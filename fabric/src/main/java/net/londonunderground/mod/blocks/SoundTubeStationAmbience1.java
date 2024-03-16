package net.londonunderground.mod.blocks;

import net.londonunderground.mod.SoundEvents;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;

import javax.annotation.Nullable;

public class SoundTubeStationAmbience1 extends BlockExtension {

	public SoundTubeStationAmbience1(BlockSettings settings) {
		super(settings);
	}

	@Override
	public void scheduledTick2(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		world.playSound(
				(PlayerEntity) null, // Player - if non-null, will play sound for every nearby player *except* the specified player
				pos, // The position of where the sound will come from
				SoundEvents.SOUNT_EVENT_TUBE_STATION_AMBIENCE1.get(), // The sound that will play
				SoundCategory.getAmbientMapped(), // This determines which of the volume sliders affect this sound
				5, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
				1 // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
		);

		scheduleBlockTick(new World(world.data), pos, state.getBlock(), 3820);
	}

	@Override
	public void onPlaced2(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
		scheduleBlockTick(world, pos, state.getBlock(), 20);
	}
}
