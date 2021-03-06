package com.quantumblink.config;

import com.quantumblink.blockentity.PowergenConfig;
import com.quantumblink.worldgen.OresConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class Config {

    public static void register() {
        registerServerConfigs();
        registerCommonConfigs();
        registerClientConfigs();
    }

    private static void registerClientConfigs() {
          ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
         PowergenConfig.registerClientConfig(CLIENT_BUILDER);
//        ManaConfig.registerClientConfig(CLIENT_BUILDER);
          ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_BUILDER.build());
    }

    private static void registerCommonConfigs() {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        OresConfig.registerCommonConfig(COMMON_BUILDER);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_BUILDER.build());

    }

    private static void registerServerConfigs() {
          ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
//        GeneratorConfig.registerServerConfig(SERVER_BUILDER);
          PowergenConfig.registerServerConfig(SERVER_BUILDER);
//        ManaConfig.registerServerConfig(SERVER_BUILDER);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_BUILDER.build());
    }

}
