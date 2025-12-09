package net.mark.helg.item;

import net.mark.helg.Helg;
import net.mark.helg.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentModel;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    public static EquipmentModel HELGERITE = EquipmentModel.builder().addHumanoidLayers(Identifier.of(Helg.MOD_ID, "helgerite")).build();

    public static final ArmorMaterial HELGERITE_ARMOR_MATERIAL = new ArmorMaterial(25, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS,2);
        map.put(EquipmentType.LEGGINGS,5);
        map.put(EquipmentType.CHESTPLATE,7);
        map.put(EquipmentType.HELMET,3);
        map.put(EquipmentType.BODY,10);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 1, 0, ModTags.Items.HELGERITE_REPAIR,
            Identifier.of(Helg.MOD_ID, "helgerite"));
}
