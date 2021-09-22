package net.goingunderground;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Thread thread = new Thread() {
			public void run() {
				while (true){
					if(FabricLoader.getInstance().isModLoaded("mtr")) {
						System.out.println("MTR Found!");
						registerBlock("platform_tfl_1", MyBlocks.PLATFORM_TFL_1, MyItems.TFL_BLOCKS);
						registerBlock("platform_tfl_gap", MyBlocks.PLATFORM_TFL_GAP, MyItems.TFL_BLOCKS);
						registerBlock("platform_block", MyBlocks.PLATFORM_BLOCK, MyItems.TFL_BLOCKS);
						registerBlock("tfl_block", MyBlocks.TFL_BLOCK, MyItems.TFL_BLOCKS);
						registerBlock("tunnel_darkness", MyBlocks.TUNNEL_DARKNESS, MyItems.TFL_BLOCKS);
						registerBlock("station_light", MyBlocks.STATION_LIGHT, MyItems.TFL_BLOCKS);
						registerBlock("exit_sign", MyBlocks.EXIT_SIGN, MyItems.TFL_BLOCKS);
						break;
					}
				}
			}
		};
		thread.start();
	}
	private static void registerBlock(String path, Block block) {
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, path), block);
	}

	private static void registerBlock(String path, Block block, ItemGroup itemGroup) {
		registerBlock(path, block);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, path), new BlockItem(block, new Item.Settings().group(itemGroup)));
	}
}
