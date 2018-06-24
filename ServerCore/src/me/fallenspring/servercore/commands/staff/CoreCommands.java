package me.fallenspring.servercore.commands.staff;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.fallenspring.servercore.Main;

public class CoreCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("core")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(Main.getInstance().getUtils().playerOnly());
				return true;
			}
			Player player = (Player) sender;
			if (!player.hasPermission("core.all")) {
				player.sendMessage(Main.getInstance().getUtils().noPermission());
				return true;
			}
			if (args.length == 0) {
				Main.getInstance().getUtils().sendMessage(player, "&aInvalid Usage. /core <command>");
				return true;
			}
			if (args[0].equalsIgnoreCase("reload")) {
				Main.getInstance().saveConfig();
				Main.getInstance().reloadConfig();
				Main.getInstance().getUtils().sendMessage(player, "&aSuccesfully reloaded.");
			}
		}
		return false;
	}
}
