package net.londonunderground.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mtr.mappings.BlockEntityRendererMapper;
import mtr.mappings.Utilities;
import net.londonunderground.MyBlocks;
import net.londonunderground.blocks.TunnelDarknessBlock;
import net.londonunderground.entities.TunnelEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public class RenderDarkTile<T extends TunnelDarknessBlock.TileEntityTunnelDarkness> extends BlockEntityRendererMapper<T> {

	public static final TunnelEntity tunnel_entity = new TunnelEntity();

	public RenderDarkTile(BlockEntityRenderDispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public void render(T entity, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
		final Player player = Minecraft.getInstance().player;
		if (player == null) {
			return;
		}
		if (!Utilities.isHolding(player, item -> item == MyBlocks.TUNNEL_DARKNESS.asItem())) {
			if (entity.getBlockPos().distSqr(player.blockPosition()) < 64) {
				return;
			}
		}

		matrices.pushPose();
		matrices.translate(0, 1.5, 0);
		final VertexConsumer vertexConsumer = vertexConsumers.getBuffer(tunnel_entity.renderType(new ResourceLocation("londonunderground:textures/block/tunnel_darkness.png")));
		tunnel_entity.renderToBuffer(matrices, vertexConsumer, light, overlay, 1, 1, 1, 50);
		matrices.popPose();
	}

	@Override
	public boolean shouldRenderOffScreen(T blockEntity) {
		return true;
	}
}
