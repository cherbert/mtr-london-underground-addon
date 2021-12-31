package net.londonunderground.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import mtr.block.IBlock;
import mtr.config.Config;
import mtr.data.*;
import mtr.gui.ClientData;
import mtr.mappings.BlockEntityMapper;
import mtr.mappings.BlockEntityRendererMapper;
import mtr.render.RenderTrains;
import net.londonunderground.Main;
import net.londonunderground.data.IGui2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;

import java.util.*;

public class RenderPIDS<T extends BlockEntityMapper> extends BlockEntityRendererMapper<T> implements IGui, IGui2 {

	private final float scale;
	private final float totalScaledWidth;
	private final float destinationStart;
	private final float destinationMaxWidth;
	private final float platformMaxWidth;
	private final float arrivalMaxWidth;
	private final int maxArrivals;
	private final float maxHeight;
	private final float startX;
	private final float startY;
	private final float startZ;
	private final boolean rotate90;
	private final boolean renderArrivalNumber;
	private final boolean showAllPlatforms;
	private final int textColor;
	private final int firstTrainColor;
	private final boolean appendDotAfterMin;

	private static final int SWITCH_LANGUAGE_TICKS = 60;
	private static final int CAR_TEXT_COLOR = 0xFF0000;
	private static final int MAX_VIEW_DISTANCE = 64;


	public RenderPIDS(BlockEntityRenderDispatcher dispatcher, int maxArrivals, float startX, float startY, float startZ, float maxHeight, int maxWidth, boolean rotate90, boolean renderArrivalNumber, boolean showAllPlatforms, int textColor, int firstTrainColor, float textPadding, boolean appendDotAfterMin) {
		super(dispatcher);
		scale = 160 * maxArrivals / maxHeight * textPadding;
		totalScaledWidth = scale * maxWidth / 16;
		destinationStart = renderArrivalNumber ? scale * 2 / 16 : 0;
		destinationMaxWidth = totalScaledWidth * 0.7F;
		platformMaxWidth = showAllPlatforms ? scale * 2 / 16 : 0;
		arrivalMaxWidth = totalScaledWidth - destinationStart - destinationMaxWidth - platformMaxWidth;
		this.maxArrivals = maxArrivals;
		this.maxHeight = maxHeight;
		this.startX = startX;
		this.startY = startY;
		this.startZ = startZ;
		this.rotate90 = rotate90;
		this.renderArrivalNumber = renderArrivalNumber;
		this.showAllPlatforms = showAllPlatforms;
		this.textColor = textColor;
		this.firstTrainColor = firstTrainColor;
		this.appendDotAfterMin = appendDotAfterMin;
	}

	public RenderPIDS(BlockEntityRenderDispatcher dispatcher, int maxArrivals, float startX, float startY, float startZ, float maxHeight, int maxWidth, boolean rotate90, boolean renderArrivalNumber, boolean showAllPlatforms, int textColor, int firstTrainColor) {
		this(dispatcher, maxArrivals, startX, startY, startZ, maxHeight, maxWidth, rotate90, renderArrivalNumber, showAllPlatforms, textColor, firstTrainColor, 1, false);
	}

