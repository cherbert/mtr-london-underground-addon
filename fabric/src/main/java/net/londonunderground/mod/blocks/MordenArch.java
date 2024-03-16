package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class MordenArch extends BlockExtension implements DirectionHelper {

	public MordenArch(BlockSettings settings) {
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
				IBlock.getVoxelShapeByDirection(0, 8, 12, 16, 16, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 7, 9.5, 16, 16, 12, facing),
				IBlock.getVoxelShapeByDirection(0, 6, 8, 16, 16, 9.5, facing),
				IBlock.getVoxelShapeByDirection(0, 5, 6, 16, 16, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 2, 0, 16, 3, 4, facing),
				IBlock.getVoxelShapeByDirection(0, 4, 5, 16, 16, 6, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 0, 16, 1, 1.66667, facing),
				IBlock.getVoxelShapeByDirection(0, 1, 0, 16, 2, 3, facing),
				IBlock.getVoxelShapeByDirection(0, 3, 0, 16, 16, 5, facing)
		);
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		builder.add(FACING);
	}
}
