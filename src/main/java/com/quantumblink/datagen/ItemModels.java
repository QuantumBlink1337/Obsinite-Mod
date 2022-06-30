package com.quantumblink.datagen;

import com.quantumblink.BaseMod;
import com.quantumblink.blockentity.BlockEntityMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModels extends ItemModelProvider {
    public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BaseMod.MODID, existingFileHelper);
    }
    @Override
    protected void registerModels() {
        withExistingParent(BlockEntityMod.POWERGEN_ITEM.get().getRegistryName().getPath(), modLoc("block/powergen/main"));
    }
}
