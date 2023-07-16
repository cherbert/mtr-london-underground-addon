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

public class StationA3StopMarker extends HorizontalDirectionalBlock {
	public StationA3StopMarker(Properties settings) {
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
				IBlock.getVoxelShapeByDirection(0,15,0,16, 16, 9, facing),
				IBlock.getVoxelShapeByDirection(0, 9, 0,16, 15, 8, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 0,16, 9, 7, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 11,16, 0.25, 12, facing),
				IBlock.getVoxelShapeByDirection(0, 4.75, 11,16, 5, 12, facing),
				IBlock.getVoxelShapeByDirection(0, 0.25, 11,16, 4.75, 12, facing),
				IBlock.getVoxelShapeByDirection(7, 1.75, 6.25,9, 2.75, 11.25, facing));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}


}
