package com.quantumblink.block;

import com.quantumblink.BaseMod;
import com.quantumblink.item.ItemMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockMod {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BaseMod.MODID);

    public static final RegistryObject<Block> CINNABAR_ORE = BLOCKS.register("cinnabar_ore", () -> new Block(Block.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops().strength(4f)));
    public static final RegistryObject<Item> CINNABAR_ORE_ITEM = blockToBlockItem(CINNABAR_ORE);
    public static final RegistryObject<Block> MERCURIZED_OBSIDIAN = BLOCKS.register("mercurized_obsidian", () -> MercurizedObsidianBlock.INSTANCE);
    public static final RegistryObject<Item> MERCURIZED_OBSIDIAN_ITEM = blockToBlockItem(MERCURIZED_OBSIDIAN);
    public static final RegistryObject<Block> OBSINITE_BLOCK = BLOCKS.register("obsinite_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
            .requiresCorrectToolForDrops().strength(3.5f)));
    public static final RegistryObject<Item> OBSINITE_BLOCK_ITEM = blockToBlockItem(OBSINITE_BLOCK);


    public static <B extends Block>RegistryObject<Item> blockToBlockItem(RegistryObject<B> block) {
        return ItemMod.ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ItemMod.ITEM_PROPERTIES));
    }
}





