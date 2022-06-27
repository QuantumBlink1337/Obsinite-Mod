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
    public static final RegistryObject<Item> STRUCTURE_GEL = ITEMS.register("structure_gel", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> GEL_ORE = ITEMS.register("gel_ore", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    //FOODS
    private static final Supplier<MobEffectInstance> DOOMGUM_MOB_EFFECT = () -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 500, 1);
    private static final FoodProperties DOOMGUM_PROPERTIES = new FoodProperties.Builder().saturationMod(10).nutrition(10).effect(DOOMGUM_MOB_EFFECT, .5f).build();
    public static final RegistryObject<Item> DOOMGUM = FOODS.register("doomgum", () -> new Item(ITEM_PROPERTIES.food(DOOMGUM_PROPERTIES)));
    public static final RegistryObject<Item> EXPLODING_FOOD = FOODS.register("exploding_food", () -> ExplodingFood.INSTANCE);
    public static final RegistryObject<Item> POSSESSED_EGG = ITEMS.register("possessed_spawn_egg", () -> new ForgeSpawnEggItem(EntityMod.POSSESSED_ENTITY, 0xff0000, 0x00ff00, ITEM_PROPERTIES));

    public static final RegistryObject<Item> LIGHTNING_HAMMER = TOOLS.register("lightning_hammer", () -> LightningHammerItem.INSTANCE);
    public static final RegistryObject<Item> GEL_PICKAXE = TOOLS.register("gel_pickaxe", () -> GelPickaxeItem.INSTANCE);

    public static final RegistryObject<Item> TELEPORT_ROD = ITEMS.register("teleport_rod", () -> TeleportRodItem.INSTANCE);

    //public static final ArmorItem GEL_HELMET = (ArmorItem) new ArmorItem(ArmorStatistics.GEL, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)).setRegistryName(BaseMod.MODID, "gel_helmet");

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        //BASIC ITEMS
        //event.getRegistry().register(STRUCTURE_GEL);
        //event.getRegistry().register(GEL_ORE);
//        event.getRegistry().register(TeleportRodItem.INSTANCE);
//        // ITEMS
//        // TOOLS
//        event.getRegistry().register(GelPickaxeItem.INSTANCE);
//        event.getRegistry().register(LightningHammerItem.INSTANCE);
        // FOOD
        //event.getRegistry().register(FoodItemTest.INSTANCE);
        // ARMOR
        //PROJECTILES

    }
}
