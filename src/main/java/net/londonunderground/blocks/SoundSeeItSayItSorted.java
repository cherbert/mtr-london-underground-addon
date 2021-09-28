package net.londonunderground.blocks;

import net.londonunderground.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class SoundSeeItSayItSorted extends Block {

    public SoundSeeItSayItSorted(Settings settings) {
        super(settings);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {

        System.out.println("play");
        world.playSound(
                null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                pos, // The position of where the sound will come from
                Main.SOUND_EVENT_SEE_IT_SAY_IT, // The sound that will play
                SoundCategory.AMBIENT, // This determines which of the volume sliders affect this sound
                3, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                1 // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
        );

        world.getBlockTickScheduler().schedule(pos, state.getBlock(), 700);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        world.getBlockTickScheduler().schedule(pos, state.getBlock(), 20);
    }
}
