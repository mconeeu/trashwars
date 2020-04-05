package eu.mcone.trashwars.state;

import eu.mcone.coresystem.api.bukkit.CorePlugin;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.gameapi.api.event.gamestate.GameStateStopEvent;
import eu.mcone.gameapi.api.gamestate.common.LobbyGameState;
import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.gameapi.api.team.TeamTablist;
import eu.mcone.trashwars.TrashWars;
import eu.mcone.trashwars.objective.InGameObjective;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class LobbyState extends LobbyGameState {

    @Override
    public void onStop(GameStateStopEvent event) {
        for (Player player : TrashWars.getInstance().getPlayerManager().getPlaying()) {
            GamePlayer gamePlayer = TrashWars.getInstance().getGamePlayer(player);
            CorePlayer corePlayer = CoreSystem.getInstance().getCorePlayer(player.getUniqueId());
            player.teleport(TrashWars.getInstance().getGameWorld().getLocation(gamePlayer.getTeam().getSpawnLocation()));
            corePlayer.setScoreboard(new TeamTablist());
            corePlayer.getScoreboard().setNewObjective(new InGameObjective());







           }
    }

    @Override
    public void onCountdownSecond(CorePlugin plugin, int second) {
        super.onCountdownSecond(plugin, second);

        if (second == 5) {
            TrashWars.getInstance().getTeamManager().setupTeam();
        }
    }
}