package net.londonunderground.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import mtr.block.IBlock;
import mtr.client.ClientData;
import mtr.client.Config;
import mtr.client.IDrawing;
import mtr.data.IGui;
import mtr.data.RailwayData;
import mtr.data.Station;
import mtr.mappings.BlockEntityRendererMapper;
import mtr.mappings.Text;
import mtr.mappings.UtilitiesClient;
import net.londonunderground.Main;
import net.londonunderground.blocks.BlockRoundelBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Locale;

public class RenderRoundel<T extends BlockRoundelBase.TileEntityBlockRoundelBase> extends BlockEntityRendererMapper<T> implements IGui, IDrawing {

	private final float maxWidth;
	private final float maxScale;
	private final float xOffset;
	private final float yOffset;
	private final float zOffset;
	private final float xTilt;
	private final int textColor;
	private final boolean isDoubleSided;
	private static Style STYLE;
	private final String font;

	public RenderRoundel(BlockEntityRenderDispatcher dispatcher, float maxWidth, float maxScale, float xOffset, float yOffset, float zOffset, float xTilt, int textColor, boolean isDoubleSided, String font) {
		super(dispatcher);
		this.maxWidth = maxWidth;
		this.maxScale = maxScale;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.zOffset = zOffset;
		this.xTilt = xTilt;
		this.textColor = textColor;
		this.isDoubleSided = isDoubleSided;
		this.font = font;
	}

	@Override
	public void render(T entity, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {

		if (Config.useMTRFont()) {
			STYLE = Style.EMPTY.withFont(new ResourceLocation(Main.MOD_ID, font));
		} else {
			STYLE = Style.EMPTY;
		}


		if (!entity.shouldRender()) {
			return;
		}

		final Level world = entity.getLevel();
		if (world == null) {
			return;
		}

		final BlockPos pos = entity.getBlockPos();
		final BlockState state = world.getBlockState(pos);
		final Direction facing = IBlock.getStatePropertySafe(state, BlockRoundelBase.FACING);

		final int color;
		switch (IBlock.getStatePropertySafe(state, BlockRoundelBase.COLOR)) {
			case 1:
				color = ARGB_LIGHT_GRAY;
				break;
			case 2:
				color = ARGB_BLACK;
				break;
			default:
				color = ARGB_WHITE;
				break;
		}

		final Station station = RailwayData.getStation(ClientData.STATIONS, ClientData.DATA_CACHE, pos);
		final FormattedCharSequence roundelText = Text.literal(IGui.textOrUntitled(IGui.formatStationName(station == null ? "" : station.name)).toUpperCase(Locale.ROOT)).setStyle(STYLE).getVisualOrderText();
		final int textWidth = Minecraft.getInstance().font.width(roundelText);

		matrices.pushPose();
		matrices.translate(0.5, 0.5, 0.5);
		UtilitiesClient.rotateYDegrees(matrices, -facing.toYRot());
		UtilitiesClient.rotateZDegrees(matrices, 180);
		final MultiBufferSource.BufferSource immediate = MultiBufferSource.immediate(Tesselator.getInstance().getBuilder());
		render(matrices, immediate, roundelText, textWidth, color, light);
		if (isDoubleSided) {
			UtilitiesClient.rotateYDegrees(matrices, 180);
			render(matrices, immediate, roundelText, textWidth, color, light);
		}
		immediate.endBatch();
		matrices.popPose();
	}

	private void render(PoseStack matrices, MultiBufferSource.BufferSource immediate, FormattedCharSequence roundelText, int textWidth, int color, int light) {
		matrices.pushPose();
		UtilitiesClient.rotateXDegrees(matrices, xTilt);
		matrices.translate(-xOffset, -yOffset, -zOffset - SMALL_OFFSET * 2);

		final float scale = Math.min((maxWidth) / textWidth, maxScale);
		matrices.scale(scale, scale, scale);
		matrices.translate(0, -3.5, 0);
		UtilitiesClient.drawInBatch(Minecraft.getInstance().font, roundelText, -textWidth / 2F, 0, textColor, false, matrices.last().pose(), immediate, 0, 190);

		matrices.popPose();
	}
}
