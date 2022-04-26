package net.londonunderground.blocks;

import mtr.mappings.BlockEntityMapper;
import mtr.mappings.EntityBlockMapper;
import net.londonunderground.MyBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TunnelDarknessBlock extends Block implements EntityBlockMapper {

	public TunnelDarknessBlock(Properties settings) {
		super(settings);
	}

	@Override
	public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return Shapes.empty();
	}

	@Override
	public RenderShape getRenderShape(BlockState blockState) {
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}

	@Override
	public BlockEntityMapper createBlockEntity(BlockPos pos, BlockState state) {
		return new TileEntityTunnelDarkness(pos, state);
	}

	public static class TileEntityTunnelDarkness extends BlockEntityMapper {

		public TileEntityTunnelDarkness(BlockPos pos, BlockState state) {
			super(MyBlockEntityTypes.DARK_TILE.get(), pos, state);
		}

		public double getViewDistance() {
			return 256;
		}
	}
}
