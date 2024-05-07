package com.ethanaxe.Listener;

import com.ethanaxe.Ewelcome;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void chat(AsyncPlayerChatEvent event) {
        //开关
        if (Ewelcome.m.getConfig().getBoolean("chatmsg.enabled",true)) {
            //获取玩家的聊天
            String msg = Ewelcome.m.getConfig().getString("chatmsg.chatmessage");
            String msg1 = event.getMessage();
            msg = msg.replace("$message$",msg1);
            //获得聊天玩家名变量:
            String player = Ewelcome.m.getConfig().getString("chatmsg.chatplayer");
            player = PlaceholderAPI.setPlaceholders(event.getPlayer(), player);
            //输出格式
            event.setFormat(player + msg);
        }
    }
}
