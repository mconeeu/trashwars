package eu.mcone.trashwars.objective;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjective;
import eu.mcone.trashwars.TrashWars;
import eu.mcone.trashwars.state.LobbyState;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;

public class LobbyObjective extends CoreSidebarObjective {

    private static int i = 0;

    public LobbyObjective() {
        super("Trashwars");
    }

    public static void updateLines() {
        if (TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState) {
            if (i >= 4) i = 0;
            i++;
            for (final CorePlayer p : CoreSystem.getInstance().getOnlineCorePlayers()) {
                final CoreSidebarObjective o = (CoreSidebarObjective) p.getScoreboard().getObjective(DisplaySlot.SIDEBAR);
                if (o != null) {
                    if (o instanceof LobbyObjective) {
                        o.setDisplayName("§7§l⚔ §a§l§nTrashwars");

                    }

                    if (i == 1) {
                        o.setScore(1, "§8»§7 Teamspeak:");
                        o.setScore(0, "  §f§ots.mcone.eu");
                    } else if (i == 2) {
                        o.setScore(1, "§8»§7 Website:");
                        o.setScore(0, "  §f§omcone.eu");
                    } else if (i == 3) {
                        o.setScore(1, "§8»§7 Twitter:");
                        o.setScore(0, "  §b§o@mconeeu");
                    } else if (i == 4) {
                        o.setScore(1, "§8»§7 YouTube:");
                        o.setScore(0, "  §c§oyt.mcone.eu");
                    } else {
                        o.setScore(1, "§8»§7 Teamspeak:");
                        o.setScore(0, "  §f§ots.mcone.eu");
                    }
                }
            }
        }

    }

    @Override
    protected void onRegister(CorePlayer corePlayer) {
        setDisplayName("§7§l⚔ §a§l§nTrashwars");

        setScore(5, "");
        setScore(4, "§8» §7Wartende Spieler:");
        onReload(corePlayer);
        setScore(2, "");
        setScore(1, "§8»§7 Teamspeak:");
        setScore(0, "  §f§ots.mcone.eu");
    }

    @Override
    protected void onReload(CorePlayer corePlayer) {
        setScore(3, "§f  " + Bukkit.getOnlinePlayers().size());

    }


}
