package eu.mcone.trashwars.state;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.gameapi.api.event.gamestate.GameStateStartEvent;
import eu.mcone.gameapi.api.event.gamestate.GameStateStopEvent;
import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.gameapi.api.player.PlayerManager;
import eu.mcone.gameapi.api.team.TeamManager;
import eu.mcone.trashwars.TrashWars;
import eu.mcone.trashwars.inventorys.TrashInventory;
import eu.mcone.trashwars.item.TrashItem;
import eu.mcone.trashwars.kit.Kit;
import eu.mcone.trashwars.listener.InventoryTriggerListener;
import eu.mcone.trashwars.objective.LobbyObjective;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;

public class InGameState extends eu.mcone.gameapi.api.gamestate.common.InGameState {


    @Override
    public void onStart(GameStateStartEvent event) {
        Bukkit.getScheduler().runTaskLater(TrashWars.getInstance(), () -> {
            for (GamePlayer gamePlayer : TrashWars.getInstance().getOnlineGamePlayers()) {
                Player player = gamePlayer.bukkit();
                int time = (gamePlayer.getCurrentKit().equals(Kit.FAULTIER) ? 50 : 40);

                if (gamePlayer.getCurrentKit().equals(Kit.FAULTIER)) {
                    run(player, time);
                } else {
                    CoreSystem.getInstance().createTitle().fadeIn(1).fadeOut(1).title("§a3").subTitle(null).stay(2).send(player);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 2), true);
                    Bukkit.getScheduler().runTaskLater(TrashWars.getInstance(), () -> {
                        CoreSystem.getInstance().createTitle().fadeIn(1).fadeOut(1).title("§a2").subTitle(null).stay(2).send(player);

                        Bukkit.getScheduler().runTaskLater(TrashWars.getInstance(), () -> {
                            CoreSystem.getInstance().createTitle().fadeIn(1).fadeOut(1).title("§a1").subTitle(null).stay(1).send(player);
                            Bukkit.getScheduler().runTaskLater(TrashWars.getInstance(), () -> {
                                run(player, time);
                            }, 20);

                        }, 20);
                    }, 20);
                }
            }
        }, 20);

    }

    private void run(Player player, int time) {
        new TrashInventory(player);
        Bukkit.getScheduler().runTaskLater(TrashWars.getInstance(), () -> {
            new TrashInventory(player);
            Bukkit.getScheduler().runTaskLater(TrashWars.getInstance(), () -> {
                new TrashInventory(player);
                Bukkit.getScheduler().runTaskLater(TrashWars.getInstance(), () -> {
                    new TrashInventory(player);
                    Bukkit.getScheduler().runTaskLater(TrashWars.getInstance(), () -> {
                        new TrashInventory(player);

                        Bukkit.getScheduler().runTaskLater(TrashWars.getInstance(), () -> {
                            player.closeInventory();
                            player.removePotionEffect(PotionEffectType.SLOW);
                        }, time);
                    }, time);
                }, time);
            }, time);
        }, time);
    }
}
