package de.jxc.buildffa.commands;

import de.jxc.buildffa.manager.LocationManager;
import de.jxc.buildffa.utils.Data;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author: JXCoding on 25.06.2020 at 11:02
 * All rights reserved to @author JXCoding or Shortlabs.
 **/
public class BuildFFACommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Data data = new Data();
        if(!(sender instanceof Player)) {
            sender.sendMessage(data.noPlayer);
            return false;
        }

        Player p = (Player) sender;
        if(p.hasPermission("buildffa.admin")) {
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("help")) {
                    p.sendMessage(data.prefix + "§9/buildffa help §7- §8Shows the help.");
                    p.sendMessage(data.prefix + "§9/buildffa setspawn §7- §8Set the spawnpoint.");
                } else if(args[0].equalsIgnoreCase("setspawn")) {
                    new LocationManager(p).setLocation("spawn");
                    p.sendMessage(data.prefix + "§7You successful set the spawn.");
                }

            } else {
                p.sendMessage(data.prefix + "§7Plugin by §9@_JXc");
                p.sendMessage(data.prefix + "§7Check §9_JXc - Developer §7on Youtube.");
                p.sendMessage(" ");
                p.sendMessage(data.prefix + "§7Please use §9/buildffa help");
            }
        } else {
            p.sendMessage(data.noPerms);
        }
        return false;
    }


}
