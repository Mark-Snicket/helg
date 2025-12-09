package net.mark.helg.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mark.helg.entity.ModEntities;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawns {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SWAMP),
                SpawnGroup.CREATURE, ModEntities.HELGERITE, 30, 3 ,7);

        SpawnRestriction.register(ModEntities.HELGERITE, SpawnLocationTypes.UNRESTRICTED,
                Heightmap.Type.MOTION_BLOCKING, AnimalEntity::isValidNaturalSpawn);
    }
}
