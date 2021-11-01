package net.londonunderground;

import mtr.Blocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.londonunderground.packet.PacketTrainDataGuiClient;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.londonunderground.render.RenderPIDS;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.londonunderground.render.RenderDarkTile;
import net.londonunderground.packet.IPacket;
import net.minecraft.client.render.RenderLayer;

public class MainClient implements ClientModInitializer, IPacket {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(Main.DARK_TILE, RenderDarkTile::new);
        BlockEntityRendererRegistry.INSTANCE.register(Main.PIDS_NORTHERN_TILE_ENTITY, dispatcher -> new RenderPIDS<>(dispatcher, 3, 1.5F, 7.5F, 6, 6.5F, 29, true, true, false, 0xFF9900, 0xFF9900));
        BlockRenderLayerMap.INSTANCE.putBlock(MyBlocks.SOUND_TIMER, RenderLayer.getCutout());
        ClientPlayNetworking.registerGlobalReceiver(PACKET_OPEN_SOUND_TIMER_SCREEN, (minecraftClient, handler, packet, sender) -> PacketTrainDataGuiClient.openSoundTimerScreenS2C(minecraftClient, packet));

    }
}
