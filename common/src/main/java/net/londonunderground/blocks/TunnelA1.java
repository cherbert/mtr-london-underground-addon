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

public class TunnelA1 extends HorizontalDirectionalBlock {
	public TunnelA1(Properties settings) {
		super(settings);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext ctx) {
		return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext) {
		final Direction facing = IBlock.getStatePropertySafe(state, FACING);
		return Shapes.or(
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
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}


}
