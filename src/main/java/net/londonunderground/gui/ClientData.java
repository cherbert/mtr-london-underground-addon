package net.londonunderground.gui;

import mtr.data.Platform;
import net.minecraft.util.math.BlockPos;

public class ClientData {

    public static Platform getClosePlatform(BlockPos pos) {
        try {
            return mtr.gui.ClientData.PLATFORMS.stream().filter(platform -> platform.isCloseToSavedRail(pos)).findFirst().orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
