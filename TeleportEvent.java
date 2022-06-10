package me.canable.swaplocations.Listeners;

import me.canable.swaplocations.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportEvent implements Listener {
    private Main plugin;

    public TeleportEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onTeleport(PlayerTeleportEvent e){
        FileConfiguration cfg = plugin.getConfig();
        if(e.getCause().equals(PlayerTeleportEvent.TeleportCause.ENDER_PEARL)){
            if(cfg.get("Type").equals("ENDER_PEARL")){
                if(cfg.get("Enabled").equals("true")){
                    e.setCancelled(true);
                }
            }
        }
    }
}
