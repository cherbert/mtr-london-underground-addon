package net.londonunderground.mod.blocks;

import net.londonunderground.mod.BlockEntityTypes;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockWithEntity;

import javax.annotation.Nonnull;

public class TunnelDarknessBlock extends BlockExtension implements BlockWithEntity {

	public TunnelDarknessBlock(BlockSettings settings) {
		super(settings);
	}

	@Nonnull
	@Override
	public VoxelShape getCollisionShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return VoxelShapes.empty();
	}

	@Nonnull
	@Override
	public BlockRenderType getRenderType2(BlockState state) {
		return BlockRenderType.getEntityblockAnimatedMapped();
	}

	@Nonnull
	@Override
	public BlockEntityExtension createBlockEntity(BlockPos pos, BlockState state) {
		return new TileEntityTunnelDarkness(pos, state);
	}


	public static class TileEntityTunnelDarkness extends BlockEntityExtension {

		public TileEntityTunnelDarkness(BlockPos pos, BlockState state) {
			super(BlockEntityTypes.DARK_TILE.get(), pos, state);
		}

		@Override
		public double getRenderDistance3() {
			return 512;
		}
	}
}
