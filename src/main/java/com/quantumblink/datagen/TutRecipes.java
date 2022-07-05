package com.quantumblink.datagen;

import com.quantumblink.BaseMod;
import com.quantumblink.block.BlockMod;
import com.quantumblink.item.ItemMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

// https://docs.minecraftforge.net/en/1.18.x/datagen/server/recipes/
public class TutRecipes extends RecipeProvider {

    public TutRecipes(DataGenerator generatorIn) {
        super(generatorIn);
    }
    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {

        List<Item> dyes = new ArrayList<>();
            dyes.add(Items.BLACK_DYE);
            dyes.add(Items.BLUE_DYE);
            dyes.add(Items.BROWN_DYE);
            dyes.add(Items.CYAN_DYE);
            dyes.add(Items.GRAY_DYE);
            dyes.add(Items.GREEN_DYE);
            dyes.add(Items.LIME_DYE);
            dyes.add(Items.MAGENTA_DYE);
            dyes.add(Items.ORANGE_DYE);
            dyes.add(Items.PINK_DYE);
            dyes.add(Items.PURPLE_DYE);
            dyes.add(Items.RED_DYE);
            dyes.add(Items.WHITE_DYE);
            dyes.add(Items.YELLOW_DYE);
            dyes.add(Items.LIGHT_BLUE_DYE);
            dyes.add(Items.LIGHT_GRAY_DYE);

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
        for (Item dye : dyes) {
            SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemMod.CRYSTALLINE_MIX.get()), dye)
                    .unlockedBy("has_crystalline_mix", has(ItemMod.CRYSTALLINE_MIX.get()))
                    .save(consumer, BaseMod.MODID+":crystalline_" + dye);
        }


//        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemMod.CRYSTALLINE_MIX.get()), Tags.Items.DYES.)
//                .
    }
}