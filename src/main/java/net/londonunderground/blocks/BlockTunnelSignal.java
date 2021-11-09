package net.londonunderground.blocks;

import mtr.block.IBlock;
import net.londonunderground.Main;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class BlockTunnelSignal extends mtr.block.BlockSignalLightBase implements BlockEntityProvider {
    public BlockTunnelSignal(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return IBlock.getVoxelShapeByDirection(0, 0, 0, 16, 16, 16, IBlock.getStatePropertySafe(state, FACING));
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new TileEntityTunnelSignalLight1();
    }
    public static class TileEntityTunnelSignalLight1 extends BlockEntity {

        public TileEntityTunnelSignalLight1() {
            super(Main.TUNNEL_BLOCK_2_SIGNAL);
        }
    }


}
