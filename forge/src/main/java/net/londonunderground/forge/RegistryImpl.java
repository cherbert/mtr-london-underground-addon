package net.londonunderground.forge;

import mtr.mappings.RegistryUtilities;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class RegistryImpl {

	public static boolean isModLoaded() {
		return true;
	}

	public static CreativeModeTab getItemGroup(ResourceLocation id, Supplier<ItemStack> supplier) {
		return RegistryUtilities.createCreativeTab(id, supplier);
	}
}
