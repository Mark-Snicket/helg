package net.mark.helg.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mark.helg.world.ModPlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SUNFLOWER_PLAINS), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.HELG_ORE_PLACED_KEY);
    }
}
