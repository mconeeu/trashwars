package eu.mcone.trashwars.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.MainScoreboard;
import eu.mcone.gameapi.api.event.team.TeamWonEvent;
import eu.mcone.trashwars.TrashWars;
import eu.mcone.trashwars.objective.EndObjective;
import eu.mcone.trashwars.state.EndState;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class TeamWonListener implements Listener {

    @EventHandler
    public void on(TeamWonEvent e) {
        TrashWars.getInstance().getGameStateManager().setGameState(new EndState(), false);

        for (Player all : Bukkit.getOnlinePlayers()) {
            CorePlayer corePlayer =  CoreSystem.getInstance().getCorePlayer(all);
            corePlayer.setScoreboard(new MainScoreboard());
            corePlayer.getScoreboard().setNewObjective(new EndObjective());

            all.getInventory().clear();
            all.getInventory().setArmorContents(new ItemStack[0]);
            all.getActivePotionEffects().clear();
            all.playSound(all.getLocation(), Sound.FIREWORK_BLAST,1,1);
            TrashWars.getInstance().getMessager().send(all, "§7Team " + e.getTeam().getTeam().getPrefix() + " §7hat das Spiel gewonnen!");
            CoreSystem.getInstance().getWorldManager().getWorld(TrashWars.getInstance().getGameConfig().parseConfig().getLobby()).teleport(all, "spawn");
            all.playSound(all.getLocation(), Sound.ENDERDRAGON_DEATH, 1, 1);
        }
    }

}
