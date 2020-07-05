package de.jxc.buildffa.listener;

import de.jxc.buildffa.manager.InventoryManager;
import de.jxc.buildffa.manager.LocationManager;
import de.jxc.buildffa.utils.Data;
import de.jxc.buildffa.utils.ItemCreator;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author: JXCoding on 25.06.2020 at 11:19
 * All rights reserved to @author JXCoding or Shortlabs.
 **/
public class PlayerJoinEventListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Data data = new Data();
        LocationManager locationManager = new LocationManager();
        e.setJoinMessage(data.getPrefix() + "§9" + p.getDisplayName() + "§7 joined the game.");

        new InventoryManager(p).joinInventory();

        if(locationManager.getLocation("spawn") != null) {
            p.teleport(locationManager.getLocation("spawn"));
        } else {
            p.sendMessage(data.prefix + "§cUnable to find the spawn. §7Please set it with §9/buildffa setspawn");
        }
    }

}
