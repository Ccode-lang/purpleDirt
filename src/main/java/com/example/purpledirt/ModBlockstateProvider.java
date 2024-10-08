package com.example.purpledirt;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockstateProvider extends BlockStateProvider {
    public ModBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PurpleDirtMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        //purple dirt grass
        Block block = PurpleDirtMod.PURPLE_DIRT_BLOCK.value();
        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(block);
        String path = blockKey.getPath();

        ModelFile model = models().cube(
                BuiltInRegistries.BLOCK.getKey(block).getPath(),
                modLoc("block/purple_dirt_bottom"),
                modLoc("block/purple_dirt_top"),
                modLoc("block/purple_dirt_side"),
                modLoc("block/purple_dirt_side"),
                modLoc("block/purple_dirt_side"),
                modLoc("block/purple_dirt_side")
        ).texture(
                "particle",
                modLoc("block/purple_dirt_side").getPath()
        );


        simpleBlock(block, model);
        simpleBlockItem(block, model);

        //purple dirt no grass
        Block block1 = PurpleDirtMod.PURPLE_DIRT_NOGRASS_BLOCK.value();
        ResourceLocation blockKey1 = BuiltInRegistries.BLOCK.getKey(block1);
        String path1 = blockKey1.getPath();

        ModelFile model1 = models().cubeAll(path1, modLoc("block/purple_dirt_bottom")).texture("particle", modLoc("block/purple_dirt_bottom"));

        simpleBlock(block1, model1);
        simpleBlockItem(block1, model1);
    }
}
