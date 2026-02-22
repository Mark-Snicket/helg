package net.mark.helg;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.mark.helg.entity.ModEntities;
import net.mark.helg.entity.client.helgerite.HelgeriteModel;
import net.mark.helg.entity.client.helgerite.HelgeriteRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class HelgClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelLayerRegistry.registerModelLayer(HelgeriteModel.HELGERITE, HelgeriteModel::getTexturedModelData);
        EntityRenderers.register(ModEntities.HELGERITE, HelgeriteRenderer::new);

    }
}
