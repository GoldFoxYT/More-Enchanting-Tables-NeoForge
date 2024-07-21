package net.goldfoxyt.met.block;

import net.goldfoxyt.met.Met;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Met.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Met.MOD_ID);

    public static final DeferredBlock<ColoredEnchantingTable> WHITE_ENCHANTING_TABLE = BLOCKS.register("white_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.WHITE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ColoredEnchantingTable> ORANGE_ENCHANTING_TABLE = BLOCKS.register("orange_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.ORANGE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ColoredEnchantingTable> MAGENTA_ENCHANTING_TABLE = BLOCKS.register("magenta_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.MAGENTA).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ColoredEnchantingTable> LIGHT_BLUE_ENCHANTING_TABLE = BLOCKS.register("light_blue_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.LIGHT_BLUE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ColoredEnchantingTable> YELLOW_ENCHANTING_TABLE = BLOCKS.register("yellow_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.YELLOW).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ColoredEnchantingTable> LIME_ENCHANTING_TABLE = BLOCKS.register("lime_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.LIME).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ColoredEnchantingTable> PINK_ENCHANTING_TABLE = BLOCKS.register("pink_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.PINK).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ColoredEnchantingTable> GRAY_ENCHANTING_TABLE = BLOCKS.register("gray_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.GRAY).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ColoredEnchantingTable> LIGHT_GRAY_ENCHANTING_TABLE = BLOCKS.register("light_gray_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.LIGHT_GRAY).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ColoredEnchantingTable> CYAN_ENCHANTING_TABLE = BLOCKS.register("cyan_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.CYAN).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ColoredEnchantingTable> PURPLE_ENCHANTING_TABLE = BLOCKS.register("purple_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.PURPLE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ColoredEnchantingTable> BLUE_ENCHANTING_TABLE = BLOCKS.register("blue_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.BLUE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ColoredEnchantingTable> BROWN_ENCHANTING_TABLE = BLOCKS.register("brown_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.BROWN).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ColoredEnchantingTable> GREEN_ENCHANTING_TABLE = BLOCKS.register("green_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.GREEN).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ColoredEnchantingTable> BLACK_ENCHANTING_TABLE = BLOCKS.register("black_enchanting_table",
            () -> new ColoredEnchantingTable(Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE).mapColor(DyeColor.BLACK).requiresCorrectToolForDrops()));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = registerBlock(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredItem<BlockItem> registerBlockItem(String name, DeferredBlock<T> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void registerBlocks(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    public static void registerItems(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}