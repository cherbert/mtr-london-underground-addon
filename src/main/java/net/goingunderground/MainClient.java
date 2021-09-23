package net.goingunderground;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.goingunderground.blocks.TunnelDarknessBlock;
import net.minecraft.client.render.RenderLayer;

public class MainClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(Main.DARK_TILE, RenderDarkTile::new);
    }
}
