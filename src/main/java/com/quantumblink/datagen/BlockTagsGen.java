package com.quantumblink.datagen;

import com.quantumblink.BaseMod;
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
                ;
        tag(BlockTags.NEEDS_IRON_TOOL)
                ;
        tag(Tags.Blocks.ORES)
                ;
    }
    @Override
    public @NotNull String getName() {
        return "QuantumBlink Tags";
    }

}
