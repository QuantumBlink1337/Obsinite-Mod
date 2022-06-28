package com.quantumblink.datagen;

import com.quantumblink.BaseMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider {
    public BlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, BaseMod.MODID, helper);
    }
    @Override
    protected void registerStatesAndModels() {

    }
}
