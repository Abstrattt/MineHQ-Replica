package com.frozenorb.commonlibs;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

@Getter @Setter
public class ConfigHelper {

    /* File */
    private File file;
    /* Strings */
    private String name, directory;
    /* Configuration */
    private Configuration configuration;

    /**
     * Configuration Class
     *
     * @param name - Is the identifier for the configuration file and object.
     * @param directory - Directory.
     */
    public ConfigHelper(JavaPlugin plugin, String name, String directory){
        /* Set the Name */
        setName(name);
        /* Set the Directory */
        setDirectory(directory);
        /* Set File */
        file = new File(directory, name + ".yml");
        /* If file does not already exist, then grab it internally from the resources folder */
        if (!file.exists()) {
            plugin.saveResource(name + ".yml", false);
        }
        /* Load the files configuration */
        this.configuration = YamlConfiguration.loadConfiguration(this.getFile());
    }

    public void save() {
        //TODO get it to save properly
    }
}
