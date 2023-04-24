package net.londonunderground.blocks;

import mtr.block.BlockPIDSBaseHorizontal;
import mtr.block.IBlock;
import mtr.mappings.BlockEntityMapper;
import net.londonunderground.MyBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class NorthernLinePIDS extends BlockPIDSBaseHorizontal {

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext collisionContext) {
		VoxelShape shape1 = IBlock.getVoxelShapeByDirection(6, 0, 0, 10, 9, 16, IBlock.getStatePropertySafe(state, FACING));
		VoxelShape shape2 = IBlock.getVoxelShapeByDirection(7.5, 9, 12.5, 8.5, 16, 13.5, IBlock.getStatePropertySafe(state, FACING));
		return Shapes.or(shape1, shape2);
	}

	@Override
	public BlockEntityMapper createBlockEntity(BlockPos pos, BlockState state) {
		return new TileEntityNorthernLinePIDS(pos, state);
	}

	public static class TileEntityNorthernLinePIDS extends TileEntityBlockPIDSBaseHorizontal {

		public TileEntityNorthernLinePIDS(BlockPos pos, BlockState state) {
			super(MyBlockEntityTypes.PIDS_NORTHERN_TILE_ENTITY.get(), pos, state);
		}

		@Override
		public int getMaxArrivals() {
			return 3;
		}
	}
}