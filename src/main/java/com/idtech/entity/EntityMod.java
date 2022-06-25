package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityMod {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            BaseMod.MODID);
    public static final RegistryObject<EntityType<PossessedEntity>> POSSESSED_ENTITY =
            ENTITIES.register("possessed", () -> EntityType.Builder.of(PossessedEntity::new, MobCategory.MONSTER)
                    .build(new ResourceLocation(BaseMod.MODID, "possessed").toString()));
    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event){
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    @SubscribeEvent
    public static void registerEntityEggs(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(PossessedEntity.EGG);
    }
    @SubscribeEvent
    public static void entityRenderers(final EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(PossessedEntity.TYPE, PossessedRenderer::new);
    }
    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(PossessedEntity.TYPE, PossessedEntity.createAttributes().build());
    }

}
