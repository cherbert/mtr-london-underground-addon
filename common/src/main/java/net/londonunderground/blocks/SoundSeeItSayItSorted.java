package net.londonunderground.blocks;

import mtr.mappings.BlockMapper;
import mtr.mappings.Utilities;
import net.londonunderground.MySoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class SoundSeeItSayItSorted extends BlockMapper {

	public SoundSeeItSayItSorted(Properties settings) {
		super(settings);
	}

	@Override
	public void tick(BlockState state, ServerLevel world, BlockPos pos) {

//		System.out.println("play");
		world.playSound(
				null, // Player - if non-null, will play sound for every nearby player *except* the specified player
				pos, // The position of where the sound will come from
				MySoundEvents.SOUND_EVENT_SEE_IT_SAY_IT, // The sound that will play
				SoundSource.AMBIENT, // This determines which of the volume sliders affect this sound
				3, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
				1 // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
		);

		Utilities.scheduleBlockTick(world, pos, state.getBlock(), 6000);
	}

	@Override
	public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity livingEntity, ItemStack itemStack) {
		Utilities.scheduleBlockTick(world, pos, state.getBlock(), 20);
	}
}
