package net.londonunderground.mod;

import net.londonunderground.mod.blocks.*;
import org.mtr.mapping.holder.Block;
import org.mtr.mapping.holder.BlockState;
import org.mtr.mapping.holder.Identifier;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.mapper.SlabBlockExtension;
import org.mtr.mapping.mapper.StairsBlockExtension;
import org.mtr.mapping.registry.BlockRegistryObject;

public final class Blocks {

	static {
		PLATFORM_TFL_1 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "platform_tfl_1"), () -> new Block(new LUPlatform1(BlockHelper.createBlockSettings(true).strength(2), true)), CreativeModeTabs.TFL_BLOCKS);
		PLATFORM_TFL_ISLAND = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "platform_tfl_island"), () -> new Block(new LUPlatform1(BlockHelper.createBlockSettings(true).strength(2), true)), CreativeModeTabs.TFL_BLOCKS);
		PLATFORM_TFL_GAP = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "platform_tfl_gap"), () -> new Block(new LUPlatform1(BlockHelper.createBlockSettings(true).strength(2), true)), CreativeModeTabs.TFL_BLOCKS);

		PLATFORM_BLOCK = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "platform_block"), () -> new Block(new BlockExtension(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_BLOCKS);
		PLATFORM_VARIANT = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "platform_variant"), () -> new Block(new BlockExtension(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_BLOCKS);
		TUNNEL_DARKNESS = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_darkness"), () -> new Block(new TunnelDarknessBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_BLOCKS);
		TFL_BLOCK = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tfl_block"), () -> new Block(new BlockExtension(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_BLOCKS);
		SOUND_OUTSIDE_AMBIENCE = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "sounds/outside_ambience"), () -> new Block(new SoundOutsideAmbience(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_BLOCKS);
		TUBE_STATION_AMBIENCE1 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "sounds/tube_station_ambience1"), () -> new Block(new SoundTubeStationAmbience1(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_BLOCKS);
		SOUND_SEE_IT_SAY_IT_SORTED = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "sounds/see_it_say_it_sorted"), () -> new Block(new SoundSeeItSayItSorted(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_BLOCKS);
		STATION_LIGHT = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_light"), () -> new Block(new StationLight(BlockHelper.createBlockSettings(true, state -> 15).strength(2))), CreativeModeTabs.TFL_BLOCKS);
		EXIT_SIGN = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "exit_sign"), () -> new Block(new ExitSign(BlockHelper.createBlockSettings(true, state -> 15).strength(2))), CreativeModeTabs.TFL_BLOCKS);

		TUNNEL_ENTRANCE_1 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_entrance_1"), () -> new Block(new BlockExtension(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		TUNNEL_A0 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a0"), () -> new Block(new TunnelA0(BlockHelper.createBlockSettings(true).noCollision())), CreativeModeTabs.TFL_STATION);
		TUNNEL_A0_MORDEN = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a0_morden"), () -> new Block(new TunnelA0(BlockHelper.createBlockSettings(true).noCollision())), CreativeModeTabs.TFL_STATION);
		TUNNEL_A1 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a1"), () -> new Block(new TunnelA1(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_STATION);
		TUNNEL_A1_MORDEN = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a1_morden"), () -> new Block(new TunnelA1(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_STATION);
		TUNNEL_A1_DUEL = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a1_duel"), () -> new Block(new TunnelA1Duel(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_STATION);
		TUNNEL_A2 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a2"), () -> new Block(new TunnelA2(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		TUNNEL_A2_NOWIRES = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a2_nowires"), () -> new Block(new TunnelA2NoWires(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		TUNNEL_A2_LIGHT = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a2_light"), () -> new Block(new TunnelA2Light(BlockHelper.createBlockSettings(true, state -> 15).strength(2))), CreativeModeTabs.TFL_STATION);
		TUNNEL_A2_LIGHT_WHITE = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a2_light_white"), () -> new Block(new TunnelA2Light(BlockHelper.createBlockSettings(true, state -> 15).strength(2))), CreativeModeTabs.TFL_STATION);

		TUNNEL_A2_NOWIRES_MORDEN = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a2_nowires_morden"), () -> new Block(new TunnelA2NoWires(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		TUNNEL_A2_SIGNAL = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a2_signal"), () -> new Block(new TunnelA2Signal(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		TUNNEL_A2_DUEL = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a2_duel"), () -> new Block(new TunnelA2Duel(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		TUNNEL_A3 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a3"), () -> new Block(new TunnelA3(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_STATION);
		TUNNEL_A3_NOWIRES = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a3_nowires"), () -> new Block(new TunnelA3NoWires(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_STATION);
		TUNNEL_A3_NOWIRES_MORDEN = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a3_nowires_morden"), () -> new Block(new TunnelA3NoWires(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_STATION);
		TUNNEL_WIRES = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_wires"), () -> new Block(new TunnelWires(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_STATION);
		TUNNEL_A3_DUEL = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a3_duel"), () -> new Block(new TunnelA3Duel(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_STATION);
		TUNNEL_A4 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a4"), () -> new Block(new TunnelA4(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_STATION);
		TUNNEL_A5 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_a5"), () -> new Block(new TunnelA5(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);


		STATION_A1 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a1"), () -> new Block(new StationA1(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A2 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a2"), () -> new Block(new StationA2(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A3_GREEN = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a3_green"), () -> new Block(new StationA3StopMarker(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A3 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a3"), () -> new Block(new StationA3(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A4 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a4"), () -> new Block(new StationA4(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A5 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a5"), () -> new Block(new StationA5(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A6 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a6"), () -> new Block(new StationA6(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A7 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a7"), () -> new Block(new StationA7(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A8 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a8"), () -> new Block(new StationA8(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A9 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a9"), () -> new Block(new StationA9(BlockHelper.createBlockSettings(true, state -> 2).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A9_PIDPOLE = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a9_pidpole"), () -> new Block(new BlockPIDSPoleStation(BlockHelper.createBlockSettings(true, state -> 2).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A1b = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a1b"), () -> new Block(new StationA1(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A2b = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a2b"), () -> new Block(new StationA2(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A3b_GREEN = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a3b_green"), () -> new Block(new StationA3StopMarker(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A3b = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a3b"), () -> new Block(new StationA3(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A4b = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a4b"), () -> new Block(new StationA4(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A5b = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a5b"), () -> new Block(new StationA5(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A6b = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a6b"), () -> new Block(new StationA6(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A7b = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a7b"), () -> new Block(new StationA7(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A8b = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a8b"), () -> new Block(new StationA8(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A9b = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a9b"), () -> new Block(new StationA9(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_STATION);
		STATION_A9b_PIDPOLE = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "station_a9b_pidpole"), () -> new Block(new BlockPIDSPoleStation(BlockHelper.createBlockSettings(true, state -> 2).strength(2))), CreativeModeTabs.TFL_STATION);

		TUBE_0 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tube_0"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_STATION);
		TUBE_0_SLAB = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tube_0_slab"), () -> new Block(new SlabBlockExtension(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_STATION);
		TUBE_0b = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tube_0b"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_STATION);
		TUBE_0b_SLAB = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tube_0b_slab"), () -> new Block(new SlabBlockExtension(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_STATION);


		PIDS_POLE = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "pids_pole"), () -> new Block(new BlockPIDSPole(BlockHelper.createBlockSettings(true).strength(1))), CreativeModeTabs.TFL_BLOCKS);

		ROUNDEL_POLE = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "roundel_pole"), () -> new Block(new LUPoleRoundel(BlockHelper.createBlockSettings(true, state -> 15).strength(1).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		ROUNDEL_POLE_DLR = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "roundel_pole_dlr"), () -> new Block(new LUPoleRoundel(BlockHelper.createBlockSettings(true, state -> 15).strength(1).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		ROUNDEL_POLE_LIZ = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "roundel_pole_liz"), () -> new Block(new LUPoleRoundel(BlockHelper.createBlockSettings(true, state -> 15).strength(1).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		ROUNDEL_POLE_OVERGROUND = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "roundel_pole_overground"), () -> new Block(new LUPoleRoundel(BlockHelper.createBlockSettings(true, state -> 15).strength(1).nonOpaque())), CreativeModeTabs.TFL_SIGNS);

		NORTHERN_PIDS = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "pids_northern"), () -> new Block(new NorthernLinePIDS()), CreativeModeTabs.TFL_BLOCKS);

		MORDEN_STAIRS = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "morden_stairs"), () -> new Block(new StairsBlockExtension(getGenericState(), BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_BLOCKS);
		MORDEN_STONE = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "morden_stone"), () -> new Block(new MordenBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_BLOCKS);
		MORDEN_SLAB = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "morden_slab"), () -> new Block(new SlabBlockExtension(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_BLOCKS);
		MORDEN_COBBLE_SLAB = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "morden_cobble_slab"), () -> new Block(new SlabBlockExtension(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_BLOCKS);
		MORDEN_COBBLESTONE = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "morden_cobblestone"), () -> new Block(new MordenBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_BLOCKS);
		MORDEN_ARCH_NEW = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "morden_arch_new"), () -> new Block(new TunnelA4(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_STATION);
		MORDEN_ARCH_ROOF = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "morden_arch_roof"), () -> new Block(new TunnelA5(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_STATION);
		MORDEN_SIGN = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "morden_sign"), () -> new Block(new MordenSign(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		METROPOLITAN_SIGN = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "metropolitan_sign"), () -> new Block(new MetropolitanSign(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		ELIZABETH_SIGN = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "elizabeth_sign"), () -> new Block(new ElizabethSign(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_SIGNS);

		SIGN_RIVER = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "sign_river"), () -> new Block(new SignRiver(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		SIGN_OVERGROUND = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "sign_overground"), () -> new Block(new SignOverground(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		SIGN_DLR = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "sign_dlr"), () -> new Block(new SignDlr(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		SIGN_TRAMS = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "sign_trams"), () -> new Block(new SignTrams(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		SIGN_POPPY = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "sign_poppy"), () -> new Block(new SignPoppy(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		SIGN_METRO = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "sign_metro"), () -> new Block(new SignMetro(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		SIGN_LIZZY = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "sign_lizzy"), () -> new Block(new SignLizzy(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		SIGN_UNDERGROUND = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "sign_underground"), () -> new Block(new SignUnderground(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		SIGN_PRIDE = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "sign_pride"), () -> new Block(new SignPride(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);

		LU_POLE = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "lu_pole"), () -> new Block(new BlockLUPole(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_BLOCKS);
		LU_CROSSBAR = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "lu_crossbar"), () -> new Block(new BlockLUCrossbar(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_BLOCKS);
		BLOCK_ROUNDEL_1 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_1"), () -> new Block(new BlockRoundel(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		BLOCK_ROUNDEL_NLE = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_nle"), () -> new Block(new BlockRoundelNLE(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		BRITISH_RAIL_UNDERGROUND = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "british_rail_underground"), () -> new Block(new BritishRailUnderground(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		BLOCK_ROUNDEL_1_BIG = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_1_big"), () -> new Block(new BlockRoundelBig(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		BLOCK_ROUNDEL_1_BIG_EVEN = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_1_big_even"), () -> new Block(new BlockRoundelBigEven(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		BLOCK_ROUNDEL_2 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_2"), () -> new Block(new BlockRoundel2(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		BLOCK_ROUNDEL_2_BIG = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_2_big"), () -> new Block(new BlockRoundel2Big(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		BLOCK_ROUNDEL_2_BIG_EVEN = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_2_big_even"), () -> new Block(new BlockRoundel2BigEven(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		BLOCK_ROUNDEL_3 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_3"), () -> new Block(new BlockRoundel3(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		BLOCK_ROUNDEL_3_BIG = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_3_big"), () -> new Block(new BlockRoundel3Big(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		BLOCK_ROUNDEL_3_BIG_EVEN = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_3_big_even"), () -> new Block(new BlockRoundel3BigEven(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		BLOCK_ROUNDEL_4 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_4"), () -> new Block(new BlockRoundel4(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		BLOCK_ROUNDEL_4_BIG = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_4_big"), () -> new Block(new BlockRoundel4Big(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		BLOCK_ROUNDEL_4_BIG_EVEN = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_4_big_even"), () -> new Block(new BlockRoundel4BigEven(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		BLOCK_ROUNDEL_5 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_5"), () -> new Block(new BlockRoundel5(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		BLOCK_ROUNDEL_5_BIG = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_5_big"), () -> new Block(new BlockRoundel5Big(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);
		BLOCK_ROUNDEL_5_BIG_EVEN = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_5_big_even"), () -> new Block(new BlockRoundel5BigEven(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_SIGNS);

		MORDEN_STEPS_LEFT = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "morden_steps_left"), () -> new Block(new MordenStepsLeft(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_BLOCKS);
		MORDEN_STEPS_MIDDLE = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "morden_steps_middle"), () -> new Block(new MordenStepsMiddle(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_BLOCKS);
		MORDEN_STEPS_RIGHT = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "morden_steps_right"), () -> new Block(new MordenStepsRight(BlockHelper.createBlockSettings(true).strength(2))), CreativeModeTabs.TFL_BLOCKS);

		NAME_PROJECTOR = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "name_projector"), () -> new Block(new NameProjector(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_BLOCKS);

		//
		// Legacy Items
		//

		TRACK_1 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "track_1"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TRACK_2 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "track_2"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUBE_1 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tube_1"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUBE_1_STOP = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tube_1_stop"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUBE_1_DUEL = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tube_1_duel"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUBE_2 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tube_2"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUBE_2_DUEL = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tube_2_duel"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUBE_3 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tube_3"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUBE_1b = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tube_1b"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUBE_1b_STOP = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tube_1b_stop"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUBE_1b_DUEL = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tube_1b_duel"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUBE_2b = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tube_2b"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUBE_2b_DUEL = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tube_2b_duel"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUBE_3b = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tube_3b"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);

		MORDEN_STEPS = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "morden_arch"), () -> new Block(new StairBlockExtends(getGenericState(), BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		MORDEN_ARCH = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "morden_steps"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);

		TUNNEL_BLOCK_0 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_block_0"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).noCollision().nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUNNEL_BLOCK_1 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_block_1"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUNNEL_BLOCK_1_DUEL = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_block_1_duel"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUNNEL_BLOCK_2 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_block_2"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUNNEL_BLOCK_2_SIGNAL = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_block_2_duel"), () -> new Block(new BlockTunnelSignal(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUNNEL_BLOCK_2_DUEL = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_block_2_signal"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUNNEL_BLOCK_3 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_block_3"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUNNEL_BLOCK_3_DUEL = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_block_3_duel"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUNNEL_BLOCK_4 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_block_4"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		TUNNEL_BLOCK_5 = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "tunnel_block_5"), () -> new Block(new LUDirectionalBlock(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);

		BLOCK_ROUNDEL_STATION = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_station"), () -> new Block(new BlockRoundelStation(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		BLOCK_ROUNDEL_STATION_TYPE_B = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_station_type_b"), () -> new Block(new BlockRoundelStationTypeB(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		BLOCK_ROUNDEL_STATION_TYPE_C = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_station_type_c"), () -> new Block(new BlockRoundelStationTypeC(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
		BLOCK_ROUNDEL_STATION_TOP = Init.REGISTRY.registerBlockWithBlockItem(new Identifier(Init.MOD_ID, "block_roundel_station_top"), () -> new Block(new BlockRoundelStationTop(BlockHelper.createBlockSettings(true).strength(2).nonOpaque())), CreativeModeTabs.TFL_LEGACY);
	}

	public static final BlockRegistryObject PLATFORM_TFL_1;
	public static final BlockRegistryObject PLATFORM_TFL_ISLAND;
	public static final BlockRegistryObject PLATFORM_TFL_GAP;
	public static final BlockRegistryObject PLATFORM_BLOCK;
	public static final BlockRegistryObject PLATFORM_VARIANT;
	public static final BlockRegistryObject TUNNEL_DARKNESS;
	public static final BlockRegistryObject TFL_BLOCK;
	public static final BlockRegistryObject SOUND_OUTSIDE_AMBIENCE;
	public static final BlockRegistryObject TUBE_STATION_AMBIENCE1;
	public static final BlockRegistryObject SOUND_SEE_IT_SAY_IT_SORTED;
	public static final BlockRegistryObject STATION_LIGHT;
	public static final BlockRegistryObject EXIT_SIGN;
	public static final BlockRegistryObject TUNNEL_ENTRANCE_1;
	public static final BlockRegistryObject TUNNEL_A0;
	public static final BlockRegistryObject TUNNEL_A0_MORDEN;
	public static final BlockRegistryObject TUNNEL_A1;
	public static final BlockRegistryObject TUNNEL_A1_MORDEN;
	public static final BlockRegistryObject TUNNEL_A1_DUEL;
	public static final BlockRegistryObject TUNNEL_A2;
	public static final BlockRegistryObject TUNNEL_A2_NOWIRES;
	public static final BlockRegistryObject TUNNEL_A2_LIGHT;
	public static final BlockRegistryObject TUNNEL_A2_LIGHT_WHITE;
	public static final BlockRegistryObject TUNNEL_A2_NOWIRES_MORDEN;
	public static final BlockRegistryObject TUNNEL_A2_SIGNAL;
	public static final BlockRegistryObject TUNNEL_A2_DUEL;
	public static final BlockRegistryObject TUNNEL_A3;
	public static final BlockRegistryObject TUNNEL_A3_NOWIRES;
	public static final BlockRegistryObject TUNNEL_A3_NOWIRES_MORDEN;
	public static final BlockRegistryObject TUNNEL_WIRES;
	public static final BlockRegistryObject TUNNEL_A3_DUEL;
	public static final BlockRegistryObject TUNNEL_A4;
	public static final BlockRegistryObject TUNNEL_A5;
	public static final BlockRegistryObject STATION_A1;
	public static final BlockRegistryObject STATION_A2;
	public static final BlockRegistryObject STATION_A3_GREEN;
	public static final BlockRegistryObject STATION_A3;
	public static final BlockRegistryObject STATION_A4;
	public static final BlockRegistryObject STATION_A5;
	public static final BlockRegistryObject STATION_A6;
	public static final BlockRegistryObject STATION_A7;
	public static final BlockRegistryObject STATION_A8;
	public static final BlockRegistryObject STATION_A9;
	public static final BlockRegistryObject STATION_A9_PIDPOLE;
	public static final BlockRegistryObject STATION_A1b;
	public static final BlockRegistryObject STATION_A2b;
	public static final BlockRegistryObject STATION_A3b_GREEN;
	public static final BlockRegistryObject STATION_A3b;
	public static final BlockRegistryObject STATION_A4b;
	public static final BlockRegistryObject STATION_A5b;
	public static final BlockRegistryObject STATION_A6b;
	public static final BlockRegistryObject STATION_A7b;
	public static final BlockRegistryObject STATION_A8b;
	public static final BlockRegistryObject STATION_A9b;
	public static final BlockRegistryObject STATION_A9b_PIDPOLE;
	public static final BlockRegistryObject TUBE_0;
	public static final BlockRegistryObject TUBE_0_SLAB;
	public static final BlockRegistryObject TUBE_0b;
	public static final BlockRegistryObject TUBE_0b_SLAB;
	public static final BlockRegistryObject PIDS_POLE;
	public static final BlockRegistryObject ROUNDEL_POLE;
	public static final BlockRegistryObject ROUNDEL_POLE_DLR;
	public static final BlockRegistryObject ROUNDEL_POLE_LIZ;
	public static final BlockRegistryObject ROUNDEL_POLE_OVERGROUND;
	public static final BlockRegistryObject NORTHERN_PIDS;
	public static final BlockRegistryObject MORDEN_STAIRS;
	public static final BlockRegistryObject MORDEN_STONE;
	public static final BlockRegistryObject MORDEN_SLAB;
	public static final BlockRegistryObject MORDEN_COBBLE_SLAB;
	public static final BlockRegistryObject MORDEN_COBBLESTONE;
	public static final BlockRegistryObject MORDEN_ARCH_NEW;
	public static final BlockRegistryObject MORDEN_ARCH_ROOF;
	public static final BlockRegistryObject MORDEN_SIGN;
	public static final BlockRegistryObject METROPOLITAN_SIGN;
	public static final BlockRegistryObject ELIZABETH_SIGN;
	public static final BlockRegistryObject SIGN_RIVER;
	public static final BlockRegistryObject SIGN_OVERGROUND;
	public static final BlockRegistryObject SIGN_DLR;
	public static final BlockRegistryObject SIGN_TRAMS;
	public static final BlockRegistryObject SIGN_POPPY;
	public static final BlockRegistryObject SIGN_METRO;
	public static final BlockRegistryObject SIGN_LIZZY;
	public static final BlockRegistryObject SIGN_UNDERGROUND;
	public static final BlockRegistryObject SIGN_PRIDE;
	public static final BlockRegistryObject LU_POLE;
	public static final BlockRegistryObject BLOCK_ROUNDEL_1;
	public static final BlockRegistryObject BLOCK_ROUNDEL_NLE;
	public static final BlockRegistryObject BRITISH_RAIL_UNDERGROUND;
	public static final BlockRegistryObject BLOCK_ROUNDEL_1_BIG;
	public static final BlockRegistryObject BLOCK_ROUNDEL_1_BIG_EVEN;
	public static final BlockRegistryObject BLOCK_ROUNDEL_2;
	public static final BlockRegistryObject BLOCK_ROUNDEL_2_BIG;
	public static final BlockRegistryObject BLOCK_ROUNDEL_2_BIG_EVEN;
	public static final BlockRegistryObject BLOCK_ROUNDEL_3;
	public static final BlockRegistryObject BLOCK_ROUNDEL_3_BIG;
	public static final BlockRegistryObject BLOCK_ROUNDEL_3_BIG_EVEN;
	public static final BlockRegistryObject BLOCK_ROUNDEL_4;
	public static final BlockRegistryObject BLOCK_ROUNDEL_4_BIG;
	public static final BlockRegistryObject BLOCK_ROUNDEL_4_BIG_EVEN;
	public static final BlockRegistryObject BLOCK_ROUNDEL_5;
	public static final BlockRegistryObject BLOCK_ROUNDEL_5_BIG;
	public static final BlockRegistryObject BLOCK_ROUNDEL_5_BIG_EVEN;
	public static final BlockRegistryObject LU_CROSSBAR;
	public static final BlockRegistryObject MORDEN_STEPS_LEFT;
	public static final BlockRegistryObject MORDEN_STEPS_MIDDLE;
	public static final BlockRegistryObject MORDEN_STEPS_RIGHT;
	public static final BlockRegistryObject NAME_PROJECTOR;
	public static final BlockRegistryObject TRACK_1;
	public static final BlockRegistryObject TRACK_2;
	public static final BlockRegistryObject TUBE_1;
	public static final BlockRegistryObject TUBE_1_STOP;
	public static final BlockRegistryObject TUBE_1_DUEL;
	public static final BlockRegistryObject TUBE_2;
	public static final BlockRegistryObject TUBE_2_DUEL;
	public static final BlockRegistryObject TUBE_3;
	public static final BlockRegistryObject TUBE_1b;
	public static final BlockRegistryObject TUBE_1b_STOP;
	public static final BlockRegistryObject TUBE_1b_DUEL;
	public static final BlockRegistryObject TUBE_2b;
	public static final BlockRegistryObject TUBE_2b_DUEL;
	public static final BlockRegistryObject TUBE_3b;
	public static final BlockRegistryObject MORDEN_STEPS;
	public static final BlockRegistryObject MORDEN_ARCH;
	public static final BlockRegistryObject TUNNEL_BLOCK_0;
	public static final BlockRegistryObject TUNNEL_BLOCK_1;
	public static final BlockRegistryObject TUNNEL_BLOCK_1_DUEL;
	public static final BlockRegistryObject TUNNEL_BLOCK_2;
	public static final BlockRegistryObject TUNNEL_BLOCK_2_SIGNAL;
	public static final BlockRegistryObject TUNNEL_BLOCK_2_DUEL;
	public static final BlockRegistryObject TUNNEL_BLOCK_3;
	public static final BlockRegistryObject TUNNEL_BLOCK_3_DUEL;
	public static final BlockRegistryObject TUNNEL_BLOCK_4;
	public static final BlockRegistryObject TUNNEL_BLOCK_5;
	public static final BlockRegistryObject BLOCK_ROUNDEL_STATION;
	public static final BlockRegistryObject BLOCK_ROUNDEL_STATION_TYPE_B;
	public static final BlockRegistryObject BLOCK_ROUNDEL_STATION_TYPE_C;
	public static final BlockRegistryObject BLOCK_ROUNDEL_STATION_TOP;

	public static void init() {
		Init.LOGGER.info("Registering MTR London Underground Addon blocks");
	}

	private static BlockState getGenericState() {
		return TFL_BLOCK.get().getDefaultState();
	}
}
