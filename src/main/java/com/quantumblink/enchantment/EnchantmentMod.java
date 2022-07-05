package com.quantumblink.enchantment;

import com.quantumblink.BaseMod;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentMod {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, BaseMod.MODID);

    public static final RegistryObject<Enchantment> MERCURIZED = ENCHANTMENTS.register("mercurized", () -> MercurizedEnchantment.INSTANCE);
}