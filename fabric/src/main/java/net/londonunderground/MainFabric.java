package net.londonunderground;

import mtr.mappings.BlockEntityMapper;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class MainFabric implements ModInitializer {

	@Override
	public void onInitialize() {
		Main.init(MainFabric::registerBlock, MainFabric::registerBlockEntityType, MainFabric::registerSoundEvent);
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> PanelCommand.register(dispatcher));
	}

	private static void registerBlock(String path, Block block, CreativeModeTab itemGroup) {
		Registry.register(Registry.BLOCK, new ResourceLocation(Main.MOD_ID, path), block);
		Registry.register(Registry.ITEM, new ResourceLocation(Main.MOD_ID, path), new BlockItem(block, new Item.Properties().tab(itemGroup)));
	}

	private static <T extends BlockEntityMapper> void registerBlockEntityType(String path, BlockEntityType<T> blockEntityType) {
		Registry.register(Registry.BLOCK_ENTITY_TYPE, new ResourceLocation(Main.MOD_ID, path), blockEntityType);
	}

	private static void registerSoundEvent(String path, SoundEvent soundEvent) {
		Registry.register(Registry.SOUND_EVENT, new ResourceLocation(Main.MOD_ID, path), soundEvent);
	}
}
