package net.londonunderground;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class Registry {

	@ExpectPlatform
	public static boolean isModLoaded() {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static CreativeModeTab getItemGroup(ResourceLocation id, Supplier<ItemStack> supplier) {
		throw new AssertionError();
	}
}
