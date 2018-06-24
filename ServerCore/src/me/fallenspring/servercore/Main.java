package me.fallenspring.servercore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import me.fallenspring.servercore.commands.Message;
import me.fallenspring.servercore.commands.Spawn;
import me.fallenspring.servercore.commands.staff.Enchant;
import me.fallenspring.servercore.commands.staff.CoreCommands;
import me.fallenspring.servercore.utils.Utils;

public class Main extends JavaPlugin {

    private Location loc = new Location(Bukkit.getWorld("world"), -1220.548, 110, -1074.372);
    private Utils utils = new Utils();
    private static Main main;
    

    public void onEnable() {
        Bukkit.getServer().getConsoleSender().sendMessage("[ServerCore] has been enabled");
        register();
        saveDefaultConfig();
        main = this;
    }
    
    public void register() {
    	getCommand("msg").setExecutor(new Message(this));
    	getCommand("spawn").setExecutor(new Spawn(this));
    	getCommand("enchant").setExecutor(new Enchant(this));
    	getCommand("core").setExecutor(new CoreCommands());
    }

    public String getPrefix() {
        return this.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "prefix"));
    }
    
    public Utils getUtils() {
        return this.utils;
    }
    
    public Location getSpawnLocation() {
    	return this.loc;
    }
    
    public Location isSpawnSet() {
    	if (loc == null) {
    		return null;
    	}
		return loc;
    }
    
    public static Main getInstance() {
    	return main;
    }
}
