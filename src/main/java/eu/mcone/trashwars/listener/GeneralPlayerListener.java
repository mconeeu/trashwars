package eu.mcone.trashwars.listener;

import eu.mcone.gameapi.api.gamestate.common.EndGameState;
import eu.mcone.trashwars.TrashWars;
import eu.mcone.trashwars.state.LobbyState;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class GeneralPlayerListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();

        if ((TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState
                || TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndGameState)
                && !player.getGameMode().equals(GameMode.CREATIVE)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player player = e.getPlayer();

        if ((TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState
                || TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndGameState)
                && !player.getGameMode().equals(GameMode.CREATIVE)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onTrigger(InventoryClickEvent e) {
        if ((TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState
                || TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndGameState)
                && !e.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        if (e.toWeatherState())
            e.setCancelled(true);
    }

    @EventHandler
    public void onItemPickUp(PlayerPickupItemEvent e) {
        if (TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState
                || TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndGameState) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        if (TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState
                || TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndGameState) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void on(PlayerItemDamageEvent e) {
        if (TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState ||
                TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndGameState) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }


    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if (TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState
                || TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndGameState) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }
}
