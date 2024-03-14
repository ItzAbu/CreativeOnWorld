package org.itzabu.creativeonworld.utils;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class CustomConfig {

    private static File saveFile;
    private static FileConfiguration saveFileConfig;


    public static void setup() {
        saveFile = new File("plugins/CreativeOnWorld/saveFile.yml");
        saveFileConfig = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(saveFile);
    }


    public static FileConfiguration getSaveFileConfig() {
        return saveFileConfig;
    }



    public static void saveSaveFileConfig() {
        try {
            saveFileConfig.save(saveFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reload() {
        saveFileConfig = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(saveFile);
    }

}
