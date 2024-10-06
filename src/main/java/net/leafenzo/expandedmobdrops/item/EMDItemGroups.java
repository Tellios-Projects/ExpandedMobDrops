package net.leafenzo.expandedmobdrops.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.leafenzo.expandedmobdrops.ExpandedMobDrops;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Supplier;

public class EMDItemGroups {
    public static final ItemGroup ITEM_GROUP = register(
            "item_group",
            () -> EMDItems.ANCIENT_CHOPS,
            (context, entries) -> {
                List<Item> items = Registries.ITEM.stream()
                        .filter(
                                item -> {
                                    Identifier id = Registries.ITEM.getId(item);
                                    return id.getNamespace().equals(ExpandedMobDrops.MOD_ID);
                                }
                        )
                        .toList();

                items.forEach(entries::add);
            }
    );

    private static ItemGroup register(String id, ItemGroup.Builder builder) {
        return Registry.register(Registries.ITEM_GROUP, Identifier.of(ExpandedMobDrops.MOD_ID, id), builder.build());
    }

    private static ItemGroup register(String id, Supplier<Item> iconSupplier, ItemGroup.EntryCollector entryCollector) {
        return register(
                id,
                FabricItemGroup.builder()
                        .icon(
                                () -> {
                                    Item item = iconSupplier.get();
                                    return new ItemStack(item);
                                }
                        )
                        .displayName(Text.translatable(createTranslationString(id)))
                        .entries(entryCollector)
        );
    }

    public static String createTranslationString(String id) {
        return "itemGroup." + ExpandedMobDrops.MOD_ID + "." + id;
    }
}
