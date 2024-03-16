package net.londonunderground.mod.blocks;

import net.londonunderground.mod.BlockEntityTypes;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mod.block.BlockPIDSHorizontalBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;

public class NorthernLinePIDS extends BlockPIDSHorizontalBase {

	private static final int MAX_ARRIVALS = 3;

	public NorthernLinePIDS() {
		super(MAX_ARRIVALS);
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
		return new TileEntityNorthernLinePIDS(pos, state);
	}

	public static class TileEntityNorthernLinePIDS extends BlockEntityHorizontalBase {

		public TileEntityNorthernLinePIDS(BlockPos pos, BlockState state) {
			super(MAX_ARRIVALS, BlockEntityTypes.PIDS_NORTHERN_TILE_ENTITY.get(), pos, state);
		}

		@Override
		public boolean showArrivalNumber() {
			return true;
		}
	}
}