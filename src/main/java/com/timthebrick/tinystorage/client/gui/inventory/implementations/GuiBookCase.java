package com.timthebrick.tinystorage.client.gui.inventory.implementations;

import com.timthebrick.tinystorage.client.gui.inventory.GuiTinyStorage;
import com.timthebrick.tinystorage.inventory.implementations.ContainerBookCase;
import com.timthebrick.tinystorage.inventory.implementations.ContainerClayChest;
import com.timthebrick.tinystorage.reference.Colours;
import com.timthebrick.tinystorage.reference.Names;
import com.timthebrick.tinystorage.reference.References;
import com.timthebrick.tinystorage.tileentity.implementations.TileEntityBookCase;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiBookCase extends GuiTinyStorage {

    private TileEntityBookCase tileEntity;

    public GuiBookCase (InventoryPlayer inventoryPlayer, TileEntityBookCase tileEntity) {
        super(new ContainerBookCase(inventoryPlayer, tileEntity), tileEntity);
        this.tileEntity = tileEntity;
        this.xSize = 176;
        this.ySize = 169;
    }

    @Override
    protected void drawGuiContainerForegroundLayer (int x, int y) {
        if (tileEntity.hasOwner()) {
            fontRendererObj.drawString(StatCollector.translateToLocal(tileEntity.getInventoryName()) + " - " + tileEntity.getOwner(), 8, 6, Colours.INV_GRAY);
        } else {
            fontRendererObj.drawString(StatCollector.translateToLocal(tileEntity.getInventoryName()), 8, 6, Colours.INV_GRAY);
        }
        fontRendererObj.drawString(StatCollector.translateToLocal(Names.Containers.VANILLA_INVENTORY), 8, ySize - 95 + 2, Colours.INV_GRAY);
        this.drawFG();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer (float opacity, int x, int y) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":textures/gui/guiBookCase.png"));
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawBG();
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }

    @Override
    public void drawFG () {
        super.drawFG();
    }

    @Override
    public void drawBG () {
        super.drawBG();
    }

    @Override
    public void initGui () {
        super.initGui();
    }
}
