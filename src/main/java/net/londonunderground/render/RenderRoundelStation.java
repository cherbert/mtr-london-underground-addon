package net.londonunderground.render;

import net.londonunderground.Main;
import net.londonunderground.blocks.BlockRoundelBase;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.*;
import net.minecraft.util.Identifier;
import java.util.Locale;

public class RenderRoundelStation extends RenderRoundelBase {

    final Style style = Style.EMPTY.withFont(new Identifier(Main.MOD_ID, "johnston"));

    public RenderRoundelStation(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    protected void drawStationName(BlockRoundelBase.TileEntityBlockRoundelBase entity, MatrixStack matrices, VertexConsumerProvider vertexConsumers, VertexConsumerProvider.Immediate immediate, String stationName, int color, int light) {
        final OrderedText roundelText = new LiteralText(stationName.toUpperCase(Locale.ROOT)).fillStyle(style).asOrderedText();

        final TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;

        int buffer = textRenderer.getWidth(roundelText);
        float scale = Math.min(2.9F/buffer,0.0158F);

        matrices.scale(scale,scale,scale);
        matrices.translate(0,48.5,-97);
        textRenderer.draw(roundelText, -(buffer/2), -3, 0xFFB3B3B3, false, matrices.peek().getModel(), vertexConsumers, false, 0, light);
    }

}
