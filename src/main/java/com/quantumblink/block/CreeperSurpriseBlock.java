package com.quantumblink.block;

import com.quantumblink.BaseMod;
import com.quantumblink.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.NotNull;

public class CreeperSurpriseBlock extends Block {
    private static final Properties properties = Properties.of(Material.STONE);
    public static final Block Instance = new CreeperSurpriseBlock(properties).setRegistryName(BaseMod.MODID, "creepersurprise");
    public static final Item ITEM = BlockUtils.createBlockItem(Instance, CreativeModeTab.TAB_COMBAT);
    public CreeperSurpriseBlock(Properties p_49795_) {
        super(p_49795_);
    }
    @Override
    public void playerDestroy(@NotNull Level level, @NotNull Player player, @NotNull BlockPos pos, @NotNull BlockState blockState, BlockEntity blockEntity, @NotNull ItemStack stack) {
        super.playerDestroy(level, player, pos, blockState, blockEntity, stack);
        //Creeper creeper = new Creeper(EntityType.CREEPER, level);
        PrimedTnt tnt = new PrimedTnt(EntityType.TNT, level);
        Utils.spawnEntity(level, tnt, pos);
    }
}
