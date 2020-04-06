package eu.mcone.trashwars.item;

import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.gameapi.api.backpack.Level;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum TrashItem {

    //Swords
    TRASH_1(new ItemBuilder(Material.SPONGE, 15).displayName("§fTrash").create()),
    TRASH_2(new ItemBuilder(Material.SAPLING, 4).displayName("§fTrash").create()),
    TRASH_3(new ItemBuilder(Material.COAL, 6).displayName("§fTrash").create()),
    TRASH_4(new ItemBuilder(Material.LEAVES, 2).displayName("§fTrash").create()),
    TRASH_5(new ItemBuilder(Material.LEAVES_2, 4).displayName("§fTrash").create()),
    TRASH_6(new ItemBuilder(Material.RABBIT, 5).displayName("§fTrash").create()),
    TRASH_7(new ItemBuilder(Material.WATER_LILY, 6).displayName("§fTrash").create()),
    TRASH_8(new ItemBuilder(Material.SPIDER_EYE, 2).displayName("§fTrash").create()),
    TRASH_9(new ItemBuilder(Material.ROTTEN_FLESH, 4).displayName("§fTrash").create()),
    TRASH_10(new ItemBuilder(Material.WOOD, 19).displayName("§fTrash").create()),
    TRASH_11(new ItemBuilder(Material.COBBLESTONE, 6).displayName("§fTrash").create()),
    TRASH_12(new ItemBuilder(Material.SPONGE, 1).displayName("§fTrash").create()),
    TRASH_13(new ItemBuilder(Material.RABBIT_STEW, 3).displayName("§fTrash").create()),
    TRASH_14(new ItemBuilder(Material.VINE, 2).displayName("§fTrash").create()),
    TRASH_15(new ItemBuilder(Material.BRICK, 8).displayName("§fTrash").create());


    private final ItemStack itemStack;

    TrashItem(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

}
