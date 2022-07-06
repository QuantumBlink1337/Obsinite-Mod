package com.quantumblink.enchantment;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class MercurizedEnchantment extends Enchantment {
    public static Enchantment INSTANCE = new MercurizedEnchantment(Rarity.VERY_RARE, EquipmentSlot.MAINHAND);

    protected MercurizedEnchantment(Rarity rarityIn, EquipmentSlot... slots) {
        super(rarityIn, EnchantmentCategory.WEAPON, slots);
    }


    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinCost(int enchantmentLevel) {
        return 30 + 10 * (enchantmentLevel - 1);
    }
    public int getMaxCost(int enchantmentLevel) {
        return super.getMinCost(enchantmentLevel) + 50;
    }
    // This currently works similar to the enchantability levels of efficiency, based on the current enchantment level of the player

    public int getMaxLevel() {
        return 3;
    }

    public void doPostAttack(@NotNull LivingEntity user, @NotNull Entity target, int level) {
        if (target instanceof LivingEntity livingentity) {

            int ticks = level * 50;
            int amplifer = level % 3 == 0 ? 1 : 0;
            livingentity.addEffect(new MobEffectInstance(MobEffects.POISON, ticks, amplifer+1));
            livingentity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, ticks, amplifer));
            livingentity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, ticks, 0));
            livingentity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, ticks, 0));
        }
    }
}
