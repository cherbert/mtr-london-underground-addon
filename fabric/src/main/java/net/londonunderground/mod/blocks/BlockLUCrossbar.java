package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.BlockWaterloggable;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class BlockLUCrossbar extends BlockWaterloggable implements DirectionHelper {

	public BlockLUCrossbar(BlockSettings settings) {
		super(settings);
	}

	@Nonnull
	@Override
	public BlockState getPlacementState2(ItemPlacementContext itemPlacementContext) {
		return super.getPlacementState2(itemPlacementContext).with(new Property<>(FACING.data), itemPlacementContext.getPlayerFacing().data);
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		super.addBlockProperties(builder);
		builder.add(FACING);
	}

	@Nonnull
	@Override
	public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		final Direction facing = IBlock.getStatePropertySafe(state, FACING);
		return BlockHelper.shapeUnion(IBlock.getVoxelShapeByDirection(0, 2, 5, 16, 3, 11, facing), IBlock.getVoxelShapeByDirection(0, 0, 7, 16, 2, 9, facing));
	}
}
