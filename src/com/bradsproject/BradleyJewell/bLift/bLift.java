package com.bradsproject.BradleyJewell.bLift;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

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
		System.out.println("bSwarm has been disabled!");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,
			String[] args)
	{
		if(!(sender instanceof Player))
			return false;
		
		Player player = (Player) sender;
		String commandName = cmd.getName().toLowerCase();
		
		if(commandName.equals("bswarm"))
		{
			try
			{
				if(args.length > 0)
				{
					return true;
				} else
				{
					player.sendMessage("Sending your swarm...");
					return true;
				}
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}
	
}
