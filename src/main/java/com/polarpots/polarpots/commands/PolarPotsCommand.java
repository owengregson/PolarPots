package com.polarpots.polarpots.commands;

import com.polarpots.polarpots.PolarPotsPlugin;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class PolarPotsCommand implements CommandExecutor, TabCompleter {
    private final PolarPotsPlugin plugin;
    private final Map<String, Command> subCommands = new HashMap<>();

    public PolarPotsCommand(PolarPotsPlugin plugin) {
        this.plugin = plugin;
        registerSubCommands();
    }

    private void registerSubCommands() {
        subCommands.put("help", new HelpCommand(plugin));
        subCommands.put("reload", new ReloadCommand(plugin));
        subCommands.put("fill", new FillCommand(plugin));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command cmd, @NotNull String label, String[] args) {
        if (args.length < 1) {
            return subCommands.get("help").execute(sender, args);
        }
        if (sender instanceof Player player && !player.hasPermission("polarpots.admin")) {
            player.sendMessage(org.bukkit.ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("PermissionMSG")));
            return true;
        }
        Command sub = subCommands.get(args[0].toLowerCase());
        if (sub != null) {
            return sub.execute(sender, args);
        }
        return subCommands.get("help").execute(sender, args);
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command cmd, @NotNull String alias, String[] args) {
        if (args.length == 1) {
            return new ArrayList<>(subCommands.keySet());
        }
        return Collections.emptyList();
    }
}
