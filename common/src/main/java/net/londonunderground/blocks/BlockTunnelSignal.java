package net.londonunderground.blocks;

import mtr.block.BlockSignalLightBase;
import mtr.block.IBlock;
import net.londonunderground.MyBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockTunnelSignal extends BlockSignalLightBase {
	public BlockTunnelSignal(BlockBehaviour.Properties settings) {
		super(settings);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext) {
		return IBlock.getVoxelShapeByDirection(0, 0, 0, 16, 16, 16, IBlock.getStatePropertySafe(state, FACING));
	}

	@Override
	public mtr.mappings.BlockEntityMapper createBlockEntity(BlockPos pos, BlockState state) {
		return new TileEntityTunnelSignalLight1(pos, state);
	}

	public static class TileEntityTunnelSignalLight1 extends mtr.mappings.BlockEntityMapper {

		public TileEntityTunnelSignalLight1(BlockPos pos, BlockState state) {
			super(MyBlockEntityTypes.TUNNEL_BLOCK_2_SIGNAL, pos, state);
		}
	}
}
