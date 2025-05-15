package net.londonunderground.mod.render;

import net.londonunderground.mod.Init;
import net.londonunderground.mod.blocks.NorthernLinePIDS;
import org.mtr.mapping.holder.Identifier;
import org.mtr.mapping.holder.OrderedText;
import org.mtr.mapping.holder.Style;
import org.mtr.mapping.mapper.GraphicsHolder;
import org.mtr.mapping.mapper.TextHelper;
import org.mtr.mod.config.Config;
import org.mtr.mod.generated.lang.TranslationProvider;
import org.mtr.mod.render.RenderPIDS;

public class RenderNorthernLinePIDS extends RenderPIDS<NorthernLinePIDS.TileEntityNorthernLinePIDS> {

	public RenderNorthernLinePIDS(Argument dispatcher) {
		super(dispatcher, 1.5F, 7.5F, 6, 6.5F, 29, true, 1);
	}

	@Override
	public void renderText(GraphicsHolder graphicsHolder, String text, int x, int y, int color) {
		final Style style = Config.getClient().getUseMTRFont() ? Style.getEmptyMapped().withFont(new Identifier(Init.MOD_ID, "london-underground-regular")) : Style.getEmptyMapped();
		final OrderedText orderedText = TextHelper.mutableTextToOrderedText(TextHelper.setStyle(TextHelper.literal(text), style));
		graphicsHolder.drawText(orderedText, x, y, color, false, GraphicsHolder.getDefaultLight());
	}

	@Override
	public String getArrivalString(long arrival, boolean isRealtime, boolean isCjk) {
		if (arrival < 60 && !isCjk) {
			return TextHelper.translatable("gui.londonunderground.arrival_sec").getString();
		} else {
			return super.getArrivalString(arrival, isRealtime, isCjk);
		}
	}
}
