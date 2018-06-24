package me.fallenspring.servercore.commands.staff;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import me.fallenspring.servercore.Main;

public class Enchant implements CommandExecutor {
	
	private Main main;
	
	public Enchant(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("enchant")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(main.getUtils().playerOnly());
				return true;
			}
			Player player = (Player) sender;
			if (!player.hasPermission("core.enchant")) {
				main.getUtils().sendMessage(player, main.getUtils().noPermission());
				return true;
			}
			if (args.length < 2) {
				main.getUtils().sendMessage(player, "&aInvalid Usage! /enchant <Enchantment> <Level>");
				return true;
			}
			if (args[0].equalsIgnoreCase("sharpness")) {
				if (player.getInventory().getItemInMainHand().getType() == Material.AIR) {
					main.getUtils().sendMessage(player, "&aYou cannot enchant that!");
					return true;
				}
				int level = 0;
				try {
					level = Integer.parseInt(args[1]);
				} catch (NumberFormatException e) {
					main.getUtils().sendMessage(player, "&aThe Argument 1 is not a valid number!");
				}
				if (level > 5) {
					player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DAMAGE_ALL, level);
					main.getUtils().sendMessage(player, "&aYou've added Sharpness: " + level + " to your item!");
				} else if (level >= 5) {
					player.getInventory().getItemInMainHand().addEnchantment(Enchantment.DAMAGE_ALL, level);
					main.getUtils().sendMessage(player, "&aYou've added Sharpness: " + level + " to your item!");
				}
			}
		}
		return false;
	}
}
