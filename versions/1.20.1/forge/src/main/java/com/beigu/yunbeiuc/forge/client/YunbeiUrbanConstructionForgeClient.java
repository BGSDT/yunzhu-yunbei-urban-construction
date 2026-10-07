package com.beigu.yunbeiuc.forge.client;

import com.beigu.yunbeiuc.block.MunicipalBlocks;
import com.beigu.yunbeiuc.render.LinkWandRenderer;
import com.beigu.yunbeiuc.entity.ModBlockEntities;
import com.beigu.yunbeiuc.render.*;
import com.beigu.yunbeiuc.util.CustomFontManager;
import com.beigu.yunbeiuc.util.FlagLoader;
import com.beigu.yunbeiuc.util.PresetManager;
import com.beigu.yunbeiuc.util.TrafficLightsPatternCategoryManager;
import com.beigu.yunbeiuc.util.TrafficLightsPatternPresetLoader;
import com.beigu.yunbeiuc.util.TrafficLightsPatternPresetManager;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class YunbeiUrbanConstructionForgeClient {

    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderType cutout = RenderType.cutoutMipped();
            RenderType translucent = RenderType.translucent();

            RenderTypeRegistry.register(cutout, MunicipalBlocks.ANTI_GLARE_NET.get());
            RenderTypeRegistry.register(cutout, MunicipalBlocks.ANTI_GLARE_NET_POLE.get());
            RenderTypeRegistry.register(cutout, MunicipalBlocks.WARNING_NETWORK.get());
            RenderTypeRegistry.register(cutout, MunicipalBlocks.WARNING_NETWORK_POLE.get());
            RenderTypeRegistry.register(translucent, MunicipalBlocks.SOUND_BARRIER_1_WHITE_NORMAL.get());
            RenderTypeRegistry.register(translucent, MunicipalBlocks.SOUND_BARRIER_1_WHITE_TB.get());
            RenderTypeRegistry.register(translucent, MunicipalBlocks.SOUND_BARRIER_1_BLUE_NORMAL.get());
            RenderTypeRegistry.register(translucent, MunicipalBlocks.SOUND_BARRIER_1_BLUE_TB.get());
            RenderTypeRegistry.register(translucent, MunicipalBlocks.SOUND_BARRIER_1_GREEN_NORMAL.get());
            RenderTypeRegistry.register(translucent, MunicipalBlocks.SOUND_BARRIER_1_GREEN_TB.get());
            RenderTypeRegistry.register(translucent, MunicipalBlocks.SOUND_BARRIER_2_NORMAL.get());
            RenderTypeRegistry.register(translucent, MunicipalBlocks.SOUND_BARRIER_2_TB.get());
            RenderTypeRegistry.register(translucent, MunicipalBlocks.SOUND_BARRIER_3_WHITE_NORMAL.get());
            RenderTypeRegistry.register(translucent, MunicipalBlocks.SOUND_BARRIER_3_WHITE_TB.get());
            RenderTypeRegistry.register(translucent, MunicipalBlocks.SOUND_BARRIER_3_BLUE_NORMAL.get());
            RenderTypeRegistry.register(translucent, MunicipalBlocks.SOUND_BARRIER_3_BLUE_TB.get());

            RenderTypeRegistry.register(cutout, MunicipalBlocks.TRAFFIC_LIGHTS_PAVEMENT_INTEGRATION_GRAY.get());
            RenderTypeRegistry.register(cutout, MunicipalBlocks.TRAFFIC_LIGHTS_PAVEMENT_INTEGRATION_BLACK.get());

            RenderTypeRegistry.register(cutout, MunicipalBlocks.CORNER_GUARD_BLACK.get());
            RenderTypeRegistry.register(cutout, MunicipalBlocks.CORNER_GUARD_BLACK_LEFT.get());
            RenderTypeRegistry.register(cutout, MunicipalBlocks.CORNER_GUARD_BLACK_RIGHT.get());

            BlockEntityRendererRegistry.register(ModBlockEntities.ROAD_POLE_TEXT_DISPLAY_ENTITY.get(), RoadPoleTextDisplayEntityRenderer::new);
            BlockEntityRendererRegistry.register(ModBlockEntities.FLAG_BLOCK_ENTITY.get(), FlagBlockEntityRenderer::new);
            BlockEntityRendererRegistry.register(ModBlockEntities.ROAD_NAME_SIGN_BLOCK_ENTITY.get(), RoadNameSignBlockEntityRenderer::new);
            BlockEntityRendererRegistry.register(ModBlockEntities.TRAFFIC_LIGHTS_BLOCK_ENTITY.get(), TrafficLightsBlockEntityRenderer::new);
            BlockEntityRendererRegistry.register(ModBlockEntities.TRAFFIC_LIGHTS_PAVEMENT_INTEGRATION_BLOCK_ENTITY.get(), TrafficLightsPavementIntegrationBlockEntityRenderer::new);
            BlockEntityRendererRegistry.register(ModBlockEntities.GANTRY_FRAME_LED_ENTITY.get(), GantryFrameLedEntityRenderer::new);
            BlockEntityRendererRegistry.register(ModBlockEntities.ROAD_POLE_LED_ENTITY.get(), RoadPoleLedEntityRenderer::new);

            FlagLoader.loadFlags(Minecraft.getInstance().getResourceManager());
            TrafficLightsPatternPresetLoader.loadPresets(Minecraft.getInstance().getResourceManager());
            CustomFontManager.getInstance().onResourceReload();
            PresetManager.load();
            TrafficLightsPatternPresetManager.load();
            TrafficLightsPatternCategoryManager.load();
        });

        MinecraftForge.EVENT_BUS.addListener(YunbeiUrbanConstructionForgeClient::onRenderLevelStage);
    }

    private static void onRenderLevelStage(RenderLevelStageEvent event) {
        if (event.getStage() == RenderLevelStageEvent.Stage.AFTER_TRANSLUCENT_BLOCKS) {
            LinkWandRenderer.renderLinkedLightsOutline(event.getPoseStack(), event.getCamera());
        }
    }
}
