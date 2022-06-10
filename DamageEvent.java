package me.canable.swaplocations.Listeners;

import me.canable.swaplocations.Main;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageEvent implements Listener {
    private Main plugin;

    public DamageEvent(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        FileConfiguration cfg = plugin.getConfig();
        if(e.getDamager().getType().equals(EntityType.valueOf((String) cfg.get("Type")))){
            if(e.getEntity() instanceof Player){
                if(cfg.get("Enabled").equals("true")){
                    e.setCancelled(true);
                    if(e.getDamager() instanceof Egg){
                        Player victim = (Player) e.getEntity();
                        Player damager = (Player) ((Egg) e.getDamager()).getShooter();
                        Location victimloc = victim.getLocation();
                        Location damagerloc = damager.getLocation();
                        victim.teleport(damagerloc);
                        damager.teleport(victimloc);
                        String s = (String) cfg.get("Sound");
                        damager.playSound(damager.getLocation(), Sound.valueOf(s),1,1);
                        victim.playSound(victim.getLocation(), Sound.valueOf(s),1,1);
                    }
                    if(e.getDamager() instanceof Snowball){
                        Player victim = (Player) e.getEntity();
                        Player damager = (Player) ((Snowball) e.getDamager()).getShooter();
                        Location victimloc = victim.getLocation();
                        Location damagerloc = damager.getLocation();
                        victim.teleport(damagerloc);
                        damager.teleport(victimloc);
                        String s = (String) cfg.get("Sound");
                        damager.playSound(damager.getLocation(), Sound.valueOf(s),1,1);
                        victim.playSound(victim.getLocation(), Sound.valueOf(s),1,1);
                    }
                    if(e.getDamager() instanceof Arrow){
                        Player victim = (Player) e.getEntity();
                        Player damager = (Player) ((Arrow) e.getDamager()).getShooter();
                        Location victimloc = victim.getLocation();
                        Location damagerloc = damager.getLocation();
                        victim.teleport(damagerloc);
                        damager.teleport(victimloc);
                        String s = (String) cfg.get("Sound");
                        damager.playSound(damager.getLocation(), Sound.valueOf(s),1,1);
                        victim.playSound(victim.getLocation(), Sound.valueOf(s),1,1);
                        e.getDamager().remove();
                    }
                    if(e.getDamager() instanceof EnderPearl){
                        e.getDamager().remove();
                        Player victim = (Player) e.getEntity();
                        Player damager = (Player) ((EnderPearl) e.getDamager()).getShooter();
                        Location victimloc = victim.getLocation();
                        Location damagerloc = damager.getLocation();
                        victim.teleport(damagerloc);
                        damager.teleport(victimloc);
                        String s = (String) cfg.get("Sound");
                        damager.playSound(damager.getLocation(), Sound.valueOf(s),1,1);
                        victim.playSound(victim.getLocation(), Sound.valueOf(s),1,1);
                    }
                }
            }
        }
    }
}
