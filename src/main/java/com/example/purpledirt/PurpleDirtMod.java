package com.example.purpledirt;

import com.example.purpledirt.biome.ModTerrablender;
import com.example.purpledirt.biome.surface.ModSurfaceRules;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import terrablender.api.SurfaceRuleManager;


@Mod(PurpleDirtMod.MODID)
public class PurpleDirtMod
{
    public static final String MODID = "purpledirt";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    public static final DeferredBlock<Block> PURPLE_DIRT_BLOCK = BLOCKS.register(
            "purple_dirt",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))
    );

    public static final DeferredBlock<Block> PURPLE_DIRT_NOGRASS_BLOCK = BLOCKS.register(
            "purple_dirt_nograss",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))
    );

    public static final DeferredItem<BlockItem> PURPLE_DIRT_ITEM = ITEMS.registerSimpleBlockItem("purple_dirt", PURPLE_DIRT_BLOCK);

    public static final DeferredItem<BlockItem> PURPLE_DIRT_NOGRASS_ITEM = ITEMS.registerSimpleBlockItem("purple_dirt_nograss", PURPLE_DIRT_NOGRASS_BLOCK);



    public PurpleDirtMod(IEventBus modEventBus, ModContainer modContainer)
    {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        ModTerrablender.registerBiomes();


        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, ModSurfaceRules.makeRules());
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(PURPLE_DIRT_ITEM);
            event.accept(PURPLE_DIRT_NOGRASS_ITEM);
        }
    }
}
