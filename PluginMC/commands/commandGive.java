package ca.bouzac.PluginMC.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class commandGive implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String item, String[] args) {

		
		Player player = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("kit")) {
			
			player.getInventory().addItem(new ItemStack(Material.IRON_HELMET));
			player.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE));
			player.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS));
			player.getInventory().addItem(new ItemStack(Material.IRON_BOOTS));
			
		}
		
		if(cmd.getName().equalsIgnoreCase("dirt"))
		{
				player.getInventory().addItem(new ItemStack(Material.DIRT, 64));				
		}
		
		
		if(cmd.getName().equalsIgnoreCase("cobble"))
		{
				player.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 64));				
		}
		
		return false;
	}

}
