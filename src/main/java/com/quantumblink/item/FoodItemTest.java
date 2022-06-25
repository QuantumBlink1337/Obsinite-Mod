package com.quantumblink.item;

import com.quantumblink.BaseMod;
import com.quantumblink.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;



public class FoodItemTest extends Item {
//    private static final Supplier<MobEffectInstance> foodEffect = () -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 500, 1);
    private static FoodProperties foodProperties = new FoodProperties.Builder().nutrition(10).saturationMod(10).alwaysEat().build();
    private static Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(foodProperties);
    public static Item INSTANCE = new FoodItemTest(properties).setRegistryName(BaseMod.MODID, "exploding_food");
    public FoodItemTest(Properties p_41383_) {
        super(p_41383_);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack p_41409_, Level p_41410_, LivingEntity p_41411_) {
        BlockPos blockPos = p_41411_.blockPosition();
        Utils.createExplosion(p_41410_, blockPos, 3);
        return this.isEdible() ? p_41411_.eat(p_41410_, p_41409_) : p_41409_;
    }
}
