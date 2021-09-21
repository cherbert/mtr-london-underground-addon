package net.goingunderground;

import mtr.Blocks;
import mtr.block.BlockPlatform;
import net.goingunderground.blocks.TFLBlock;
import net.goingunderground.blocks.TunnelDarknessBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MapColor;

public interface MyBlocks extends Blocks {
    Block PLATFORM_TFL_1 = new BlockPlatform(FabricBlockSettings.of(Material.METAL, MapColor.YELLOW).requiresTool().hardness(2), true);
    Block TUNNEL_DARKNESS = new TunnelDarknessBlock(FabricBlockSettings.of(Material.AIR, MapColor.OFF_WHITE).requiresTool().air().noCollision());
    Block TFL_BLOCK = new TFLBlock(FabricBlockSettings.of(Material.AIR, MapColor.OFF_WHITE).requiresTool().hardness(2));
}
