package net.londonunderground;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public interface MySoundEvents {

	SoundEvent SOUND_EVENT_OUTSIDE_AMBIENT = new SoundEvent(new ResourceLocation(Main.MOD_ID, "cityambient"));
	SoundEvent SOUND_EVENT_SEE_IT_SAY_IT = new SoundEvent(new ResourceLocation(Main.MOD_ID,"seeitsayitsorted"));
	SoundEvent SOUNT_EVENT_TUBE_STATION_AMBIENCE1 = new SoundEvent(new ResourceLocation(Main.MOD_ID, "ambient1"));

}
