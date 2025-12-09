package net.mark.helg.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mark.helg.world.ModPlacedFeatures;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.SUNFLOWER_PLAINS), GenerationStep.Decoration.UNDERGROUND_ORES,
                ModPlacedFeatures.HELG_ORE_PLACED_KEY);
    }
}
