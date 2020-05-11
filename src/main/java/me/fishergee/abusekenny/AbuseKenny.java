package me.fishergee.abusekenny;

import me.fishergee.abusekenny.cmds.AbuseKennyCmd;
import me.fishergee.abusekenny.listeners.PlayerMoveListener;
import me.fishergee.abusekenny.managers.Kenny;
import org.bukkit.plugin.java.JavaPlugin;

public final class AbuseKenny extends JavaPlugin {

    public static AbuseKenny plugin;

    private final Kenny kenny = new Kenny();

    @Override
    public void onEnable() {
        plugin = this;
        registerListeners();
        registerCommands();
        kenny.startAnvilSpam();

    }

    @Override
    public void onDisable() {
        plugin = null;
    }

    public Kenny getKenny(){
        return this.kenny;
    }

    public void registerListeners()
    {
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
    }

    public void registerCommands(){
        getCommand("abusekenny").setExecutor(new AbuseKennyCmd());
    }
}
