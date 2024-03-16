package net.londonunderground.mod.blocks;

import net.londonunderground.mod.BlockEntityTypes;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;

public class BlockRoundelStationTypeB extends BlockRoundelBase {


	public BlockRoundelStationTypeB(BlockSettings settings) {
		super(settings);
	}

	@Override
	public BlockState getPlacementState2(ItemPlacementContext ctx) {
		return getDefaultState2().with(new Property<>(FACING.data), ctx.getPlayerFacing().data);
	}

	@Nonnull
	@Override
	public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return IBlock.getVoxelShapeByDirection(0, 0, 0, 16, 16, 16, IBlock.getStatePropertySafe(state, FACING));
	}

	@Nonnull
	@Override
	public BlockEntityExtension createBlockEntity(BlockPos pos, BlockState state) {
		return new BlockRoundelStationTypeB.TileEntityBlockRoundelStationTypeB(pos, state);
	}

	public static class TileEntityBlockRoundelStationTypeB extends BlockRoundelBase.TileEntityBlockRoundelBase {

		public TileEntityBlockRoundelStationTypeB(BlockPos pos, BlockState state) {
			super(BlockEntityTypes.BLOCK_ROUNDEL_STATION_TYPE_B_TILE_ENTITY.get(), pos, state);
		}

		@Override
		public boolean shouldRender() {
			return true;
		}
	}
}
