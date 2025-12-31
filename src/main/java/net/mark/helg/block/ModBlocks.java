package net.mark.helg.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mark.helg.Helg;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {

    public static final Block HELG_ORE = registerBlock("helg_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2,5), properties
                    .strength(1f)
                    .explosionResistance(1f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.ROOTED_DIRT)));

    public static final Block HELGERITE_BLOCK = registerBlock("helgerite_block",
            properties -> new Block(properties
                    .strength(5f)
                    .explosionResistance(5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GRAVEL)));


    /* temp block to handle "changing the id" */
    public static final Block HELG_BLOCK = registerBlock("helg_block",
            properties -> new Block(properties
                    .strength(5f)
                    .explosionResistance(5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GRAVEL)));




    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Helg.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Helg.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Helg.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Helg.MOD_ID, name)))));
    }


    public static void registerModBlocks() {
    ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> {
        entries.accept(ModBlocks.HELG_ORE);
        });

    ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
        entries.accept(ModBlocks.HELGERITE_BLOCK);
        });
    }
}
