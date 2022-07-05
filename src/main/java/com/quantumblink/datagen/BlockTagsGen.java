package com.quantumblink.datagen;

import com.quantumblink.BaseMod;
import com.quantumblink.block.BlockMod;
import com.quantumblink.blockentity.BlockEntityMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class BlockTagsGen extends BlockTagsProvider {
    public BlockTagsGen(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BaseMod.MODID, existingFileHelper);
    }
    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockEntityMod.POWERGEN.get())
                .add(BlockMod.CINNABAR_ORE.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockEntityMod.POWERGEN.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BlockMod.CINNABAR_ORE.get())
                .add(BlockMod.MERCURIZED_OBSIDIAN.get());
        tag(Tags.Blocks.ORES)
                .add(BlockMod.CINNABAR_ORE.get());
    }
    @Override
    public @NotNull String getName() {
        return "QuantumBlink Tags";
    }

}
