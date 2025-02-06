package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.BlockSettings;
import org.mtr.mapping.holder.BlockState;
import org.mtr.mapping.holder.ItemPlacementContext;
import org.mtr.mapping.holder.Property;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.BlockWaterloggable;

import java.util.List;

public class LUPoleRoundel extends BlockWaterloggable implements DirectionHelper {

	public LUPoleRoundel(BlockSettings settings) {
		super(settings);
	}

	@Override
	public BlockState getPlacementState2(ItemPlacementContext itemPlacementContext) {
		return super.getPlacementState2(itemPlacementContext).with(new Property<>(FACING.data), itemPlacementContext.getPlayerFacing().data);
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		super.addBlockProperties(builder);
		builder.add(FACING);
	}
}
