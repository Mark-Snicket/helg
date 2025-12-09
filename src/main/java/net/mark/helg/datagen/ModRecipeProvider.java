package net.mark.helg.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.mark.helg.Helg;
import net.mark.helg.block.ModBlocks;
import net.mark.helg.item.ModItems;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                /*List<ItemConvertible> HELG_SMELTABLES = List.of(ModBlocks.HELG_ORE, ModItems.HELGERITE_HELMET,
                        ModItems.HELGERITE_CHESTPLATE, ModItems.HELGERITE_LEGGINGS, ModItems.HELGERITE_BOOTS);

                offerSmelting(HELG_SMELTABLES, RecipeCategory.MISC, ModItems.HELG_SHARD, 0.1f, 200, "helg_shard");
                offerBlasting(HELG_SMELTABLES, RecipeCategory.MISC, ModItems.HELG_SHARD, 0.1f, 100, "helg_shard");

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.HELG_INGOT, RecipeCategory.DECORATIONS, ModBlocks.HELG_BLOCK);

                createShaped(RecipeCategory.MISC, ModItems.HELG_INGOT)
                        .pattern(" + ")
                        .pattern("+#+")
                        .pattern(" + ")
                        .input('+', ModItems.HELG_SHARD)
                        .input('#', Items.LAPIS_LAZULI)
                        .criterion(hasItem(ModItems.HELG_SHARD), conditionsFromItem(ModItems.HELG_SHARD))
                        .offerTo(recipeExporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(Helg.MOD_ID, "helg_ingot_from_shard")));

                createShapeless(RecipeCategory.MISC, ModItems.HELG_INGOT, 9)
                        .input(ModBlocks.HELG_BLOCK)
                        .criterion(hasItem(ModBlocks.HELG_BLOCK), conditionsFromItem(ModBlocks.HELG_BLOCK))
                        .offerTo(recipeExporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(Helg.MOD_ID, "helg_ingot_from_block")));*/

            }
        };
    }



    @Override
    public String getName() {
        return "Helg recipes";
    }
}
