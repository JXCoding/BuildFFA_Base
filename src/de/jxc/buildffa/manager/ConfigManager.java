package de.jxc.buildffa.manager;

import de.jxc.buildffa.BuildFFA;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * @author: JXCoding on 25.06.2020 at 11:06
 * All rights reserved to @author JXCoding or Shortlabs.
 **/
public class ConfigManager {

    private File file;
    private YamlConfiguration yamlConfiguration;

    private final String path = BuildFFA.getInstance().getDataFolder().getPath();

    public ConfigManager(String file) {
        this.file = new File(path, file);
        this.yamlConfiguration = YamlConfiguration.loadConfiguration(this.file);
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getYamlConfiguration() {
        return yamlConfiguration;
    }

    public void save() {
        try {
            this.yamlConfiguration.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
