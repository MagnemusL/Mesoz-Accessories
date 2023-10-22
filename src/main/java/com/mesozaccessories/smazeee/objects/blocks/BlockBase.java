package com.mesozaccessories.smazeee.objects.blocks;

import com.mesozaccessories.smazeee.MesozAccessories;
import com.mesozaccessories.smazeee.init.BlockInit;
import com.mesozaccessories.smazeee.init.ItemInit;
import com.mesozaccessories.smazeee.objects.blocks.custom.MF1B;
import com.mesozaccessories.smazeee.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

    public BlockBase(String name, Material material) {
        super(material);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(MesozAccessories.MZATAB);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        MesozAccessories.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
