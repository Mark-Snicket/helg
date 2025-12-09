package net.mark.helg.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.mark.helg.Helg;
import net.mark.helg.block.ModBlocks;
import net.mark.helg.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                /*List<ItemLike> HELG_SMELTABLES = List.of(ModBlocks.HELG_ORE, ModItems.HELGERITE_HELMET,
                        ModItems.HELGERITE_CHESTPLATE, ModItems.HELGERITE_LEGGINGS, ModItems.HELGERITE_BOOTS);

                oreSmelting(HELG_SMELTABLES, RecipeCategory.MISC, ModItems.HELG_SHARD, 0.1f, 200, "helg_shard");
                oreBlasting(HELG_SMELTABLES, RecipeCategory.MISC, ModItems.HELG_SHARD, 0.1f, 100, "helg_shard");

                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.HELG_INGOT, RecipeCategory.DECORATIONS, ModBlocks.HELG_BLOCK);

                shaped(RecipeCategory.MISC, ModItems.HELG_INGOT)
                        .pattern(" + ")
                        .pattern("+#+")
                        .pattern(" + ")
                        .define('+', ModItems.HELG_SHARD)
                        .define('#', Items.LAPIS_LAZULI)
                        .unlockedBy(getHasName(ModItems.HELG_SHARD), has(ModItems.HELG_SHARD))
                        .save(exporter, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(Helg.MOD_ID, "helg_ingot_from_shard")));

                shapeless(RecipeCategory.MISC, ModItems.HELG_INGOT, 9)
                        .requires(ModBlocks.HELG_BLOCK)
                        .unlockedBy(getHasName(ModBlocks.HELG_BLOCK), has(ModBlocks.HELG_BLOCK))
                        .save(exporter, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(Helg.MOD_ID, "helg_ingot_from_block")));*/

            }
        };
    }


    @Override
    public String getName() {
        return "Helg recipes";
    }
}
