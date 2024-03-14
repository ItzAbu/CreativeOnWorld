package org.itzabu.creativeonworld;

import org.bukkit.plugin.java.JavaPlugin;
import org.itzabu.creativeonworld.listeners.ChangeWorldEvent;
import org.itzabu.creativeonworld.utils.CustomConfig;

import java.util.ArrayList;
import java.util.List;

public final class CreativeOnWorld extends JavaPlugin {

    @Override
    public void onEnable() {
        //Configs
        CustomConfig.setup();
        List<String> comments = new ArrayList<String>();
        comments.add("Questo è il mondo dove si attiva il plugin");
        CreativeOnWorld.getPlugin(CreativeOnWorld.class).getConfig().setComments("CreativeWorld", comments);
        CreativeOnWorld.getPlugin(CreativeOnWorld.class).getConfig().addDefault("CreativeWorld", null);
        CreativeOnWorld.getPlugin(CreativeOnWorld.class).getConfig().options().copyDefaults(true);

        CreativeOnWorld.getPlugin(CreativeOnWorld.class).saveConfig();

        //Events
        getServer().getPluginManager().registerEvents(new ChangeWorldEvent(), this);



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
