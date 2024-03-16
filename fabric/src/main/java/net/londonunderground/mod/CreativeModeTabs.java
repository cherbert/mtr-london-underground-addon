package net.londonunderground.mod;

import org.mtr.mapping.holder.Identifier;
import org.mtr.mapping.holder.ItemConvertible;
import org.mtr.mapping.holder.ItemStack;
import org.mtr.mapping.registry.CreativeModeTabHolder;

public final class CreativeModeTabs {

	static {
		TFL_BLOCKS = Init.REGISTRY.createCreativeModeTabHolder(new Identifier(Init.MOD_ID, "tfl_blocks"), () -> new ItemStack(new ItemConvertible(Blocks.ROUNDEL_POLE.get().data)));
		TFL_STATION = Init.REGISTRY.createCreativeModeTabHolder(new Identifier(Init.MOD_ID, "tfl_station"), () -> new ItemStack(new ItemConvertible(Blocks.STATION_A1.get().data)));
		TFL_SIGNS = Init.REGISTRY.createCreativeModeTabHolder(new Identifier(Init.MOD_ID, "tfl_signs"), () -> new ItemStack(new ItemConvertible(Blocks.BLOCK_ROUNDEL_1.get().data)));
		TFL_LEGACY = Init.REGISTRY.createCreativeModeTabHolder(new Identifier(Init.MOD_ID, "tfl_legacy"), () -> new ItemStack(new ItemConvertible(Blocks.TFL_BLOCK.get().data)));
	}

	public static final CreativeModeTabHolder TFL_BLOCKS;
	public static final CreativeModeTabHolder TFL_STATION;
	public static final CreativeModeTabHolder TFL_SIGNS;
	public static final CreativeModeTabHolder TFL_LEGACY;

	public static void init() {
		Init.LOGGER.info("Registering MTR London Underground Addon creative mode tabs");
	}
}
