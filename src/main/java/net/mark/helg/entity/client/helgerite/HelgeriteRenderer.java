package net.mark.helg.entity.client.helgerite;

import net.mark.helg.Helg;
import net.mark.helg.entity.custom.HelgeriteEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class HelgeriteRenderer extends MobEntityRenderer<HelgeriteEntity, HelgeriteRenderState, HelgeriteModel> {
    public HelgeriteRenderer(EntityRendererFactory.Context context) {
        super(context, new HelgeriteModel(context.getPart(HelgeriteModel.HELGERITE)), 0.1f);
    }

    @Override
    public Identifier getTexture(HelgeriteRenderState state) {
        return Identifier.of(Helg.MOD_ID, "textures/entity/helgerite/helgerite.png");
    }

    @Override
    public HelgeriteRenderState createRenderState() {
        return new HelgeriteRenderState();
    }

    @Override
    public void updateRenderState(HelgeriteEntity livingEntity, HelgeriteRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
    }
}
