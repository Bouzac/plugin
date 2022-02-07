package ca.bouzac.PluginMC;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class MonPluginListeners implements Listener {
	
	private Main main;
	
	public MonPluginListeners(Main Main) {
		
		this.main = Main;
		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event)
	{
		
		Player player = event.getPlayer();
		
		Location spawnLobby = new Location((Bukkit.getWorld("Lobby")), Bukkit.getWorld("Lobby").getSpawnLocation().getX(), 48, Bukkit.getWorld("Lobby").getSpawnLocation().getZ());
		player.teleport(spawnLobby);
		
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event)
	{
		
		Player player = (Player) event.getPlayer();
		
		if(player.getWorld() == Bukkit.getWorld("minage" + "" + player.getName()))
		{
			
			Bukkit.unloadWorld("minage" + "" + player.getName(), false);			
			
		}
		
		Location lobby = new Location((Bukkit.getWorld("Lobby")), -123, 152, 96, -90f, 2f);
		player.teleport(lobby);
		
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event)
	{

		System.out.println(event.getEventName() + " a été utilisé par " + event.getEntity());
		Player player = (Player)event.getEntity();
		
		if(event.getEntityType() != EntityType.PLAYER) return;	
		
		if(player.getWorld() == Bukkit.getWorld("minage" + "" + player.getName()) || player.getWorld() == Bukkit.getWorld("Lobby") && event.getEntity() instanceof Player)
		{
			
			if(event.getCause().equals(DamageCause.VOID)) return ;
			event.setCancelled(true);
			
		}
		
	}
	
	@SuppressWarnings({ "unused" })
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		System.out.println(event.getEventName() + " a été utilisé par " + event.getPlayer());
		Location spawnLobby = new Location((Bukkit.getWorld("Lobby")), Bukkit.getWorld("Lobby").getSpawnLocation().getX(), Bukkit.getWorld("Lobby").getSpawnLocation().getY(), Bukkit.getWorld("Lobby").getSpawnLocation().getZ());
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack it = event.getItem();
		
		if(action == Action.RIGHT_CLICK_AIR) {
			
			
			
		}
		
		if(event.getClickedBlock() != null && action == Action.RIGHT_CLICK_BLOCK)
		{
			
			BlockState bs = event.getClickedBlock().getState();
			
			if(bs instanceof ArmorStand)
			{
				
				ArmorStand armorstand = (ArmorStand) bs;
				Location spawnAR = new Location((Bukkit.getWorld("Lobby")), -4, 48, -5);
				Location spawnR = new Location((Bukkit.getWorld("civiSMP")), -8, 104, -5);
				
				if(it != null)
				{
					
					player.sendMessage("Tu doit avoir la main vide pour faire cela");
					
				}
				
				if(armorstand.getLocation() == spawnAR)
				{
					
					player.teleport(spawnR);
					
				}
				
			}
			
			if(bs instanceof Sign)
			{
				
				Sign sign = (Sign) bs;
				
				if(sign.getLine(0).equalsIgnoreCase("[dirt]"))
				{
					String numberString = sign.getLine(2);
					int numberInt = Integer.parseInt(numberString);
					
					if(numberInt <= 65){
						
						player.sendMessage(numberInt + "est trop grand le max est de 64");
						
						return;
					}
					
					player.getInventory().addItem(new ItemStack(Material.DIRT, numberInt));
					
				}
				
				if(sign.getLine(0).equalsIgnoreCase("[cobble]"))
				{
					
					String numberString = sign.getLine(2);
					
					int numberInt = Integer.parseInt(numberString);
					
					player.getInventory().addItem(new ItemStack(Material.COBBLESTONE, numberInt));
					
				}
				
				if(sign.getLine(0).equalsIgnoreCase("[minage]"))
				{
					if(player.getWorld() == Bukkit.getWorld("minage" + "" + player.getName())) {
						
						player.sendMessage("Tu ne peut pas faire cela dans ce monde");
						
						return;
						
					}else
					{
						
					WorldCreator wc = new WorldCreator("minage" + "" + player.getName());
					
					wc.environment(World.Environment.NORMAL);
					wc.generateStructures(false);
					wc.type(WorldType.NORMAL);
					
					wc.createWorld();
					
					Location spawnM = new Location(Bukkit.getWorld("minage" + "" + player.getName()), Bukkit.getWorld("minage" + "" + player.getName()).getSpawnLocation().getX(), Bukkit.getWorld("minage" + "" + player.getName()).getSpawnLocation().getY(), Bukkit.getWorld("minage" + "" + player.getName()).getSpawnLocation().getZ());
					player.teleport(spawnM);
					Bukkit.getWorld("minage" + "" + player.getName()).setAnimalSpawnLimit(0);
					Bukkit.getWorld("minage" + "" + player.getName()).setMonsterSpawnLimit(0);

					}
	
				}
				
				if(sign.getLine(0).equalsIgnoreCase("§4Clique Ici") && sign.getLine(2).equalsIgnoreCase("Pour te tp"))
				{
					
					Location spawnR = new Location(Bukkit.getWorld("civisSMP"),-9 ,71 ,162 , 0f, 0f);
					player.teleport(spawnR);
					
				}
				
				if(sign.getLine(0).equalsIgnoreCase("§2Clique Ici") && sign.getLine(2).equalsIgnoreCase("Pour te tp"))
				{
					
					Location spawnV = new Location(Bukkit.getWorld("civisSMP"),96 ,115 ,32 , 0f, 0f);
					player.teleport(spawnV);
					
				}
				
				if(sign.getLine(0).equalsIgnoreCase("§1Clique Ici") && sign.getLine(2).equalsIgnoreCase("Pour te tp"))
				{
					
					Location spawnB = new Location(Bukkit.getWorld("civisSMP"),-46 ,127 ,-95 , 0f, 0f);
					player.teleport(spawnB);
					
				}
	
				if(sign.getLine(0).equalsIgnoreCase("§eClique Ici") && sign.getLine(2).equalsIgnoreCase("Pour te tp"))
				{
					
					Location spawnJ = new Location(Bukkit.getWorld("civisSMP"),-120, 107, -0 , 0f, 0f);
					player.teleport(spawnJ);
					
				}
				
			}
			
		}
		
		
		ItemStack plumeTp = new ItemStack(Material.FEATHER);
		ItemMeta plumeTpMeta = plumeTp.getItemMeta();
		plumeTpMeta.setDisplayName("Tp au ckeckpoint");
		plumeTp.setItemMeta(plumeTpMeta);
		
		ItemStack porteStart = new ItemStack(Material.IRON_DOOR);
		ItemMeta porteStartMeta = porteStart.getItemMeta();
		porteStartMeta.setDisplayName("Tp au début");
		porteStart.setItemMeta(porteStartMeta);
		
		ItemStack bedrockFin = new ItemStack(Material.BEDROCK);
		ItemMeta bedrockFinMeta = bedrockFin.getItemMeta();
		bedrockFinMeta.setDisplayName("Arrêter le jump");
		bedrockFin.setItemMeta(bedrockFinMeta);
			
		Inventory inv = player.getInventory();
		
		Location posDebut = main.getConfig().getLocation("jump.checkpoint.start");
		
		Location posCheck = posDebut;
		
		if(action == Action.PHYSICAL) {
			
			
				
				player.getInventory().clear();
				player.getInventory().setItem(0, plumeTp);
				player.getInventory().setItem(4, porteStart);
				player.getInventory().setItem(8, bedrockFin);
				posCheck = event.getClickedBlock().getLocation();			
				player.sendMessage("CheckPoint !");

				posCheck = event.getClickedBlock().getLocation();
		}
				
					
		
		if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			
			if(it.getItemMeta().getDisplayName() == "Tp au checkpoint") {
					
				player.teleport(posCheck);
						
			}
			
			if(it.getItemMeta().getDisplayName() == "Tp au début") {
				
				player.teleport(posDebut);
				event.setCancelled(true);		
			}
			
			if(it.getItemMeta().getDisplayName() == "Arrêter le jump") {
				
				player.teleport(spawnLobby);
				player.sendMessage("§2Tu as annulé le jump !");
				
			}
			
		}
		
				
		

			
		
		
		
		
	}
	
}
