package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.BlockWaterloggable;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class ExitSign extends BlockWaterloggable implements DirectionHelper {

	public ExitSign(BlockSettings settings) {
		super(settings);
	}

	@Nonnull
	@Override
	public BlockState getPlacementState2(ItemPlacementContext itemPlacementContext) {
		return super.getPlacementState2(itemPlacementContext).with(new Property<>(FACING.data), itemPlacementContext.getPlayerFacing().data);
	}

	@Nonnull
	@Override
	public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		final Direction facing = IBlock.getStatePropertySafe(state, FACING);
		return IBlock.getVoxelShapeByDirection(0, 7.5, 0, 16, 15, 8, facing);
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		super.addBlockProperties(builder);
		builder.add(FACING);
	}
}
