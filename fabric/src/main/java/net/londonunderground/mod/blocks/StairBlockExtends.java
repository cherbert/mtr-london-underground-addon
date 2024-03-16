package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.StairsBlockExtension;
import org.mtr.mapping.mapper.TextHelper;

import javax.annotation.Nullable;
import java.util.List;

public class StairBlockExtends extends StairsBlockExtension {

	public StairBlockExtends(BlockState baseBlockState, BlockSettings settings) {
		super(baseBlockState, settings);
	}

	@Override
	public void addTooltips(ItemStack stack, @Nullable BlockView world, List<MutableText> tooltip, TooltipContext options) {
		tooltip.add(TextHelper.literal("DEPRECATED!!!").formatted(TextFormatting.RED));
	}
}
