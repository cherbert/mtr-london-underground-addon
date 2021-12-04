package net.londonunderground;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import mapper.Utilities;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

import static net.minecraft.server.command.CommandManager.literal;

public class PanelCommand {

    static RequiredArgumentBuilder<ServerCommandSource, Integer> requiredArgumentBuilder = CommandManager.argument("custom", IntegerArgumentType.integer());

    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(literal("panel").then(requiredArgumentBuilder.executes(PanelCommand::run)));
        });
    }

    public static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        final World world = context.getSource().getWorld();
        final PlayerEntity player = context.getSource().getPlayer();
        int modelData = IntegerArgumentType.getInteger(context,"custom");

        ItemStack item = new ItemStack(Items.IRON_INGOT, 1);
        NbtCompound compound = Utilities.getOrCreateNbt(item);
        compound.putInt("CustomModelData", modelData);
        player.giveItemStack(item);
        world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.BLOCKS, 1, 1);
        return 1;
    }
}