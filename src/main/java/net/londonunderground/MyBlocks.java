package net.londonunderground;

import mtr.Blocks;
import mtr.block.BlockPlatform;
import net.londonunderground.blocks.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MapColor;

public interface MyBlocks extends Blocks {
    Block PLATFORM_TFL_1 = new BlockPlatform(FabricBlockSettings.of(Material.METAL, MapColor.YELLOW).requiresTool().hardness(2), true);
    Block PLATFORM_TFL_GAP = new BlockPlatform(FabricBlockSettings.of(Material.METAL, MapColor.YELLOW).requiresTool().hardness(2), true);
    Block PLATFORM_BLOCK = new BlockPlatform(FabricBlockSettings.of(Material.METAL, MapColor.YELLOW).requiresTool().hardness(2), false);
    Block TUNNEL_DARKNESS = new TunnelDarknessBlock(FabricBlockSettings.of(Material.STONE, MapColor.OFF_WHITE).requiresTool().hardness(2).nonOpaque());
    Block TFL_BLOCK = new TFLBlock(FabricBlockSettings.of(Material.METAL, MapColor.OFF_WHITE).requiresTool().hardness(2));
    Block SOUND_OUTSIDE_AMBIENCE = new SoundOutsideAmbience(FabricBlockSettings.of(Material.METAL, MapColor.OFF_WHITE).requiresTool().hardness(2));
    Block SOUND_SEE_IT_SAY_IT_SORTED = new SoundSeeItSayItSorted(FabricBlockSettings.of(Material.METAL, MapColor.OFF_WHITE).requiresTool().hardness(2));
    Block STATION_LIGHT = new StationLight(FabricBlockSettings.of(Material.METAL, MapColor.OFF_WHITE).requiresTool().hardness(2).luminance(15).nonOpaque());
    Block EXIT_SIGN = new ExitSign(FabricBlockSettings.of(Material.METAL, MapColor.OFF_WHITE).requiresTool().hardness(2).luminance(15));
    Block TUNNEL_BLOCK_0 = new BlockTunnel0(FabricBlockSettings.of(Material.METAL, MapColor.OFF_WHITE).noCollision().requiresTool().hardness(2).nonOpaque());
    Block TUNNEL_BLOCK_1 = new BlockTunnel1(FabricBlockSettings.of(Material.METAL, MapColor.OFF_WHITE).requiresTool().hardness(2).nonOpaque());
    Block TUNNEL_BLOCK_2 = new BlockTunnel2(FabricBlockSettings.of(Material.METAL, MapColor.OFF_WHITE).requiresTool().hardness(2).nonOpaque());
    Block TUNNEL_BLOCK_3 = new BlockTunnel3(FabricBlockSettings.of(Material.METAL, MapColor.OFF_WHITE).requiresTool().hardness(2).nonOpaque());
    Block TUNNEL_BLOCK_4 = new BlockTunnel4(FabricBlockSettings.of(Material.METAL, MapColor.OFF_WHITE).requiresTool().hardness(2).nonOpaque());
    Block TUNNEL_BLOCK_5 = new BlockTunnel5(FabricBlockSettings.of(Material.METAL, MapColor.OFF_WHITE).requiresTool().hardness(2).nonOpaque());
    Block NORTHERN_PIDS = new NorthernLinePIDS();
}
