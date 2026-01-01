package net.mark.helg.util;

import net.mark.helg.Helg;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> HELGERITE_BLOCK_CRAFTABLES = createTag("helgerite_block_craftables");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Helg.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> HELG_ARMOR_REPAIRABLES = createTag("helg_armor_repairables");
        public static final TagKey<Item> HELGERITE_ARMOR_REPAIRABLES = createTag("helgerite_armor_repairables");
        public static final TagKey<Item> HELGERITE_INGOT_CRAFTABLES = createTag("helgerite_ingot_craftables");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Helg.MOD_ID, name));
        }
    }
}
