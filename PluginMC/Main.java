package ca.bouzac.PluginMC;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.plugin.java.JavaPlugin;

import ca.bouzac.PluginMC.commands.CommandTest;
import ca.bouzac.PluginMC.commands.CommandTp;
import ca.bouzac.PluginMC.commands.commandGive;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		getCommand("test").setExecutor(new CommandTest());
		getCommand("alert").setExecutor(new CommandTest());
		getCommand("lobby").setExecutor(new CommandTp());
		getCommand("kit").setExecutor(new commandGive());
		getCommand("standR").setExecutor(new CommandTp());
		getCommand("standV").setExecutor(new CommandTp());
		getCommand("standB").setExecutor(new CommandTp());
		getCommand("standJ").setExecutor(new CommandTp());
		getServer().getPluginManager().registerEvents(new MonPluginListeners(this), this);		
		
		WorldCreator wc = new WorldCreator("Lobby");
		
		wc.environment(World.Environment.NORMAL);
		wc.type(WorldType.FLAT);
		
		wc.createWorld();
		
	}
}