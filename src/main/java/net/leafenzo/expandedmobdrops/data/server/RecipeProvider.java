package net.leafenzo.expandedmobdrops.data.server;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.leafenzo.expandedmobdrops.block.EMDBlocks;
import net.leafenzo.expandedmobdrops.item.EMDItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, EMDBlocks.FAT_BLOCK, EMDItems.FAT);
    }
}
