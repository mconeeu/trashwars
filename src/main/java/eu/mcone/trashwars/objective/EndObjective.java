package eu.mcone.trashwars.objective;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjectiveEntry;
import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.gameapi.api.scoreboard.LobbyObjective;
import eu.mcone.trashwars.TrashWars;

public class EndObjective extends LobbyObjective {
    @Override
    protected void onLobbyRegister(CorePlayer corePlayer, CoreSidebarObjectiveEntry entry) {
        GamePlayer gamePlayer = TrashWars.getInstance().getGamePlayer(corePlayer.getUuid());
        entry.setTitle("§7§l⚔ §a§l§nTrashwars");

        entry.setScore(6, "");
        entry.setScore(5, "§8» §7Team:");
        entry.setScore(4, "   §f§l" + gamePlayer.getTeam().getLabel());
        entry.setScore(3, "");
        entry.setScore(2, "§8» §7Kills:");
        onReload(corePlayer, entry);
    }

    @Override
    protected void onLobbyReload(CorePlayer corePlayer, CoreSidebarObjectiveEntry entry) {
        GamePlayer gamePlayer = TrashWars.getInstance().getGamePlayer(corePlayer.getUuid());
        entry.setScore(1, "   §f§l" + gamePlayer.getRoundKills());
    }
}

