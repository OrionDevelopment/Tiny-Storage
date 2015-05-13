package com.timthebrick.tinystorage.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;

import com.timthebrick.tinystorage.handler.ConfigurationHandler;
import com.timthebrick.tinystorage.handler.PlayerEventHandler;

public abstract class CommonProxy implements IProxy {
	
	PlayerEventHandler playerEventHandler = new PlayerEventHandler();

	public void registerEventHandlers() {
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		MinecraftForge.EVENT_BUS.register(playerEventHandler);
		FMLCommonHandler.instance().bus().register(playerEventHandler);
	}
	
}
