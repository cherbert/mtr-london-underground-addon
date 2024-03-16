package net.londonunderground.mod.render;

import net.londonunderground.mod.blocks.BlockRoundelBase;
import org.mtr.mapping.mapper.BlockEntityRenderer;
import org.mtr.mapping.mapper.GraphicsHolder;

import javax.annotation.Nonnull;

public class RenderNameProjector<T extends BlockRoundelBase.TileEntityBlockRoundelBase> extends BlockEntityRenderer<T> {

	public RenderNameProjector(Argument dispatcher) {
		super(dispatcher);
	}

	@Override
	public void render(@Nonnull T entity, float tickDelta, @Nonnull GraphicsHolder graphicsHolder, int textWidth, int light) {
		// TODO
	}
}
