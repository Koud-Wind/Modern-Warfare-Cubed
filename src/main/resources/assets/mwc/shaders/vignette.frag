#version 120

uniform sampler2D reticle;
uniform sampler2D tex0;
uniform sampler2D dirt;
uniform sampler2D holo;
uniform sampler2D depthTex;
uniform mat4 projection;


uniform float Radius;
uniform float reticleZoom = 1.0;


uniform vec3 ConvergeX = vec3(-1.0,  0.0, 0.5);
uniform vec3 ConvergeY = vec3( 0.0, -1.0, 0.5);
uniform vec3 RadialConvergeX = vec3(1.0, 1.0, 1.0);
uniform vec3 RadialConvergeY = vec3(1.0, 1.0, 1.0);
uniform vec2 Velocity;


uniform float texScale = 0.05;
uniform float radius = 0.1;
uniform float time;
uniform float fogIntensity;
uniform vec3 baseFogColor;
uniform bool shouldDoFog;
uniform bool isNightVisionOn;
uniform bool useWhitePhosphor;

const float PI = 3.14;
const vec2 SCREEN_CENTER = vec2(0.5, 0.5);
const vec3 NV_LUMINOSITY_VEC = vec3(0.30, 0.59, 0.11);
const vec3 SCOPE_TINT_MULTIPLIER = vec3(0.8, 0.8, 0.9);
const float NIGHTVISION_NOISE_AMP = 4.0;
const float NV_INTENSITY_ADJUST = 20.0;
const float NV_CONTRAST = 0.8;
const float SOFTNESS = 0.1;


varying vec4 posi;
varying vec3 normal;
varying vec3 tangent;
varying vec2 texCoord;
varying vec2 oneTexel;

/*
 * Radial Split Effect - taken from MC's shaders.
 */
vec4 radialSplit(float deconvergent) {
    vec3 CoordX = texCoord.x * RadialConvergeX;
    vec3 CoordY = texCoord.y * RadialConvergeY;

    CoordX += ConvergeX * deconvergent - (RadialConvergeX - 1.0) * 0.5;
    CoordY += ConvergeY * deconvergent - (RadialConvergeY - 1.0) * 0.5;

    float RedValue = texture2D(tex0, vec2(CoordX.x, CoordY.x)).r;
    float GreenValue = texture2D(tex0, vec2(CoordX.y, CoordY.y)).g;
    float BlueValue = texture2D(tex0, vec2(CoordX.z, CoordY.z)).b;
    float AlphaValue = texture2D(tex0, texCoord).a;

    return vec4(RedValue, GreenValue, BlueValue, 1.0);
}

vec4 radialSplit(vec2 tc, float deconvergent) {

    // Modification in order to increase the intensity
    // based on the distance from the center.
    deconvergent *= length(tc - SCREEN_CENTER) * 5;

    vec3 CoordX = tc.x * RadialConvergeX;
    vec3 CoordY = tc.y * RadialConvergeY;

    CoordX += ConvergeX * deconvergent - (RadialConvergeX - 1.0) * 0.5;
    CoordY += ConvergeY * deconvergent - (RadialConvergeY - 1.0) * 0.5;

    float red   = texture2D(tex0, vec2(CoordX.x, CoordY.x)).r;
    float green = texture2D(tex0, vec2(CoordX.y, CoordY.y)).g;
    float blue  = texture2D(tex0, vec2(CoordX.z, CoordY.z)).b;

    return vec4(red, green, blue, 1.0);
}

/*
 * Smooth step distance from texCoord to a point in space
 */
float getDistSmooth(vec2 center, float rad, float soft) {
    float dist = distance(texCoord.xy, center);
    return smoothstep(rad, rad - soft, dist);
}

/*
 * Code for creating a parallax effect, from the reflex.frag shader.
 *
 * Article: https://vazgriz.com/158/reflex-sight-shader-in-unity3d/
 */
vec2 getReticleCoords() {
    vec3 cameraDir = normalize(posi.xyz);
    vec3 offset = cameraDir + normal;
    mat3 mat = mat3(tangent, cross(normal, tangent), normal);
    offset = mat * offset;
    vec2 uv = offset.yx / texScale;
    return uv;
}

/*
 * Get single sample of noise.
 * (float) timer - continously changing float that acts as a random seed
 *
 * Source - https://stackoverflow.com/questions/4200224/random-noise-functions-for-glsl
 */
float getNSingle(float timer) {
    return (fract(sin(dot(texCoord, vec2(12.9898, 78.233) * (2.0 + timer))) * 43758.5453));
}

/*
 * Gets a 3D noise vector by taking 3 single samples
 */
vec2 getNoise(float timer) {
    return vec2(getNSingle(timer), getNSingle(timer));
}

