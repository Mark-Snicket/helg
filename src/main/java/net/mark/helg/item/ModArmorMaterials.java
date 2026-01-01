package net.mark.helg.item;

import net.mark.helg.Helg;
import net.mark.helg.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> HELGERITE_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Helg.MOD_ID, "helgerite"));
    public static final RegistryKey<EquipmentAsset> HELG_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Helg.MOD_ID, "helg"));

    public static final ArmorMaterial HELGERITE_ARMOR_MATERIAL = new ArmorMaterial(25, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS,2);
        map.put(EquipmentType.LEGGINGS,5);
        map.put(EquipmentType.CHESTPLATE,7);
        map.put(EquipmentType.HELMET,3);
        map.put(EquipmentType.BODY,13);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 1, 0, ModTags.Items.HELGERITE_ARMOR_REPAIRABLES, HELGERITE_KEY);


    public static final ArmorMaterial HELG_ARMOR_MATERIAL = new ArmorMaterial(25, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BODY,13);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 1, 0, ModTags.Items.HELG_ARMOR_REPAIRABLES, HELG_KEY);
}
