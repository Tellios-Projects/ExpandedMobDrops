package net.leafenzo.expandedmobdrops.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.leafenzo.expandedmobdrops.data.client.ModelProvider;
import net.leafenzo.expandedmobdrops.data.server.BlockLootTableProvider;
import net.leafenzo.expandedmobdrops.data.client.LanguageProvider;
import net.leafenzo.expandedmobdrops.data.server.RecipeProvider;

public class ExpandedMobDropsDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(ModelProvider::new);
        pack.addProvider(LanguageProvider::new);
        pack.addProvider(BlockLootTableProvider::new);
        pack.addProvider(RecipeProvider::new);
    }
}
