package net.londonunderground;

import mtr.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static net.londonunderground.Main.MOD_ID;

public interface MyItems {
	CreativeModeTab TFL_BLOCKS = Registry.getItemGroup(new ResourceLocation(MOD_ID, "tfl_blocks"), () -> new ItemStack(MyBlocks.TFL_BLOCK.get()));
	CreativeModeTab TFL_SIGNS = Registry.getItemGroup(new ResourceLocation(MOD_ID, "tfl_signs"), () -> new ItemStack(MyBlocks.BLOCK_ROUNDEL_2.get()));
}
