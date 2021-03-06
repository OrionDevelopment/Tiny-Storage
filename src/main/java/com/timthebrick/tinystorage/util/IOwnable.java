package com.timthebrick.tinystorage.util;

import net.minecraft.entity.player.EntityPlayer;

public interface IOwnable {

    void setOwner (String owner);

    void setOwner (EntityPlayer player);

    void setUniqueOwner (String owner);

    void setUniqueOwner (EntityPlayer player);

    String getOwner ();

    String getUniqueOwner ();

    boolean hasUniqueOwner ();

    boolean hasOwner ();

}
