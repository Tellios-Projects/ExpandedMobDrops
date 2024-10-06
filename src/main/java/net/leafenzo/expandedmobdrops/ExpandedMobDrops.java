package net.leafenzo.expandedmobdrops;

import com.google.common.reflect.Reflection;
import net.fabricmc.api.ModInitializer;

import net.leafenzo.expandedmobdrops.block.EMDBlocks;
import net.leafenzo.expandedmobdrops.item.EMDItemGroups;
import net.leafenzo.expandedmobdrops.item.EMDItems;
import net.leafenzo.expandedmobdrops.loot.EMDLootTableModifications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpandedMobDrops implements ModInitializer {
    public static final String MOD_ID = "expandedmobdrops";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        Reflection.initialize(
                EMDBlocks.class,
                EMDItems.class,
                EMDItemGroups.class
        );

        EMDLootTableModifications.INSTANCE.initialize();
    }
}
