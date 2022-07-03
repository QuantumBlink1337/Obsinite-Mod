package com.quantumblink.worldgen;

import com.quantumblink.BaseMod;
import com.quantumblink.block.BlockMod;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import java.util.List;

public class Ores {

    public static final int OVERWORLD_VEINSIZE = 10;
    public static final int OVERWORLD_AMOUNT = 50;

    public static PlacedFeature OVERWORLD_OREGEN_PF;
    public static ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>> OVERWORLD_OREGEN_CF;
    public static void registerConfiguredFeatures() {
        OreConfiguration overworldConfig = new OreConfiguration(new BlockMatchTest(Blocks.CALCITE), BlockMod.CINNABAR_ORE.get().defaultBlockState(),OVERWORLD_VEINSIZE);
        OVERWORLD_OREGEN_CF = Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(BaseMod.MODID, "cinnabar_ore_overworld"), new ConfiguredFeature<>(Feature.ORE, overworldConfig));
        OVERWORLD_OREGEN_PF =  Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(BaseMod.MODID, "cinnabar_ore_overworld"), new PlacedFeature(Holder.direct(OVERWORLD_OREGEN_CF),
                List.of(CountPlacement.of(OVERWORLD_AMOUNT),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(60)))));
    }

    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(OVERWORLD_OREGEN_PF));
    }
}