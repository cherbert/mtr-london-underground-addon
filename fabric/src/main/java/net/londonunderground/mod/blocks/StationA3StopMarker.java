package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class StationA3StopMarker extends BlockExtension implements DirectionHelper {

	public StationA3StopMarker(BlockSettings settings) {
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
				IBlock.getVoxelShapeByDirection(0, 15, 0, 16, 16, 9, facing),
				IBlock.getVoxelShapeByDirection(0, 9, 0, 16, 15, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 0, 16, 9, 7, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 11, 16, 0.25, 12, facing),
				IBlock.getVoxelShapeByDirection(0, 4.75, 11, 16, 5, 12, facing),
				IBlock.getVoxelShapeByDirection(0, 0.25, 11, 16, 4.75, 12, facing),
				IBlock.getVoxelShapeByDirection(7, 1.75, 6.25, 9, 2.75, 11.25, facing)
		);
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		builder.add(FACING);
	}
}
