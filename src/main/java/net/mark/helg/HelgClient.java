package net.mark.helg;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.mark.helg.entity.ModEntities;
import net.mark.helg.entity.client.helgerite.HelgeriteModel;
import net.mark.helg.entity.client.helgerite.HelgeriteRenderer;

public class HelgClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(HelgeriteModel.HELGERITE, HelgeriteModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.HELGERITE, HelgeriteRenderer::new);

    }
}
