package net.mark.helg.entity;

import net.mark.helg.Helg;
import net.mark.helg.entity.custom.HelgeriteEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<HelgeriteEntity> HELGERITE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Helg.MOD_ID, "helgerite"),
            EntityType.Builder.create(HelgeriteEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.33f, 0.33f).build());


    public static void registerModEntities() {

    }
}