	@Override
	public void render(T entity, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {

		final Style style;
		if (Config.useMTRFont()) {
			style = Style.EMPTY.withFont(new ResourceLocation(Main.MOD_ID, "londonunderground"));
		} else {
			style = Style.EMPTY;
		}

		final Level world = entity.getLevel();
		if (world == null) {
			return;
		}

		final BlockPos pos = entity.getBlockPos();
		final Direction facing = IBlock.getStatePropertySafe(world, pos, HorizontalDirectionalBlock.FACING);
		if (RenderTrains.shouldNotRender(pos, Math.min(MAX_VIEW_DISTANCE, RenderTrains.maxTrainRenderDistance), rotate90 ? null : facing)) {
			return;
		}

		try {
			final Set<Route.ScheduleEntry> schedules;
			final Map<Long, String> platformIdToName = new HashMap<>();

			if (showAllPlatforms) {
				final Station station = RailwayData.getStation(ClientData.STATIONS, ClientData.DATA_CACHE, pos);
				if (station == null) {
					return;
				}

				final Map<Long, Platform> platforms = ClientData.DATA_CACHE.requestStationIdToPlatforms(station.id);
				if (platforms.isEmpty()) {
					return;
				}

				schedules = new HashSet<>();
				platforms.values().forEach(platform -> {
					final Set<Route.ScheduleEntry> scheduleForPlatform = ClientData.SCHEDULES_FOR_PLATFORM.get(platform.id);
					if (scheduleForPlatform != null) {
						scheduleForPlatform.forEach(scheduleEntry -> {
							if (!scheduleEntry.isTerminating) {
								schedules.add(scheduleEntry);
								platformIdToName.put(platform.id, platform.name);
							}
						});
					}
				});
			} else {
				final long platformId = RailwayData.getClosePlatformId(ClientData.PLATFORMS, ClientData.DATA_CACHE, pos);
				if (platformId == 0) {
					schedules = new HashSet<>();
				} else {
					final Set<Route.ScheduleEntry> schedulesForPlatform = ClientData.SCHEDULES_FOR_PLATFORM.get(platformId);
					schedules = schedulesForPlatform == null ? new HashSet<>() : schedulesForPlatform;
				}
			}

			final List<Route.ScheduleEntry> scheduleList = new ArrayList<>(schedules);
			Collections.sort(scheduleList);

			final boolean showCarLength;
			final float carLengthMaxWidth;
			if (!showAllPlatforms) {
				int maxCars = 0;
				int minCars = Integer.MAX_VALUE;
				for (final Route.ScheduleEntry scheduleEntry : scheduleList) {
					final int trainCars = scheduleEntry.trainCars;
					if (trainCars > maxCars) {
						maxCars = trainCars;
					}
					if (trainCars < minCars) {
						minCars = trainCars;
					}
				}
				showCarLength = minCars != maxCars;
				carLengthMaxWidth = showCarLength ? scale * 6 / 16 : 0;
			} else {
				showCarLength = false;
				carLengthMaxWidth = 0;
			}

			for (int i = 0; i < Math.min(maxArrivals, scheduleList.size()); i++) {
				final Route.ScheduleEntry currentSchedule = scheduleList.get(i);

				final String[] destinationSplit = currentSchedule.destination.split("\\|");
				String destinationString = IGui.textOrUntitled(destinationSplit[((int) Math.floor(RenderTrains.getGameTicks()) / SWITCH_LANGUAGE_TICKS) % destinationSplit.length]);

				final Component arrivalText;
				final int seconds = (int) ((currentSchedule.arrivalMillis - System.currentTimeMillis()) / 1000);
				final boolean isCJK = destinationString.codePoints().anyMatch(Character::isIdeographic);
				if (seconds >= 60) {
					arrivalText = new TranslatableComponent(isCJK ? "gui.mtr.arrival_min_cjk" : "gui.mtr.arrival_min", seconds / 60).append(appendDotAfterMin && !isCJK ? "." : "");
				} else {
					arrivalText = seconds > 0 ? new TranslatableComponent(isCJK ? "gui.mtr.arrival_sec_cjk" : "gui.londonunderground.arrival_sec", seconds).append(appendDotAfterMin && !isCJK ? "." : "") : null;
				}
				final Component carText = new TranslatableComponent(isCJK ? "gui.mtr.arrival_car_cjk" : "gui.mtr.arrival_car", currentSchedule.trainCars);

				matrices.pushPose();
				matrices.translate(0.5, 0, 0.5);
				matrices.mulPose(Vector3f.YP.rotationDegrees((rotate90 ? 90 : 0) - facing.toYRot()));
				matrices.mulPose(Vector3f.ZP.rotationDegrees(180));
				matrices.translate((startX - 8) / 16, -startY / 16 + i * maxHeight / maxArrivals / 16, (startZ - 8) / 16 - SMALL_OFFSET * 2);
				matrices.scale(1F / scale, 1F / scale, 1F / scale);

				final Font textRenderer = Minecraft.getInstance().font;

				if (renderArrivalNumber) {
					final FormattedCharSequence text1 = new TextComponent(String.valueOf(i + 1)).setStyle(style).getVisualOrderText();
					textRenderer.draw(matrices, text1, 0, 0, seconds > 0 ? textColor : firstTrainColor);
				}

				final float newDestinationMaxWidth = destinationMaxWidth - carLengthMaxWidth;

				if (showAllPlatforms) {
					final String platformName = " " + platformIdToName.get(currentSchedule.platformId);
					final FormattedCharSequence text2 = new TextComponent(platformName).setStyle(style).getVisualOrderText();
					if (platformName != null) {
						textRenderer.draw(matrices, text2, destinationStart + newDestinationMaxWidth, 0, seconds > 0 ? textColor : firstTrainColor);
					}
				}

				if (showCarLength) {
					matrices.pushPose();
					matrices.translate(destinationStart + newDestinationMaxWidth + platformMaxWidth, 0, 0);

					final FormattedCharSequence text3 = new TextComponent(carText.getString()).setStyle(style).getVisualOrderText();


					final int carTextWidth = textRenderer.width(text3);
					if (carTextWidth > carLengthMaxWidth) {
						matrices.scale(carLengthMaxWidth / carTextWidth, 1, 1);
					}
					textRenderer.draw(matrices, text3, 0, 0, CAR_TEXT_COLOR);
					matrices.popPose();
				}

				if (currentSchedule.isTerminating) {
					if (isCJK) {
						destinationString = "終止服務";
					} else {
						destinationString = "Terminating Here";
					}
				}

				matrices.pushPose();
				matrices.translate(destinationStart, 0, 0);
				final int destinationWidth = textRenderer.width(destinationString);
				if (destinationWidth > newDestinationMaxWidth) {
					matrices.scale(newDestinationMaxWidth / destinationWidth, 1, 1);
				}

				final FormattedCharSequence text4 = new TextComponent(destinationString).setStyle(style).getVisualOrderText();

				textRenderer.draw(matrices, text4, 0, 0, seconds > 0 ? textColor : firstTrainColor);
				matrices.popPose();

				if (arrivalText != null) {
					final FormattedCharSequence text5 = new TextComponent(arrivalText.getString()).setStyle(style).getVisualOrderText();


					matrices.pushPose();
					final int arrivalWidth = textRenderer.width(text5);
					if (arrivalWidth > arrivalMaxWidth) {
						matrices.translate(destinationStart + newDestinationMaxWidth + platformMaxWidth + carLengthMaxWidth, 0, 0);
						matrices.scale(arrivalMaxWidth / arrivalWidth, 1, 1);
					} else {
						matrices.translate(totalScaledWidth - arrivalWidth, 0, 0);
					}
					textRenderer.draw(matrices, text5, 0, 0, textColor);
					matrices.popPose();
				}

				matrices.popPose();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
