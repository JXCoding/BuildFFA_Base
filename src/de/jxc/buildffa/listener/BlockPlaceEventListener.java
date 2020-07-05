package de.jxc.buildffa.listener;

import de.jxc.buildffa.BuildFFA;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * @author: JXCoding on 25.06.2020 at 11:23
 * All rights reserved to @author JXCoding or Shortlabs.
 **/
public class BlockPlaceEventListener implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if(e.getBlockPlaced().getType() == Material.SANDSTONE) {
            Bukkit.getScheduler().runTaskLater(BuildFFA.getInstance(), new BukkitRunnable() {
                @Override
                public void run() {
                    e.getBlockPlaced().setType(Material.AIR);
                }
            }, 4*20);
        }
    }

}
