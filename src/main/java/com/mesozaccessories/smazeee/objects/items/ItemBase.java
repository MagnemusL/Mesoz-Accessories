package com.mesozaccessories.smazeee.objects.items;

import com.mesozaccessories.smazeee.MesozAccessories;
import com.mesozaccessories.smazeee.init.ItemInit;
import com.mesozaccessories.smazeee.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(MesozAccessories.MZATAB);

        ItemInit.ITEMS.add(this);
    }
    @Override
    public void registerModels() {
        MesozAccessories.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
