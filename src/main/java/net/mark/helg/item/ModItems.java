package net.mark.helg.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mark.helg.Helg;
import net.mark.helg.entity.ModEntities;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ModItems {

    public static final Item HELG_SHARD = registerItem("helg_shard", Item::new);
    public static final Item HELGERITE_INGOT = registerItem("helgerite_ingot", Item::new);


    public static final Item HELGERITE_HELMET = registerItem("helgerite_helmet",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.HELGERITE_ARMOR_MATERIAL, ArmorType.HELMET)));

    public static final Item HELGERITE_CHESTPLATE = registerItem("helgerite_chestplate",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.HELGERITE_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));

    public static final Item HELGERITE_LEGGINGS = registerItem("helgerite_leggings",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.HELGERITE_ARMOR_MATERIAL, ArmorType.LEGGINGS)));

    public static final Item HELGERITE_BOOTS = registerItem("helgerite_boots",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.HELGERITE_ARMOR_MATERIAL, ArmorType.BOOTS)));

    public static final Item HELGERITE_SPAWN_EGG = registerItem("helgerite_spawn_egg",
            properties -> new SpawnEggItem(properties.spawnEgg(ModEntities.HELGERITE)));

    public static final Item HELG_HORSE_ARMOR = registerItem("helg_horse_armor",
            properties -> new Item(properties.horseArmor(ModArmorMaterials.HELG_ARMOR_MATERIAL)));

    public static final Item HELGERITE_HORSE_ARMOR = registerItem("helgerite_horse_armor",
            properties -> new Item(properties.horseArmor(ModArmorMaterials.HELGERITE_ARMOR_MATERIAL)));


    /* temp block to "handle" changing the id */
    public static final Item HELG_INGOT = registerItem("helg_ingot", Item::new);



    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Helg.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Helg.MOD_ID, name)))));
    }


    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.accept(ModItems.HELG_SHARD);
            entries.accept(ModItems.HELGERITE_INGOT);
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> {
            entries.accept(ModItems.HELGERITE_HELMET);
            entries.accept(ModItems.HELGERITE_CHESTPLATE);
            entries.accept(ModItems.HELGERITE_LEGGINGS);
            entries.accept(ModItems.HELGERITE_BOOTS);
            entries.accept(ModItems.HELG_HORSE_ARMOR);
            entries.accept(ModItems.HELGERITE_HORSE_ARMOR);
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(entries -> {
            entries.accept(ModItems.HELGERITE_SPAWN_EGG);
        });
    }
}
