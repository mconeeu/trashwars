package eu.mcone.trashwars.listener;

import eu.mcone.trashwars.TrashWars;
import eu.mcone.trashwars.state.EndState;
import eu.mcone.trashwars.state.LobbyState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntityListener implements Listener {

    @EventHandler
    public void on(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            if (TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState
                    || TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndState) {
                e.setCancelled(true);
            }
        } else {
            e.setCancelled(true);
        }
    }
}
