package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.TextHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.BlockPIDSHorizontalBase;
import org.mtr.mod.block.BlockPoleCheckBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class BlockPIDSPole extends BlockPoleCheckBase {

	public BlockPIDSPole(BlockSettings settings) {
		super(settings);
	}

	@Nonnull
	@Override
	public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return IBlock.getVoxelShapeByDirection(7.5, 0, 12.5, 8.5, 16, 13.5, IBlock.getStatePropertySafe(state, FACING));
	}

	@Override
	protected boolean isBlock(Block block) {
		return block.data instanceof BlockPIDSHorizontalBase || block.data instanceof BlockPIDSPole;
	}

	@Override
	protected Text getTooltipBlockText() {
		return new Text(TextHelper.translatable("block.mtr.pids_1").data);
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		builder.add(FACING);
	}
}
