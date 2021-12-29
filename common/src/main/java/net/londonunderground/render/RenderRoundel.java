package net.londonunderground.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.math.Vector3f;
import mtr.block.IBlock;
import mtr.config.Config;
import mtr.data.IGui;
import mtr.data.RailwayData;
import mtr.data.Station;
import mtr.gui.ClientData;
import mtr.gui.IDrawing;
import mtr.mappings.BlockEntityRendererMapper;
import net.londonunderground.Main;
import net.londonunderground.blocks.BlockRoundelBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextComponent;
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
	private static String font;

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

		final Station station = RailwayData.getStation(ClientData.STATIONS, pos);
		final FormattedCharSequence roundelText = new TextComponent(IGui.textOrUntitled(IGui.formatStationName(station == null ? "" : station.name)).toUpperCase(Locale.ROOT)).setStyle(STYLE).getVisualOrderText();
		final int textWidth = Minecraft.getInstance().font.width(roundelText);

		matrices.pushPose();
		matrices.translate(0.5, 0.5, 0.5);
		matrices.mulPose(Vector3f.YP.rotationDegrees(-facing.toYRot()));
		matrices.mulPose(Vector3f.ZP.rotationDegrees(180));
		final MultiBufferSource.BufferSource immediate = MultiBufferSource.immediate(Tesselator.getInstance().getBuilder());
		render(matrices, immediate, roundelText, textWidth, color, light);
		if (isDoubleSided) {
			matrices.mulPose(Vector3f.YP.rotationDegrees(180));
			render(matrices, immediate, roundelText, textWidth, color, light);
		}
		immediate.endBatch();
		matrices.popPose();
	}

	private void render(PoseStack matrices, MultiBufferSource.BufferSource immediate, FormattedCharSequence roundelText, int textWidth, int color, int light) {
		matrices.pushPose();
		matrices.mulPose(Vector3f.XP.rotationDegrees(xTilt));
		matrices.translate(-xOffset, -yOffset, -zOffset - SMALL_OFFSET * 2);

		final float scale = Math.min(maxWidth / textWidth, maxScale);
		matrices.scale(scale, scale, scale);
		matrices.translate(0, -4, 0);
		Minecraft.getInstance().font.drawInBatch(roundelText, -textWidth / 2F, 0, textColor, false, matrices.last().pose(), immediate, false, 0, 190);

		matrices.popPose();
	}
}
