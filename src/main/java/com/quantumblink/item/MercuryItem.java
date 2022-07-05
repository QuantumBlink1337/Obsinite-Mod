package com.quantumblink.item;

import com.quantumblink.block.BlockMod;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import static com.quantumblink.item.ItemMod.ITEM_PROPERTIES;

public class MercuryItem extends Item {
    private static final Supplier<MobEffectInstance> CONFUSION = () -> new MobEffectInstance(MobEffects.CONFUSION, 200, 1);
    private static final Supplier<MobEffectInstance> BLINDNESS = () -> new MobEffectInstance(MobEffects.BLINDNESS, 200, 1);
    private static final Supplier<MobEffectInstance> WEAKNESS = () -> new MobEffectInstance(MobEffects.WEAKNESS, 200, 2);
    private static final Supplier<MobEffectInstance> POISON_4 = () -> new MobEffectInstance(MobEffects.POISON, 200, 4);

    public static final String MERCURY_INFO = "message.mercury";
    // Extremely toxic.
    private static final FoodProperties foodProperties = new FoodProperties.Builder().nutrition(0).saturationMod(0).alwaysEat()
            .effect(CONFUSION, 1f)
            .effect(BLINDNESS, 1f)
            .effect(WEAKNESS, 1f)
            .effect(POISON_4, 1f)
            .build();

    public static final Properties properties = ITEM_PROPERTIES.food(foodProperties);
    public static final Item INSTANCE = new MercuryItem(properties);
    public MercuryItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack) {
        return UseAnim.DRINK;
    }
    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Block block = pContext.getLevel().getBlockState(pContext.getClickedPos()).getBlock();
        if (block.equals(Blocks.OBSIDIAN)) {
            pContext.getLevel().setBlock(pContext.getClickedPos(), BlockMod.MERCURIZED_OBSIDIAN.get().defaultBlockState(), 1);
            Objects.requireNonNull(pContext.getPlayer()).getMainHandItem().shrink(1);
            pContext.getPlayer().playSound(SoundEvents.GLASS_BREAK, 10, 1);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }
//    public InteractionResult useOn(UseOnContext context) {
//        context.getLevel().setBlock(context.getClickedPos(), Blocks.GOLD_BLOCK.defaultBlockState(), 1);
//
//        return InteractionResult.PASS;
//    }
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(new TextComponent(MERCURY_INFO).withStyle(ChatFormatting.DARK_BLUE));
    }


}
