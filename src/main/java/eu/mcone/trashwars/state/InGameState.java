package eu.mcone.trashwars.state;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.util.CoreTitle;
import eu.mcone.gameapi.api.event.gamestate.GameStateStartEvent;
import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.trashwars.TrashWars;
import eu.mcone.trashwars.inventorys.TrashInventory;
import eu.mcone.trashwars.kit.Kit;
import eu.mcone.trashwars.objective.InGameObjective;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class InGameState extends eu.mcone.gameapi.api.gamestate.common.InGameState {

    static {
        setObjective(InGameObjective.class);
    }

    private static final CoreTitle COUNT_1 = CoreSystem.getInstance().createTitle().fadeIn(1).fadeOut(1).title("§a1").subTitle("").stay(2);
    private static final CoreTitle COUNT_2 = CoreSystem.getInstance().createTitle().fadeIn(1).fadeOut(1).title("§a2").subTitle("").stay(2);
    private static final CoreTitle COUNT_3 = CoreSystem.getInstance().createTitle().fadeIn(1).fadeOut(1).title("§a3").subTitle("").stay(2);

    public InGameState(int timeout) {
        super(timeout);
    }

    @Override
    public void onStart(GameStateStartEvent event) {
        Bukkit.getScheduler().runTaskLater(TrashWars.getInstance(), () -> {
            for (GamePlayer gamePlayer : TrashWars.getInstance().getOnlineGamePlayers()) {
                Player player = gamePlayer.bukkit();
                TrashWars.getInstance().getMessenger().send(player, "§7Die Ausrüstungsphase hat nun gestartet!");
                int time = (gamePlayer.getCurrentKit().equals(Kit.FAULTIER) ? 50 : 40);

                if (gamePlayer.getCurrentKit().equals(Kit.FAULTIER)) {
                    run(player, time);
                } else {
                    COUNT_3.send(player);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 2), true);
                    Bukkit.getScheduler().runTaskLater(TrashWars.getInstance(), () -> {
                        COUNT_2.send(player);

                        Bukkit.getScheduler().runTaskLater(TrashWars.getInstance(), () -> {
                            COUNT_1.send(player);
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
                            TrashWars.getInstance().getMessenger().send(player, "§7Die Kampfphase hat nun gestartet!");
                        }, time);
                    }, time);
                }, time);
            }, time);
        }, time);
    }
}
