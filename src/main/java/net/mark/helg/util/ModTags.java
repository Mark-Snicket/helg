package net.mark.helg.util;

import net.mark.helg.Helg;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;


public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> HELGERITE_BLOCK_CRAFTABLES = createTag("helgerite_block_craftables");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Helg.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> HELGERITE_ARMOR_REPAIRABLES = createTag("helgerite_armor_repairables");
        public static final TagKey<Item> HELGERITE_INGOT_CRAFTABLES = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Helg.MOD_ID, name));
        }
    }
}
