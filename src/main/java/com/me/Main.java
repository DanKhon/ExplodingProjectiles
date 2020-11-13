package com;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;

public class Main extends PluginBase {

    public static Config config;

    public static boolean eggs;
    public static boolean arrows;
    public static boolean snowballs;

    @Override
    public void onEnable() {
        getLogger().info(TextFormat.GREEN + "Exploding Arrows Plugin Enabled");
        config = getConfig();
        getServer().getPluginManager().registerEvents(new Shoot(),this);

        eggs = config.getBoolean("eggs");
        arrows = config.getBoolean("arrows");
        snowballs = config.getBoolean("snowballs");

        super.onEnable();
    }

    @Override
    public void onDisable() {
        getLogger().info(TextFormat.RED + "Exploding Arrows Plugin Disabled");
        super.onDisable();
    }
}
