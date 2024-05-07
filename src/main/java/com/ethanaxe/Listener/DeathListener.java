package com.ethanaxe.Listener;

import com.ethanaxe.Ewelcome;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements org.bukkit.event.Listener{
    @EventHandler
    public void ps(PlayerDeathEvent event){
        if (Ewelcome.m.getConfig().getBoolean("death.enabled",true)){
            String msg = Ewelcome.m.getConfig().getString("death.deathmessage");
            msg = PlaceholderAPI.setPlaceholders(event.getPlayer(), msg);
            event.setDeathMessage(msg);
        }
        if (Ewelcome.m.getConfig().getBoolean("pos.enabled",true)){
            String msg = Ewelcome.m.getConfig().getString("pos.message");
            msg = PlaceholderAPI.setPlaceholders(event.getPlayer(),msg);
            Player p1 = event.getPlayer();
            p1.sendMessage(msg);
        }
    }
}
