package com.timthebrick.tinystorage.block;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.timthebrick.tinystorage.reference.RenderIDs;
import com.timthebrick.tinystorage.tileentity.implementations.TileEntityWoolChestLarge;

public class BlockWoolChestLarge extends BlockWoolChest {
	
	public BlockWoolChestLarge(boolean isLockable) {
		super(Material.cloth, isLockable);
		if (!this.isLockable) {
			this.setBlockName("blockWoolChestLarge");
		} else {
			this.setBlockName("blockWoolChestLargeLocked");
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityWoolChestLarge();
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		setBlockBoundsBasedOnState(world, x, y, z);
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		setBlockBoundsBasedOnState(world, x, y, z);
		return super.getSelectedBoundingBoxFromPool(world, x, y, z);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		updateChestBounds(world.getBlockMetadata(x, y, z));
	}

	public void updateChestBounds(int meta) {
		setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
	}

	@Override
	public int getRenderType() {
		return RenderIDs.woolChestLarge;
	}
}
