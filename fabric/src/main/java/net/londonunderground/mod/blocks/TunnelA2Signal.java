package net.londonunderground.mod.blocks;

import net.londonunderground.mod.BlockEntityTypes;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mod.block.BlockSignalLightBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;

public class TunnelA2Signal extends BlockSignalLightBase {

	public TunnelA2Signal(BlockSettings settings) {
		super(settings, 2, 14);
	}

	@Nonnull
	@Override
	public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		final Direction facing = IBlock.getStatePropertySafe(state, FACING);
		return IBlock.getVoxelShapeByDirection(0, 0, 0, 12, 16, 16, facing);
	}

	@Nonnull
	@Override
	public BlockEntityExtension createBlockEntity(BlockPos pos, BlockState state) {
		return new TileEntityTunnelSignalLight1(pos, state);
	}

	public static class TileEntityTunnelSignalLight1 extends BlockEntityExtension {

		public TileEntityTunnelSignalLight1(BlockPos pos, BlockState state) {
			super(BlockEntityTypes.TUNNEL_A2_SIGNAL.get(), pos, state);
		}
	}

	@Override
	public BlockState getPlacementState2(ItemPlacementContext ctx) {
		return getDefaultState2().with(new Property<>(FACING.data), ctx.getPlayerFacing().rotateYClockwise().data);
	}
}
