package net.londonunderground.blocks;

import mtr.block.IBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StationLight extends Block {

	public static final BooleanProperty FACING = BooleanProperty.create("facing");

	public StationLight(Properties settings) {
		super(settings);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext ctx) {
		boolean facing = ctx.getHorizontalDirection().getAxis() == Direction.Axis.X;
		return defaultBlockState().setValue(FACING, facing);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext collisionContext) {
		if (IBlock.getStatePropertySafe(state, FACING)) {
			return Shapes.or(
					Block.box(0, 14.5, 6, 16, 16, 6.5),
					Block.box(0, 14.5, 9.5, 16, 16, 10),
					Block.box(0, 15, 6.5, 16, 16, 9.5)
			);
		} else {

			return Shapes.or(
					Block.box(6, 14.5, 0, 6.5, 16, 16),
					Block.box(9.5, 14.5, 0, 10, 16, 16),
					Block.box(6.5, 15, 0, 9.5, 16, 16)
			);
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}


}