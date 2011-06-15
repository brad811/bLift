package com.bradsproject.BradleyJewell.bLift;

import org.bukkit.Server;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.bradsproject.BradleyJewell.bLift.bLiftRedstoneListener;

/**
 * bLift for Bukkit
 * 
 * @author BradleyJewell
 */
public class bLift extends JavaPlugin
{
	Server server;
	
	private final bLiftRedstoneListener redstoneListener = new bLiftRedstoneListener(this);
	
	public void onEnable()
	{
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.REDSTONE_CHANGE, redstoneListener, Priority.Low, this);
		
		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println(pdfFile.getName() + " version " + pdfFile.getVersion()
				+ " is enabled!");
	}
	
	public void onDisable()
	{
		System.out.println("bLift has been disabled!");
	}
}
