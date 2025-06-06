package com.polarpots.polarpots.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class Debug {
    private static Plugin plugin;
    private Debug() {}

    public static void initialize(Plugin p) {
        plugin = p;
    }

    public static void log(CommandSender sender, String message) {
        if (plugin.getConfig().getBoolean("debug", false)) {
            sender.sendMessage(ChatColor.GRAY + "[PolarPots] " + message);
        }
    }
}
