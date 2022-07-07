package com.quantumblink.item;

import com.quantumblink.BaseMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ObsiniteBoots extends ArmorItem {
    public static final ObsiniteBoots INSTANCE = new ObsiniteBoots(ArmorStatistics.OBSINITE, EquipmentSlot.FEET, ItemMod.ITEM_PROPERTIES.fireResistant());
    public ObsiniteBoots(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }
    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        if (slot == EquipmentSlot.LEGS) {
            return BaseMod.MODID  + ":textures/models/armor/obsinite_armor_layer_2.png";
        }
        else {
            return BaseMod.MODID + ":textures/models/armor/obsinite_armor_layer_1.png";
        }
    }
}
