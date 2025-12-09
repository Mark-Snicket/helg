package net.mark.helg.item;

import net.mark.helg.Helg;
import net.mark.helg.util.ModTags;
import net.minecraft.util.Util;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.EnumMap;

public class ModArmorMaterials {
    static ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = ResourceKey.createRegistryKey(Identifier.parse("equipment_asset"));
    public static final ResourceKey<EquipmentAsset> HELGERITE_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(Helg.MOD_ID, "helgerite"));

    public static final ArmorMaterial HELGERITE_ARMOR_MATERIAL = new ArmorMaterial(25, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS,2);
        map.put(ArmorType.LEGGINGS,5);
        map.put(ArmorType.CHESTPLATE,7);
        map.put(ArmorType.HELMET,3);
        map.put(ArmorType.BODY,10);
    }), 15, SoundEvents.ARMOR_EQUIP_ELYTRA, 1, 0, ModTags.Items.HELGERITE_REPAIR, HELGERITE_KEY);
}
