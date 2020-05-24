package eu.mcone.trashwars.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.gameapi.api.event.player.GamePlayerLoadedEvent;
import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.gameapi.api.team.TeamManager;
import eu.mcone.trashwars.TrashWars;
import eu.mcone.trashwars.kit.Kit;
import eu.mcone.trashwars.state.LobbyState;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffectType;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void on(GamePlayerLoadedEvent e) {
        Player player = e.getBukkitPlayer();
        GamePlayer gamePlayer = e.getPlayer();

        gamePlayer.setKit(Kit.DEFAULT);

        player.setGameMode(GameMode.SURVIVAL);

        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setLevel(0);
        player.setExp(0);
        player.removePotionEffect(PotionEffectType.SLOW);

        player.getInventory().setItem(8, InventoryTriggerListener.QUIT_ITEM);
        player.getInventory().setItem(6, InventoryTriggerListener.KITS);

        if (TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState) {
            player.getInventory().setItem(7, TeamManager.TEAM);
            player.getInventory().setItem(5, new ItemBuilder(Material.STORAGE_MINECART, 1, 0).displayName("§3§lRucksack §8» §7§oZeige deine gesammelten Items an").create());
            CoreSystem.getInstance().getWorldManager().getWorld(TrashWars.getInstance().getGameConfig().parseConfig().getLobby()).teleport(player, "spawn");
        }
    }
}
