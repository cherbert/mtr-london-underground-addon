package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class TunnelA3 extends BlockExtension implements DirectionHelper {

	public TunnelA3(BlockSettings settings) {
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
				IBlock.getVoxelShapeByDirection(0, 15.16667, -1, 16, 16, 0, facing),
				IBlock.getVoxelShapeByDirection(0, 15.16667, 0, 16, 16, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 14.16667, 0, 16, 16, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 14.16667, 0, 16, 15.16667, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 13.16667, 1, 16, 14.16667, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 11, 2.16667, 16, 13.16667, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 9.5, 3.16667, 16, 11, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 7, 4.16667, 16, 9.5, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 3, 5.16667, 16, 7, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 4.5, 16, 3, 16, facing)
		);
	}
}
