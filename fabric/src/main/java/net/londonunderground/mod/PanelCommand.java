package net.londonunderground.mod;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import org.mtr.mapping.holder.ItemConvertible;
import org.mtr.mapping.holder.ItemStack;
import org.mtr.mapping.holder.Items;
import org.mtr.mapping.holder.ServerPlayerEntity;
import org.mtr.mapping.registry.CommandBuilder;

public final class PanelCommand {

	public static void build(CommandBuilder<?> commandBuilder) {
		commandBuilder.then("panel", commandBuilderPanel -> commandBuilderPanel.then("custom", IntegerArgumentType.integer(), innerCommandBuilder -> innerCommandBuilder.executes(PanelCommand::run)));
	}

	private static int run(CommandBuilder.ContextHandler contextHandler) {
		final ServerPlayerEntity serverPlayerEntity = contextHandler.getServerPlayer();
		if (serverPlayerEntity != null) {
			final ItemStack item = new ItemStack(new ItemConvertible(Items.getIronIngotMapped().data), 1);
			item.getOrCreateTag().putInt("CustomModelData", contextHandler.getInteger("custom"));
			serverPlayerEntity.giveItemStack(item);
		}
		return 1;
	}
}
