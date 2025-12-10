package net.mark.helg.entity.client.helgerite;

import net.mark.helg.Helg;
import net.mark.helg.entity.custom.HelgeriteEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class HelgeriteRenderer extends MobEntityRenderer<HelgeriteEntity, HelgeriteModel<HelgeriteEntity>> {
    public HelgeriteRenderer(EntityRendererFactory.Context context) {
        super(context, new HelgeriteModel<>(context.getPart(HelgeriteModel.HELGERITE)), 0.1f);
    }

    @Override
    public Identifier getTexture(HelgeriteEntity entity) {
        return Identifier.of(Helg.MOD_ID, "textures/entity/helgerite/helgerite.png");
    }

    @Override
    public void render(HelgeriteEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f,0.5f);
        } else {
            matrixStack.scale(1.0f, 1.0f, 1.0f);

            super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
        }
    }
}
