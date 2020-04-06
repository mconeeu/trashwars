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
public enum FightItem {

    //Swords
    DIAMOND_SWORD(Level.EPIC, new ItemBuilder(Material.DIAMOND_SWORD, 1).displayName("§3Diamantschwert").create()),
    DIAMOND_SWORD_1(Level.LEGENDARY, new ItemBuilder(Material.DIAMOND_SWORD, 1).enchantment(Enchantment.DAMAGE_ALL, 1).displayName("§3Diamantschwert").create()),
    DIAMOND_SWORD_2(Level.MYSTICAL, new ItemBuilder(Material.DIAMOND_SWORD, 1).enchantment(Enchantment.KNOCKBACK, 1).displayName("§3Diamantschwert").create()),
    WOOD_SWORD(Level.USUAL, new ItemBuilder(Material.WOOD_SWORD, 1).enchantment(Enchantment.DAMAGE_ALL, 2).displayName("§3Holzschwert").create()),
    WOOD_SWORD_1(Level.UNUSUAL, new ItemBuilder(Material.WOOD_SWORD, 1).enchantment(Enchantment.DAMAGE_ALL, 1).enchantment(Enchantment.FIRE_ASPECT, 1).displayName("§3Holzschwert").create()),
    GOLD_SWORD(Level.EPIC, new ItemBuilder(Material.GOLD_SWORD, 1).enchantment(Enchantment.DAMAGE_ALL, 1).displayName("§3Goldschwert").create()),
    STONE_SWORD(Level.UNUSUAL, new ItemBuilder(Material.STONE_SWORD, 1).enchantment(Enchantment.DAMAGE_ALL, 1).displayName("§3Steinschwert").create()),
    STONE_SWORD_1(Level.EPIC, new ItemBuilder(Material.STONE_SWORD, 1).enchantment(Enchantment.KNOCKBACK, 1).enchantment(Enchantment.FIRE_ASPECT, 1).displayName("§3Steinschwert").create()),
    STONE_SWORD_2(Level.LEGENDARY, new ItemBuilder(Material.STONE_SWORD, 1).enchantment(Enchantment.FIRE_ASPECT, 1).displayName("§3Steinschwert").create()),
    WOOD_SWORD_2(Level.USUAL, new ItemBuilder(Material.WOOD_SWORD, 1).enchantment(Enchantment.FIRE_ASPECT, 2).displayName("§3Holzschwert").create()),

    //Axes
    GOLD_AXE(Level.USUAL, new ItemBuilder(Material.GOLD_AXE, 1).enchantment(Enchantment.DURABILITY, 2).displayName("§3Goldaxt").create()),
    GOLD_AXE_2(Level.UNUSUAL, new ItemBuilder(Material.GOLD_AXE, 1).enchantment(Enchantment.KNOCKBACK, 2).enchantment(Enchantment.DAMAGE_ALL, 1).displayName("§3Goldaxt").create()),
    DIAMOND_AXE(Level.EPIC, new ItemBuilder(Material.DIAMOND_AXE, 1).displayName("§3Diamantaxt").create()),
    STONE_AXE_2(Level.USUAL, new ItemBuilder(Material.STONE_AXE, 1).enchantment(Enchantment.DURABILITY, 1).displayName("§3Steinaxt").create()),


    //BLOCKS
    COBBLESTONE(Level.USUAL, new ItemBuilder(Material.COBBLESTONE, 54).displayName("§3Bruchstein").create()),
    CLEANSTONE(Level.UNUSUAL, new ItemBuilder(Material.STONE, 58).displayName("§3Stein").create()),


