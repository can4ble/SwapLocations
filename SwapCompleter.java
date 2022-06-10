package me.canable.swaplocations.TabCompleters;

import me.canable.swaplocations.Main;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class SwapCompleter implements TabCompleter {
    private Main plugin;

    public SwapCompleter(Main plugin) {
        this.plugin = plugin;
    }
    public void SwapLocations(Entity entity1, Entity entity2){
        Location entity1loc = entity1.getLocation();
        Location entity2loc = entity2.getLocation();
        entity1.teleport(entity2loc);
        entity2.teleport(entity1loc);
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        FileConfiguration cfg = plugin.getConfig();
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("swaplocations.completer") || p.hasPermission("swaplocations.*")){
                if(args.length == 1){
                    List<String> returns = Arrays.asList("Toggle", "Type","Sound", "Prefix");
                    p.playSound(p.getLocation(), Sound.CLICK,1,1);
                    return returns;
                }else if(args.length == 2){
                    if(args[0].equalsIgnoreCase("type")){
                        List<String> types = Arrays.asList("EGG", "SNOWBALL", "ARROW", "ENDER_PEARL");
                        p.playSound(p.getLocation(), Sound.CLICK,1,1);
                        return types;
                    }else if(args[0].equalsIgnoreCase("prefix")){
                        List<String> returns = Arrays.asList("reset", String.valueOf(cfg.get("prefix")));
                        p.playSound(p.getLocation(), Sound.CLICK,1,1);
                        return returns;
                    }else if(args[0].equalsIgnoreCase("sound")){
                        p.playSound(p.getLocation(), Sound.CLICK,1,1);
                        return plugin.createList();
                    }
                }
            }
        }
        return null;
    }
}
