package eu.mcone.trashwars.state;

import eu.mcone.coresystem.api.bukkit.CorePlugin;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.gameapi.api.event.gamestate.GameStateStopEvent;
import eu.mcone.gameapi.api.gamestate.common.LobbyGameState;
import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.gameapi.api.player.GamePlayerState;
import eu.mcone.trashwars.TrashWars;
import eu.mcone.trashwars.kit.Kit;
import eu.mcone.trashwars.objective.InGameObjective;
import eu.mcone.trashwars.objective.LobbyObjective;
import org.bukkit.entity.Player;

public class LobbyState extends LobbyGameState {

    static {
        setObjective(LobbyObjective.class);
    }

    @Override
    public void onStop(GameStateStopEvent event) {
        for (Player player : TrashWars.getInstance().getPlayerManager().getPlayers(GamePlayerState.PLAYING)) {

            GamePlayer gamePlayer = TrashWars.getInstance().getGamePlayer(player);
            CorePlayer corePlayer = CoreSystem.getInstance().getCorePlayer(player.getUniqueId());
            player.teleport(TrashWars.getInstance().getGameWorld().getLocation(gamePlayer.getTeam().getSpawnLocation()));
            player.getInventory().clear();

            if (gamePlayer.getCurrentKit().equals(Kit.DEFAULT)) {
                gamePlayer.setKit(Kit.DEFAULT);
            } else if (gamePlayer.getCurrentKit().equals(Kit.FAULTIER)) {
                gamePlayer.setKit(Kit.FAULTIER);
            } else if (gamePlayer.getCurrentKit().equals(Kit.ASSASINE)) {
                gamePlayer.setKit(Kit.ASSASINE);
            } else if (gamePlayer.getCurrentKit().equals(Kit.FISHER)) {
                gamePlayer.setKit(Kit.FISHER);
            }

            corePlayer.getScoreboard().setNewObjective(new InGameObjective());
        }
    }

    @Override
    public void onCountdownSecond(CorePlugin plugin, int second) {
        super.onCountdownSecond(plugin, second);

        if (second == 5) {
            TrashWars.getInstance().getTeamManager().setTeamsForRemainingPlayersBalanced();
        }
    }
}