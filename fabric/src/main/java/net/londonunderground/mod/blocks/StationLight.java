package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class StationLight extends BlockExtension {

	public static final BooleanProperty FACING = BooleanProperty.of("facing");

	public StationLight(BlockSettings settings) {
		super(settings);
	}

	@Override
	public BlockState getPlacementState2(ItemPlacementContext ctx) {
		boolean facing = ctx.getPlayerFacing().getAxis() == Axis.X;
		return getDefaultState2().with(new Property<>(FACING.data), facing);
	}

	@Nonnull
	@Override
	public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		if (IBlock.getStatePropertySafe(state, FACING)) {
			return BlockHelper.shapeUnion(
					Block.createCuboidShape(0, 14.5, 6, 16, 16, 6.5),
					Block.createCuboidShape(0, 14.5, 9.5, 16, 16, 10),
					Block.createCuboidShape(0, 15, 6.5, 16, 16, 9.5)
			);
		} else {

			return BlockHelper.shapeUnion(
					Block.createCuboidShape(6, 14.5, 0, 6.5, 16, 16),
					Block.createCuboidShape(9.5, 14.5, 0, 10, 16, 16),
					Block.createCuboidShape(6.5, 15, 0, 9.5, 16, 16)
			);
		}
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		builder.add(FACING);
	}
}