float linearize_depth(float d, float zNear, float zFar) {
    return zNear * zFar / (zFar + d * (zNear - zFar));
}

/*
 *  Applies a night vision effect to the fragment
 *
 *  Updated code of Victor Matskiv Sr.
 */
vec4 doNightVision(vec4 color) {
    // Apply noise to night-vision
    vec2 uv;
    uv.x = 0.35 * sin(time * 10);
    uv.y = 0.35 * cos(time * 10);
    vec2 noise = getNoise(time) * NIGHTVISION_NOISE_AMP;
    color.xy += noise.xy * 0.005;

    // Find color intensity
    float intensity = dot(NV_LUMINOSITY_VEC, color.rgb);
    intensity = clamp(NV_CONTRAST * (intensity - 0.5) + 0.5, 0.0, 1.0);
    float colorComponent = clamp(intensity / 0.59, 0.0, 1.0) * NV_INTENSITY_ADJUST;

    // Modify the color
    vec4 visionColor;
    if (useWhitePhosphor) {
        visionColor = vec4(colorComponent * 0.7, colorComponent * 0.7, colorComponent, 1.0);
    } else {
        visionColor = vec4(colorComponent * 0.7, colorComponent, colorComponent * 0.7, 1.0);
    }

    // Mix base color and use visionColor as a filter (?)
    float gray = dot(color.rgb, vec3(0.299, 0.587, 0.114));
    vec4 grayColor = vec4(gray, gray, gray, 1.0);
    color = grayColor * visionColor;

    return color;
}

/*
 * Simple fog from Inigo Quilez's phenomenal blog
 * [https://iquilezles.org/articles/fog/]
 */
vec4 applyFog(vec4 color, vec2 tex_coord) {
    float linearizedDepth = linearize_depth(texture2D(depthTex, tex_coord).r, 0.0025, 100);
    float fogAmount = 1.0 - exp(-linearizedDepth * fogIntensity);
    vec4 fogColor = vec4(baseFogColor, 1.0);
    return mix(color, fogColor, fogAmount);
}

void main() {
    // Our boilerplate color
    vec4 newColor = vec4(0);

    // Get reticle coordinates
    vec2 uv = getReticleCoords();

    // calculate the distorted texture coordinates
    vec2 realTex = texCoord - SCREEN_CENTER;
    vec2 distortedTex = cos(min((length(realTex) / (1.5)), 1.0) * PI * 0.5) * realTex + SCREEN_CENTER;
    vec4 grime = texture2D(dirt, texCoord);

    vec4 original = texture2D(tex0, distortedTex);
    float borderRGB = getDistSmooth((uv * vec2(1.1, 1.0)) + SCREEN_CENTER, 10.0, 4);

    newColor = mix(original, radialSplit(0.001), 1 - borderRGB);

    // Mix in the reticle
    vec2 distortedTexBorder = cos(min((length(realTex) / 0.9), 1.0) * PI * 0.5) * uv;
    vec4 newReticleColor = texture2D(reticle, (distortedTexBorder + (Velocity * 0.2)) * 0.05 * reticleZoom + SCREEN_CENTER);

    vec2 centeredTexCoords = texCoord - SCREEN_CENTER;
    vec2 distortedTexCoords = cos(min((length(centeredTexCoords) * 0.6), 1.0) * PI * 0.5) * centeredTexCoords + SCREEN_CENTER;

    // Use a radial split w/ the distorted coordinates
    newColor = radialSplit(distortedTexCoords, 0.001);
    if (shouldDoFog)
        newColor = applyFog(newColor, distortedTexCoords);

    // Mixed crosshairs
    newColor = mix(newColor, newReticleColor, newReticleColor.a);

    // Apply night vision
    if (isNightVisionOn) newColor = doNightVision(newColor);

    float border = distance(texCoord.xy, (uv * vec2(1.1, 1.0)) + SCREEN_CENTER);
    if (border > 9) newColor.rgb = vec3(0);

    // Add a grime texture on top
    newColor += grime * (1 - length(newColor)) / 2;

    // Some color changes from the lens
    newColor.rgb *= SCOPE_TINT_MULTIPLIER;

    newColor.b *= 0.9;
    newColor.rg *= 0.8;

    // add scope shadow
    float rad = 0.5;
    float dist = distance(texCoord.xy, vec2(0.5 + Velocity.x, 0.5 + Velocity.y));
    float vignette = smoothstep(rad, rad - SOFTNESS, dist);

    newColor *= vignette;

    // overlay the scope radius
    float scopeRad = 0.46;
    dist = distance(texCoord.xy, SCREEN_CENTER);
    float mask = smoothstep(scopeRad, scopeRad - SOFTNESS, dist);
    if (mask == 0)
        newColor.a = 0;
    else
        newColor.a = 1;

    gl_FragColor = newColor;
}