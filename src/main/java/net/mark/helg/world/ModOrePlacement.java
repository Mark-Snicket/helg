package net.mark.helg.world;

import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModOrePlacement {
    public  static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(int count , PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    public static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heighModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heighModifier);
    }
}
