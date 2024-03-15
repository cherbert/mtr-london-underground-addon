package net.londonunderground.blocks;

import mtr.block.IBlock;
import mtr.mappings.BlockEntityMapper;
import net.londonunderground.MyBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class NameProjector extends BlockRoundelBase {


	public NameProjector(Properties settings) {
		super(settings);
	}

//    @Override
//    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
//        final Direction facing = IBlock.getStatePropertySafe(state, FACING);
//        return world.getBlockState(pos.relative(facing)).isFaceSturdy(world, pos.relative(facing), facing.getOpposite());
//    }

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext ctx) {
		return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection());
	}

//    @Override
//    public BlockState updateShape(BlockState state, Direction direction, BlockState newState, LevelAccessor world, BlockPos pos, BlockPos posFrom) {
//        if (direction.getOpposite() == IBlock.getStatePropertySafe(state, FACING).getOpposite() && !state.canPlaceAt(world, pos)) {
//            return Blocks.AIR.defaultBlockState();
//        } else {
//            return state;
//        }
//    }

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext collisionContext) {
		return IBlock.getVoxelShapeByDirection(0, 0, 0, 16, 16, 16, IBlock.getStatePropertySafe(state, FACING));
	}

	@Override
	public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return Shapes.empty();
	}

	@Override
	public BlockEntityMapper createBlockEntity(BlockPos pos, BlockState state) {
		return new NameProjector.TileEntityNameProjector(pos, state);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(COLOR, FACING);
	}

	public static class TileEntityNameProjector extends TileEntityBlockRoundelBase {

		public TileEntityNameProjector(BlockPos pos, BlockState state) {
			super(MyBlockEntityTypes.NAME_PROJECTOR.get(), pos, state);
		}

		@Override
		public boolean shouldRender() {
			return true;
		}
	}
}
