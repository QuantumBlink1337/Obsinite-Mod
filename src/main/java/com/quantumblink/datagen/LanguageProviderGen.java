package com.quantumblink.datagen;

import com.quantumblink.BaseMod;
import com.quantumblink.block.BlockMod;
import com.quantumblink.blockentity.BlockEntityMod;
import com.quantumblink.enchantment.EnchantmentMod;
import com.quantumblink.item.ItemMod;
import com.quantumblink.item.MercuryItem;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;

import static com.quantumblink.blockentity.PowergenBlock.*;
public class LanguageProviderGen extends LanguageProvider {

    public LanguageProviderGen(DataGenerator gen, String locale) {
        super(gen, BaseMod.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + BaseMod.CREATIVE_MODE_TAB, "Tutorial");
        //add(MESSAGE_POWERGEN, "Power generator generating %s per tick!");
        add(SCREEN_TUTORIAL_POWERGEN, "Power Generator");
        add(MercuryItem.MERCURY_INFO, "Right click Obsidian with this.");

        //BlockEntityMod Registration;
        add(BlockEntityMod.POWERGEN.get(), "Power Generator");
        add(BlockMod.CINNABAR_ORE.get(), "Cinnabar Ore");
        add(ItemMod.CINNABAR.get(), "Cinnabar Crystals");
        add(ItemMod.CINNABAR_DUST.get(), "Cinnabar Dust");
        add(ItemMod.MERCURY.get(), "Vial of Mercury");
        add(ItemMod.OBSINITE.get(), "Obsinite Ingot");
        add(EnchantmentMod.MERCURIZED.get(),"Mercurized");

        add(ItemMod.OBSINITE_HELMET.get(), "Obsinite Helmet");
        add(ItemMod.OBSINITE_CHEST.get(), "Obsinite Chestplate");
        add(ItemMod.OBSINITE_LEGGINGS.get(), "Obsinite Leggings");
        add(ItemMod.OBSINITE_BOOTS.get(), "Obsinite Boots");

    }
}