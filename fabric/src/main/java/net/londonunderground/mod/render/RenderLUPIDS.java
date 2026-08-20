package net.londonunderground.mod.render;

import com.lx862.jcm.mod.data.pids.preset.PIDSPresetBase;
import com.lx862.jcm.mod.render.block.PIDSRenderer;
import net.londonunderground.mod.blocks.LUPIDS;
import org.mtr.core.operation.ArrivalResponse;
import org.mtr.libraries.it.unimi.dsi.fastutil.longs.LongImmutableList;
import org.mtr.libraries.it.unimi.dsi.fastutil.objects.ObjectArrayList;
import org.mtr.mapping.holder.BlockPos;
import org.mtr.mapping.holder.BlockState;
import org.mtr.mapping.holder.Direction;
import org.mtr.mapping.holder.World;
import org.mtr.mapping.mapper.GraphicsHolder;
import org.mtr.mod.render.StoredMatrixTransformations;

/**
 * Positions the display panel on the block, then hands rendering to the preset.
 * For a script preset that means the JS render() function does the drawing, so
 * there is deliberately no drawing logic here.
 */
public class RenderLUPIDS extends PIDSRenderer<LUPIDS.TileEntityLUPIDS> {

	/**
	 * Display canvas in preset-space pixels; the script's pids.width and
	 * pids.height are exactly these numbers.
	 *
	 * Note the canvas does NOT line up with the model's lit area. Measured by
	 * drawing an outline at the canvas edges, the lit screen sits at roughly
	 * x 3..148, y 15..50 within this 150 x 60 canvas. Anything drawn outside
	 * that lands on the model rather than the display, which is why the model's
	 * casing protrudes in front of the inset Background - it occludes the
	 * overflow so the script needs no masking of its own.
	 */
	private static final int DISPLAY_WIDTH = 186;
	private static final int DISPLAY_HEIGHT = 60;

	/** Panel offset from the block origin. Tune to seat it on the model. */
	private static final double OFFSET_X = -0.47;
	private static final double OFFSET_Y = -0.155;
	private static final double OFFSET_Z = -0.13;

	public RenderLUPIDS(Argument dispatcher) {
		super(dispatcher);
	}

	@Override
	public void renderPIDS(
			LUPIDS.TileEntityLUPIDS entity,
			PIDSPresetBase preset,
			GraphicsHolder graphicsHolder,
			StoredMatrixTransformations transformations,
			World world,
			BlockState state,
			BlockPos pos,
			Direction facing,
			LongImmutableList platformIds,
			ObjectArrayList<ArrivalResponse> arrivals,
			float tickDelta,
			boolean[] rowHidden,
			int light
	) {
		transformations.add(holder -> holder.translate(OFFSET_X, OFFSET_Y, OFFSET_Z));
		preset.render(
				entity,
				graphicsHolder,
				transformations,
				world,
				entity.getPos2(),
				facing,
				platformIds,
				arrivals,
				rowHidden,
				tickDelta,
				0,
				0,
				DISPLAY_WIDTH,
				DISPLAY_HEIGHT,
				light
		);
	}
}
