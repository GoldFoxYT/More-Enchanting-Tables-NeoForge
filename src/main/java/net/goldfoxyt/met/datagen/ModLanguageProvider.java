package net.goldfoxyt.met.datagen;

import net.goldfoxyt.met.Met;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static net.goldfoxyt.met.block.ModBlocks.*;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, Met.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        addBlock(WHITE_ENCHANTING_TABLE, "White Enchanting Table");
        addBlock(ORANGE_ENCHANTING_TABLE, "Orange Enchanting Table");
        addBlock(MAGENTA_ENCHANTING_TABLE, "Magenta Enchanting Table");
        addBlock(LIGHT_BLUE_ENCHANTING_TABLE, "Light Blue Enchanting Table");
        addBlock(YELLOW_ENCHANTING_TABLE, "Yellow Enchanting Table");
        addBlock(LIME_ENCHANTING_TABLE, "Lime Enchanting Table");
        addBlock(PINK_ENCHANTING_TABLE, "Pink Enchanting Table");
        addBlock(GRAY_ENCHANTING_TABLE, "Gray Enchanting Table");
        addBlock(LIGHT_GRAY_ENCHANTING_TABLE, "Light Gray Enchanting Table");
        addBlock(CYAN_ENCHANTING_TABLE, "Cyan Enchanting Table");
        addBlock(PURPLE_ENCHANTING_TABLE, "Purple Enchanting Table");
        addBlock(BLUE_ENCHANTING_TABLE, "Blue Enchanting Table");
        addBlock(BROWN_ENCHANTING_TABLE, "Brown Enchanting Table");
        addBlock(GREEN_ENCHANTING_TABLE, "Green Enchanting Table");
        addBlock(BLACK_ENCHANTING_TABLE, "Black Enchanting Table");
    }
    public void addCreativeModeTab(ResourceLocation key, String name) {
        add("creativetab." + key.getPath(), name);
    }
}
