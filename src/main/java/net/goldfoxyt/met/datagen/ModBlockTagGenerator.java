package net.goldfoxyt.met.datagen;

import net.goldfoxyt.met.Met;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.goldfoxyt.met.block.ModBlocks.*;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Met.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(WHITE_ENCHANTING_TABLE.get(),
                        ORANGE_ENCHANTING_TABLE.get(),
                        MAGENTA_ENCHANTING_TABLE.get(),
                        LIGHT_BLUE_ENCHANTING_TABLE.get(),
                        YELLOW_ENCHANTING_TABLE.get(),
                        LIME_ENCHANTING_TABLE.get(),
                        PINK_ENCHANTING_TABLE.get(),
                        GRAY_ENCHANTING_TABLE.get(),
                        LIGHT_GRAY_ENCHANTING_TABLE.get(),
                        CYAN_ENCHANTING_TABLE.get(),
                        PURPLE_ENCHANTING_TABLE.get(),
                        BLUE_ENCHANTING_TABLE.get(),
                        BROWN_ENCHANTING_TABLE.get(),
                        GREEN_ENCHANTING_TABLE.get(),
                        BLACK_ENCHANTING_TABLE.get());


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(WHITE_ENCHANTING_TABLE.get(),
                        ORANGE_ENCHANTING_TABLE.get(),
                        MAGENTA_ENCHANTING_TABLE.get(),
                        LIGHT_BLUE_ENCHANTING_TABLE.get(),
                        YELLOW_ENCHANTING_TABLE.get(),
                        LIME_ENCHANTING_TABLE.get(),
                        PINK_ENCHANTING_TABLE.get(),
                        GRAY_ENCHANTING_TABLE.get(),
                        LIGHT_GRAY_ENCHANTING_TABLE.get(),
                        CYAN_ENCHANTING_TABLE.get(),
                        PURPLE_ENCHANTING_TABLE.get(),
                        BLUE_ENCHANTING_TABLE.get(),
                        BROWN_ENCHANTING_TABLE.get(),
                        GREEN_ENCHANTING_TABLE.get(),
                        BLACK_ENCHANTING_TABLE.get());


    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}