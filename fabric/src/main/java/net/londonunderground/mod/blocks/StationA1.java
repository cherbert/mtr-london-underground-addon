package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class StationA1 extends BlockExtension implements DirectionHelper {

	public StationA1(BlockSettings settings) {
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
				IBlock.getVoxelShapeByDirection(0, 0, 0, 16, 1, 15, facing),
				IBlock.getVoxelShapeByDirection(0, 1, 0, 16, 3, 14, facing),
				IBlock.getVoxelShapeByDirection(0, 3, 0, 16, 5, 13, facing),
				IBlock.getVoxelShapeByDirection(0, 5, 0, 16, 7, 12, facing),
				IBlock.getVoxelShapeByDirection(0, 7, 0, 16, 9, 11, facing),
				IBlock.getVoxelShapeByDirection(0, 9, 0, 16, 12, 10, facing),
				IBlock.getVoxelShapeByDirection(0, 12, 0, 16, 16, 9, facing)
		);
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		builder.add(FACING);
	}


}