package net.londonunderground.entities;

import minecraftmappings.ModelDataWrapper;
import minecraftmappings.ModelMapper;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class TunnelEntity extends EntityModel<Entity> {

	private final ModelMapper bb_main;

	public TunnelEntity() {
			final int textureWidth = 16;
			final int textureHeight = 16;
			final ModelDataWrapper modelDataWrapper = new ModelDataWrapper(this, textureWidth, textureHeight);
			bb_main = new ModelMapper(modelDataWrapper);
			bb_main.setPivot(0.0F, 24.0F, 0.0F);
			bb_main.setTextureOffset(0, 0).addCuboid(0.0F, -24.0F, 0.0F, 16, 16, 16, 0.0F, false);
			modelDataWrapper.setModelPart(textureWidth, textureHeight);
			bb_main.setModelPart();
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
			//previously the render function, render code was moved to a method below
	}
	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

			bb_main.render(matrixStack, buffer, 0, 0, 0, packedLight, packedOverlay);
	}
	public void setRotationAngle(ModelPart bone, float x, float y, float z) {
			bone.pitch = x;
			bone.yaw = y;
			bone.roll = z;
	}

}