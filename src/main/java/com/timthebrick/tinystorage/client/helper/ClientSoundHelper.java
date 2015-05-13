package com.timthebrick.tinystorage.client.helper;

import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraftforge.fml.client.FMLClientHandler;

import com.timthebrick.tinystorage.util.ResourceLocationHelper;

public class ClientSoundHelper {
	
	public static void playSound(String soundName, float xCoord, float yCoord, float zCoord, float volume, float pitch) {
		FMLClientHandler.instance().getClient().getSoundHandler().playSound(new PositionedSoundRecord(ResourceLocationHelper.getResourceLocation(soundName), volume, pitch, xCoord, yCoord, zCoord));
	}

}
