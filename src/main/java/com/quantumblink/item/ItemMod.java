package com.quantumblink.item;

import com.quantumblink.BaseMod;
import com.quantumblink.entity.EntityMod;
import com.quantumblink.item.tools.ArmorStatistics;
import com.quantumblink.item.tools.ObsiniteChest;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber
public class ItemMod {
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(BaseMod.CREATIVE_MODE_TAB);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BaseMod.MODID);
    public static final DeferredRegister<Item> TOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, BaseMod.MODID);
    public static final DeferredRegister<Item> FOODS = DeferredRegister.create(ForgeRegistries.ITEMS, BaseMod.MODID);
    //public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BaseMod.MODID);


    //BASIC ITEMS
    public static final RegistryObject<Item> CINNABAR = ITEMS.register("cinnabar", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> CINNABAR_DUST = ITEMS.register("cinnabar_dust", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> MERCURY = ITEMS.register("mercury", () -> MercuryItem.INSTANCE);
    public static final RegistryObject<Item> OBSINITE = ITEMS.register("obsinite_ingot", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> CRYSTALLINE_MIX = ITEMS.register("crystalline_mix", () -> new Item(ITEM_PROPERTIES));

    //FOODS
    public static final RegistryObject<Item> POSSESSED_EGG = ITEMS.register("possessed_spawn_egg", () -> new ForgeSpawnEggItem(EntityMod.POSSESSED_ENTITY, 0xff0000, 0x00ff00, ITEM_PROPERTIES));

    // TOOLS
    public static final RegistryObject<Item> OBSINITE_HELMET = TOOLS.register("obsinite_helmet", () -> new ArmorItem(ArmorStatistics.OBSINITE, EquipmentSlot.HEAD, ITEM_PROPERTIES));
    public static final RegistryObject<Item> OBSINITE_CHEST = TOOLS.register("obsinite_chest", () -> ObsiniteChest.INSTANCE);
    public static final RegistryObject<Item> OBSINITE_LEGGINGS = TOOLS.register("obsinite_leggings", () -> new ArmorItem(ArmorStatistics.OBSINITE, EquipmentSlot.LEGS, ITEM_PROPERTIES));
    public static final RegistryObject<Item> OBSINITE_BOOTS = TOOLS.register("obsinite_boots", () -> new ArmorItem(ArmorStatistics.OBSINITE, EquipmentSlot.FEET, ITEM_PROPERTIES));


    //public static final ArmorItem GEL_HELMET = (ArmorItem) new ArmorItem(ArmorStatistics.GEL, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)).setRegistryName(BaseMod.MODID, "gel_helmet");
}
