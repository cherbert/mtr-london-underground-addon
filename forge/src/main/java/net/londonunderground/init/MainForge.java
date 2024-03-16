package net.londonunderground.init;

import net.londonunderground.mod.Init;
import net.londonunderground.mod.InitClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod(Init.MOD_ID)
public class MainForge {

	public MainForge() {
		Init.init();
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> InitClient::init);
	}
}
