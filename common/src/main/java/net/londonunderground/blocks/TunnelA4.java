package net.londonunderground.blocks;

import mtr.block.IBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TunnelA4 extends HorizontalDirectionalBlock {
	public TunnelA4(Properties settings) {
		super(settings);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext ctx) {
		return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext) {
		final Direction facing = IBlock.getStatePropertySafe(state, FACING);
		return Shapes.or(
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
