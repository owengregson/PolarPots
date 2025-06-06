package com.polarpots.polarpots.commands;

import org.bukkit.command.CommandSender;

public interface Command {
    boolean execute(CommandSender sender, String[] args);
}
