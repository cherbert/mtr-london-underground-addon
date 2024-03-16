package net.londonunderground.mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mtr.mapping.registry.Registry;
import org.mtr.mapping.tool.DummyClass;

public final class Init {

	public static final String MOD_ID = "londonunderground";
	public static final Logger LOGGER = LogManager.getLogger("MTRLondonUndergroundAddon");
	public static final Registry REGISTRY = new Registry();

	public static void init() {
		Blocks.init();
		BlockEntityTypes.init();
		CreativeModeTabs.init();
		SoundEvents.init();
		DummyClass.enableLogging();

		REGISTRY.registerCommand("londonunderground", PanelCommand::build, "mtrlu", "lumtr");

		// Finish registration
		REGISTRY.init();
	}
}
