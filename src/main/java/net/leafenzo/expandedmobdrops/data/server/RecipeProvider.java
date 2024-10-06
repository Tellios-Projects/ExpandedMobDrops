package net.leafenzo.expandedmobdrops.data.server;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.leafenzo.expandedmobdrops.block.EMDBlocks;
import net.leafenzo.expandedmobdrops.item.EMDItems;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.SmokingRecipe;
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

        generateCookingRecipes(exporter, "smelting", RecipeSerializer.SMELTING, SmeltingRecipe::new, 200);
        generateCookingRecipes(exporter, "smoking", RecipeSerializer.SMOKING, SmokingRecipe::new, 100);
        generateCookingRecipes(exporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 600);
    }

    public static <T extends AbstractCookingRecipe> void generateCookingRecipes(RecipeExporter exporter, String cooker, RecipeSerializer<T> serializer, AbstractCookingRecipe.RecipeFactory<T> recipeFactory, int cookingTime) {
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.BEAR_MEAT, EMDItems.BEAR_STEAK, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.BEAST_MEAT, EMDItems.COOKED_BEAST, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.CANINE_MEAT, EMDItems.COOKED_CANINE, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.FELINE_MEAT, EMDItems.COOKED_FELINE, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.EQUINE_MEAT, EMDItems.COOKED_EQUINE, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.CAMELID_MEAT, EMDItems.COOKED_CAMELID, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.RAW_BUSHMEAT, EMDItems.COOKED_BUSHMEAT, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.ARTHROPOD_FLESH, EMDItems.COOKED_ARTHROPOD, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.CRITTER_MEAT, EMDItems.CRITTER_STEAK, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.RAW_REPTILE, EMDItems.COOKED_REPTILE, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.RAW_AMPHIBIAN, EMDItems.COOKED_AMPHIBIAN, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.RAW_TURTLE, EMDItems.COOKED_TURTLE, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.RAW_BIRD, EMDItems.COOKED_BIRD, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.GLOW_SQUID, EMDItems.COOKED_SQUID, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.SQUID, EMDItems.COOKED_SQUID, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.ANCIENT_CHOPS, EMDItems.ANCIENT_STEAK, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.FUNGAL_MEAT, EMDItems.FUNGAL_STEAK, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.SCULK_TENDRIL, EMDItems.ROASTED_TENDRIL, 0.35F);
        offerCustomFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, EMDItems.STRIDER_CHUNK, EMDItems.STRIDER_JERKY, 0.35F);
    }

    public static <T extends AbstractCookingRecipe> void offerCustomFoodCookingRecipe(
            RecipeExporter exporter,
            String cooker,
            RecipeSerializer<T> serializer,
            AbstractCookingRecipe.RecipeFactory<T> recipeFactory,
            int cookingTime,
            ItemConvertible input,
            ItemConvertible output,
            float experience
    ) {
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(input), RecipeCategory.FOOD, output, experience, cookingTime, serializer, recipeFactory)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, getItemPath(output) + "_from_" + getItemPath(input) + "_in_" + cooker);
    }
}
