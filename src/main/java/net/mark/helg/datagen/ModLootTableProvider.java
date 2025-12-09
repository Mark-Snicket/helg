package net.mark.helg.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.mark.helg.block.ModBlocks;
import net.mark.helg.item.ModItems;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        //dropSelf(ModBlocks.HELG_BLOCK);

        //add(ModBlocks.HELG_ORE, createOreDrop(ModBlocks.HELG_ORE, ModItems.HELG_SHARD));
    }
}
