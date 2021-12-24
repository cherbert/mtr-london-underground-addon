package net.londonunderground;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class PanelCommand {

	private static final RequiredArgumentBuilder<CommandSourceStack, Integer> REQUIRED_ARGUMENT_BUILDER = Commands.argument("custom", IntegerArgumentType.integer());

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("panel").then(REQUIRED_ARGUMENT_BUILDER.executes(PanelCommand::run)));
	}

	public static int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
		final Level world = context.getSource().getLevel();
		final Player player = context.getSource().getPlayerOrException();
		int modelData = IntegerArgumentType.getInteger(context, "custom");

		ItemStack item = new ItemStack(Items.IRON_INGOT, 1);
		CompoundTag compound = item.getOrCreateTag();
		compound.putInt("CustomModelData", modelData);
		player.addItem(item);
		world.playSound(null, player.blockPosition(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 1, 1);
		return 1;
	}
}
