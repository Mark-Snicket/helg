package net.mark.helg;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.mark.helg.block.ModBlocks;
import net.mark.helg.entity.ModEntities;
import net.mark.helg.entity.custom.HelgeriteEntity;
import net.mark.helg.item.ModItems;
import net.mark.helg.util.ModLootTableModifiers;
import net.mark.helg.worldgen.gen.ModEntitySpawns;

public class Helg implements ModInitializer {
	public static final String MOD_ID = "helg";

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModEntitySpawns.addSpawns();

		ModEntities.registerModEntities();
		ModLootTableModifiers.modifyLootTables();

		FabricDefaultAttributeRegistry.register(ModEntities.HELGERITE, HelgeriteEntity.createHelgeriteAttributes());
	}
}
