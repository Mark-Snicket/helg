package net.mark.helg.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mark.helg.Helg;
import net.mark.helg.entity.ModEntities;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item HELG_SHARD = registerItem("helg_shard", new Item(new Item.Settings()));
    public static final Item HELG_INGOT = registerItem("helg_ingot", new Item(new Item.Settings()));


    public static final Item HELGERITE_HELMET = registerItem("helgerite_helmet",
            new ArmorItem(ModArmorMaterials.HELGERITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(25))));

    public static final Item HELGERITE_CHESTPLATE = registerItem("helgerite_chestplate",
            new ArmorItem(ModArmorMaterials.HELGERITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(25))));

    public static final Item HELGERITE_LEGGINGS = registerItem("helgerite_leggings",
            new ArmorItem(ModArmorMaterials.HELGERITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(25))));

    public static final Item HELGERITE_BOOTS = registerItem("helgerite_boots",
            new ArmorItem(ModArmorMaterials.HELGERITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(25))));

    public static final Item HELGERITE_SPAWN_EGG = registerItem("helgerite_spawn_egg",
            new SpawnEggItem(ModEntities.HELGERITE,0xd1b08a, 0x2422d9, new Item.Settings()));

    public static final Item HELG_HORSE_ARMOR = registerItem("helg_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.HELG_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));

    public static final Item HELGERITE_HORSE_ARMOR = registerItem("helgerite_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.HELGERITE_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Helg.MOD_ID, name), item);
    }




    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.HELG_SHARD);
            entries.add(ModItems.HELG_INGOT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(ModItems.HELGERITE_HELMET);
            entries.add(ModItems.HELGERITE_CHESTPLATE);
            entries.add(ModItems.HELGERITE_LEGGINGS);
            entries.add(ModItems.HELGERITE_BOOTS);

            entries.add(ModItems.HELGERITE_HORSE_ARMOR);
            entries.add(ModItems.HELG_HORSE_ARMOR);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(ModItems.HELGERITE_SPAWN_EGG);
        });
    }
}
