package com.beigu.yunbeiuc.entity;

import com.beigu.yunbeiuc.YunbeiUrbanConstruction;
import com.beigu.yunbeiuc.block.MunicipalBlocks;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import com.beigu.yunbeiuc.api.mapper.VersionServices;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;


public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BES =
            VersionServices.registries().blockEntityTypes(YunbeiUrbanConstruction.MOD_ID);

    public static final RegistrySupplier<BlockEntityType<TrafficLightsBlockEntity>> TRAFFIC_LIGHTS_BLOCK_ENTITY =
            BES.register("traffic_lights_block_entity",
                    () -> VersionServices.blockEntities().create(TrafficLightsBlockEntity::new,
                            MunicipalBlocks.TRAFFIC_LIGHTS_GRAY_VERTICAL.get(),
                            MunicipalBlocks.TRAFFIC_LIGHTS_BLACK_VERTICAL.get(),
                            MunicipalBlocks.TRAFFIC_LIGHTS_YELLOW_VERTICAL.get(),
                            MunicipalBlocks.TRAFFIC_LIGHTS_GRAY_HORIZONTAL.get(),
                            MunicipalBlocks.TRAFFIC_LIGHTS_BLACK_HORIZONTAL.get(),
                            MunicipalBlocks.TRAFFIC_LIGHTS_GRAY_SINGLE_HORIZONTAL.get(),
                            MunicipalBlocks.TRAFFIC_LIGHTS_BLACK_SINGLE_HORIZONTAL.get(),
                            MunicipalBlocks.TRAFFIC_LIGHTS_GRAY_SINGLE_VERTICAL.get(),
                            MunicipalBlocks.TRAFFIC_LIGHTS_BLACK_SINGLE_VERTICAL.get(),
                            MunicipalBlocks.TRAFFIC_LIGHTS_FOGGY.get(),
                            MunicipalBlocks.TRAFFIC_LIGHTS_GRAY_SHANGHAI.get(),
                            MunicipalBlocks.TRAFFIC_LIGHTS_BLACK_SHANGHAI.get(),
                            MunicipalBlocks.TRAFFIC_LIGHTS_COUNTDOWN_TIMER.get(),
                            MunicipalBlocks.TRAFFIC_LIGHTS_PAVEMENT_GRAY.get(),
                            MunicipalBlocks.TRAFFIC_LIGHTS_PAVEMENT_BLACK.get(),
                            MunicipalBlocks.TRAFFIC_LIGHTS_GREEN_TAIPEI.get(),
                            MunicipalBlocks.TRAFFIC_LIGHTS_PAVEMENT_GREEN_TAIPEI.get()));

    public static final RegistrySupplier<BlockEntityType<TrafficLightsPavementIntegrationBlockEntity>> TRAFFIC_LIGHTS_PAVEMENT_INTEGRATION_BLOCK_ENTITY =
            BES.register("traffic_lights_pavement_integration_block_entity",
                    () -> VersionServices.blockEntities().create(TrafficLightsPavementIntegrationBlockEntity::new,
                            MunicipalBlocks.TRAFFIC_LIGHTS_PAVEMENT_INTEGRATION_GRAY.get(),
                            MunicipalBlocks.TRAFFIC_LIGHTS_PAVEMENT_INTEGRATION_BLACK.get()));

    public static final RegistrySupplier<BlockEntityType<RoadPoleTextDisplayEntity>> ROAD_POLE_TEXT_DISPLAY_ENTITY =
            BES.register("road_pole_text_display_entity",
                    () -> VersionServices.blockEntities().create(RoadPoleTextDisplayEntity::new,
                            MunicipalBlocks.ROAD_POLE_TEXT_DISPLAY.get()));

    public static final RegistrySupplier<BlockEntityType<RoadPoleLedEntity>> ROAD_POLE_LED_ENTITY =
            BES.register("road_pole_led_entity",
                    () -> VersionServices.blockEntities().create(RoadPoleLedEntity::new,
                            MunicipalBlocks.ROAD_POLE_LED.get()));

    public static final RegistrySupplier<BlockEntityType<FlagBlockEntity>> FLAG_BLOCK_ENTITY =
            BES.register("flag_block_entity",
                    () -> VersionServices.blockEntities().create(FlagBlockEntity::new,
                            MunicipalBlocks.ROAD_POLE_FLAG.get()));

    public static final RegistrySupplier<BlockEntityType<RoadNameSignBlockEntity>> ROAD_NAME_SIGN_BLOCK_ENTITY =
            BES.register("road_name_sign_block_entity",
                    () -> VersionServices.blockEntities().create(RoadNameSignBlockEntity::new,
                            MunicipalBlocks.ROAD_NAME_SIGN_RC.get(),
                            MunicipalBlocks.ROAD_NAME_SIGN_RA.get()));

    public static final RegistrySupplier<BlockEntityType<GantryFrameLedEntity>> GANTRY_FRAME_LED_ENTITY =
            BES.register("gantry_frame_led_entity",
                    () -> VersionServices.blockEntities().create(GantryFrameLedEntity::new,
                            MunicipalBlocks.GANTRY_FRAME_LED.get()));

    public static void init() {
        BES.register();
    }
}
