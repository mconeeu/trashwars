package eu.mcone.trashwars.objective;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjectiveEntry;
import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.gameapi.api.player.GamePlayerState;
import eu.mcone.trashwars.TrashWars;

public class InGameObjective extends eu.mcone.gameapi.api.scoreboard.InGameObjective {

    @Override
    protected void onInGameRegister(CorePlayer corePlayer, CoreSidebarObjectiveEntry entry) {
        GamePlayer gamePlayer = TrashWars.getInstance().getGamePlayer(corePlayer.getUuid());
        entry.setTitle("§7§l⚔ §a§l§nTrashwars");

        onReload(corePlayer, entry);

        entry.setScore(12, "");
        entry.setScore(11, "§8» §7Team:");
        entry.setScore(10, "   §f§l" + gamePlayer.getTeam().getLabel());
        entry.setScore(9, "");
        entry.setScore(8, "§8» §7Lebene Spieler:");
        entry.setScore(6, "");
        entry.setScore(5, "§8» §7Kills:");
        entry.setScore(3, "");
        entry.setScore(2, "§8» §7Kit:");
        entry.setScore(1, "   §f§l" + gamePlayer.getCurrentKit().getName());
    }

    @Override
    protected void onInGameReload(CorePlayer corePlayer, CoreSidebarObjectiveEntry entry) {
        GamePlayer gamePlayer = TrashWars.getInstance().getGamePlayer(corePlayer.getUuid());
        entry.setScore(4, "   §f§l" + gamePlayer.getRoundKills());
        entry.setScore(7, "   §f§l" + TrashWars.getInstance().getPlayerManager().getPlayers(GamePlayerState.PLAYING).size());
    }
}
