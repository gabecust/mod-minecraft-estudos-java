package net.gabecust.tutorialmod.datagen;

import net.gabecust.tutorialmod.TutorialMod;
import net.gabecust.tutorialmod.block.ModBlocks;
import net.gabecust.tutorialmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder{
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> ALUMINUM_SMELTABLES  = List.of(
            ModItems.RAW_ALUMINUM.get(),
            ModBlocks.ALUMINUM_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHISEL.get())
                .pattern(" P#")
                .pattern(" NP")
                .pattern("B  ")
                .define('N', Items.NETHERITE_INGOT)
                .define('B', Items.BLAZE_ROD)
                .define('#', ModBlocks.PURPLE_GOLD_BLOCK.get())
                .define('P', ModItems.PURPLE_GOLD_INGOT.get())
                .unlockedBy(getHasName(ModItems.PURPLE_GOLD_INGOT.get()), has(ModItems.PURPLE_GOLD_INGOT.get()))
                .unlockedBy(getHasName(ModBlocks.PURPLE_GOLD_BLOCK.get()), has(ModBlocks.PURPLE_GOLD_BLOCK.get()))
                .unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
                .unlockedBy(getHasName(Items.BLAZE_ROD), has(Items.BLAZE_ROD))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ENCHANTED_GOLDEN_APPLE)
                .pattern("###")
                .pattern("#A#")
                .pattern("###")
                .define('A', Items.APPLE)
                .define('#', ModBlocks.OLD_GOLD_BLOCK.get())
                .unlockedBy(getHasName(Items.APPLE), has(Items.APPLE))
                .unlockedBy(getHasName(ModBlocks.OLD_GOLD_BLOCK.get()), has(ModBlocks.OLD_GOLD_BLOCK.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID + ":enchanted_golden_apple_from_old_gold_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OLD_ENCHANTED_GOLDEN_APPLE.get())
                .pattern("###")
                .pattern("#A#")
                .pattern("###")
                .define('A', Items.APPLE)
                .define('#', ModBlocks.OLDER_GOLD_BLOCK.get())
                .unlockedBy(getHasName(Items.APPLE), has(Items.APPLE))
                .unlockedBy(getHasName(ModBlocks.OLDER_GOLD_BLOCK.get()), has(ModBlocks.OLDER_GOLD_BLOCK.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALUMINUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALUMINUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.ALUMINUM_INGOT.get()), has(ModItems.ALUMINUM_INGOT.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_ALUMINUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_ALUMINUM.get())
                .unlockedBy(getHasName(ModItems.RAW_ALUMINUM.get()), has(ModItems.RAW_ALUMINUM.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURPLE_GOLD_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.PURPLE_GOLD_INGOT.get())
                .unlockedBy(getHasName(ModItems.PURPLE_GOLD_INGOT.get()), has(ModItems.PURPLE_GOLD_INGOT.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALUMINUM_INGOT.get(), 9)
                .requires(ModBlocks.ALUMINUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ALUMINUM_BLOCK.get()), has(ModBlocks.ALUMINUM_BLOCK.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID + ":aluminum_ingot_from_aluminum_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_ALUMINUM.get(), 9)
                .requires(ModBlocks.RAW_ALUMINUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_ALUMINUM_BLOCK.get()), has(ModBlocks.RAW_ALUMINUM_BLOCK.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID + ":raw_aluminum_from_raw_aluminum_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PURPLE_GOLD_INGOT.get(), 9)
                .requires(ModBlocks.PURPLE_GOLD_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.PURPLE_GOLD_BLOCK.get()), has(ModBlocks.PURPLE_GOLD_BLOCK.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID + ":purple_gold_ingot_from_purple_gold_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GOLD_INGOT, 9)
                .requires(ModBlocks.OLD_GOLD_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.OLD_GOLD_BLOCK.get()), has(ModBlocks.OLD_GOLD_BLOCK.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID + ":gold_ingot_from_old_gold_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GOLD_INGOT, 9)
                .requires(ModBlocks.OLDER_GOLD_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.OLDER_GOLD_BLOCK.get()), has(ModBlocks.OLDER_GOLD_BLOCK.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID + ":gold_ingot_from_older_gold_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.IRON_INGOT, 9)
                .requires(ModBlocks.OLD_IRON_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.OLD_IRON_BLOCK.get()), has(ModBlocks.OLD_IRON_BLOCK.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID + ":iron_ingot_from_old_iron_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.DIAMOND, 9)
                .requires(ModBlocks.OLD_DIAMOND_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.OLD_DIAMOND_BLOCK.get()), has(ModBlocks.OLD_DIAMOND_BLOCK.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID + ":diamond_from_old_diamond_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.EMERALD, 9)
                .requires(ModBlocks.OLD_EMERALD_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.OLD_EMERALD_BLOCK.get()), has(ModBlocks.OLD_EMERALD_BLOCK.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID + ":emerald_from_old_emerald_block");

        oreSmelting(pRecipeOutput, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT.get(), 0.5f, 200, "aluminum_ingot");
        oreBlasting(pRecipeOutput, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT.get(), 0.5f, 100, "aluminum_ingot");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
