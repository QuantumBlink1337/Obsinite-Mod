package com.quantumblink.item.tools;

import com.quantumblink.BaseMod;
import com.quantumblink.item.ItemMod;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class GelPickaxeItem extends PickaxeItem {
    public static Item INSTANCE = new GelPickaxeItem(ToolMod.tier,
            100, 100, ItemMod.ITEM_PROPERTIES);

    public GelPickaxeItem(Tier tier, int attackDamageIn, float AttackSpeedIn, Properties properties) {
        super(tier, attackDamageIn, AttackSpeedIn, properties);
    }
}
