package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class TunnelA1 extends BlockExtension implements DirectionHelper {

	public TunnelA1(BlockSettings settings) {
		super(settings);
	}

	@Override
	public BlockState getPlacementState2(ItemPlacementContext ctx) {
		return getDefaultState2().with(new Property<>(FACING.data), ctx.getPlayerFacing().getOpposite().data);
	}

	@Nonnull
	@Override
	public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		final Direction facing = IBlock.getStatePropertySafe(state, FACING);
		return BlockHelper.shapeUnion(
				IBlock.getVoxelShapeByDirection(0, 15, 5.16667, 16, 16, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 12.5, 4.16667, 16, 15, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 11, 3.16667, 16, 12.5, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 8.83333, 2.16667, 16, 11, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 6.83333, 0, 16, 7.83333, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 7.83333, 1, 16, 8.83333, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 0, 16, 6.83333, 16, facing)
		);
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		builder.add(FACING);
	}
}
