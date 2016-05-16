package com.gmail.gogobebe2.cars;

import org.bukkit.plugin.java.JavaPlugin;

public class Cars extends JavaPlugin {
    private static Cars instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Starting up " + this.getName() + ". If you need me to update this plugin, email at gogobebe2@gmail.com");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling " + this.getName() + ". If you need me to update this plugin, email at gogobebe2@gmail.com");
    }

    public static Cars getInstance() {
        return instance;
    }
}
