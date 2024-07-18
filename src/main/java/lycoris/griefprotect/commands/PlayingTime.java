package lycoris.griefprotect.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayingTime implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        int time_seconds = ((Player) commandSender).getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;
        int h = time_seconds / 3600;
        time_seconds %= 3600;
        int m = time_seconds / 60;
        time_seconds %= 60;
        commandSender.sendMessage(ChatColor.GREEN + "Вы наиграли " + h + "ч " + m + "мин " + time_seconds + "с");

//        if (commandSender.getName().equals("Ekran1al")) {
//            ((Player) commandSender).teleport(new Location(Bukkit.getWorld("world_the_end"), 0, 100, 0));
//        }

        return false;
    }
}
