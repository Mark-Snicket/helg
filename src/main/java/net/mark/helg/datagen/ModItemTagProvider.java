package net.mark.helg.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.mark.helg.item.ModItems;
import net.mark.helg.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {

        /*valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.HELGERITE_HELMET)
                .add(ModItems.HELGERITE_CHESTPLATE)
                .add(ModItems.HELGERITE_LEGGINGS)
                .add(ModItems.HELGERITE_BOOTS);


        valueLookupBuilder(ModTags.Items.HELGERITE_REPAIR)
            .add(ModItems.HELGERITE_HELMET)
            .add(ModItems.HELGERITE_CHESTPLATE)
            .add(ModItems.HELGERITE_LEGGINGS)
            .add(ModItems.HELGERITE_BOOTS);*/
    }
}
