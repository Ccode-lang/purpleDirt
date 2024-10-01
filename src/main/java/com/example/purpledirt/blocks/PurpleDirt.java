package com.example.purpledirt.blocks;

import com.example.purpledirt.PurpleDirtMod;
import com.example.purpledirt.blocks.blockentity.PurpleDirtEntity;
import com.example.purpledirt.blocks.blockentity.PurpleDirtNoGrassEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import static com.example.purpledirt.PurpleDirtMod.PURPLE_DIRT_ENTITY;
import static com.example.purpledirt.PurpleDirtMod.PURPLE_DIRT_NOGRASS_ENTITY;

public class PurpleDirt extends Block implements EntityBlock {
    public PurpleDirt(Properties properties) {
        super(properties);
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new PurpleDirtEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return type == PURPLE_DIRT_ENTITY.get() ? PurpleDirtEntity::tick : null;
    }
}
