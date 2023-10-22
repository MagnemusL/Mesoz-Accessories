package com.mesozaccessories.smazeee.objects.blocks;

import com.mesozaccessories.smazeee.MesozAccessories;
import com.mesozaccessories.smazeee.init.BlockInit;
import com.mesozaccessories.smazeee.init.ItemInit;
import com.mesozaccessories.smazeee.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Objects;

public class ModularFence1Bottom extends Block {

    public static final AxisAlignedBB MF1B = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    //Facing(kinda) more to do with facing of bounding boxes
    //public static final AxisAlignedBB MF1B_WE = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);

    //Facing
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL); {
        this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    public ModularFence1Bottom(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(MesozAccessories.MZATAB);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    //Facing
    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing facing = EnumFacing.getFront(meta);

        if(facing.getAxis()==EnumFacing.Axis.Y)
        {
            facing=EnumFacing.NORTH;
        }
        return getDefaultState().withProperty(FACING, facing);
    }

    //Facing
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing) state.getValue(FACING)).getIndex();
    }

    //Facing
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }

    //Facing
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos,EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    /*private boolean canBlockStay(World worldIn, BlockPos pos){
        return worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos, EnumFacing.UP);
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos){
        return super.canPlaceBlockAt(worldIn, pos) ? this.canBlockStay(worldIn, pos) : false;
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos){
        if(!this.canBlockStay(worldIn, pos)) {
            worldIn.setBlockToAir(pos);
            InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.MF1B));
        }
    }
     */

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return MF1B;
    }

    //Facing(kinda) more to do with facing of bounding boxes
    /*@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch(((EnumFacing)state.getValue(FACING))) {
            case SOUTH:
            default:
                return MF1B;
            case NORTH:
                return MF1B;
            case EAST:
                return MF1B_WE;
            case WEST:
                return MF1B_WE;
        }
    }
     */
}
