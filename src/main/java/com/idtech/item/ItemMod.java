package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber
public class ItemMod {

    //BASIC ITEMS
    public static final Item STRUCTURE_GEL = ItemUtils.buildBasicItem("structuregel", CreativeModeTab.TAB_MISC);
    public static final Item GEL_ORE = ItemUtils.buildBasicItem("gelore", CreativeModeTab.TAB_MISC);
    //FOODS
    private static final Supplier<MobEffectInstance> foodEffect = () -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 500, 1);
    public static final Item DOOM_GUM = ItemUtils.buildFoodItem("doomfood",new FoodProperties.Builder().nutrition(10)
            .saturationMod(10).effect(foodEffect, 1.0F).alwaysEat().build());
    public static final ArmorItem GEL_HELMET = (ArmorItem) new ArmorItem(ArmorStatistics.GEL, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)).setRegistryName(BaseMod.MODID, "gel_helmet");

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        //BASIC ITEMS
        event.getRegistry().register(STRUCTURE_GEL);
        event.getRegistry().register(GEL_ORE);
        event.getRegistry().register(TeleportRodItem.INSTANCE);
        // ITEMS
        // TOOLS
        event.getRegistry().register(GelPickaxeItem.INSTANCE);
        event.getRegistry().register(LightningHammerItem.INSTANCE);
        // FOOD
        event.getRegistry().register(DOOM_GUM);
        event.getRegistry().register(FoodItemTest.INSTANCE);
        // ARMOR
        event.getRegistry().register(GEL_HELMET);
        //PROJECTILES

    }
}
