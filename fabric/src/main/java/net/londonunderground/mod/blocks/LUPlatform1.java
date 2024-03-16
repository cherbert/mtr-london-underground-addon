package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mod.block.BlockPlatform;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;

public class LUPlatform1 extends BlockPlatform {

	public LUPlatform1(BlockSettings settings, boolean isIndented) {
		super(settings, isIndented);
	}

	@Override
	public BlockState getPlacementState2(ItemPlacementContext ctx) {
		return getDefaultState2().with(new Property<>(FACING.data), ctx.getPlayerFacing().data);
	}

	@Nonnull
	@Override
	public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		final Direction facing = IBlock.getStatePropertySafe(state, FACING);
		return BlockHelper.shapeUnion(
				IBlock.getVoxelShapeByDirection(0, 0, 5.05, 16, 16, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 13, 0, 16, 16, 5.05, facing)
		);
	}
}
