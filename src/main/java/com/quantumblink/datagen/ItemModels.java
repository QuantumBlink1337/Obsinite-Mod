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
        withExistingParent(Objects.requireNonNull(BlockMod.OBSINITE_BLOCK_ITEM.get().getRegistryName()).getPath(), modLoc("block/obsinite_block"));


        withExistingParent(Objects.requireNonNull(ItemMod.OBSINITE_SWORD.get().getRegistryName()).getPath()
                , "item/handheld").texture("layer0", "item/obsinite_sword");
        withExistingParent(Objects.requireNonNull(ItemMod.OBSINITE_PICKAXE.get().getRegistryName()).getPath()
                , "item/handheld").texture("layer0", "item/obsinite_pickaxe");
        withExistingParent(Objects.requireNonNull(ItemMod.OBSINITE_SHOVEL.get().getRegistryName()).getPath()
                , "item/handheld").texture("layer0", "item/obsinite_shovel");
        withExistingParent(Objects.requireNonNull(ItemMod.OBSINITE_AXE.get().getRegistryName()).getPath()
                , "item/handheld").texture("layer0", "item/obsinite_axe");
        withExistingParent(Objects.requireNonNull(ItemMod.OBSINITE_HOE.get().getRegistryName()).getPath()
                , "item/handheld").texture("layer0", "item/obsinite_hoe");

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
        singleTexture(Objects.requireNonNull(ItemMod.OBSINITE_HELMET.get().getRegistryName()).getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/obsinite_helmet"));
        singleTexture(Objects.requireNonNull(ItemMod.OBSINITE_CHEST.get().getRegistryName()).getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/obsinite_chest"));
        singleTexture(Objects.requireNonNull(ItemMod.OBSINITE_LEGGINGS.get().getRegistryName()).getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/obsinite_leggings"));
        singleTexture(Objects.requireNonNull(ItemMod.OBSINITE_BOOTS.get().getRegistryName()).getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/obsinite_boots"));
        singleTexture(Objects.requireNonNull(ItemMod.CRYSTALLINE_MIX.get().getRegistryName()).getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/crystalline_mix"));
    }
}
