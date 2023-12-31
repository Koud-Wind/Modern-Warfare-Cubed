package com.paneedah.mwc.items.guns;

import com.paneedah.mwc.MWC;
import com.paneedah.mwc.models.weapons.*;
import com.paneedah.mwc.proxies.CommonProxy;
import com.paneedah.mwc.weapons.Attachments;
import com.paneedah.mwc.weapons.AuxiliaryAttachments;
import com.paneedah.mwc.weapons.Magazines;
import com.paneedah.weaponlib.*;
import com.paneedah.mwc.rendering.Transform;
import com.paneedah.weaponlib.compatibility.RecoilParam;
import com.paneedah.weaponlib.config.BalancePackManager.GunConfigurationGroup;
import net.minecraft.item.Item;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class M60E4Factory {

    public Item createGun(CommonProxy commonProxy) {
        return new Weapon.Builder()
                .withName("m60e4")
                .withFireRate(0.4f)
                .withRecoil(4f)
                .withZoom(0.9f)
                .withConfigGroup(GunConfigurationGroup.MACHINE_GUN)
                .withMuzzlePosition(new Vec3d(-.1, -1, -8))
                .withMaxShots(Integer.MAX_VALUE)
                .withShootSound("m60")
                .withSilencedShootSound("ak15_silenced")
                .withReloadSound("m60_reload")
                .withUnloadSound("m60_unload")
                .withInspectSound("inspection")
                .withDrawSound("mg42_draw")
                .withReloadingTime(45)
                .withFlashIntensity(0.5f)
                .withFlashScale(() -> 0.6f)
                .withFlashOffsetX(() -> 0.1f)
                .withFlashOffsetY(() -> 0.16f)
                .withInaccuracy(1f)
                .withCreativeTab(MWC.WEAPONS_TAB)
                .useNewSystem()
                .withRecoilParam(new RecoilParam(
                        30.0,
                        15.75,
                        50.0,
                        0.4,
                        0.3125,
                        -0.0425,
                        -0.0325,
                        1.8
                ))

                .withUnremovableAttachmentCategories(AttachmentCategory.GUARD)

                .withCompatibleAttachment(AuxiliaryAttachments.M60Action, true, (model) -> {
                })
                .withCompatibleAttachment(Attachments.M60HandGuard, true, (model) -> {
                })
                .withCompatibleAttachment(Attachments.M60E4HandGuard, (model) -> {
                    if (model instanceof AKRail) {
                        GL11.glTranslatef(0.295F, -1.28F, -4.2F);
                        GL11.glScaled(0.6F, 0.6F, 0.7F);
                        GL11.glRotatef(90F, 0f, 0f, 1f);
                    } else if (model instanceof AKRail2) {
                        GL11.glTranslatef(-0.35F, -1.1F, -4.2F);
                        GL11.glScaled(0.6F, 0.6F, 0.7F);
                        GL11.glRotatef(-90F, 0f, 0f, 1f);
                    } else if (model instanceof AKRail3) {
                        GL11.glTranslatef(0.12F, -0.44F, -4.85F);
                        GL11.glScaled(0.6F, 0.6F, 1.05F);
                        GL11.glRotatef(180F, 0f, 0f, 1f);
                    }
                })
                .withCompatibleAttachment(Attachments.M60FrontSight, true, (model) -> {
                })
                .withCompatibleAttachment(Attachments.M60Rail, (model) -> {
                    GL11.glTranslatef(-0.155f, -1.87f, -1.43f);
                    GL11.glScaled(0.78F, 0.83F, 0.6F);
                })
                .withCompatibleAttachment(AuxiliaryAttachments.M60Hatch, true, (model) -> {
                })
                .withCompatibleAttachment(AuxiliaryAttachments.M60Belt, renderContext -> {
                    PlayerWeaponInstance instance = renderContext.getWeaponInstance();
                    if (instance != null) {
                        ItemAttachment<Weapon> activeAttachment = WeaponAttachmentAspect.getActiveAttachment(AttachmentCategory.MAGAZINE, instance);
                        if (activeAttachment == null) {
                            GL11.glScaled(0F, 0F, 0F);
                        }
                    }
                }, (model) -> {
                }, true, false)
                .withCompatibleAttachment(Magazines.M60Mag, (model) -> {
                })
                .withCompatibleAttachment(AuxiliaryAttachments.Extra, true, (model) -> {
                    if (model instanceof AKMiron1) {
                        GL11.glTranslatef(0.125F, -1.8F, -0.5F);
                        GL11.glScaled(0F, 0F, 0F);
                    } else if (model instanceof AKMiron2) {
                        GL11.glTranslatef(-0.183F, -1.32F, -5F);
                        GL11.glScaled(0F, 0F, 0F);
                    } else if (model instanceof AK47iron) {
                        GL11.glTranslatef(-0.25F, -1.65F, -3.05F);
                        GL11.glScaled(0F, 0F, 0F);
                    } else if (model instanceof M4Iron1) {
                        GL11.glTranslatef(0.155F, -1.74F, 1F);
                        GL11.glScaled(0F, 0F, 0F);
                    } else if (model instanceof M4Iron2) {
                        GL11.glTranslatef(0.26F, -1.55F, -2.35F);
                        GL11.glScaled(0F, 0F, 0F);
                    } else if (model instanceof P90iron) {
                        GL11.glTranslatef(0.26F, -1.55F, -2.35F);
                        GL11.glScaled(0F, 0F, 0F);
                    } else if (model instanceof G36CIron1) {
                        GL11.glTranslatef(-0.22F, -1.94F, 0.13F);
                        GL11.glScaled(0F, 0F, 0F);
                    } else if (model instanceof G36CIron2) {
                        GL11.glTranslatef(-0.205F, -1.9F, -3.15F);
                        GL11.glScaled(0F, 0F, 0F);
                    } else if (model instanceof ScarIron1) {
                        GL11.glTranslatef(0.165F, -1.65F, 1F);
                        GL11.glScaled(0F, 0F, 0F);
                    } else if (model instanceof ScarIron2) {
                        GL11.glTranslatef(0.25F, -1.55F, -2F);
                        GL11.glScaled(0F, 0F, 0F);
                    } else if (model instanceof FALIron) {
                        GL11.glTranslatef(-0.019F, -1.935F, -6.55F);
                        GL11.glScaled(0.15F, 0.3F, 0.8F);
                        GL11.glRotatef(-180F, 0f, 0f, 1f);
                    } else if (model instanceof M14Iron) {
                        GL11.glTranslatef(0.129F, -1.63F, -2.08F);
                        GL11.glScaled(0F, 0F, 0F);
                    } else if (model instanceof MP5Iron) {
                        GL11.glTranslatef(0.215F, -1.54F, 1.2F);
                        GL11.glScaled(0F, 0F, 0F);
                    }
                })
                .withCompatibleAttachment(Attachments.NightRaider, () -> {
                    GL11.glTranslatef(-0.13F, -1.95F, -1.71F);
                    GL11.glScaled(0.75F, 0.75F, 0.75F);
                }, (model) -> {
                    if (model instanceof JPUreticle) {
                        GL11.glTranslatef(0.12F, -0.2F, 2.49F);
                        GL11.glScaled(0.03F, 0.03F, 0.03F);
                    }
                })
                .withCompatibleAttachment(Attachments.ACOG, () -> {
                    GL11.glTranslatef(-0.24F, -1.95F, -0.455F);
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
                .withCompatibleAttachment(Attachments.Specter, () -> {
                    GL11.glTranslatef(-0.1F, -1.65F, -0.755F);
                    GL11.glScaled(0.43F, 0.43F, 0.43F);
                }, (model) -> {
                    if (model instanceof Acog2) {
                        GL11.glTranslatef(0.15F, -1.035F, 1.513F);
                        GL11.glScaled(0.1F, 0.1F, 0.1F);
                    }
                })
                .withCompatibleAttachment(Attachments.Reflex, () -> {
                    GL11.glTranslatef(0.02F, -1.75F, -0.63F);
                    GL11.glScaled(0.45F, 0.45F, 0.45F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(-0.125F, -0.7F, -0.4F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.MicroReflex, () -> {
                    GL11.glTranslatef(-0.07F, -2.49F, -0.63F);
                    GL11.glScaled(0.35F, 0.35F, 0.35F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(0.08F, 0.97F, -0.4F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.BijiaReflex, () -> {
                    GL11.glTranslatef(0.02F, -1.75F, -0.83F);
                    GL11.glScaled(0.5F, 0.5F, 0.5F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(-0.125F, -0.68F, -0.4F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.Holographic, () -> {
                    GL11.glTranslatef(0.03F, -1.8F, -0.67F);
                    GL11.glScaled(0.65F, 0.65F, 0.65F);
                }, (model) -> {
                    if (model instanceof Holo2) {
                        GL11.glTranslatef(-0.125F, -0.5F, -0.1F);
                        GL11.glScaled(0.1F, 0.1F, 0.1F);
                    }
                })
                .withCompatibleAttachment(Attachments.HolographicAlt, () -> {
                    GL11.glTranslatef(0.03F, -1.8F, -0.67F);
                    GL11.glScaled(0.65F, 0.65F, 0.65F);
                }, (model) -> {
                    if (model instanceof Holo2) {
                        GL11.glTranslatef(-0.125F, -0.5F, -0.1F);
                        GL11.glScaled(0.1F, 0.1F, 0.1F);
                    }
                })
                .withCompatibleAttachment(Attachments.EotechHybrid2, () -> {
                    GL11.glTranslatef(0.03F, -1.8F, -0.67F);
                    GL11.glScaled(0.65F, 0.65F, 0.65F);
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
                .withCompatibleAttachment(Attachments.VortexRedux, () -> {
                    GL11.glTranslatef(-0.215F, -2.0F, -0.93F);
                    GL11.glScaled(0.45F, 0.45F, 0.45F);
                }, (model) -> {
                    if (model instanceof Holo2) {
                        GL11.glTranslatef(0.395F, -0.33F, -0.1F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.Kobra, () -> {
                    GL11.glTranslatef(0.04f, -1.8f, -0.57f);
                    GL11.glScaled(0.65F, 0.65F, 0.65F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(-0.125F, -0.45F, -0.85F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.KobraGen3, () -> {
                    GL11.glTranslatef(0.04f, -1.8f, -0.57f);
                    GL11.glScaled(0.65F, 0.65F, 0.65F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(-0.125F, -0.45F, -0.85F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.MicroT1, () -> {
                    GL11.glTranslatef(-0.1F, -2.0F, -0.6F);
                    GL11.glScaled(0.38F, 0.38F, 0.38F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(0.155F, -0.4F, -0.5F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.AimpointCompM5, () -> {
                    GL11.glTranslatef(-0.1F, -2.0F, -0.6F);
                    GL11.glScaled(0.38F, 0.38F, 0.38F);
                }, (model) -> {
                    if (model instanceof Reflex2) {
                        GL11.glTranslatef(0.155F, -0.4F, -0.5F);
                        GL11.glScaled(0.15F, 0.15F, 0.15F);
                    }
                })
                .withCompatibleAttachment(Attachments.Grip2, (model) -> {
                    GL11.glTranslatef(-0.1F, -0.01F, -3.8F);
                    GL11.glScaled(1F, 1F, 1F);
                })
                .withCompatibleAttachment(Attachments.StubbyGrip, (model) -> {
                    GL11.glTranslatef(-0.1F, -0.01F, -3.8F);
                    GL11.glScaled(1F, 1F, 1F);
                })
                .withCompatibleAttachment(Attachments.AngledGrip, (model) -> {
                    GL11.glTranslatef(-0.1F, 0.11F, -3.8F);
                    GL11.glScaled(1F, 1F, 1F);
                })
                .withCompatibleAttachment(Attachments.VGrip, (model) -> {
                    GL11.glTranslatef(-0.1F, -0.01F, -3.8F);
                    GL11.glScaled(1F, 1F, 1F);
                })
                .withCompatibleAttachment(Attachments.Grip2Tan, (model) -> {
                    GL11.glTranslatef(-0.1F, -0.01F, -3.8F);
                    GL11.glScaled(1F, 1F, 1F);
                })
                .withCompatibleAttachment(Attachments.StubbyGripTan, (model) -> {
                    GL11.glTranslatef(-0.1F, -0.01F, -3.8F);
                    GL11.glScaled(1F, 1F, 1F);
                })
                .withCompatibleAttachment(Attachments.AngledGripTan, (model) -> {
                    GL11.glTranslatef(-0.1F, 0.11F, -3.8F);
                    GL11.glScaled(1F, 1F, 1F);
                })
                .withCompatibleAttachment(Attachments.VGripTan, (model) -> {
                    GL11.glTranslatef(-0.1F, -0.01F, -3.8F);
                    GL11.glScaled(1F, 1F, 1F);
                })
                .withCompatibleAttachment(Attachments.Bipod, (model) -> {
                    GL11.glTranslatef(-0.1F, 0.11F, -3.8F);
                    GL11.glScaled(1F, 1F, 1F);
                })
                .withCompatibleAttachment(Attachments.Laser2, () -> {
                    GL11.glTranslatef(0.125F, -1.38F, -3.86F);
                    GL11.glScaled(0.8F, 0.8F, 0.8F);
                })
                .withCompatibleAttachment(Attachments.Laser, () -> {
                    GL11.glTranslatef(0.125F, -1.38F, -3.86F);
                    GL11.glScaled(0.8F, 0.8F, 0.8F);
                })
                .withTextureNames("m60")
                .withRenderer(new WeaponRenderer.Builder()
                        .withModel(new M60())
                        .withEntityPositioning(itemStack -> {
                            GL11.glScaled(0.35F, 0.35F, 0.35F);
                            GL11.glTranslatef(0, 0f, 3f);
                            GL11.glRotatef(0F, 0f, 0f, 4f);
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
                                        .withPosition(-1.825000f, 5.665000f, -5.605000f)
                                        .withRotation(0.000000f, 1.000000f, 6.300000f)
                                        .withPivotPoint(-0.350000f, -2.900000f, -0.100000f)
                                        .withScale(3.0F, 3.0F, 3.0F)
                        )

                        .withFirstPersonHandPositioning(


                                new Transform()
                                        .withPosition(1.730000f, 0.865000f, -1.146400f)
                                        .withBBRotation(-15.4928F, -45.7685F, 66.3639F)
                                        .withScale(2.6F, 2.6F, 4.0F)
                                        .withPivotPoint(0, 0, 0),


                                new Transform()
                                        .withPosition(-0.2F, 0.1F, 2)
                                        .withRotation(-5.4027F, -4.7805F, -1.6694F)
                                        .withScale(3.5F, 3.5F, 3.5F)
                                        .withPivotPoint(0, 0, 0)

                        )

                        .setupModernAnimations("m249", AuxiliaryAttachments.M60Action)
                        .setupCustomKeyedPart(AuxiliaryAttachments.M60Belt, "m249", "belt")
                        .setupCustomKeyedPart(AuxiliaryAttachments.M60Hatch, "m249", "hatch")
                        .setupCustomKeyedPart(Attachments.ACOG, "m249", "scope")
                        .setupCustomKeyedPart(Attachments.Specter, "m249", "scope")
                        .setupCustomKeyedPart(Attachments.Reflex, "m249", "scope")
                        .setupCustomKeyedPart(Attachments.NightRaider, "m249", "scope")
                        .setupCustomKeyedPart(Attachments.BijiaReflex, "m249", "scope")
                        .setupCustomKeyedPart(Attachments.Holographic, "m249", "scope")
                        .setupCustomKeyedPart(Attachments.HolographicAlt, "m249", "scope")
                        .setupCustomKeyedPart(Attachments.EotechHybrid2, "m249", "scope")
                        .setupCustomKeyedPart(Attachments.MicroReflex, "m249", "scope")
                        .setupCustomKeyedPart(Attachments.MicroT1, "m249", "scope")
                        .setupCustomKeyedPart(Attachments.AimpointCompM5, "m249", "scope")
                        .setupCustomKeyedPart(Attachments.VortexRedux, "m249", "scope")
                        .setupCustomKeyedPart(Attachments.Kobra, "m249", "scope")
                        .setupCustomKeyedPart(Attachments.KobraGen3, "m249", "scope")
                        .setupCustomKeyedPart(Attachments.M60Rail, "m249", "scope")
                        .setupModernMagazineAnimations("m249",
                                Magazines.M60Mag)

                        .withFirstPersonCustomPositioning(AuxiliaryAttachments.M60Belt.getRenderablePart(), (renderContext) -> {
                            //if (renderContext.getWeaponInstance().getAmmo() == 0) {
                            //    GL11.glTranslatef(-0.5F, 0.4F, 0F);
                            //}
                        })

                        .withFirstPersonPositioningZooming((renderContext) -> {
                            GL11.glTranslatef(0.1F, 0.51F, 0.53F);

                            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.NightRaider)) {
                                GL11.glTranslatef(-0.003F, 0.04f, 0.15f);
                            }


                            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                                GL11.glTranslatef(-0.002F, 0.068f, 0.2f);
                            }


                            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.MicroT1)) {
                                GL11.glTranslatef(0.002F, 0.065f, -0.1f);
                            }


                            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.AimpointCompM5)) {
                                GL11.glTranslatef(0.002F, 0.065f, -0.1f);
                            }


                            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
                                GL11.glTranslatef(-0.01F, -0.005f, 0.3f);
                            }


                            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                                GL11.glTranslatef(0F, -0.015f, -0.3f);
                            }


                            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.MicroReflex)) {
                                GL11.glTranslatef(0.001F, 0.05f, -0.1f);
                            }


                            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.BijiaReflex)) {
                                GL11.glTranslatef(0.002F, 0.01f, -0.1f);
                            }


                            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic)) {
                                GL11.glTranslatef(0.005F, 0.025f, -0.15f);
                            }


                            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HolographicAlt)) {
                                GL11.glTranslatef(0.005F, 0.025f, -0.15f);
                            }


                            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.EotechHybrid2)) {
                                GL11.glTranslatef(0.009F, 0.04f, -0.35f);
                            }


                            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.VortexRedux)) {
                                GL11.glTranslatef(-0.005F, 0.07f, -0.2f);
                            }


                            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                                GL11.glTranslatef(-0.002F, 0.045f, -0.3f);
                            }


                            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.KobraGen3)) {
                                GL11.glTranslatef(-0.002F, 0.045f, -0.3f);
                            }
                        })

                        .withFirstPersonPositioningModifying((renderContext) -> {
                            new Transform()
                                    .withPosition(-1.905000f, 4.065000f, -3.645000f)
                                    .withRotation(0.000000f, -30.514396f, -26.062789f)
                                    .withPivotPoint(-0.350000f, -2.900000f, -0.100000f)
                                    .withScale(2.000000f, 2.000000f, 2.000000f)
                                    .applyTransformations();
                        })

                        .withFirstPersonPositioningModifyingAlt((renderContext) -> {
                            new Transform()
                                    .withPosition(-1.425000f, 3.545000f, -5.685000f)
                                    .withRotation(-0.187566f, -46.164037f, -11.869230f)
                                    .withPivotPoint(-0.350000f, -2.900000f, -0.100000f)
                                    .withScale(2.000000f, 2.000000f, 2.000000f)
                                    .applyTransformations();
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
                .withSpawnEntityDamage(8f)
                .withSpawnEntityGravityVelocity(0.0118f)

                .build(MWC.modContext);
    }
}