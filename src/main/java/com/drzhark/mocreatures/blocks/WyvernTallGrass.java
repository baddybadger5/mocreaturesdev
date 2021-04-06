package com.drzhark.mocreatures.blocks;





import java.util.Random;


import com.drzhark.mocreatures.util.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IForgeShearable;


public class WyvernTallGrass extends BushBlock implements IForgeShearable, IGrowable {


   protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    public WyvernTallGrass() {
        super(Properties.create(Material.TALL_PLANTS)
                .sound(SoundType.PLANT)
                .setLightLevel((f) -> { return 11; })
                .notSolid()
                .doesNotBlockMovement()
                .zeroHardnessAndResistance()
                .harvestLevel(0));

    }

    @Override
   protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.isIn(RegistryHandler.WYVERN_GRASS) || state.isIn(RegistryHandler.WYVERN_DIRT) || state.isIn(RegistryHandler.OGRE_GRASS) || state.isIn(RegistryHandler.OGRE_DIRT);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
       return SHAPE;
   }

    @Override
    public boolean canGrow(IBlockReader iBlockReader, BlockPos blockPos, BlockState blockState, boolean b) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World world, Random random, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void grow(ServerWorld serverWorld, Random random, BlockPos blockPos, BlockState blockState) {

    }

    public AbstractBlock.OffsetType getOffsetType() {
        return AbstractBlock.OffsetType.XYZ;
    }

}
