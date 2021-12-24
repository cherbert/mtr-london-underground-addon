package net.londonunderground.forge;

import mtr.mappings.BlockEntityMapper;
import mtr.mappings.BlockEntityRendererMapper;
import mtr.mappings.RegistryUtilitiesClient;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Function;

public class RegistryClientImpl {

	public static void registerBlockRenderType(RenderType type, Block block) {
		RegistryUtilitiesClient.registerRenderType(type, block);
	}

	public static <T extends BlockEntityMapper> void registerTileEntityRenderer(BlockEntityType<T> type, Function<BlockEntityRenderDispatcher, BlockEntityRendererMapper<T>> function) {
		RegistryUtilitiesClient.registerTileEntityRenderer(type, function);
	}
}
