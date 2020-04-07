package eu.mcone.trashwars.listener;

import eu.mcone.trashwars.TrashWars;
import eu.mcone.trashwars.state.EndState;
import eu.mcone.trashwars.state.LobbyState;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class GeneralPlayerListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();

        if ((TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState
                || TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndState)
                && !player.getGameMode().equals(GameMode.CREATIVE)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onAchiewment(PlayerAchievementAwardedEvent e) {
        Player player = e.getPlayer();
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        Block block = e.getBlock();

        if ((TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState
                || TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndState)
                && !player.getGameMode().equals(GameMode.CREATIVE)) {
            e.setCancelled(true);
        } else if (block.getType().equals(Material.TNT)) {
            block.setType(Material.AIR);
            player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
            TNTPrimed tnt = player.getWorld().spawn(block.getLocation(), TNTPrimed.class);
            tnt.setFuseTicks(50);
        }
    }

    @EventHandler
    public void onTrigger(InventoryClickEvent e) {
        if ((TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState
                || TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndState)
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
                || TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndState) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        if (TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState
                || TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndState) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void on(PlayerItemDamageEvent e) {
        if (TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState ||
                TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndState) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }


    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if (TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState
                || TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndState) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }
}
