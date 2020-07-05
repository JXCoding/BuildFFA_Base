package de.jxc.buildffa;

import de.jxc.buildffa.commands.BuildFFACommand;
import de.jxc.buildffa.listener.BlockPlaceEventListener;
import de.jxc.buildffa.listener.PlayerJoinEventListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author: JXCoding on 25.06.2020 at 11:01
 * All rights reserved to @author JXCoding or Shortlabs.
 **/
public class BuildFFA extends JavaPlugin {

    private static BuildFFA instance;

    public void onEnable() {
        instance = this;
        PluginManager pm = Bukkit.getPluginManager();
        getCommand("buildffa").setExecutor(new BuildFFACommand());

        pm.registerEvents(new PlayerJoinEventListener(), this) ;
        pm.registerEvents(new BlockPlaceEventListener(), this);
    }

    public void onDisable() {

    }

    public static BuildFFA getInstance() {
        return instance;
    }
}
