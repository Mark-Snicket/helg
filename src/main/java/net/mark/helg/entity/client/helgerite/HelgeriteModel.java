package net.mark.helg.entity.client.helgerite;

import net.mark.helg.Helg;
import net.mark.helg.entity.custom.HelgeriteEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class HelgeriteModel extends EntityModel<HelgeriteRenderState> {
    public static final EntityModelLayer HELGERITE = new EntityModelLayer(Identifier.of(Helg.MOD_ID, "helgerite"), "main");

    private final ModelPart helgerite;

    public HelgeriteModel(ModelPart root) {
        super(root);
        this.helgerite = root.getChild("helgerite");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData helgerite = modelPartData.addChild("helgerite", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData wing2 = helgerite.addChild("wing2", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, -1.0F, 0.0F));

        ModelPartData wing2_r1 = wing2.addChild("wing2_r1", ModelPartBuilder.create().uv(-4, 0).cuboid(-0.05F, -4.0F, -3.0F, 0.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.7071F, -0.7071F, 0.0F, 0.0F, 0.0F, 0.7854F));

        ModelPartData wing1 = helgerite.addChild("wing1", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, -1.0F, 0.0F));

        ModelPartData wing1_r1 = wing1.addChild("wing1_r1", ModelPartBuilder.create().uv(-4, 0).cuboid(0.05F, -4.0F, -3.0F, 0.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-0.7071F, -0.7071F, 0.0F, 0.0F, 0.0F, -0.7854F));

        ModelPartData body = helgerite.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.075F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));
        return TexturedModelData.of(modelData, 16, 16);
    }
    @Override
    public void setAngles(HelgeriteRenderState state) {
        super.setAngles(state);
        this.setHeadAngles(state.yawDegrees);

        this.animateWalking(HelgeriteAnimations.IDLE, state.limbFrequency, state.limbAmplitudeMultiplier, 2.0f, 2.5f);
        this.animate(state.idleAnimationState, HelgeriteAnimations.IDLE, state.age, 1.0f);
    }

    private void setHeadAngles(float headYaw) {
        headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);

        this.helgerite.yaw = headYaw * 0.017453292f;
    }
}