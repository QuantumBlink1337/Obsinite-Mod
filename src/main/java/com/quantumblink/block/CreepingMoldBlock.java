package com.quantumblink.block;

import com.quantumblink.BaseMod;
import com.quantumblink.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class CreepingMoldBlock extends Block {
    private static final Properties properties = Properties.of(Material.AMETHYST).randomTicks().strength(1.5f);
    public static final Block Instance = new CreepingMoldBlock(properties).setRegistryName(BaseMod.MODID, "creepingmold");
    public static final Item ITEM = BlockUtils.createBlockItem(Instance, CreativeModeTab.TAB_BUILDING_BLOCKS);
    public CreepingMoldBlock(Properties p_49795_) {
        super(p_49795_);

    }
    @Override
    public void randomTick(@NotNull BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos pos, @NotNull Random random) {
        super.randomTick(blockState, serverLevel, pos, random);
        BlockPos blockPos = Utils.findNeightborBlock(pos);
        serverLevel.setBlockAndUpdate(blockPos, this.defaultBlockState());
    }
}
