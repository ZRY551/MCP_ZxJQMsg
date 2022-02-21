package cn.zry551.zxjemsg.Event;

import cn.zry551.zxjemsg.Data;
import cn.zry551.zxjemsg.Strings;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerExit  implements Listener {
    @EventHandler
    public void Login(PlayerQuitEvent e){
        try {
            //InetAddress RIP = e.getRealAddress();
            Player P = e.getPlayer();
            if (Data.Use) {
                String RD = Data.QuitFormat.replaceAll("&&", "#LX");
                RD = RD.replaceAll("&", Strings.CC);
                RD = RD.replaceAll("#LX", "&");
                RD = RD.replaceAll("#UN", P.getName());
                e.setQuitMessage(RD);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
