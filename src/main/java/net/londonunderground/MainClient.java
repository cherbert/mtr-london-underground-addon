package net.londonunderground;

import net.londonunderground.render.RenderPIDS;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.londonunderground.render.RenderDarkTile;

public class MainClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(Main.DARK_TILE, RenderDarkTile::new);
        BlockEntityRendererRegistry.INSTANCE.register(Main.PIDS_NORTHERN_TILE_ENTITY, dispatcher -> new RenderPIDS<>(dispatcher, 3, 1.5F, 7.5F, 6, 6.5F, 29, true, true, false, 0xFF9900, 0xFF9900));


    }
}
