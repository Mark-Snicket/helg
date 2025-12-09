package net.mark.helg.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.mark.helg.item.ModArmorMaterials;
import net.mark.helg.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.resources.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        //blockStateModelGenerator.createTrivialCube(ModBlocks.HELG_ORE);
        //blockStateModelGenerator.createTrivialCube(ModBlocks.HELG_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        /*itemModelGenerator.generateFlatItem(ModItems.HELG_SHARD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.HELG_INGOT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateTrimmableItem(ModItems.HELGERITE_HELMET, ModArmorMaterials.HELGERITE_KEY, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModelGenerator.generateTrimmableItem(ModItems.HELGERITE_CHESTPLATE, ModArmorMaterials.HELGERITE_KEY, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerator.generateTrimmableItem(ModItems.HELGERITE_LEGGINGS, ModArmorMaterials.HELGERITE_KEY, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerator.generateTrimmableItem(ModItems.HELGERITE_BOOTS, ModArmorMaterials.HELGERITE_KEY, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

        itemModelGenerator.generateFlatItem(ModItems.HELGERITE_SPAWN_EGG,
                new ModelTemplate(Optional.of(Identifier.parse("item/template_spawn_egg")), Optional.empty()));*/
    }
}
