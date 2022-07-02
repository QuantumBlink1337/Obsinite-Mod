package com.quantumblink.datagen;

import com.quantumblink.BaseMod;
import com.quantumblink.blockentity.BlockEntityMod;
import net.minecraft.data.DataGenerator;
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

        //BlockEntityMod Registration;
        add(BlockEntityMod.POWERGEN.get(), "Power Generator");
//        add(Registration.MYSTERIOUS_ORE_OVERWORLD.get(), "Mysterious ore");
//        add(Registration.MYSTERIOUS_ORE_NETHER.get(), "Mysterious ore");
//        add(Registration.MYSTERIOUS_ORE_END.get(), "Mysterious ore");
//        add(Registration.MYSTERIOUS_ORE_DEEPSLATE.get(), "Mysterious ore");

    }
}