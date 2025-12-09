package net.mark.helg.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.mark.helg.item.ModItems;
import net.mark.helg.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

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
