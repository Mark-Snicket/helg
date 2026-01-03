package net.mark.helg.entity.custom.goal;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.Equippable;
import org.jspecify.annotations.Nullable;

import java.util.EnumSet;

public class ArmorTemptGoal extends Goal {
    private static final TargetingConditions TEMPT_TARGETING = TargetingConditions.forNonCombat().ignoreLineOfSight();
    private final TargetingConditions targetingConditions;
    protected final Mob mob;
    protected final double speedModifier;
    private double px;
    private double py;
    private double pz;
    private double pRotX;
    private double pRotY;
    protected @Nullable Player player;
    private int calmDown;
    private final ArmorMaterial material;
    private final boolean canScare;


    public ArmorTemptGoal(PathfinderMob mob, double speed, ArmorMaterial material, boolean canScare) {
        this.mob = mob;
        this.speedModifier = speed;
        this.material = material;
        this.canScare = canScare;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        this.targetingConditions = TEMPT_TARGETING.copy().selector((livingEntity, serverLevel) -> this.shouldFollow(livingEntity));
    }

    @Override
    public boolean canUse() {
        if (this.calmDown > 0) {
            --this.calmDown;
            return false;
        } else {
            this.player = getServerLevel(this.mob).getNearestPlayer(this.targetingConditions.range(this.mob.getAttributeValue(Attributes.TEMPT_RANGE)), this.mob);
            return this.player != null;
        }
    }

    private boolean shouldFollow(LivingEntity livingEntity) {
        Player player = (Player) livingEntity;
        return hasFullSuitOfArmorOn(player) && hasCorrectArmorOn(player);
    }

    @Override
    public boolean canContinueToUse() {
        if (this.canScare()) {
            if (this.mob.distanceToSqr(this.player) < (double) 36.0F) {
                if (this.player.distanceToSqr(this.px, this.py, this.pz) > 0.010000000000000002) {
                    return false;
                }

                if (Math.abs((double) this.player.getXRot() - this.pRotX) > (double) 5.0F || Math.abs((double) this.player.getYRot() - this.pRotY) > (double) 5.0F) {
                    return false;
                }
            } else {
                this.px = this.player.getX();
                this.py = this.player.getY();
                this.pz = this.player.getZ();
            }

            this.pRotX = (double) this.player.getXRot();
            this.pRotY = (double) this.player.getYRot();
        }

        return this.canUse();
    }

    protected boolean canScare() {
        return this.canScare;
    }

    @Override
    public void start() {
        this.px = this.player.getX();
        this.py = this.player.getY();
        this.pz = this.player.getZ();
    }

    @Override
    public void stop() {
        this.player = null;
        this.stopNavigation();
        this.calmDown = reducedTickDelay(100);
    }

    @Override
    public void tick() {
        this.mob.getLookControl().setLookAt(this.player, (float) (this.mob.getMaxHeadYRot() + 20), (float) this.mob.getMaxHeadXRot());
        if (this.mob.distanceToSqr(this.player) < 6.25) {
            this.stopNavigation();
        } else {
            this.navigateTowards(this.player);
        }

    }

    protected void stopNavigation() {
        this.mob.getNavigation().stop();
    }

    protected void navigateTowards(Player player) {
        this.mob.getNavigation().moveTo(player, this.speedModifier);
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getItem(36);
        ItemStack leggings = player.getInventory().getItem(37);
        ItemStack chestplate = player.getInventory().getItem(38);
        ItemStack helmet = player.getInventory().getItem(39);
        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(Player player) {
        ItemStack boots = player.getInventory().getItem(36);
        ItemStack leggings = player.getInventory().getItem(37);
        ItemStack chestplate = player.getInventory().getItem(38);
        ItemStack helmet = player.getInventory().getItem(39);

        Equippable equippableComponentBoots = boots.getComponents().get(DataComponents.EQUIPPABLE);
        Equippable equippableComponentLeggings = leggings.getComponents().get(DataComponents.EQUIPPABLE);
        Equippable equippableComponentChestplate = chestplate.getComponents().get(DataComponents.EQUIPPABLE);
        Equippable equippableComponentHelmet = helmet.getComponents().get(DataComponents.EQUIPPABLE);

        return equippableComponentBoots.assetId().get().equals(this.material.assetId()) && equippableComponentLeggings.assetId().get().equals(this.material.assetId()) &&
                equippableComponentChestplate.assetId().get().equals(this.material.assetId()) && equippableComponentHelmet.assetId().get().equals(this.material.assetId());
    }


}

