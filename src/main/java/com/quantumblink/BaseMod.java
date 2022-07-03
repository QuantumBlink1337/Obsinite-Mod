package com.quantumblink;

import com.quantumblink.block.*;
import com.quantumblink.blockentity.BlockEntityMod;
import com.quantumblink.client.PowergenScreen;
import com.quantumblink.config.Config;
import com.quantumblink.entity.*;
import com.quantumblink.item.*;

//import com.idtech.world.WorldMod;
import com.quantumblink.worldgen.Ores;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.Event;
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

    // Change your modid here. Whenever modid is needed, use BaseMod.MODID
    public static final String MODID = "examplemod";
    private static final Logger LOGGER = LogManager.getLogger(BaseMod.MODID);
    public static final CreativeModeTab CREATIVE_MODE_TAB = new CreativeModeTab("Obsinite") {
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
        EventsMod.setup();

        BlockMod.BLOCKS.register(MODbus);

        ItemMod.ITEMS.register(MODbus);
        ItemMod.FOODS.register(MODbus);
        ItemMod.TOOLS.register(MODbus);
        EntityMod.ENTITIES.register(MODbus);
        BlockEntityMod.BLOCK_ENTITIES.register(MODbus);
        BlockEntityMod.CONTAINERS.register(MODbus);


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


    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
//        @SubscribeEvent
//        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
//            // register a new block here
//            LOGGER.info("HELLO from Register Block");
//        }

        /**
         * Registers block during mod setup
         *
         * @param event RegistryEvent to access the block registry
         */
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {


//            event.getRegistry().register(BlockMod.CASTLE_WALL);

        }


        /**
         * Registers item during mod setup
         *
         * @param event RegistryEvent to access the item registry
         */
        //@SubscribeEvent
//        public static void registerItems(final RegistryEvent.Register<Item> event) {
//            LOGGER.info("Registering Items");
//            // Add item registry calls here.
//            // event.getRegistry.register(<item variable>)
//
//            ItemMod.registerItems(event);
//            BlockMod.registerBlockItems(event);
//            EntityMod.registerEntityEggs(event);
//
//        }


        /**
         * Registers entities during mod setup
         *
         * @param event RegistryEvent to access the entity registry
         */
        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
            BaseMod.LOGGER.info("Registering Entities");
            // Add item registry calls here.
            // event.getRegistry.register(<entity type>)
            // also register the entity attributes with:
            // GlobalEntityTypeAttributes.put(<entity type>, <entity attribute method>.func_233813_a_());
//            EntityMod.registerEntities(event);

        }

        @SubscribeEvent
        public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
            BaseMod.LOGGER.info("Registering Biomes");
            // Add biome registry calls here
            // event.getRegistry.register(<biome variable>)
//            WorldMod.registerBiomes(event);

        }

//        @SubscribeEvent
//        public static void entityRenderers(final EntityRenderersEvent.RegisterRenderers event){
//            EntityMod.entityRenderers(event);
//        }
//        @SubscribeEvent
//        public static void attributeRegister(EntityAttributeCreationEvent event) {
//            EntityMod.onAttributeCreate(event);
//        }
//
//        @SubscribeEvent
//        public static void registerEnchantments(final RegistryEvent.Register<Enchantment> event){
//            EnchantmentMod.registerEnchantments(event);
//        }

    }

    @Mod.EventBusSubscriber(modid = BaseMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class EventsMod {
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


