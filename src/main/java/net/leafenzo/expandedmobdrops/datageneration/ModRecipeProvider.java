package net.leafenzo.expandedmobdrops.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.leafenzo.expandedmobdrops.Super;
import net.leafenzo.expandedmobdrops.item.ModItems;
import net.leafenzo.expandedmobdrops.registration.WoodSet;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;


public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) { super(output); }

//    public static void offerReversibleCompactingRecipes(Consumer<RecipeJsonProvider> exporter, RecipeCategory reverseCategory, ItemConvertible baseItem, RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingId, @Nullable String compactingGroup, String reverseId, @Nullable String reverseGroup) {
//        ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 9).input(compactItem).group(reverseGroup).criterion(RecipeProvider.hasItem(compactItem), RecipeProvider.conditionsFromItem(compactItem)).offerTo(exporter, new Identifier(reverseId+"_from_"+compactingId));
//        ShapedRecipeJsonBuilder.create(compactingCategory, compactItem).input(Character.valueOf('#'), baseItem).pattern("###").pattern("###").pattern("###").group(compactingGroup).criterion(RecipeProvider.hasItem(baseItem), RecipeProvider.conditionsFromItem(baseItem)).offerTo(exporter, new Identifier(compactingId+"_from_"+reverseId));
//    }
    public static void offerStairsRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createStairsRecipe(output, Ingredient.ofItems(input))
                .criterion(FabricRecipeProvider.hasItem(input), FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }
    public static void offerSlabRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, output, input);
    }
    public static void offerWallRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, output, input);
    }
    public static void offerTrapdoorRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createTrapdoorRecipe(output, Ingredient.ofItems(input))
                .criterion("has_planks", FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerDoorRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createDoorRecipe(output, Ingredient.ofItems(input))
                .criterion("has_planks", FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerButtonRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createTransmutationRecipe(output, Ingredient.ofItems(input))
                .criterion("has_planks", FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerFenceRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createFenceRecipe(output, Ingredient.ofItems(input))
                .criterion("has_planks", FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerFenceGateRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createFenceGateRecipe(output, Ingredient.ofItems(input))
                .criterion("has_planks", FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerSignRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createSignRecipe(output, Ingredient.ofItems(input))
                .criterion("has_planks", FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerShapelessRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input1, ItemConvertible input2, int  outputCount) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output, outputCount)
                .input(input1)
                .input(input2)
                .criterion(RecipeProvider.hasItem(input1), RecipeProvider.conditionsFromItem(input1))
                .criterion(RecipeProvider.hasItem(input2), RecipeProvider.conditionsFromItem(input2))
                .offerTo(exporter, RecipeProvider.convertBetween(output, input1));
    }

    public static void offerPlanksRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input, int count) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, count).input(input).group("planks").criterion("has_logs", RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerReversible2x2CompactingRecipes(Consumer<RecipeJsonProvider> exporter, RecipeCategory reverseCategory, ItemConvertible baseItem, RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingId, @Nullable String compactingGroup, String reverseId, @Nullable String reverseGroup) {
        ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 4).input(compactItem).group(reverseGroup).criterion(RecipeProvider.hasItem(compactItem), RecipeProvider.conditionsFromItem(compactItem)).offerTo(exporter, new Identifier(reverseId+"_from_"+compactingId));
        ShapedRecipeJsonBuilder.create(compactingCategory, compactItem)
                .input(Character.valueOf('#'), baseItem)
                .pattern("##")
                .pattern("##")
                .group(compactingGroup)
                .criterion(FabricRecipeProvider.hasItem(baseItem), FabricRecipeProvider.conditionsFromItem(baseItem))
                .offerTo(exporter, new Identifier(compactingId+"_from_"+reverseId));
    }
    public static void offerReversible2x2CompactingRecipes(Consumer<RecipeJsonProvider> exporter, RecipeCategory reverseCategory, ItemConvertible baseItem, RecipeCategory compactingCategory, ItemConvertible compactItem) {
        offerReversible2x2CompactingRecipes(exporter, reverseCategory, baseItem, compactingCategory, compactItem, RecipeProvider.getRecipeName(compactItem), Super.MOD_ID + ":" + Registries.ITEM.getId(baseItem.asItem()).getPath(), RecipeProvider.getRecipeName(baseItem), Super.MOD_ID + ":" + Registries.ITEM.getId(baseItem.asItem()).getPath() + "_reverse");
    }

    public static void offerWoodsetRecipes(Consumer<RecipeJsonProvider> exporter, WoodSet woodSet) {
        Block log = woodSet.getLog();
        Block strippedLog = woodSet.getStrippedLog();
        Block strippedWood = woodSet.getStrippedWood();
        Block wood = woodSet.getWood();
        Block planks = woodSet.getPlanks();
        Block stairs = woodSet.getStairs();
        Block slab = woodSet.getSlab();
        Block trapDoor = woodSet.getTrapDoor();
        Block door = woodSet.getDoor();
        Block pressurePlate = woodSet.getPressurePlate();
        Block button = woodSet.getButton();
        Block fence = woodSet.getFence();
        Block fenceGate = woodSet.getFenceGate();
        Item boat = woodSet.getBoatItem();
        Item chestBoat = woodSet.getChestBoatItem();
        Item sign = woodSet.getSignItem();
        Item hangingSign = woodSet.getHangingSignItem();

        // this many checks is a lil stinky, but I just don't really want to deal with a woodset that doesn't have a trapdoor for some reason or another, which might happen
        if(log != null && wood != null) { offerBarkBlockRecipe(exporter, wood, log); }
        if(strippedLog != null && strippedWood != null) { offerBarkBlockRecipe(exporter, strippedWood, strippedLog); }
        if(planks != null) {
            //stick recipes are have already been handled by the item tag
            offerPlanksRecipe(exporter, planks, woodSet.getItemLogsTag(), 4);
            if (trapDoor != null) { offerTrapdoorRecipe(exporter, trapDoor, planks); }
            if (door != null) { offerDoorRecipe(exporter, door, planks); }
            if (pressurePlate != null) { offerPressurePlateRecipe(exporter, pressurePlate, planks); }
            if (button != null) { offerButtonRecipe(exporter, button, planks); }
            if (fence != null) { offerFenceRecipe(exporter, fence, planks); }
            if (fenceGate != null) { offerFenceGateRecipe(exporter, fenceGate, planks); }
            if (boat != null) { offerBoatRecipe(exporter, boat, planks); }
            if (chestBoat != null) { offerChestBoatRecipe(exporter, chestBoat, boat); }
            if (stairs != null) { offerStairsRecipe(exporter, stairs, planks); }
            if (slab != null) { offerSlabRecipe(exporter, slab, planks); }
            if (sign != null) { offerSignRecipe(exporter, sign, planks); }
            if (strippedLog != null && hangingSign != null) { offerHangingSignRecipe(exporter, hangingSign, strippedLog); }
        }
    }

    public static void offerMeatCookingRecipes(Consumer<RecipeJsonProvider> exporter, ItemConvertible input, ItemConvertible output) {
        offerFoodCookingRecipe(exporter, "smoking", RecipeSerializer.SMOKING, 100, input, output, 0.35f);
        offerFoodCookingRecipe(exporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, 600, input, output, 0.35f);
        offerFoodCookingRecipe(exporter, "smelting", RecipeSerializer.SMELTING, 200, input, output, 0.35f);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerMeatCookingRecipes(exporter, ModItems.ANCIENT_MEAT, ModItems.COOKED_ANCIENT_MEAT);
    }
}
