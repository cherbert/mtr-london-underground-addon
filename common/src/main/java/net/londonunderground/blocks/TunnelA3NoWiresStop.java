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

public class TunnelA3NoWiresStop extends HorizontalDirectionalBlock {
	public TunnelA3NoWiresStop(Properties settings) {
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
				IBlock.getVoxelShapeByDirection(0, 15.16667, -1, 16, 16, 0, facing),
				IBlock.getVoxelShapeByDirection(0, 15.16667, 0, 16, 16, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 14.16667, 0, 16, 16, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 14.16667, 0, 16, 15.16667, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 13.16667, 1, 16, 14.16667, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 11, 2.16667, 16, 13.16667, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 9.5, 3.16667, 16, 11, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 7, 4.16667, 16, 9.5, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 3, 5.16667, 16, 7, 16, facing),
				IBlock.getVoxelShapeByDirection(0, 0, 6.16667, 16, 3, 16, facing),
				IBlock.getVoxelShapeByDirection(3, 0, 4, 16, 5, 6, facing)
		);
	}

}
