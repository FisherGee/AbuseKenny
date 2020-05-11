package me.fishergee.abusekenny.cmds;

import me.fishergee.abusekenny.AbuseKenny;
import me.fishergee.abusekenny.managers.Kenny;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AbuseKennyCmd implements CommandExecutor {
    Kenny kenny = AbuseKenny.plugin.getKenny();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        if(!(cmd.getName().equalsIgnoreCase("abusekenny"))) return true;
        if(args.length == 1 && args[0].equalsIgnoreCase("stop")){
            kenny.setAbused(false);
            sender.sendMessage(ChatColor.RED + "YOU HAVE STOPPED ABUSING KENNY!");
            return true;
        }
        Kenny kenny = AbuseKenny.plugin.getKenny();
        kenny.setAbused(true);
        sender.sendMessage(ChatColor.GREEN + "ENABLED KENNY ABUSE!");
        return true;
    }
}
