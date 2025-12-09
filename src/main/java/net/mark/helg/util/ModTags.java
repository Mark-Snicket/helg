package net.mark.helg.util;

import net.mark.helg.Helg;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;


public class ModTags {
    public static class Items {
        public static final TagKey<Item> HELGERITE_REPAIR = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Helg.MOD_ID, name));
        }
    }
}
