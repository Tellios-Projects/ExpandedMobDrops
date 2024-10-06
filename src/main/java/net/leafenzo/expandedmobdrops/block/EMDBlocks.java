package net.leafenzo.expandedmobdrops.block;

import net.leafenzo.expandedmobdrops.ExpandedMobDrops;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
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

    private static Block register(String id, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(ExpandedMobDrops.MOD_ID, id), block);
    }
}
