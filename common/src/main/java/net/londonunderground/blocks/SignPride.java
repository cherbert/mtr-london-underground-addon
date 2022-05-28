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
import net.minecraft.world.phys.shapes.VoxelShape;

public class SignPride extends BlockRoundelBase {

    public SignPride(Properties settings) {
        super(settings);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext) {
        return IBlock.getVoxelShapeByDirection(-1.5, 0, 7.575, 17.5, 31, 8.425, state.getValue(FACING));
    }

    @Override
    public BlockEntityMapper createBlockEntity(BlockPos pos, BlockState state) {
        return new SignPride.TileEntitySignPride(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public static class TileEntitySignPride extends TileEntityBlockRoundelBase {

        public TileEntitySignPride(BlockPos pos, BlockState state) {
            super(MyBlockEntityTypes.SIGN_PRIDE_TILE_ENTITY.get(), pos, state);
        }

        @Override
        public boolean shouldRender() {
            return true;
        }
    }
}


