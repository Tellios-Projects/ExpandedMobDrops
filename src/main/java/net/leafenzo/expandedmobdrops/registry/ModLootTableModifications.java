package net.leafenzo.expandedmobdrops.registry;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.leafenzo.expandedmobdrops.ModInit;
import net.leafenzo.expandedmobdrops.Super;
import net.leafenzo.expandedmobdrops.item.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.loot.LootTables;

public class ModLootTableModifications {

    public static void registerModLootTableModifications() {
        ModInit.LOGGER.debug("Registering loot table modfiactions for " + Super.MOD_ID);
        modifyEntityLootTables();
    }

    private static void modifyEntityLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (new Identifier("minecraft", "entities/sniffer").equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.ANCIENT_MEAT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f))
                        .build()
                );
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
