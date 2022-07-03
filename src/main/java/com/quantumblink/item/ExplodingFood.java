package com.quantumblink.item;

import com.quantumblink.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import static com.quantumblink.item.ItemMod.ITEM_PROPERTIES;


public class ExplodingFood extends Item {
//    private static final Supplier<MobEffectInstance> foodEffect = () -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 500, 1);
    private static final FoodProperties foodProperties = new FoodProperties.Builder().nutrition(10).saturationMod(10).alwaysEat().build();
    public static final Properties properties =ITEM_PROPERTIES.food(foodProperties);
    public static final Item INSTANCE = new ExplodingFood(properties);
    public ExplodingFood(Properties p_41383_) {
        super(p_41383_);
    }
    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack p_41409_, @NotNull Level p_41410_, LivingEntity p_41411_) {
        BlockPos blockPos = p_41411_.blockPosition();
        Utils.createExplosion(p_41410_, blockPos, 3);
        return this.isEdible() ? p_41411_.eat(p_41410_, p_41409_) : p_41409_;

    }
}
