package net.londonunderground.blocks;

import mtr.data.Platform;
import mtr.data.Route;
import mtr.gui.ClientData;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.londonunderground.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

import java.util.*;

public class SoundTimer extends Block implements BlockEntityProvider {

    public static final BooleanProperty POWERED = BooleanProperty.of("powered");
    public static Integer seconds = 9999;

    public SoundTimer(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(POWERED, false));
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.setBlockState(pos, state.with(POWERED, false));
    }

    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(POWERED) ? 15 : 0;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new TileEntitySoundTimer();
    }

    public static class TileEntitySoundTimer extends BlockEntity implements Tickable {

        public TileEntitySoundTimer() {
            super(Main.SOUND_TIMER_ENTITY);
        }

        @Environment(EnvType.CLIENT)
        public double getRenderDistance() {
            return 128.0D;
        }

        @Override
        public void tick() {
            if(!world.isClient) {
                if(seconds == 37) {
                    ServerWorld serverworld = (ServerWorld) world;
                    final Block block = serverworld.getBlockState(pos).getBlock();
                    serverworld.setBlockState(pos, serverworld.getBlockState(pos).with(SoundTimer.POWERED, true));
                    serverworld.getBlockTickScheduler().schedule(pos, block, 20);
                }
            } else if (world != null && world.isClient) {
                final Set<Route.ScheduleEntry> schedules;
                final Platform platform = ClientData.getClosePlatform(pos);
                if (platform == null) {
                    System.out.println("No Platform");
                    return;
                }

                schedules = ClientData.SCHEDULES_FOR_PLATFORM.get(platform.id);
                if (schedules == null) {
                    System.out.println("No Schedule");
                    return;
                }

                final List<Route.ScheduleEntry> scheduleList = new ArrayList<>(schedules);
                Collections.sort(scheduleList);

                final Route.ScheduleEntry currentSchedule = scheduleList.get(0);
                seconds = (int) ((currentSchedule.arrivalMillis - System.currentTimeMillis()) / 1000);

                if(seconds < 60) {
                    System.out.println(seconds);
                } else {
                    System.out.println("Greater than 60");
                }
            }

        }
    }

}