package net.mark.helg.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.mark.helg.block.ModBlocks;
import net.mark.helg.item.ModArmorMaterials;
import net.mark.helg.item.ModItems;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.Models;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HELG_ORE);
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HELG_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        /*itemModelGenerator.register(ModItems.HELG_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.HELG_INGOT, Models.GENERATED);

        itemModelGenerator.registerArmor( ModItems.HELGERITE_HELMET, ModArmorMaterials.HELGERITE_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor( ModItems.HELGERITE_CHESTPLATE, ModArmorMaterials.HELGERITE_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor( ModItems.HELGERITE_LEGGINGS, ModArmorMaterials.HELGERITE_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor( ModItems.HELGERITE_BOOTS, ModArmorMaterials.HELGERITE_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

        itemModelGenerator.register(ModItems.HELGERITE_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));*/
    }
}
