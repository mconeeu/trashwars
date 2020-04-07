package eu.mcone.trashwars.listener;

import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.gameapi.api.backpack.Category;
import eu.mcone.gameapi.api.backpack.defaults.DefaultCategory;
import eu.mcone.gameapi.api.gamestate.common.EndGameState;
import eu.mcone.trashwars.TrashWars;
import eu.mcone.trashwars.state.EndState;
import eu.mcone.trashwars.state.LobbyState;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryTriggerListener implements Listener {

    public static final ItemStack QUIT_ITEM = new ItemBuilder(Material.SLIME_BALL, 1, 0).displayName("§c§lLobby §8» §7§osendet dich zu Lobby zurück").create();
    public static final ItemStack KITS = new ItemBuilder(Material.CHEST, 1, 0).displayName("§c§lTemporärekits §8» §7§okaufe dir hier dein Temporäres Ingame Kit.").create();

    @EventHandler
    public void on(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            ItemStack itemStack = e.getItem();
            if (itemStack == null)
                return;

            if (TrashWars.getInstance().getGameStateManager().getRunning() instanceof LobbyState
                    || TrashWars.getInstance().getGameStateManager().getRunning() instanceof EndState) {
                if (itemStack.getType().equals(Material.IRON_DOOR)) {
                    player.performCommand("hub");
                } else if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lRucksack §8» §7§oZeige deine gesammelten Items an")) {
                    e.setCancelled(true);
                    TrashWars.getInstance().getBackpackManager().openBackpackInventory(DefaultCategory.GADGET.name(), player);
                } else if (itemStack.getType().equals(Material.CHEST)) {
                    TrashWars.getInstance().getKitManager().openKitsInventory(player, player::closeInventory);
                }

                e.setCancelled(true);
            }
        }
    }

}
