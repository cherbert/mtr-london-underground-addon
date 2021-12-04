package net.londonunderground.render;

import mapper.BlockEntityMapper;
import mtr.gui.IDrawing;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import mtr.render.RenderSignalBase;

public class RenderTunnelSignalLight<T extends BlockEntityMapper> extends RenderSignalBase<T> {

    final boolean redOnTop;
    final int proceedColor;

    public RenderTunnelSignalLight(BlockEntityRenderDispatcher dispatcher, boolean isSingleSided, boolean redOnTop, int proceedColor) {
        super(dispatcher, isSingleSided);
        this.redOnTop = redOnTop;
        this.proceedColor = proceedColor;
    }

    @Override
    protected void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, VertexConsumer vertexConsumer, T entity, float tickDelta, Direction facing, boolean isOccupied, boolean isBackSide) {
        final float y = isOccupied == redOnTop ? 0.25F : 0.4375F;
        IDrawing.drawTexture(matrices, vertexConsumer,-0.25F , y, 0.3125F, -0.0625F, y + 0.1875F, 0.3125F, facing.getOpposite(), isOccupied ? 0xFFFF0000 : proceedColor, MAX_LIGHT_GLOWING);
    }
}
