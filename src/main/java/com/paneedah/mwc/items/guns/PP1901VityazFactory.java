package com.paneedah.mwc.items.guns;

import com.paneedah.mwc.MWC;
import com.paneedah.mwc.models.weapons.*;
import com.paneedah.mwc.proxies.CommonProxy;
import com.paneedah.mwc.weapons.*;
import com.paneedah.weaponlib.*;
import com.paneedah.weaponlib.animation.Transform;
import com.paneedah.weaponlib.compatibility.RecoilParam;
import com.paneedah.weaponlib.config.BalancePackManager.GunConfigurationGroup;
import com.paneedah.weaponlib.render.shells.ShellParticleSimulator.Shell.Type;
import net.minecraft.item.Item;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class PP1901VityazFactory {

    public Item createGun(CommonProxy commonProxy) {
        return new Weapon.Builder()
                .withName("pp19vityaz")
                .withFireRate(0.7f)
                .withRecoil(2f)
                .withZoom(0.9f)
                .withMuzzlePosition(new Vec3d(-0.1, -0.9, -4.7))
                .withConfigGroup(GunConfigurationGroup.SUBMACHINE_GUN)
                .withShellType(Type.PISTOL)
                .hasFlashPedals()
                .withMaxShots(1, Integer.MAX_VALUE)
                .withShootSound("kbp_9a91")
                .withSilencedShootSound("kbp9a91_silenced")
                .withDrawSound("ak_draw")
                .withReloadingTime(45)
                .withFlashIntensity(0.5f)
                .withFlashScale(() -> 0.6f)
                .withFlashOffsetX(() -> 0.1f)
                .withFlashOffsetY(() -> 0.15f)
                .withInaccuracy(1f)
                .withCreativeTab(MWC.WEAPONS_TAB)
                .useNewSystem()
                .withRecoilParam(new RecoilParam(
                        15.0,
                        15.75,
                        50.0,
                        0.4,
                        0.3125,
                        0.0,
                        0.0,
                        1.0
                ))

                .withScreenShaking(RenderableState.SHOOTING,
                        2f,
                        0.1f,
                        3f)

                .withUnremovableAttachmentCategories(AttachmentCategory.GUARD)
                .withUnremovableAttachmentCategories(AttachmentCategory.BACKGRIP)
                .withUnremovableAttachmentCategories(AttachmentCategory.STOCK)

                .withCompatibleAttachment(AuxiliaryAttachments.PP1901Action, true, (model) -> {
                })
                .withCompatibleAttachment(Attachments.PP1901HandGuard, true, (model) -> {
                })
                .withCompatibleAttachment(Attachments.PP1901HandGuardB10, (model) -> {
                })
                .withCompatibleAttachment(Attachments.PP1901HandGuardMagpul, (model) -> {
                })
                .withCompatibleAttachment(Magazines.PP1901Mag, (model) -> {
                })
                .withCompatibleAttachment(Attachments.PP1901Grip, true, (model) -> {
                })
                .withCompatibleAttachment(Attachments.RK9Grip, (model) -> {
                })
                .withCompatibleAttachment(Attachments.AKSStock, true, (model) -> {
                })
                .withCompatibleAttachment(Attachments.RailMountB22, (model) -> {
                    GL11.glTranslatef(0.02F, 0F, 0F);
                })

                .withCompatibleAttachment(Attachments.ACOG, (player, itemStack) -> {
                    GL11.glTranslatef(-0.285F, -1.62F, -1.8F);
                    GL11.glScaled(0.83F, 0.83F, 0.83F);
                }, (model) -> {
                    if (model instanceof AcogScope2) {
                        GL11.glTranslatef(-0.018F, -0.25F, 0.13F);
                        GL11.glScaled(0.5F, 0.5F, 0.5F);
                    } else if (model instanceof AcogReticle) {
                        GL11.glTranslatef(0.243F, -0.23F, 0.68f);
                        GL11.glScaled(0.03F, 0.03F, 0.03F);
                    }
                })

                .withCompatibleAttachment(Attachments.MicroReflex, (player, itemStack) -> {
                    GL11.glTranslatef(-0.13F, -2.31F, -2.4F);
                    GL11.glScaled(0.45F, 0.45F, 0.45F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(0.08F, 0.97F, -0.4F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })

                .withCompatibleAttachment(Attachments.MicroT1, (player, itemStack) -> {
                    GL11.glTranslatef(-0.15F, -1.63F, -2.2F);
                    GL11.glScaled(0.43F, 0.43F, 0.43F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(0.155F, -0.4F, -0.5F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.AimpointCompM5, (player, itemStack) -> {
                    GL11.glTranslatef(-0.15F, -1.63F, -2.2F);
                    GL11.glScaled(0.43F, 0.43F, 0.43F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(0.155F, -0.4F, -0.5F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.Reflex, (player, itemStack) -> {
                    GL11.glTranslatef(-0.022F, -1.4F, -2.7F);
                    GL11.glScaled(0.6F, 0.6F, 0.6F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(-0.125F, -0.7F, -0.4F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.BijiaReflex, (player, itemStack) -> {
                    GL11.glTranslatef(-0.02F, -1.38F, -2.7F);
                    GL11.glScaled(0.6F, 0.6F, 0.6F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(-0.125F, -0.68F, -0.4F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.Holographic, (player, itemStack) -> {
                    GL11.glTranslatef(0F, -1.47F, -2.4F);
                    GL11.glScaled(0.73F, 0.73F, 0.73F);
                }, (model) -> {
                    if (model instanceof Holo2) {
                        GL11.glTranslatef(-0.125F, -0.5F, -0.1F);
                        GL11.glScaled(0.1F, 0.1F, 0.1F);
                    }
                })
                .withCompatibleAttachment(Attachments.HolographicAlt, (player, itemStack) -> {
                    GL11.glTranslatef(0F, -1.47F, -2.4F);
                    GL11.glScaled(0.73F, 0.73F, 0.73F);
                }, (model) -> {
                    if (model instanceof Holo2) {
                        GL11.glTranslatef(-0.125F, -0.5F, -0.1F);
                        GL11.glScaled(0.1F, 0.1F, 0.1F);
                    }
                })

                .withCompatibleAttachment(Attachments.EotechHybrid2, (player, itemStack) -> {
                    GL11.glTranslatef(-0.005F, -1.45F, -2.8F);
                    GL11.glScaled(0.73F, 0.73F, 0.73F);
                }, (model) -> {
                    if (model instanceof EotechScopeRing) {
                        GL11.glTranslatef(-0.2F, -0.41F, 1.8F);
                        GL11.glScaled(0.5F, 0.5F, 0.5F);
                    }
                    if (model instanceof Holo2) {
                        GL11.glTranslatef(-0.118F, -0.535F, 1.9F);
                        GL11.glScaled(0.05F, 0.05F, 0.05F);
                    }
                })

                .withCompatibleAttachment(Attachments.VortexRedux, (player, itemStack) -> {
                    GL11.glTranslatef(-0.295F, -1.66F, -2.8F);
                    GL11.glScaled(0.52F, 0.52F, 0.52F);
                }, (model) -> {
                    if (model instanceof Holo2) {
                        GL11.glTranslatef(0.395F, -0.33F, -0.1F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.Kobra, (player, itemStack) -> {
                    GL11.glTranslatef(-0.005F, -1.46F, -2.2F);
                    GL11.glScaled(0.7F, 0.7F, 0.7F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(-0.125F, -0.45F, -0.85F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.KobraGen3, (player, itemStack) -> {
                    GL11.glTranslatef(-0.005F, -1.46F, -2.2F);
                    GL11.glScaled(0.7F, 0.7F, 0.7F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(-0.125F, -0.45F, -0.85F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })

                .withCompatibleAttachment(Attachments.KobraMount, (player, itemStack) -> {
                    GL11.glTranslatef(-0.035F, -1.23F, -0.85F);
                    GL11.glScaled(0.7F, 0.7F, 0.7F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(-0.125F, -0.45F, -0.85F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.OKP7, (player, itemStack) -> {
                    GL11.glTranslatef(-0.18F, -0.65F, -1.1F);
                    GL11.glScaled(0.7F, 0.7F, 0.7F);
                }, (model) -> {
                    if (model instanceof OKP7reticle) {
                        GL11.glTranslatef(0.17F, -1.15F, -0.6F);
                        GL11.glScaled(0.1F, 0.1F, 0.1F);
                    }
                })
                .withCompatibleAttachment(Attachments.Grip2, (model) -> {
                    GL11.glTranslatef(-0.18F, -0.23F, -3.3F);
                })
                .withCompatibleAttachment(Attachments.StubbyGrip, (model) -> {
                    GL11.glTranslatef(-0.18F, -0.23F, -3.3F);
                })
                .withCompatibleAttachment(Attachments.VGrip, (model) -> {
                    GL11.glTranslatef(-0.18F, -0.23F, -3.3F);
                })
                .withCompatibleAttachment(Attachments.Grip2Tan, (model) -> {
                    GL11.glTranslatef(-0.18F, -0.23F, -3.3F);
                })
                .withCompatibleAttachment(Attachments.StubbyGripTan, (model) -> {
                    GL11.glTranslatef(-0.18F, -0.23F, -3.3F);
                })
                .withCompatibleAttachment(Attachments.VGripTan, (model) -> {
                    GL11.glTranslatef(-0.18F, -0.23F, -3.3F);
                })
                .withCompatibleAttachment(Attachments.Laser, (player, itemStack) -> {
                    GL11.glTranslatef(-0.25F, -0.78F, -3.3F);
                    GL11.glRotatef(-180F, 0f, 0f, 1f);
                    GL11.glScaled(0.8F, 0.8F, 0.8F);
                })
                .withCompatibleAttachment(Attachments.Laser2, (player, itemStack) -> {
                    GL11.glTranslatef(-0.25F, -0.78F, -3.3F);
                    GL11.glRotatef(-180F, 0f, 0f, 1f);
                    GL11.glScaled(0.8F, 0.8F, 0.8F);
                })
                .withCompatibleAttachment(Attachments.Silencer9mm, (model) -> {
                    GL11.glTranslatef(-0.2F, -1.08F, -5.8F);
                })
                .withCompatibleAttachment(Attachments.DeltaTekMPIFlashhider, (model) -> {
                })

                .withTextureNames("pp1901")
                .withRenderer(new WeaponRenderer.Builder()
                        .withModel(new PP1901())
                        .withActionPiece(AuxiliaryAttachments.PP1901Action)
                        .withActionTransform(new Transform().withPosition(0, 0, 1F))
                        .withADSBeizer(new Vec3d(0.2F, 1.7, 0.5F))

                        .withEntityPositioning(itemStack -> {
                            GL11.glScaled(0.35F, 0.35F, 0.35F);
                            GL11.glTranslatef(0, 0f, 3f);
                        })
                        .withInventoryPositioning(itemStack -> {
                            GL11.glScaled(0.28F, 0.28F, 0.28F);
                            GL11.glTranslatef(1, 2f, -1.2f);
                            GL11.glRotatef(-120F, -0.5f, 7f, 3f);
                        })
                        .withThirdPersonPositioning((renderContext) -> {
                            GL11.glScaled(0.5F, 0.5F, 0.5F);
                            GL11.glTranslatef(-1.8F, -1.1F, 2F);
                            GL11.glRotatef(-45F, 0f, 1f, 0f);
                            GL11.glRotatef(70F, 1f, 0f, 0f);
                        })

                        .withFirstPersonPositioning(
                                new Transform()
                                        .withPosition(-1.225000f, 3.705000f, -2.525000f)
                                        .withRotation(0.000000f, 1.000000f, 6.300000f)
                                        .withRotationPoint(-0.350000f, -1.300000f, -0.100000f)
                                        .withScale(3.0F, 3.0F, 3.0F)
                        )

                        .withFirstPersonHandPositioning(

                                // Left hand
                                new Transform()
                                        .withPosition(1.210000f, 0.265000f, -0.820000f)
                                        .withBBRotation(-7.1415F, -27.3003F, 52.6433F)
                                        .withScale(2.6F, 2.6F, 4.0F)
                                        .withRotationPoint(0, 0, 0),


                                // Right hand
                                new Transform()
                                        .withPosition(-0.200000f, 0.180000f, 1.960000f)
                                        .withRotation(-5.4027F, -4.7805F, -1.6694F)
                                        .withScale(3, 3, 3.5F)
                                        .withRotationPoint(0, 0, 0)

                        )

                        .setupModernAnimations("ak12", AuxiliaryAttachments.PP1901Action)
                        .setupModernMagazineAnimations("ak12",
                                Magazines.PP1901Mag)

                        .withFirstPersonPositioningZooming((renderContext) -> {
                            GL11.glTranslatef(0.154F, -0.13F, 0.8f);

                            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG))
                                GL11.glTranslatef(-0.01F, 0.375F, 1.25F);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.MicroT1))
                                GL11.glTranslatef(-0.01F, 0.355F, 1.1f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.AimpointCompM5))
                                GL11.glTranslatef(-0.001F, 0.355F, 1.1f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex))
                                GL11.glTranslatef(0F, 0.38F, 0.9F);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.BijiaReflex))
                                GL11.glTranslatef(-0.005F, 0.34f, 1.1f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.MicroReflex))
                                GL11.glTranslatef(-0.005F, 0.413f, 0.8f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic))
                                GL11.glTranslatef(-0.005F, 0.365f, 1.1f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HolographicAlt))
                                GL11.glTranslatef(-0.005F, 0.365f, 1.1f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.EotechHybrid2))
                                GL11.glTranslatef(0F, 0.375f, 1.3f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.VortexRedux))
                                GL11.glTranslatef(-0.007F, 0.39F, 1.2f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra))
                                GL11.glTranslatef(-0.008F, 0.36f, 1.1f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.KobraGen3))
                                GL11.glTranslatef(-0.008F, 0.36f, 1.1f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.KobraMount))
                                GL11.glTranslatef(0.025F, 0.135f, -0.3f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.OKP7))
                                GL11.glTranslatef(0F, 0.02F, 0F);
                            else
                                GL11.glRotatef(-1.3F, 1f, 0f, 0f);
                        })

                        .withFirstPersonPositioningModifying((renderContext) -> {
                            new Transform()
                                    .withPosition(-1.905000f, 4.065000f, -3.645000f)
                                    .withRotation(0.000000f, -30.514396f, -26.062789f)
                                    .withRotationPoint(-0.350000f, -2.900000f, -0.100000f)
                                    .withScale(3.000000f, 3.000000f, 3.000000f)
                                    .doGLDirect();
                        })
                        .withFirstPersonPositioningModifyingAlt((renderContext) -> {
                            new Transform()
                                    .withPosition(-1.425000f, 3.545000f, -5.685000f)
                                    .withRotation(-0.187566f, -46.164037f, -11.869230f)
                                    .withRotationPoint(-0.350000f, -2.900000f, -0.100000f)
                                    .withScale(3.000000f, 3.000000f, 3.000000f)
                                    .doGLDirect();
                        })

                        .withFirstPersonHandPositioningModifying(
                                (renderContext) -> {
                                    new Transform()
                                            .withPosition(1.730000f, 0.065000f, -0.980000f)
                                            .withRotation(93.414678f, 23.699100f, 15.553163f)
                                            .withScale(2.6F, 2.6F, 4.0F)
                                            .withRotationPoint(0.000000f, 0.000000f, 0.000000f)
                                            .doGLDirect();
                                },
                                (renderContext) -> {
                                    new Transform()
                                            .withPosition(-0.2F, 0.1F, 2)
                                            .withRotation(-5.4027F, -4.7805F, -1.6694F)
                                            .withScale(3.5F, 3.5F, 3.5F)
                                            .withRotationPoint(0, 0, 0)
                                            .doGLDirect();
                                })

                        .withFirstPersonHandPositioningModifyingAlt(
                                (renderContext) -> {
                                    new Transform()
                                            .withPosition(2.450000f, -0.335000f, -0.660000f)
                                            .withRotation(93.766422f, 50.841130f, 4.679372f)
                                            .withScale(2.600000f, 2.600000f, 4.000000f)
                                            .withRotationPoint(0.000000f, 0.000000f, 0.000000f)
                                            .doGLDirect();
                                },
                                (renderContext) -> {
                                    new Transform()
                                            .withPosition(-0.600000f, 0.340000f, 1.880000f)
                                            .withRotation(-12.193518f, -4.7805F, 1.399459f)
                                            .withScale(3.5F, 3.5F, 3.5F)
                                            .withRotationPoint(0.000000f, 0.000000f, 0.000000f)
                                            .doGLDirect();
                                })

                        .build())
                .withSpawnEntityDamage(5f)
                .withSpawnEntityGravityVelocity(0.0118f)

                .build(MWC.modContext);
    }
}