package net.leafenzo.expandedmobdrops;

import net.fabricmc.api.ClientModInitializer;
import net.leafenzo.expandedmobdrops.client.render.ModColorHandler;
import net.leafenzo.expandedmobdrops.client.render.ModRenderLayers;
import net.leafenzo.expandedmobdrops.particle.ModParticleTypes;

public class ModClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModRenderLayers.registerBlockCutouts();
        ModColorHandler.registerBlockColorProviders();

        ModParticleTypes.registerFactoriesForClient();
    }
}
