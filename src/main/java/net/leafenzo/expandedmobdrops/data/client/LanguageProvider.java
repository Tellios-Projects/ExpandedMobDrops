package net.leafenzo.expandedmobdrops.data.client;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.leafenzo.expandedmobdrops.block.EMDBlocks;
import net.leafenzo.expandedmobdrops.item.EMDItemGroups;
import net.leafenzo.expandedmobdrops.item.EMDItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class LanguageProvider extends FabricLanguageProvider {
    public LanguageProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> lookup) {
        super(output, lookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup lookup, TranslationBuilder builder) {
        builder.add(EMDItemGroups.createTranslationString("item_group"), "Expanded Mob Drops");

        builder.add(EMDBlocks.FAT_BLOCK, "Fat Block");

        builder.add(EMDItems.ANCIENT_CHOPS, "Ancient Chops");
        builder.add(EMDItems.ANCIENT_STEAK, "Ancient Steak");
        builder.add(EMDItems.EQUINE_MEAT, "Equine Meat");
        builder.add(EMDItems.FAT, "Lump of Fat");
        builder.add(EMDItems.FELINE_MEAT, "Feline Meat");
        builder.add(EMDItems.FOX_HIDE, "Fox Hide");
        builder.add(EMDItems.FUNGAL_MEAT, "Fungal Meat");
        builder.add(EMDItems.FUNGAL_STEAK, "Fungal Steak");
        builder.add(EMDItems.GLOW_SQUID, "Glow Squid");
        builder.add(EMDItems.INSECT_FLESH, "Insect Flesh");
        builder.add(EMDItems.MOOSHROOM_HIDE, "Mooshroom Hide");
        builder.add(EMDItems.PANDA_HIDE, "Panda Hide");
        builder.add(EMDItems.POLAR_BEAR_HIDE, "Polar Bear Hide");
        builder.add(EMDItems.RAW_AMPHIBIAN, "Raw Amphibian");
        builder.add(EMDItems.RAW_BIRD, "Raw Bird");
        builder.add(EMDItems.RAW_BUSHMEAT, "Raw Bushmeat");
        builder.add(EMDItems.RAW_REPTILE, "Raw Reptile");
        builder.add(EMDItems.RAW_TURTLE, "Raw Turtle");
        builder.add(EMDItems.ROASTED_TENDRIL, "Roasted Tendril");
        builder.add(EMDItems.ROTTEN_PORKCHOP, "Rotten Porkchop");
        builder.add(EMDItems.SCALY_HIDE, "Scaly Hide");
        builder.add(EMDItems.SCULK_TENDRIL, "Sculk Tendril");
        builder.add(EMDItems.SNIFFER_HIDE, "Sniffer Hide");
        builder.add(EMDItems.SQUID, "Squid");
        builder.add(EMDItems.STRIDER_CHUNK, "Strider Chunk");
        builder.add(EMDItems.STRIDER_JERKY, "Strider Jerky");
        builder.add(EMDItems.STRIDER_SKIN, "Strider Skin");
        builder.add(EMDItems.ARTHROPOD_FLESH, "Arthropod Flesh");
        builder.add(EMDItems.BEAR_HIDE, "Bear Hide");
        builder.add(EMDItems.BEAR_MEAT, "Bear Meat");
        builder.add(EMDItems.BEAR_STEAK, "Bear Steak");
        builder.add(EMDItems.BEAST_MEAT, "Beast Meat");
        builder.add(EMDItems.BUGMEAT, "Bugmeat");
        builder.add(EMDItems.CAMELID_MEAT, "Camelid Meat");
        builder.add(EMDItems.CANINE_MEAT, "Canine Meat");
        builder.add(EMDItems.COOKED_AMPHIBIAN, "Cooked Amphibian");
        builder.add(EMDItems.COOKED_ARTHROPOD, "Cooked Arthropod");
        builder.add(EMDItems.COOKED_BEAST, "Cooked Beast");
        builder.add(EMDItems.COOKED_BIRD, "Cooked Bird");
        builder.add(EMDItems.COOKED_BUSHMEAT, "Cooked Bushmeat");
        builder.add(EMDItems.COOKED_CAMELID, "Cooked Camelid");
        builder.add(EMDItems.COOKED_CANINE, "Cooked Canine");
        builder.add(EMDItems.COOKED_EQUINE, "Cooked Equine");
        builder.add(EMDItems.COOKED_FELINE, "Cooked Feline");
        builder.add(EMDItems.COOKED_REPTILE, "Cooked Reptile");
        builder.add(EMDItems.COOKED_SQUID, "Cooked Squid");
        builder.add(EMDItems.COOKED_TURTLE, "Cooked Turtle");
        builder.add(EMDItems.CRITTER_MEAT, "Critter Meat");
        builder.add(EMDItems.CRITTER_STEAK, "Critter Steak");
    }
}
