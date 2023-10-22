package com.mesozaccessories.smazeee.objects.blocks.custom;

import com.mesozaccessories.smazeee.MesozAccessories;
import com.mesozaccessories.smazeee.init.BlockInit;
import com.mesozaccessories.smazeee.init.ItemInit;
import com.mesozaccessories.smazeee.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;


public class TestBlock extends Block implements IHasModel {
    public TestBlock(String name, Material material) {
        super(material);

        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(5.0f);
        setResistance(45.0f);
        setLightLevel(25.0f);
        setLightOpacity(10);
        setDefaultSlipperiness(6.0f);
        setHarvestLevel("hoe", 2);
        setSoundType(SoundType.SLIME);
        //setBlockUnbreakable();

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ItemInit.STEEL_WIRE;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return true;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return true;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (hand == EnumHand.MAIN_HAND) {
            playerIn.jump();
        }
        return true;
    }

    public boolean canBlockStay(World worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos, EnumFacing.UP);
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        if(!this.canBlockStay(worldIn, pos)) {
            worldIn.setBlockToAir(fromPos);
            InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.STEEL_WIRE, 5));
        }
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    /*@Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return null;
    }
    */

    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        return true;
    }

    @Override
    public void registerModels() {
        MesozAccessories.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
