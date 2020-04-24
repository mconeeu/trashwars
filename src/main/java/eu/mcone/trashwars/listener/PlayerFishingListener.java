package eu.mcone.trashwars.listener;

import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.trashwars.TrashWars;
import eu.mcone.trashwars.kit.Kit;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.util.Vector;

public class PlayerFishingListener implements Listener {

    @EventHandler
    public void onFish(PlayerFishEvent e) {
        Player p = e.getPlayer();

        Fish h = e.getHook();

        GamePlayer gamePlayer = TrashWars.getInstance().getGamePlayer(p);

        if (((e.getState().equals(PlayerFishEvent.State.IN_GROUND)) ||
                (e.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY)) ||
                (e.getState().equals(PlayerFishEvent.State.FAILED_ATTEMPT))) &&
                (p.getItemInHand().getItemMeta().getDisplayName().equals("§8» §d§lEnterhacken")) &&
                (Bukkit.getWorld(e.getPlayer().getWorld().getName())
                        .getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1,
                                h.getLocation().getBlockZ())
                        .getType() != Material.AIR) && gamePlayer.getCurrentKit().equals(Kit.FISHER)) {
            if (Bukkit.getWorld(e.getPlayer().getWorld().getName())
                    .getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1,
                            h.getLocation().getBlockZ())
                    .getType() != Material.STATIONARY_WATER) {
                Location lc = p.getLocation();
                Location to = e.getHook().getLocation();

                lc.setY(lc.getY() + 0.5D);
                p.teleport(lc);

                p.getInventory().remove(p.getItemInHand());

                p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 3, 3);
                p.playSound(p.getLocation(), Sound.CAT_HISS, 2, 2);
                double g = -0.08D;
                double t = to.distance(lc);
                double v_x = (1.0D + 0.07D * t) * (to.getX() - lc.getX()) / t;
                double v_y = (1.0D + 0.03D * t) * (to.getY() - lc.getY()) / t - 0.5D * g * t;
                double v_z = (1.0D + 0.07D * t) * (to.getZ() - lc.getZ()) / t;

                Vector v = p.getVelocity();
                v.setX(v_x);
                v.setY(v_y);
                v.setZ(v_z);
                p.setVelocity(v);
            }
        }

    }
}
