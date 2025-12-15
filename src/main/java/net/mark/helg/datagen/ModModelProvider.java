package net.mark.helg.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.mark.helg.Helg;
import net.mark.helg.item.ModArmorMaterials;
import net.mark.helg.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
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

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.HELGERITE_HELMET), Identifier.of(Helg.MOD_ID, "helgerite_helmet"),
                ModArmorMaterials.HELGERITE, EquipmentSlot.HEAD);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.HELGERITE_CHESTPLATE), Identifier.of(Helg.MOD_ID, "helgerite_chestplate"),
                ModArmorMaterials.HELGERITE, EquipmentSlot.CHEST);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.HELGERITE_LEGGINGS), Identifier.of(Helg.MOD_ID, "helgerite_leggings"),
                ModArmorMaterials.HELGERITE, EquipmentSlot.LEGS);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.HELGERITE_BOOTS), Identifier.of(Helg.MOD_ID, "helgerite_boots"),
                ModArmorMaterials.HELGERITE, EquipmentSlot.FEET);

        itemModelGenerator.register(ModItems.HELGERITE_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(ModItems.HELGERITE_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.HELG_HORSE_ARMOR, Models.GENERATED);*/
    }
}
