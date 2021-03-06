package com.timthebrick.tinystorage.client.renderer.tileentity;

import com.timthebrick.tinystorage.reference.References;
import com.timthebrick.tinystorage.tileentity.implementations.TileEntityQuarryChest;
import com.timthebrick.tinystorage.tileentity.implementations.TileEntityTrashChest;
import com.timthebrick.tinystorage.tileentity.implementations.sub.TileEntityQuarryChestLarge;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class TileEntityRendererQuarryChest extends TileEntitySpecialRenderer{

    private final ModelChest modelChest = new ModelChest();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        if (tileEntity instanceof TileEntityQuarryChest) {
            TileEntityQuarryChest tileEntityQuarryChest= (TileEntityQuarryChest) tileEntity;
            ForgeDirection direction = null;

            if (tileEntityQuarryChest.getWorldObj() != null) {
                direction = tileEntityQuarryChest.getOrientation();
            }

            World world = tileEntityQuarryChest.getWorldObj();
            Block block = world.getBlock(tileEntityQuarryChest.xCoord, tileEntityQuarryChest.yCoord, tileEntityQuarryChest.zCoord);

            this.bindTexture(new ResourceLocation(References.MOD_ID.toLowerCase() + ":textures/models/chests/quarryChest.png"));

            GL11.glPushMatrix();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float) x, (float) y + 1.0F, (float) z + 1.0F);

            //TinyStorageLog.info(tileEntityQuarryChest.getState());

            if (tileEntityQuarryChest.getState() == 0) {
                GL11.glScalef(0.65F, -0.65F, -0.65F);
                GL11.glTranslatef(0.26F, 0.53F, 0.26F);
            } else if (tileEntityQuarryChest.getState() == 1) {
                GL11.glScalef(0.8F, -0.8F, -0.8F);
                GL11.glTranslatef(0.12F, 0.25F, 0.12F);
            } else if (tileEntityQuarryChest.getState() == 2) {
                GL11.glScalef(1.0F, -1.0F, -1.0F);
            }

            GL11.glTranslatef(0.5F, 0.5F, 0.5F);

            short angle = 0;

            if (direction != null) {
                if (direction == ForgeDirection.NORTH) {
                    angle = 180;
                } else if (direction == ForgeDirection.SOUTH) {
                    angle = 0;
                } else if (direction == ForgeDirection.WEST) {
                    angle = 90;
                } else if (direction == ForgeDirection.EAST) {
                    angle = -90;
                }
            }

            GL11.glRotatef(angle, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            float adjustedLidAngle = tileEntityQuarryChest.prevLidAngle + (tileEntityQuarryChest.lidAngle - tileEntityQuarryChest.prevLidAngle) * tick;
            adjustedLidAngle = 1.0F - adjustedLidAngle;
            adjustedLidAngle = 1.0F - adjustedLidAngle * adjustedLidAngle * adjustedLidAngle;
            modelChest.chestLid.rotateAngleX = -(adjustedLidAngle * (float) Math.PI / 2.0F);
            modelChest.renderAll();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}
