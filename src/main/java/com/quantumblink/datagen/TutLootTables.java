package com.quantumblink.datagen;

import com.quantumblink.blockentity.BlockEntityMod;
import net.minecraft.data.DataGenerator;

public class TutLootTables extends BaseLootTableProvider {

    public TutLootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        lootTables.put(BlockEntityMod.POWERGEN.get(), createStandardTable("powergen", BlockEntityMod.POWERGEN.get(), BlockEntityMod.POWERGEN_BE.get()));
    }
}