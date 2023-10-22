package com.mesozaccessories.smazeee;

import com.mesozaccessories.smazeee.objects.tabs.AccessoriesTab;
import com.mesozaccessories.smazeee.proxy.CommonProxy;
import com.mesozaccessories.smazeee.recipes.SmeltingRecipes;
import com.mesozaccessories.smazeee.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.ID, version = Reference.VERSION, name = Reference.NAME)
public class MesozAccessories {
    @Instance
    public static MesozAccessories Instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    public static final CreativeTabs MZATAB = new AccessoriesTab("mzatab");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {
        SmeltingRecipes.init();
    }

    @EventHandler
    public void PostInit(FMLPostInitializationEvent event) {

    }

    @EventHandler
    public void ServerInit(FMLServerStartingEvent event) {

    }
}
