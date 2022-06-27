package com.quantumblink.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class PossessedEntity extends Zombie {
//    public static EntityType<PossessedEntity> TYPE = (EntityType<PossessedEntity>) EntityType.Builder.of(PossessedEntity::new, MobCategory.MONSTER)
//            .build("possessed").setRegistryName(BaseMod.MODID, "possessed");
    //public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xb00101, 0xacbf1f);
    public PossessedEntity(EntityType<? extends Zombie> p_34271_, Level p_34272_) {
        super(p_34271_, p_34272_);
    }
    public static AttributeSupplier.@NotNull Builder createMonsterAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.ATTACK_DAMAGE, 3.0)
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.FOLLOW_RANGE, 40.0)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_KNOCKBACK, 4)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 20f);
    }
    @Override
    protected boolean isSunSensitive() {
        return false;
    }

}
