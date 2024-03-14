package org.itzabu.creativeonworld.utils.InvUtils;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.itzabu.creativeonworld.utils.CustomConfig;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class InvSave {



public static void saveInventory(Player p) {
    Inventory inv = p.getInventory();
    File file = new File("plugins/CreativeOnWorld/" + p.getUniqueId() + ".yml");
    FileConfiguration config = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(file);
    config.set("inv", inv.getContents());
    try {
        config.save(file);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void getInv(Player p) {
    Inventory inv = p.getInventory();
    File file = new File("plugins/CreativeOnWorld/" + p.getUniqueId() + ".yml");
    FileConfiguration config = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(file);
    ItemStack[] items = ((ArrayList<ItemStack>) config.get("inv")).toArray(new ItemStack[0]);
    inv.setContents(items);
    if(file.delete()) {
        System.out.println("Inv ritornato con successo . " + p.getName());
    } else {
        System.out.println("ERRORE");
    }
}

}


