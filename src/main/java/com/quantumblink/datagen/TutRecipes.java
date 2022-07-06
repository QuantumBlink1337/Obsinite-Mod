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



        List<ArmorItem> DIAMOND_ARMOR = new ArrayList<>();
            DIAMOND_ARMOR.add((ArmorItem) Items.DIAMOND_CHESTPLATE);
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
        for (ArmorItem armor : DIAMOND_ARMOR) {
            int remainingDurability = armor.getMaterial().getDurabilityForSlot(armor.getSlot()) - Ingredient.of(armor).getItems()[0].getDamageValue();

        }
        ShapelessRecipeBuilder.shapeless(ItemMod.CRYSTALLINE_MIX.get())
                .requires(ItemMod.CINNABAR.get())
                .requires(Items.AMETHYST_SHARD)
                .requires(Items.QUARTZ)
                .requires(Items.LAPIS_LAZULI)
                .unlockedBy("has_cinnabar", has(ItemMod.CINNABAR.get()))
                .save(consumer, recipeName("crystalline_mix_recipe"));
    }
    private String recipeName(String string) {
        return BaseMod.MODID + ":" + string;
    }
}