package net.londonunderground.render;

import mtr.block.IBlock;
import mtr.data.IGui;
import mtr.data.RailwayData;
import mtr.data.Station;
import mtr.gui.ClientData;
import mtr.gui.IDrawing;
import net.londonunderground.Main;
import net.londonunderground.blocks.BlockRoundelBase;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Style;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.WorldAccess;

import java.util.Locale;

public class RenderRoundel<T extends BlockRoundelBase.TileEntityBlockRoundelBase> extends BlockEntityRenderer<T> implements IGui, IDrawing {

	private final float maxWidth;
	private final float maxScale;
	private final float yOffset;
	private final float zOffset;
	private final float xTilt;
	private final boolean isDoubleSided;
	private static final Style STYLE = Style.EMPTY.withFont(new Identifier(Main.MOD_ID, "johnston"));

	public RenderRoundel(BlockEntityRenderDispatcher dispatcher, float maxWidth, float maxScale, float yOffset, float zOffset, float xTilt, boolean isDoubleSided) {
		super(dispatcher);
		this.maxWidth = maxWidth;
		this.maxScale = maxScale;
		this.yOffset = yOffset;
		this.zOffset = zOffset;
		this.xTilt = xTilt;
		this.isDoubleSided = isDoubleSided;
	}

	@Override
	public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
		if (!entity.shouldRender()) {
			return;
		}

		final WorldAccess world = entity.getWorld();
		if (world == null) {
			return;
		}

		final BlockPos pos = entity.getPos();
		final BlockState state = world.getBlockState(pos);
		final Direction facing = IBlock.getStatePropertySafe(state, BlockRoundelBase.FACING);

		final int color;
		switch (IBlock.getStatePropertySafe(state, BlockRoundelBase.COLOR)) {
			case 1:
				color = ARGB_LIGHT_GRAY;
				break;
			case 2:
				color = ARGB_BLACK;
				break;
			default:
				color = ARGB_WHITE;
				break;
		}

		final Station station = RailwayData.getStation(ClientData.STATIONS, pos);
		final OrderedText roundelText = new LiteralText((station == null ? new TranslatableText("gui.mtr.untitled").getString() : station.name).toUpperCase(Locale.ROOT)).fillStyle(STYLE).asOrderedText();
		final int textWidth = MinecraftClient.getInstance().textRenderer.getWidth(roundelText);

		matrices.push();
		matrices.translate(0.5, 0.5, 0.5);
		matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(-facing.asRotation()));
		matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
		final VertexConsumerProvider.Immediate immediate = VertexConsumerProvider.immediate(Tessellator.getInstance().getBuffer());
		render(matrices, immediate, roundelText, textWidth, color, light);
		if (isDoubleSided) {
			matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180));
			render(matrices, immediate, roundelText, textWidth, color, light);
		}
		immediate.draw();
		matrices.pop();
	}

	private void render(MatrixStack matrices, VertexConsumerProvider.Immediate immediate, OrderedText roundelText, int textWidth, int color, int light) {
		matrices.push();
		matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(xTilt));
		matrices.translate(0, -yOffset, -zOffset - SMALL_OFFSET * 2);

		final float scale = Math.min(maxWidth / textWidth, maxScale);
		matrices.scale(scale, scale, scale);
		matrices.translate(0, -4, 0);
		MinecraftClient.getInstance().textRenderer.draw(roundelText, -textWidth / 2F, 0, 0xFFFFFFFF, false, matrices.peek().getModel(), immediate, false, 0, 190);

		matrices.pop();
	}
}
