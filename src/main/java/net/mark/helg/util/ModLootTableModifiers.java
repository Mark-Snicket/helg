package net.mark.helg.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.mark.helg.item.ModItems;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ModLootTableModifiers {

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {


            if (BuiltInLootTables.SIMPLE_DUNGEON.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .when(LootItemRandomChanceCondition.randomChance(0.066f).build())
                        .add(LootItem.lootTableItem(ModItems.HELG_HORSE_ARMOR).build())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            } else if (BuiltInLootTables.DESERT_PYRAMID.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .when(LootItemRandomChanceCondition.randomChance(0.055f).build())
                        .add(LootItem.lootTableItem(ModItems.HELG_HORSE_ARMOR).build())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            } else if (BuiltInLootTables.END_CITY_TREASURE.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .when(LootItemRandomChanceCondition.randomChance(0.045f).build())
                        .add(LootItem.lootTableItem(ModItems.HELG_HORSE_ARMOR).build())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

            } else if (BuiltInLootTables.JUNGLE_TEMPLE.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .when(LootItemRandomChanceCondition.randomChance(0.045f).build())
                        .add(LootItem.lootTableItem(ModItems.HELG_HORSE_ARMOR).build())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

            } else if (BuiltInLootTables.NETHER_BRIDGE.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .when(LootItemRandomChanceCondition.randomChance(0.099f).build())
                        .add(LootItem.lootTableItem(ModItems.HELG_HORSE_ARMOR).build())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

            } else if (BuiltInLootTables.STRONGHOLD_CORRIDOR.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .when(LootItemRandomChanceCondition.randomChance(0.025f).build())
                        .add(LootItem.lootTableItem(ModItems.HELG_HORSE_ARMOR).build())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

            } else if (BuiltInLootTables.VILLAGE_WEAPONSMITH.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .when(LootItemRandomChanceCondition.randomChance(0.025f).build())
                        .add(LootItem.lootTableItem(ModItems.HELG_HORSE_ARMOR).build())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

            }
        });
    }
}