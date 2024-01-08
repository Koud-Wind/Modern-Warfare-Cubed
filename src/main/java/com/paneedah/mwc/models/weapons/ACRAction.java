package com.paneedah.mwc.models.weapons;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.9.2
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


public class ACRAction extends ModelBase {
	private final ModelRenderer action;
	private final ModelRenderer ACR140_r1_r1;

	public ACRAction() {
		textureWidth = 400;
		textureHeight = 400;

		action = new ModelRenderer(this);
		action.setRotationPoint(-1.1443F, -16.189F, -28.8415F);
		action.cubeList.add(new ModelBox(action, 45, 197, 1.0109F, -1.3792F, -7.1585F, 2, 1, 1, -0.1F, false));
		action.cubeList.add(new ModelBox(action, 45, 197, 2.5109F, -1.3792F, -7.1585F, 1, 1, 1, -0.1F, false));
		action.cubeList.add(new ModelBox(action, 45, 197, 1.0109F, -1.3792F, -6.6585F, 2, 1, 1, -0.1F, false));

		ACR140_r1_r1 = new ModelRenderer(this);
		ACR140_r1_r1.setRotationPoint(2.5109F, -0.8792F, -6.1585F);
		action.addChild(ACR140_r1_r1);
		setRotationAngle(ACR140_r1_r1, 0.0F, -0.7854F, 0.0F);
		ACR140_r1_r1.cubeList.add(new ModelBox(ACR140_r1_r1, 45, 197, -0.2F, -0.5F, -0.8F, 1, 1, 1, -0.17F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		action.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}