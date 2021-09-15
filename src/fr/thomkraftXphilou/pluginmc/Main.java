package fr.thomkraftXphilou.pluginmc;

import fr.thomkraftXphilou.pluginmc.commands.commands;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("");
        System.out.println("Le Plugin PVP est bien allumer !");
        System.out.println("");
        getCommand("test").setExecutor(new commands());
        getCommand("alert").setExecutor(new commands());
        getCommand("kit").setExecutor(new commands());
        getServer().getPluginManager().registerEvents(new monpluginlisterners(), this);
    }
    

    @Override
    public void onDisable() {
        
        System.out.println("le Plugin PVP c'est eteint");
    }

}

