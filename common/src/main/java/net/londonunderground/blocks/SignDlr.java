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

public class SignDlr extends BlockRoundelBase {

    public SignDlr(Properties settings) {
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
        return new SignDlr.TileEntitySignDlr(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public static class TileEntitySignDlr extends TileEntityBlockRoundelBase {

        public TileEntitySignDlr(BlockPos pos, BlockState state) {
            super(MyBlockEntityTypes.SIGN_DLR_TILE_ENTITY.get(), pos, state);
        }

        @Override
        public boolean shouldRender() {
            return true;
        }
    }
}


