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

    public static ItemGroup EXPANDED_MOB_DROPS = Registry.register(Registries.ITEM_GROUP, new Identifier(Super.MOD_ID, "expanded_mob_drops"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.expanded_mob_drops"))
                    .icon(() -> new ItemStack(Blocks.AIR)).entries((displayContext, entries) -> {
                     entries.add(ModItems.ANCIENT_MEAT);
                     entries.add(ModItems.COOKED_ANCIENT_MEAT);
                     entries.add(ModItems.EQUINE_MEAT);
                     entries.add(ModItems.FAT);
                     entries.add(ModItems.FELINE_MEAT);
                     entries.add(ModItems.FOX_HIDE);
                     entries.add(ModItems.FUNGAL_MEAT);
                     entries.add(ModItems.FUNGAL_STEAK);
                     entries.add(ModItems.GLOW_SQUID);
                     entries.add(ModItems.INSECT_FLESH);
                     entries.add(ModItems.MOOSHROOM_HIDE);
                     entries.add(ModItems.PANDA_HIDE);
                     entries.add(ModItems.POLAR_BEAR_HIDE);
                     entries.add(ModItems.RAW_AMPHIBIAN);
                     entries.add(ModItems.RAW_BIRD);
                     entries.add(ModItems.RAW_BUSHMEAT);
                     entries.add(ModItems.RAW_REPTILE);
                     entries.add(ModItems.RAW_TURTLE);
                     entries.add(ModItems.ROASTED_TENDRIL);
                     entries.add(ModItems.ROTTEN_PORKCHOP);
                     entries.add(ModItems.SCALEY_HIDE);
                     entries.add(ModItems.SCULK_TENDRIL);
                     entries.add(ModItems.SNIFFER_HIDE);
                     entries.add(ModItems.SQUID);
                     entries.add(ModItems.STRIDER_CHUNK);
                     entries.add(ModItems.STRIDER_JERKY);
                     entries.add(ModItems.STRIDER_SKIN);
                     entries.add(ModItems.ANCIENT_STEAK);
                     entries.add(ModItems.ARTHROPOD_FLESH);
                     entries.add(ModItems.BEAR_HIDE);
                     entries.add(ModItems.BEAR_MEAT);
                     entries.add(ModItems.BEAR_STEAK);
                     entries.add(ModItems.BEAST_MEAT);
                     entries.add(ModItems.BUGMEAT);
                     entries.add(ModItems.CAMELID_MEAT);
                     entries.add(ModItems.CANINE_MEAT);
                     entries.add(ModItems.COOKED_AMPHIBIAN);
                     entries.add(ModItems.COOKED_ARTHROPOD);
                     entries.add(ModItems.COOKED_BEAST);
                     entries.add(ModItems.COOKED_BIRD);
                     entries.add(ModItems.COOKED_BUSHMEAT);
                     entries.add(ModItems.COOKED_CAMELID);
                     entries.add(ModItems.COOKED_CANINE);
                     entries.add(ModItems.COOKED_EQUINE);
                     entries.add(ModItems.COOKED_FELINE);
                     entries.add(ModItems.COOKED_REPTILE);
                     entries.add(ModItems.COOKED_SQUID);
                     entries.add(ModItems.COOKED_TURTLE);
                     entries.add(ModItems.CRITTER_MEAT);
                     entries.add(ModItems.CRITTER_STEAK);
                    }).build());
}
