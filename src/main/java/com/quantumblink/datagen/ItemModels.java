package com.quantumblink.datagen;

import com.quantumblink.BaseMod;
import com.quantumblink.block.BlockMod;
import com.quantumblink.blockentity.BlockEntityMod;
import com.quantumblink.item.ItemMod;
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
        withExistingParent(BlockMod.CINNABAR_ORE_ITEM.get().getRegistryName().getPath(), modLoc("block/cinnabar_ore"));
        singleTexture(ItemMod.CINNABAR.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/cinnabar"));
    }
}
