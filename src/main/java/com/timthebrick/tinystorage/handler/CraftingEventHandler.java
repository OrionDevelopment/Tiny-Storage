package com.timthebrick.tinystorage.handler;

import com.timthebrick.tinystorage.item.crafting.RecipeStorageBags;
import com.timthebrick.tinystorage.util.IOwnable;
import com.timthebrick.tinystorage.util.ItemHelper;
import net.minecraft.item.ItemStack;

import com.timthebrick.tinystorage.item.ItemDebugTool;
import com.timthebrick.tinystorage.item.ItemDebugTool.OperationMode;
import com.timthebrick.tinystorage.item.ItemDebugTool.OperationModeSettings;
import com.timthebrick.tinystorage.util.NBTHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.crafting.CraftingManager;

public class CraftingEventHandler {

    public static void init () {
        CraftingManager.getInstance().getRecipeList().add(new RecipeStorageBags());
    }

    @SubscribeEvent
    public void onItemCraftedEvent (PlayerEvent.ItemCraftedEvent event) {
        if (event.crafting.getItem() instanceof IOwnable) {
            ItemHelper.setOwner(event.crafting, event.player);
        }
        if (!event.player.worldObj.isRemote) {
            ItemStack stack = event.crafting;
            if (stack != null) {
                if (stack.getItem() instanceof ItemDebugTool) {
                    ItemDebugTool debugTool = (ItemDebugTool) stack.getItem();
                    OperationModeSettings operationMode = OperationModeSettings.RENDER_AREA;
                    NBTHelper.setInteger(stack, "operationMode", operationMode.ordinal());
                }
            }
        }
    }

}
