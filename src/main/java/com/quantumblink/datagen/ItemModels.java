package com.quantumblink.datagen;

import com.quantumblink.BaseMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModels extends ItemModelProvider {
    public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BaseMod.MODID, existingFileHelper);
    }
    @Override
    protected void registerModels() {

    }
}
