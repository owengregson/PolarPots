package com.polarpots.polarpots.commands;

import com.polarpots.polarpots.PolarPotsPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements Command {
    private final PolarPotsPlugin plugin;

    public ReloadCommand(PolarPotsPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!sender.hasPermission("polarpots.admin")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("PermissionMSG")));
            return true;
        }
        plugin.reloadConfig();
        sender.sendMessage(ChatColor.GREEN + "Config reloaded!");
        return true;
    }
}
