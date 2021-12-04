package net.londonunderground.blocks;

import mapper.BlockEntityMapper;
import mapper.BlockEntityProviderMapper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.londonunderground.Main;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class TunnelDarknessBlock extends Block implements BlockEntityProviderMapper {

    public TunnelDarknessBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TileEntityTunnelDarkness(pos, state);
    }

    public static class TileEntityTunnelDarkness extends BlockEntityMapper {

        public TileEntityTunnelDarkness(BlockPos pos, BlockState state) {
            super(Main.DARK_TILE, pos, state);
        }
        @Environment(EnvType.CLIENT)
        public double getRenderDistance() {
            return 256.0D;
        }

    }
}
