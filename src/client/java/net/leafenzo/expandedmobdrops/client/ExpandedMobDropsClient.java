package net.leafenzo.expandedmobdrops.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.leafenzo.expandedmobdrops.block.EMDBlocks;
import net.minecraft.client.render.RenderLayer;

public class ExpandedMobDropsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        initRenderLayers(BlockRenderLayerMap.INSTANCE);
    }

    private void initRenderLayers(BlockRenderLayerMap layers) {
        layers.putBlocks(
                RenderLayer.getCutout(),
                EMDBlocks.FOX_HIDE
        );
    }
}
