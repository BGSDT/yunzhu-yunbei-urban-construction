package com.beigu.yunbeiuc.item;

import com.beigu.yunbeiuc.YunbeiUrbanConstruction;
import com.beigu.yunbeiuc.api.item.CreativeTabHandle;
import com.beigu.yunbeiuc.api.mapper.VersionServices;
import net.minecraft.world.item.ItemStack;

public final class ModItemGroups {
    public static final CreativeTabHandle YUNBEIUC_MUNICIPAL_GROUP = VersionServices.creativeTabs().create(
            VersionServices.resources().create(YunbeiUrbanConstruction.MOD_ID, "municipal"),
            () -> new ItemStack(ModItems.WAND.get()));

    private ModItemGroups() {
    }

    public static void init() {
        VersionServices.creativeTabs().registerTabs();
        VersionServices.creativeTabs().append(YUNBEIUC_MUNICIPAL_GROUP, ModItems.ALL_MUNICIPAL_ITEMS);
    }
}
