package lycoris.griefprotect.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Exchange implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (player.getInventory().getItemInMainHand().equals(new ItemStack(Material.DIAMOND, 7))) {
            player.getInventory().setItemInMainHand(new ItemStack(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 1));
        } else {
            player.sendMessage(ChatColor.RED + "Возьмите в руку " + ChatColor.GOLD + "7 " + ChatColor.RED + "алмазов, чтобы обменять на Незертиовое Улучшение");
        }

        return false;
    }
}
