package net.londonunderground.mod.blocks;

import net.londonunderground.mod.SoundEvents;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;

import javax.annotation.Nullable;

public class SoundSeeItSayItSorted extends BlockExtension {

	public SoundSeeItSayItSorted(BlockSettings settings) {
		super(settings);
	}

	@Override
	public void scheduledTick2(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		world.playSound(
				(PlayerEntity) null, // Player - if non-null, will play sound for every nearby player *except* the specified player
				pos, // The position of where the sound will come from
				SoundEvents.SOUND_EVENT_SEE_IT_SAY_IT.get(), // The sound that will play
				SoundCategory.getAmbientMapped(), // This determines which of the volume sliders affect this sound
				3, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
				1 // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
		);

		scheduleBlockTick(new World(world.data), pos, state.getBlock(), 6000);
	}

	@Override
	public void onPlaced2(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
		scheduleBlockTick(world, pos, state.getBlock(), 20);
	}
}
