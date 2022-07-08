package com.quantumblink.datagen;

import com.quantumblink.block.BlockMod;
import com.quantumblink.blockentity.BlockEntityMod;
import com.quantumblink.item.ItemMod;
import net.minecraft.data.DataGenerator;

public class TutLootTables extends BaseLootTableProvider {

    public TutLootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        lootTables.put(BlockEntityMod.POWERGEN.get(), createStandardTable("powergen", BlockEntityMod.POWERGEN.get(), BlockEntityMod.POWERGEN_BE.get()));
        lootTables.put(BlockMod.MERCURIZED_OBSIDIAN.get(), createSimpleTable("mercurized_obsidian", BlockMod.MERCURIZED_OBSIDIAN.get()));
        lootTables.put(BlockMod.CINNABAR_ORE.get(), createSilkTouchTable("cinnabar", BlockMod.CINNABAR_ORE.get(), ItemMod.CINNABAR.get(), 1, 3));
        lootTables.put(BlockMod.OBSINITE_BLOCK.get(), createSimpleTable("obsinite_block", BlockMod.OBSINITE_BLOCK.get()));
    }
}