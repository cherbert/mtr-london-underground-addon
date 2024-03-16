package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class TunnelA4 extends BlockExtension implements DirectionHelper {

	public TunnelA4(BlockSettings settings) {
		super(settings);
	}

	@Override
	public BlockState getPlacementState2(ItemPlacementContext ctx) {
		return getDefaultState2().with(new Property<>(FACING.data), ctx.getPlayerFacing().getOpposite().data);
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		builder.add(FACING);
	}

	@Nonnull
	@Override
	public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		final Direction facing = IBlock.getStatePropertySafe(state, FACING);
		return BlockHelper.shapeUnion(
				IBlock.getVoxelShapeByDirection(0, 8, 0, 16, 16, 4, facing),
				IBlock.getVoxelShapeByDirection(0, 7, 4, 16, 16, 6.5, facing),
				IBlock.getVoxelShapeByDirection(0, 6, 6.5, 16, 16, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 5, 8, 16, 16, 10, facing),
				IBlock.getVoxelShapeByDirection(0, 2, 12, 16, 3, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 4, 10, 16, 16, 11, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 14.3333, 16, 1, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 1, 13, 16, 2, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 3, 11, 16, 16, 16, facing)
		);
	}
}
