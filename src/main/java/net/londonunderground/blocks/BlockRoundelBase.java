package net.londonunderground.blocks;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;

import java.util.List;

public abstract class BlockRoundelBase extends HorizontalFacingBlock implements BlockEntityProvider {

    public static final IntProperty COLOR = IntProperty.of("color", 0, 2);

    protected BlockRoundelBase(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(new TranslatableText("tooltip.londonunderground.block_roundel").setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
    }

    public abstract static class TileEntityBlockRoundelBase extends BlockEntity {

        public final float yOffset;
        public final float zOffset;

        public TileEntityBlockRoundelBase(BlockEntityType<?> type, float yOffset, float zOffset) {
            super(type);
            this.yOffset = zOffset;
            this.zOffset = zOffset;
        }

        public abstract boolean shouldRender();
    }
}
