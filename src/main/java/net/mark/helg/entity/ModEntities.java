package net.mark.helg.entity;

import net.mark.helg.Helg;
import net.mark.helg.entity.custom.HelgeriteEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {
    private static final ResourceKey<EntityType<?>> HELGERITE_KEY =
            ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Helg.MOD_ID, "helgerite"));

    public static final EntityType<HelgeriteEntity> HELGERITE = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(Helg.MOD_ID, "helgerite"),
            EntityType.Builder.<HelgeriteEntity>of(HelgeriteEntity::new, MobCategory.CREATURE)
            .sized(0.33f, 0.33f).build(HELGERITE_KEY));


    public static void registerModEntities() {

    }
}