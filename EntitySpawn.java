package me.canable.swaplocations.Listeners;

import me.canable.swaplocations.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitySpawn implements Listener {
    private Main plugin;

    public EntitySpawn(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent e){
        FileConfiguration cfg = plugin.getConfig();
        if(cfg.get("Type").equals("EGG")){
            e.setCancelled(true);
        }
    }
}
