package com.quantumblink.entity;

import com.quantumblink.BaseMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class PossessedRenderer extends ZombieRenderer {
    public PossessedRenderer(EntityRendererProvider.Context provider) {
        super(provider);
    }
    public ResourceLocation getTextureLocation(@NotNull PossessedEntity entity) {
        return new ResourceLocation(BaseMod.MODID, "textures/entity/possessed.png");
    }
}
