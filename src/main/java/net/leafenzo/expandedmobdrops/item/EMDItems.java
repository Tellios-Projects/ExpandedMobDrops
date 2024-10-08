package net.leafenzo.expandedmobdrops.item;

import net.leafenzo.expandedmobdrops.ExpandedMobDrops;
import net.leafenzo.expandedmobdrops.block.EMDBlocks;
import net.minecraft.block.Block;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EMDItems {
    // Mammal Meats
    public static final Item BEAR_MEAT = registerFood(
            "bear_meat",
            new FoodComponent.Builder()
    );
    
    public static final Item BEAR_STEAK = registerFood(
            "bear_steak",
            new FoodComponent.Builder()
    );

    public static final Item BEAST_MEAT = registerFood(
            "beast_meat",
            new FoodComponent.Builder()
    );
    
    public static final Item COOKED_BEAST = registerFood(
            "cooked_beast",
            new FoodComponent.Builder()
    );

    public static final Item CANINE_MEAT = registerFood(
            "canine_meat",
            new FoodComponent.Builder()
    );
    
    public static final Item COOKED_CANINE = registerFood(
            "cooked_canine",
            new FoodComponent.Builder()
    );

    public static final Item FELINE_MEAT = registerFood(
            "feline_meat",
            new FoodComponent.Builder()
    );

    public static final Item COOKED_FELINE = registerFood(
            "cooked_feline",
            new FoodComponent.Builder()
    );

    public static final Item EQUINE_MEAT = registerFood(
            "equine_meat",
            new FoodComponent.Builder()
    );

    public static final Item COOKED_EQUINE = registerFood(
            "cooked_equine",
            new FoodComponent.Builder()
    );

    public static final Item CAMELID_MEAT = registerFood(
            "camelid_meat",
            new FoodComponent.Builder()
    );

    public static final Item COOKED_CAMELID = registerFood(
            "cooked_camelid",
            new FoodComponent.Builder()
    );

    /* Critter, Insect & Bushmeat */

    public static final Item RAW_BUSHMEAT = registerFood(
            "raw_bushmeat",
            new FoodComponent.Builder()
    );

    public static final Item COOKED_BUSHMEAT = registerFood(
            "cooked_bushmeat",
            new FoodComponent.Builder()
    );

    public static final Item BUGMEAT = registerFood(
            "bugmeat",
            new FoodComponent.Builder()
    );

    public static final Item ARTHROPOD_FLESH = registerFood(
            "arthropod_flesh",
            new FoodComponent.Builder()
    );

    public static final Item COOKED_ARTHROPOD = registerFood(
            "cooked_arthropod",
            new FoodComponent.Builder()
    );

    public static final Item INSECT_FLESH = registerFood(
            "insect_flesh",
            new FoodComponent.Builder()
    );

    public static final Item CRITTER_MEAT = registerFood(
            "critter_meat",
            new FoodComponent.Builder()
    );

    public static final Item CRITTER_STEAK = registerFood(
            "critter_steak",
            new FoodComponent.Builder()
    );

    /* Reptile & Amphibian Meats */

    public static final Item RAW_REPTILE = registerFood(
            "raw_reptile",
            new FoodComponent.Builder()
    );

    public static final Item COOKED_REPTILE = registerFood(
            "cooked_reptile",
            new FoodComponent.Builder()
    );

    public static final Item RAW_AMPHIBIAN = registerFood(
            "raw_amphibian",
            new FoodComponent.Builder()
    );

    public static final Item COOKED_AMPHIBIAN = registerFood(
            "cooked_amphibian",
            new FoodComponent.Builder()
    );

    public static final Item RAW_TURTLE = registerFood(
            "raw_turtle",
            new FoodComponent.Builder()
    );

    public static final Item COOKED_TURTLE = registerFood(
            "cooked_turtle",
            new FoodComponent.Builder()
    );

    /* Bird & Flying Creatures */

    public static final Item RAW_BIRD = registerFood(
            "raw_bird",
            new FoodComponent.Builder()
    );

    public static final Item COOKED_BIRD = registerFood(
            "cooked_bird",
            new FoodComponent.Builder()
    );

    /* Fish & Squid Meats */

    public static final Item SQUID = registerFood(
            "squid",
            new FoodComponent.Builder()
    );

    public static final Item COOKED_SQUID = registerFood(
            "cooked_squid",
            new FoodComponent.Builder()
    );

    public static final Item GLOW_SQUID = registerFood(
            "glow_squid",
            new FoodComponent.Builder()
    );

    /* Fantasy Meats */

    public static final Item ANCIENT_CHOPS = registerFood(
            "ancient_chops",
            new FoodComponent.Builder()
    );

    public static final Item ANCIENT_STEAK = registerFood(
            "ancient_steak",
            new FoodComponent.Builder()
    );

    public static final Item FUNGAL_MEAT = registerFood(
            "fungal_meat",
            new FoodComponent.Builder()
    );

    public static final Item FUNGAL_STEAK = registerFood(
            "fungal_steak",
            new FoodComponent.Builder()
    );

    public static final Item SCULK_TENDRIL = registerFood(
            "sculk_tendril",
            new FoodComponent.Builder()
    );

    public static final Item ROASTED_TENDRIL = registerFood(
            "roasted_tendril",
            new FoodComponent.Builder()
    );

    public static final Item STRIDER_CHUNK = registerFood(
            "strider_chunk",
            new FoodComponent.Builder()
    );

    public static final Item STRIDER_JERKY = registerFood(
            "strider_jerky",
            new FoodComponent.Builder()
    );

    public static final Item ROTTEN_PORKCHOP = registerFood(
            "rotten_porkchop",
            new FoodComponent.Builder()
    );

    /* Animal Hides */

    public static final Item FOX_HIDE = registerMaterial("fox_hide");
    public static final Item MOOSHROOM_HIDE = registerMaterial("mooshroom_hide");
    public static final Item PANDA_HIDE = registerMaterial("panda_hide");
    public static final Item POLAR_BEAR_HIDE = registerMaterial("polar_bear_hide");
    public static final Item SCALY_HIDE = registerMaterial("scaly_hide");
    public static final Item SNIFFER_HIDE = registerMaterial("sniffer_hide");
    public static final Item BEAR_HIDE = registerMaterial("bear_hide");
    public static final Item STRIDER_SKIN = registerMaterial("strider_skin");

    /* Misc */

    public static final Item FAT = registerFood(
            "fat",
            new FoodComponent.Builder()
                    .nutrition(2)
                    .saturationModifier(0.8f)
                    .alwaysEdible()
                    .snack()
    );

    public static final Item FAT_BLOCK = registerBlock("fat_block", EMDBlocks.FAT_BLOCK);

    private static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ExpandedMobDrops.MOD_ID, id), item);
    }

    private static Item registerFood(String id, FoodComponent.Builder builder) {
        Item item = new Item(new Item.Settings().food(builder.build()));
        return register(id, item);
    }

    private static Item registerMaterial(String id) {
        return register(id, new Item(new Item.Settings()));
    }

    private static Item registerBlock(String id, Block block) {
        return register(id, new BlockItem(block, new Item.Settings()));
    }
}
