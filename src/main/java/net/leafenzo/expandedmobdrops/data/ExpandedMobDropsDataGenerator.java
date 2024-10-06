package net.leafenzo.expandedmobdrops.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ExpandedMobDropsDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(ModelProvider::new);
        pack.addProvider(LanguageProvider::new);
        pack.addProvider(BlockLootTableGenerator::new);
    }
}
