package net.londonunderground.mod.render;

import org.mtr.mapping.holder.Direction;
import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mapping.mapper.GraphicsHolder;
import org.mtr.mod.client.IDrawing;
import org.mtr.mod.data.IGui;
import org.mtr.mod.render.RenderSignalBase;

import javax.annotation.Nonnull;

public class RenderTunnelSignalLight<T extends BlockEntityExtension> extends RenderSignalBase<T> implements IGui {

	private final boolean redOnTop;
	private final int proceedColor;

	public RenderTunnelSignalLight(Argument dispatcher, boolean isSingleSided, boolean redOnTop, int proceedColor) {
		super(dispatcher, isSingleSided, 2);
		this.redOnTop = redOnTop;
		this.proceedColor = proceedColor;
	}

	@Override
	protected void render(@Nonnull GraphicsHolder graphicsHolder, @Nonnull T entity, float tickDelta, @Nonnull Direction facing, int occupiedAspect, boolean isBackSide) {
		final float y = occupiedAspect > 0 == redOnTop ? 0.25F : 0.4375F;
		IDrawing.drawTexture(graphicsHolder, -0.25F, y, 0.3125F, -0.0625F, y + 0.1875F, 0.3125F, facing.rotateYClockwise(), occupiedAspect > 0 ? 0xFFFF0000 : proceedColor, GraphicsHolder.getDefaultLight());

	}
}
