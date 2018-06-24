package me.fallenspring.servercore.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Utils {

    private ArrayList<Player> jellyLegs = new ArrayList<Player>();
    private String prefix = toColor("&bServer >>");

    public void addJelly(Player p) {
        jellyLegs.add(p);
    }

    public void removeJelly(Player p) {
        jellyLegs.remove(p);
    }

    public boolean containsJelly(Player p) {
        return jellyLegs.contains(p);
    }

    public String playerOnly() {
    	return prefix + toColor("&aOnly a player can use this command!"); }

    public String noPermission() {
    	return prefix + toColor("&aOSorry, but you do not have permission to use this command!");}

    public void sendMessage(CommandSender sender, String message) {
    	sender.sendMessage(prefix + toColor(message));}

    public String toColor(String toColor) {
        return ChatColor.translateAlternateColorCodes('&', toColor);
    }
}