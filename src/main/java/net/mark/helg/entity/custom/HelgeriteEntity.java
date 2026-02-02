package net.mark.helg.entity.custom;

import net.mark.helg.entity.custom.goal.ArmorTemptGoal;
import net.mark.helg.item.ModArmorMaterials;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;


public class HelgeriteEntity extends Animal implements FlyingAnimal {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;

    public HelgeriteEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new FlyingMoveControl(this, 10, true);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.2f));
        this.goalSelector.addGoal(2, new ArmorTemptGoal(this, 1.33f, ModArmorMaterials.HELGERITE_ARMOR_MATERIAL, false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomFlyingGoal(this, 3.0f));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0f));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0f));

    }

    @Override
    protected @NonNull PathNavigation createNavigation(@NonNull Level level) {
        FlyingPathNavigation flyingPathNavigation = new FlyingPathNavigation(this, level);
        flyingPathNavigation.setCanOpenDoors(false);
        flyingPathNavigation.setCanFloat(true);
        flyingPathNavigation.setRequiredPathLength(48.0F);
        return flyingPathNavigation;
    }

    public static AttributeSupplier.Builder createHelgeriteAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10)
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.FLYING_SPEED, 0.33)
                .add(Attributes.FALL_DAMAGE_MULTIPLIER, 0.0f)
                .add(Attributes.GRAVITY, 0.0)
                .add(Attributes.TEMPT_RANGE, 10.0);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationCooldown <= 0 && this.isFlying()) {
            this.idleAnimationCooldown = 240;
            this.idleAnimationState.start(this.age);
        } else {
            this.idleAnimationCooldown--;
        }
    }


    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }


    }

    @Override
    public boolean isFood(@NonNull ItemStack stack) {
        return false;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(@NonNull ServerLevel serverLevel, @NonNull AgeableMob ageableMob) {
        return null;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.ZOMBIE_INFECT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(@NonNull DamageSource source) {
        return SoundEvents.RAVAGER_STEP;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.GOAT_HORN_BREAK;
    }


    @Override
    public boolean isFlying() {
        return !this.onGround();
    }


}