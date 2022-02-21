package cn.zry551.zxjemsg.Event;

import cn.zry551.zxjemsg.Data;
import cn.zry551.zxjemsg.Strings;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.jetbrains.annotations.NotNull;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

import java.net.InetAddress;

public class PlayerLogin implements Listener {
    @EventHandler
    public void Login(PlayerJoinEvent e){
        try {
            //InetAddress RIP = e.getRealAddress();
            Player P = e.getPlayer();
            if (Data.Use) {
                String RD = Data.JoinFormat.replaceAll("&&", "#LX");
                RD = RD.replaceAll("&", Strings.CC);
                RD = RD.replaceAll("#LX", "&");
                RD = RD.replaceAll("#UN", P.getName());
                e.setJoinMessage(RD);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
