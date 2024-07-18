package lycoris.griefprotect.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PortalEvent implements Listener {

    @EventHandler
    public static void portal(PlayerTeleportEvent event) {
//        if (event.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL) {
//            event.getPlayer().sendMessage(ChatColor.RED + "Энд закрыт!");
//            event.setCancelled(true);
//
//        }
    }
}
