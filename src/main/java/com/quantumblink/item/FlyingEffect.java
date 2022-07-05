package com.quantumblink.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class FlyingEffect extends MobEffect {
    public static final FlyingEffect CREATIVE_FLIGHT = new FlyingEffect(MobEffectCategory.BENEFICIAL, 0);

    protected FlyingEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity instanceof Player player) {
            player.getAbilities().mayfly = true;
        }
    }
}
