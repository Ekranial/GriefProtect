package lycoris.griefprotect.events;

import io.papermc.paper.block.fluid.FluidData;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.jetbrains.annotations.NotNull;

import javax.swing.plaf.synth.Region;

public class LavaBucket implements Listener {

    public static boolean water_around(Location location) {
        World world = location.getWorld();
        int x = (int) location.getX();
        int y = (int) location.getY();
        int z = (int) location.getZ();
        if (Bukkit.getWorld(world.getUID()).getFluidData(x + 1, y, z).getFluidType().equals(Fluid.WATER) || Bukkit.getWorld(world.getUID()).getFluidData(x + 1, y, z).getFluidType().equals(Fluid.FLOWING_WATER)) {
            return true;
        }
        if (Bukkit.getWorld(world.getUID()).getFluidData(x - 1, y, z).getFluidType().equals(Fluid.WATER) || Bukkit.getWorld(world.getUID()).getFluidData(x - 1, y, z).getFluidType().equals(Fluid.FLOWING_WATER)) {
            return true;
        }
        if (Bukkit.getWorld(world.getUID()).getFluidData(x, y, z + 1).getFluidType().equals(Fluid.WATER) || Bukkit.getWorld(world.getUID()).getFluidData(x, y, z + 1).getFluidType().equals(Fluid.FLOWING_WATER)) {
            return true;
        }
        if (Bukkit.getWorld(world.getUID()).getFluidData(x, y, z - 1).getFluidType().equals(Fluid.WATER) || Bukkit.getWorld(world.getUID()).getFluidData(x + 1, y, z - 1).getFluidType().equals(Fluid.FLOWING_WATER)) {
            return true;
        }
        if (Bukkit.getWorld(world.getUID()).getFluidData(x, y - 1, z).getFluidType().equals(Fluid.WATER) || Bukkit.getWorld(world.getUID()).getFluidData(x, y - 1, z).getFluidType().equals(Fluid.FLOWING_WATER)) {
            return true;
        }

        return false;

    }

    @EventHandler
    public static void LavaBucket(PlayerBucketEmptyEvent event) {
        if (!event.getPlayer().hasPermission("ag.bypass")) {
            if (!water_around(event.getBlock().getLocation())) {
                if (event.getBucket().equals(Material.LAVA_BUCKET) && !event.getPlayer().getName().equals("Ekran1al")) {
                    System.out.println(event.getBlockClicked().getLocation());
                    if (event.getPlayer().getStatistic(Statistic.PLAY_ONE_MINUTE) < 288000) {
                        event.getPlayer().sendMessage(ChatColor.RED + "Чтобы вылить лаву, вам нужно наиграть 4 часа");
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

}