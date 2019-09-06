package com.r1ckp1ckle.dumpinven.utility;

import com.r1ckp1ckle.dumpinven.DumpInven;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.logging.Level;

public class ConfigurationUtils {
    private DumpInven dumpInven;

    public File getConfigFile() {
        return configFile;
    }

    private File configFile;
    private FileConfiguration config;

    public ConfigurationUtils(DumpInven dumpInven){
        this.dumpInven = dumpInven;
        initConfig();
    }

    private void initConfig() {
        if(!dumpInven.getDataFolder().exists()){
            dumpInven.getDataFolder().mkdirs();
        }
        configFile = new File(dumpInven.getDataFolder(), "config.yml");
        if(!configFile.exists()) dumpInven.saveResource("config.yml", false);
        config = new YamlConfiguration();
        try {
            config.load(configFile);
        } catch(Exception e) {
            dumpInven.getLogger().log(Level.SEVERE, "Failed to load plugin files.");
            dumpInven.getLogger().log(Level.SEVERE, "Error: " + e.getMessage());
        }
    }

    public void reloadFiles(){
        try {
            config.load(configFile);
        } catch (Exception e) {
            dumpInven.getLogger().log(Level.SEVERE, "Failed to load plugin files.");
            dumpInven.getLogger().log(Level.SEVERE, "Error: " + e.getMessage());
        }
    }

    public void saveFiles() {
        try {
            config.save(configFile);
        } catch (Exception e) {
            dumpInven.getLogger().log(Level.SEVERE, "Failed to save plugin files.");
            dumpInven.getLogger().log(Level.SEVERE, "Error: " + e.getMessage());
        }
    }
}
