package com.quantumblink.item;

import com.quantumblink.BaseMod;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class GelPickaxeItem extends PickaxeItem {
    private static final Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_TOOLS);
    public static Tier tier = new ForgeTier(4, 1561, 8.0F, 10.0F, 3, null, ()-> Ingredient.of(ItemMod.STRUCTURE_GEL));
    public static Item INSTANCE = new GelPickaxeItem(tier,
            100, 100, properties).setRegistryName(BaseMod.MODID, "gelpickaxe");

    public GelPickaxeItem(Tier tier, int attackDamageIn, float AttackSpeedIn, Properties properties) {
        super(tier, attackDamageIn, AttackSpeedIn, properties);
    }
}
