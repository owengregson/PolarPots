package com.polarpots.polarpots;

import com.polarpots.polarpots.commands.PolarPotsCommand;
import com.polarpots.polarpots.events.PotionListener;
import com.polarpots.polarpots.utils.Debug;
import org.bukkit.plugin.java.JavaPlugin;

public class PolarPotsPlugin extends JavaPlugin {

    private static PolarPotsPlugin instance;
    private PolarPotsCommand command;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Debug.initialize(this);
        getServer().getPluginManager().registerEvents(new PotionListener(this), this);
        command = new PolarPotsCommand(this);
        getCommand("polarpots").setExecutor(command);
        getCommand("polarpots").setTabCompleter(command);
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static PolarPotsPlugin getInstance() {
        return instance;
    }
}
