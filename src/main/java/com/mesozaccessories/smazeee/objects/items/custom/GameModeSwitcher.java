package com.mesozaccessories.smazeee.objects.items.custom;

import com.mesozaccessories.smazeee.MesozAccessories;
import com.mesozaccessories.smazeee.init.ItemInit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

public class GameModeSwitcher extends Item {
    public boolean IsCreative;
    public boolean HasPermission;

    public GameModeSwitcher(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(MesozAccessories.MZATAB);

        ItemInit.ITEMS.add(this);
    }

    /*@Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (playerIn.isCreative()) {
            IsCreative = true;
            playerIn.setGameType(GameType.SURVIVAL);
        }
        else {
            IsCreative = false;
            playerIn.setGameType(GameType.CREATIVE);
        }
        return null;
    }

     */

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        playerIn.setGameType(GameType.CREATIVE);
        return null;
    }
}
