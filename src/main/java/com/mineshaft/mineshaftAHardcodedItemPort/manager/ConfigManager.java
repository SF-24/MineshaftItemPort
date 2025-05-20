package com.mineshaft.mineshaftAHardcodedItemPort.manager;

import com.mineshaft.mineshaftAHardcodedItemPort.MineshaftItemPort;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.Objects;

public class ConfigManager {

    private static FileConfiguration config;

    public void setupConfig() {
        ConfigManager.config = MineshaftItemPort.getInstance().getConfig();
        MineshaftItemPort.getInstance().saveDefaultConfig();
    }

    public String getConfigLineToString(String line) {
        if(config.contains(line)) {
            return Objects.requireNonNull(config.get(line)).toString();
        }
        return null;
    }

    public Configuration getConfiguration() { return config; }

    public void ReloadConfigs() {
        config = YamlConfiguration.loadConfiguration(new File("Config.yml"));
    }



}
