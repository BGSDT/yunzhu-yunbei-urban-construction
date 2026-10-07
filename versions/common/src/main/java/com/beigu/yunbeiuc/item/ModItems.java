package com.beigu.yunbeiuc.item;

import com.beigu.yunbeiuc.YunbeiUrbanConstruction;
import com.beigu.yunbeiuc.block.MunicipalBlocks;
import com.beigu.yunbeiuc.item.custom.*;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import com.beigu.yunbeiuc.api.mapper.VersionServices;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            VersionServices.registries().items(YunbeiUrbanConstruction.MOD_ID);

    public static final List<Supplier<? extends Item>> ALL_MUNICIPAL_ITEMS = new ArrayList<>();

    private static <T extends Item> RegistrySupplier<T> registerItem(String name, Supplier<T> supplier) {
        RegistrySupplier<T> item = ITEMS.register(name, supplier);
        ALL_MUNICIPAL_ITEMS.add(item);
        return item;
    }

    private static RegistrySupplier<Item> registerBlockItem(RegistrySupplier<? extends Block> blockSupplier, List<Supplier<? extends Item>> categoryList) {
        RegistrySupplier<Item> item = ITEMS.register(blockSupplier.getId().getPath(),
                () -> {
                    Block block = blockSupplier.get();
                    Item.Properties properties = VersionServices.creativeTabs().apply(new Item.Properties(),
                            ModItemGroups.YUNBEIUC_MUNICIPAL_GROUP);
                    BlockItem blockItem = new BlockItem(block, properties);
                    Item.BY_BLOCK.put(block, blockItem);
                    return blockItem;
                });
        categoryList.add(item);
        return item;
    }

    // ===== Wand Items =====
    public static final RegistrySupplier<Item> WAND = registerItem("wand",
            () -> new Item(VersionServices.creativeTabs().apply(new Item.Properties().stacksTo(1), ModItemGroups.YUNBEIUC_MUNICIPAL_GROUP)));
    public static final RegistrySupplier<Item> LINK_WAND = registerItem("link_wand",
            () -> new LinkWand(VersionServices.creativeTabs().apply(new Item.Properties().stacksTo(1), ModItemGroups.YUNBEIUC_MUNICIPAL_GROUP)));
    public static final RegistrySupplier<Item> TEXT_COPY_WAND = registerItem("text_copy_wand",
            () -> new TextCopyWand(VersionServices.creativeTabs().apply(new Item.Properties().stacksTo(1), ModItemGroups.YUNBEIUC_MUNICIPAL_GROUP)));

    // ===== Municipal BlockItems =====
    public static final RegistrySupplier<Item> ROAD_POLE_FOUNDATIONS = registerBlockItem(MunicipalBlocks.ROAD_POLE_FOUNDATIONS, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_POLE_FOUNDATIONS_SLAB = registerBlockItem(MunicipalBlocks.ROAD_POLE_FOUNDATIONS_SLAB, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_POLE_LONGITUDINAL = registerBlockItem(MunicipalBlocks.ROAD_POLE_LONGITUDINAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_POLE_HORIZONTAL = registerBlockItem(MunicipalBlocks.ROAD_POLE_HORIZONTAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_POLE_TSHAPE = registerBlockItem(MunicipalBlocks.ROAD_POLE_TSHAPE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_POLE_TEXT_DISPLAY = registerBlockItem(MunicipalBlocks.ROAD_POLE_TEXT_DISPLAY, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_POLE_LED = registerBlockItem(MunicipalBlocks.ROAD_POLE_LED, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_POLE_FLAG = registerBlockItem(MunicipalBlocks.ROAD_POLE_FLAG, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_POLE_LIGHT_FOUNDATIONS = registerBlockItem(MunicipalBlocks.ROAD_POLE_LIGHT_FOUNDATIONS, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_POLE_LIGHT_FOUNDATIONS_SLAB = registerBlockItem(MunicipalBlocks.ROAD_POLE_LIGHT_FOUNDATIONS_SLAB, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_POLE_LIGHT_LONGITUDINAL = registerBlockItem(MunicipalBlocks.ROAD_POLE_LIGHT_LONGITUDINAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_POLE_LIGHT_BRANCH_1 = registerBlockItem(MunicipalBlocks.ROAD_POLE_LIGHT_BRANCH_1, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_POLE_LIGHT_BRANCH_2 = registerBlockItem(MunicipalBlocks.ROAD_POLE_LIGHT_BRANCH_2, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_POLE_LIGHT_BRANCH_3 = registerBlockItem(MunicipalBlocks.ROAD_POLE_LIGHT_BRANCH_3, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_LIGHT_HIGH_MAST = registerBlockItem(MunicipalBlocks.ROAD_LIGHT_HIGH_MAST, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_LIGHT_1 = registerBlockItem(MunicipalBlocks.ROAD_LIGHT_1, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_LIGHT_2 = registerBlockItem(MunicipalBlocks.ROAD_LIGHT_2, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_SOLAR_PANEL = registerBlockItem(MunicipalBlocks.ROAD_SOLAR_PANEL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_DETECTION_CAMERA = registerBlockItem(MunicipalBlocks.ROAD_DETECTION_CAMERA, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_LIGHTING_LAMP = registerBlockItem(MunicipalBlocks.ROAD_LIGHTING_LAMP, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_RADAR_SPEED_DETECTOR = registerBlockItem(MunicipalBlocks.ROAD_RADAR_SPEED_DETECTOR, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_GRAY_VERTICAL = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_GRAY_VERTICAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_BLACK_VERTICAL = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_BLACK_VERTICAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_YELLOW_VERTICAL = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_YELLOW_VERTICAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_GRAY_HORIZONTAL = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_GRAY_HORIZONTAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_BLACK_HORIZONTAL = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_BLACK_HORIZONTAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_GRAY_SINGLE_HORIZONTAL = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_GRAY_SINGLE_HORIZONTAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_BLACK_SINGLE_HORIZONTAL = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_BLACK_SINGLE_HORIZONTAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_GRAY_SINGLE_VERTICAL = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_GRAY_SINGLE_VERTICAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_BLACK_SINGLE_VERTICAL = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_BLACK_SINGLE_VERTICAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_FOGGY = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_FOGGY, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_GRAY_SHANGHAI = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_GRAY_SHANGHAI, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_BLACK_SHANGHAI = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_BLACK_SHANGHAI, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_COUNTDOWN_TIMER = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_COUNTDOWN_TIMER, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_PAVEMENT_GRAY = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_PAVEMENT_GRAY, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_PAVEMENT_BLACK = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_PAVEMENT_BLACK, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_PAVEMENT_INTEGRATION_GRAY = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_PAVEMENT_INTEGRATION_GRAY, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_PAVEMENT_INTEGRATION_BLACK = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_PAVEMENT_INTEGRATION_BLACK, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_GREEN_TAIPEI = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_GREEN_TAIPEI, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_LIGHTS_PAVEMENT_GREEN_TAIPEI = registerBlockItem(MunicipalBlocks.TRAFFIC_LIGHTS_PAVEMENT_GREEN_TAIPEI, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_CONE = registerBlockItem(MunicipalBlocks.TRAFFIC_CONE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_COLLISION_BARREL = registerBlockItem(MunicipalBlocks.ROAD_COLLISION_BARREL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> WATER_SAFETY_BARRIER_RED = registerBlockItem(MunicipalBlocks.WATER_SAFETY_BARRIER_RED, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> SPEED_BUMP = registerBlockItem(MunicipalBlocks.SPEED_BUMP, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> VIBRATION_MARKING_LINE = registerBlockItem(MunicipalBlocks.VIBRATION_MARKING_LINE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> PARKING_SPACE_BARRIER = registerBlockItem(MunicipalBlocks.PARKING_SPACE_BARRIER, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> GANTRY_FRAME_SIDE = registerBlockItem(MunicipalBlocks.GANTRY_FRAME_SIDE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> GANTRY_FRAME_CONNECTION = registerBlockItem(MunicipalBlocks.GANTRY_FRAME_CONNECTION, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> GANTRY_FRAME_MAIN = registerBlockItem(MunicipalBlocks.GANTRY_FRAME_MAIN, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> GANTRY_FRAME_RAILING = registerBlockItem(MunicipalBlocks.GANTRY_FRAME_RAILING, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> GANTRY_FRAME_LADDER = registerBlockItem(MunicipalBlocks.GANTRY_FRAME_LADDER, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> GANTRY_FRAME_LED_SIDE = registerBlockItem(MunicipalBlocks.GANTRY_FRAME_LED_SIDE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> GANTRY_FRAME_LED_MAIN = registerBlockItem(MunicipalBlocks.GANTRY_FRAME_LED_MAIN, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> GANTRY_FRAME_LED = registerBlockItem(MunicipalBlocks.GANTRY_FRAME_LED, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> GANTRY_FRAME_DETECTION_CAMERA = registerBlockItem(MunicipalBlocks.GANTRY_FRAME_DETECTION_CAMERA, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> GANTRY_FRAME_LIGHTING_LAMP = registerBlockItem(MunicipalBlocks.GANTRY_FRAME_LIGHTING_LAMP, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> GANTRY_FRAME_RADAR_SPEED_DETECTOR = registerBlockItem(MunicipalBlocks.GANTRY_FRAME_RADAR_SPEED_DETECTOR, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> WARNING_NETWORK = registerBlockItem(MunicipalBlocks.WARNING_NETWORK, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> WARNING_NETWORK_POLE = registerBlockItem(MunicipalBlocks.WARNING_NETWORK_POLE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ANTI_GLARE_NET = registerBlockItem(MunicipalBlocks.ANTI_GLARE_NET, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ANTI_GLARE_NET_POLE = registerBlockItem(MunicipalBlocks.ANTI_GLARE_NET_POLE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ANTI_GLARE_VERSION = registerBlockItem(MunicipalBlocks.ANTI_GLARE_VERSION, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_BARRIER = registerBlockItem(MunicipalBlocks.TRAFFIC_BARRIER, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_BARRIER_YELLOW_DOUBLE = registerBlockItem(MunicipalBlocks.TRAFFIC_BARRIER_YELLOW_DOUBLE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_BARRIER_YELLOW = registerBlockItem(MunicipalBlocks.TRAFFIC_BARRIER_YELLOW, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_BARRIER_RED = registerBlockItem(MunicipalBlocks.TRAFFIC_BARRIER_RED, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_BARRIER_RED_DOUBLE = registerBlockItem(MunicipalBlocks.TRAFFIC_BARRIER_RED_DOUBLE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_BARRIER_OBLIQUE = registerBlockItem(MunicipalBlocks.TRAFFIC_BARRIER_OBLIQUE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_BARRIER_GRAY = registerBlockItem(MunicipalBlocks.TRAFFIC_BARRIER_GRAY, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_BARRIER_GRAY_OBLIQUE = registerBlockItem(MunicipalBlocks.TRAFFIC_BARRIER_GRAY_OBLIQUE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_BARRIER_GRAY_RED = registerBlockItem(MunicipalBlocks.TRAFFIC_BARRIER_GRAY_RED, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_BARRIER_GRAY_RED_OBLIQUE = registerBlockItem(MunicipalBlocks.TRAFFIC_BARRIER_GRAY_RED_OBLIQUE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_BARRIER_GRAY_YELLOW = registerBlockItem(MunicipalBlocks.TRAFFIC_BARRIER_GRAY_YELLOW, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_BARRIER_GRAY_YELLOW_OBLIQUE = registerBlockItem(MunicipalBlocks.TRAFFIC_BARRIER_GRAY_YELLOW_OBLIQUE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_BARRIER_GRAY_SLANT = registerBlockItem(MunicipalBlocks.TRAFFIC_BARRIER_GRAY_SLANT, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_BARRIER_GRAY_SLANT_YELLOW = registerBlockItem(MunicipalBlocks.TRAFFIC_BARRIER_GRAY_SLANT_YELLOW, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_BARRIER_GRAY_SLANT_RED = registerBlockItem(MunicipalBlocks.TRAFFIC_BARRIER_GRAY_SLANT_RED, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> TRAFFIC_BARRIER_GRAY_SLANT_OBLIQUE = registerBlockItem(MunicipalBlocks.TRAFFIC_BARRIER_GRAY_SLANT_OBLIQUE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> REFLECTIVE_SIGN_YELLOW_ALL_1 = registerBlockItem(MunicipalBlocks.REFLECTIVE_SIGN_YELLOW_ALL_1, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> REFLECTIVE_SIGN_YELLOW_ALL_2 = registerBlockItem(MunicipalBlocks.REFLECTIVE_SIGN_YELLOW_ALL_2, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> REFLECTIVE_SIGN_RED_ALL_1 = registerBlockItem(MunicipalBlocks.REFLECTIVE_SIGN_RED_ALL_1, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> REFLECTIVE_SIGN_RED_ALL_2 = registerBlockItem(MunicipalBlocks.REFLECTIVE_SIGN_RED_ALL_2, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> SOUND_BARRIER_1_WHITE_NORMAL = registerBlockItem(MunicipalBlocks.SOUND_BARRIER_1_WHITE_NORMAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> SOUND_BARRIER_1_WHITE_TB = registerBlockItem(MunicipalBlocks.SOUND_BARRIER_1_WHITE_TB, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> SOUND_BARRIER_1_BLUE_NORMAL = registerBlockItem(MunicipalBlocks.SOUND_BARRIER_1_BLUE_NORMAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> SOUND_BARRIER_1_BLUE_TB = registerBlockItem(MunicipalBlocks.SOUND_BARRIER_1_BLUE_TB, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> SOUND_BARRIER_1_GREEN_NORMAL = registerBlockItem(MunicipalBlocks.SOUND_BARRIER_1_GREEN_NORMAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> SOUND_BARRIER_1_GREEN_TB = registerBlockItem(MunicipalBlocks.SOUND_BARRIER_1_GREEN_TB, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> SOUND_BARRIER_2_NORMAL = registerBlockItem(MunicipalBlocks.SOUND_BARRIER_2_NORMAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> SOUND_BARRIER_2_TB = registerBlockItem(MunicipalBlocks.SOUND_BARRIER_2_TB, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> SOUND_BARRIER_3_WHITE_NORMAL = registerBlockItem(MunicipalBlocks.SOUND_BARRIER_3_WHITE_NORMAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> SOUND_BARRIER_3_WHITE_TB = registerBlockItem(MunicipalBlocks.SOUND_BARRIER_3_WHITE_TB, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> SOUND_BARRIER_3_BLUE_NORMAL = registerBlockItem(MunicipalBlocks.SOUND_BARRIER_3_BLUE_NORMAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> SOUND_BARRIER_3_BLUE_TB = registerBlockItem(MunicipalBlocks.SOUND_BARRIER_3_BLUE_TB, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_NAME_SIGN_RC = registerBlockItem(MunicipalBlocks.ROAD_NAME_SIGN_RC, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_NAME_SIGN_RA = registerBlockItem(MunicipalBlocks.ROAD_NAME_SIGN_RA, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_NAME_SIGN_POLE = registerBlockItem(MunicipalBlocks.ROAD_NAME_SIGN_POLE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> INSTRUMENT_POLE_FOUNDATIONS = registerBlockItem(MunicipalBlocks.INSTRUMENT_POLE_FOUNDATIONS, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> INSTRUMENT_POLE_LONGITUDINAL = registerBlockItem(MunicipalBlocks.INSTRUMENT_POLE_LONGITUDINAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> INSTRUMENT_CAMERA = registerBlockItem(MunicipalBlocks.INSTRUMENT_CAMERA, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> INSTRUMENT_FEE_DISPLAY = registerBlockItem(MunicipalBlocks.INSTRUMENT_FEE_DISPLAY, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> INSTRUMENT_LANE_INDICATOR = registerBlockItem(MunicipalBlocks.INSTRUMENT_LANE_INDICATOR, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> INSTRUMENT_STROBE_LIGHT = registerBlockItem(MunicipalBlocks.INSTRUMENT_STROBE_LIGHT, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_RAILINGS_IRON = registerBlockItem(MunicipalBlocks.ROAD_RAILINGS_IRON, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_RAILINGS_IRON_ENDING_1 = registerBlockItem(MunicipalBlocks.ROAD_RAILINGS_IRON_ENDING_1, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_RAILINGS_IRON_ENDING_2 = registerBlockItem(MunicipalBlocks.ROAD_RAILINGS_IRON_ENDING_2, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_RAILINGS_IRON_POLE = registerBlockItem(MunicipalBlocks.ROAD_RAILINGS_IRON_POLE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_RAILINGS_IRON_OBLIQUE = registerBlockItem(MunicipalBlocks.ROAD_RAILINGS_IRON_OBLIQUE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_RAILINGS_GREEN = registerBlockItem(MunicipalBlocks.ROAD_RAILINGS_GREEN, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_RAILINGS_GREEN_ENDING_1 = registerBlockItem(MunicipalBlocks.ROAD_RAILINGS_GREEN_ENDING_1, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_RAILINGS_GREEN_ENDING_2 = registerBlockItem(MunicipalBlocks.ROAD_RAILINGS_GREEN_ENDING_2, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_RAILINGS_GREEN_POLE = registerBlockItem(MunicipalBlocks.ROAD_RAILINGS_GREEN_POLE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_RAILINGS_GREEN_OBLIQUE = registerBlockItem(MunicipalBlocks.ROAD_RAILINGS_GREEN_OBLIQUE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> RUBBISH_BIN_WHITE = registerBlockItem(MunicipalBlocks.RUBBISH_BIN_WHITE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> RUBBISH_BIN_GRAY_GREEN = registerBlockItem(MunicipalBlocks.RUBBISH_BIN_GRAY_GREEN, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> SPIKED_BELT = registerBlockItem(MunicipalBlocks.SPIKED_BELT, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> RISING_BOLLARD = registerBlockItem(MunicipalBlocks.RISING_BOLLARD, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> CORNER_GUARD_BLACK = registerBlockItem(MunicipalBlocks.CORNER_GUARD_BLACK, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> CORNER_GUARD_BLACK_LEFT = registerBlockItem(MunicipalBlocks.CORNER_GUARD_BLACK_LEFT, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> CORNER_GUARD_BLACK_RIGHT = registerBlockItem(MunicipalBlocks.CORNER_GUARD_BLACK_RIGHT, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> CALTROP_RED = registerBlockItem(MunicipalBlocks.CALTROP_RED, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> CALTROP_YELLOW = registerBlockItem(MunicipalBlocks.CALTROP_YELLOW, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_WARNING_POLE_RED = registerBlockItem(MunicipalBlocks.ROAD_WARNING_POLE_RED, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_WARNING_POLE_YELLOW = registerBlockItem(MunicipalBlocks.ROAD_WARNING_POLE_YELLOW, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> ROAD_WARNING_POLE_GREEN = registerBlockItem(MunicipalBlocks.ROAD_WARNING_POLE_GREEN, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> COUNTERFEIT_ROADBLOCK_STANDARD_YELLOW = registerBlockItem(MunicipalBlocks.COUNTERFEIT_ROADBLOCK_STANDARD_YELLOW, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> COUNTERFEIT_ROADBLOCK_STANDARD_RED = registerBlockItem(MunicipalBlocks.COUNTERFEIT_ROADBLOCK_STANDARD_RED, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> COUNTERFEIT_ROADBLOCK_ENHANCED_YELLOW = registerBlockItem(MunicipalBlocks.COUNTERFEIT_ROADBLOCK_ENHANCED_YELLOW, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> COUNTERFEIT_ROADBLOCK_ENHANCED_RED = registerBlockItem(MunicipalBlocks.COUNTERFEIT_ROADBLOCK_ENHANCED_RED, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> COUNTERFEIT_ROADBLOCK_EASY_YELLOW = registerBlockItem(MunicipalBlocks.COUNTERFEIT_ROADBLOCK_EASY_YELLOW, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> COUNTERFEIT_ROADBLOCK_EASY_RED = registerBlockItem(MunicipalBlocks.COUNTERFEIT_ROADBLOCK_EASY_RED, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> COUNTERFEIT_ROADBLOCK_EASY_LINE = registerBlockItem(MunicipalBlocks.COUNTERFEIT_ROADBLOCK_EASY_LINE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> COUNTERFEIT_ROADBLOCK_SIMPLE_YELLOW = registerBlockItem(MunicipalBlocks.COUNTERFEIT_ROADBLOCK_SIMPLE_YELLOW, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> IRON_HORSE_YELLOW = registerBlockItem(MunicipalBlocks.IRON_HORSE_YELLOW, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> IRON_HORSE_RED = registerBlockItem(MunicipalBlocks.IRON_HORSE_RED, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> IRON_HORSE_WHITE = registerBlockItem(MunicipalBlocks.IRON_HORSE_WHITE, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> IRON_HORSE_GRAY = registerBlockItem(MunicipalBlocks.IRON_HORSE_GRAY, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> BARRIER_GATE_1_MAIN = registerBlockItem(MunicipalBlocks.BARRIER_GATE_1_MAIN, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> BARRIER_GATE_1_MAIN_SLAB = registerBlockItem(MunicipalBlocks.BARRIER_GATE_1_MAIN_SLAB, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> BARRIER_GATE_1_POLE_HORIZONTAL = registerBlockItem(MunicipalBlocks.BARRIER_GATE_1_POLE_HORIZONTAL, ALL_MUNICIPAL_ITEMS);
    public static final RegistrySupplier<Item> BARRIER_GATE_1_POLE_LONGITUDINAL = registerBlockItem(MunicipalBlocks.BARRIER_GATE_1_POLE_LONGITUDINAL, ALL_MUNICIPAL_ITEMS);







    public static void init() {
        ITEMS.register();
    }
}

