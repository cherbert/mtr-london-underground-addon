package net.londonunderground.forge;

import mtr.mappings.BlockEntityMapper;
import mtr.mappings.BlockEntityRendererMapper;
import mtr.mappings.NetworkUtilities;
import mtr.mappings.RegistryUtilitiesClient;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Consumer;
import java.util.function.Function;

public class RegistryClientImpl {

	public static void registerBlockRenderType(RenderType type, Block block) {
		RegistryUtilitiesClient.registerRenderType(type, block);
	}

	public static void registerItemModelPredicate(String id, Item item, String tag) {
		RegistryUtilitiesClient.registerItemModelPredicate(id, item, tag);
	}

	public static <T extends BlockEntityMapper> void registerTileEntityRenderer(BlockEntityType<T> type, Function<BlockEntityRenderDispatcher, BlockEntityRendererMapper<T>> function) {
		RegistryUtilitiesClient.registerTileEntityRenderer(type, function);
	}

	public static void registerNetworkReceiver(ResourceLocation resourceLocation, Consumer<FriendlyByteBuf> consumer) {
		NetworkUtilities.registerReceiverS2C(resourceLocation, (packet, context) -> consumer.accept(packet));
	}

	public static void registerPlayerJoinEvent(Consumer<LocalPlayer> consumer) {
		RegistryUtilitiesClient.registerPlayerJoinEvent(consumer);
	}

	public static void sendToServer(ResourceLocation id, FriendlyByteBuf packet) {
		NetworkUtilities.sendToServer(id, packet);
	}
}
