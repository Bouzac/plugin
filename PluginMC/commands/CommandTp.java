package ca.bouzac.PluginMC.commands;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class CommandTp implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("lobby"))
			{
					
					
				if(player.getWorld() == Bukkit.getWorld("minage" + "" + player.getName())) 
				{
					

					Location lobby = new Location((Bukkit.getWorld("Lobby")), -123.01, 152.50, 96.01, -90f, 2f);
					player.teleport(lobby);
				
					Bukkit.unloadWorld("minage" + "" + player.getName(), false);				
				
				} else
				{
				
					Location lobby = new Location((Bukkit.getWorld("Lobby")), Bukkit.getWorld("Lobby").getSpawnLocation().getX(), Bukkit.getWorld("Lobby").getSpawnLocation().getY(), Bukkit.getWorld("Lobby").getSpawnLocation().getZ(), -90f, 2f);
					player.teleport(lobby);
			
				}			
				
			}
			
			Location locPlayer = player.getLocation();
			
			if(cmd.getName().equalsIgnoreCase("standR"))
			{
				

				ItemStack chestplateR = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta lch = (LeatherArmorMeta) chestplateR.getItemMeta();
				lch.setColor(Color.RED);
				chestplateR.setItemMeta(lch);
				
				ArmorStand standR = (ArmorStand) locPlayer.getWorld().spawnEntity(locPlayer, EntityType.ARMOR_STAND);
				standR.setCustomName("§4Spawn des Rouges");
				standR.setCustomNameVisible(true);
				standR.setVisible(false);
				standR.setInvulnerable(true);
				standR.setChestplate(chestplateR);
				
			}
			
			if(cmd.getName().equalsIgnoreCase("standV"))
			{
				
				ItemStack chestplateV = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta lch = (LeatherArmorMeta) chestplateV.getItemMeta();
				lch.setColor(Color.GREEN);
				chestplateV.setItemMeta(lch);
				
				ArmorStand standV = (ArmorStand) locPlayer.getWorld().spawnEntity(locPlayer, EntityType.ARMOR_STAND);
				standV.setCustomName("§2Spawn des Verts");
				standV.setCustomNameVisible(true);
				standV.setVisible(false);
				standV.setInvulnerable(true);
				standV.setChestplate(chestplateV);
				
			}

			if(cmd.getName().equalsIgnoreCase("standB"))
			{
				
				ItemStack chestplateB = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta lch = (LeatherArmorMeta) chestplateB.getItemMeta();
				lch.setColor(Color.BLUE);
				chestplateB.setItemMeta(lch);
				
				ArmorStand standB = (ArmorStand) locPlayer.getWorld().spawnEntity(locPlayer, EntityType.ARMOR_STAND);
				standB.setCustomName("§1Spawn des Bleus");
				standB.setCustomNameVisible(true);
				standB.setVisible(false);
				standB.setInvulnerable(true);
				standB.setChestplate(chestplateB);
				
			}
			
			if(cmd.getName().equalsIgnoreCase("standJ"))
			{
				
				ItemStack chestplateB = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta lch = (LeatherArmorMeta) chestplateB.getItemMeta();
				lch.setColor(Color.YELLOW);
				chestplateB.setItemMeta(lch);
				
				ArmorStand standB = (ArmorStand) locPlayer.getWorld().spawnEntity(locPlayer, EntityType.ARMOR_STAND);
				standB.setCustomName("§eSpawn des Jaunes");
				standB.setCustomNameVisible(true);
				standB.setVisible(false);
				standB.setInvulnerable(true);
				standB.setChestplate(chestplateB);
				
			}
			
		}
		
		return false;
	}

}
