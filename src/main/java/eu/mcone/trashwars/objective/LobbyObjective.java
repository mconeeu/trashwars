package eu.mcone.trashwars.objective;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjective;
import eu.mcone.trashwars.TrashWars;
import eu.mcone.trashwars.state.LobbyState;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;

public class LobbyObjective extends CoreSidebarObjective {

    public LobbyObjective() {
        super("Trashwars");
    }


    @Override
    protected void onRegister(CorePlayer corePlayer) {
        setDisplayName("§7§l⚔ §a§l§nTrashwars");

        setScore(4, "");
        setScore(3, "§8» §7Wartende Spieler:");
        onReload(corePlayer);
        setScore(1, "");
        setScore(0, " §f§lMCONE.EU");
    }

    @Override
    protected void onReload(CorePlayer corePlayer) {
        setScore(2, "§f  " + Bukkit.getOnlinePlayers().size());
    }


}
