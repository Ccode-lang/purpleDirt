package com.example.purpledirt.blocks.blockentity;

import com.example.purpledirt.PurpleDirtMod;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import static com.example.purpledirt.PurpleDirtMod.PURPLE_DIRT_ENTITY;


public class PurpleDirtEntity extends BlockEntity{
    public PurpleDirtEntity(BlockPos pPos, BlockState pBlockState) {
        super(PURPLE_DIRT_ENTITY.get(), pPos, pBlockState);
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {
        if (!level.getBlockState(blockPos.above()).is(Blocks.AIR)) {
            level.setBlock(blockPos, PurpleDirtMod.PURPLE_DIRT_NOGRASS_BLOCK.get().defaultBlockState(), 1);
        }
    }
}
