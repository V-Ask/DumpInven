package com.r1ckp1ckle.battlepass.events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class PlayerInventoryDumpEvent extends Event implements Cancellable {
    private Player player;
    private Location dropLocation;
    private World world;
    private ItemStack[] droppedItems;

    public PlayerInventoryDumpEvent(Player player, Location dropLocation, World world, ItemStack[] droppedItems) {
        this.player = player;
        this.dropLocation = dropLocation;
        this.world = world;
        this.droppedItems = droppedItems;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Location getDropLocation() {
        return this.dropLocation;
    }

    public World getWorld() {
        return this.world;
    }

    public ItemStack[] getDroppedItems() {
        return this.droppedItems;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }

    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList(){
        return handlers;
    }
}
