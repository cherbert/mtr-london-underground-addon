package net.londonunderground.mod.blocks;

import net.londonunderground.mod.BlockEntityTypes;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class MordenSign extends BlockRoundelBase {

	public MordenSign(BlockSettings settings) {
		super(settings);
	}

	@Override
	public BlockState getPlacementState2(ItemPlacementContext ctx) {
		return getDefaultState2().with(new Property<>(FACING.data), ctx.getPlayerFacing().data);
	}

	@Nonnull
	@Override
	public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		final Direction facing = IBlock.getStatePropertySafe(state, FACING);
		return BlockHelper.shapeUnion(
				IBlock.getVoxelShapeByDirection(-1.5, 8.66667, 7.575, 17.5, 31, 8.425, facing),
				IBlock.getVoxelShapeByDirection(7.375, 0, 7.6, 8.625, 8.75, 8.4, facing)
		);
	}

	@Nonnull
	@Override
	public BlockEntityExtension createBlockEntity(BlockPos pos, BlockState state) {
		return new MordenSign.TileEntityMordenSign(pos, state);
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		builder.add(FACING);
	}

	public static class TileEntityMordenSign extends BlockRoundelBase.TileEntityBlockRoundelBase {

		public TileEntityMordenSign(BlockPos pos, BlockState state) {
			super(BlockEntityTypes.MORDEN_SIGN_TILE_ENTITY.get(), pos, state);
		}

		@Override
		public boolean shouldRender() {
			return true;
		}
	}
}


