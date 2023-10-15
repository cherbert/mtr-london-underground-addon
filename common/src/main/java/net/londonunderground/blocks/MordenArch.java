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

public class MordenArch extends HorizontalDirectionalBlock {
	public MordenArch(Properties settings) {
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
				IBlock.getVoxelShapeByDirection(0,8,12,16, 16, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 7, 9.5,16, 16, 12, facing),
				IBlock.getVoxelShapeByDirection(0, 6, 8,16, 16, 9.5, facing),
				IBlock.getVoxelShapeByDirection(0, 5, 6,16, 16, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 2, 0,16, 3, 4, facing),
				IBlock.getVoxelShapeByDirection(0, 4, 5,16, 16, 6, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 0,16, 1, 1.66667, facing),
				IBlock.getVoxelShapeByDirection(0, 1, 0,16, 2, 3, facing),
				IBlock.getVoxelShapeByDirection(0, 3, 0,16, 16, 5, facing));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}


}
