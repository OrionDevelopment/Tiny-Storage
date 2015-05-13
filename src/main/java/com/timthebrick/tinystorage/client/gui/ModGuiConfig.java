package com.timthebrick.tinystorage.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

import com.timthebrick.tinystorage.handler.ConfigurationHandler;
import com.timthebrick.tinystorage.reference.References;

public class ModGuiConfig extends GuiConfig {

	public ModGuiConfig(GuiScreen guiScreen) {
		super(guiScreen, new ConfigElement(ConfigurationHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), References.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.config.toString()));
	}

}
