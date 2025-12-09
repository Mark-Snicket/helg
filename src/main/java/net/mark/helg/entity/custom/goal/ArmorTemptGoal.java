package net.mark.helg.entity.custom.goal;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;



public class ArmorTemptGoal extends Goal {
    private static final TargetPredicate TEMPTING_ENTITY_PREDICATE = TargetPredicate.createNonAttackable().setBaseMaxDistance(10.0).ignoreVisibility();
    private final TargetPredicate predicate;
    protected final PathAwareEntity mob;
    private final double speed;
    private double lastPlayerX;
    private double lastPlayerY;
    private double lastPlayerZ;
    @Nullable
    protected PlayerEntity closestPlayer;
    private int cooldown;
    private boolean active;
    private final ArmorMaterial material;

    public ArmorTemptGoal(PathAwareEntity entity, double speed, ArmorMaterial material) {
        this.mob = entity;
        this.speed = speed;
        this.material = material;
        this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
        this.predicate = TEMPTING_ENTITY_PREDICATE.copy().setPredicate((TargetPredicate.EntityPredicate) this.closestPlayer);
    }

    @Override
    public boolean canStart() {
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
    public boolean shouldContinue() {
        return this.canStart();
    }

    @Override
    public void start() {
        this.active = true;
    }

    @Override
    public void stop() {
        this.closestPlayer = null;
        this.mob.getNavigation().stop();
        this.cooldown = Goal.toGoalTicks(100);
        this.active = false;
    }

    @Override
    public void tick() {
        this.mob.getLookControl().lookAt(this.closestPlayer, this.mob.getMaxHeadRotation() + 20, this.mob.getMaxLookPitchChange());
        if (this.mob.squaredDistanceTo(this.closestPlayer) < 6.25) {
            this.mob.getNavigation().stop();
        } else {
            this.mob.getNavigation().startMovingTo(this.closestPlayer, this.speed);
        }
    }

    public boolean isActive() {
        return this.active;
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {

        if (player == null) {
            return false;
        }

        ItemStack boots = player.getInventory().getStack(EquipmentSlot.FEET.getIndex());
        ItemStack leggings = player.getInventory().getStack(EquipmentSlot.LEGS.getIndex());
        ItemStack chestplate = player.getInventory().getStack(EquipmentSlot.CHEST.getIndex());
        ItemStack helmet = player.getInventory().getStack(EquipmentSlot.HEAD.getIndex());

        return !helmet.isEmpty() && !chestplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {

        ItemStack boots = player.getInventory().getStack(EquipmentSlot.FEET.getIndex());
        ItemStack leggings = player.getInventory().getStack(EquipmentSlot.LEGS.getIndex());
        ItemStack chestplate = player.getInventory().getStack(EquipmentSlot.CHEST.getIndex());
        ItemStack helmet = player.getInventory().getStack(EquipmentSlot.HEAD.getIndex());

        EquippableComponent equippableComponentBoots = boots.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentLeggings = leggings.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentBreastplate = chestplate.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentHelmet = helmet.getComponents().get(DataComponentTypes.EQUIPPABLE);

        return equippableComponentBoots.assetId().get().equals(material) && equippableComponentLeggings.assetId().get().equals(material) &&
                equippableComponentBreastplate.assetId().get().equals(material) && equippableComponentHelmet.assetId().get().equals(material);
    }

}
