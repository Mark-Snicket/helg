package net.mark.helg.entity.custom.goal;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class ArmorTemptGoal extends Goal {
    private static final TargetPredicate TEMPTING_ENTITY_PREDICATE = TargetPredicate.createNonAttackable().ignoreVisibility();
    protected final PathAwareEntity mob;
    private final TargetPredicate predicate;
    private final double speed;
    private final ArmorMaterial material;
    private final boolean canBeScared;
    @Nullable
    protected PlayerEntity closestPlayer;
    private double lastPlayerX;
    private double lastPlayerY;
    private double lastPlayerZ;
    private double lastPlayerPitch;
    private double lastPlayerYaw;
    private int cooldown;

    public ArmorTemptGoal(PathAwareEntity entity, double speed, ArmorMaterial material, boolean canBeScared) {
        this.mob = entity;
        this.speed = speed;
        this.material = material;
        this.canBeScared = canBeScared;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        this.predicate = TEMPTING_ENTITY_PREDICATE.copy().setPredicate((entityX, world) -> this.isTemptedBy(entityX));
    }

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

            this.lastPlayerPitch = this.closestPlayer.getPitch();
            this.lastPlayerYaw = this.closestPlayer.getYaw();
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
        this.mob.getNavigation().stop();
        this.cooldown = toGoalTicks(100);
    }

    @Override
    public void tick() {
        this.mob.getLookControl().lookAt(this.closestPlayer, (float) (this.mob.getMaxHeadRotation() + 20), (float) this.mob.getMaxLookPitchChange());
        if (this.mob.squaredDistanceTo(this.closestPlayer) < (double) 6.25F) {
            this.mob.getNavigation().stop();
        } else {
            this.mob.getNavigation().startMovingTo(this.closestPlayer, this.speed);
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(PlayerEntity player) {
        ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem) player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmorStack(3).getItem());

        EquippableComponent equippableComponentBoots = boots.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentLeggings = leggings.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentBreastplate = breastplate.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentHelmet = helmet.getComponents().get(DataComponentTypes.EQUIPPABLE);

        return equippableComponentBoots.model().get().equals(this.material.modelId()) && equippableComponentLeggings.model().get().equals(this.material.modelId()) &&
                equippableComponentBreastplate.model().get().equals(this.material.modelId()) && equippableComponentHelmet.model().get().equals(this.material.modelId());
    }
}