package net.londonunderground;

import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.argument.IdentifierArgumentType;
import net.minecraft.entity.player.PlayerEntity;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Identifier;

import static net.minecraft.server.command.CommandManager.literal;

public class GiveCommand {
    static RequiredArgumentBuilder<ServerCommandSource, Identifier> requiredArgumentBuilder = CommandManager.argument("custom", IdentifierArgumentType.identifier());
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(literal("tfl").then(requiredArgumentBuilder.executes(GiveCommand::run)));
        });
    }

    public static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        final PlayerEntity player = MinecraftClient.getInstance().player;

        System.out.println("Hello World!");
        System.out.println(IdentifierArgumentType.getIdentifier(context,"custom"));
        ItemStack chris = new ItemStack(Items.IRON_INGOT);
        player.giveItemStack(chris);
        return 1;
    }
}