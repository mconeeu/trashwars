package eu.mcone.trashwars.objective;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjective;
import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.trashwars.TrashWars;

public class EndObjective extends CoreSidebarObjective {

    public EndObjective() {
        super("Trashwars");
    }

    @Override
    protected void onRegister(CorePlayer corePlayer) {
        GamePlayer gamePlayer = TrashWars.getInstance().getGamePlayer(corePlayer.getUuid());
        setDisplayName("§7§l⚔ §a§l§nTrashwars");

        setScore(10, "");
        setScore(9, "§8» §7Team:");
        setScore(8, "   §f§l" + gamePlayer.getTeam().getTeam().getPrefix());
        setScore(7, "");
        setScore(6, "§8» §7Kills:");
        setScore(5, "   §f§l" + gamePlayer.getRoundKills());
        setScore(4, "");
        setScore(3, "§8» §7Lebene Spieler:");
        setScore(2, "   §f§l" + TrashWars.getInstance().getPlayerManager().getPlaying().size());
        setScore(1, "");
        setScore(0, " §c§lMCONE.EU");
    }

    @Override
    protected void onReload(CorePlayer corePlayer) {
        GamePlayer gamePlayer = TrashWars.getInstance().getGamePlayer(corePlayer.getUuid());
        setScore(5, "   §f§l" + gamePlayer.getRoundKills());
        setScore(2, "   §f§l" + TrashWars.getInstance().getPlayerManager().getPlaying().size());
    }
}

