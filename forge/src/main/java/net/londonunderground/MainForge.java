package net.londonunderground;

import mtr.mappings.BlockEntityMapper;
import mtr.mappings.DeferredRegisterHolder;
import mtr.mappings.RegistryUtilities;
import net.londonunderground.mappings.ForgeUtilities;
import net.minecraft.core.Registry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.MOD_ID)
public class MainForge {

	private static final DeferredRegisterHolder<Item> ITEMS = new DeferredRegisterHolder<>(Main.MOD_ID, Registry.ITEM_REGISTRY);
	private static final DeferredRegisterHolder<Block> BLOCKS = new DeferredRegisterHolder<>(Main.MOD_ID, Registry.BLOCK_REGISTRY);
	private static final DeferredRegisterHolder<BlockEntityType<?>> BLOCK_ENTITY_TYPES = new DeferredRegisterHolder<>(Main.MOD_ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);
	private static final DeferredRegisterHolder<SoundEvent> SOUND_EVENTS = new DeferredRegisterHolder<>(Main.MOD_ID, Registry.SOUND_EVENT_REGISTRY);

	public MainForge() {
		final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ForgeUtilities.registerModEventBus(Main.MOD_ID, eventBus);
		eventBus.register(MTRForgeRegistry.class);
		Main.init(MainForge::registerBlock, MainForge::registerBlockEntityType, MainForge::registerSoundEvent);
		RegistryUtilities.registerCommand((dispatcher, selection) -> PanelCommand.register(dispatcher));
		ITEMS.register();
		BLOCKS.register();
		BLOCK_ENTITY_TYPES.register();
		SOUND_EVENTS.register();
	}

	private static void registerBlock(String path, Block block) {
		BLOCKS.register(path, () -> block);
	}

	private static void registerBlock(String path, Block block, CreativeModeTab itemGroup) {
		registerBlock(path, block);
		ITEMS.register(path, () -> new BlockItem(block, new Item.Properties().tab(itemGroup)));
	}

	private static <T extends BlockEntityMapper> void registerBlockEntityType(String path, BlockEntityType<T> blockEntityType) {
		BLOCK_ENTITY_TYPES.register(path, () -> blockEntityType);
	}

	private static void registerSoundEvent(String path, SoundEvent soundEvent) {
		SOUND_EVENTS.register(path, () -> soundEvent);
	}

	private static class MTRForgeRegistry {

		@SubscribeEvent
		public static void onClientSetupEvent(FMLClientSetupEvent event) {
			MainClient.init();
		}
	}
}
