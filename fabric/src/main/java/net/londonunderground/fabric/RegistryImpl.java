package net.londonunderground.fabric;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class RegistryImpl {

	public static boolean isModLoaded() {
		return FabricLoader.getInstance().isModLoaded("mtr");
	}

	public static CreativeModeTab getItemGroup(ResourceLocation id, Supplier<ItemStack> supplier) {
		return FabricItemGroupBuilder.build(id, supplier);
	}
}
