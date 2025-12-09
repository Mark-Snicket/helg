package net.mark.helg.entity.client.helgerite;

import net.mark.helg.Helg;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

public class HelgeriteModel extends EntityModel<HelgeriteRenderState> {
    public static final ModelLayerLocation HELGERITE = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Helg.MOD_ID, "helgerite"), "main");

    private final ModelPart helgerite;
    private final KeyframeAnimation flyingAnimation;
    private final KeyframeAnimation idlingAnimation;

    public HelgeriteModel(ModelPart root) {
        super(root);
        this.helgerite = root.getChild("helgerite");

        this.flyingAnimation = HelgeriteAnimations.IDLE.bake(root);
        this.idlingAnimation = HelgeriteAnimations.IDLE.bake(root);
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition PartDefinition = meshDefinition.getRoot();
        PartDefinition helgerite = PartDefinition.addOrReplaceChild("helgerite", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition wing2 = helgerite.addOrReplaceChild("wing2", CubeListBuilder.create(), PartPose.offset(1.0F, -1.0F, 0.0F));

        PartDefinition wing2_r1 = wing2.addOrReplaceChild("wing2_r1", CubeListBuilder.create().texOffs(-4, 0).addBox(-0.05F, -4.0F, -3.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7071F, -0.7071F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition wing1 = helgerite.addOrReplaceChild("wing1", CubeListBuilder.create(), PartPose.offset(-1.0F, -1.0F, 0.0F));

        PartDefinition wing1_r1 = wing1.addOrReplaceChild("wing1_r1", CubeListBuilder.create().texOffs(-4, 0).addBox(0.05F, -4.0F, -3.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7071F, -0.7071F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition body = helgerite.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.075F)), PartPose.offset(0.0F, -1.0F, 0.0F));
        return LayerDefinition.create(meshDefinition, 16, 16);
    }
    @Override
    public void setupAnim(HelgeriteRenderState state) {
        super.setupAnim(state);
        this.setHeadAngles(state.yRot);

        this.flyingAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2.0f, 2.5f);
        this.idlingAnimation.apply(state.idleAnimationState, state.ageScale, 1.0f);
    }

    private void setHeadAngles(float headYaw) {
        headYaw = Mth.clamp(headYaw, -30.0f, 30.0f);

        this.helgerite.yRot = headYaw * 0.017453292f;
    }
}