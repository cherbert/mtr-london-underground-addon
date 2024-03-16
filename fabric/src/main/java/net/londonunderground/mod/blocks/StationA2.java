package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class StationA2 extends BlockExtension implements DirectionHelper {

	public StationA2(BlockSettings settings) {
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
				IBlock.getVoxelShapeByDirection(0, 0, 8, 16, 1, 9, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 7, 16, 7, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 6, 16, 16, 7, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 5, 16, 16, 6, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 4, 16, 16, 5, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 0, 16, 16, 4, facing)
		);
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		builder.add(FACING);
	}
}
