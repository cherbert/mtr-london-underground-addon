package net.londonunderground.fabric;

import mtr.mappings.BlockEntityMapper;
import mtr.mappings.BlockEntityRendererMapper;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.londonunderground.mappings.FabricRegistryUtilities;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Function;

public class RegistryClientImpl {

	public static void registerBlockRenderType(RenderType type, Block block) {
		BlockRenderLayerMap.INSTANCE.putBlock(block, type);
	}

	public static <T extends BlockEntityMapper> void registerTileEntityRenderer(BlockEntityType<T> type, Function<BlockEntityRenderDispatcher, BlockEntityRendererMapper<T>> function) {
		FabricRegistryUtilities.registerTileEntityRenderer(type, function);
	}
}
