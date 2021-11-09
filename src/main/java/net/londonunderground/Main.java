package net.londonunderground;

import mtr.Blocks;
import mtr.block.BlockSignalLight1;
import net.londonunderground.blocks.BlockTunnelSignal;
import net.londonunderground.packet.IPacket;
import net.londonunderground.packet.PacketTrainDataGuiServer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.londonunderground.blocks.NorthernLinePIDS;
import net.londonunderground.blocks.SoundTimer;
import net.londonunderground.blocks.TunnelDarknessBlock;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;


public class Main implements ModInitializer, IPacket {
	public static final String MOD_ID = "londonunderground";
	public static final BlockEntityType<TunnelDarknessBlock.TileEntityTunnelDarkness> DARK_TILE = registerTileEntity("tunnel_darkness", TunnelDarknessBlock.TileEntityTunnelDarkness::new, MyBlocks.TUNNEL_DARKNESS);
	public static final BlockEntityType<NorthernLinePIDS.TileEntityNorthernLinePIDS> PIDS_NORTHERN_TILE_ENTITY = registerTileEntity("pids_northern", NorthernLinePIDS.TileEntityNorthernLinePIDS::new, MyBlocks.NORTHERN_PIDS);
	public static final BlockEntityType<SoundTimer.TileEntitySoundTimer> SOUND_TIMER_ENTITY = registerTileEntity("sounds_timer", SoundTimer.TileEntitySoundTimer::new, MyBlocks.SOUND_TIMER);
	public static final BlockEntityType<BlockTunnelSignal.TileEntityTunnelSignalLight1> TUNNEL_BLOCK_2_SIGNAL = registerTileEntity("tunnel_block_2_signal", BlockTunnelSignal.TileEntityTunnelSignalLight1::new, MyBlocks.TUNNEL_BLOCK_2_SIGNAL);


	public static SoundEvent SOUND_EVENT_OUTSIDE_AMBIENT = registerSoundEvent("cityambient");
	public static SoundEvent SOUND_EVENT_SEE_IT_SAY_IT = registerSoundEvent("seeitsayitsorted");
	public static SoundEvent SOUNT_EVENT_TUBE_STATION_AMBIENCE1 = registerSoundEvent("ambient1");



	int ARGB_RED = 0xFFAA0000;

	@Override
	public void onInitialize() {

		while (true){

			if(FabricLoader.getInstance().isModLoaded("mtr")) {
				System.out.println("MTR Found!");
				registerBlock("tfl_block", MyBlocks.TFL_BLOCK, MyItems.TFL_BLOCKS);
				registerBlock("sounds_timer", MyBlocks.SOUND_TIMER, MyItems.TFL_BLOCKS);
				registerBlock("platform_tfl_1", MyBlocks.PLATFORM_TFL_1, MyItems.TFL_BLOCKS);
				registerBlock("platform_tfl_gap", MyBlocks.PLATFORM_TFL_GAP, MyItems.TFL_BLOCKS);
				registerBlock("platform_block", MyBlocks.PLATFORM_BLOCK, MyItems.TFL_BLOCKS);
				registerBlock("sounds/see_it_say_it_sorted", MyBlocks.SOUND_SEE_IT_SAY_IT_SORTED, MyItems.TFL_BLOCKS);
				registerBlock("sounds/tube_station_ambience1", MyBlocks.TUBE_STATION_AMBIENCE1, MyItems.TFL_BLOCKS);
				registerBlock("sounds/outside_ambience", MyBlocks.SOUND_OUTSIDE_AMBIENCE, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_darkness", MyBlocks.TUNNEL_DARKNESS, MyItems.TFL_BLOCKS);
				registerBlock("station_light", MyBlocks.STATION_LIGHT, MyItems.TFL_BLOCKS);
				registerBlock("exit_sign", MyBlocks.EXIT_SIGN, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_entrance_1", MyBlocks.TUNNEL_ENTRANCE_1, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_block_0", MyBlocks.TUNNEL_BLOCK_0, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_block_1", MyBlocks.TUNNEL_BLOCK_1, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_block_1_duel", MyBlocks.TUNNEL_BLOCK_1_DUEL, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_block_2", MyBlocks.TUNNEL_BLOCK_2, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_block_2_duel", MyBlocks.TUNNEL_BLOCK_2_DUEL, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_block_2_signal", MyBlocks.TUNNEL_BLOCK_2_SIGNAL, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_block_3", MyBlocks.TUNNEL_BLOCK_3, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_block_3_duel", MyBlocks.TUNNEL_BLOCK_3_DUEL, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_block_4", MyBlocks.TUNNEL_BLOCK_4, MyItems.TFL_BLOCKS);
				registerBlock("tunnel_block_5", MyBlocks.TUNNEL_BLOCK_5, MyItems.TFL_BLOCKS);
				registerBlock("morden_arch", MyBlocks.MORDEN_ARCH, MyItems.TFL_BLOCKS);
				registerBlock("tube_0", MyBlocks.TUBE_0, MyItems.TFL_BLOCKS);
				registerBlock("tube_1", MyBlocks.TUBE_1, MyItems.TFL_BLOCKS);
				registerBlock("tube_2", MyBlocks.TUBE_2, MyItems.TFL_BLOCKS);
				registerBlock("tube_3", MyBlocks.TUBE_3, MyItems.TFL_BLOCKS);
				registerBlock("pids_northern", MyBlocks.NORTHERN_PIDS, MyItems.TFL_BLOCKS);
				registerBlock("track_1", MyBlocks.TRACK_1, MyItems.TFL_BLOCKS);
				registerBlock("track_2", MyBlocks.TRACK_2, MyItems.TFL_BLOCKS);
				registerBlock("morden_stairs", MyBlocks.MORDEN_STAIRS, MyItems.TFL_BLOCKS);
				registerBlock("morden_stone", MyBlocks.MORDEN_STONE, MyItems.TFL_BLOCKS);
				registerBlock("morden_slab", MyBlocks.MORDEN_SLAB, MyItems.TFL_BLOCKS);
				registerBlock("morden_cobblestone", MyBlocks.MORDEN_COBBLESTONE, MyItems.TFL_BLOCKS);
				registerBlock("morden_sign", MyBlocks.MORDEN_SIGN, MyItems.TFL_BLOCKS);
				registerBlock("morden_steps", MyBlocks.MORDEN_STEPS, MyItems.TFL_BLOCKS);
				registerBlock("lu_pole", MyBlocks.LU_POLE, MyItems.TFL_BLOCKS);
				registerBlock("lu_crossbar", MyBlocks.LU_CROSSBAR, MyItems.TFL_BLOCKS);

				ServerPlayNetworking.registerGlobalReceiver(PACKET_SOUND_TIMER_UPDATE, (minecraftServer, player, handler, packet, sender) -> PacketTrainDataGuiServer.receiveSoundTimerC2S(minecraftServer, player, packet));



				PanelCommand.register();
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
