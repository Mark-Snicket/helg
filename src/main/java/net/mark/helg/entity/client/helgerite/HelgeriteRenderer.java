package net.mark.helg.entity.client.helgerite;

import net.mark.helg.Helg;
import net.mark.helg.entity.custom.HelgeriteEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public class HelgeriteRenderer extends MobRenderer<HelgeriteEntity, HelgeriteRenderState, HelgeriteModel> {
    public HelgeriteRenderer(EntityRendererProvider.Context context) {
        super(context, new HelgeriteModel(context.bakeLayer(HelgeriteModel.HELGERITE)), 0.1f);
    }

    @Override
    public @NonNull Identifier getTextureLocation(HelgeriteRenderState state) {
        return Identifier.fromNamespaceAndPath(Helg.MOD_ID, "textures/entity/helgerite/helgerite.png");
    }

    @Override
    public HelgeriteRenderState createRenderState() {
        return new HelgeriteRenderState();
    }

    @Override
    public void extractRenderState(HelgeriteEntity livingEntity, HelgeriteRenderState livingEntityRenderState, float f) {
        super.extractRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
    }
}
