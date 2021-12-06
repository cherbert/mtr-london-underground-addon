package net.londonunderground.blocks;

import minecraftmappings.BlockEntityMapper;
import minecraftmappings.BlockEntityProviderMapper;
import mtr.block.IBlock;
import net.londonunderground.Main;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class BlockTunnelSignal extends mtr.block.BlockSignalLightBase implements BlockEntityProviderMapper {
    public BlockTunnelSignal(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return IBlock.getVoxelShapeByDirection(0, 0, 0, 16, 16, 16, IBlock.getStatePropertySafe(state, FACING));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TileEntityTunnelSignalLight1(pos, state);
    }
    public static class TileEntityTunnelSignalLight1 extends BlockEntityMapper {

        public TileEntityTunnelSignalLight1(BlockPos pos, BlockState state) {
            super(Main.TUNNEL_BLOCK_2_SIGNAL, pos, state);
        }
    }


}
