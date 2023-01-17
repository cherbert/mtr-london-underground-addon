package net.londonunderground;

import mtr.RegistryObject;
import mtr.block.BlockPIDSPole;
import mtr.block.BlockPlatform;
import net.londonunderground.blocks.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public interface MyBlocks {
	RegistryObject<Block> PLATFORM_TFL_1 =new RegistryObject<>(()-> new BlockPlatform(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(2), true));
	RegistryObject<Block> PLATFORM_TFL_ISLAND =new RegistryObject<>(()-> new BlockPlatform(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(2), true));
	RegistryObject<Block> PLATFORM_TFL_GAP =new RegistryObject<>(()-> new BlockPlatform(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(2), true));
	RegistryObject<Block> PLATFORM_BLOCK =new RegistryObject<>(()-> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(2)));
	RegistryObject<Block> PLATFORM_VARIANT =new RegistryObject<>(()-> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(2)));
	RegistryObject<Block> TUNNEL_DARKNESS =new RegistryObject<>(()-> new TunnelDarknessBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> TFL_BLOCK =new RegistryObject<>(()-> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2)));
	RegistryObject<Block> SOUND_OUTSIDE_AMBIENCE =new RegistryObject<>(()-> new SoundOutsideAmbience(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2)));
	RegistryObject<Block> TUBE_STATION_AMBIENCE1 =new RegistryObject<>(()-> new SoundTubeStationAmbience1(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2)));
	RegistryObject<Block> SOUND_SEE_IT_SAY_IT_SORTED =new RegistryObject<>(()-> new SoundSeeItSayItSorted(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2)));
	RegistryObject<Block> STATION_LIGHT =new RegistryObject<>(()-> new StationLight(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).lightLevel(state -> 15).noOcclusion()));
	RegistryObject<Block> EXIT_SIGN =new RegistryObject<>(()-> new ExitSign(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).lightLevel(state -> 15)));
	RegistryObject<Block> TUNNEL_ENTRANCE_1 =new RegistryObject<>(()-> new TunnelEntrance1(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> TUNNEL_BLOCK_0 =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().noCollission().noOcclusion()));
	RegistryObject<Block> TUNNEL_BLOCK_1 =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> TUNNEL_BLOCK_1_DUEL =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> TUNNEL_BLOCK_2 =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> TUNNEL_BLOCK_2_SIGNAL =new RegistryObject<>(()-> new BlockTunnelSignal(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> TUNNEL_BLOCK_2_DUEL =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> TUNNEL_BLOCK_3 =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> TUNNEL_BLOCK_3_DUEL =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> TUNNEL_BLOCK_4 =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> TUNNEL_BLOCK_5 =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));


	RegistryObject<Block> STATION_A1 =new RegistryObject<>(()-> new StationA1(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2)));
	RegistryObject<Block> STATION_A2 =new RegistryObject<>(()-> new StationA2(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2)));
	RegistryObject<Block> STATION_A3 =new RegistryObject<>(()-> new StationA3(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2)));
	RegistryObject<Block> STATION_A4 =new RegistryObject<>(()-> new StationA4(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2)));
	RegistryObject<Block> STATION_A5 =new RegistryObject<>(()-> new StationA5(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2)));
	RegistryObject<Block> STATION_A6 =new RegistryObject<>(()-> new StationA6(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2)));
	RegistryObject<Block> STATION_A7 =new RegistryObject<>(()-> new StationA7(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2)));
	RegistryObject<Block> STATION_A8 =new RegistryObject<>(()-> new StationA8(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2)));
	RegistryObject<Block> STATION_A9 =new RegistryObject<>(()-> new StationA9(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2)));

	RegistryObject<Block> TUBE_0 =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));
	RegistryObject<Block> TUBE_1 =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));
	RegistryObject<Block> TUBE_1_STOP =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));

	RegistryObject<Block> TUBE_1_DUEL =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));
	RegistryObject<Block> TUBE_2 =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> TUBE_2_DUEL =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> TUBE_3 =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));

	RegistryObject<Block> TUBE_0b =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));
	RegistryObject<Block> TUBE_0b_SLAB = new RegistryObject<>(()-> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));
	RegistryObject<Block> TUBE_1b =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));
	RegistryObject<Block> TUBE_1b_STOP =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));

	RegistryObject<Block> TUBE_1b_DUEL =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));
	RegistryObject<Block> TUBE_2b =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> TUBE_2b_DUEL =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> TUBE_3b =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));

	RegistryObject<Block> PIDS_POLE = new RegistryObject<>(() -> new BlockPIDSPole(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(1)));

	RegistryObject<Block> ROUNDEL_POLE = new RegistryObject<>(() -> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(1).noOcclusion().lightLevel(state -> 15)));
	RegistryObject<Block> ROUNDEL_POLE_DLR = new RegistryObject<>(() -> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(1).noOcclusion().lightLevel(state -> 15)));
	RegistryObject<Block> ROUNDEL_POLE_LIZ = new RegistryObject<>(() -> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(1).noOcclusion().lightLevel(state -> 15)));
	RegistryObject<Block> ROUNDEL_POLE_OVERGROUND = new RegistryObject<>(() -> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(1).noOcclusion().lightLevel(state -> 15)));

	RegistryObject<Block> NORTHERN_PIDS =new RegistryObject<>(NorthernLinePIDS::new);
	RegistryObject<Block> TRACK_1 =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> TRACK_2 =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> MORDEN_STAIRS =new RegistryObject<>(()-> new StairBlockExtends(TFL_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> MORDEN_STONE =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> MORDEN_SLAB =new RegistryObject<>(()-> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> MORDEN_COBBLE_SLAB =new RegistryObject<>(()-> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> MORDEN_COBBLESTONE =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> MORDEN_ARCH =new RegistryObject<>(()-> new LUDirectionalBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> MORDEN_SIGN =new RegistryObject<>(()-> new MordenSign(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));
	RegistryObject<Block> METROPOLITAN_SIGN =new RegistryObject<>(()-> new MetropolitanSign(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));
	RegistryObject<Block> ELIZABETH_SIGN =new RegistryObject<>(()-> new ElizabethSign(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));

	RegistryObject<Block> SIGN_RIVER =new RegistryObject<>(()-> new SignRiver(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));
	RegistryObject<Block> SIGN_OVERGROUND =new RegistryObject<>(()-> new SignOverground(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));
	RegistryObject<Block> SIGN_DLR =new RegistryObject<>(()-> new SignDlr(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));
	RegistryObject<Block> SIGN_TRAMS =new RegistryObject<>(()-> new SignTrams(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));
	RegistryObject<Block> SIGN_POPPY =new RegistryObject<>(()-> new SignPoppy(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));
	RegistryObject<Block> SIGN_METRO =new RegistryObject<>(()-> new SignMetro(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));
	RegistryObject<Block> SIGN_LIZZY =new RegistryObject<>(()-> new SignLizzy(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));
	RegistryObject<Block> SIGN_UNDERGROUND =new RegistryObject<>(()-> new SignUnderground(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));
	RegistryObject<Block> SIGN_PRIDE =new RegistryObject<>(()-> new SignPride(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).strength(2).noOcclusion()));

	RegistryObject<Block> MORDEN_STEPS =new RegistryObject<>(()-> new StairBlockExtends(TFL_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> LU_POLE =new RegistryObject<>(()-> new BlockLUPole(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_1 =new RegistryObject<>(()-> new BlockRoundel(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_NLE =new RegistryObject<>(()-> new BlockRoundelNLE(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BRITISH_RAIL_UNDERGROUND =new RegistryObject<>(()-> new BritishRailUnderground(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_1_BIG =new RegistryObject<>(()-> new BlockRoundelBig(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_1_BIG_EVEN =new RegistryObject<>(()-> new BlockRoundelBigEven(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_2 =new RegistryObject<>(()-> new BlockRoundel2(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_2_BIG =new RegistryObject<>(()-> new BlockRoundel2Big(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_2_BIG_EVEN =new RegistryObject<>(()-> new BlockRoundel2BigEven(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_3 =new RegistryObject<>(()-> new BlockRoundel3(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_3_BIG =new RegistryObject<>(()-> new BlockRoundel3Big(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_3_BIG_EVEN =new RegistryObject<>(()-> new BlockRoundel3BigEven(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_4 =new RegistryObject<>(()-> new BlockRoundel4(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_4_BIG =new RegistryObject<>(()-> new BlockRoundel4Big(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_4_BIG_EVEN =new RegistryObject<>(()-> new BlockRoundel4BigEven(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_5 =new RegistryObject<>(()-> new BlockRoundel5(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_5_BIG =new RegistryObject<>(()-> new BlockRoundel5Big(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_5_BIG_EVEN =new RegistryObject<>(()-> new BlockRoundel5BigEven(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_STATION =new RegistryObject<>(()-> new BlockRoundelStation(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_STATION_TYPE_B =new RegistryObject<>(()-> new BlockRoundelStationTypeB(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_STATION_TYPE_C =new RegistryObject<>(()-> new BlockRoundelStationTypeC(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> BLOCK_ROUNDEL_STATION_TOP =new RegistryObject<>(()-> new BlockRoundelStationTop(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> LU_CROSSBAR =new RegistryObject<>(()-> new BlockLUCrossbar(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
}
