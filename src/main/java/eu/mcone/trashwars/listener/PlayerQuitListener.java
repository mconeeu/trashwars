package eu.mcone.trashwars.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.gameapi.api.event.player.GamePlayerUnloadEvent;
import eu.mcone.trashwars.TrashWars;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.messaging.PluginMessageListenerRegistration;
import org.bukkit.scoreboard.DisplaySlot;

public class PlayerQuitListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onQuit(GamePlayerUnloadEvent e) {
        Bukkit.getScheduler().runTask(TrashWars.getInstance(), () -> {
            for (CorePlayer all : CoreSystem.getInstance().getOnlineCorePlayers()) {
                if (!all.equals(e.getCorePlayer()))
                    all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
            }
        });
    }
}
