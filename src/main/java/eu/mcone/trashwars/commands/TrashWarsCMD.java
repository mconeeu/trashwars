package eu.mcone.trashwars.commands;

import eu.mcone.coresystem.api.bukkit.command.CoreCommand;
import eu.mcone.trashwars.TrashWars;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TrashWarsCMD extends CoreCommand {


    public TrashWarsCMD() {
        super("trashwars");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, String[] strings) {
        Player player = (Player)commandSender;
        TrashWars.getInstance().getMessenger().send(player, "§8§m---------- §r§a§lMCONE-TrashWars §8§m----------");
        TrashWars.getInstance().getMessenger().send(player, "§7Entwickelt von §fMarvio, §fDieserDominik");
        TrashWars.getInstance().getMessenger().send(player, "§r");
        TrashWars.getInstance().getMessenger().send(player, "§7§oWir bemühen uns darum alle Systeme und Spielmodi so effizient wie möglich zu gestalten.");
        TrashWars.getInstance().getMessenger().send(player, "§7§oDeshalb sind auch alle von uns verwendeten Plugins ausschließlich selbst entwickelt!");
        TrashWars.getInstance().getMessenger().send(player, "§8§m---------- §r§a§lMCONE-TrashWars §8§m----------");
        player.playSound(player.getLocation(), Sound.NOTE_PIANO,1,1);


        return false;
    }
}
