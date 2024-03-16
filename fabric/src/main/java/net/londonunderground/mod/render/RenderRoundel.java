package net.londonunderground.mod.render;

import net.londonunderground.mod.Init;
import net.londonunderground.mod.blocks.BlockRoundelBase;
import org.mtr.core.data.Station;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockEntityRenderer;
import org.mtr.mapping.mapper.GraphicsHolder;
import org.mtr.mapping.mapper.TextHelper;
import org.mtr.mod.InitClient;
import org.mtr.mod.block.IBlock;
import org.mtr.mod.client.Config;
import org.mtr.mod.client.IDrawing;
import org.mtr.mod.data.IGui;
import org.mtr.mod.render.RenderTrains;
import org.mtr.mod.render.StoredMatrixTransformations;

import javax.annotation.Nonnull;
import java.util.Locale;

public class RenderRoundel<T extends BlockRoundelBase.TileEntityBlockRoundelBase> extends BlockEntityRenderer<T> implements IGui, IDrawing {

	private final float maxWidth;
	private final float maxScale;
	private final float xOffset;
	private final float yOffset;
	private final float zOffset;
	private final float xTilt;
	private final int textColor;
	private final boolean isDoubleSided;
	private final String font;

	public RenderRoundel(Argument dispatcher, float maxWidth, float maxScale, float xOffset, float yOffset, float zOffset, float xTilt, int textColor, boolean isDoubleSided, String font) {
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
	public void render(@Nonnull T entity, float tickDelta, @Nonnull GraphicsHolder graphicsHolder, int light, int overlay) {
		final Style style;
		if (Config.useMTRFont()) {
			style = Style.getEmptyMapped().withFont(new Identifier(Init.MOD_ID, font));
		} else {
			style = Style.getEmptyMapped();
		}


		if (!entity.shouldRender()) {
			return;
		}

		final World world = entity.getWorld2();
		if (world == null) {
			return;
		}

		final BlockPos pos = entity.getPos2();
		final BlockState state = world.getBlockState(pos);
		final Direction facing = IBlock.getStatePropertySafe(state, BlockRoundelBase.FACING);

		final Station station = InitClient.findStation(pos);
		final MutableText roundelText = TextHelper.setStyle(TextHelper.literal(IGui.textOrUntitled(IGui.formatStationName(station == null ? "" : station.getName())).toUpperCase(Locale.ROOT)), style);
		final int textWidth = GraphicsHolder.getTextWidth(roundelText);

		final StoredMatrixTransformations storedMatrixTransformations = new StoredMatrixTransformations(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
		storedMatrixTransformations.add(graphicsHolderNew -> {
			graphicsHolderNew.rotateYDegrees(-facing.asRotation());
			graphicsHolderNew.rotateZDegrees(180);
		});
		RenderTrains.scheduleRender(RenderTrains.QueuedRenderLayer.TEXT, (graphicsHolderNew, offset) -> {
			storedMatrixTransformations.transform(graphicsHolderNew, offset);
			render(graphicsHolderNew, roundelText, textWidth, light);
			if (isDoubleSided) {
				graphicsHolderNew.rotateYDegrees(180);
				render(graphicsHolderNew, roundelText, textWidth, light);
			}
			graphicsHolderNew.pop();
		});
	}

	private void render(GraphicsHolder graphicsHolder, MutableText roundelText, int textWidth, int light) {
		graphicsHolder.push();
		graphicsHolder.rotateXDegrees(xTilt);
		graphicsHolder.translate(-xOffset, -yOffset, -zOffset - SMALL_OFFSET * 2);

		final float scale = Math.min((maxWidth) / textWidth, maxScale);
		graphicsHolder.scale(scale, scale, scale);
		graphicsHolder.translate(0, -3.5, 0);
		graphicsHolder.drawText(roundelText, -textWidth / 2, 0, textColor, false, light);

		graphicsHolder.pop();
	}
}
