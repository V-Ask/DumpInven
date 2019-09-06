package com.r1ckp1ckle.battlepass;

import com.r1ckp1ckle.battlepass.commands.Dump;
import com.r1ckp1ckle.battlepass.utility.ConfigurationUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class DumpInven extends JavaPlugin {

    private static DumpInven instance;
    private ConfigurationUtils configurationUtils;
    public static DumpInven getInstance() {
        return instance;
    }

    public void onEnable() {
        System.out.println("=======================================");
        instance = this;
        configurationUtils = new ConfigurationUtils(this);
        registerListeners();
        registerCommands();
        System.out.println("DumpInven Enabled");
        System.out.println("=======================================");
    }

    @Override
    public void onDisable() {
        System.out.println("=======================================");
        System.out.println("DumpInven Disabled");
        System.out.println("=======================================");
    }

    private void registerListeners() {

    }

    private void registerCommands() {
        getCommand("dump").setExecutor(new Dump());
    }
}