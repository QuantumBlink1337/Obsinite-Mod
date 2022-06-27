package com.quantumblink.block;


import com.quantumblink.BaseMod;
import com.quantumblink.item.ItemMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockMod {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BaseMod.MODID);

    public static final RegistryObject<Block> GEL_ORE = BLOCKS.register("gel_ore_block", () -> new Block(Block.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops().strength(4f)));
    public static final RegistryObject<Item> GEL_ORE_ITEM = fromItem(GEL_ORE);
    public static final RegistryObject<Block> LAMP = BLOCKS.register("wooden_lamp", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
            .lightLevel(state -> 15).requiresCorrectToolForDrops().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> LAMP_ITEM = fromItem(LAMP);
    public static final RegistryObject<Block> CREEPER_SURPRISE = BLOCKS.register("creeper_surprise", () -> CreeperSurpriseBlock.INSTANCE);
    public static final RegistryObject<Item> CREEPER_SURPRISE_ITEM = fromItem(CREEPER_SURPRISE);
    public static final RegistryObject<Block> RUBBER = BLOCKS.register("rubber", () -> RubberBlock.Instance);
    public static final RegistryObject<Item> RUBBER_ITEM = fromItem(RUBBER);
    public static final RegistryObject<Block> CREEPING_MOLD = BLOCKS.register("creeping_mold", () -> CreepingMoldBlock.Instance);
    public static final RegistryObject<Item> CREEPING_MOLD_ITEM = fromItem(CREEPING_MOLD);
    public static <B extends Block>RegistryObject<Item> fromItem(RegistryObject<B> block) {
        return ItemMod.ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ItemMod.ITEM_PROPERTIES));
    }
}





