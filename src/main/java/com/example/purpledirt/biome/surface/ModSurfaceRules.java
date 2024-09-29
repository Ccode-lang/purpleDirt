package com.example.purpledirt.biome.surface;

import com.example.purpledirt.PurpleDirtMod;
import com.example.purpledirt.biome.ModBiomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.neoforged.fml.common.Mod;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource PURPLE_DIRT = SurfaceRules.state(PurpleDirtMod.PURPLE_DIRT_BLOCK.get().defaultBlockState());
    private static final SurfaceRules.RuleSource DIRT = SurfaceRules.state(Blocks.DIRT.defaultBlockState());
    private static final SurfaceRules.RuleSource GRASS = SurfaceRules.state(Blocks.GRASS_BLOCK.defaultBlockState());


    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS), DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.PURPLE_DIRT_BIOME), PURPLE_DIRT),

                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        );
    }
}
