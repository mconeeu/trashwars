package eu.mcone.trashwars.objective;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjectiveEntry;
import org.bukkit.Bukkit;

public class LobbyObjective extends eu.mcone.gameapi.api.scoreboard.LobbyObjective {

    @Override
    protected void onLobbyRegister(CorePlayer corePlayer, CoreSidebarObjectiveEntry entry) {
        setDisplayName("§7§l⚔ §a§l§nTrashwars");

        entry.setScore(3, "");
        entry.setScore(2, "§8» §7Wartende Spieler:");
        onReload(corePlayer, entry);
    }

    @Override
    protected void onLobbyReload(CorePlayer corePlayer, CoreSidebarObjectiveEntry entry) {
        entry.setScore(1, "§f  " + Bukkit.getOnlinePlayers().size());
    }
}
