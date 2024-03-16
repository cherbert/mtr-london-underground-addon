package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class StationA4 extends BlockExtension implements DirectionHelper {

	public StationA4(BlockSettings settings) {
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
				IBlock.getVoxelShapeByDirection(0, 0, 0, 16, 4, 9, facing),
				IBlock.getVoxelShapeByDirection(0, 4, 0, 16, 7, 10, facing),
				IBlock.getVoxelShapeByDirection(0, 7, 0, 16, 9, 11, facing),
				IBlock.getVoxelShapeByDirection(0, 9, 0, 16, 11, 12, facing),
				IBlock.getVoxelShapeByDirection(0, 11, 0, 16, 13, 13, facing),
				IBlock.getVoxelShapeByDirection(0, 13, 0, 16, 15, 14, facing),
				IBlock.getVoxelShapeByDirection(0, 15, 0, 16, 16, 15, facing)
		);
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		builder.add(FACING);
	}
}
