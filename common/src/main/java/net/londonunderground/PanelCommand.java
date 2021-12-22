package net.londonunderground;

public class PanelCommand {

//	static RequiredArgumentBuilder<ServerCommandSource, Integer> requiredArgumentBuilder = CommandManager.argument("custom", IntegerArgumentType.integer());
//
//	public static void register() {
//		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
//			dispatcher.register(literal("panel").then(requiredArgumentBuilder.executes(PanelCommand::run)));
//		});
//	}
//
//	public static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
//		final World world = context.getSource().getWorld();
//		final PlayerEntity player = context.getSource().getPlayer();
//		int modelData = IntegerArgumentType.getInteger(context, "custom");
//
//		ItemStack item = new ItemStack(Items.IRON_INGOT, 1);
//		NbtCompound compound = Utilities.getOrCreateNbt(item);
//		compound.putInt("CustomModelData", modelData);
//		player.giveItemStack(item);
//		world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 1, 1);
//		return 1;
//	}
}