package net.leafenzo.expandedmobdrops.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.leafenzo.expandedmobdrops.ExpandedMobDrops;
import net.leafenzo.expandedmobdrops.block.EMDBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
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
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
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
