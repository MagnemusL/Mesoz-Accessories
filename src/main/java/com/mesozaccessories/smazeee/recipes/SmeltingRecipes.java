package com.mesozaccessories.smazeee.recipes;

import com.mesozaccessories.smazeee.init.BlockInit;
import com.mesozaccessories.smazeee.init.ItemInit;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingRecipes {
    public static void init() {
        GameRegistry.addSmelting(new ItemStack(Blocks.IRON_BLOCK), new ItemStack(BlockInit.STEEL_BLOCK), 1f);
    }
}
