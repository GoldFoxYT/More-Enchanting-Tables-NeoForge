package net.goldfoxyt.met.block;

import net.goldfoxyt.met.Met;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(BuiltInRegistries.BLOCK, Met.MOD_ID);
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(BuiltInRegistries.ITEM, Met.MOD_ID);

    public static final DeferredHolder<Block, ColoredEnchantingTable> WHITE_ENCHANTING_TABLE = registerBlock("white_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.WHITE).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, ColoredEnchantingTable> ORANGE_ENCHANTING_TABLE = registerBlock("orange_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.ORANGE).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, ColoredEnchantingTable> MAGENTA_ENCHANTING_TABLE = registerBlock("magenta_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.MAGENTA).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, ColoredEnchantingTable> LIGHT_BLUE_ENCHANTING_TABLE = registerBlock("light_blue_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.LIGHT_BLUE).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, ColoredEnchantingTable> YELLOW_ENCHANTING_TABLE = registerBlock("yellow_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.YELLOW).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, ColoredEnchantingTable> LIME_ENCHANTING_TABLE = registerBlock("lime_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.LIME).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, ColoredEnchantingTable> PINK_ENCHANTING_TABLE = registerBlock("pink_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.PINK).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, ColoredEnchantingTable> GRAY_ENCHANTING_TABLE = registerBlock("gray_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.GRAY).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, ColoredEnchantingTable> LIGHT_GRAY_ENCHANTING_TABLE = registerBlock("light_gray_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.LIGHT_GRAY).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, ColoredEnchantingTable> CYAN_ENCHANTING_TABLE = registerBlock("cyan_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.CYAN).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, ColoredEnchantingTable> PURPLE_ENCHANTING_TABLE = registerBlock("purple_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.PURPLE).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, ColoredEnchantingTable> BLUE_ENCHANTING_TABLE = registerBlock("blue_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.BLUE).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, ColoredEnchantingTable> BROWN_ENCHANTING_TABLE = registerBlock("brown_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.BROWN).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, ColoredEnchantingTable> GREEN_ENCHANTING_TABLE = registerBlock("green_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.GREEN).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, ColoredEnchantingTable> BLACK_ENCHANTING_TABLE = registerBlock("black_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.BLACK).requiresCorrectToolForDrops()));

    private static <T extends Block> DeferredHolder<Block,T> registerBlock(String name, Supplier<T> block) {
        DeferredHolder<Block, T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredHolder<Block, T> block) {
        ModBlocks.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void registerBlocks(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    public static void registerItems(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}