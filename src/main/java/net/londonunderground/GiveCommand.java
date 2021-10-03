package net.londonunderground;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

import static net.minecraft.server.command.CommandManager.literal;

public class GiveCommand {
    static RequiredArgumentBuilder<ServerCommandSource, Integer> requiredArgumentBuilder = CommandManager.argument("custom", IntegerArgumentType.integer());
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(literal("tfl").then(requiredArgumentBuilder.executes(GiveCommand::run)));
        });
    }

    public static int run(CommandContext<ServerCommandSource> context) {
        final PlayerEntity player = MinecraftClient.getInstance().player;
        int modelData = IntegerArgumentType.getInteger(context,"custom");

        ItemStack item = new ItemStack(Items.IRON_INGOT, 1);
        NbtCompound compound = new NbtCompound();
        compound.putInt("CustomModelData", modelData);
        item.setTag(compound);
        player.giveItemStack(item);
        return 1;
    }
}