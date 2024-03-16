package net.londonunderground.init;

import net.fabricmc.api.ModInitializer;
import net.londonunderground.mod.Init;

public class MainFabric implements ModInitializer {

	@Override
	public void onInitialize() {
		Init.init();
	}
}
