package net.mark.helg.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mark.helg.Helg;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Function;

public class ModBlocks {

    public static final Block HELG_ORE = registerBlock("helg_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(2,5),properties
                    .strength(1f)
                    .resistance(1f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.ROOTED_DIRT)));

    public static final Block HELGERITE_BLOCK = registerBlock("helgerite_block",
            properties -> new Block(properties
                    .strength(5f)
                    .resistance(5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.GRAVEL)));


    /* temp block to handle "changing the id" */
    public static final Block HELG_BLOCK = registerBlock("helg_block",
                    properties -> new Block(properties
                    .strength(5f)
                    .resistance(5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.GRAVEL)));




    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Helg.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(Helg.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Helg.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Helg.MOD_ID, name)))));
    }


    public static void registerModBlocks() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.HELG_ORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.HELGERITE_BLOCK);
        });
    }
}
