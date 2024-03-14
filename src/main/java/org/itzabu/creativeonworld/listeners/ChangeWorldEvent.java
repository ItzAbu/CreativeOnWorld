package org.itzabu.creativeonworld.listeners;

import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.itzabu.creativeonworld.CreativeOnWorld;
import org.itzabu.creativeonworld.utils.CustomConfig;
import org.itzabu.creativeonworld.utils.InvUtils.InvSave;

import java.io.File;

public class ChangeWorldEvent implements Listener {


    void onWorldChange(PlayerChangedWorldEvent e) {
        String world = CustomConfig.getSaveFileConfig().getString("CreativeWorld");
        if(world == null) {
            return;
        }
        World creativeworld = CreativeOnWorld.getPlugin(CreativeOnWorld.class).getServer().getWorld(world);
        if(e.getPlayer().getWorld() != creativeworld) {

            File file = new File("plugins/CreativeOnWorld/" + e.getPlayer().getUniqueId() + ".yml");
            if(file.exists()) {
                InvSave.getInv(e.getPlayer());
            }

            return;
        }

        InvSave.saveInventory(e.getPlayer());
        e.getPlayer().setGameMode(GameMode.CREATIVE);

    }

    void onJoinEvent(PlayerChangedWorldEvent e) {
        String world = CustomConfig.getSaveFileConfig().getString("CreativeWorld");
        if(world == null) {
            return;
        }
        File file = new File("plugins/CreativeOnWorld/" + e.getPlayer().getUniqueId() + ".yml");
        if(file.exists()) {
            InvSave.getInv(e.getPlayer());
        }
        return;
    }

}
