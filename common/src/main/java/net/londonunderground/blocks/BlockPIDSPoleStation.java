package net.londonunderground.blocks;

import mtr.block.BlockPIDSBaseHorizontal;
import mtr.block.BlockPoleCheckBase;
import mtr.block.IBlock;
import mtr.mappings.Text;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockPIDSPoleStation extends BlockPoleCheckBase {

	public BlockPIDSPoleStation(Properties settings) {
		super(settings);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext) {
		final Direction facing = IBlock.getStatePropertySafe(state, FACING);
		return Shapes.or(
				IBlock.getVoxelShapeByDirection(0,12,0,16, 13, 2, facing),
				IBlock.getVoxelShapeByDirection(0, 13, 0,16, 14, 7, facing),
				IBlock.getVoxelShapeByDirection(0, 14, 0,16, 15, 11, facing),
				IBlock.getVoxelShapeByDirection(0,15,0, 16, 16,16, facing),
				IBlock.getVoxelShapeByDirection(7.5, 0, 12.5, 8.5, 16, 13.5, facing)
		);
	}

	@Override
	protected boolean isBlock(Block block) {
		return true;
	}

	@Override
	protected Component getTooltipBlockText() {
		return Text.translatable("block.mtr.pids_1");
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
}
