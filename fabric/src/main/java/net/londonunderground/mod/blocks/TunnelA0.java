package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class TunnelA0 extends BlockExtension implements DirectionHelper {

	public TunnelA0(BlockSettings settings) {
		super(settings);
	}

	@Override
	public BlockState getPlacementState2(ItemPlacementContext ctx) {
		return getDefaultState2().with(new Property<>(FACING.data), ctx.getPlayerFacing().getOpposite().data);
	}

	@Nonnull
	@Override
	public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		final Direction facing = IBlock.getStatePropertySafe(state, FACING).getOpposite();
		return BlockHelper.shapeUnion(
				IBlock.getVoxelShapeByDirection(0, 0, 6, 16, 0.83333, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 2.66667, 0, 16, 3.66667, 4, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 5, 16, 1.83333, 6, facing),
				IBlock.getVoxelShapeByDirection(0, 4.66667, 0, 16, 6, 1.66667, facing),
				IBlock.getVoxelShapeByDirection(0, 3.66667, 0, 16, 4.66667, 3, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 0, 16, 2.66667, 5, facing),
				IBlock.getVoxelShapeByDirection(0, 6, 0, 16, 6.83333, 1, facing)
		);
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		builder.add(FACING);
	}
}
