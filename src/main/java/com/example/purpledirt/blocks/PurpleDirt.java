package com.example.purpledirt.blocks;

import com.example.purpledirt.PurpleDirtMod;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class PurpleDirt extends Block {
    public PurpleDirt(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextIntBetweenInclusive(0, 100) > 75 && !pLevel.getBlockState(pPos.above()).is(Blocks.AIR)) {
            pLevel.setBlock(pPos, PurpleDirtMod.PURPLE_DIRT_NOGRASS_BLOCK.get().defaultBlockState(), 1);
        }
    }
}
