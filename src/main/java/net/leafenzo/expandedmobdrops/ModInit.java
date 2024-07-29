package net.leafenzo.expandedmobdrops;

import net.fabricmc.api.ModInitializer;
import net.leafenzo.expandedmobdrops.block.ModBlocks;
import net.leafenzo.expandedmobdrops.item.ModItemGroups;
import net.leafenzo.expandedmobdrops.item.ModItems;
import net.leafenzo.expandedmobdrops.particle.ModParticleTypes;
import net.leafenzo.expandedmobdrops.registries.ModFabricRegistries;
import net.leafenzo.expandedmobdrops.registry.ModLootTableModifications;
import net.leafenzo.expandedmobdrops.util.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModInit implements ModInitializer {
    public static final String MOD_ID = Super.MOD_ID;
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
//        ModBlockEntityType.RegisterModBlockEntityTypes();
        ModLootTableModifications.registerModLootTableModifications();
        ModParticleTypes.registerModParticleTypes();
        ModFabricRegistries.registerFlammableBlocks();
//        ModFabricRegistries.registerCompostingChances();
//        ModFabricRegistries.registerVillagerInteractions();
//        ModFabricRegistries.registerFuels();
//        DispenserBehavior.RegisterDispenserBehaviors();
//        ModRecipeSerializer.registerModRecipeSerializer();
//        ModEffects.registerModEffects();
//        ModPotions.registerModPotions();
        ModWorldGen.registerWorldGen();
        ModItemGroups.registerModItemGroups();
    }
}

