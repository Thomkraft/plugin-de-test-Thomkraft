package fr.thomkraftXphilou.pluginmc;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class monpluginlisterners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        //player.getInventory().clear();


        player.updateInventory();



    }

}
