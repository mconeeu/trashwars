package eu.mcone.trashwars.objective;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.Bukkit;

public class LobbyObjective extends eu.mcone.gameapi.api.scoreboard.LobbyObjective {

    public LobbyObjective() {
        super("Trashwars");
    }


    @Override
    protected void onRegister(CorePlayer corePlayer) {
        setDisplayName("§7§l⚔ §a§l§nTrashwars");

        setScore(3, "");
        setScore(2, "§8» §7Wartende Spieler:");
        onReload(corePlayer);
    }

    @Override
    protected void onReload(CorePlayer corePlayer) {
        setScore(1, "§f  " + Bukkit.getOnlinePlayers().size());
    }

}
