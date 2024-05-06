package com.ethanaxe;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class Ewelcome extends JavaPlugin implements org.bukkit.event.@NotNull Listener {


    static Ewelcome m;
    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("\033[33;1m欢迎使用\033[36;1;4mEthanAxe\033[0m\033[33;1m的\033[36;1;4mEwelcome\033[0m\033[33;1m插件！\033[0m");
        Bukkit.getPluginCommand("ewelcome").setExecutor(new commands());
        Bukkit.getPluginManager().registerEvents(new Listener(),this);
        Bukkit.getPluginCommand("ewelcome").setTabCompleter(new commands());


        saveDefaultConfig();
        m = this;
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            /*
             * We register the EventListener here, when PlaceholderAPI is installed.
             * Since all events are in the main class (this class), we simply use "this"
             */
            Bukkit.getPluginManager().registerEvents(this, this);
        } else {
            /*
             * We inform about the fact that PlaceholderAPI isn't installed and then
             * disable this plugin to prevent issues.
             */
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }

    }
    /*
       The identifier, shouldn't contain any _ or %
        */
    public String getIdentifier() {
        return "tutorial";
    }

    public String getPlugin() {
        return null;
    }


    /*
     The author of the Placeholder
     This cannot be null
     */
    public String getAuthor() {
        return "Banbeucmas";
    }

    /*
     Same with #getAuthor() but for versioon
     This cannot be null
     */

    public String getVersion() {
        return "SomeMagicalVersion";
    }

    /*
    Use this method to setup placeholders
    This is somewhat similar to EZPlaceholderhook
     */
    public String onPlaceholderRequest(Player player, String identifier) {
        /*
         %tutorial_onlines%
         Returns the number of online players
          */
        if(identifier.equalsIgnoreCase("onlines")){
            return String.valueOf(Bukkit.getOnlinePlayers().size());
        }

        /*
        Check if the player is online,
        You should do this before doing anything regarding players
         */
        if(player == null){
            return "";
        }

        /*
        %tutorial_name%
        Returns the player name
         */
        if(identifier.equalsIgnoreCase("name")){
            return player.getName();
        }


        return null;
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("\033[31;1m感谢使用\033[35;1;4mEthanAxe\033[0m\033[31;1m的\033[35;1;4mEwelcome\033[0m\033[31;1m插件！\033[0m");
        System.out.println("\033[35;1mbay~~\033[0m");
    }
}
