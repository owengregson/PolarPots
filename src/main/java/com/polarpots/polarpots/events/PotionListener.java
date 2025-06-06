package com.polarpots.polarpots.events;

import com.polarpots.polarpots.PolarPotsPlugin;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.potion.PotionType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class PotionListener implements Listener {

    private final PolarPotsPlugin plugin;

    public PotionListener(PolarPotsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLaunch(ProjectileLaunchEvent event) {
        if (event.getEntityType() == EntityType.SPLASH_POTION) {
            Projectile projectile = event.getEntity();
            if (projectile.getShooter() instanceof Player player && player.isSprinting()) {
                Vector velocity = projectile.getVelocity();
                double potSpeed = plugin.getConfig().getDouble("PotSpeed", 0.1);
                velocity.setY(velocity.getY() - potSpeed);
                projectile.setVelocity(velocity);
            }
        }
    }

    @EventHandler
    public void onSplash(PotionSplashEvent event) {
        if (event.getEntity().getShooter() instanceof Player shooter) {
            if (shooter.isSprinting() && event.getIntensity(shooter) > 0.5D) {
                event.setIntensity(shooter, 1.0D);
            }
        }
    }
}
