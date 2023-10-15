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

public class StairBlockExtendsNew extends StairBlock {
	public StairBlockExtendsNew(BlockState baseBlockState, Properties settings) {
		super(baseBlockState, settings);
	}
}


