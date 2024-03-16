package net.londonunderground.mod.blocks;

import net.londonunderground.mod.BlockEntityTypes;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;

public class BlockRoundelBigEven extends BlockRoundelBase {

	public BlockRoundelBigEven(BlockSettings settings) {
		super(settings);
	}

	@Override
	public BlockState getPlacementState2(ItemPlacementContext ctx) {
		final Direction side = ctx.getSide();
		if (side != Direction.UP && side != Direction.DOWN) {
			return getDefaultState2().with(new Property<>(FACING.data), side.getOpposite().data);
		} else {
			return null;
		}
	}

	@Nonnull
	@Override
	public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return IBlock.getVoxelShapeByDirection(0, 0, 0, 16, 16, 1, IBlock.getStatePropertySafe(state, FACING));
	}

	@Nonnull
	@Override
	public BlockEntityExtension createBlockEntity(BlockPos pos, BlockState state) {
		return new BlockRoundelBigEven.TileEntityBlockRoundelBigEven(pos, state);
	}

	public static class TileEntityBlockRoundelBigEven extends TileEntityBlockRoundelBase {

		public TileEntityBlockRoundelBigEven(BlockPos pos, BlockState state) {
			super(BlockEntityTypes.BLOCK_ROUNDEL_BIG_EVEN_TILE_ENTITY.get(), pos, state);
		}

		@Override
		public boolean shouldRender() {
			return true;
		}
	}
}
