package eu.mcone.trashwars.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.gameapi.api.player.PlayerManager;
import eu.mcone.trashwars.TrashWars;
import eu.mcone.trashwars.state.EndState;
import eu.mcone.trashwars.state.LobbyState;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        e.setDeathMessage(null);
        Player player = e.getEntity().getPlayer();
        Player killer = (player.getKiller() != null ? player.getKiller() : TrashWars.getInstance().getDamageLogger().getKiller(player));

        player.getInventory().clear();
        player.getInventory().setArmorContents(new ItemStack[0]);

        if (TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState
                || TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndState) {
            CoreSystem.getInstance().getWorldManager().getWorld(TrashWars.getInstance().getGameConfig().parseConfig().getLobby()).teleport(player, "spawn");
        } else {
            GamePlayer gamePlayer = TrashWars.getInstance().getGamePlayer(player);
            gamePlayer.addDeaths(1);

            if (killer != null) {
                GamePlayer gameKiller = TrashWars.getInstance().getGamePlayer(killer);
                gameKiller.addKills(1);
                killer.addPotionEffect(PotionEffectType.REGENERATION.createEffect(55, 3));
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
                player.playEffect(player.getLocation(), Effect.INSTANT_SPELL, 1);
            } else {
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
            }

            player.getInventory().setArmorContents(null);
            player.getInventory().clear();

            player.getInventory().setItem(7, PlayerManager.SPECTATOR);
            player.getInventory().setItem(8, InventoryTriggerListener.QUIT_ITEM);

            CoreSystem.getInstance().createActionBar()
                    .message("§c§oDu bist gestorben")
                    .send(player);

            for (CorePlayer all : CoreSystem.getInstance().getOnlineCorePlayers()) {
                all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
            }
        }

        player.spigot().respawn();
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();
        if (TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState
                || TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndState) {
            e.setRespawnLocation(CoreSystem.getInstance().getWorldManager().getWorld(TrashWars.getInstance().getGameConfig().parseConfig().getLobby()).getLocation("spawn"));
        } else {
            e.setRespawnLocation(CoreSystem.getInstance().getWorldManager().getWorld(TrashWars.getInstance().getGameConfig().parseConfig().getGameWorld()).getLocation("game.spectator"));
        }
    }
}
