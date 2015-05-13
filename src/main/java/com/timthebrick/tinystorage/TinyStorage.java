package com.timthebrick.tinystorage;

import java.io.File;

import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import com.timthebrick.tinystorage.core.TinyStorageLog;
import com.timthebrick.tinystorage.core.UnlocalizedNameDump;
import com.timthebrick.tinystorage.handler.ConfigurationHandler;
import com.timthebrick.tinystorage.handler.GuiHandler;
import com.timthebrick.tinystorage.init.ModBlocks;
import com.timthebrick.tinystorage.init.ModItems;
import com.timthebrick.tinystorage.init.Recipes;
import com.timthebrick.tinystorage.init.TileEntities;
import com.timthebrick.tinystorage.network.PacketHandler;
import com.timthebrick.tinystorage.proxy.IProxy;
import com.timthebrick.tinystorage.reference.References;

@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.VERSION, guiFactory = References.GUI_FACTORY_CLASS)
public class TinyStorage {

	public boolean developmentEnvironment;

	@Instance(References.MOD_ID)
	public static TinyStorage instance;

	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static IProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		developmentEnvironment = (Boolean)Launch.blackboard.get("fml.deobfuscatedEnvironment");
		if (developmentEnvironment){
			TinyStorageLog.info("Development Environment detected; some features may not work the same as in a normal game");
		}
		TinyStorageLog.info("Starting pre init");
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		PacketHandler.init();
		ModBlocks.init();
		ModItems.init();
		if (developmentEnvironment) {
			UnlocalizedNameDump.dumpBlockNames(new File(event.getModConfigurationDirectory(), References.MOD_ID + "_BlockUnlocalizedNames.txt"));
			UnlocalizedNameDump.dumpItemNames(new File(event.getModConfigurationDirectory(), References.MOD_ID + "_ItemUnlocalizedNames.txt"));
		}
		TinyStorageLog.info("Finished pre init");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		TinyStorageLog.info("Starting init");
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		TileEntities.init();
		proxy.initRenderingAndTextures();
		proxy.registerEventHandlers();
		Recipes.init();
		TinyStorageLog.info("Finished init");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		TinyStorageLog.info("Starting post init");
		TinyStorageLog.info("Finished post init");
	}

}
