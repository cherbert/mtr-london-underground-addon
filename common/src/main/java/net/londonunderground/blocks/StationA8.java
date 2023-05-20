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

public class StationA8 extends HorizontalDirectionalBlock {
	public StationA8(Properties settings) {
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
				IBlock.getVoxelShapeByDirection(0,4,0,16, 5, 2, facing),
				IBlock.getVoxelShapeByDirection(0, 5, 0,16, 6, 4, facing),
				IBlock.getVoxelShapeByDirection(0, 6, 0,16, 7, 5, facing),
				IBlock.getVoxelShapeByDirection(0,7,0, 16, 8,7, facing),
				IBlock.getVoxelShapeByDirection(0, 8, 0,16, 9, 9, facing),
				IBlock.getVoxelShapeByDirection(0, 9, 0,16, 10, 11, facing),
				IBlock.getVoxelShapeByDirection(0,10,0,16, 11, 14, facing),
				IBlock.getVoxelShapeByDirection(0,11,0, 16, 16,16, facing)
		);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}


}
