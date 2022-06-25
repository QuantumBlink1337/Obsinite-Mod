package com.quantumblink.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.monster.Zombie;
import org.jetbrains.annotations.NotNull;

public class PossessedRendererFactory implements EntityRendererProvider<Zombie> {
    public static PossessedRendererFactory INSTANCE = new PossessedRendererFactory();
    @Override
    public @NotNull EntityRenderer<Zombie> create(@NotNull Context p_174010_) {
        return new PossessedRenderer(p_174010_);
    }
}
