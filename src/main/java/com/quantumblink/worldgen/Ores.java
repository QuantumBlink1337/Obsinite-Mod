package com.quantumblink.worldgen;

import com.quantumblink.block.BlockMod;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;


public class Ores {

    public static final int OVERWORLD_VEINSIZE = 5;
    public static final int OVERWORLD_AMOUNT = 3;
//    public static final int DEEPSLATE_VEINSIZE = 5;
//    public static final int DEEPSLATE_AMOUNT = 3;


    public static Holder<PlacedFeature> OVERWORLD_OREGEN;
    public static Holder<PlacedFeature> DEEPSLATE_OREGEN;

    public static void registerConfiguredFeatures() {
//        OreConfiguration deepslateConfig = new OreConfiguration(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Registration.MYSTERIOUS_ORE_DEEPSLATE.get().defaultBlockState(), OresConfig.DEEPSLATE_VEINSIZE.get());
//        DEEPSLATE_OREGEN = registerPlacedFeature("deepslate_mysterious_ore", new ConfiguredFeature<>(Feature.ORE, deepslateConfig),
//                CountPlacement.of(OresConfig.DEEPSLATE_AMOUNT.get()),
//                InSquarePlacement.spread(),
//                BiomeFilter.biome(),
//                HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64)));

        OreConfiguration overworldConfig = new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, BlockMod.CINNABAR_ORE.get().defaultBlockState(), OresConfig.OVERWORLD_VEINSIZE.get());
        OVERWORLD_OREGEN = registerPlacedFeature("overworld_mysterious_ore", new ConfiguredFeature<>(Feature.ORE, overworldConfig),
                CountPlacement.of(OresConfig.OVERWORLD_AMOUNT.get()),
                InSquarePlacement.spread(),
                //new DimensionBiomeFilter(key -> !Dimensions.MYSTERIOUS.equals(key)),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(90)));
    }

    private static <C extends FeatureConfiguration, F extends Feature<C>> Holder<PlacedFeature> registerPlacedFeature(String registryName, ConfiguredFeature<C, F> feature, PlacementModifier... placementModifiers) {
        return PlacementUtils.register(registryName, Holder.direct(feature), placementModifiers);
    }

    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OVERWORLD_OREGEN);
            //event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DEEPSLATE_OREGEN);
    }
}