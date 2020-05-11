package me.fishergee.abusekenny.managers;

import me.fishergee.abusekenny.AbuseKenny;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Kenny {
    private boolean isBeingAbused = false;

    public void setAbused(boolean abusedOrNot){
        isBeingAbused = abusedOrNot;
    }

    public boolean getAbused(){
        return this.isBeingAbused;
    }

    public boolean isOnlineKenny(){
        for(Player p : Bukkit.getServer().getOnlinePlayers()){
            if(p.getName().equals("Confidential_") || p.getName().equals("Intriguing") || p.getName().equals("CraftyKenny")){
                return true;
            }
        }
        return false;
    }

    public Player getOnlineKenny(){
        for(Player p : Bukkit.getServer().getOnlinePlayers()){
            if(p.getName().equals("Confidential_") || p.getName().equals("Intriguing") || p.getName().equals("CraftyKenny") || p.getName().equalsIgnoreCase("ChillPixelL")){
                return p;
            }
        }
        return null;
    }

    public void startAnvilSpam(){
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(AbuseKenny.plugin, new BukkitRunnable(){
            @Override
            public void run() {
                if(isOnlineKenny() == true && isBeingAbused == true){
                    getOnlineKenny().sendMessage(ChatColor.RED + "YOU ARE BEING ABUSED SIR!!!");
                    getOnlineKenny().playSound(getOnlineKenny().getLocation(), Sound.ANVIL_LAND, 10, 1);
                    getOnlineKenny().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 1));
                    getOnlineKenny().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 10));
                    getOnlineKenny().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 10));
                }
            }
        }, 0,5);
    }
}
