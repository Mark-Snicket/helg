package net.mark.helg.entity.custom.goal;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class ArmorTemptGoal extends Goal {
    private static final TargetPredicate TEMPTING_ENTITY_PREDICATE = TargetPredicate.createNonAttackable().ignoreVisibility();
    private final TargetPredicate predicate;
    protected final MobEntity mob;
    protected final double speed;
    private double lastPlayerX;
    private double lastPlayerY;
    private double lastPlayerZ;
    private double lastPlayerPitch;
    private double lastPlayerYaw;
    @Nullable
    protected PlayerEntity closestPlayer;
    private int cooldown;
    private final ArmorMaterial material;
    private final boolean canBeScared;

    public ArmorTemptGoal(MobEntity entity, double speed, ArmorMaterial material, boolean canBeScared) {
        this.mob = entity;
        this.speed = speed;
        this.material = material;
        this.canBeScared = canBeScared;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        this.predicate = TEMPTING_ENTITY_PREDICATE.copy().setPredicate((entityX, world) -> this.isTemptedBy(entityX));
    }

    @Override
    public boolean canStart() {
        if (this.cooldown > 0) {
            --this.cooldown;
            return false;
        } else {
            this.closestPlayer = getServerWorld(this.mob).getClosestPlayer(this.predicate.setBaseMaxDistance(this.mob.getAttributeValue(EntityAttributes.TEMPT_RANGE)), this.mob);
            return this.closestPlayer != null;
        }
    }

    private boolean isTemptedBy(LivingEntity entity) {
        PlayerEntity player = (PlayerEntity) entity;

        return hasFullSuitOfArmorOn(player) && hasCorrectArmorOn(player);
    }

    @Override
    public boolean shouldContinue() {
        if (this.canBeScared()) {
            if (this.mob.squaredDistanceTo(this.closestPlayer) < (double) 36.0F) {
                if (this.closestPlayer.squaredDistanceTo(this.lastPlayerX, this.lastPlayerY, this.lastPlayerZ) > 0.010000000000000002) {
                    return false;
                }

                if (Math.abs((double) this.closestPlayer.getPitch() - this.lastPlayerPitch) > (double) 5.0F || Math.abs((double) this.closestPlayer.getYaw() - this.lastPlayerYaw) > (double) 5.0F) {
                    return false;
                }
            } else {
                this.lastPlayerX = this.closestPlayer.getX();
                this.lastPlayerY = this.closestPlayer.getY();
                this.lastPlayerZ = this.closestPlayer.getZ();
            }

            this.lastPlayerPitch = (double) this.closestPlayer.getPitch();
            this.lastPlayerYaw = (double) this.closestPlayer.getYaw();
        }

        return this.canStart();
    }

    protected boolean canBeScared() {
        return this.canBeScared;
    }

    @Override
    public void start() {
        this.lastPlayerX = this.closestPlayer.getX();
        this.lastPlayerY = this.closestPlayer.getY();
        this.lastPlayerZ = this.closestPlayer.getZ();
    }

    @Override
    public void stop() {
        this.closestPlayer = null;
        this.stopMoving();
        this.cooldown = toGoalTicks(100);
    }

    public void tick() {
        this.mob.getLookControl().lookAt(this.closestPlayer, (float) (this.mob.getMaxHeadRotation() + 20), (float) this.mob.getMaxLookPitchChange());
        if (this.mob.squaredDistanceTo(this.closestPlayer) < 6.25) {
            this.stopMoving();
        } else {
            this.startMovingTo(this.closestPlayer);
        }

    }

    protected void stopMoving() {
        this.mob.getNavigation().stop();
    }

    protected void startMovingTo(PlayerEntity player) {
        this.mob.getNavigation().startMovingTo(player, this.speed);
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getStack(36);
        ItemStack leggings = player.getInventory().getStack(37);
        ItemStack chestplate = player.getInventory().getStack(38);
        ItemStack helmet = player.getInventory().getStack(39);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getStack(36);
        ItemStack leggings = player.getInventory().getStack(37);
        ItemStack chestplate = player.getInventory().getStack(38);
        ItemStack helmet = player.getInventory().getStack(39);

        EquippableComponent equippableComponentBoots = boots.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentLeggings = leggings.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentChestplate = chestplate.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentHelmet = helmet.getComponents().get(DataComponentTypes.EQUIPPABLE);

        return equippableComponentBoots.assetId().get().equals(this.material.assetId()) && equippableComponentLeggings.assetId().get().equals(this.material.assetId()) &&
                equippableComponentChestplate.assetId().get().equals(this.material.assetId()) && equippableComponentHelmet.assetId().get().equals(this.material.assetId());
    }

}