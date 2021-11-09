//package net.londonunderground.packet;
//
//import mtr.data.SerializedDataBase;
//import mtr.packet.PacketTrainDataBase;
//import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
//import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
////import net.londonunderground.blocks.SoundTimer;
//import net.minecraft.block.entity.BlockEntity;
//import net.minecraft.network.PacketByteBuf;
//import net.minecraft.server.MinecraftServer;
//import net.minecraft.server.network.ServerPlayerEntity;
//import net.minecraft.util.math.BlockPos;
//
//import static net.londonunderground.packet.IPacket.PACKET_OPEN_SOUND_TIMER_SCREEN;
//
//public class PacketTrainDataGuiServer extends PacketTrainDataBase {
//
//    public static void receiveSoundTimerC2S(MinecraftServer minecraftServer, ServerPlayerEntity player, PacketByteBuf packet) {
//        final BlockPos pos = packet.readBlockPos();
//        final String message = packet.readString(SerializedDataBase.PACKET_STRING_READ_LENGTH);
//        minecraftServer.execute(() -> {
//            final BlockEntity entity = player.world.getBlockEntity(pos);
//            if (entity instanceof SoundTimer.TileEntitySoundTimer) {
//                ((SoundTimer.TileEntitySoundTimer) entity).setMessage(message);
//            }
//        });
//    }
//    public static void openSoundTimerScreenS2C(ServerPlayerEntity player, BlockPos blockPos) {
//        final PacketByteBuf packet = PacketByteBufs.create();
//        packet.writeBlockPos(blockPos);
//        ServerPlayNetworking.send(player, PACKET_OPEN_SOUND_TIMER_SCREEN, packet);
//    }
//
//
//}
