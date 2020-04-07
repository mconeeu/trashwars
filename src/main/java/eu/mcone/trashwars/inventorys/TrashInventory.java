package eu.mcone.trashwars.inventorys;

import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventoryOption;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.gameapi.api.backpack.Level;
import eu.mcone.trashwars.item.FightItem;
import eu.mcone.trashwars.item.TrashItem;
import org.bukkit.entity.Player;

import java.util.*;

public class TrashInventory extends CoreInventory {

    private static final int FIGHT_ITEM_COUNT = 11;
    private static final List<FightItem> FIGHT_ITEMS = new ArrayList<>();

    static {
        for (FightItem item : FightItem.values()) {

            for (int i = 0; i < (Level.values().length - item.getLevel().ordinal()); i++) {
                FIGHT_ITEMS.add(item);
            }
        }
    }

    private final Map<Integer, FightItem> setItems = new HashMap<>();
    private final Random slotRandom = new Random();
    private final Random fightRandom = new Random();

    public TrashInventory(Player player) {
        super("§fNimm so viel du kannst..", player, InventorySlot.ROW_6, InventoryOption.FILL_EMPTY_SLOTS);

        for (int i = 0; i < FIGHT_ITEM_COUNT; i++) {
            int slot = getSlotRandom();
            FightItem item = getRandomFightItem();

            setItem(slot, item.getItemStack());
            setItems.put(slot, item);
        }

        Random trashRandom = new Random();
        for (int i = 0; i < InventorySlot.ROW_6; i++) {
            if (!setItems.containsKey(i)) {
                setItem(i, TrashItem.values()[trashRandom.nextInt(TrashItem.values().length)].getItemStack());
            }
        }

        openInventory();
    }

    private int getSlotRandom() {
        int slot = slotRandom.nextInt(InventorySlot.ROW_6);
        return setItems.containsKey(slot) ? getSlotRandom() : slot;
    }

    private FightItem getRandomFightItem() {
        FightItem item = FIGHT_ITEMS.get(fightRandom.nextInt(FIGHT_ITEMS.size()));
        return setItems.containsValue(item) ? getRandomFightItem() : item;
    }

}
