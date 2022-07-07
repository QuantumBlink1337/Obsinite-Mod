package com.quantumblink.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class ObsiniteBoots extends ArmorItem {
    public static final ObsiniteBoots INSTANCE = new ObsiniteBoots(ArmorStatistics.OBSINITE, EquipmentSlot.FEET, ItemMod.ITEM_PROPERTIES.fireResistant());
    public ObsiniteBoots(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        if (slot == EquipmentSlot.LEGS) {
            return "examplemod:textures/models/armor/obsinite_armor_layer_2";
        }
        else {
            return "examplemod:textures/models/armor/obsinite_armor_layer_1";
        }
    }
}
