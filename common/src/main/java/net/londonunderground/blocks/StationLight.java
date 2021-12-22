package net.londonunderground.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
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
		return Block.box(0, 14, 0, 16, 16, 16);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}


}
