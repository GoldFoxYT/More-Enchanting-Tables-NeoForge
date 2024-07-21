package net.goldfoxyt.met;

import net.goldfoxyt.met.block.ModBlocks;
import net.goldfoxyt.met.block.blockentity.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Met.MOD_ID)
public class Met {
    public static final String MOD_ID = "met";

    public Met(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModBlocks.registerBlocks(modEventBus);
        ModBlocks.registerItems(modEventBus);
        ModBlockEntities.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.WHITE_ENCHANTING_TABLE.get());
            event.accept(ModBlocks.ORANGE_ENCHANTING_TABLE.get());
            event.accept(ModBlocks.MAGENTA_ENCHANTING_TABLE.get());
            event.accept(ModBlocks.LIGHT_BLUE_ENCHANTING_TABLE.get());
            event.accept(ModBlocks.YELLOW_ENCHANTING_TABLE.get());
            event.accept(ModBlocks.LIME_ENCHANTING_TABLE.get());
            event.accept(ModBlocks.PINK_ENCHANTING_TABLE.get());
            event.accept(ModBlocks.GRAY_ENCHANTING_TABLE.get());
            event.accept(ModBlocks.LIGHT_GRAY_ENCHANTING_TABLE.get());
            event.accept(ModBlocks.CYAN_ENCHANTING_TABLE.get());
            event.accept(ModBlocks.PURPLE_ENCHANTING_TABLE.get());
            event.accept(ModBlocks.BLUE_ENCHANTING_TABLE.get());
            event.accept(ModBlocks.BROWN_ENCHANTING_TABLE.get());
            event.accept(ModBlocks.GREEN_ENCHANTING_TABLE.get());
            event.accept(ModBlocks.BLACK_ENCHANTING_TABLE.get());
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus =EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> BlockEntityRenderers.register(ModBlockEntities.COLORED_ENCHANTING_TABLE.get(), ColoredEnchantingTableRenderer::new));
        }
        public void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.COLORED_ENCHANTING_TABLE.get(), ColoredEnchantingTableRenderer::new);
        }
    }
}