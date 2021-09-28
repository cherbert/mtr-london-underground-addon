package net.londonunderground;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.londonunderground.blocks.NorthernLinePIDS;
import net.londonunderground.blocks.TunnelDarknessBlock;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class Main implements ModInitializer {
	public static final String MOD_ID = "londonunderground";
	public static final BlockEntityType<TunnelDarknessBlock.TileEntityTunnelDarkness> DARK_TILE = registerTileEntity("tunnel_darkness", TunnelDarknessBlock.TileEntityTunnelDarkness::new, MyBlocks.TUNNEL_DARKNESS);
	public static final BlockEntityType<NorthernLinePIDS.TileEntityNorthernLinePIDS> PIDS_NORTHERN_TILE_ENTITY = registerTileEntity("pids_northern", NorthernLinePIDS.TileEntityNorthernLinePIDS::new, MyBlocks.NORTHERN_PIDS);

	public static SoundEvent SOUND_EVENT_OUTSIDE_AMBIENT = registerSoundEvent("cityambient");
	public static SoundEvent SOUND_EVENT_SEE_IT_SAY_IT = registerSoundEvent("seeitsayitsorted");


	@Override
	public void onInitialize() {
		while (true){
			if(FabricLoader.getInstance().isModLoaded("mtr")) {
				System.out.println("MTR Found!");
				registerBlock("platform_tfl_1", MyBlocks.PLATFORM_TFL_1, MyItems.TFL_BLOCKS);
				registerBlock("platform_tfl_gap", MyBlocks.PLATFORM_TFL_GAP, MyItems.TFL_BLOCKS);
				registerBlock("platform_block", MyBlocks.PLATFORM_BLOCK, MyItems.TFL_BLOCKS);
				registerBlock("tfl_block", MyBlocks.TFL_BLOCK, MyItems.TFL_BLOCKS);
				registerBlock("sounds/see_it_say_it_sorted", MyBlocks.SOUND_SEE_IT_SAY_IT_SORTED, MyItems.TFL_BLOCKS);
				registerBlock("sounds/outside_ambience", MyBlocks.SOUND_OUTSIDE_AMBIENCE, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_darkness", MyBlocks.TUNNEL_DARKNESS, MyItems.TFL_BLOCKS);
				registerBlock("station_light", MyBlocks.STATION_LIGHT, MyItems.TFL_BLOCKS);
				registerBlock("exit_sign", MyBlocks.EXIT_SIGN, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_block_0", MyBlocks.TUNNEL_BLOCK_0, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_block_1", MyBlocks.TUNNEL_BLOCK_1, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_block_2", MyBlocks.TUNNEL_BLOCK_2, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_block_3", MyBlocks.TUNNEL_BLOCK_3, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_block_4", MyBlocks.TUNNEL_BLOCK_4, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_block_5", MyBlocks.TUNNEL_BLOCK_5, MyItems.TFL_BLOCKS);
				registerBlock("pids_northern", MyBlocks.NORTHERN_PIDS, MyItems.TFL_BLOCKS);

				break;

			}
		}
	}
	private static void registerBlock(String path, Block block) {
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, path), block);
	}

	private static void registerBlock(String path, Block block, ItemGroup itemGroup) {
		registerBlock(path, block);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, path), new BlockItem(block, new Item.Settings().group(itemGroup)));
	}

	private static <T extends BlockEntity> BlockEntityType<T> registerTileEntity(String path, Supplier<T> supplier, Block block) {
		return Registry.register(Registry.BLOCK_ENTITY_TYPE, MOD_ID + ":" + path, BlockEntityType.Builder.create(supplier, block).build(null));
	}

	private static SoundEvent registerSoundEvent(String path) {
		final Identifier id = new Identifier(MOD_ID, path);
		return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
	}

}
