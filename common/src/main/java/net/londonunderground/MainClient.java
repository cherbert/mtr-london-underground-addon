package net.londonunderground;

import mtr.RegistryClient;
import net.londonunderground.render.RenderDarkTile;
import net.londonunderground.render.RenderPIDS;
import net.londonunderground.render.RenderRoundel;
import net.londonunderground.render.RenderTunnelSignalLight;
import net.minecraft.client.renderer.RenderType;

public class MainClient {

	public static void init() {
		RegistryClient.registerTileEntityRenderer(MyBlockEntityTypes.DARK_TILE.get(), RenderDarkTile::new);
		RegistryClient.registerTileEntityRenderer(MyBlockEntityTypes.TUNNEL_BLOCK_2_SIGNAL.get(), dispatcher -> new RenderTunnelSignalLight<>(dispatcher, true, false, 0xFF00FF00));
		RegistryClient.registerTileEntityRenderer(MyBlockEntityTypes.PIDS_NORTHERN_TILE_ENTITY.get(), dispatcher -> new RenderPIDS<>(dispatcher, 3, 1.5F, 7.5F, 6, 6.5F, 29, true, true, 0xFF9900, 0xFF9900));
		RegistryClient.registerTileEntityRenderer(MyBlockEntityTypes.BLOCK_ROUNDEL_TILE_ENTITY.get(), dispatcher -> new RenderRoundel<>(dispatcher, 14 / 16F, 0.2F / 16, 0, 0, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));
		RegistryClient.registerTileEntityRenderer(MyBlockEntityTypes.BLOCK_ROUNDEL_BIG_TILE_ENTITY.get(), dispatcher -> new RenderRoundel<>(dispatcher, 28 / 16F, 0.4F / 16, 0, 0.5F, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));
		RegistryClient.registerTileEntityRenderer(MyBlockEntityTypes.BLOCK_ROUNDEL2_TILE_ENTITY.get(), dispatcher -> new RenderRoundel<>(dispatcher, 14 / 16F, 0.2F / 16, 0, 0, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));

		RegistryClient.registerTileEntityRenderer(MyBlockEntityTypes.BLOCK_ROUNDEL_STATION_TILE_ENTITY.get(), dispatcher -> new RenderRoundel<>(dispatcher, 22 / 13F, 0.22F / 13, 0, 0.21F, 1.046F, 0, 0xFFB3B3B3, false, "johnston"));
		RegistryClient.registerTileEntityRenderer(MyBlockEntityTypes.BLOCK_ROUNDEL_STATION_TOP_TILE_ENTITY.get(), dispatcher -> new RenderRoundel<>(dispatcher, 22 / 13F, 0.22F / 13, 0.40F, 0.250F, 1.577F, 30, 0xFF000D3D, false, "johnston"));
		RegistryClient.registerTileEntityRenderer(MyBlockEntityTypes.BLOCK_ROUNDEL_STATION_TYPE_B_TILE_ENTITY.get(), dispatcher -> new RenderRoundel<>(dispatcher, 22 / 13F, 0.22F / 13, 0.01F, -0.039F, 1.296F, 0, 0xFFB3B3B3, false, "johnston"));
		RegistryClient.registerTileEntityRenderer(MyBlockEntityTypes.BLOCK_ROUNDEL_STATION_TYPE_C_TILE_ENTITY.get(), dispatcher -> new RenderRoundel<>(dispatcher, 32 / 5F, 1.32F / 13, 0.01F, 1.739F, 0.596F, 30, 0xFF000000, false, "beeching"));

		RegistryClient.registerTileEntityRenderer(MyBlockEntityTypes.MORDEN_SIGN_TILE_ENTITY.get(), dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10 / 16F, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));
		RegistryClient.registerTileEntityRenderer(MyBlockEntityTypes.ELIZABETH_SIGN_TILE_ENTITY.get(), dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10 / 16F, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));

		RegistryClient.registerTileEntityRenderer(MyBlockEntityTypes.SIGN_RIVER_TILE_ENTITY.get(), dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10.2F / 16, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));
		RegistryClient.registerTileEntityRenderer(MyBlockEntityTypes.SIGN_OVERGROUND_TILE_ENTITY.get(), dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10.2F / 16, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));
		RegistryClient.registerTileEntityRenderer(MyBlockEntityTypes.SIGN_DLR_TILE_ENTITY.get(), dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10.2F / 16, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));
		RegistryClient.registerTileEntityRenderer(MyBlockEntityTypes.SIGN_TRAMS_TILE_ENTITY.get(), dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10.2F / 16, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));
		RegistryClient.registerTileEntityRenderer(MyBlockEntityTypes.SIGN_POPPY_TILE_ENTITY.get(), dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10.2F / 16, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));

		RegistryClient.registerBlockRenderType(RenderType.cutout(), MyBlocks.TUNNEL_BLOCK_2_SIGNAL.get());
		RegistryClient.registerBlockRenderType(RenderType.cutout(), MyBlocks.BLOCK_ROUNDEL_1.get());
		RegistryClient.registerBlockRenderType(RenderType.cutout(), MyBlocks.BLOCK_ROUNDEL_2.get());
		RegistryClient.registerBlockRenderType(RenderType.cutout(), MyBlocks.BLOCK_ROUNDEL_1_BIG.get());
	}
}
