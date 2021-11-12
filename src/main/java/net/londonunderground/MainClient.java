package net.londonunderground;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
//import net.londonunderground.packet.PacketTrainDataGuiClient;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.londonunderground.render.RenderPIDS;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.londonunderground.render.RenderDarkTile;
import net.londonunderground.packet.IPacket;
import net.londonunderground.render.RenderRoundel;
import net.londonunderground.render.RenderTunnelSignalLight;
import net.minecraft.client.render.RenderLayer;

public class MainClient implements ClientModInitializer, IPacket {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(Main.DARK_TILE, RenderDarkTile::new);
        BlockEntityRendererRegistry.INSTANCE.register(Main.TUNNEL_BLOCK_2_SIGNAL, dispatcher -> new RenderTunnelSignalLight<>(dispatcher, true, false, 0xFF00FF00));
        BlockEntityRendererRegistry.INSTANCE.register(Main.PIDS_NORTHERN_TILE_ENTITY, dispatcher -> new RenderPIDS<>(dispatcher, 3, 1.5F, 7.5F, 6, 6.5F, 29, true, true, false, 0xFF9900, 0xFF9900));
        BlockEntityRendererRegistry.INSTANCE.register(Main.BLOCK_ROUNDEL_TILE_ENTITY, RenderRoundel::new);
        BlockRenderLayerMap.INSTANCE.putBlock(MyBlocks.TUNNEL_BLOCK_2_SIGNAL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MyBlocks.BLOCK_ROUNDEL_1, RenderLayer.getCutout());
    }
}
