package net.londonunderground.blocks;

import mtr.block.IBlock;
import net.londonunderground.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class MordenSign extends BlockRoundelBase {

    public MordenSign(Settings settings) {
        super(settings);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(FACING, ctx.getPlayerFacing());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return IBlock.getVoxelShapeByDirection(-2, 0, 8, 19, 31, 9, state.get(FACING));
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new MordenSign.TileEntityMordenSign();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public static class TileEntityMordenSign extends BlockRoundelBase.TileEntityBlockRoundelBase {

        public TileEntityMordenSign() {
            super(Main.MORDEN_SIGN_TILE_ENTITY);
        }

        @Override
        public boolean shouldRender() {
            return true;
        }
    }
}


