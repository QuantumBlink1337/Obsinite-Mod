package com.quantumblink.datagen;

import com.quantumblink.BaseMod;
import com.quantumblink.block.BlockMod;
import com.quantumblink.blockentity.BlockEntityMod;
import com.quantumblink.item.ItemMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class ItemModels extends ItemModelProvider {
    public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BaseMod.MODID, existingFileHelper);
    }
    @Override
    protected void registerModels() {
        withExistingParent(Objects.requireNonNull(BlockEntityMod.POWERGEN_ITEM.get().getRegistryName()).getPath(), modLoc("block/powergen/main"));
        withExistingParent(Objects.requireNonNull(BlockMod.CINNABAR_ORE_ITEM.get().getRegistryName()).getPath(), modLoc("block/cinnabar_ore"));
        withExistingParent(Objects.requireNonNull(BlockMod.MERCURIZED_OBSIDIAN_ITEM.get().getRegistryName()).getPath(), modLoc("block/mercurized_obsidian"));
        singleTexture(Objects.requireNonNull(ItemMod.CINNABAR.get().getRegistryName()).getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/cinnabar"));
        singleTexture(Objects.requireNonNull(ItemMod.CINNABAR_DUST.get().getRegistryName()).getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/cinnabar_dust"));
        singleTexture(Objects.requireNonNull(ItemMod.MERCURY.get().getRegistryName()).getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/mercury"));
        singleTexture(Objects.requireNonNull(ItemMod.OBSINITE.get().getRegistryName()).getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/obsinite_ingot"));
    }
}
