package com.quantumblink.item.tools;

import com.quantumblink.item.ItemMod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ObsiniteChest extends ArmorItem {
    public static final ObsiniteChest INSTANCE = new ObsiniteChest(ArmorStatistics.OBSINITE, EquipmentSlot.CHEST, ItemMod.ITEM_PROPERTIES);
    public ObsiniteChest(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }
    private static final MobEffectInstance FIRE_RESIST = new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1);
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player) {
            boolean HELMET = player.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(ItemMod.OBSINITE_HELMET.get());
            boolean LEGGINGS = player.getItemBySlot(EquipmentSlot.LEGS).getItem().equals(ItemMod.OBSINITE_LEGGINGS.get());
            boolean BOOTS = player.getItemBySlot(EquipmentSlot.FEET).getItem().equals(ItemMod.OBSINITE_BOOTS.get());
            if (HELMET && LEGGINGS && BOOTS) {
                player.addEffect(FIRE_RESIST);
            }
        }
    }


}
