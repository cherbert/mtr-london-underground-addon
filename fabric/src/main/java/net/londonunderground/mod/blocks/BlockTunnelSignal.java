package net.londonunderground.mod.blocks;

import net.londonunderground.mod.BlockEntityTypes;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mapping.mapper.TextHelper;
import org.mtr.mod.block.BlockSignalLightBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class BlockTunnelSignal extends BlockSignalLightBase {

	public BlockTunnelSignal(BlockSettings settings) {
		super(settings, 2, 14);
	}

	@Nonnull
	@Override
	public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return IBlock.getVoxelShapeByDirection(0, 0, 0, 16, 16, 16, IBlock.getStatePropertySafe(state, FACING));
	}

	@Nonnull
	@Override
	public BlockEntityExtension createBlockEntity(BlockPos pos, BlockState state) {
		return new TileEntityTunnelSignalLight1(pos, state);
	}

	public static class TileEntityTunnelSignalLight1 extends BlockEntityExtension {

		public TileEntityTunnelSignalLight1(BlockPos pos, BlockState state) {
			super(BlockEntityTypes.TUNNEL_BLOCK_2_SIGNAL.get(), pos, state);
		}
	}

	@Override
	public void addTooltips(ItemStack stack, @Nullable BlockView world, List<MutableText> tooltip, TooltipContext options) {
		tooltip.add(TextHelper.literal("DEPRECATED!!!").formatted(TextFormatting.RED));
	}

}
