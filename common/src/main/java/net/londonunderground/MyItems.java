package net.londonunderground;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static net.londonunderground.Main.MOD_ID;

public interface MyItems {
	CreativeModeTab TFL_BLOCKS = Registry.getItemGroup(new ResourceLocation(MOD_ID, "tfl_blocks"), () -> new ItemStack(MyBlocks.TFL_BLOCK));
}
