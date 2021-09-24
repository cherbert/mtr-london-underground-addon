package net.londonunderground;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static net.londonunderground.Main.MOD_ID;

public interface MyItems {
    ItemGroup TFL_BLOCKS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "tfl_blocks"), () -> new ItemStack(MyBlocks.TFL_BLOCK));
}
