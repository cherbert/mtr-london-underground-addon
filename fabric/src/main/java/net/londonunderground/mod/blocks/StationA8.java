package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class StationA8 extends BlockExtension implements DirectionHelper {

	public StationA8(BlockSettings settings) {
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
				IBlock.getVoxelShapeByDirection(0, 4, 0, 16, 5, 2, facing),
				IBlock.getVoxelShapeByDirection(0, 5, 0, 16, 6, 4, facing),
				IBlock.getVoxelShapeByDirection(0, 6, 0, 16, 7, 5, facing),
				IBlock.getVoxelShapeByDirection(0, 7, 0, 16, 8, 7, facing),
				IBlock.getVoxelShapeByDirection(0, 8, 0, 16, 9, 9, facing),
				IBlock.getVoxelShapeByDirection(0, 9, 0, 16, 10, 11, facing),
				IBlock.getVoxelShapeByDirection(0, 10, 0, 16, 11, 14, facing),
				IBlock.getVoxelShapeByDirection(0, 11, 0, 16, 16, 16, facing)
		);
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		builder.add(FACING);
	}
}
