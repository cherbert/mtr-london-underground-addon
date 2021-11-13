package net.londonunderground.render;

import mtr.block.BlockStationNameBase;
import mtr.render.RenderStationNameBase;
import net.londonunderground.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.*;
import net.minecraft.util.Identifier;
import java.util.Locale;

public class RenderRoundel extends RenderStationNameBase {

    final Style style = Style.EMPTY.withFont(new Identifier(Main.MOD_ID, "johnston"));

    public RenderRoundel(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    protected void drawStationName(BlockStationNameBase.TileEntityStationNameBase entity, MatrixStack matrices, VertexConsumerProvider vertexConsumers, VertexConsumerProvider.Immediate immediate, String stationName, int color, int light) {
        final OrderedText chris3 = new LiteralText(stationName.toUpperCase(Locale.ROOT)).fillStyle(style).asOrderedText();

        final TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;

        //IDrawing.drawStringWithFont(matrices, textRenderer, immediate, chris3, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, 0, 0, 60, color, false, light, null);
        int buffer = textRenderer.getWidth(chris3);
        float scale = Math.min(0.9F/buffer,0.014F);

        matrices.scale(scale,scale,scale);
        matrices.translate(0,0,-1.0);
        textRenderer.draw(chris3, -(buffer/2), -3, 0xFFB3B3B3, false, matrices.peek().getModel(), vertexConsumers, false, 0, light);
    }

}
