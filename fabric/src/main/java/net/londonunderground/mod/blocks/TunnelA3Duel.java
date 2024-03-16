package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class TunnelA3Duel extends BlockExtension implements DirectionHelper {

	public TunnelA3Duel(BlockSettings settings) {
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
				IBlock.getVoxelShapeByDirection(0, 0, 6.16667, 16, 3, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 3, 5.16667, 16, 7, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 7, 4.16667, 16, 9.5, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 9.5, 3.16667, 16, 11, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 11, 2.16667, 16, 13.16667, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 14.16667, 0, 16, 15.16667, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 13.16667, 1, 16, 14.16667, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 15.16667, 0, 16, 16, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 15.16667, -1, 16, 16, 0, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 8, 16, 3, 9.83333, facing),
				IBlock.getVoxelShapeByDirection(0, 3, 8, 16, 7, 10.83333, facing),
				IBlock.getVoxelShapeByDirection(0, 7, 8, 16, 9.5, 11.83333, facing),
				IBlock.getVoxelShapeByDirection(0, 9.5, 8, 16, 11, 12.83333, facing),
				IBlock.getVoxelShapeByDirection(0, 11, 8, 16, 13.16667, 13.83333, facing),
				IBlock.getVoxelShapeByDirection(0, 14.16667, 8, 16, 15.16667, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 13.16667, 8, 16, 14.16667, 15, facing),
				IBlock.getVoxelShapeByDirection(0, 15.16667, 8, 16, 16, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 15.16667, 16, 16, 16, 17, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 8, 16, 3, 11.83333, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 4.16667, 16, 3, 8, facing)
		);
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		builder.add(FACING);
	}
}
