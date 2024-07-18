package lycoris.griefprotect.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceBlock implements Listener {

    @EventHandler
    public static void PlaceBlock(BlockPlaceEvent event) {
        if (!event.getPlayer().hasPermission("ag.bypass")) {
            if (event.getBlockPlaced().getType().equals(Material.TNT) && !event.getPlayer().getName().equals("Ekran1al")) {
                if (event.getPlayer().getStatistic(Statistic.PLAY_ONE_MINUTE) < 288000) {
                    event.getPlayer().sendMessage(ChatColor.RED + "Чтобы поставить динамит, вам нужно наиграть 4 часа");
                    event.setCancelled(true);
                }
            } else if (event.getBlockPlaced().getType().equals(Material.POLISHED_BLACKSTONE_SLAB) && !event.getPlayer().getName().equals("Ekran1al")) {
                if (event.getPlayer().getStatistic(Statistic.PLAY_ONE_MINUTE) < 288000) {
                    event.getPlayer().sendMessage(ChatColor.RED + "Чтобы поставить этот блок, вам нужно наиграть 4 часа");
                    event.setCancelled(true);
                }
            } else if (event.getBlockPlaced().getType().equals(Material.FIRE) && !event.getPlayer().getName().equals("Ekran1al")) {
                if (event.getPlayer().getStatistic(Statistic.PLAY_ONE_MINUTE) < 288000) {
                    int x = event.getBlockPlaced().getX();
                    int y = event.getBlockPlaced().getY();
                    int z = event.getBlockPlaced().getZ();

                    if (!event.getBlockPlaced().getWorld().getBlockAt(x, y - 1, z).getType().equals(Material.OBSIDIAN)) {
                        event.getPlayer().sendMessage(ChatColor.RED + "Чтобы поджечь что-то кроме портала в ад, вам нужно наиграть 4 часа");
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
