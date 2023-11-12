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

public class TunnelA0 extends HorizontalDirectionalBlock {
	public TunnelA0(Properties settings) {
		super(settings);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext ctx) {
		return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext) {
		final Direction facing = IBlock.getStatePropertySafe(state, FACING).getOpposite();
		return Shapes.or(
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
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}


}
