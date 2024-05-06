package com.ethanaxe;

import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.BlockNBTComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listener implements org.bukkit.event.Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void pj(PlayerJoinEvent event) {
        if (Ewelcome.m.getConfig().getBoolean("joinmsg.enabled" , true)) {
            String msg = Ewelcome.m.getConfig().getString("joinmsg.joinMessage");
            msg = PlaceholderAPI.setPlaceholders(event.getPlayer(), msg);
            event.setJoinMessage(msg);
        }
    }
    @EventHandler
    public void pq(PlayerQuitEvent event) {
        if (Ewelcome.m.getConfig().getBoolean("quitmsg.enabled" , true)) {
            String msg = Ewelcome.m.getConfig().getString("quitmsg.quitMessage");
            msg = PlaceholderAPI.setPlaceholders(event.getPlayer(), msg);
            event.setQuitMessage(msg);
        }
    }
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

