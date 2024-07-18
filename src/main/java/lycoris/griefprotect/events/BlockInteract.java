package lycoris.griefprotect.events;

import net.coreprotect.CoreProtect;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class BlockInteract implements Listener {

    @EventHandler
    public static void Chest(PlayerInteractEvent event) {
//        if (event.getPlayer().getName().equals("Ekran1al")) {
//            ArrayList<String[]> data = (ArrayList<String[]>) CoreProtect.getInstance().getAPI().blockLookup(event.getClickedBlock(), 999999999);
//            for (String[] i : data) {
//                if (i[1].equals("fyty") ) {
//                    System.out.println(Arrays.toString(i));
//                }
//            }
//        }


        if (!event.getPlayer().hasPermission("ag.bypass")) {
            if (event.getPlayer().getStatistic(Statistic.PLAY_ONE_MINUTE) < 288000) {
                if (event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    int x = event.getClickedBlock().getX();
                    int y = event.getClickedBlock().getY();
                    int z = event.getClickedBlock().getZ();

                    if (event.getClickedBlock().getWorld().getBlockAt(x, y + 1, z).getType().equals(Material.POLISHED_BLACKSTONE_SLAB))
                        return;

                    if (event.getClickedBlock().getType().equals(Material.CHEST)) {
                        ArrayList<String[]> data = (ArrayList<String[]>) CoreProtect.getInstance().getAPI().blockLookup(event.getClickedBlock(), 999999999);
                        boolean can_break = false;
                        if (data.isEmpty()) can_break = true;
                        else {
                            for (String[] i : data) {
                                if (i[1].equals(event.getPlayer().getName())) {
//                                event.getPlayer().sendMessage(Arrays.toString(i));
                                    can_break = true;
                                    break;
                                }
                            }
                        }

                        if (can_break) {
//                        event.getPlayer().sendMessage(ChatColor.GREEN + "Блок может быть изменён, вам нужно наиграть 12 часов");
                            event.setCancelled(false);
                        } else {
                            event.getPlayer().sendMessage(ChatColor.RED + "Блок не может быть изменён, вам нужно наиграть 4 часа");
                            event.setCancelled(true);
                        }
                    }
                }
            }
        }
    }
}
