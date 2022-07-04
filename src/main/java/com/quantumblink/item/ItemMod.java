package com.quantumblink.item;

import com.quantumblink.BaseMod;
import com.quantumblink.entity.EntityMod;
import com.quantumblink.item.tools.GelPickaxeItem;
import com.quantumblink.item.tools.LightningHammerItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber
public class ItemMod {
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(BaseMod.CREATIVE_MODE_TAB);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BaseMod.MODID);
    public static final DeferredRegister<Item> TOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, BaseMod.MODID);
    public static final DeferredRegister<Item> FOODS = DeferredRegister.create(ForgeRegistries.ITEMS, BaseMod.MODID);


    //BASIC ITEMS
    public static final RegistryObject<Item> CINNABAR = ITEMS.register("cinnabar", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> CINNABAR_DUST = ITEMS.register("cinnabar_dust", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> MERCURY = ITEMS.register("mercury", () -> MercuryItem.INSTANCE);
    public static final RegistryObject<Item> OBSINITE = ITEMS.register("obsinite_ingot", () -> new Item(ITEM_PROPERTIES));

    //FOODS
    public static final RegistryObject<Item> POSSESSED_EGG = ITEMS.register("possessed_spawn_egg", () -> new ForgeSpawnEggItem(EntityMod.POSSESSED_ENTITY, 0xff0000, 0x00ff00, ITEM_PROPERTIES));

    // TOOLS

    //public static final ArmorItem GEL_HELMET = (ArmorItem) new ArmorItem(ArmorStatistics.GEL, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)).setRegistryName(BaseMod.MODID, "gel_helmet");
}
