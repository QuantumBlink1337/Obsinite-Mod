package com.quantumblink.item.tools;

import com.quantumblink.item.ItemMod;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ToolMod {
    public static Tier tier = new ForgeTier(4, 1561, 8.0F, 10.0F, 3, null, ()-> Ingredient.of(ItemMod.OBSINITE.get()));

}
