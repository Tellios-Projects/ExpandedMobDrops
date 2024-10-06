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
            addSmeltableMobDrop(builder, lookup, EMDItems.BEAR_MEAT);
            addMobDrop(builder, EMDItems.BEAR_HIDE);
            addMobDrop(builder, EMDItems.POLAR_BEAR_HIDE);
        });

        addSimpleSmeltableMobDrop(EntityType.RAVAGER, EMDItems.BEAST_MEAT);
        addSimpleSmeltableMobDrop(EntityType.WOLF, EMDItems.CANINE_MEAT);
        addSimpleSmeltableMobDrop(EntityType.OCELOT, EMDItems.FELINE_MEAT);
        addSimpleSmeltableMobDrop(EntityType.CAT, EMDItems.FELINE_MEAT);
        addSimpleSmeltableMobDrop(EntityType.HORSE, EMDItems.EQUINE_MEAT);
        addSimpleSmeltableMobDrop(EntityType.CAMEL, EMDItems.CAMELID_MEAT);
        addSimpleSmeltableMobDrop(EntityType.SPIDER, EMDItems.ARTHROPOD_FLESH);
        addSimpleSmeltableMobDrop(EntityType.FROG, EMDItems.RAW_AMPHIBIAN);
        addSimpleSmeltableMobDrop(EntityType.TURTLE, EMDItems.RAW_TURTLE);
        addSimpleSmeltableMobDrop(EntityType.PARROT, EMDItems.RAW_BIRD);
        addSimpleSmeltableMobDrop(EntityType.SQUID, EMDItems.SQUID);
        addSimpleSmeltableMobDrop(EntityType.GLOW_SQUID, EMDItems.GLOW_SQUID);

        addModifier(EntityType.WARDEN, (builder, lookup) -> {
            addSmeltableMobDrop(builder, lookup, EMDItems.ANCIENT_CHOPS);
            addSmeltableMobDrop(builder, lookup, EMDItems.SCULK_TENDRIL);
        });

        addModifier(EntityType.MOOSHROOM, (builder, lookup) -> {
            addSmeltableMobDrop(builder, lookup, EMDItems.FUNGAL_MEAT);
            addMobDrop(builder, EMDItems.MOOSHROOM_HIDE);
        });

        addSimpleSmeltableMobDrop(EntityType.STRIDER, EMDItems.STRIDER_CHUNK);

        addSimpleMobDrop(EntityType.FOX, EMDItems.FOX_HIDE);
        addSimpleMobDrop(EntityType.PANDA, EMDItems.PANDA_HIDE);
        addSimpleMobDrop(EntityType.SNIFFER, EMDItems.SNIFFER_HIDE);
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

    private void addSimpleMobDrop(EntityType<?> type, Item item) {
        addModifier(type, (builder, lookup) -> addMobDrop(builder, item));
    }

    /**
     * Adds a smeltable mob drop to the given entity.
     */
    private static void addMobDrop(LootTable.Builder builder, Item item) {
        builder.pool(
                LootPool.builder()
                        .with(
                                ItemEntry.builder(item)
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)))
                        )
        );
    }

    private void addSimpleSmeltableMobDrop(EntityType<?> type, Item item) {
        addModifier(type, (builder, lookup) -> addSmeltableMobDrop(builder, lookup, item));
    }

    /**
     * Adds a smeltable mob drop to the given entity.
     */
    private static void addSmeltableMobDrop(LootTable.Builder builder, RegistryWrapper.WrapperLookup lookup, Item item) {
        builder.pool(
                LootPool.builder()
                        .with(
                                ItemEntry.builder(item)
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)))
                                        .apply(FurnaceSmeltLootFunction.builder().conditionally(createSmeltLootCondition(lookup)))
                        )
        );
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
