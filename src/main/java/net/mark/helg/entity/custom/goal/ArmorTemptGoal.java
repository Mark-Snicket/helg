package net.mark.helg.entity.custom.goal;


import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.Equippable;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;



public class ArmorTemptGoal extends Goal {
    private static final TargetingConditions TEMPTING_ENTITY_PREDICATE = TargetingConditions.forNonCombat().range(10.0).ignoreLineOfSight();
    private final TargetingConditions predicate;
    protected final PathfinderMob mob;
    private final double speed;
    private double lastPlayerX;
    private double lastPlayerY;
    private double lastPlayerZ;
    @Nullable
    protected Player closestPlayer;
    private int cooldown;
    private boolean active;
    private final ArmorMaterial material;

    public ArmorTemptGoal(PathfinderMob entity, double speed, ArmorMaterial material) {
        this.mob = entity;
        this.speed = speed;
        this.material = material;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        this.predicate = TEMPTING_ENTITY_PREDICATE.copy().selector((TargetingConditions.Selector) this.closestPlayer);
    }

    @Override
    public boolean canUse() {
        if (this.cooldown > 0) {
            --this.cooldown;
            return false;
        }
        //this.closestPlayer = this.mob.getWorld().getClosestPlayer(closestPlayer, 16);
        return this.closestPlayer != null;
    }

    private boolean isTemptedBy(LivingEntity entity) {

        return hasFullSuitOfArmorOn(this.closestPlayer) && hasCorrectArmorOn(this.material, this.closestPlayer);
    }

    @Override
    public boolean canContinueToUse() {
        return this.canUse();
    }

    @Override
    public void start() {
            this.active = true;
    }

    @Override
    public void stop() {
        this.closestPlayer = null;
        this.mob.getNavigation().stop();
        this.cooldown = Goal.reducedTickDelay(100);
        this.active = false;
    }

    @Override
    public void tick() {
        this.mob.getLookControl().setLookAt(this.closestPlayer, this.mob.getMaxHeadYRot() + 20, this.mob.getMaxHeadXRot());
        if (this.mob.distanceToSqr(this.closestPlayer) < 6.25) {
            this.mob.getNavigation().stop();
        } else {
            this.mob.getNavigation().moveTo(this.closestPlayer, this.speed);
        }
    }

    public boolean isActive() {
        return this.active;
    }

    private boolean hasFullSuitOfArmorOn(Player player) {

        if (player == null) {
            return false;
        }

        ItemStack boots = player.getInventory().getItem(EquipmentSlot.FEET.getIndex());
        ItemStack leggings = player.getInventory().getItem(EquipmentSlot.LEGS.getIndex());
        ItemStack chestplate = player.getInventory().getItem(EquipmentSlot.CHEST.getIndex());
        ItemStack helmet = player.getInventory().getItem(EquipmentSlot.HEAD.getIndex());

        return !helmet.isEmpty() && !chestplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {

        ItemStack boots = player.getInventory().getItem(EquipmentSlot.FEET.getIndex());
        ItemStack leggings = player.getInventory().getItem(EquipmentSlot.LEGS.getIndex());
        ItemStack chestplate = player.getInventory().getItem(EquipmentSlot.CHEST.getIndex());
        ItemStack helmet = player.getInventory().getItem(EquipmentSlot.HEAD.getIndex());

        Equippable equippableBoots = boots.getComponents().get(DataComponents.EQUIPPABLE);
        Equippable equippableLeggings = leggings.getComponents().get(DataComponents.EQUIPPABLE);
        Equippable equippableBreastplate = chestplate.getComponents().get(DataComponents.EQUIPPABLE);
        Equippable equippableHelmet = helmet.getComponents().get(DataComponents.EQUIPPABLE);

        return equippableBoots.assetId().get().equals(material) && equippableLeggings.assetId().get().equals(material) &&
                equippableBreastplate.assetId().get().equals(material) && equippableHelmet.assetId().get().equals(material);
    }

}
