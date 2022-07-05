package com.quantumblink.datagen;

import com.quantumblink.BaseMod;
import com.quantumblink.item.ItemMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class ItemTagsGen extends ItemTagsProvider {
    public ItemTagsGen(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
        super(generator, blockTags, BaseMod.MODID, helper);
    }
    @Override
    protected void addTags() {
        tag(Tags.Items.DUSTS)
                .add(ItemMod.CINNABAR_DUST.get());
        tag(Tags.Items.GEMS)
                .add(ItemMod.CINNABAR.get());
    }
    @Override
    public @NotNull String getName() {
        return "QuantumBlink Tags";
    }
}
