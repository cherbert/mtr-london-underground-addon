package net.goingunderground.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class TFLBlock extends Block {

    public static final BooleanProperty ISVISIBLE = BooleanProperty.of("isvisible");

    public TFLBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(ISVISIBLE, true));
    }

//    @Override
//    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
//        super.randomDisplayTick(state, world, pos, random);
//        PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 0.2, false);
//        if (player == null) {
//            world.setBlockState(pos, state.with(ISVISIBLE, true));
//        } else {
//            world.setBlockState(pos, state.with(ISVISIBLE, false));
//        }
//
//    }
//
//    @Override
//    public BlockRenderType getRenderType(BlockState state) {
//        if (!state.get(ISVISIBLE)) {
//            return BlockRenderType.INVISIBLE;
//        } else {
//            return BlockRenderType.MODEL;
//        }
//    }
}
