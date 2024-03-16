package net.londonunderground.mod;

import org.mtr.mapping.holder.Identifier;
import org.mtr.mapping.registry.SoundEventRegistryObject;

public final class SoundEvents {

	static {
		SOUND_EVENT_OUTSIDE_AMBIENT = Init.REGISTRY.registerSoundEvent(new Identifier(Init.MOD_ID, "cityambient"));
		SOUND_EVENT_SEE_IT_SAY_IT = Init.REGISTRY.registerSoundEvent(new Identifier(Init.MOD_ID, "seeitsayitsorted"));
		SOUNT_EVENT_TUBE_STATION_AMBIENCE1 = Init.REGISTRY.registerSoundEvent(new Identifier(Init.MOD_ID, "ambient1"));
	}

	public static final SoundEventRegistryObject SOUND_EVENT_OUTSIDE_AMBIENT;
	public static final SoundEventRegistryObject SOUND_EVENT_SEE_IT_SAY_IT;
	public static final SoundEventRegistryObject SOUNT_EVENT_TUBE_STATION_AMBIENCE1;

	public static void init() {
		Init.LOGGER.info("Registering MTR London Underground Addon sound events");
	}
}
