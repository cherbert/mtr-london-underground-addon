//package net.londonunderground.gui;
//
//import net.londonunderground.blocks.SoundTimer;
//import mtr.data.IGui;
//import mtr.gui.IDrawing;
//import net.londonunderground.packet.IPacket;
//import net.londonunderground.packet.PacketTrainDataGuiClient;
//import net.minecraft.block.entity.BlockEntity;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.gui.screen.Screen;
//import net.minecraft.client.gui.widget.TextFieldWidget;
//import net.minecraft.client.util.math.PoseStack;
//import net.minecraft.text.TextComponent;
//import net.minecraft.text.Component;
//import net.minecraft.text.TranslatableComponent;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//
//public class EditSoundTimerScreen extends Screen implements IGui, IPacket {
//
//    private final BlockPos pos;
//    private final String message;
//    private final TextFieldWidget textFieldMessage;
//    private final Component text = Text.translatable("gui.londonunderground.soundtimer_message");
//
//    private static final int MAX_MESSAGE_LENGTH = 256;
//
//    public EditSoundTimerScreen(BlockPos pos) {
//        super(Text.literal(""));
//        this.pos = pos;
//
//
//        client = Minecraft.getInstance();
//        textFieldMessage = new TextFieldWidget(client.textRenderer, 0, 0, 0, SQUARE_SIZE, Text.literal(""));
//
//
//        final World world = client.world;
//        if (world != null) {
//            final BlockEntity entity = world.getBlockEntity(pos);
//            message = entity instanceof SoundTimer.TileEntitySoundTimer ? ((SoundTimer.TileEntitySoundTimer ) entity).getMessage() : "";
//        } else {
//            message = "";
//        }
//    }
//
//    @Override
//    protected void init() {
//        super.init();
//        IDrawing.setPositionAndWidth(textFieldMessage, SQUARE_SIZE + TEXT_FIELD_PADDING / 2, SQUARE_SIZE * 2 + TEXT_FIELD_PADDING / 2, width - SQUARE_SIZE * 2 - TEXT_FIELD_PADDING);
//        textFieldMessage.setMaxLength(MAX_MESSAGE_LENGTH);
//        textFieldMessage.setText(message);
//        addChild(textFieldMessage);
//
//    }
//
//    @Override
//    public void tick() {
//        textFieldMessage.tick();
//    }
//
//    @Override
//    public void onClose() {
//        PacketTrainDataGuiClient.sendSoundTimerC2S(pos, textFieldMessage.getText());
//        super.onClose();
//    }
//
//    @Override
//    public void render(PoseStack matrices, int mouseX, int mouseY, float delta) {
//        try {
//            renderBackground(matrices);
//            textRenderer.draw(matrices, text, SQUARE_SIZE + TEXT_PADDING, SQUARE_SIZE + TEXT_PADDING, ARGB_WHITE);
//            textFieldMessage.render(matrices, mouseX, mouseY, delta);
//            super.render(matrices, mouseX, mouseY, delta);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public boolean isPauseScreen() {
//        return false;
//    }
//}
