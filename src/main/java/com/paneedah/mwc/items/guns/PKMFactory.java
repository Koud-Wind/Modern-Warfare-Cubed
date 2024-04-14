package com.paneedah.mwc.items.guns;

import com.paneedah.mwc.MWC;
import com.paneedah.mwc.models.weapons.*;
import com.paneedah.mwc.proxies.CommonProxy;
import com.paneedah.mwc.weapons.Attachments;
import com.paneedah.mwc.weapons.AuxiliaryAttachments;
import com.paneedah.mwc.weapons.Magazines;
import com.paneedah.weaponlib.*;
import com.paneedah.weaponlib.animation.Transform;
import com.paneedah.weaponlib.compatibility.RecoilParam;
import com.paneedah.weaponlib.config.BalancePackManager.GunConfigurationGroup;
import net.minecraft.item.Item;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class PKMFactory {

    public Item createGun(CommonProxy commonProxy) {
        return new Weapon.Builder()
                .withName("pkm")
                .withFireRate(0.6f)
                .withRecoil(4.5f)
                .withZoom(0.9f)
                .withConfigGroup(GunConfigurationGroup.MACHINE_GUN)
                .withMuzzlePosition(new Vec3d(-.15, -1.15, -8.7))
                .withMaxShots(Integer.MAX_VALUE)
                .withShootSound("m60")
                .withSilencedShootSound("ak15_silenced")
                .withReloadSound("mg42_reload")
                .withUnloadSound("mg42_unload")
                .withInspectSound("inspection")
                .withDrawSound("mg42_draw")
                .withReloadingTime(45)
                .withFlashIntensity(0.5f)
                .withFlashScale(() -> 0.6f)
                .withFlashOffsetX(() -> 0.1f)
                .withFlashOffsetY(() -> 0.16f)
                .withShellCasingVerticalOffset(-0.05f)
                .withShellCasingForwardOffset(-0.2f)
                .withShellCasingEjectEnabled(false)
                .withInaccuracy(1f)
                .hasFlashPedals()
                .useNewSystem()
                .withRecoilParam(new RecoilParam(
                        25.0,
                        15.75,
                        50.0,
                        0,
                        0,
                        0,
                        0.05,
                        1.8
                ))

                .withUnremovableAttachmentCategories(AttachmentCategory.BACKGRIP)
                .withUnremovableAttachmentCategories(AttachmentCategory.RECEIVER)
                .withUnremovableAttachmentCategories(AttachmentCategory.STOCK)
                .withCompatibleAttachment(AuxiliaryAttachments.PKMAction, true, (model) -> {
                })
                .withCompatibleAttachment(AuxiliaryAttachments.PKMHatch, true, (model) -> {
                    if (model instanceof PKMrearsight) {
                        GL11.glTranslatef(-0.0F, -2.44F, -1.2F);
                        GL11.glScaled(0.5F, 0.5F, 0.5F);
                    }
                })
                .withCompatibleAttachment(AuxiliaryAttachments.PKMBelt, true, (model) -> {
                })
                .withCompatibleAttachment(AuxiliaryAttachments.PKMBelt2, true, (model) -> {
                })
                .withCompatibleAttachment(Attachments.PKMBarrel, true, (model) -> {
                    if (model instanceof PKMfrontsight) {
                        GL11.glTranslatef(-0.0F, -1.93F, -8.2F);
                        GL11.glScaled(0.5F, 0.5F, 0.5F);
                    }
                })
                .withCompatibleAttachment(Attachments.PechenegBarrel, (model) -> {
                    if (model instanceof PKMfrontsight) {
                        GL11.glTranslatef(-0.0F, -1.93F, -8.2F);
                        GL11.glScaled(0.5F, 0.5F, 0.5F);
                    }
                })
                .withCompatibleAttachment(Attachments.PechenegBipod, (model) -> {
                })
                .withCompatibleAttachment(Attachments.PKMGrip, true, (model) -> {
                })
                .withCompatibleAttachment(Attachments.RK3PGrip, (model) -> {
                })
                .withCompatibleAttachment(Attachments.PKMStock, true, (model) -> {
                })
                .withCompatibleAttachment(Attachments.PT2Stock, (model) -> {
                })
                .withCompatibleAttachment(Attachments.B51ScopeMountRail, (player, itemStack) -> {
                    GL11.glTranslatef(0.025F, 0.01F, -0.03F);
                    GL11.glScaled(1F, 1F, 1F);
                }, (model) -> {
                    if (model instanceof AKRail) {
                        GL11.glTranslatef(-0.23F, -1.95F, -2.6f);
                        GL11.glScaled(0.7F, 0.6F, 0.9F);
                    }
                })
                .withCompatibleAttachment(Attachments.B50PKMHandguard, (player, itemStack) -> {
                    GL11.glTranslatef(-0.02F, 0.07F, 0F);
                    GL11.glScaled(1F, 1F, 1F);
                }, (model) -> {
                    GL11.glTranslatef(-0.25F, -1.64F, -4.1F);
                    GL11.glScaled(0.45F, 0.45F, 0.45F);
                })
                .withCompatibleAttachment(Attachments.B50PKPHandguard, (player, itemStack) -> {
                    GL11.glTranslatef(-0.02F, 0.07F, 0F);
                    GL11.glScaled(1F, 1F, 1F);
                }, (model) -> {
                    GL11.glTranslatef(-0.25F, -1.64F, -4.1F);
                    GL11.glScaled(0.45F, 0.45F, 0.45F);
                })
                .withCompatibleAttachment(Magazines.PKMMag, (model) -> {
                })

                .withCompatibleAttachment(Attachments.NightRaider, (player, itemStack) -> {
                    GL11.glTranslatef(-0.22F, -2.05F, -2.65F);
                    GL11.glScaled(0.9F, 0.9F, 0.9F);
                }, (model) -> {
                    if (model instanceof JPUreticle) {
                        GL11.glTranslatef(0.12F, -0.2F, 2.49F);
                        GL11.glScaled(0.03F, 0.03F, 0.03F);
                    }
                })
                .withCompatibleAttachment(Attachments.ACOG, (player, itemStack) -> {
                    GL11.glTranslatef(-0.328F, -2.07F, -1.15F);
                    GL11.glScaled(0.9F, 0.9F, 0.9F);
                }, (model) -> {
                    if (model instanceof AcogScope2) {
                        GL11.glTranslatef(-0.018F, -0.25F, 0.13F);
                        GL11.glScaled(0.5F, 0.5F, 0.5F);
                    } else if (model instanceof AcogReticle) {
                        GL11.glTranslatef(0.243F, -0.23F, 0.68f);
                        GL11.glScaled(0.03F, 0.03F, 0.03F);
                    }
                })
                .withCompatibleAttachment(Attachments.Specter, (player, itemStack) -> {
                    GL11.glTranslatef(-0.19F, -1.69F, -1.25F);
                    GL11.glScaled(0.5F, 0.5F, 0.5F);
                }, (model) -> {
                    if (model instanceof Acog2) {
                        GL11.glTranslatef(0.15F, -1.035F, 1.513F);
                        GL11.glScaled(0.1F, 0.1F, 0.1F);
                    }
                })
                .withCompatibleAttachment(Attachments.MicroReflex, (player, itemStack) -> {
                    GL11.glTranslatef(-0.145F, -2.62F, -1.15F);
                    GL11.glScaled(0.38F, 0.38F, 0.38F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(0.08F, 0.97F, -0.4F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.Reflex, (player, itemStack) -> {
                    GL11.glTranslatef(-0.045F, -1.82F, -1.65F);
                    GL11.glScaled(0.55F, 0.55F, 0.55F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(-0.125F, -0.7F, -0.4F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.BijiaReflex, (player, itemStack) -> {
                    GL11.glTranslatef(-0.04F, -1.79F, -1.75F);
                    GL11.glScaled(0.63F, 0.63F, 0.63F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(-0.125F, -0.68F, -0.4F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.Holographic, (player, itemStack) -> {
                    GL11.glTranslatef(-0.015F, -1.87F, -1.65F);
                    GL11.glScaled(0.8F, 0.8F, 0.8F);
                }, (model) -> {
                    if (model instanceof Holo2) {
                        GL11.glTranslatef(-0.125F, -0.5F, -0.1F);
                        GL11.glScaled(0.1F, 0.1F, 0.1F);
                    }
                })
                .withCompatibleAttachment(Attachments.HolographicAlt, (player, itemStack) -> {
                    GL11.glTranslatef(-0.015F, -1.87F, -1.65F);
                    GL11.glScaled(0.8F, 0.8F, 0.8F);
                }, (model) -> {
                    if (model instanceof Holo2) {
                        GL11.glTranslatef(-0.125F, -0.5F, -0.1F);
                        GL11.glScaled(0.1F, 0.1F, 0.1F);
                    }
                })
                .withCompatibleAttachment(Attachments.EotechHybrid2, (player, itemStack) -> {
                    GL11.glTranslatef(-0.015F, -1.87F, -1.95F);
                    GL11.glScaled(0.8F, 0.8F, 0.8F);
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
                    GL11.glTranslatef(-0.315F, -2.08F, -1.65F);
                    GL11.glScaled(0.5F, 0.5F, 0.5F);
                }, (model) -> {
                    if (model instanceof Holo2) {
                        GL11.glTranslatef(0.395F, -0.33F, -0.1F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.Kobra, (player, itemStack) -> {
                    GL11.glTranslatef(-0.025F, -1.89F, -1.15F);
                    GL11.glScaled(0.75F, 0.75F, 0.75F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(-0.125F, -0.45F, -0.85F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.KobraGen3, (player, itemStack) -> {
                    GL11.glTranslatef(-0.025F, -1.89F, -1.15F);
                    GL11.glScaled(0.75F, 0.75F, 0.75F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(-0.125F, -0.45F, -0.85F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.MicroT1, (player, itemStack) -> {
                    GL11.glTranslatef(-0.186F, -2.07F, -1.15F);
                    GL11.glScaled(0.45F, 0.45F, 0.45F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(0.155F, -0.4F, -0.5F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.AimpointCompM5, (player, itemStack) -> {
                    GL11.glTranslatef(-0.186F, -2.07F, -1.15F);
                    GL11.glScaled(0.45F, 0.45F, 0.45F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(0.155F, -0.4F, -0.5F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.Silencer762x54, (model) -> {
                    GL11.glTranslatef(-0.2F, -1.37F, -10.8F);
                    GL11.glScaled(1.5F, 1.5F, 1.5F);
                })
                .withCompatibleAttachment(Attachments.Grip2, (model) -> {
                    GL11.glTranslatef(-0.1F, -0.1F, -4.5F);
                    GL11.glScaled(1.1F, 1.1F, 1.1F);
                    GL11.glRotatef(0F, -45f, 0f, 0f);
                })
                .withCompatibleAttachment(Attachments.StubbyGrip, (model) -> {
                    GL11.glTranslatef(-0.1F, -0.1F, -4.5F);
                    GL11.glScaled(1.1F, 1.1F, 1.1F);
                    GL11.glRotatef(0F, -45f, 0f, 0f);
                })
                .withCompatibleAttachment(Attachments.VGrip, (model) -> {
                    GL11.glTranslatef(-0.1F, -0.1F, -4.5F);
                    GL11.glScaled(1.1F, 1.1F, 1.1F);
                    GL11.glRotatef(0F, -45f, 0f, 0f);
                })
                .withCompatibleAttachment(Attachments.Laser2, renderContext -> {
                    PlayerWeaponInstance instance = renderContext.getWeaponInstance();
                    if (instance != null) {
                        ItemAttachment<Weapon> activeAttachment = WeaponAttachmentAspect.getActiveAttachment(
                                AttachmentCategory.GUARD, instance);
                        if (activeAttachment == Attachments.B50PKMHandguard) {
                            GL11.glTranslatef(-0.2F, -1.3F, -4.8F);
                            GL11.glScaled(1.0F, 1.0F, 1.0F);
                            GL11.glRotatef(-90F, 0f, 0f, 1f);
                        } else {
                            GL11.glTranslatef(-0.2F, -1.6F, -4.8F);
                            GL11.glScaled(1.0F, 1.0F, 1.0F);
                            GL11.glRotatef(-90F, 0f, 0f, 1f);
                        }
                    }
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(0F, 0F, 0F);
                        GL11.glScaled(0F, 0F, 0F);
                    }
                }, false, false)

                .withTextureNames("pkm")
                .withRenderer(new WeaponRenderer.Builder()
                        .withModel(new PKM())
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
                            GL11.glScaled(0.45F, 0.45F, 0.45F);
                            GL11.glTranslatef(-1.7F, -0.8F, 1.9F);
                            GL11.glRotatef(-45F, 0f, 1f, 0f);
                            GL11.glRotatef(70F, 1f, 0f, 0f);
                        })

                        .withFirstPersonPositioning(
                                new Transform()
                                        .withPosition(-1.825000f, 5.665000f, -5.005000f)
                                        .withRotation(0.000000f, -0.500000f, 0.500000f)
                                        .withRotationPoint(-0.350000f, -2.900000f, -0.100000f)
                                        .withScale(3.5F, 3.5F, 3.5F)
                        )

                        .withFirstPersonHandPositioning(


                                new Transform()
                                        .withPosition(1.68f, 0.665f, -0.9464f)
                                        .withBBRotation(-15.4928F, -45.7685F, 66.3639F)
                                        .withScale(2.6F, 2.6F, 4.0F)
                                        .withRotationPoint(0, 0, 0),


                                new Transform()
                                        .withPosition(-0.05F, -0.2F, 1.8F)
                                        .withRotation(5.4027F, 4.7805F, -1.6694F)
                                        .withScale(3.0F, 3.0F, 3.0F)
                                        .withRotationPoint(0, 0, 0)

                        )

                        .setupModernAnimations("pkm", AuxiliaryAttachments.PKMAction)
                        .setupCustomKeyedPart(AuxiliaryAttachments.PKMBelt, "pkm", "belt")
                        .setupCustomKeyedPart(AuxiliaryAttachments.PKMBelt2, "pkm", "belt")
                        .setupCustomKeyedPart(AuxiliaryAttachments.PKMHatch, "pkm", "hatch")
                        .setupCustomKeyedPart(Attachments.B51ScopeMountRail, "pkm", "hatch")
                        .setupModernMagazineAnimations("pkm",
                                Magazines.PKMMag)

                        .withFirstPersonCustomPositioning(AuxiliaryAttachments.PKMBelt2.getRenderablePart(), (renderContext) -> {
                            if (renderContext.getWeaponInstance().getAmmo() == 0) {
                                GL11.glTranslatef(-0.5F, 3.0F, 5F);
                                GL11.glScaled(0F, 0F, 0F);
                            }
                        })
                        .withFirstPersonCustomPositioning(AuxiliaryAttachments.PKMBelt.getRenderablePart(), (renderContext) -> {
                            if (renderContext.getWeaponInstance().getAmmo() == 0) {
                                GL11.glTranslatef(-0.5F, 3.0F, 5F);
                                GL11.glScaled(0F, 0F, 0F);
                            }
                        })


                        .withFirstPersonPositioningZooming((renderContext) -> {
                            ItemAttachment<Weapon> activeAttachment = WeaponAttachmentAspect.getActiveAttachment(AttachmentCategory.RAILING, renderContext.getWeaponInstance());
                            if (activeAttachment == Attachments.B51ScopeMountRail)
                                GL11.glTranslatef(0.167F, 0.525F, 0.5F);
                            else
                                GL11.glTranslatef(0.161F, 0.125F, 0.9F);


                            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.NightRaider))
                                GL11.glTranslatef(0.002f, 0.165f, 0.65f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG))
                                GL11.glTranslatef(0.001f, 0.193f, 0.8f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter))
                                GL11.glTranslatef(0f, 0.095f, 0.65f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.MicroReflex))
                                GL11.glTranslatef(0.005f, 0.14f, 0.2f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex))
                                GL11.glTranslatef(0.003f, 0.12f, 0.3f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.BijiaReflex))
                                GL11.glTranslatef(0.005f, 0.12f, 0.3f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic))
                                GL11.glTranslatef(-0.003f, 0.15f, 0.4f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HolographicAlt))
                                GL11.glTranslatef(-0.003f, 0.15f, 0.4f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.EotechHybrid2))
                                GL11.glTranslatef(0.005f, 0.175f, 0.6f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.VortexRedux))
                                GL11.glTranslatef(0.005f, 0.15f, 0.3f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra))
                                GL11.glTranslatef(0f, 0.16f, 0f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.KobraGen3))
                                GL11.glTranslatef(0f, 0.16f, 0f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.MicroT1))
                                GL11.glTranslatef(0.007f, 0.155f, 0.3f);
                            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.AimpointCompM5))
                                GL11.glTranslatef(0.007f, 0.155f, 0.3f);
                        })

                        .withFirstPersonPositioningModifying((renderContext) -> {
                            new Transform()
                                    .withPosition(-1.905000f, 4.065000f, -3.645000f)
                                    .withRotation(0.000000f, -30.514396f, -26.062789f)
                                    .withRotationPoint(-0.350000f, -2.900000f, -0.100000f)
                                    .withScale(2.500000f, 2.500000f, 2.500000f)
                                    .doGLDirect();
                        })

                        .withFirstPersonPositioningModifyingAlt((renderContext) -> {
                            new Transform()
                                    .withPosition(-1.425000f, 3.545000f, -5.685000f)
                                    .withRotation(-0.187566f, -46.164037f, -11.869230f)
                                    .withRotationPoint(-0.350000f, -2.900000f, -0.100000f)
                                    .withScale(2.500000f, 2.500000f, 2.500000f)
                                    .doGLDirect();
                        })
                        .withFirstPersonHandPositioningModifying(
                                (renderContext) -> {
                                    GL11.glScalef(4f, 4f, 4f);
                                    GL11.glRotatef(-85.000000f, 1f, 0f, 0f);
                                    GL11.glRotatef(-55.000000f, 0f, 1f, 0f);
                                    GL11.glRotatef(30.000000f, 0f, 0f, 1f);
                                    GL11.glTranslatef(0.100000f, -1.100000f, 0.275000f);
                                },
                                (renderContext) -> {
                                    GL11.glScalef(4f, 4f, 4f);
                                    GL11.glRotatef(-90.000000f, 1f, 0f, 0f);
                                    GL11.glRotatef(0.000000f, 0f, 1f, 0f);
                                    GL11.glRotatef(-45.000000f, 0f, 0f, 1f);
                                    GL11.glTranslatef(0.790000f, -1.435000f, 0.710000f);
                                })

                        .withFirstPersonHandPositioningModifyingAlt(
                                (renderContext) -> {
                                    GL11.glScalef(4f, 4f, 4f);
                                    GL11.glRotatef(-85.000000f, 1f, 0f, 0f);
                                    GL11.glRotatef(-55.000000f, 0f, 1f, 0f);
                                    GL11.glRotatef(30.000000f, 0f, 0f, 1f);
                                    GL11.glTranslatef(0.100000f, -1.100000f, 0.275000f);
                                },
                                (renderContext) -> {
                                    GL11.glScalef(4f, 4f, 4f);
                                    GL11.glRotatef(-90.000000f, 1f, 0f, 0f);
                                    GL11.glRotatef(0.000000f, 0f, 1f, 0f);
                                    GL11.glRotatef(-45.000000f, 0f, 0f, 1f);
                                    GL11.glTranslatef(0.790000f, -1.435000f, 0.710000f);
                                })


                        .build())
                .withSpawnEntityDamage(10f)
                .withSpawnEntityGravityVelocity(0.0118f)

                .build(MWC.modContext);
    }
}