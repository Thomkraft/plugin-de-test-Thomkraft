package fr.thomkraftXphilou.pluginmc;

import fr.thomkraftXphilou.pluginmc.commands.commands;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
 // É  È
    @Override
    public void onEnable() { //§2vert §9bleu
        Bukkit.getConsoleSender().sendMessage(
                   "\n§9 ÉÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍ»\n" +
                        "§9 º§2 Le Plugin PVP c'est bien allume  ! §9º\n" +
                        "§9 ÈÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍ¼"
                );
        getCommand("test").setExecutor(new commands());
        getCommand("alert").setExecutor(new commands());
        getCommand("kit").setExecutor(new commands());
        getServer().getPluginManager().registerEvents(new monpluginlisterners(), this);
    }
    

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage(
                   "\n§9 ÉÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍ»\n" +
                        "§9 º§4     le Plugin PVP c'est eteint     §9º\n" +
                        "§9 ÈÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍ¼"
        );
    }

}

