package com.quantumblink.block;

import com.quantumblink.BaseMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.NotNull;

public class RubberBlock extends Block {
    private static final Properties properties = Properties.of(Material.STONE);
    public static Block Instance = new RubberBlock(properties);
    public RubberBlock(Properties p_49795_) {
        super(p_49795_);
    }
    @Override
    public void stepOn(@NotNull Level levelIn, @NotNull BlockPos posIn, @NotNull BlockState blockStateIn, @NotNull Entity entityIn) {
        super.stepOn(levelIn, posIn, blockStateIn, entityIn);
        entityIn.setDeltaMovement(0,5,0);
        entityIn.resetFallDistance();
    }
}
