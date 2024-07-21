package net.goldfoxyt.met.datagen.loot;

import net.goldfoxyt.met.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static net.goldfoxyt.met.block.ModBlocks.*;

public class ModBlockLootTables extends BlockLootSubProvider{
    private static final Set<Item> EXPLOSION_RESISTANT = new HashSet<>();

    public ModBlockLootTables(HolderLookup.Provider provider) {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        this.add(WHITE_ENCHANTING_TABLE.get(), (block) -> this.createNameableBlockEntityTable(block));
        this.add(ORANGE_ENCHANTING_TABLE.get(), (block) -> this.createNameableBlockEntityTable(block));
        this.add(MAGENTA_ENCHANTING_TABLE.get(), (block) -> this.createNameableBlockEntityTable(block));
        this.add(LIGHT_BLUE_ENCHANTING_TABLE.get(), (block) -> this.createNameableBlockEntityTable(block));
        this.add(YELLOW_ENCHANTING_TABLE.get(), (block) -> this.createNameableBlockEntityTable(block));
        this.add(LIME_ENCHANTING_TABLE.get(), (block) -> this.createNameableBlockEntityTable(block));
        this.add(PINK_ENCHANTING_TABLE.get(), (block) -> this.createNameableBlockEntityTable(block));
        this.add(GRAY_ENCHANTING_TABLE.get(), (block) -> this.createNameableBlockEntityTable(block));
        this.add(LIGHT_GRAY_ENCHANTING_TABLE.get(), (block) -> this.createNameableBlockEntityTable(block));
        this.add(CYAN_ENCHANTING_TABLE.get(), (block) -> this.createNameableBlockEntityTable(block));
        this.add(PURPLE_ENCHANTING_TABLE.get(), (block) -> this.createNameableBlockEntityTable(block));
        this.add(BLUE_ENCHANTING_TABLE.get(), (block) -> this.createNameableBlockEntityTable(block));
        this.add(BROWN_ENCHANTING_TABLE.get(), (block) -> this.createNameableBlockEntityTable(block));
        this.add(GREEN_ENCHANTING_TABLE.get(), (block) -> this.createNameableBlockEntityTable(block));
        this.add(BLACK_ENCHANTING_TABLE.get(), (block) -> this.createNameableBlockEntityTable(block));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream()
                .map(DeferredHolder::get)
                .collect(Collectors.toList());
    }
}