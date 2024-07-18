package lycoris.griefprotect;

import lycoris.griefprotect.commands.Exchange;
import lycoris.griefprotect.commands.PlayingTime;
import lycoris.griefprotect.events.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class GriefProtect extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new BlockInteract(), this);
        Bukkit.getPluginManager().registerEvents(new PlaceBlock(), this);
        Bukkit.getPluginManager().registerEvents(new LavaBucket(), this);
        Bukkit.getPluginManager().registerEvents(new PortalEvent(), this);
        this.getCommand("playingtime").setExecutor(new PlayingTime());
//        this.getCommand("exchange").setExecutor(new Exchange());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
