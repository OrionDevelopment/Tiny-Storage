package com.timthebrick.tinystorage.handler;

import com.timthebrick.tinystorage.client.gui.inventory.implementations.*;
import com.timthebrick.tinystorage.inventory.implementations.*;
import com.timthebrick.tinystorage.tileentity.implementations.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.timthebrick.tinystorage.reference.GUIs;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement (int id, EntityPlayer entityPlayer, World world, int x, int y, int z) {
        if (id == GUIs.TINY_CHEST.ordinal()) {
            TileEntityTinyChest tileEntityTinyChest = (TileEntityTinyChest) world.getTileEntity(x, y, z);
            return new ContainerTinyChest(entityPlayer.inventory, tileEntityTinyChest);
        } else if (id == GUIs.FILTER_CHEST.ordinal()) {
            TileEntityFilterChest tileEntityFilterChest = (TileEntityFilterChest) world.getTileEntity(x, y, z);
            return new ContainerFilterChest(entityPlayer.inventory, tileEntityFilterChest);
        } else if (id == GUIs.DRAW.ordinal()) {
            TileEntityDraw tileEntityDraw = (TileEntityDraw) world.getTileEntity(x, y, z);
            return new ContainerDraw(entityPlayer.inventory, tileEntityDraw);
        } else if (id == GUIs.TRASH_CHEST.ordinal()) {
            TileEntityTrashChest tileEntityTrashChest = (TileEntityTrashChest) world.getTileEntity(x, y, z);
            return new ContainerTrashChest(entityPlayer.inventory, tileEntityTrashChest);
        } else if (id == GUIs.MICRO_CHEST.ordinal()) {
            TileEntityMicroChest tileEntityMicroChest = (TileEntityMicroChest) world.getTileEntity(x, y, z);
            return new ContainerMicroChest(entityPlayer.inventory, tileEntityMicroChest);
        } else if (id == GUIs.WOOL_CHEST.ordinal()) {
            TileEntityWoolChest tileEntityWoolChest = (TileEntityWoolChest) world.getTileEntity(x, y, z);
            return new ContainerWoolChest(entityPlayer.inventory, tileEntityWoolChest);
        } else if (id == GUIs.PEACEFUL_CHEST.ordinal()) {
            TileEntityPeacefulChest tileEntityPeacefulChest = (TileEntityPeacefulChest) world.getTileEntity(x, y, z);
            return new ContainerPeacefulChest(entityPlayer.inventory, tileEntityPeacefulChest);
        } else if (id == GUIs.VACUUM_CHEST.ordinal()) {
            TileEntityVacuumChest tileEntityVacuumChest = (TileEntityVacuumChest) world.getTileEntity(x, y, z);
            return new ContainerVacuumChest(entityPlayer.inventory, tileEntityVacuumChest);
        } else if (id == GUIs.CLAY_CHEST.ordinal()) {
            TileEntityClayChest tileEntityClayChest = (TileEntityClayChest) world.getTileEntity(x, y, z);
            return new ContainerClayChest(entityPlayer.inventory, tileEntityClayChest);
        } else if (id == GUIs.QUARRY_CHEST.ordinal()) {
            TileEntityQuarryChest tileEntityClayChest = (TileEntityQuarryChest) world.getTileEntity(x, y, z);
            return new ContainerQuarryChest(entityPlayer.inventory, tileEntityClayChest);
        } else if (id == GUIs.STORAGE_BAG.ordinal()) {
            return new ContainerStorageBag(entityPlayer, new InventoryStorageBag(entityPlayer.getHeldItem()));
        }else if (id == GUIs.BOOKCASE.ordinal()) {
            TileEntityBookCase tileEntityBookCase = (TileEntityBookCase) world.getTileEntity(x, y, z);
            return new ContainerBookCase(entityPlayer.inventory, tileEntityBookCase);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement (int id, EntityPlayer entityPlayer, World world, int x, int y, int z) {
        if (id == GUIs.TINY_CHEST.ordinal()) {
            TileEntityTinyChest tileEntityTinyChest = (TileEntityTinyChest) world.getTileEntity(x, y, z);
            return new GuiTinyChest(entityPlayer.inventory, tileEntityTinyChest);
        } else if (id == GUIs.FILTER_CHEST.ordinal()) {
            TileEntityFilterChest tileEntityFilterChest = (TileEntityFilterChest) world.getTileEntity(x, y, z);
            return new GuiFilterChest(entityPlayer.inventory, tileEntityFilterChest);
        } else if (id == GUIs.DRAW.ordinal()) {
            TileEntityDraw tileEntityDraw = (TileEntityDraw) world.getTileEntity(x, y, z);
            return new GuiDraw(entityPlayer.inventory, tileEntityDraw);
        } else if (id == GUIs.TRASH_CHEST.ordinal()) {
            TileEntityTrashChest tileEntityTrashChest = (TileEntityTrashChest) world.getTileEntity(x, y, z);
            return new GuiTrashChest(entityPlayer.inventory, tileEntityTrashChest);
        } else if (id == GUIs.MICRO_CHEST.ordinal()) {
            TileEntityMicroChest tileEntityMicroChest = (TileEntityMicroChest) world.getTileEntity(x, y, z);
            return new GuiMicroChest(entityPlayer.inventory, tileEntityMicroChest);
        } else if (id == GUIs.WOOL_CHEST.ordinal()) {
            TileEntityWoolChest tileEntityWoolChest = (TileEntityWoolChest) world.getTileEntity(x, y, z);
            return new GuiWoolChest(entityPlayer.inventory, tileEntityWoolChest);
        } else if (id == GUIs.PEACEFUL_CHEST.ordinal()) {
            TileEntityPeacefulChest tileEntityPeacefulChest = (TileEntityPeacefulChest) world.getTileEntity(x, y, z);
            return new GuiPeacefulChest(entityPlayer.inventory, tileEntityPeacefulChest);
        } else if (id == GUIs.VACUUM_CHEST.ordinal()) {
            TileEntityVacuumChest tileEntityVauumChest = (TileEntityVacuumChest) world.getTileEntity(x, y, z);
            return new GuiVacuumChest(entityPlayer.inventory, tileEntityVauumChest);
        } else if (id == GUIs.CLAY_CHEST.ordinal()) {
            TileEntityClayChest tileEntityClayChest = (TileEntityClayChest) world.getTileEntity(x, y, z);
            return new GuiClayChest(entityPlayer.inventory, tileEntityClayChest);
        } else if (id == GUIs.QUARRY_CHEST.ordinal()) {
            TileEntityQuarryChest tileEntityClayChest = (TileEntityQuarryChest) world.getTileEntity(x, y, z);
            return new GuiQuarryChest(entityPlayer.inventory, tileEntityClayChest);
        } else if (id == GUIs.STORAGE_BAG.ordinal()) {
            return new GuiStorageBag(entityPlayer, new InventoryStorageBag(entityPlayer.getHeldItem()));
        }else if (id == GUIs.BOOKCASE.ordinal()) {
            TileEntityBookCase tileEntityBookCase = (TileEntityBookCase) world.getTileEntity(x, y, z);
            return new GuiBookCase(entityPlayer.inventory, tileEntityBookCase);
        }
        return null;
    }

}
