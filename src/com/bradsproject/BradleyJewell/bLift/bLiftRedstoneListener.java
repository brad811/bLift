package com.bradsproject.BradleyJewell.bLift;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockRedstoneEvent;

public class bLiftRedstoneListener extends BlockListener
{
	private final bLift plugin;
	
	public bLiftRedstoneListener(bLift instance)
	{
		plugin = instance;
	}
	
	@Override
	public void onBlockRedstoneChange(BlockRedstoneEvent event)
	{
		Block block = event.getBlock();
		if(block.getType() == Material.STONE_BUTTON && !block.isBlockIndirectlyPowered())
			new Elevator(plugin, block);
	}
}
