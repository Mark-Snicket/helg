package net.mark.helg;

import net.fabricmc.api.ModInitializer;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.mark.helg.block.ModBlocks;
import net.mark.helg.entity.ModEntities;
import net.mark.helg.entity.custom.HelgeriteEntity;
import net.mark.helg.item.ModItems;
import net.mark.helg.util.ModLootTableModifiers;
import net.mark.helg.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Helg implements ModInitializer {
	public static final String MOD_ID = "helg";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGen();
		ModEntities.registerModEntities();
		ModLootTableModifiers.modifyLootTables();

		FabricDefaultAttributeRegistry.register(ModEntities.HELGERITE, HelgeriteEntity.createHelgeriteAttributes());
	}
}
