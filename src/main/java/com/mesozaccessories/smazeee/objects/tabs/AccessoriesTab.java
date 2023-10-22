package com.mesozaccessories.smazeee.objects.tabs;

import com.mesozaccessories.smazeee.init.BlockInit;
import com.mesozaccessories.smazeee.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class AccessoriesTab extends CreativeTabs {
    public AccessoriesTab(String label) {
        super("mzatab");
        this.setBackgroundImageName("mesoz_accessories.png");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(BlockInit.STEEL_BLOCK);
    }
}
