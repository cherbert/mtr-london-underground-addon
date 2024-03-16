package net.londonunderground.mod;

import net.londonunderground.mod.render.*;
import org.mtr.mapping.holder.RenderLayer;
import org.mtr.mapping.registry.RegistryClient;

public final class InitClient {

	public static final RegistryClient REGISTRY_CLIENT = new RegistryClient(Init.REGISTRY);

	public static void init() {
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.DARK_TILE, RenderDarkTile::new);
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.TUNNEL_BLOCK_2_SIGNAL, dispatcher -> new RenderTunnelSignalLight<>(dispatcher, true, false, 0xFF00FF00));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.TUNNEL_A2_SIGNAL, dispatcher -> new RenderTunnelSignalLight<>(dispatcher, true, false, 0xFF00FF00));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.PIDS_NORTHERN_TILE_ENTITY, RenderNorthernLinePIDS::new);
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 14 / 16F, 0.2F / 16, 0, 0, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL_NLE_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 14 / 16F, 0.2F / 16, 0, 0, -0.495F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BRITISH_RAIL_UNDERGROUND_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 14 / 16F, 0.2F / 16, 0, 0.09F, -0.480F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL_BIG_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 28 / 16F, 0.4F / 16, 0, 0.5F, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL_BIG_EVEN_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 28 / 16F, 0.4F / 16, -0.5F, 0.5F, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL2_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 14 / 16F, 0.2F / 16, 0, 0, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL2_BIG_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 28 / 16F, 0.4F / 16, 0, 0.5F, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL2_BIG_EVEN_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 28 / 16F, 0.4F / 16, -0.5F, 0.5F, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL3_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 14 / 16F, 0.2F / 16, 0, 0, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL3_BIG_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 28 / 16F, 0.4F / 16, 0, 0.5F, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL3_BIG_EVEN_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 28 / 16F, 0.4F / 16, -0.5F, 0.5F, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL4_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 14 / 16F, 0.2F / 16, 0, 0, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL4_BIG_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 28 / 16F, 0.4F / 16, 0, 0.5F, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL4_BIG_EVEN_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 28 / 16F, 0.4F / 16, -0.5F, 0.5F, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL5_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 14 / 16F, 0.2F / 16, 0, 0, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL5_BIG_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 28 / 16F, 0.4F / 16, 0, 0.5F, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL5_BIG_EVEN_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 28 / 16F, 0.4F / 16, -0.5F, 0.5F, -0.5F, 0, 0xFFB3B3B3, false, "johnston"));

		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL_STATION_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 22 / 13F, 0.22F / 13, 0, 0.21F, 1.046F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL_STATION_TOP_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 22 / 13F, 0.22F / 13, 0.40F, 0.250F, 1.577F, 30, 0xFF000D3D, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL_STATION_TYPE_B_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 22 / 13F, 0.22F / 13, 0.01F, -0.039F, 1.296F, 0, 0xFFB3B3B3, false, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.BLOCK_ROUNDEL_STATION_TYPE_C_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 32 / 5F, 1.32F / 13, 0.01F, 1.739F, 0.596F, 30, 0xFF000000, false, "beeching"));

		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.NAME_PROJECTOR, RenderNameProjector::new);

		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.MORDEN_SIGN_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10 / 16F, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.METROPOLITAN_SIGN_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10 / 16F, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.ELIZABETH_SIGN_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10 / 16F, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));

		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.SIGN_RIVER_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10.2F / 16, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.SIGN_OVERGROUND_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10.2F / 16, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.SIGN_DLR_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10.2F / 16, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.SIGN_TRAMS_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10.2F / 16, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.SIGN_POPPY_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10.2F / 16, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.SIGN_METRO_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10.2F / 16, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.SIGN_LIZZY_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10.2F / 16, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.SIGN_UNDERGROUND_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10.2F / 16, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));
		REGISTRY_CLIENT.registerBlockEntityRenderer(BlockEntityTypes.SIGN_PRIDE_TILE_ENTITY, dispatcher -> new RenderRoundel<>(dispatcher, 15 / 16F, 0.2F / 16, 0, 10.2F / 16, 0.425F / 16, 0, 0xFFB3B3B3, true, "johnston"));

		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.TUNNEL_BLOCK_2_SIGNAL);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.TUNNEL_A2_SIGNAL);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.BRITISH_RAIL_UNDERGROUND);

		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.BLOCK_ROUNDEL_1);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.BLOCK_ROUNDEL_NLE);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.BLOCK_ROUNDEL_1_BIG);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.BLOCK_ROUNDEL_1_BIG_EVEN);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.BLOCK_ROUNDEL_2);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.BLOCK_ROUNDEL_2_BIG);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.BLOCK_ROUNDEL_2_BIG_EVEN);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.BLOCK_ROUNDEL_3);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.BLOCK_ROUNDEL_3_BIG);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.BLOCK_ROUNDEL_3_BIG_EVEN);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.BLOCK_ROUNDEL_4);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.BLOCK_ROUNDEL_4_BIG);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.BLOCK_ROUNDEL_4_BIG_EVEN);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.BLOCK_ROUNDEL_5);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.BLOCK_ROUNDEL_5_BIG);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.BLOCK_ROUNDEL_5_BIG_EVEN);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.ROUNDEL_POLE);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.ROUNDEL_POLE_DLR);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.ROUNDEL_POLE_LIZ);
		REGISTRY_CLIENT.registerBlockRenderType(RenderLayer.getCutout(), Blocks.ROUNDEL_POLE_OVERGROUND);

		// Finish registration
		REGISTRY_CLIENT.init();
	}
}
