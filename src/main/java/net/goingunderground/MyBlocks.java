package net.goingunderground;

import mtr.Blocks;
import mtr.block.BlockPlatform;
import net.goingunderground.blocks.ExitSign;
import net.goingunderground.blocks.StationLight;
import net.goingunderground.blocks.TFLBlock;
import net.goingunderground.blocks.TunnelDarknessBlock;
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
    Block STATION_LIGHT = new StationLight(FabricBlockSettings.of(Material.METAL, MapColor.OFF_WHITE).requiresTool().hardness(2).luminance(15).nonOpaque());
    Block EXIT_SIGN = new ExitSign(FabricBlockSettings.of(Material.METAL, MapColor.OFF_WHITE).requiresTool().hardness(2).luminance(15));

}
