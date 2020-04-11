package eu.mcone.trashwars.objective;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjective;
import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.gameapi.api.scoreboard.EndGameObjective;
import eu.mcone.trashwars.TrashWars;

public class EndObjective extends EndGameObjective {

    public EndObjective() {
        super("Trashwars");
    }

    @Override
    protected void onRegister(CorePlayer corePlayer) {
        GamePlayer gamePlayer = TrashWars.getInstance().getGamePlayer(corePlayer.getUuid());
        setDisplayName("§7§l⚔ §a§l§nTrashwars");

        setScore(6, "");
        setScore(5, "§8➥ §7Team:");
        setScore(4, "   §f§l" + gamePlayer.getTeam().getTeam().getPrefix());
        setScore(3, "");
        setScore(2, "§8➥ §7Kills:");
        onReload(corePlayer);
    }

    @Override
    protected void onReload(CorePlayer corePlayer) {
        GamePlayer gamePlayer = TrashWars.getInstance().getGamePlayer(corePlayer.getUuid());
        setScore(1, "   §f§l" + gamePlayer.getRoundKills());
    }
}

