package net.londonunderground.init;

import net.fabricmc.api.ClientModInitializer;
import net.londonunderground.mod.InitClient;

public class MainFabricClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		InitClient.init();
	}
}
