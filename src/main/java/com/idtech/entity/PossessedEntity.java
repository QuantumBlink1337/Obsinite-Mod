package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class PossessedEntity extends Zombie {
    public static EntityType<PossessedEntity> TYPE = (EntityType<PossessedEntity>) EntityType.Builder.of(PossessedEntity::new, MobCategory.MONSTER)
            .build("possessed").setRegistryName(BaseMod.MODID, "possessed");
    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xb00101, 0xacbf1f);
    public PossessedEntity(EntityType<? extends Zombie> p_34271_, Level p_34272_) {
        super(p_34271_, p_34272_);
    }
    public static AttributeSupplier.@NotNull Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.23F).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }
}
