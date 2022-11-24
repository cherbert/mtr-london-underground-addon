package net.londonunderground;

import mtr.RegistryObject;
import mtr.mappings.BlockEntityMapper;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.BiConsumer;

public class Main {

	public static final String MOD_ID = "londonunderground";

	public static void init(
			RegisterBlockItem registerBlockItem,
			BiConsumer<String,RegistryObject<? extends BlockEntityType<? extends BlockEntityMapper>>> registerBlockEntityType,
			BiConsumer<String, SoundEvent> registerSoundEvent
	) {
		registerBlockItem.accept("tfl_block", MyBlocks.TFL_BLOCK, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("platform_tfl_1", MyBlocks.PLATFORM_TFL_1, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("platform_tfl_island", MyBlocks.PLATFORM_TFL_ISLAND, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("platform_tfl_gap", MyBlocks.PLATFORM_TFL_GAP, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("platform_block", MyBlocks.PLATFORM_BLOCK, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("platform_variant", MyBlocks.PLATFORM_VARIANT, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("sounds/see_it_say_it_sorted", MyBlocks.SOUND_SEE_IT_SAY_IT_SORTED, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("sounds/tube_station_ambience1", MyBlocks.TUBE_STATION_AMBIENCE1, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("sounds/outside_ambience", MyBlocks.SOUND_OUTSIDE_AMBIENCE, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tunnel_darkness", MyBlocks.TUNNEL_DARKNESS, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("station_light", MyBlocks.STATION_LIGHT, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("exit_sign", MyBlocks.EXIT_SIGN, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tunnel_entrance_1", MyBlocks.TUNNEL_ENTRANCE_1, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tunnel_block_0", MyBlocks.TUNNEL_BLOCK_0, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tunnel_block_1", MyBlocks.TUNNEL_BLOCK_1, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tunnel_block_1_duel", MyBlocks.TUNNEL_BLOCK_1_DUEL, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tunnel_block_2", MyBlocks.TUNNEL_BLOCK_2, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tunnel_block_2_duel", MyBlocks.TUNNEL_BLOCK_2_DUEL, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tunnel_block_2_signal", MyBlocks.TUNNEL_BLOCK_2_SIGNAL, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tunnel_block_3", MyBlocks.TUNNEL_BLOCK_3, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tunnel_block_3_duel", MyBlocks.TUNNEL_BLOCK_3_DUEL, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tunnel_block_4", MyBlocks.TUNNEL_BLOCK_4, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tunnel_block_5", MyBlocks.TUNNEL_BLOCK_5, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("morden_arch", MyBlocks.MORDEN_ARCH, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tube_0", MyBlocks.TUBE_0, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tube_1", MyBlocks.TUBE_1, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tube_1_stop", MyBlocks.TUBE_1_STOP, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tube_1_duel", MyBlocks.TUBE_1_DUEL, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tube_2", MyBlocks.TUBE_2, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tube_2_duel", MyBlocks.TUBE_2_DUEL, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tube_3", MyBlocks.TUBE_3, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tube_0b", MyBlocks.TUBE_0b, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tube_0b_slab", MyBlocks.TUBE_0b_SLAB, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tube_1b", MyBlocks.TUBE_1b, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tube_1b_stop", MyBlocks.TUBE_1b_STOP, MyItems.TFL_BLOCKS);

		registerBlockItem.accept("tube_1b_duel", MyBlocks.TUBE_1b_DUEL, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tube_2b", MyBlocks.TUBE_2b, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tube_2b_duel", MyBlocks.TUBE_2b_DUEL, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("tube_3b", MyBlocks.TUBE_3b, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("pids_northern", MyBlocks.NORTHERN_PIDS, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("pids_pole", MyBlocks.PIDS_POLE, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("track_1", MyBlocks.TRACK_1, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("track_2", MyBlocks.TRACK_2, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("morden_stairs", MyBlocks.MORDEN_STAIRS, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("morden_stone", MyBlocks.MORDEN_STONE, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("morden_slab", MyBlocks.MORDEN_SLAB, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("morden_cobble_slab", MyBlocks.MORDEN_COBBLE_SLAB, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("morden_cobblestone", MyBlocks.MORDEN_COBBLESTONE, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("morden_sign", MyBlocks.MORDEN_SIGN, MyItems.TFL_SIGNS);
		registerBlockItem.accept("metropolitan_sign", MyBlocks.METROPOLITAN_SIGN, MyItems.TFL_SIGNS);
		registerBlockItem.accept("elizabeth_sign", MyBlocks.ELIZABETH_SIGN, MyItems.TFL_SIGNS);

		registerBlockItem.accept("sign_underground", MyBlocks.SIGN_UNDERGROUND, MyItems.TFL_SIGNS);
		registerBlockItem.accept("sign_overground", MyBlocks.SIGN_OVERGROUND, MyItems.TFL_SIGNS);
		registerBlockItem.accept("sign_river", MyBlocks.SIGN_RIVER, MyItems.TFL_SIGNS);
		registerBlockItem.accept("sign_dlr", MyBlocks.SIGN_DLR, MyItems.TFL_SIGNS);
		registerBlockItem.accept("sign_lizzy", MyBlocks.SIGN_LIZZY, MyItems.TFL_SIGNS);
		registerBlockItem.accept("sign_trams", MyBlocks.SIGN_TRAMS, MyItems.TFL_SIGNS);
		registerBlockItem.accept("sign_poppy", MyBlocks.SIGN_POPPY, MyItems.TFL_SIGNS);
		registerBlockItem.accept("sign_metro", MyBlocks.SIGN_METRO, MyItems.TFL_SIGNS);
		registerBlockItem.accept("sign_pride", MyBlocks.SIGN_PRIDE, MyItems.TFL_SIGNS);

		registerBlockItem.accept("morden_steps", MyBlocks.MORDEN_STEPS, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("lu_pole", MyBlocks.LU_POLE, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("roundel_pole", MyBlocks.ROUNDEL_POLE, MyItems.TFL_SIGNS);
		registerBlockItem.accept("lu_crossbar", MyBlocks.LU_CROSSBAR, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("block_roundel_1", MyBlocks.BLOCK_ROUNDEL_1, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_nle", MyBlocks.BLOCK_ROUNDEL_NLE, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_1_big", MyBlocks.BLOCK_ROUNDEL_1_BIG, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_1_big_even", MyBlocks.BLOCK_ROUNDEL_1_BIG_EVEN, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_2", MyBlocks.BLOCK_ROUNDEL_2, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_2_big", MyBlocks.BLOCK_ROUNDEL_2_BIG, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_2_big_even", MyBlocks.BLOCK_ROUNDEL_2_BIG_EVEN, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_3", MyBlocks.BLOCK_ROUNDEL_3, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_3_big", MyBlocks.BLOCK_ROUNDEL_3_BIG, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_3_big_even", MyBlocks.BLOCK_ROUNDEL_3_BIG_EVEN, MyItems.TFL_SIGNS);

		registerBlockItem.accept("block_roundel_station", MyBlocks.BLOCK_ROUNDEL_STATION, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("block_roundel_station_type_b", MyBlocks.BLOCK_ROUNDEL_STATION_TYPE_B, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("block_roundel_station_type_c", MyBlocks.BLOCK_ROUNDEL_STATION_TYPE_C, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("block_roundel_station_top", MyBlocks.BLOCK_ROUNDEL_STATION_TOP, MyItems.TFL_BLOCKS);

		registerBlockEntityType.accept("morden_sign", MyBlockEntityTypes.MORDEN_SIGN_TILE_ENTITY);
		registerBlockEntityType.accept("metropolitan_sign", MyBlockEntityTypes.METROPOLITAN_SIGN_TILE_ENTITY);
		registerBlockEntityType.accept("elizabeth_sign", MyBlockEntityTypes.ELIZABETH_SIGN_TILE_ENTITY);

		registerBlockEntityType.accept("sign_river", MyBlockEntityTypes.SIGN_RIVER_TILE_ENTITY);
		registerBlockEntityType.accept("sign_overground", MyBlockEntityTypes.SIGN_OVERGROUND_TILE_ENTITY);
		registerBlockEntityType.accept("sign_lizzy", MyBlockEntityTypes.SIGN_LIZZY_TILE_ENTITY);
		registerBlockEntityType.accept("sign_dlr", MyBlockEntityTypes.SIGN_DLR_TILE_ENTITY);
		registerBlockEntityType.accept("sign_trams", MyBlockEntityTypes.SIGN_TRAMS_TILE_ENTITY);
		registerBlockEntityType.accept("sign_poppy", MyBlockEntityTypes.SIGN_POPPY_TILE_ENTITY);
		registerBlockEntityType.accept("sign_metro", MyBlockEntityTypes.SIGN_METRO_TILE_ENTITY);
		registerBlockEntityType.accept("sign_underground", MyBlockEntityTypes.SIGN_UNDERGROUND_TILE_ENTITY);
		registerBlockEntityType.accept("sign_pride", MyBlockEntityTypes.SIGN_PRIDE_TILE_ENTITY);

		registerBlockItem.accept("british_rail_underground", MyBlocks.BRITISH_RAIL_UNDERGROUND, MyItems.TFL_SIGNS);

		registerBlockEntityType.accept("tunnel_darkness", MyBlockEntityTypes.DARK_TILE);
		registerBlockEntityType.accept("pids_northern", MyBlockEntityTypes.PIDS_NORTHERN_TILE_ENTITY);
		registerBlockEntityType.accept("tunnel_block_2_signal", MyBlockEntityTypes.TUNNEL_BLOCK_2_SIGNAL);
		registerBlockEntityType.accept("block_roundel_1", MyBlockEntityTypes.BLOCK_ROUNDEL_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_nle", MyBlockEntityTypes.BLOCK_ROUNDEL_NLE_TILE_ENTITY);
		registerBlockEntityType.accept("british_rail_underground", MyBlockEntityTypes.BRITISH_RAIL_UNDERGROUND_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_1_big", MyBlockEntityTypes.BLOCK_ROUNDEL_BIG_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_1_big_even", MyBlockEntityTypes.BLOCK_ROUNDEL_BIG_EVEN_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_2", MyBlockEntityTypes.BLOCK_ROUNDEL2_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_2_big", MyBlockEntityTypes.BLOCK_ROUNDEL2_BIG_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_2_big_even", MyBlockEntityTypes.BLOCK_ROUNDEL2_BIG_EVEN_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_3", MyBlockEntityTypes.BLOCK_ROUNDEL3_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_3_big", MyBlockEntityTypes.BLOCK_ROUNDEL3_BIG_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_3_big_even", MyBlockEntityTypes.BLOCK_ROUNDEL3_BIG_EVEN_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_station", MyBlockEntityTypes.BLOCK_ROUNDEL_STATION_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_station_type_b", MyBlockEntityTypes.BLOCK_ROUNDEL_STATION_TYPE_B_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_station_type_c", MyBlockEntityTypes.BLOCK_ROUNDEL_STATION_TYPE_C_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_station_top", MyBlockEntityTypes.BLOCK_ROUNDEL_STATION_TOP_TILE_ENTITY);

		registerSoundEvent.accept("cityambient", MySoundEvents.SOUND_EVENT_OUTSIDE_AMBIENT);
		registerSoundEvent.accept("seeitsayitsorted", MySoundEvents.SOUNT_EVENT_TUBE_STATION_AMBIENCE1);
		registerSoundEvent.accept("ambient1", MySoundEvents.SOUND_EVENT_SEE_IT_SAY_IT);
	}

	@FunctionalInterface
	public interface RegisterBlockItem {
		void accept(String string, RegistryObject<Block> block, CreativeModeTab tab);
	}
}
