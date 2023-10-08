package net.londonunderground.blocks;

import mtr.mappings.Text;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class StairBlockExtends extends StairBlock {
	public StairBlockExtends(BlockState baseBlockState, Properties settings) {
		super(baseBlockState, settings);
	}

	@Override
	public void appendHoverText(ItemStack stack, BlockGetter blockGetter, List<Component> tooltip, TooltipFlag tooltipFlag) {
		tooltip.add(Text.literal("DEPRECATED!!!").setStyle(Style.EMPTY.withColor(ChatFormatting.RED)));
	}
}


