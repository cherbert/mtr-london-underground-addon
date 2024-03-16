package net.londonunderground.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockHelper;

import javax.annotation.Nonnull;

public class BlockLUPole extends BlockExtension {

	public BlockLUPole(BlockSettings settings) {
		super(settings);
	}

	@Nonnull
	@Override
	public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return BlockHelper.shapeUnion(Block.createCuboidShape(6, 0, 6, 10, 16, 10), Block.createCuboidShape(5, 0, 7, 11, 16, 9), Block.createCuboidShape(7, 0, 5, 9, 16, 11));
	}
}
