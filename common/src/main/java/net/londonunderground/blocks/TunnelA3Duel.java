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

public class TunnelA3Duel extends HorizontalDirectionalBlock {
	public TunnelA3Duel(Properties settings) {
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
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}


}
