package com.idtech.item;

import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class TeleportRodItem extends Item {
    private static final Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_MISC);
    public static Item INSTANCE = new TeleportRodItem(properties).setRegistryName("teleportrod");
    public TeleportRodItem(Properties properties) {
        super(properties);
    }
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player playerIn, @NotNull InteractionHand handIn) {
        ItemStack itemStack = playerIn.getItemInHand(handIn);
        BlockPos pos = Utils.getBlockAtCursor(playerIn, 1000.0d, true);
        if (pos != null) {
            playerIn.teleportTo(pos.getX(), pos.getY(), pos.getZ());
            playerIn.fallDistance = 0.0f;
        }
        return InteractionResultHolder.pass(itemStack);
    }
}

