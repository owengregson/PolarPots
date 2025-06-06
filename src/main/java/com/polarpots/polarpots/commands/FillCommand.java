package com.polarpots.polarpots.commands;

import com.polarpots.polarpots.PolarPotsPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class FillCommand implements Command {
    private final PolarPotsPlugin plugin;

    public FillCommand(PolarPotsPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return true;
        }
        if (!player.hasPermission("polarpots.admin")) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("PermissionMSG")));
            return true;
        }
        int amount = plugin.getConfig().getInt("FillAmount", 36);
        if (args.length >= 2) {
            try {
                amount = Integer.parseInt(args[1]);
            } catch (NumberFormatException ignored) {
            }
        }
        ItemStack potion = new ItemStack(Material.SPLASH_POTION);
        PotionMeta meta = (PotionMeta) potion.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL, false, true));
        potion.setItemMeta(meta);
        int filled = 0;
        for (int i = 0; i < player.getInventory().getSize() && filled < amount; i++) {
            player.getInventory().setItem(i, potion.clone());
            filled++;
        }
        player.sendMessage(ChatColor.GREEN + "Filled inventory with " + filled + " potions.");
        return true;
    }
}
