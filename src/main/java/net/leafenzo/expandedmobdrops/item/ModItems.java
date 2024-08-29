package net.leafenzo.expandedmobdrops.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.leafenzo.expandedmobdrops.ModInit;
import net.leafenzo.expandedmobdrops.Super;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
     public static final Item ARTHROPOD_FLESH = registerItem("arthropod_flesh", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(1)
             .saturationModifier(0.8f)
             .build()
     )));

     public static final Item BEAR_HIDE = registerItem("bear_hide", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item BEAR_MEAT = registerItem("bear_meat", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item BEAR_STEAK = registerItem("bear_steak", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item BEAST_MEAT = registerItem("beast_meat", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item BUGMEAT = registerItem("bugmeat", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item CAMELID_MEAT = registerItem("camelid_meat", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item CANINE_MEAT = registerItem("canine_meat", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item COOKED_AMPHIBIAN = registerItem("cooked_amphibian", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item COOKED_ARTHROPOD = registerItem("cooked_arthropod", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item COOKED_BEAST = registerItem("cooked_beast", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item COOKED_BIRD = registerItem("cooked_bird", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item COOKED_BUSHMEAT = registerItem("cooked_bushmeat", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item COOKED_CAMELID = registerItem("cooked_camelid", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item COOKED_CANINE = registerItem("cooked_canine", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item COOKED_EQUINE = registerItem("cooked_equine", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item COOKED_FELINE = registerItem("cooked_feline", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item COOKED_REPTILE = registerItem("cooked_reptile", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item COOKED_SQUID = registerItem("cooked_squid", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item COOKED_TURTLE = registerItem("cooked_turtle", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item CRITTER_MEAT = registerItem("critter_meat", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item CRITTER_STEAK = registerItem("critter_steak", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item EQUINE_MEAT = registerItem("equine_meat", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item FAT = registerItem("fat", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item FELINE_MEAT = registerItem("feline_meat", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item FOX_HIDE = registerItem("fox_hide", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item FUNGAL_MEAT = registerItem("fungal_meat", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item FUNGAL_STEAK = registerItem("fungal_steak", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item GLOW_SQUID = registerItem("glow_squid", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item INSECT_FLESH = registerItem("insect_flesh", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item MOOSHROOM_HIDE = registerItem("mooshroom_hide", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item PANDA_HIDE = registerItem("panda_hide", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item POLAR_BEAR_HIDE = registerItem("polar_bear_hide", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item RAW_AMPHIBIAN = registerItem("raw_amphibian", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item RAW_BIRD = registerItem("raw_bird", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item RAW_BUSHMEAT = registerItem("raw_bushmeat", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item RAW_REPTILE = registerItem("raw_reptile", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item RAW_TURTLE = registerItem("raw_turtle", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item ROASTED_TENDRIL = registerItem("roasted_tendril", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item ROTTEN_PORKCHOP = registerItem("rotten_porkchop", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item SCALEY_HIDE = registerItem("scaley_hide", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item SCULK_TENDRIL = registerItem("sculk_tendril", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item SNIFFER_HIDE = registerItem("sniffer_hide", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item SQUID = registerItem("squid", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item STRIDER_CHUNK = registerItem("strider_chunk", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item STRIDER_JERKY = registerItem("strider_jerky", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

     public static final Item STRIDER_SKIN = registerItem("strider_skin", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));

    public static final Item ANCIENT_MEAT = registerItem("ancient_meat", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(4)
            .saturationModifier(0.5f)
            .build())
    ));
    public static final Item COOKED_ANCIENT_MEAT = registerItem("cooked_ancient_meat", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(9)
            .saturationModifier(1.6f)
            .build())
    ));

     public static final Item ANCIENT_STEAK = registerItem("ancient_steak", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
             .hunger(5)
             .saturationModifier(1.0f)
             .build()
     )));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Super.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ModInit.LOGGER.info("Registering Mod Items for " + Super.MOD_ID);
    }}
