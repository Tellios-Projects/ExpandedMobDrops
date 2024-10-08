package net.leafenzo.expandedmobdrops.loot;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.leafenzo.expandedmobdrops.item.EMDItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.AnyOfLootCondition;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.FurnaceSmeltLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.entity.EntityEquipmentPredicate;
import net.minecraft.predicate.entity.EntityFlagsPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.EnchantmentsPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.predicate.item.ItemSubPredicateTypes;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EMDLootTableModifications {
    public static final EMDLootTableModifications INSTANCE = new EMDLootTableModifications();

    private final Map<Identifier, LootTableModifier> modifiers = new HashMap<>();

    private EMDLootTableModifications() {
        setupModifiers();
    }

    public void initialize() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            Identifier id = key.getValue();
            LootTableModifier modifier = modifiers.get(id);
            if (modifier != null) {
                modifier.modify(tableBuilder, registries);
            }
        });
    }

    private void setupModifiers() {
        addModifier(EntityType.POLAR_BEAR, (builder, lookup) -> {
            addSmeltableMobDrop(builder, lookup, EMDItems.BEAR_MEAT, 2.0f);
            addMobDrop(builder, EMDItems.BEAR_HIDE, 1.0f);
            addMobDrop(builder, EMDItems.POLAR_BEAR_HIDE, 1.0f);
        });

        addSimpleSmeltableMobDrop(EntityType.RAVAGER, EMDItems.BEAST_MEAT, 2.0f);

        addModifier(EntityType.WOLF, this::addCanineDrops);
        addModifier(EntityType.FOX, (builder, lookup) -> {
            this.addCanineDrops(builder, lookup);
            addMobDrop(builder, EMDItems.FOX_HIDE, 1.0f);
        });

        addModifier(EntityType.CAT, this::addFelineDrops);
        addModifier(EntityType.OCELOT, this::addFelineDrops);

        addModifier(EntityType.HORSE, this::addEquineDrops);
        addModifier(EntityType.DONKEY, this::addEquineDrops);
        addModifier(EntityType.MULE, this::addEquineDrops);

        addModifier(EntityType.CAMEL, this::addCamelidDrops);
        addModifier(EntityType.LLAMA, this::addCamelidDrops);

        addModifier(EntityType.BEE, this::addBugDrops);
        addModifier(EntityType.SILVERFISH, this::addBugDrops);
        addModifier(EntityType.ENDERMITE, this::addBugDrops);

        addModifier(EntityType.SPIDER, this::addArthropodDrops);
        addModifier(EntityType.CAVE_SPIDER, this::addArthropodDrops);

        addModifier(EntityType.FROG, this::addAmphibianDrops);
        addModifier(EntityType.AXOLOTL, this::addAmphibianDrops);

        addSimpleSmeltableMobDrop(EntityType.TURTLE, EMDItems.RAW_TURTLE, 2.0f);
        addSimpleSmeltableMobDrop(EntityType.PARROT, EMDItems.RAW_BIRD, 2.0f);
        addSimpleSmeltableMobDrop(EntityType.SQUID, EMDItems.SQUID, 2.0f);
        addSimpleSmeltableMobDrop(EntityType.GLOW_SQUID, EMDItems.GLOW_SQUID, 2.0f);
        addSimpleSmeltableMobDrop(EntityType.ARMADILLO, EMDItems.RAW_BUSHMEAT, 2.0f);
        addSimpleSmeltableMobDrop(EntityType.BAT, EMDItems.CRITTER_MEAT, 2.0f);

        addModifier(EntityType.WARDEN, (builder, lookup) -> {
            addSmeltableMobDrop(builder, lookup, EMDItems.SCULK_TENDRIL, 2.0f);
        });

        addModifier(EntityType.MOOSHROOM, (builder, lookup) -> {
            addSmeltableMobDrop(builder, lookup, EMDItems.FUNGAL_MEAT, 2.0f);
            addMobDrop(builder, EMDItems.MOOSHROOM_HIDE, 1.0f);
        });

        addSimpleSmeltableMobDrop(EntityType.STRIDER, EMDItems.STRIDER_CHUNK, 2.0f);

        addSimpleMobDrop(EntityType.PANDA, EMDItems.PANDA_HIDE, 1.0f);

        addModifier(EntityType.SNIFFER, (builder, lookup) -> {
            addSmeltableMobDrop(builder, lookup, EMDItems.ANCIENT_CHOPS, 2.0f);
            addMobDrop(builder, EMDItems.SNIFFER_HIDE, 1.0f);
        });

        addModifier(EntityType.PIG, createFatDrops(3.0f));
        addModifier(EntityType.HOGLIN, createFatDrops(3.0f));

        addModifier(EntityType.COW, createFatDrops(2.0f));
        addModifier(EntityType.GOAT, createFatDrops(2.0f));
        addModifier(EntityType.SHEEP, createFatDrops(2.0f));
    }

    /**
     * Adds a loot table modifier for the given entity.
     */
    private void addModifier(EntityType<?> type, LootTableModifier modifier) {
        Identifier id = type.getLootTableId().getValue();

        if (modifiers.containsKey(id)) {
            throw new IllegalArgumentException("Modifier already registered: " + id);
        }

        modifiers.put(id, modifier);
    }

    private void addSimpleMobDrop(EntityType<?> type, Item item, float max) {
        addModifier(type, (builder, lookup) -> addMobDrop(builder, item, max));
    }

    /**
     * Adds a smeltable mob drop to the given entity.
     */
    private static void addMobDrop(LootTable.Builder builder, Item item, float max) {
        builder.pool(
                LootPool.builder()
                        .with(
                                ItemEntry.builder(item)
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, max)))
                        )
        );
    }

    private void addSimpleSmeltableMobDrop(EntityType<?> type, Item item, float max) {
        addModifier(type, (builder, lookup) -> addSmeltableMobDrop(builder, lookup, item, max));
    }

    /**
     * Adds a smeltable mob drop to the given entity.
     */
    private static void addSmeltableMobDrop(LootTable.Builder builder, RegistryWrapper.WrapperLookup lookup, Item item, float max) {
        builder.pool(
                LootPool.builder()
                        .with(
                                ItemEntry.builder(item)
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, max)))
                                        .apply(FurnaceSmeltLootFunction.builder().conditionally(createSmeltLootCondition(lookup)))
                        )
        );
    }

    private void addBugDrops(LootTable.Builder builder, RegistryWrapper.WrapperLookup lookup) {
        addMobDrop(builder, EMDItems.BUGMEAT, 2.0f);
    }

    private void addArthropodDrops(LootTable.Builder builder, RegistryWrapper.WrapperLookup lookup) {
        addSmeltableMobDrop(builder, lookup, EMDItems.ARTHROPOD_FLESH, 2.0f);
    }

    private void addEquineDrops(LootTable.Builder builder, RegistryWrapper.WrapperLookup lookup) {
        addSmeltableMobDrop(builder, lookup, EMDItems.EQUINE_MEAT, 2.0f);
    }

    private void addAmphibianDrops(LootTable.Builder builder, RegistryWrapper.WrapperLookup lookup) {
        addSmeltableMobDrop(builder, lookup, EMDItems.RAW_AMPHIBIAN, 2.0f);
    }

    private void addCamelidDrops(LootTable.Builder builder, RegistryWrapper.WrapperLookup lookup) {
        addSmeltableMobDrop(builder, lookup, EMDItems.CAMELID_MEAT, 2.0f);
        addMobDrop(builder, EMDItems.FAT, 2.0f);
    }

    private void addCanineDrops(LootTable.Builder builder, RegistryWrapper.WrapperLookup lookup) {
        addSmeltableMobDrop(builder, lookup, EMDItems.CANINE_MEAT, 2.0f);
    }

    private void addFelineDrops(LootTable.Builder builder, RegistryWrapper.WrapperLookup lookup) {
        addSmeltableMobDrop(builder, lookup, EMDItems.FELINE_MEAT, 2.0f);
    }

    private LootTableModifier createFatDrops(float max) {
        return (builder, lookup) -> {
            addMobDrop(builder, EMDItems.FAT, max);
        };
    }

    private static AnyOfLootCondition.Builder createSmeltLootCondition(RegistryWrapper.WrapperLookup lookup) {
        RegistryWrapper.Impl<Enchantment> impl = lookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return AnyOfLootCondition.builder(
                EntityPropertiesLootCondition.builder(
                        LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.create()
                                .flags(EntityFlagsPredicate.Builder.create().onFire(true))
                ),
                EntityPropertiesLootCondition.builder(
                        LootContext.EntityTarget.DIRECT_ATTACKER,
                        EntityPredicate.Builder.create()
                                .equipment(
                                        EntityEquipmentPredicate.Builder.create()
                                                .mainhand(
                                                        ItemPredicate.Builder.create()
                                                                .subPredicate(
                                                                        ItemSubPredicateTypes.ENCHANTMENTS,
                                                                        EnchantmentsPredicate.enchantments(
                                                                                List.of(
                                                                                        new EnchantmentPredicate(impl.getOrThrow(EnchantmentTags.SMELTS_LOOT), NumberRange.IntRange.ANY)
                                                                                )
                                                                        )
                                                                )
                                                )
                                )
                )
        );
    }

    @FunctionalInterface
    interface LootTableModifier {
        void modify(LootTable.Builder builder, RegistryWrapper.WrapperLookup lookup);
    }
}
