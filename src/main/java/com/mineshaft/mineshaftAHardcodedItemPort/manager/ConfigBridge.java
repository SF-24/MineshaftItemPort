package com.mineshaft.mineshaftAHardcodedItemPort.manager;

import com.mineshaft.mineshaftAHardcodedItemPort.MineshaftItemPort;
import org.bukkit.configuration.Configuration;

public class ConfigBridge {

    public static int getCustomModelDataOfBrew(String name, Container container) {
        if (MineshaftItemPort.getInstance().getConfig().contains(container.name().toLowerCase() + "." + name)) {
            return getConfig().getInt(container.name().toLowerCase() + "." + name);
        } else if(container.equals(Container.TANKARD)) {
            return 13;
        }
        return 0;
    }
    public static Configuration getConfig() {
        return MineshaftItemPort.getInstance().getConfigManager().getConfiguration();
    }


}
