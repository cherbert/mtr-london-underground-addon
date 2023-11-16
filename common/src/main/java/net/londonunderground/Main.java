package net.londonunderground;

import mtr.CreativeModeTabs;
import mtr.RegistryObject;
import mtr.mappings.BlockEntityMapper;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.BiConsumer;

public class Main {

	public static final String MOD_ID = "londonunderground";

	public static void init(
			RegisterBlockItem registerBlockItem,
			RegisterBlockHide registerBlockHide,
			BiConsumer<String, RegistryObject<? extends BlockEntityType<? extends BlockEntityMapper>>> registerBlockEntityType,
			BiConsumer<String, SoundEvent> registerSoundEvent
	) {
		registerBlockItem.accept("tfl_block", MyBlocks.TFL_BLOCK, MyItems.TFL_BLOCKS); // culled

		// Platform Blocks
		registerBlockItem.accept("platform_tfl_1", MyBlocks.PLATFORM_TFL_1, MyItems.TFL_BLOCKS); // culled
		registerBlockItem.accept("platform_tfl_island", MyBlocks.PLATFORM_TFL_ISLAND, MyItems.TFL_BLOCKS); // culled
		registerBlockItem.accept("platform_tfl_gap", MyBlocks.PLATFORM_TFL_GAP, MyItems.TFL_BLOCKS); // culled
		registerBlockItem.accept("platform_block", MyBlocks.PLATFORM_BLOCK, MyItems.TFL_BLOCKS); // culled
		registerBlockItem.accept("platform_variant", MyBlocks.PLATFORM_VARIANT, MyItems.TFL_BLOCKS); //culled

		registerBlockItem.accept("sounds/see_it_say_it_sorted", MyBlocks.SOUND_SEE_IT_SAY_IT_SORTED, MyItems.TFL_BLOCKS); // culled
		registerBlockItem.accept("sounds/tube_station_ambience1", MyBlocks.TUBE_STATION_AMBIENCE1, MyItems.TFL_BLOCKS); // culled
		registerBlockItem.accept("sounds/outside_ambience", MyBlocks.SOUND_OUTSIDE_AMBIENCE, MyItems.TFL_BLOCKS); // culled

		registerBlockItem.accept("tunnel_darkness", MyBlocks.TUNNEL_DARKNESS, MyItems.TFL_BLOCKS); // culled
		registerBlockItem.accept("station_light", MyBlocks.STATION_LIGHT, MyItems.TFL_BLOCKS); // culled
		registerBlockItem.accept("exit_sign", MyBlocks.EXIT_SIGN, MyItems.TFL_BLOCKS); // culled

		registerBlockItem.accept("station_a1", MyBlocks.STATION_A1, MyItems.TFL_STATION); // culled
		registerBlockItem.accept("station_a2", MyBlocks.STATION_A2, MyItems.TFL_STATION); // culled
		registerBlockItem.accept("station_a3", MyBlocks.STATION_A3, MyItems.TFL_STATION); // culled
		registerBlockItem.accept("station_a4", MyBlocks.STATION_A4, MyItems.TFL_STATION);
		registerBlockItem.accept("station_a5", MyBlocks.STATION_A5, MyItems.TFL_STATION);
		registerBlockItem.accept("station_a6", MyBlocks.STATION_A6, MyItems.TFL_STATION);
		registerBlockItem.accept("station_a7", MyBlocks.STATION_A7, MyItems.TFL_STATION);
		registerBlockItem.accept("station_a8", MyBlocks.STATION_A8, MyItems.TFL_STATION);
		registerBlockItem.accept("station_a9", MyBlocks.STATION_A9, MyItems.TFL_STATION);

		registerBlockItem.accept("station_a1b", MyBlocks.STATION_A1b, MyItems.TFL_STATION); // culled
		registerBlockItem.accept("station_a2b", MyBlocks.STATION_A2b, MyItems.TFL_STATION); // culled
		registerBlockItem.accept("station_a3b", MyBlocks.STATION_A3b, MyItems.TFL_STATION); // culled
		registerBlockItem.accept("station_a4b", MyBlocks.STATION_A4b, MyItems.TFL_STATION);
		registerBlockItem.accept("station_a5b", MyBlocks.STATION_A5b, MyItems.TFL_STATION);
		registerBlockItem.accept("station_a6b", MyBlocks.STATION_A6b, MyItems.TFL_STATION);
		registerBlockItem.accept("station_a7b", MyBlocks.STATION_A7b, MyItems.TFL_STATION);
		registerBlockItem.accept("station_a8b", MyBlocks.STATION_A8b, MyItems.TFL_STATION);
		registerBlockItem.accept("station_a9b", MyBlocks.STATION_A9b, MyItems.TFL_STATION);

		// Stop Markers
		//registerBlockItem.accept("station_a3_stop", MyBlocks.STATION_A3_STOP, MyItems.TFL_STATION); // culled
		//registerBlockItem.accept("station_a3b_stop", MyBlocks.STATION_A3b_STOP, MyItems.TFL_STATION); // culled
		registerBlockItem.accept("station_a3_green", MyBlocks.STATION_A3_GREEN, MyItems.TFL_STATION); // culled
		registerBlockItem.accept("station_a3b_green", MyBlocks.STATION_A3b_GREEN, MyItems.TFL_STATION); // culled
		registerBlockItem.accept("tunnel_wires", MyBlocks.TUNNEL_WIRES, MyItems.TFL_STATION);

		registerBlockItem.accept("tube_0", MyBlocks.TUBE_0, MyItems.TFL_STATION);
		registerBlockItem.accept("tube_0_slab", MyBlocks.TUBE_0_SLAB, MyItems.TFL_STATION);
		registerBlockItem.accept("tube_0b", MyBlocks.TUBE_0b, MyItems.TFL_STATION);
		registerBlockItem.accept("tube_0b_slab", MyBlocks.TUBE_0b_SLAB, MyItems.TFL_STATION);

		registerBlockItem.accept("tunnel_entrance_1", MyBlocks.TUNNEL_ENTRANCE_1, MyItems.TFL_STATION);
		registerBlockItem.accept("tunnel_a0", MyBlocks.TUNNEL_A0, MyItems.TFL_STATION);
		registerBlockItem.accept("tunnel_a1", MyBlocks.TUNNEL_A1, MyItems.TFL_STATION);

		registerBlockItem.accept("tunnel_a1_duel", MyBlocks.TUNNEL_A1_DUEL, MyItems.TFL_STATION);
		registerBlockItem.accept("tunnel_a2", MyBlocks.TUNNEL_A2, MyItems.TFL_STATION);
		registerBlockItem.accept("tunnel_a2_duel", MyBlocks.TUNNEL_A2_DUEL, MyItems.TFL_STATION);
		registerBlockItem.accept("tunnel_a2_signal", MyBlocks.TUNNEL_A2_SIGNAL, MyItems.TFL_STATION);
		registerBlockItem.accept("tunnel_a2_nowires", MyBlocks.TUNNEL_A2_NOWIRES, MyItems.TFL_STATION);
		registerBlockItem.accept("tunnel_a2_light", MyBlocks.TUNNEL_A2_LIGHT, MyItems.TFL_STATION);

		registerBlockItem.accept("tunnel_a3_duel", MyBlocks.TUNNEL_A3_DUEL, MyItems.TFL_STATION);
		registerBlockItem.accept("tunnel_a3_nowires", MyBlocks.TUNNEL_A3_NOWIRES, MyItems.TFL_STATION);

		registerBlockItem.accept("tunnel_a3", MyBlocks.TUNNEL_A3, MyItems.TFL_STATION);
		registerBlockItem.accept("tunnel_a4", MyBlocks.TUNNEL_A4, MyItems.TFL_STATION);
		registerBlockItem.accept("tunnel_a5", MyBlocks.TUNNEL_A5, MyItems.TFL_STATION);

		registerBlockItem.accept("tunnel_a0_morden", MyBlocks.TUNNEL_A0_MORDEN, MyItems.TFL_STATION);
		registerBlockItem.accept("tunnel_a1_morden", MyBlocks.TUNNEL_A1_MORDEN, MyItems.TFL_STATION);
		registerBlockItem.accept("tunnel_a2_nowires_morden", MyBlocks.TUNNEL_A2_NOWIRES_MORDEN, MyItems.TFL_STATION);
		registerBlockItem.accept("tunnel_a3_nowires_morden", MyBlocks.TUNNEL_A3_NOWIRES_MORDEN, MyItems.TFL_STATION);
		registerBlockItem.accept("morden_arch_new", MyBlocks.MORDEN_ARCH_NEW, MyItems.TFL_STATION);
		registerBlockItem.accept("morden_arch_roof", MyBlocks.MORDEN_ARCH_ROOF, MyItems.TFL_STATION);

		registerBlockItem.accept("station_a9_pidpole", MyBlocks.STATION_A9_PIDPOLE, MyItems.TFL_STATION);
		registerBlockItem.accept("station_a9b_pidpole", MyBlocks.STATION_A9b_PIDPOLE, MyItems.TFL_STATION);

		registerBlockItem.accept("pids_northern", MyBlocks.NORTHERN_PIDS, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("pids_pole", MyBlocks.PIDS_POLE, MyItems.TFL_BLOCKS);

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


		registerBlockItem.accept("morden_stairs", MyBlocks.MORDEN_STAIRS, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("lu_pole", MyBlocks.LU_POLE, MyItems.TFL_BLOCKS);

		registerBlockItem.accept("lu_crossbar", MyBlocks.LU_CROSSBAR, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("block_roundel_1", MyBlocks.BLOCK_ROUNDEL_1, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_1_big", MyBlocks.BLOCK_ROUNDEL_1_BIG, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_1_big_even", MyBlocks.BLOCK_ROUNDEL_1_BIG_EVEN, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_2", MyBlocks.BLOCK_ROUNDEL_2, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_2_big", MyBlocks.BLOCK_ROUNDEL_2_BIG, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_2_big_even", MyBlocks.BLOCK_ROUNDEL_2_BIG_EVEN, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_3", MyBlocks.BLOCK_ROUNDEL_3, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_3_big", MyBlocks.BLOCK_ROUNDEL_3_BIG, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_3_big_even", MyBlocks.BLOCK_ROUNDEL_3_BIG_EVEN, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_4", MyBlocks.BLOCK_ROUNDEL_4, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_4_big", MyBlocks.BLOCK_ROUNDEL_4_BIG, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_4_big_even", MyBlocks.BLOCK_ROUNDEL_4_BIG_EVEN, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_5", MyBlocks.BLOCK_ROUNDEL_5, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_5_big", MyBlocks.BLOCK_ROUNDEL_5_BIG, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_5_big_even", MyBlocks.BLOCK_ROUNDEL_5_BIG_EVEN, MyItems.TFL_SIGNS);

		registerBlockItem.accept("block_roundel_station", MyBlocks.BLOCK_ROUNDEL_STATION, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("block_roundel_station_type_b", MyBlocks.BLOCK_ROUNDEL_STATION_TYPE_B, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("block_roundel_station_type_c", MyBlocks.BLOCK_ROUNDEL_STATION_TYPE_C, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("block_roundel_station_top", MyBlocks.BLOCK_ROUNDEL_STATION_TOP, MyItems.TFL_BLOCKS);

		registerBlockItem.accept("british_rail_underground", MyBlocks.BRITISH_RAIL_UNDERGROUND, MyItems.TFL_SIGNS);
		registerBlockItem.accept("block_roundel_nle", MyBlocks.BLOCK_ROUNDEL_NLE, MyItems.TFL_SIGNS);

		registerBlockItem.accept("roundel_pole", MyBlocks.ROUNDEL_POLE, MyItems.TFL_SIGNS);
		registerBlockItem.accept("roundel_pole_dlr", MyBlocks.ROUNDEL_POLE_DLR, MyItems.TFL_SIGNS);
		registerBlockItem.accept("roundel_pole_liz", MyBlocks.ROUNDEL_POLE_LIZ, MyItems.TFL_SIGNS);
		registerBlockItem.accept("roundel_pole_overground", MyBlocks.ROUNDEL_POLE_OVERGROUND, MyItems.TFL_SIGNS);

		registerBlockItem.accept("morden_steps_left", MyBlocks.MORDEN_STEPS_LEFT, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("morden_steps_middle", MyBlocks.MORDEN_STEPS_MIDDLE, MyItems.TFL_BLOCKS);
		registerBlockItem.accept("morden_steps_right", MyBlocks.MORDEN_STEPS_RIGHT, MyItems.TFL_BLOCKS);



		// Legacy Items

		registerBlockItem.accept("track_1", MyBlocks.TRACK_1, MyItems.TFL_LEGACY);
		registerBlockItem.accept("track_2", MyBlocks.TRACK_2, MyItems.TFL_LEGACY);

		registerBlockItem.accept("tube_1", MyBlocks.TUBE_1, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tube_1_stop", MyBlocks.TUBE_1_STOP, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tube_1_duel", MyBlocks.TUBE_1_DUEL, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tube_2", MyBlocks.TUBE_2, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tube_2_duel", MyBlocks.TUBE_2_DUEL, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tube_3", MyBlocks.TUBE_3, MyItems.TFL_LEGACY);

		registerBlockItem.accept("tube_1b", MyBlocks.TUBE_1b, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tube_1b_stop", MyBlocks.TUBE_1b_STOP, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tube_1b_duel", MyBlocks.TUBE_1b_DUEL, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tube_2b", MyBlocks.TUBE_2b, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tube_2b_duel", MyBlocks.TUBE_2b_DUEL, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tube_3b", MyBlocks.TUBE_3b, MyItems.TFL_LEGACY);

		registerBlockItem.accept("tunnel_block_0", MyBlocks.TUNNEL_BLOCK_0, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tunnel_block_1", MyBlocks.TUNNEL_BLOCK_1, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tunnel_block_1_duel", MyBlocks.TUNNEL_BLOCK_1_DUEL, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tunnel_block_2", MyBlocks.TUNNEL_BLOCK_2, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tunnel_block_2_duel", MyBlocks.TUNNEL_BLOCK_2_DUEL, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tunnel_block_2_signal", MyBlocks.TUNNEL_BLOCK_2_SIGNAL, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tunnel_block_3", MyBlocks.TUNNEL_BLOCK_3, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tunnel_block_3_duel", MyBlocks.TUNNEL_BLOCK_3_DUEL, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tunnel_block_4", MyBlocks.TUNNEL_BLOCK_4, MyItems.TFL_LEGACY);
		registerBlockItem.accept("tunnel_block_5", MyBlocks.TUNNEL_BLOCK_5, MyItems.TFL_LEGACY);
		registerBlockItem.accept("morden_arch", MyBlocks.MORDEN_ARCH, MyItems.TFL_LEGACY);
		registerBlockItem.accept("morden_steps", MyBlocks.MORDEN_STEPS, MyItems.TFL_LEGACY);



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

		registerBlockEntityType.accept("tunnel_darkness", MyBlockEntityTypes.DARK_TILE);
		registerBlockEntityType.accept("pids_northern", MyBlockEntityTypes.PIDS_NORTHERN_TILE_ENTITY);
		registerBlockEntityType.accept("tunnel_block_2_signal", MyBlockEntityTypes.TUNNEL_BLOCK_2_SIGNAL);
		registerBlockEntityType.accept("tunnel_a2_signal", MyBlockEntityTypes.TUNNEL_A2_SIGNAL);
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
		registerBlockEntityType.accept("block_roundel_4", MyBlockEntityTypes.BLOCK_ROUNDEL4_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_4_big", MyBlockEntityTypes.BLOCK_ROUNDEL4_BIG_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_4_big_even", MyBlockEntityTypes.BLOCK_ROUNDEL4_BIG_EVEN_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_5", MyBlockEntityTypes.BLOCK_ROUNDEL5_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_5_big", MyBlockEntityTypes.BLOCK_ROUNDEL5_BIG_TILE_ENTITY);
		registerBlockEntityType.accept("block_roundel_5_big_even", MyBlockEntityTypes.BLOCK_ROUNDEL5_BIG_EVEN_TILE_ENTITY);

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
		void accept(String string, RegistryObject<Block> block, CreativeModeTabs.Wrapper tab);
	}
	@FunctionalInterface
	public interface RegisterBlockHide {
		void accept(String string, RegistryObject<Block> block);
	}
}
