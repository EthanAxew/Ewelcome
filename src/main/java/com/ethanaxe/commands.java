package com.ethanaxe;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class commands implements CommandExecutor , TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] arges) {
        String a1 = arges[0];
        if (a1.equals("help")){
            Player p1 = (Player) sender;
            p1.sendMessage(ChatColor.YELLOW + "----Ewelcome帮助菜单----");
            p1.sendMessage(ChatColor.WHITE + "/ewe help" + ChatColor.RED + "  插件帮助");
            p1.sendMessage(ChatColor.WHITE + "/ewe reload" + ChatColor.RED + "  重载插件");
            p1.sendMessage(ChatColor.YELLOW + "-------------------------------");


        }
        if (a1.equals("reload")){
            Ewelcome.m.reloadConfig();
            Player p1 = (Player) sender;
            p1.sendMessage(ChatColor.WHITE + "[" + ChatColor.AQUA + "EWE" +  ChatColor.WHITE + "]" + ChatColor.GOLD + "插件重载成功！");
            return true;


        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] arges) {
        if(arges.length ==1){
            List<String> list = new ArrayList<>();
            list.add("help");
            list.add("reload");
            return list;
        }

        return null;
    }
}
