package me.fishergee.abusekenny.listeners;

import me.fishergee.abusekenny.AbuseKenny;
import me.fishergee.abusekenny.managers.Kenny;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener{

    private Kenny kenny = AbuseKenny.plugin.getKenny();

    @EventHandler
    public void onKennyMove(PlayerMoveEvent e){
        Location from = e.getFrom();
        Location to = e.getTo();
        Player p = e.getPlayer();
        if(kenny.getAbused() == true && (p.getName().equalsIgnoreCase("Confidential_") || p.getName().equalsIgnoreCase("Intriguing") || p.getName().equalsIgnoreCase("CraftyKenny") || p.getName().equalsIgnoreCase("ChillPixelL"))){
            if(from.getX() != to.getX() && from.getZ() != to.getZ()){
                p.teleport(from);
            }
        }
    }
}
