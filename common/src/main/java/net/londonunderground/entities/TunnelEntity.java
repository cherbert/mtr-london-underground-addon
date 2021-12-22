package net.londonunderground.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mtr.mappings.ModelDataWrapper;
import mtr.mappings.ModelMapper;
import net.minecraft.client.model.EntityModel;
import net.minecraft.world.entity.Entity;

public class TunnelEntity extends EntityModel<Entity> {

	private final ModelMapper bb_main;

	public TunnelEntity() {
		final int textureWidth = 16;
		final int textureHeight = 16;
		final ModelDataWrapper modelDataWrapper = new ModelDataWrapper(this, textureWidth, textureHeight);
		bb_main = new ModelMapper(modelDataWrapper);
		bb_main.setPos(0, 24, 0);
		bb_main.texOffs(0, 0).addBox(0, -24, 0, 16, 16, 16, 0, false);
		modelDataWrapper.setModelPart(textureWidth, textureHeight);
		bb_main.setModelPart();
	}

	@Override
	public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {
	}

	@Override
	public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrixStack, buffer, 0, 0, 0, packedLight, packedOverlay);
	}
}