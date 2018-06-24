package me.fallenspring.servercore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.fallenspring.servercore.Main;

public class Message implements CommandExecutor {
	
	private Main main;
	
	public Message(Main main) {
		this.main = main;
	}
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (cmd.getName().equalsIgnoreCase("msg")) {
    		if (!(sender instanceof Player)) {
    			sender.sendMessage(main.getUtils().playerOnly());
    			return true;
    		}
    		Player player = (Player) sender;
    		if (args.length < 2) {
    			main.getUtils().sendMessage(player, "&aInvalid Usage! /msg <Player> <Message>");
    			return true;
    		}
    		Player target = Bukkit.getPlayer(args[0]);
    		if (target == null) {
    			main.getUtils().sendMessage(player, "&aCould not find user.");
    			return true;
    		}
    		StringBuilder sb = new StringBuilder();
    		
    		for (int i = 1; i < args.length; i++) {
    			sb.append(args[i]).append(" ");
    		}
    		String message = sb.toString().trim();
    		player.sendMessage(main.getUtils().toColor("&6You ----> &r" + target.getName() + " says: " + message));
    		target.sendMessage(main.getUtils().toColor(player.getName() + "&6 ---> You says: " + message));
        }
		return false;
    }
}
