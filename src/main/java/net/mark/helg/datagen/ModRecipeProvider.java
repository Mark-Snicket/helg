package net.mark.helg.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.mark.helg.Helg;
import net.mark.helg.block.ModBlocks;
import net.mark.helg.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        /*List<ItemConvertible> HELG_SMELTABLES = List.of(ModBlocks.HELG_ORE, ModItems.HELGERITE_HELMET,
                ModItems.HELGERITE_CHESTPLATE, ModItems.HELGERITE_LEGGINGS, ModItems.HELGERITE_BOOTS);

        offerSmelting(recipeExporter, HELG_SMELTABLES, RecipeCategory.MISC, ModItems.HELG_SHARD, 0.1f, 200, "helg_shard");
        offerBlasting(recipeExporter, HELG_SMELTABLES, RecipeCategory.MISC, ModItems.HELG_SHARD, 0.1f, 100, "helg_shard");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.HELG_INGOT, RecipeCategory.DECORATIONS, ModBlocks.HELG_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HELG_INGOT)
                .pattern(" + ")
                .pattern("+ +")
                .pattern(" + ")
                .input('+', ModItems.HELG_SHARD)
                //.input('+', idk how make vanilla item);
                .criterion(hasItem(ModItems.HELG_SHARD), conditionsFromItem(ModItems.HELG_SHARD))
                .offerTo(recipeExporter, Identifier.of(Helg.MOD_ID, "helg_ingot_from_shard"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HELG_INGOT, 9)
                .input(ModBlocks.HELG_BLOCK)
                .criterion(hasItem(ModBlocks.HELG_BLOCK), conditionsFromItem(ModBlocks.HELG_BLOCK))
                .offerTo(recipeExporter, Identifier.of(Helg.MOD_ID, "helg_ingot_from_block"));*/
    }
}
