package com.quantumblink;

import com.quantumblink.block.*;
import com.quantumblink.blockentity.BlockEntityMod;
import com.quantumblink.client.PowergenScreen;
import com.quantumblink.config.Config;
import com.quantumblink.enchantment.EnchantmentMod;
import com.quantumblink.entity.*;
import com.quantumblink.item.*;

//import com.idtech.world.WorldMod;
import com.quantumblink.worldgen.Ores;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

/**
 * The BaseMod class holds any static variables your mod needs and runs all registry events. You'll add registry lines
 * in this file for all of your block, item, entities, etc. that you add to Minecraft
 */
@Mod(BaseMod.MODID)
//@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class BaseMod {

    public static final String MODID = "obsiniteexpansion";
    private static final Logger LOGGER = LogManager.getLogger(BaseMod.MODID);
    public static final CreativeModeTab CREATIVE_MODE_TAB = new CreativeModeTab("obsiniteexpansion") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ItemMod.CINNABAR.get());
        }
    };

    public BaseMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        IEventBus MODbus = FMLJavaModLoadingContext.get().getModEventBus();
        Config.register();
        ModEvents.setup();
        BlockMod.BLOCKS.register(MODbus);
        ItemMod.ITEMS.register(MODbus);
        ItemMod.FOODS.register(MODbus);
        ItemMod.TOOLS.register(MODbus);
        EntityMod.ENTITIES.register(MODbus);
        BlockEntityMod.BLOCK_ENTITIES.register(MODbus);
        BlockEntityMod.CONTAINERS.register(MODbus);
        EnchantmentMod.ENCHANTMENTS.register(MODbus);
        //ItemMod.EFFECTS.register(MODbus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Setup step after all other registry events - if you need to do anything after everything else has loaded, put it here.
     *
     * @param event event info
     */
    public void setup(FMLCommonSetupEvent event) {
        // Do any mod setup steps here. Occurs after all registry events.
        // Put biome manager registry stuff here.
        BaseMod.LOGGER.info("Mod Setup Step");
//        WorldMod.setupBiomes();
        // TierSortingRegistry.registerTier(ItemMod.GEL_TIER, new ResourceLocation(MODID, "gelore"), List.of(Tiers.NETHERITE), List.of());

        BaseMod.LOGGER.info("Command registration here hopefully.");
//        MinecraftForge.EVENT_BUS.register(CustomEvent.class);
//        MinecraftForge.EVENT_BUS.addListener(EventMod::isHoldingEvent);
        //Adds the RegisterCommandEvent as an event and sets a listener for it during FMLCommonSetup
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo(MODID, "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.messageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)


    @Mod.EventBusSubscriber(modid = BaseMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents {
        @SubscribeEvent
        public static void onAttributeCreate(EntityAttributeCreationEvent event) {
            event.put(EntityMod.POSSESSED_ENTITY.get(), PossessedEntity.createMonsterAttributes().build());
        }

        public static void setup() {
            IEventBus bus = MinecraftForge.EVENT_BUS;
            bus.addListener(Ores::onBiomeLoadingEvent);
        }
        @SubscribeEvent
        public static void init(FMLCommonSetupEvent event) {
            event.enqueueWork(Ores::registerConfiguredFeatures);
        }
    }

    @Mod.EventBusSubscriber(modid = BaseMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientSetup {
        @SubscribeEvent
        public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(EntityMod.POSSESSED_ENTITY.get(), PossessedRenderer::new);
        }
        @SubscribeEvent
        public static void init(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                MenuScreens.register(BlockEntityMod.POWERGEN_CONTAINER.get(), PowergenScreen::new);           // Attach our container to the screen
                ItemBlockRenderTypes.setRenderLayer(BlockEntityMod.POWERGEN.get(), RenderType.translucent()); // Set the render type for our power generator to translucent
            });
        }
    }
}


