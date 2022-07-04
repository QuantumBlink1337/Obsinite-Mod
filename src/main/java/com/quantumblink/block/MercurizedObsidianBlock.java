package com.quantumblink.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class MercurizedObsidianBlock extends Block {
    private static final Properties properties = Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(50f, 1200f);
    public static final MercurizedObsidianBlock INSTANCE = new MercurizedObsidianBlock(properties);
    public MercurizedObsidianBlock(Properties p_49795_) {
        super(p_49795_);
    }

}
