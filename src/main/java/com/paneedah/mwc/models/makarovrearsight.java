// Date: 9/30/2017 12:26:24 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.paneedah.mwc.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class makarovrearsight extends ModelBase
{
  //fields
    ModelRenderer sight1;
    ModelRenderer sight2;
    ModelRenderer sight3;
    ModelRenderer sight4;
    ModelRenderer sight5;
    ModelRenderer sight6;
    ModelRenderer sigh8;
    ModelRenderer sight9;
    ModelRenderer sight10;
    ModelRenderer sight11;
    ModelRenderer sight12;
    ModelRenderer sight13;
    ModelRenderer sight14;
    ModelRenderer sight15;
    ModelRenderer sight16;
  
  public makarovrearsight()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      sight1 = new ModelRenderer(this, 0, 0);
      sight1.addBox(0F, 0F, 0F, 2, 2, 2);
      sight1.setRotationPoint(-1.7F, -1.8F, -1F);
      sight1.setTextureSize(64, 32);
      sight1.mirror = true;
      setRotation(sight1, 0F, 0F, 0F);
      sight2 = new ModelRenderer(this, 0, 0);
      sight2.addBox(0F, 0F, 0F, 1, 5, 2);
      sight2.setRotationPoint(-2F, -1.8F, -1F);
      sight2.setTextureSize(64, 32);
      sight2.mirror = true;
      setRotation(sight2, 0F, 0F, 0F);
      sight3 = new ModelRenderer(this, 0, 0);
      sight3.addBox(0F, 0F, 0F, 2, 2, 2);
      sight3.setRotationPoint(2.7F, -1.8F, -1F);
      sight3.setTextureSize(64, 32);
      sight3.mirror = true;
      setRotation(sight3, 0F, 0F, 0F);
      sight4 = new ModelRenderer(this, 0, 0);
      sight4.addBox(0F, 0F, 0F, 1, 5, 2);
      sight4.setRotationPoint(4F, -1.8F, -1F);
      sight4.setTextureSize(64, 32);
      sight4.mirror = true;
      setRotation(sight4, 0F, 0F, 0F);
      sight5 = new ModelRenderer(this, 0, 0);
      sight5.addBox(0F, 0F, 0F, 3, 3, 2);
      sight5.setRotationPoint(1.7F, -0.2F, -1F);
      sight5.setTextureSize(64, 32);
      sight5.mirror = true;
      setRotation(sight5, 0F, 0F, 0F);
      sight6 = new ModelRenderer(this, 0, 0);
      sight6.addBox(0F, 0F, 0F, 4, 3, 2);
      sight6.setRotationPoint(-1.7F, -0.2F, -1F);
      sight6.setTextureSize(64, 32);
      sight6.mirror = true;
      setRotation(sight6, 0F, 0F, 0F);
      sigh8 = new ModelRenderer(this, 0, 0);
      sigh8.addBox(0F, 0F, 0F, 1, 4, 2);
      sigh8.setRotationPoint(5F, -0.8F, -1F);
      sigh8.setTextureSize(64, 32);
      sigh8.mirror = true;
      setRotation(sigh8, 0F, 0F, 0F);
      sight9 = new ModelRenderer(this, 0, 0);
      sight9.addBox(0F, 0F, 0F, 1, 4, 2);
      sight9.setRotationPoint(-3F, -0.8F, -1F);
      sight9.setTextureSize(64, 32);
      sight9.mirror = true;
      setRotation(sight9, 0F, 0F, 0F);
      sight10 = new ModelRenderer(this, 0, 0);
      sight10.addBox(0F, 0F, 0F, 1, 1, 2);
      sight10.setRotationPoint(5F, -1.8F, -1F);
      sight10.setTextureSize(64, 32);
      sight10.mirror = true;
      setRotation(sight10, 0F, 0F, 0.7853982F);
      sight11 = new ModelRenderer(this, 0, 0);
      sight11.addBox(0F, 0F, 0F, 1, 1, 2);
      sight11.setRotationPoint(-2F, -1.8F, -1F);
      sight11.setTextureSize(64, 32);
      sight11.mirror = true;
      setRotation(sight11, 0F, 0F, 0.7853982F);
      sight12 = new ModelRenderer(this, 0, 0);
      sight12.addBox(0F, 0F, 0F, 1, 1, 2);
      sight12.setRotationPoint(6F, -0.8F, -1F);
      sight12.setTextureSize(64, 32);
      sight12.mirror = true;
      setRotation(sight12, 0F, 0F, 2.356194F);
      sight13 = new ModelRenderer(this, 0, 0);
      sight13.addBox(0F, 0F, 0F, 1, 1, 2);
      sight13.setRotationPoint(-3F, -0.8F, -1F);
      sight13.setTextureSize(64, 32);
      sight13.mirror = true;
      setRotation(sight13, 0F, 0F, -0.7853982F);
      sight14 = new ModelRenderer(this, 0, 0);
      sight14.addBox(0F, 0F, 0F, 9, 1, 7);
      sight14.setRotationPoint(-3F, 2.2F, -3.5F);
      sight14.setTextureSize(64, 32);
      sight14.mirror = true;
      setRotation(sight14, 0F, 0F, 0F);
      sight15 = new ModelRenderer(this, 0, 0);
      sight15.addBox(0F, 0F, 0F, 9, 2, 3);
      sight15.setRotationPoint(-3F, 2.2F, -3.5F);
      sight15.setTextureSize(64, 32);
      sight15.mirror = true;
      setRotation(sight15, 0.5576792F, 0F, 0F);
      sight16 = new ModelRenderer(this, 0, 0);
      sight16.addBox(0F, 0F, 0F, 9, 3, 2);
      sight16.setRotationPoint(-3F, 2.2F, 3.5F);
      sight16.setTextureSize(64, 32);
      sight16.mirror = true;
      setRotation(sight16, -2.119181F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    sight1.render(f5);
    sight2.render(f5);
    sight3.render(f5);
    sight4.render(f5);
    sight5.render(f5);
    sight6.render(f5);
    sigh8.render(f5);
    sight9.render(f5);
    sight10.render(f5);
    sight11.render(f5);
    sight12.render(f5);
    sight13.render(f5);
    sight14.render(f5);
    sight15.render(f5);
    sight16.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

}
