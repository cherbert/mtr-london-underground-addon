package net.londonunderground.packet;

import net.londonunderground.Main;
import net.minecraft.util.Identifier;

public interface IPacket {
    Identifier PACKET_OPEN_SOUND_TIMER_SCREEN = new Identifier(Main.MOD_ID, "packet_open_sound_timer_screen");
    Identifier PACKET_SOUND_TIMER_UPDATE = new Identifier(Main.MOD_ID, "packet_sound_timer_update");
    int MAX_PACKET_BYTES = 1048576;
}
