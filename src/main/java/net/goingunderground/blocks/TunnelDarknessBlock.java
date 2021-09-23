package net.goingunderground.blocks;

import net.goingunderground.Main;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class TunnelDarknessBlock extends Block implements BlockEntityProvider {

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
    public BlockEntity createBlockEntity(BlockView world) {
        return new TileEntityTunnelDarkness();
    }

    public static class TileEntityTunnelDarkness extends BlockEntity {

        public TileEntityTunnelDarkness() {
            super(Main.DARK_TILE);
        }

    }
}
