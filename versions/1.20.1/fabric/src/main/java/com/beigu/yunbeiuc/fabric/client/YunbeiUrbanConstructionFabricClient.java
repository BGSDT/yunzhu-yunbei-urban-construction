package com.beigu.yunbeiuc.fabric.client;

import com.beigu.yunbeiuc.block.MunicipalBlocks;
import com.beigu.yunbeiuc.render.LinkWandRenderer;
import com.beigu.yunbeiuc.entity.ModBlockEntities;
import com.beigu.yunbeiuc.render.*;
import com.beigu.yunbeiuc.util.PresetManager;
import com.beigu.yunbeiuc.util.TrafficLightsPatternCategoryManager;
import com.beigu.yunbeiuc.util.TrafficLightsPatternPresetManager;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.renderer.RenderType;


public final class YunbeiUrbanConstructionFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.ANTI_GLARE_NET.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.ANTI_GLARE_NET_POLE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.WARNING_NETWORK.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.WARNING_NETWORK_POLE.get(), RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.SOUND_BARRIER_1_WHITE_NORMAL.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.SOUND_BARRIER_1_WHITE_TB.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.SOUND_BARRIER_1_BLUE_NORMAL.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.SOUND_BARRIER_1_BLUE_TB.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.SOUND_BARRIER_1_GREEN_NORMAL.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.SOUND_BARRIER_1_GREEN_TB.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.SOUND_BARRIER_2_NORMAL.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.SOUND_BARRIER_2_TB.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.SOUND_BARRIER_3_WHITE_NORMAL.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.SOUND_BARRIER_3_WHITE_TB.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.SOUND_BARRIER_3_BLUE_NORMAL.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.SOUND_BARRIER_3_BLUE_TB.get(), RenderType.translucent());

        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.TRAFFIC_LIGHTS_GRAY_SINGLE_HORIZONTAL.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.TRAFFIC_LIGHTS_BLACK_SINGLE_HORIZONTAL.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.TRAFFIC_LIGHTS_GRAY_SINGLE_VERTICAL.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.TRAFFIC_LIGHTS_BLACK_SINGLE_VERTICAL.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.TRAFFIC_LIGHTS_PAVEMENT_INTEGRATION_GRAY.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.TRAFFIC_LIGHTS_PAVEMENT_INTEGRATION_BLACK.get(), RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.CORNER_GUARD_BLACK.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.CORNER_GUARD_BLACK_LEFT.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MunicipalBlocks.CORNER_GUARD_BLACK_RIGHT.get(), RenderType.cutout());

        BlockEntityRendererRegistry.register(ModBlockEntities.ROAD_POLE_TEXT_DISPLAY_ENTITY.get(), RoadPoleTextDisplayEntityRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.FLAG_BLOCK_ENTITY.get(), FlagBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.ROAD_NAME_SIGN_BLOCK_ENTITY.get(), RoadNameSignBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.TRAFFIC_LIGHTS_BLOCK_ENTITY.get(), TrafficLightsBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.TRAFFIC_LIGHTS_PAVEMENT_INTEGRATION_BLOCK_ENTITY.get(), TrafficLightsPavementIntegrationBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.GANTRY_FRAME_LED_ENTITY.get(), GantryFrameLedEntityRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.ROAD_POLE_LED_ENTITY.get(), RoadPoleLedEntityRenderer::new);

        PresetManager.load();
        TrafficLightsPatternPresetManager.load();
        TrafficLightsPatternCategoryManager.load();

        WorldRenderEvents.AFTER_TRANSLUCENT.register(context -> LinkWandRenderer.renderLinkedLightsOutline(context.matrixStack(), context.camera()));
    }
}
