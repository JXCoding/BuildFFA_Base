package de.jxc.buildffa.manager;

import de.jxc.buildffa.utils.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * @author: JXCoding on 25.06.2020 at 15:36
 * All rights reserved to @author JXCoding or Shortlabs.
 **/
public class InventoryManager {

    private Player player;

    public InventoryManager(Player player) {
        this.player = player;
    }

    public void joinInventory() {
        Inventory inv = player.getInventory();
        inv.clear();

        new ItemCreator(Material.DIAMOND_SWORD, 1).setName("§7Slicer").setSlot(inv, 0);
        new ItemCreator(Material.SANDSTONE, 64).setName("§7Building Blocks").setSlot(inv, 1);

    }

    public void openKitInventory() {
        Inventory inv = Bukkit.createInventory(null, 27, "§9Kits");


        player.openInventory(inv);
    }

}
