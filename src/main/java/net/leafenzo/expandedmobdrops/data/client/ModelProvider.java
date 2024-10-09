package net.leafenzo.expandedmobdrops.data.client;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.leafenzo.expandedmobdrops.ExpandedMobDrops;
import net.leafenzo.expandedmobdrops.block.EMDBlocks;
import net.leafenzo.expandedmobdrops.item.EMDItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.VariantsBlockStateSupplier;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        generator.registerSimpleCubeAll(EMDBlocks.FAT_BLOCK);

        generator.blockStateCollector
                .accept(
                        VariantsBlockStateSupplier.create(EMDBlocks.FOX_HIDE, BlockStateVariant.create().put(VariantSettings.MODEL, TextureMap.getId(EMDBlocks.FOX_HIDE)))
                                .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates())
                );
        generator.excludeFromSimpleItemModelGeneration(EMDBlocks.FOX_HIDE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(EMDItems.FOX_HIDE, Models.GENERATED);

        Registries.ITEM.forEach(
                item -> {
                    if (item instanceof BlockItem) {
                        return;
                    }

                    Identifier id = Registries.ITEM.getId(item);
                    if (id.getNamespace().equals(ExpandedMobDrops.MOD_ID)) {
                        generator.register(item, Models.GENERATED);
                    }
                }
        );
    }
}
