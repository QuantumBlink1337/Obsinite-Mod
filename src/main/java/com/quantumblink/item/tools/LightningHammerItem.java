package com.quantumblink.item.tools;

import com.quantumblink.BaseMod;
import com.quantumblink.Utils;
import com.quantumblink.item.ItemMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeTier;
import org.jetbrains.annotations.NotNull;

public class LightningHammerItem extends SwordItem {
    public static Tier tier = new ForgeTier(4, 1561, 8.0F, 10.0F, 3, null, ()-> Ingredient.of(ItemMod.STRUCTURE_GEL.get()));

    public static Item INSTANCE = new LightningHammerItem(tier, 7, 3.3F, ItemMod.ITEM_PROPERTIES);
    public LightningHammerItem(Tier tier, int attackDamageIn, float attackFloatIn, Properties properties) {
        super(tier, attackDamageIn, attackFloatIn, properties);
    }
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player playerIn, @NotNull InteractionHand handIn) {
        ItemStack itemStack = playerIn.getItemInHand(handIn);
        BlockPos blockPos = Utils.getBlockAtCursor(playerIn, 20.0d, true);
        if (blockPos != null) {
            playerIn.die(DamageSource.DRAGON_BREATH);
            //Utils.createExplosion(level, blockPos, 0.5f);
            //Utils.strikeLightning(level, blockPos);
        }
        return InteractionResultHolder.pass(itemStack);
    }
}
