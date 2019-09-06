package com.r1ckp1ckle.battlepass.commands;

import com.r1ckp1ckle.battlepass.DumpInven;
import com.r1ckp1ckle.battlepass.events.PlayerInventoryDumpEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Dump implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) return true;
        Player player = (Player)commandSender;
        Location dropLocale = player.getLocation().add(player.getLocation().getDirection().multiply((int)DumpInven.getInstance().getConfig().getDouble("drop-offset")));
        PlayerInventoryDumpEvent event = new PlayerInventoryDumpEvent(player, dropLocale, player.getWorld(), player.getInventory().getContents());
        Bukkit.getPluginManager().callEvent(event);
        if(!event.isCancelled()) {
            for(int i = 0; i < player.getInventory().getSize(); i++) {
                ItemStack itemStack = player.getInventory().getContents()[i];
                if(itemStack == null || itemStack.getType().equals(Material.AIR)) continue;
                player.getInventory().setItem(i, null);
                player.getWorld().dropItemNaturally(dropLocale, itemStack);
            }
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', DumpInven.getInstance().getConfig().getString("dump-message")));
        }
        return true;
    }
}
