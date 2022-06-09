package net.londonunderground.blocks;

import mtr.mappings.BlockEntityMapper;
import mtr.mappings.EntityBlockMapper;
import mtr.mappings.Text;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.List;

public abstract class BlockRoundelBase extends HorizontalDirectionalBlock implements EntityBlockMapper {

	public static final IntegerProperty COLOR = IntegerProperty.create("color", 0, 2);

	protected BlockRoundelBase(Properties settings) {
		super(settings);
	}

	@Override
	public void appendHoverText(ItemStack stack, BlockGetter blockGetter, List<Component> tooltip, TooltipFlag tooltipFlag) {
		tooltip.add(Text.translatable("tooltip.londonunderground.block_roundel").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
	}

	public abstract static class TileEntityBlockRoundelBase extends BlockEntityMapper {

		public TileEntityBlockRoundelBase(BlockEntityType<?> type, BlockPos pos, BlockState state) {
			super(type, pos, state);
		}

		public abstract boolean shouldRender();
	}
}
