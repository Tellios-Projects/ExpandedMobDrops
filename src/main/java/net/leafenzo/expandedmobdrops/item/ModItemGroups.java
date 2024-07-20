package net.leafenzo.expandedmobdrops.item;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.leafenzo.expandedmobdrops.ModInit;
import net.leafenzo.expandedmobdrops.Super;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static void registerModItemGroups() {
        ModInit.LOGGER.debug("Registering item groups for " + Super.MOD_ID);
    }

    public static ItemGroup TEMPLATE = Registry.register(Registries.ITEM_GROUP, new Identifier(Super.MOD_ID, "expandedmobdrops"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.expandedmobdrops"))
                    .icon(() -> new ItemStack(Blocks.AIR)).entries((displayContext, entries) -> {
                     //entries.add(ModBlocks.);
                    }).build());
}
