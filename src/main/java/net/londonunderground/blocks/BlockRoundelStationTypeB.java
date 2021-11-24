package net.londonunderground.blocks;

import mtr.block.IBlock;
import net.londonunderground.Main;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class BlockRoundelStationTypeB extends BlockRoundelBase {


    public BlockRoundelStationTypeB(Settings settings) {
        super(settings);
    }

//    @Override
//    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
//        final Direction facing = IBlock.getStatePropertySafe(state, FACING);
//        return world.getBlockState(pos.offset(facing)).isSideSolidFullSquare(world, pos.offset(facing), facing.getOpposite());
//    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(FACING, ctx.getPlayerFacing());
    }

//    @Override
//    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
//        if (direction.getOpposite() == IBlock.getStatePropertySafe(state, FACING).getOpposite() && !state.canPlaceAt(world, pos)) {
//            return Blocks.AIR.getDefaultState();
//        } else {
//            return state;
//        }
//    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return IBlock.getVoxelShapeByDirection(0, 0, 0, 16, 16, 16, IBlock.getStatePropertySafe(state, FACING));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new BlockRoundelStationTypeB.TileEntityBlockRoundelStationTypeB();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(COLOR, FACING);
    }

    public static class TileEntityBlockRoundelStationTypeB extends BlockRoundelBase.TileEntityBlockRoundelBase {

        public TileEntityBlockRoundelStationTypeB() {
            super(Main.BLOCK_ROUNDEL_STATION_TYPE_B_TILE_ENTITY);
        }

        @Override
        public boolean shouldRender() {
            return true;
        }
    }
}
