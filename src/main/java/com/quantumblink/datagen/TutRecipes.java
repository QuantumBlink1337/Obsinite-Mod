package com.quantumblink.datagen;

import com.quantumblink.BaseMod;
import com.quantumblink.block.BlockMod;
import com.quantumblink.item.ItemMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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

        List<Item> NETHERITE_ARMOR = new ArrayList<>();
            NETHERITE_ARMOR.add( Items.NETHERITE_HELMET);
            NETHERITE_ARMOR.add( Items.NETHERITE_CHESTPLATE);
            NETHERITE_ARMOR.add( Items.NETHERITE_LEGGINGS);
            NETHERITE_ARMOR.add( Items.NETHERITE_BOOTS);
        List<Item> OBSINITE_ARMOR = new ArrayList<>();
            OBSINITE_ARMOR.add( ItemMod.OBSINITE_HELMET.get());
            OBSINITE_ARMOR.add( ItemMod.OBSINITE_CHEST.get());
            OBSINITE_ARMOR.add( ItemMod.OBSINITE_LEGGINGS.get());
            OBSINITE_ARMOR.add( ItemMod.OBSINITE_BOOTS.get());
        List<Item> NETHERITE_TOOLS = new ArrayList<>();
        NETHERITE_TOOLS.add( Items.NETHERITE_SWORD);
        NETHERITE_TOOLS.add( Items.NETHERITE_PICKAXE);
        NETHERITE_TOOLS.add( Items.NETHERITE_SHOVEL);
        NETHERITE_TOOLS.add( Items.NETHERITE_AXE);
        NETHERITE_TOOLS.add( Items.NETHERITE_HOE);
        List<Item> OBSINITE_TOOLS = new ArrayList<>();
        OBSINITE_TOOLS.add( ItemMod.OBSINITE_SWORD.get());
        OBSINITE_TOOLS.add( ItemMod.OBSINITE_PICKAXE.get());
        OBSINITE_TOOLS.add( ItemMod.OBSINITE_SHOVEL.get());
        OBSINITE_TOOLS.add( ItemMod.OBSINITE_AXE.get());
        OBSINITE_TOOLS.add( ItemMod.OBSINITE_HOE.get());
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ItemMod.CINNABAR_DUST.get()), ItemMod.MERCURY.get(), 2f, 400)
                .unlockedBy("has_cinnabar_dust",has(ItemMod.CINNABAR_DUST.get()))
                .save(consumer, recipeName("cinnabar_dust_to_mercury"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemMod.CINNABAR.get()), ItemMod.CINNABAR_DUST.get())
                .unlockedBy("has_cinnabar", has(ItemMod.CINNABAR.get()))
                .save(consumer, recipeName("cinnabar_to_cinnabar_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockMod.CINNABAR_ORE_ITEM.get()), ItemMod.CINNABAR.get(), 2f, 200)
                .unlockedBy("has_cinnabar_ore", has(BlockMod.CINNABAR_ORE_ITEM.get()))
                .save(consumer, recipeName("cinnabar_ore_to_crystals"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_INGOT), Ingredient.of(BlockMod.MERCURIZED_OBSIDIAN_ITEM.get()), ItemMod.OBSINITE.get())
                .unlocks("mercurized_obsidian_unlock", has(BlockMod.MERCURIZED_OBSIDIAN_ITEM.get()))
                .save(consumer, recipeName("obsinite_ingot_recipe"));
        for (Item dye : dyes) {
            SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemMod.CRYSTALLINE_MIX.get()), dye)
                    .unlockedBy("has_crystalline_mix", has(ItemMod.CRYSTALLINE_MIX.get()))
                    .save(consumer, recipeName("crystalline_" + dye));
        }
        for (int i = 0; i < NETHERITE_ARMOR.size(); i++) {
            UpgradeRecipeBuilder.smithing(Ingredient.of(NETHERITE_ARMOR.get(i)), Ingredient.of(ItemMod.OBSINITE.get()), OBSINITE_ARMOR.get(i))
                    .unlocks("has_obsinite_ingot", has(ItemMod.OBSINITE.get()))
                    .save(consumer, recipeName(OBSINITE_ARMOR.get(i).toString()));

        }
        for (int i = 0; i < NETHERITE_TOOLS.size(); i++) {
            UpgradeRecipeBuilder.smithing(Ingredient.of(NETHERITE_TOOLS.get(i)), Ingredient.of(ItemMod.OBSINITE.get()), OBSINITE_TOOLS.get(i))
                    .unlocks("has_obsinite_ingot", has(ItemMod.OBSINITE.get()))
                    .save(consumer, recipeName(OBSINITE_TOOLS.get(i).toString()));

        }
        ShapelessRecipeBuilder.shapeless(ItemMod.CRYSTALLINE_MIX.get())
                .requires(ItemMod.CINNABAR.get())
                .requires(Items.AMETHYST_SHARD)
                .requires(Items.QUARTZ)
                .requires(Items.LAPIS_LAZULI)
                .unlockedBy("has_cinnabar", has(ItemMod.CINNABAR.get()))
                .save(consumer, recipeName("crystalline_mix_recipe"));
        ShapedRecipeBuilder.shaped(BlockMod.OBSINITE_BLOCK_ITEM.get())
                .pattern("aaa")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', ItemMod.OBSINITE.get())
                .unlockedBy("has_obsinite_ingot",has(ItemMod.OBSINITE.get()))
                .save(consumer, recipeName("obsinite_ingot_to_block"));
        ShapelessRecipeBuilder.shapeless(ItemMod.OBSINITE.get(), 9)
                .requires(BlockMod.OBSINITE_BLOCK_ITEM.get())
                .unlockedBy("has_obsinite_ingot",has(ItemMod.OBSINITE.get()))
                .save(consumer, recipeName("obsinite_block_to_ingot"));

    }
    private String recipeName(String string) {
        return BaseMod.MODID + ":" + string;
    }
}