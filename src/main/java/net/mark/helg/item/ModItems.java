package net.mark.helg.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mark.helg.Helg;
import net.mark.helg.entity.ModEntities;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item HELG_SHARD = registerItem("helg_shard", Item::new);
    public static final Item HELGERITE_INGOT = registerItem("helgerite_ingot", Item::new);


    public static final Item HELGERITE_HELMET = registerItem("helgerite_helmet",
            settings -> new ArmorItem(ModArmorMaterials.HELGERITE_ARMOR_MATERIAL, EquipmentType.HELMET, settings
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(25))));

    public static final Item HELGERITE_CHESTPLATE = registerItem("helgerite_chestplate",
            settings -> new ArmorItem(ModArmorMaterials.HELGERITE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE, settings
                    .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(25))));

    public static final Item HELGERITE_LEGGINGS = registerItem("helgerite_leggings",
            settings -> new ArmorItem(ModArmorMaterials.HELGERITE_ARMOR_MATERIAL, EquipmentType.LEGGINGS, settings
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(25))));

    public static final Item HELGERITE_BOOTS = registerItem("helgerite_boots",
            settings -> new ArmorItem(ModArmorMaterials.HELGERITE_ARMOR_MATERIAL, EquipmentType.BOOTS, settings
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(25))));

    public static final Item HELGERITE_SPAWN_EGG = registerItem("helgerite_spawn_egg",
            settings -> new SpawnEggItem(ModEntities.HELGERITE, 0xd1b08a, 0x2422d9, settings));

    public static final Item HELG_HORSE_ARMOR = registerItem("helg_horse_armor",
            settings -> new AnimalArmorItem(ModArmorMaterials.HELG_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, settings.maxCount(1)));

    public static final Item HELGERITE_HORSE_ARMOR = registerItem("helgerite_horse_armor",
            settings -> new AnimalArmorItem(ModArmorMaterials.HELGERITE_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, settings.maxCount(1)));


    /* temp block to "handle" changing the id */
    public static final Item HELG_INGOT = registerItem("helg_ingot", Item::new);


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Helg.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Helg.MOD_ID, name)))));
    }


    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.HELG_SHARD);
            entries.add(ModItems.HELGERITE_INGOT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(ModItems.HELGERITE_HELMET);
            entries.add(ModItems.HELGERITE_CHESTPLATE);
            entries.add(ModItems.HELGERITE_LEGGINGS);
            entries.add(ModItems.HELGERITE_BOOTS);

            entries.add(ModItems.HELG_HORSE_ARMOR);
            entries.add(ModItems.HELGERITE_HORSE_ARMOR);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(ModItems.HELGERITE_SPAWN_EGG);
        });
    }
}
