package net.londonunderground.mod.blocks;

import com.lx862.jcm.mod.block.JCMPIDSBlock;
import com.lx862.jcm.mod.block.entity.PIDSBlockEntity;
import net.londonunderground.mod.BlockEntityTypes;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;

/**
 * London Underground PIDS, rendered by a JCM script rather than by Java.
 *
 * The script is baked in: getDefaultPresetId() returns the preset declared in
 * assets/jsblock/joban_custom_resources.json, which points at
 * assets/lu_jcm_pack/scripts/lu_pids.js. Placing the block is enough - there is
 * no preset to pick.
 *
 * Requires JCM and MTR at runtime, plus the MTR London Underground Addon for
 * the Johnston-style font and the block textures the model references. All
 * three are declared in fabric.mod.json.
 */
public class LUPIDS extends JCMPIDSBlock {

	/** Preset id declared in assets/jsblock/joban_custom_resources.json. */
	public static final String PRESET_ID = "lu_pids";

	/** Block type, used by presets to filter which blocks they apply to. */
	public static final String PIDS_TYPE = "lu_pids";

	private static final int MAX_ARRIVALS = 3;

	public LUPIDS(BlockSettings blockSettings) {
		super(blockSettings);
	}

	@Nonnull
	@Override
	public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return BlockHelper.shapeUnion(
				IBlock.getVoxelShapeByDirection(6, 0, 0, 10, 9, 16, IBlock.getStatePropertySafe(state, FACING)),
				IBlock.getVoxelShapeByDirection(7.5, 9, 12.5, 8.5, 16, 13.5, IBlock.getStatePropertySafe(state, FACING))
		);
	}

	@Nonnull
	@Override
	public BlockEntityExtension createBlockEntity(BlockPos pos, BlockState state) {
		return new TileEntityLUPIDS(pos, state);
	}

	public static class TileEntityLUPIDS extends PIDSBlockEntity {

		public TileEntityLUPIDS(BlockPos pos, BlockState state) {
			super(BlockEntityTypes.LU_PIDS_TILE_ENTITY.get(), pos, state);
		}

		@Override
		public String getPIDSType() {
			return PIDS_TYPE;
		}

		@Override
		public String getDefaultPresetId() {
			return PRESET_ID;
		}

		@Override
		public int getRowAmount() {
			return MAX_ARRIVALS;
		}

		@Override
		public boolean isKeyBlock() {
			return true;
		}
	}
}
