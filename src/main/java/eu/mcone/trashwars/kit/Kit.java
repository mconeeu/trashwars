package eu.mcone.trashwars.kit;

import eu.mcone.coresystem.api.bukkit.inventory.PlayerInventorySlot;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Kit {

    public static final eu.mcone.gameapi.api.kit.Kit DEFAULT = new eu.mcone.gameapi.api.kit.Kit(
            "Standard-Kit",
            new ItemBuilder(Material.WOOD_SWORD)
                    .displayName("§7Standard-Kit")
                    .lore(
                            "",
                            "§7§oMit diesem Kit erhälst du:",
                            "§8» §7Stein Schwert",
                            "§8» §764x Stein",
                            "§8» §764x Bruchstein",
                            "",
                            "§7Kosten: §f0 Coins",
                            "§c§oDu erhälst das Kit nur einmal!"
                    )
                    .itemFlags(ItemFlag.HIDE_ATTRIBUTES)
                    .create(),
            new HashMap<Integer, ItemStack>() {{
                put(PlayerInventorySlot.HOTBAR_SLOT_1, new ItemBuilder(Material.WOOD_SWORD)
                        .displayName("§8» §b§lHolz Schwert")
                        .lore("§7§oStandard-Kit")
                        .enchantment(Enchantment.DAMAGE_ALL, 1)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_2, new ItemBuilder(Material.STONE, 64)
                        .displayName("§8» §6§lStein")
                        .lore("§7§oStandard-Kit")
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_3, new ItemBuilder(Material.COBBLESTONE, 64)
                        .displayName("§8» §6§lBruchstein")
                        .lore("§7§oStandard-Kit")
                        .create()
                );
            }},
            0
    );

    public static final eu.mcone.gameapi.api.kit.Kit ASSASINE = new eu.mcone.gameapi.api.kit.Kit(
            "Assasine-Kit",
            new ItemBuilder(Material.DIAMOND_SWORD)
                    .displayName("§6Assasine-Kit")
                    .lore(
                            "",
                            "§7§oMit diesem Kit erhälst du:",
                            "§8» §6Diamantschwert",
                            "§8» §664x Steinblöcke",
                            "§8» §664x Bruchstein",
                            "",
                            "§7§oFähigkeit:",
                            "§8» §6Mit diesen Kit erhälst du keine Fähigkeit",
                            "",
                            "§7Kosten: §f100 Coins",
                            "§c§oDu erhälst das Kit nur einmal!"
                    )
                    .create(),
            new HashMap<Integer, ItemStack>() {{

                put(PlayerInventorySlot.HOTBAR_SLOT_1, new ItemBuilder(Material.DIAMOND_SWORD)
                        .displayName("§8» §b§lDiamantschwert")
                        .lore("§6§oAssasine-Kit")
                        .enchantment(Enchantment.DAMAGE_ALL, 1)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_2, new ItemBuilder(Material.STONE, 64)
                        .displayName("§8» §d§lStein")
                        .lore("§6§oFaultier-Kit")
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_3, new ItemBuilder(Material.COBBLESTONE, 64)
                        .displayName("§8» §d§lBruchstein")
                        .lore("§6§oFaultier-Kit")
                        .create()
                );
            }},
            100
    );

    public static final eu.mcone.gameapi.api.kit.Kit FAULTIER = new eu.mcone.gameapi.api.kit.Kit(
            "Faultier-Kit",
            new ItemBuilder(Material.WEB)
                    .displayName("§6Faultier-Kit")
                    .lore(
                            "",
                            "§7§oMit diesem Kit erhälst du:",
                            "§8» §6Stein Schwert",
                            "§8» §664x Steinblöcke",
                            "§8» §664x Bruchstein",
                            "§8» §664x Spinnenweben",
                            "",
                            "§7§oFähigkeit:",
                            "§8» §6Das Trash Inventar bleibt 1 Sekunde länger offen",
                            "",
                            "§7Kosten: §f100 Coins",
                            "§c§oDu erhälst das Kit nur einmal!"
                    )
                    .create(),
            new HashMap<Integer, ItemStack>() {{

                put(PlayerInventorySlot.HOTBAR_SLOT_1, new ItemBuilder(Material.STONE_SWORD)
                        .displayName("§8» §b§lStein Schwert")
                        .lore("§6§oFaultier-Kit")
                        .enchantment(Enchantment.DAMAGE_ALL, 2)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_2, new ItemBuilder(Material.STONE, 64)
                        .displayName("§8» §d§lStein")
                        .lore("§6§oFaultier-Kit")
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_3, new ItemBuilder(Material.COBBLESTONE, 64)
                        .displayName("§8» §d§lBruchstein")
                        .lore("§6§oFaultier-Kit")
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_4, new ItemBuilder(Material.WEB, 64)
                        .displayName("§8» §6§lSpinnenweben")
                        .lore("§6§oFaultier-Kit")
                        .create()
                );
            }},
            100
    );
}
