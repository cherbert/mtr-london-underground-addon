package net.goingunderground.blocks;

import net.goingunderground.MyBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class TFLBlock extends Block {
    public TFLBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
        //world.addParticle(ParticleTypes.FALLING_OBSIDIAN_TEAR, pos.getX(), pos.getY()+0.5D, pos.getZ(), 0,5.5D,0);
        //super.randomDisplayTick(state, world, pos, random);

    }
}
