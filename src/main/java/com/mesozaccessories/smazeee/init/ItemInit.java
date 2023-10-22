package com.mesozaccessories.smazeee.init;

import com.mesozaccessories.smazeee.objects.items.ItemBase;
import com.mesozaccessories.smazeee.objects.items.custom.GameModeSwitcher;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item STEEL_WIRE = new ItemBase("steel_wire");
    public static final ItemBlock MF1B = new ItemBlock(BlockInit.MF1B);

    public static final Item GAMEMODE_SWITCHER  = new GameModeSwitcher("gamemode_switcher");
}
