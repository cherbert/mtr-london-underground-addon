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

public class TunnelA1Duel extends HorizontalDirectionalBlock {
	public TunnelA1Duel(Properties settings) {
		super(settings);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext ctx) {
		return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection());
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext) {
		final Direction facing = IBlock.getStatePropertySafe(state, FACING);
		return Shapes.or(
				IBlock.getVoxelShapeByDirection(0, 15, 6.16667, 16, 16, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 7, 7, 16, 15, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 3, 6.16667, 16, 7, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 5.16667, 16, 3, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 8, 16, 3, 10.83333, facing),
				IBlock.getVoxelShapeByDirection(0, 15, 8, 16, 16, 9.83333, facing),
				IBlock.getVoxelShapeByDirection(0, 7, 8, 16, 15, 9, facing),
				IBlock.getVoxelShapeByDirection(0, 3, 8, 16, 7, 9.83333, facing),
				IBlock.getVoxelShapeByDirection(7.8125, 12.01444, 10.9935, 8.1875, 14.95833, 11.38861, facing),
				IBlock.getVoxelShapeByDirection(7.8125, 7.59778, 10.32683, 8.1875, 10.29167, 10.77683, facing),
				IBlock.getVoxelShapeByDirection(7.8125, 11.55785, 6.88085, 8.1875, 12.05785, 11.38085, facing),
				IBlock.getVoxelShapeByDirection(7.8125, 7.50154, 5.2781, 8.1875, 8.00154, 9.7781, facing),
				IBlock.getVoxelShapeByDirection(0, 12.20833, 9.83334, 16, 12.70833, 10.33334, facing),
				IBlock.getVoxelShapeByDirection(0, 8.04167, 9.16667, 16, 8.54167, 9.66667, facing),
				IBlock.getVoxelShapeByDirection(0, 12.45833, 10.45834, 16, 12.95833, 10.95834, facing),
				IBlock.getVoxelShapeByDirection(0, 8.29167, 9.79167, 16, 8.79167, 10.29167, facing),
				IBlock.getVoxelShapeByDirection(0, 13.08333, 10.45834, 16, 13.58333, 10.95834, facing),
				IBlock.getVoxelShapeByDirection(0, 8.91667, 9.79167, 16, 9.41667, 10.29167, facing),
				IBlock.getVoxelShapeByDirection(0, 12.83333, 9.83334, 16, 13.33333, 10.33334, facing),
				IBlock.getVoxelShapeByDirection(0, 8.66667, 9.16667, 16, 9.16667, 9.66667, facing),
				IBlock.getVoxelShapeByDirection(0, 13.45833, 9.83334, 16, 13.95833, 10.33334, facing),
				IBlock.getVoxelShapeByDirection(0, 9.29167, 9.16667, 16, 9.79167, 9.66667, facing),
				IBlock.getVoxelShapeByDirection(0, 13.70833, 10.45834, 16, 14.20833, 10.95834, facing),
				IBlock.getVoxelShapeByDirection(0, 9.54167, 9.79167, 16, 10.04167, 10.29167, facing),
				IBlock.getVoxelShapeByDirection(0, 14.33333, 10.45834, 16, 14.83333, 10.95834, facing),
				IBlock.getVoxelShapeByDirection(0, 10.16667, 9.79167, 16, 10.66667, 10.29167, facing),
				IBlock.getVoxelShapeByDirection(0, 14.08333, 9.83334, 16, 14.58333, 10.33334, facing),
				IBlock.getVoxelShapeByDirection(0, 9.91667, 9.16667, 16, 10.41667, 9.66667, facing),
				IBlock.getVoxelShapeByDirection(7.8125, 12.01444, 4.61139, 8.1875, 14.95833, 5.0065, facing),
				IBlock.getVoxelShapeByDirection(7.8125, 7.84778, 5.27806, 8.1875, 10.29167, 5.67317, facing),
				IBlock.getVoxelShapeByDirection(7.8125, 11.55785, 4.61915, 8.1875, 12.05785, 9.11915, facing),
				IBlock.getVoxelShapeByDirection(7.8125, 7.50154, 6.27093, 8.1875, 8.00154, 10.77093, facing),
				IBlock.getVoxelShapeByDirection(0, 12.20833, 5.66666, 16, 12.70833, 6.16666, facing),
				IBlock.getVoxelShapeByDirection(0, 8.04167, 6.33333, 16, 8.54167, 6.83333, facing),
				IBlock.getVoxelShapeByDirection(0, 12.45833, 5.04166, 16, 12.95833, 5.54166, facing),
				IBlock.getVoxelShapeByDirection(0, 8.29167, 5.70833, 16, 8.79167, 6.20833, facing),
				IBlock.getVoxelShapeByDirection(0, 13.08333, 5.04166, 16, 13.58333, 5.54166, facing),
				IBlock.getVoxelShapeByDirection(0, 8.91667, 5.70833, 16, 9.41667, 6.20833, facing),
				IBlock.getVoxelShapeByDirection(0, 12.83333, 5.66666, 16, 13.33333, 6.16666, facing),
				IBlock.getVoxelShapeByDirection(0, 8.66667, 6.33333, 16, 9.16667, 6.83333, facing),
				IBlock.getVoxelShapeByDirection(0, 13.45833, 5.66666, 16, 13.95833, 6.16666, facing),
				IBlock.getVoxelShapeByDirection(0, 9.29167, 6.33333, 16, 9.79167, 6.83333, facing),
				IBlock.getVoxelShapeByDirection(0, 13.70833, 5.04166, 16, 14.20833, 5.54166, facing),
				IBlock.getVoxelShapeByDirection(0, 9.54167, 5.70833, 16, 10.04167, 6.20833, facing),
				IBlock.getVoxelShapeByDirection(0, 14.33333, 5.04166, 16, 14.83333, 5.54166, facing),
				IBlock.getVoxelShapeByDirection(0, 10.16667, 5.70833, 16, 10.66667, 6.20833, facing),
				IBlock.getVoxelShapeByDirection(0, 14.08333, 5.66666, 16, 14.58333, 6.16666, facing),
				IBlock.getVoxelShapeByDirection(0, 9.91667, 6.33333, 16, 10.41667, 6.83333, facing)
		);
	}


		@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}


}
