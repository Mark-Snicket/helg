package net.mark.helg.util;

import net.mark.helg.Helg;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;


public class ModTags {
    public static class Items {
        public static final TagKey<Item> HELGERITE_REPAIR = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Helg.MOD_ID, name));
        }
    }
}
