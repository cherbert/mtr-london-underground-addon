package net.londonunderground;

import mtr.CreativeModeTabs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import static net.londonunderground.Main.MOD_ID;

public interface MyItems {
	CreativeModeTabs.Wrapper TFL_BLOCKS = new CreativeModeTabs.Wrapper(new ResourceLocation(MOD_ID, "tfl_blocks"), () -> new ItemStack(MyBlocks.ROUNDEL_POLE.get()));
	CreativeModeTabs.Wrapper TFL_STATION = new CreativeModeTabs.Wrapper(new ResourceLocation(MOD_ID, "tfl_station"), () -> new ItemStack(MyBlocks.STATION_A1.get()));
	CreativeModeTabs.Wrapper TFL_SIGNS = new CreativeModeTabs.Wrapper(new ResourceLocation(MOD_ID, "tfl_signs"), () -> new ItemStack(MyBlocks.BLOCK_ROUNDEL_1.get()));
	CreativeModeTabs.Wrapper TFL_LEGACY = new CreativeModeTabs.Wrapper(new ResourceLocation(MOD_ID, "tfl_legacy"), () -> new ItemStack(MyBlocks.TFL_BLOCK.get()));
}
