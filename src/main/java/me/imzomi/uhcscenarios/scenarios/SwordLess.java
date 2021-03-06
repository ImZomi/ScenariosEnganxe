package me.imzomi.uhcscenarios.scenarios;

import me.imzomi.uhcscenarios.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class SwordLess implements Listener, CommandExecutor {

    private Main plugin;
    public SwordLess(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void cancelSword(CraftItemEvent e){
        if (plugin.SwordLess){
            if (e.getRecipe().getResult().getType() == Material.DIAMOND_SWORD || e.getRecipe().getResult().getType() == Material.IRON_SWORD || e.getRecipe().getResult().getType() == Material.GOLDEN_SWORD || e.getRecipe().getResult().getType() == Material.NETHERITE_SWORD || e.getRecipe().getResult().getType() == Material.STONE_SWORD || e.getRecipe().getResult().getType() == Material.WOODEN_SWORD){
                e.setCancelled(true);
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Enganxe" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " No puedes ejecutar comandos desde la consola");
        }
        if (sender.hasPermission("uhc.admin") && cmd.getName().equalsIgnoreCase("SwordLess")) {
            if (!plugin.SwordLess) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY+ "["+ChatColor.GOLD+"Enganxe"+ChatColor.DARK_GRAY+"]"+ " &0➤ &fSwordLess has been &aenabled"));
                plugin.SwordLess = Boolean.valueOf(true);
            } else {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY+ "["+ChatColor.GOLD+"Enganxe"+ChatColor.DARK_GRAY+"]"+ " &0➤ &fSwordLess has been &cdisabled"));
                plugin.SwordLess = Boolean.valueOf(false);
            }
        } else {
            p.sendMessage(ChatColor.RED + "No tienes permisos para utilizar este comando");
        }
        return false;
    }
}