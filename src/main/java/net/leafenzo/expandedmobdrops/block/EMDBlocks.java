package net.leafenzo.expandedmobdrops.block;

import net.leafenzo.expandedmobdrops.ExpandedMobDrops;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class EMDBlocks {
    public static final Block FAT_BLOCK = register(
            "fat_block",
            new Block(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.OFF_WHITE)
                            .slipperiness(0.8F)
                            .sounds(BlockSoundGroup.SLIME)
                            .nonOpaque()
            )
    );

    public static final Block FOX_HIDE = register("fox_hide", createHideBlock(MapColor.ORANGE));

    private static Block createHideBlock(MapColor mapColor) {
        return new HideBlock(
                AbstractBlock.Settings.create()
                        .mapColor(mapColor)
                        .strength(0.1f)
                        .sounds(BlockSoundGroup.WOOL)
                        .pistonBehavior(PistonBehavior.DESTROY)
                        .offset(AbstractBlock.OffsetType.XYZ)
                        .dynamicBounds()
                        .nonOpaque()
        );
    }

    private static Block register(String id, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(ExpandedMobDrops.MOD_ID, id), block);
    }
}