    //Helmet
    DIAMOND_HELMET(Level.LEGENDARY, new ItemBuilder(Material.DIAMOND_HELMET, 1).displayName("§3Diamanthelm").create()),
    DIAMOND_HELMET_1(Level.LEGENDARY, new ItemBuilder(Material.DIAMOND_HELMET, 1).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).displayName("§3Diamanthelm").create()),
    DIAMOND_HELMET_2(Level.MYSTICAL, new ItemBuilder(Material.DIAMOND_HELMET, 1).enchantment(Enchantment.PROTECTION_EXPLOSIONS, 1).displayName("§3Diamanthelm").create()),
    GOLD_HELMET(Level.EPIC, new ItemBuilder(Material.GOLD_HELMET, 1).displayName("§3Goldhelm").create()),
    GOLD_HELMET_1(Level.LEGENDARY, new ItemBuilder(Material.GOLD_HELMET, 1).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).displayName("§3Goldhelm").create()),
    GOLD_HELMET_2(Level.EPIC, new ItemBuilder(Material.GOLD_HELMET, 1).enchantment(Enchantment.PROTECTION_FIRE, 1).displayName("§3Goldhelm").create()),
    CHAINMAIL_HELMET(Level.USUAL, new ItemBuilder(Material.CHAINMAIL_HELMET, 1).enchantment(Enchantment.THORNS, 1).displayName("§3Kettenhelm").create()),
    CHAINMAIL_HELMET_1(Level.UNUSUAL, new ItemBuilder(Material.CHAINMAIL_HELMET, 1).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).displayName("§3Kettenhelm").create()),
    CHAINMAIL_HELMET_2(Level.EPIC, new ItemBuilder(Material.CHAINMAIL_HELMET, 1).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).enchantment(Enchantment.PROTECTION_FIRE, 1).displayName("§3Kettenhelm").create()),
    LEATHER_HELMET(Level.USUAL, new ItemBuilder(Material.LEATHER_HELMET, 1).displayName("§3Lederhelm").create()),
    LEATHER_HELMET_1(Level.USUAL, new ItemBuilder(Material.LEATHER_HELMET, 1).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).displayName("§3Lederhelm").create()),
    LEATHER_HELMET_2(Level.UNUSUAL, new ItemBuilder(Material.LEATHER_HELMET, 1).enchantment(Enchantment.PROTECTION_FIRE, 1).displayName("§3Lederhelm").create()),

    //Chestplates
    DIAMOND_CHESTPLATE(Level.EPIC, new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1).displayName("§3Diamantbrutsplatte").create()),
    DIAMOND_CHESTPLATE_1(Level.MYSTICAL, new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).displayName("§3Diamantbrutsplatte").create()),
    DIAMOND_CHESTPLATE_2(Level.MYSTICAL, new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1).enchantment(Enchantment.PROTECTION_FIRE, 1).displayName("§3Diamantbrutsplatte").create()),
    CHAINMAIL_CHESTPLATE(Level.UNUSUAL, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE, 1).displayName("§3Kettenbrutsplatte").create()),
    CHAINMAIL_CHESTPLATE_1(Level.UNUSUAL, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE, 1).enchantment(Enchantment.PROTECTION_FIRE, 1).displayName("§3Kettenbrutsplatte").create()),
    CHAINMAIL_CHESTPLATE_2(Level.LEGENDARY, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE, 1).enchantment(Enchantment.PROTECTION_EXPLOSIONS, 2).displayName("§3Kettenbrutsplatte").create()),
    LEATHER_CHESTPLATE(Level.USUAL, new ItemBuilder(Material.LEATHER_CHESTPLATE, 1).displayName("§3Lederbrutsplatte").create()),
    LEATHER_CHESTPLATE_1(Level.USUAL, new ItemBuilder(Material.LEATHER_CHESTPLATE, 1).enchantment(Enchantment.PROTECTION_PROJECTILE, 1).displayName("§3Lederbrutsplatte").create()),
    LEATHER_CHESTPLATE_2(Level.EPIC, new ItemBuilder(Material.LEATHER_CHESTPLATE, 1).enchantment(Enchantment.PROTECTION_FIRE, 1).displayName("§3Lederbrutsplatte").create()),
    GOLD_CHESTPLATE(Level.UNUSUAL, new ItemBuilder(Material.GOLD_CHESTPLATE, 1).displayName("§3Goldbrutsplatte").create()),
    GOLD_CHESTPLATE_1(Level.EPIC, new ItemBuilder(Material.GOLD_CHESTPLATE, 1).enchantment(Enchantment.PROTECTION_FIRE, 1).displayName("§3Goldbrutsplatte").create()),
    GOLD_CHESTPLATE_2(Level.LEGENDARY, new ItemBuilder(Material.GOLD_CHESTPLATE, 1).enchantment(Enchantment.PROTECTION_PROJECTILE, 1).displayName("§3Goldbrutsplatte").create()),

    //Leggings
    DIAMOND_LEGGINGS(Level.EPIC, new ItemBuilder(Material.DIAMOND_LEGGINGS, 1).displayName("§3Diamanthose").create()),
    DIAMOND_LEGGINGS_1(Level.LEGENDARY, new ItemBuilder(Material.DIAMOND_LEGGINGS, 1).enchantment(Enchantment.PROTECTION_FALL, 1).displayName("§3Diamanthose").create()),
    DIAMOND_LEGGINGS_2(Level.MYSTICAL, new ItemBuilder(Material.DIAMOND_LEGGINGS, 1).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).enchantment(Enchantment.PROTECTION_EXPLOSIONS, 1).displayName("§3Diamanthose").create()),
    DIAMOND_LEGGINGS_3(Level.MYSTICAL, new ItemBuilder(Material.DIAMOND_LEGGINGS, 1).enchantment(Enchantment.PROTECTION_PROJECTILE, 2).enchantment(Enchantment.PROTECTION_EXPLOSIONS, 3).displayName("§3Diamanthose").create()),
    CHAINMAIL_LEGGINGS(Level.UNUSUAL, new ItemBuilder(Material.CHAINMAIL_LEGGINGS, 1).displayName("§3Kettenhose").create()),
    CHAINMAIL_LEGGINGS_1(Level.EPIC, new ItemBuilder(Material.CHAINMAIL_LEGGINGS, 1).enchantment(Enchantment.PROTECTION_EXPLOSIONS, 1).displayName("§3Kettenhose").create()),
    CHAINMAIL_LEGGINGS_2(Level.LEGENDARY, new ItemBuilder(Material.CHAINMAIL_LEGGINGS, 1).enchantment(Enchantment.PROTECTION_FIRE, 3).displayName("§3Kettenhose").create()),
    GOLD_LEGGINGS(Level.EPIC, new ItemBuilder(Material.GOLD_LEGGINGS, 1).displayName("§3Goldhose").create()),
    GOLD_LEGGINGS_1(Level.EPIC, new ItemBuilder(Material.GOLD_LEGGINGS, 1).enchantment(Enchantment.PROTECTION_FIRE, 1).displayName("§3Goldhose").create()),
    GOLD_LEGGINGS_2(Level.LEGENDARY, new ItemBuilder(Material.GOLD_LEGGINGS, 1).enchantment(Enchantment.PROTECTION_EXPLOSIONS, 1).enchantment(Enchantment.PROTECTION_PROJECTILE, 1).displayName("§3Goldhose").create()),
    LEATHER_LEGGINGS(Level.USUAL, new ItemBuilder(Material.LEATHER_LEGGINGS, 1).displayName("§3Lederhose").create()),
    LEATHER_LEGGINGS_1(Level.UNUSUAL, new ItemBuilder(Material.LEATHER_LEGGINGS, 1).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).displayName("§3Lederhose").create()),
    LEATHER_LEGGINGS_3(Level.EPIC, new ItemBuilder(Material.LEATHER_LEGGINGS, 1).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).enchantment(Enchantment.PROTECTION_FIRE, 2).displayName("§3Lederhose").create()),

    //Boots
    DIAMOND_BOOTS(Level.UNUSUAL, new ItemBuilder(Material.DIAMOND_BOOTS, 1).displayName("§3Diamantschuhe").create()),
    DIAMOND_BOOTS_1(Level.LEGENDARY, new ItemBuilder(Material.DIAMOND_BOOTS, 1).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).displayName("§3Diamantschuhe").create()),
    DIAMOND_BOOTS_2(Level.MYSTICAL, new ItemBuilder(Material.DIAMOND_BOOTS, 1).enchantment(Enchantment.PROTECTION_FALL, 1).displayName("§3Dimantschuhe").create()),
    CHAINMAIL_BOOTS(Level.USUAL, new ItemBuilder(Material.CHAINMAIL_BOOTS, 1).displayName("§3Kettenschuhe").create()),
    CHAINMAIL_BOOTS_1(Level.UNUSUAL, new ItemBuilder(Material.CHAINMAIL_BOOTS, 1).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).displayName("§3Kettenschuhe").create()),
    CHAINMAIL_BOOTS_2(Level.EPIC, new ItemBuilder(Material.CHAINMAIL_BOOTS, 1).enchantment(Enchantment.PROTECTION_FALL, 1).displayName("§3Kettenschuhe").create()),
    GOLD_BOOTS(Level.UNUSUAL, new ItemBuilder(Material.GOLD_BOOTS, 1).displayName("§3Goldschuhe").create()),
    GOLD_BOOTS_1(Level.EPIC, new ItemBuilder(Material.GOLD_BOOTS, 1).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).enchantment(Enchantment.PROTECTION_FIRE, 1).displayName("§3Goldschuhe").create()),
    GOLD_BOOTS_2(Level.LEGENDARY, new ItemBuilder(Material.GOLD_BOOTS, 1).enchantment(Enchantment.PROTECTION_EXPLOSIONS, 1).displayName("§3Goldschuhe").create()),
    LEATHER_BOOTS(Level.USUAL, new ItemBuilder(Material.LEATHER_BOOTS, 1).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).displayName("§3Lederschuhe").create()),
    LEATHER_BOOTS_1(Level.UNUSUAL, new ItemBuilder(Material.LEATHER_BOOTS, 1).enchantment(Enchantment.PROTECTION_FIRE, 2).enchantment(Enchantment.PROTECTION_EXPLOSIONS, 1).displayName("§3Lederschuhe").create()),
    LEATHER_BOOTS_2(Level.EPIC, new ItemBuilder(Material.LEATHER_BOOTS, 1).enchantment(Enchantment.PROTECTION_FALL, 3).enchantment(Enchantment.PROTECTION_PROJECTILE, 2).displayName("§3Lederschuhe").create()),

    //Eat
    COOKED_BEEF(Level.USUAL, new ItemBuilder(Material.COOKED_BEEF, 16).displayName("§7Fleisch").create()),
    GOLDEN_APPLE(Level.UNUSUAL, new ItemBuilder(Material.GOLDEN_APPLE, 1).displayName("§6Zauberapfel").create()),
    CARROT(Level.USUAL, new ItemBuilder(Material.CARROT, 16).displayName("§6Karotte").create()),
    COOKIE(Level.UNUSUAL, new ItemBuilder(Material.COOKIE, 16).displayName("§6Kekse").create()),
    CAKE(Level.EPIC, new ItemBuilder(Material.CAKE, 3).displayName("§3Kuchen").create()),

    //Blocks
    STONE(Level.USUAL, new ItemBuilder(Material.STONE, 32).displayName("§7Stein").create()),
    COBBLESTONE_2(Level.USUAL, new ItemBuilder(Material.STONE, 18).displayName("§7Bruchstein").create()),
    STONE_1(Level.UNUSUAL, new ItemBuilder(Material.STONE, 16).displayName("§7Stein").create()),
    WOOD(Level.USUAL, new ItemBuilder(Material.WOOD, 48).displayName("§7Holz").create()),
    WOOD_3(Level.UNUSUAL, new ItemBuilder(Material.WOOD, 62).displayName("§7Holz").create()),
    WOOD_1(Level.UNUSUAL, new ItemBuilder(Material.WOOD, 32).displayName("§7Holz").create()),
    CLAY_BRICK(Level.UNUSUAL, new ItemBuilder(Material.CLAY_BRICK, 42).displayName("§7Ziegelstein").create()),
    CLAY_BRICK_1(Level.EPIC, new ItemBuilder(Material.CLAY_BRICK, 15).displayName("§7Ziegelstein").create()),
    DIAMOND_BLOCK(Level.EPIC, new ItemBuilder(Material.DIAMOND_BLOCK, 2).displayName("§7Diamantblock").create()),

    //Specials
    TNT(Level.UNUSUAL, new ItemBuilder(Material.TNT, 1).displayName("§cT§fN§cT").create()),
    TNT_1(Level.EPIC, new ItemBuilder(Material.TNT, 3).displayName("§cT§fN§cT").create()),
    FISHING_ROD(Level.USUAL, new ItemBuilder(Material.FISHING_ROD, 1).displayName("§3Angel").create()),
    ENDER_PEARL(Level.LEGENDARY, new ItemBuilder(Material.ENDER_PEARL, 1).displayName("§cEnderperle").create()),
    WATER_BUCKET(Level.USUAL, new ItemBuilder(Material.WATER_BUCKET, 1).enchantment(Enchantment.LUCK, 1).displayName("§3Wassereimer").create()),
    WATER_BUCKET_1(Level.UNUSUAL, new ItemBuilder(Material.WATER_BUCKET, 1).enchantment(Enchantment.LUCK, 1).displayName("§3Wassereimer").create()),
    LAVA_BUCKET(Level.UNUSUAL, new ItemBuilder(Material.LAVA_BUCKET, 1).displayName("§3Lavaeimer").create()),
    WEB(Level.UNUSUAL, new ItemBuilder(Material.WEB, 6).displayName("§3Spinnennetz").create()),
    WEB_1(Level.EPIC, new ItemBuilder(Material.WEB, 4).displayName("§3Spinnennetz").create()),
    SOUP(Level.UNUSUAL, new ItemBuilder(Material.MUSHROOM_SOUP, 5).displayName("§3Suppe").create()),
    DIAMOND(Level.LEGENDARY, new ItemBuilder(Material.DIAMOND, 4).displayName("§3Diamant").create()),
    DIAMOND_1(Level.LEGENDARY, new ItemBuilder(Material.DIAMOND, 7).displayName("§3Diamant").create()),
    IRON_INGOT(Level.UNUSUAL, new ItemBuilder(Material.IRON_INGOT, 8).displayName("§3Eisen").create()),
    IRON_INGOT_1(Level.UNUSUAL, new ItemBuilder(Material.IRON_INGOT, 13).displayName("§3Eisen").create()),
    GOLD_INGOT(Level.EPIC, new ItemBuilder(Material.GOLD_INGOT, 3).displayName("§3Gold").create()),
    GOLD_INGOT_1(Level.EPIC, new ItemBuilder(Material.GOLD_INGOT, 13).displayName("§3Gold").create()),
    ENCHANTMENT_TABLE(Level.LEGENDARY, new ItemBuilder(Material.ENCHANTMENT_TABLE, 1).displayName("§3Verzauberungstisch").create()),
    EXP_BOTTLE(Level.UNUSUAL, new ItemBuilder(Material.EXP_BOTTLE, 16).displayName("§3XP Level").create()),
    STICK(Level.USUAL, new ItemBuilder(Material.STICK, 2).displayName("§3Holzstock").create()),
    STICK_1(Level.UNUSUAL, new ItemBuilder(Material.STICK, 5).displayName("§3Holzstock").create()),
    STICK_2(Level.UNUSUAL, new ItemBuilder(Material.STICK, 16).displayName("§3Holzstock").create()),
    BOW_1(Level.UNUSUAL, new ItemBuilder(Material.BOW, 1).displayName("§3Bogen").create()),
    BOW_2(Level.LEGENDARY, new ItemBuilder(Material.BOW, 1).enchantment(Enchantment.ARROW_FIRE, 1).displayName("§3Bogen").create()),
    ARROW_1(Level.EPIC, new ItemBuilder(Material.ARROW, 4).enchantment(Enchantment.ARROW_KNOCKBACK, 2).displayName("§3Pfeil").create()),
    ARROW_2(Level.MYSTICAL, new ItemBuilder(Material.ARROW, 9).displayName("§3Pfeil").create()),
    TORCH(Level.USUAL, new ItemBuilder(Material.TORCH, 16).displayName("§3Fackeln").create()),
    TORCH_1(Level.USUAL, new ItemBuilder(Material.TORCH, 28).displayName("§3Fackeln").create()),
    TORCH_2(Level.UNUSUAL, new ItemBuilder(Material.TORCH, 37).displayName("§3Fackeln").create()),

    //Potions
    SPEED(Level.UNUSUAL, new ItemBuilder(Material.POTION, 1, 1).displayName("§3Schnelligkeit").create()),
    SPEED_1(Level.EPIC, new ItemBuilder(Material.POTION, 2, 1).displayName("§3Schnelligkeit").create()),
    SPEED_2(Level.LEGENDARY, new ItemBuilder(Material.POTION, 3, 1).displayName("§3Schnelligkeit").create()),
    STRENGTH(Level.EPIC, new ItemBuilder(Material.POTION, 1, 5).displayName("§3Stärke").create()),
    HEAL(Level.UNUSUAL, new ItemBuilder(Material.POTION, 1, 6).displayName("§3Direktheilung").create()),
    HEAL_1(Level.LEGENDARY, new ItemBuilder(Material.POTION, 1, 6).displayName("§3Direktheilung").create()),
    HEAL_2(Level.MYSTICAL, new ItemBuilder(Material.POTION, 3, 6).displayName("§3Direktheilung").create()),
    REGENERATION(Level.USUAL, new ItemBuilder(Material.POTION, 1, 10).displayName("§3Regeneration").create()),
    REGENERATION_1(Level.MYSTICAL, new ItemBuilder(Material.POTION, 3, 10).displayName("§3Regeneration").create()),

    //Pickaxes
    STONE_PICKAXE(Level.USUAL, new ItemBuilder(Material.STONE_PICKAXE, 1).displayName("§7Steinspitzhacke").create()),
    STONE_PICKAXE_1(Level.UNUSUAL, new ItemBuilder(Material.STONE_PICKAXE, 1).enchantment(Enchantment.DAMAGE_ALL, 2).displayName("§7Steinspitzhacke").create()),
    GOLD_PICKAXE(Level.EPIC, new ItemBuilder(Material.GOLD_PICKAXE, 1).displayName("§6Goldspitzhacke").create()),
    GOLD_PICKAXE_1(Level.EPIC, new ItemBuilder(Material.GOLD_PICKAXE, 1).enchantment(Enchantment.DIG_SPEED, 1).displayName("§6Goldspitzhacke").create()),
    IRON_PICKAXE(Level.USUAL, new ItemBuilder(Material.IRON_PICKAXE, 1).displayName("§fEisenspitzhacke").create()),
    IRON_PICKAXE_1(Level.UNUSUAL, new ItemBuilder(Material.IRON_PICKAXE, 1).enchantment(Enchantment.DIG_SPEED, 2).displayName("§fEisenspitzhacke").create()),
    DIAMOND_PICKAXE(Level.LEGENDARY, new ItemBuilder(Material.DIAMOND_PICKAXE, 1).displayName("§3Diamantspitzhacke").create()),
    DIAMOND_PICKAXE_1(Level.LEGENDARY, new ItemBuilder(Material.DIAMOND_PICKAXE, 1).enchantment(Enchantment.DIG_SPEED, 2).displayName("§3Diamantspitzhacke").create());

    private final ItemStack itemStack;
    private Level level;

    FightItem(Level level, ItemStack itemStack) {
        this.level = level;
        this.itemStack = itemStack;
    }

    public static List<FightItem> getItems(Level level) {
        List<FightItem> items = new ArrayList<>();
        for (FightItem item : values()) {
            if (item.getLevel().equals(level)) {
                items.add(item);
            }
        }

        return items;
    }
}
