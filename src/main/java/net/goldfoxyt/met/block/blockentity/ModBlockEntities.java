package net.goldfoxyt.met.block.blockentity;

import net.goldfoxyt.met.Met;
import net.goldfoxyt.met.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Met.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ColoredEnchantingTableBlockEntity>> COLORED_ENCHANTING_TABLE = BLOCK_ENTITIES.register("colored_enchanting_table",
            () -> BlockEntityType.Builder.of(ColoredEnchantingTableBlockEntity::new,
                            ModBlocks.WHITE_ENCHANTING_TABLE.get(),
                            ModBlocks.ORANGE_ENCHANTING_TABLE.get(),
                            ModBlocks.MAGENTA_ENCHANTING_TABLE.get(),
                            ModBlocks.LIGHT_BLUE_ENCHANTING_TABLE.get(),
                            ModBlocks.YELLOW_ENCHANTING_TABLE.get(),
                            ModBlocks.LIME_ENCHANTING_TABLE.get(),
                            ModBlocks.PINK_ENCHANTING_TABLE.get(),
                            ModBlocks.GRAY_ENCHANTING_TABLE.get(),
                            ModBlocks.LIGHT_GRAY_ENCHANTING_TABLE.get(),
                            ModBlocks.CYAN_ENCHANTING_TABLE.get(),
                            ModBlocks.PURPLE_ENCHANTING_TABLE.get(),
                            ModBlocks.BLUE_ENCHANTING_TABLE.get(),
                            ModBlocks.BROWN_ENCHANTING_TABLE.get(),
                            ModBlocks.GREEN_ENCHANTING_TABLE.get(),
                            ModBlocks.BLACK_ENCHANTING_TABLE.get())
                    .build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}