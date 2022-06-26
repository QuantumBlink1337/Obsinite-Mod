package com.quantumblink.entity;

import com.quantumblink.BaseMod;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;
import org.jetbrains.annotations.NotNull;

public class PossessedRenderer extends ZombieRenderer {
    private static final ResourceLocation TEXTURE = new ResourceLocation(BaseMod.MODID, "textures/entity/possessed.png");
    public PossessedRenderer(EntityRendererProvider.Context p_174456_) {
        super(p_174456_);
    }
    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Zombie p_113771_) {
        return TEXTURE;
    }
}
