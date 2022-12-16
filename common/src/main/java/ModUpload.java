import com.jonafanho.apitools.*;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ModUpload {

	private static final String[] MINECRAFT_VERSIONS = {"1.16.5", "1.17.1", "1.18.2", "1.19.2", "1.19.3"};

	public static void main(String[] args) throws IOException {
		if (args.length == 2) {
			final String[] modVersion = {""};

			NetworkUtils.openConnectionSafeJson("https://www.minecrafttransitrailway.com/libs/latest/latest-lu-addon.json", jsonElement -> modVersion[0] = jsonElement.getAsJsonObject().get("version").getAsString());
			for (final String minecraftVersion : MINECRAFT_VERSIONS) {
				for (final ModLoader modLoader : ModLoader.values()) {
					final String modVersionMtr = modLoader.name + "-" + minecraftVersion + "-" + modVersion[0];
					final String urlMtr = "https://www.minecrafttransitrailway.com/libs/latest/MTR-LU-Addon-" + modLoader.name + "-" + minecraftVersion + "-latest.jar";
					final String fileNameMtr = "MTR-LU-Addon-" + modVersionMtr + ".jar";

					final Map<String, DependencyType> dependenciesCurseForge = new HashMap<>();
					dependenciesCurseForge.put(modLoader == ModLoader.FABRIC ? "fabric-api" : "architectury-api", DependencyType.REQUIRED);
					dependenciesCurseForge.put("minecraft-transit-railway", DependencyType.REQUIRED);
					while (true) {
						final boolean[] success = {false};
						NetworkUtils.openConnectionSafe(urlMtr, inputStream -> success[0] = new ModId("545686", ModProvider.CURSE_FORGE).uploadFile("", modVersionMtr.toUpperCase(Locale.ENGLISH), "", dependenciesCurseForge, modLoader == ModLoader.FABRIC ? ReleaseStatus.RELEASE : ReleaseStatus.BETA, Collections.singleton(minecraftVersion), Collections.singleton(modLoader), false, inputStream, fileNameMtr, args[0]));
						if (success[0]) {
							break;
						}
					}

					if (true) {
						continue;
						// No Modrinth uploads yet
					}

					final Map<String, DependencyType> dependenciesModrinth = new HashMap<>();
					dependenciesModrinth.put(modLoader == ModLoader.FABRIC ? "P7dR8mSH" : "lhGA9TYQ", DependencyType.REQUIRED);
					dependenciesModrinth.put("XKPAmI6u", DependencyType.REQUIRED);
					while (true) {
						final boolean[] success = {false};
						NetworkUtils.openConnectionSafe(urlMtr, inputStream -> success[0] = new ModId("", ModProvider.MODRINTH).uploadFile("The London Underground Addon", modVersionMtr.toUpperCase(Locale.ENGLISH), "", dependenciesModrinth, ReleaseStatus.RELEASE, Collections.singleton(minecraftVersion), Collections.singleton(modLoader), false, inputStream, fileNameMtr, args[1]));
						if (success[0]) {
							break;
						}
					}
				}
			}
		}
	}
}
