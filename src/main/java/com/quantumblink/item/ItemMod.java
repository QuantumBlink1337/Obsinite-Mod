package com.quantumblink.item;

import com.quantumblink.BaseMod;
import com.quantumblink.entity.EntityMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.ForgeTier;
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
    public static final RegistryObject<Item> OBSINITE = ITEMS.register("obsinite_ingot", () -> new Item(ITEM_PROPERTIES.fireResistant()));
    public static final RegistryObject<Item> CRYSTALLINE_MIX = ITEMS.register("crystalline_mix", () -> new Item(ITEM_PROPERTIES));


    public static final Tier TIER = new ForgeTier(5, 2350, 11.2F, 4.2F, 16,
            BlockTags.create(new ResourceLocation("needs_obsinite_tool")), ()-> Ingredient.of(OBSINITE.get()));

    //FOODS
    public static final RegistryObject<Item> POSSESSED_EGG = ITEMS.register("possessed_spawn_egg", () -> new ForgeSpawnEggItem(EntityMod.POSSESSED_ENTITY, 0xff0000, 0x00ff00, ITEM_PROPERTIES));

    // TOOLS
    public static final RegistryObject<Item> OBSINITE_HELMET = TOOLS.register("obsinite_helmet", () -> new ArmorItem(ArmorStatistics.OBSINITE, EquipmentSlot.HEAD, ITEM_PROPERTIES.fireResistant()));
    public static final RegistryObject<Item> OBSINITE_CHEST = TOOLS.register("obsinite_chest", () -> ObsiniteChest.INSTANCE);
    public static final RegistryObject<Item> OBSINITE_LEGGINGS = TOOLS.register("obsinite_leggings", () -> new ArmorItem(ArmorStatistics.OBSINITE, EquipmentSlot.LEGS, ITEM_PROPERTIES.fireResistant()));
    public static final RegistryObject<Item> OBSINITE_BOOTS = TOOLS.register("obsinite_boots", () -> new ArmorItem(ArmorStatistics.OBSINITE, EquipmentSlot.FEET, ITEM_PROPERTIES.fireResistant()));

    public static final RegistryObject<Item> OBSINITE_SWORD = TOOLS.register("obsinite_sword", () -> new SwordItem(TIER, 4, -1.5f, ITEM_PROPERTIES.fireResistant()));
    public static final RegistryObject<Item> OBSINITE_PICKAXE = TOOLS.register("obsinite_pickaxe", () -> new PickaxeItem(TIER, (int) 1.5F, -3.0f, ITEM_PROPERTIES.fireResistant()));
    public static final RegistryObject<Item> OBSINITE_SHOVEL = TOOLS.register("obsinite_shovel", () -> new ShovelItem(TIER, 1, -2.8f, ITEM_PROPERTIES.fireResistant()));
    public static final RegistryObject<Item> OBSINITE_AXE = TOOLS.register("obsinite_axe", () -> new AxeItem(TIER, 5, -3.0f, ITEM_PROPERTIES.fireResistant()));
    public static final RegistryObject<Item> OBSINITE_HOE = TOOLS.register("obsinite_hoe", () -> new HoeItem(TIER, -4, 0f, ITEM_PROPERTIES.fireResistant()));

}
