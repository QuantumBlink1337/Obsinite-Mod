package com.quantumblink.datagen;

import com.quantumblink.block.BlockMod;
import com.quantumblink.item.ItemMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.crafting.UpgradeRecipe;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
// https://docs.minecraftforge.net/en/1.18.x/datagen/server/recipes/
public class TutRecipes extends RecipeProvider {

    public TutRecipes(DataGenerator generatorIn) {
        super(generatorIn);
    }
    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {

        List<ItemStack> dyes;

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ItemMod.CINNABAR_DUST.get()), ItemMod.MERCURY.get(), 2f, 400)
                .unlockedBy("has_cinnabar_dust",has(ItemMod.CINNABAR_DUST.get()))
                .save(consumer, "cinnabar_dust_to_mercury");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemMod.CINNABAR.get()), ItemMod.CINNABAR_DUST.get())
                .unlockedBy("has_cinnabar", has(ItemMod.CINNABAR.get()))
                .save(consumer, "cinnabar_to_cinnabar_dust");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockMod.CINNABAR_ORE_ITEM.get()), ItemMod.CINNABAR.get(), 2f, 200)
                .unlockedBy("has_cinnabar_ore", has(BlockMod.CINNABAR_ORE_ITEM.get()))
                .save(consumer, "cinnabar_ore_to_crystals");
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_INGOT), Ingredient.of(BlockMod.MERCURIZED_OBSIDIAN_ITEM.get()), ItemMod.OBSINITE.get())
                .unlocks("mercurized_obsidian_unlock", has(BlockMod.MERCURIZED_OBSIDIAN_ITEM.get()))
                .save(consumer, "obsinite_ingot_recipe");
//        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemMod.CRYSTALLINE_MIX.get()), Tags.Items.DYES.)
//                .
    }
}