package com.timthebrick.tinystorage.item.block;

import java.util.List;

import com.timthebrick.tinystorage.reference.Messages;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.timthebrick.tinystorage.block.BlockTinyChest;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockPeacefulChest extends ItemBlock {

	public ItemBlockPeacefulChest(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta) {
		return meta;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean flag) {
		int metaData = itemStack.getItemDamage();
		if (metaData == 0) {
			list.add(StatCollector.translateToLocal(Messages.ItemTooltips.BLOCK_SMALL));
		} else if (metaData == 1) {
			list.add(StatCollector.translateToLocal(Messages.ItemTooltips.BLOCK_MEDIUM));
		} else if (metaData == 2) {
			list.add(StatCollector.translateToLocal(Messages.ItemTooltips.BLOCK_LARGE));
		}
		list.add(StatCollector.translateToLocal(Messages.ItemTooltips.PEACEFUL_CHEST_DESC_1));
		list.add(StatCollector.translateToLocal(Messages.ItemTooltips.PEACEFUL_CHEST_DESC_2));
	}

}
