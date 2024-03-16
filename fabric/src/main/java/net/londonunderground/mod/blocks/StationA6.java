package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class StationA6 extends BlockExtension implements DirectionHelper {

	public StationA6(BlockSettings settings) {
		super(settings);
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
				IBlock.getVoxelShapeByDirection(0, 4, 0, 16, 6, 2, facing),
				IBlock.getVoxelShapeByDirection(0, 6, 0, 16, 7, 3, facing),
				IBlock.getVoxelShapeByDirection(0, 7, 0, 16, 8, 4, facing),
				IBlock.getVoxelShapeByDirection(0, 8, 0, 16, 9, 5, facing),
				IBlock.getVoxelShapeByDirection(0, 10, 0, 16, 12, 7, facing),
				IBlock.getVoxelShapeByDirection(0, 14, 0, 16, 15, 10, facing),
				IBlock.getVoxelShapeByDirection(0, 12, 0, 16, 13, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 15, 0, 16, 16, 11, facing),
				IBlock.getVoxelShapeByDirection(0, 13, 0, 16, 14, 9, facing),
				IBlock.getVoxelShapeByDirection(0, 9, 0, 16, 10, 6, facing),
				IBlock.getVoxelShapeByDirection(0, 2, 0, 16, 4, 1, facing)
		);
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		builder.add(FACING);
	}
}
