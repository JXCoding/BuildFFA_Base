package de.jxc.buildffa.manager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

/**
 * @author: JXCoding on 25.06.2020 at 11:08
 * All rights reserved to @author JXCoding or Shortlabs.
 **/
public class LocationManager {

    private Player player;
    private ConfigManager configManager;

    public LocationManager() {
        configManager = new ConfigManager("locations.yml");
    }

    public LocationManager(Player player) {
        this.player = player;
        configManager = new ConfigManager("locations.yml");
    }

    public void setLocation(String location) {
        if(player != null) {
            Location pLoc = player.getLocation();
            configManager.getYamlConfiguration().set("buildffa." + location + ".x", pLoc.getX());
            configManager.getYamlConfiguration().set("buildffa." + location + ".y", pLoc.getY());
            configManager.getYamlConfiguration().set("buildffa." + location + ".z", pLoc.getZ());

            configManager.getYamlConfiguration().set("buildffa." + location + ".yaw", pLoc.getYaw());
            configManager.getYamlConfiguration().set("buildffa." + location + ".pitch", pLoc.getPitch());

            configManager.getYamlConfiguration().set("buildffa." + location + ".world", pLoc.getWorld().getName());
            configManager.save();

        } else {
            System.out.println("Player Variable is null.");
        }
    }

    public Location getLocation(String location) {
        double x = configManager.getYamlConfiguration().getDouble("buildffa." + location + ".x");
        double y = configManager.getYamlConfiguration().getDouble("buildffa." + location + ".y");
        double z = configManager.getYamlConfiguration().getDouble("buildffa." + location + ".z");

        float yaw = configManager.getYamlConfiguration().getInt("buildffa." + location + ".yaw");
        float pitch = configManager.getYamlConfiguration().getInt("buildffa." + location + ".pitch");

        World w = Bukkit.getWorld(configManager.getYamlConfiguration().getString("buildffa." + location + ".world"));

        Location loc = new Location(w, x, y, z);
        loc.setPitch(pitch);
        loc.setYaw(yaw);

        return loc;
    }

}
