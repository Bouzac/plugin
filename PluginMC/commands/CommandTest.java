package ca.bouzac.PluginMC.commands;

import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
				Player player = (Player)sender;			
			if(cmd.getName().equalsIgnoreCase("test")) {
				player.sendMessage(ChatColor.DARK_RED + "Bravo tu as reussit le test !");
				return true;
			}
			if(cmd.getName().equalsIgnoreCase("alert")) {
				
				if(args.length == 0) {
					player.sendMessage("La comande est : /alert <message>");
				}
				if (args.length >= 1) {
					
					StringBuilder bc = new StringBuilder();
					for(String part : args) {
						bc.append(part + "");
					}
					
					Bukkit.broadcastMessage("§4[" + player.getName() + "]§0" + bc.toString());
					
				}
				
				return true;
			}
		}

		
		return false;
	}

}
