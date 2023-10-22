package com.mesozaccessories.smazeee.init;

import com.mesozaccessories.smazeee.objects.blocks.BlockBase;
import com.mesozaccessories.smazeee.objects.blocks.custom.MF1B;
import com.mesozaccessories.smazeee.objects.blocks.custom.TestBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block STEEL_SCRAP = new BlockBase("steel_scrap", Material.IRON);

    public static final Block STEEL_BLOCK = new BlockBase("steel_block", Material.IRON);

    public static final Block TEST_BLOCK = new TestBlock("test_block", Material.CACTUS);

    //public static final Block DUPER = new Duper("duper", Material.IRON);

    public static final Block MF1B = new MF1B("mf1b", Material.IRON);
}
