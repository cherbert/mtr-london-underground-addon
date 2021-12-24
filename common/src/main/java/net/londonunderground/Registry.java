package net.londonunderground;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class Registry {

	@ExpectPlatform
	public static boolean isModLoaded() {
		throw new AssertionError();
	}
}
