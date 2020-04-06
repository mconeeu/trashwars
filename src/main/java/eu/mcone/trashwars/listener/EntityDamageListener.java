package eu.mcone.trashwars.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.trashwars.TrashWars;
import eu.mcone.trashwars.state.EndState;
import eu.mcone.trashwars.state.LobbyState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void on(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            if (TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState || TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndState) {
                if (e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
                    CoreSystem.getInstance().getWorldManager().getWorld(TrashWars.getInstance().getGameConfig().parseConfig().getLobby()).getLocation("spawn");
                }

                e.setCancelled(true);
            }
        }
    }
}
