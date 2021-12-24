package net.londonunderground.fabric;

import net.fabricmc.loader.api.FabricLoader;

public class RegistryImpl {

	public static boolean isModLoaded() {
		return FabricLoader.getInstance().isModLoaded("mtr");
	}
}
