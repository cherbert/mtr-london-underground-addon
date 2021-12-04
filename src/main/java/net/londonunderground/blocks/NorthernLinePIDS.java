package net.londonunderground.blocks;

import mapper.BlockEntityMapper;
import mtr.block.BlockPIDSBase;
import mtr.block.IBlock;
import net.londonunderground.Main;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class NorthernLinePIDS extends BlockPIDSBase {

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		VoxelShape shape1 = IBlock.getVoxelShapeByDirection(6, 0, 0, 10, 9, 16, IBlock.getStatePropertySafe(state, FACING));
		VoxelShape shape2 = IBlock.getVoxelShapeByDirection(7.5, 9, 12.5, 8.5, 16, 13.5, IBlock.getStatePropertySafe(state, FACING));
		return VoxelShapes.union(shape1, shape2);
	}

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new TileEntityNorthernLinePIDS(pos, state);
	}

	public static class TileEntityNorthernLinePIDS extends BlockEntityMapper {

		public TileEntityNorthernLinePIDS(BlockPos pos, BlockState state) {
			super(Main.PIDS_NORTHERN_TILE_ENTITY, pos, state);
		}
	}
}