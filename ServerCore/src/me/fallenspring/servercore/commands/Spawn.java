package me.fallenspring.servercore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.fallenspring.servercore.Main;

public class Spawn implements CommandExecutor {
	
	private Main main;
	
	public Spawn(Main main) {
		this.main = main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			if (!(sender instanceof Player)) {
				main.getUtils().sendMessage(sender, main.getUtils().playerOnly());
				return true;
			}
			Player player = (Player) sender;
			if (main.isSpawnSet() != null) {
				player.teleport(main.getSpawnLocation());
			} else {
				main.getUtils().sendMessage(player, "&aThe Spawn is not set!");
			}
		}
		return false;
	}

}
