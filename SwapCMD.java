package me.canable.swaplocations.Commands;

import me.canable.swaplocations.Main;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class SwapCMD implements CommandExecutor {
    private Main plugin;

    public SwapCMD(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration cfg = plugin.getConfig();
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                p.sendMessage(cfg.get("Prefix") + "§bUsage§f: /swaplocations §bToggle§7/§bType§7/§bSound§7/§bPrefix");
                p.playSound(p.getLocation(),Sound.NOTE_PLING,1,1);
            }else if(args.length == 1){
                if(args[0].equalsIgnoreCase("toggle")){
                    if(cfg.get("Enabled").equals("true")) {
                        cfg.set("Enabled", "false");
                        p.sendMessage(cfg.get("Prefix") + "§bSwap §fhas been §cDisabled");
                        p.playSound(p.getLocation(),Sound.LEVEL_UP,1,1);
                        plugin.saveConfig();
                    }else{
                        cfg.set("Enabled", "true");
                        p.sendMessage(cfg.get("Prefix") + "§bSwap §fhas been §aEnabled");
                        p.playSound(p.getLocation(),Sound.LEVEL_UP,1,1);
                        plugin.saveConfig();
                    }
                }else if(args[0].equalsIgnoreCase("sound")){
                    p.sendMessage(cfg.get("Prefix") + "§bUsage§f: /swaplocations §bsound (Sound)");
                    p.sendMessage(cfg.get("Prefix") + "§bExample§f: /swaplocations §bsound LEVEL_UP");
                    p.playSound(p.getLocation(),Sound.NOTE_PLING,1,1);
                }else if(args[0].equalsIgnoreCase("type")){
                    p.sendMessage(cfg.get("Prefix") + "§bUsage§f: /swaplocations §btype (EntityType)");
                    p.sendMessage(cfg.get("Prefix") + "§bExample§f: /swaplocations §btype SNOWBALL");
                    p.playSound(p.getLocation(),Sound.NOTE_PLING,1,1);
                }
                else if(args[0].equalsIgnoreCase("prefix")){
                    p.sendMessage(cfg.get("Prefix") + "§bUsage§f: /swaplocations §bprefix (Prefix)");
                    p.sendMessage(cfg.get("Prefix") + "§bExample§f: /swaplocations §bprefix Swapper » ");
                    p.playSound(p.getLocation(),Sound.NOTE_PLING,1,1);
                }
            }
            if(args.length == 2){
                if(args[0].equalsIgnoreCase("type")){
                    List<String> types = Arrays.asList("EGG", "SNOWBALL", "ARROW", "ENDER_PEARL");
                    if(types.contains(args[1])){
                        cfg.set("Type", args[1]);
                        p.sendMessage(cfg.get("Prefix") + "§bSwap's Type §7has been set to §b" + args[1] + "!");
                        p.playSound(p.getLocation(),Sound.LEVEL_UP,1,1);
                        plugin.saveConfig();
                    }else{
                        p.sendMessage(cfg.get("Prefix") + "§cSorry but, this EntityType is invaild, remember this plugin's sounds are from 1.8.9");
                        p.playSound(p.getLocation(),Sound.BAT_HURT,1,1);
                    }
                }
                if(args[0].equalsIgnoreCase("sound")){
                    if(plugin.createList().contains(args[1])){
                        cfg.set("Sound", args[1]);
                        p.sendMessage(cfg.get("Prefix") + "§bSwap's Sound §7has been set to §b" + args[1] + "!");
                        p.playSound(p.getLocation(),Sound.LEVEL_UP,1,1);
                        plugin.saveConfig();
                    }else{
                        p.sendMessage(cfg.get("Prefix") + "§cSorry but, this Sound is invaild.");
                        p.playSound(p.getLocation(),Sound.BAT_HURT,1,1);
                    }
                }
                if(args[0].equalsIgnoreCase("prefix")){
                    if(args[1].equalsIgnoreCase("reset")){
                        cfg.set("Prefix", "§b§lSwapLocations §8» §r");
                        p.sendMessage(cfg.get("Prefix") + "§bSwap's Prefix §7has been set to §b§lSwapLocations §8» §r!");
                        p.playSound(p.getLocation(),Sound.LEVEL_UP,1,1);
                        plugin.saveConfig();
                    }else{
                        cfg.set("Prefix", args[1]);
                        p.sendMessage(cfg.get("Prefix") + "§bSwap's Prefix §7has been set to §b" + args[1] + "!");
                        p.playSound(p.getLocation(),Sound.LEVEL_UP,1,1);
                        plugin.saveConfig();
                    }
                }
            }else{
                if(args.length >= 2){
                    if(args[0].equalsIgnoreCase("prefix")){
                        StringBuilder builder = new StringBuilder();
                        int length = args.length;
                        for(int i = 1; i < length; i++){
                            builder.append(args[i]);
                            builder.append(" ");
                        }
                        String finalprefix = builder.toString();
                        cfg.set("Prefix", finalprefix);
                        p.sendMessage(cfg.get("Prefix") + "§bSwap's Prefix §7has been set to §b" + finalprefix + "!");
                        p.playSound(p.getLocation(),Sound.LEVEL_UP,1,1);
                        plugin.saveConfig();
                    }
                }
            }
        }
        return true;
    }
}
