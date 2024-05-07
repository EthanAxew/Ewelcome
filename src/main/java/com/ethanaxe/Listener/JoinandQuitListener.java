package com.ethanaxe.Listener;

import com.ethanaxe.Ewelcome;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinandQuitListener implements org.bukkit.event.Listener {
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

}
