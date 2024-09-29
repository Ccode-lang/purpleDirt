package com.example.purpledirt.biome;

import com.example.purpledirt.PurpleDirtMod;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(ResourceLocation.fromNamespaceAndPath(PurpleDirtMod.MODID, "overworld"), 5));
    }
}
