package net.londonunderground;

import mtr.CreativeModeTabs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import static net.londonunderground.Main.MOD_ID;

public interface MyItems {
	CreativeModeTabs.Wrapper TFL_BLOCKS = new CreativeModeTabs.Wrapper(new ResourceLocation(MOD_ID, "tfl_blocks"), () -> new ItemStack(MyBlocks.TFL_BLOCK.get()));
	CreativeModeTabs.Wrapper TFL_SIGNS = new CreativeModeTabs.Wrapper(new ResourceLocation(MOD_ID, "tfl_signs"), () -> new ItemStack(MyBlocks.BLOCK_ROUNDEL_2.get()));
}
