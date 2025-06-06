package com.polarpots.polarpots.commands;

import com.polarpots.polarpots.PolarPotsPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements Command {
    private final PolarPotsPlugin plugin;

    public HelpCommand(PolarPotsPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        sender.sendMessage(ChatColor.AQUA + "PolarPots Commands:");
        sender.sendMessage(ChatColor.AQUA + "/polarpots fill [amount] - Fill inventory with splash healing II potions");
        sender.sendMessage(ChatColor.AQUA + "/polarpots reload - Reload config");
        return true;
    }
}
