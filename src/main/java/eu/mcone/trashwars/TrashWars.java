package eu.mcone.trashwars;

import com.google.common.eventbus.DeadEvent;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import eu.mcone.gameapi.api.GamePlugin;
import eu.mcone.gameapi.api.Option;
import eu.mcone.gameapi.api.gamestate.common.InGameState;
import eu.mcone.trashwars.commands.TrashWarsCMD;
import eu.mcone.trashwars.listener.*;
import eu.mcone.trashwars.objective.LobbyObjective;
import eu.mcone.trashwars.state.EndState;
import eu.mcone.trashwars.state.LobbyState;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class TrashWars extends GamePlugin {

    public TrashWars() {
        super("TrashWars", ChatColor.GREEN, "trashwars.prefix", Option.BACKPACK_MANAGER_REGISTER_GADGET_CATEGORY, Option.BACKPACK_MANAGER_REGISTER_OUTFIT_CATEGORY, Option.BACKPACK_MANAGER_REGISTER_HAT_CATEGORY, Option.BACKPACK_MANAGER_REGISTER_TRAIL_CATEGORY, Option.BACKPACK_MANAGER_REGISTER_EXCLUSIVE_CATEGORY, Option.BACKPACK_MANAGER_USE_RANK_BOOTS);
    }

    @Getter
    public static TrashWars instance;
    @Getter
    private CoreWorld gameWorld;

    @Override
    public void onGameEnable() {
        instance = this;
        sendConsoleMessage("§aInitializing new GameState Handler...");
        getGameStateManager().addGameStateFirst(new LobbyState()).addGameState(new InGameState()).addGameState(new EndState()).startGame();
        getPlayerManager();
        getDamageLogger();
        getTeamManager().useTeamChat(true);
        getKitManager();

        startScheduler();

        gameWorld = CoreSystem.getInstance().getWorldManager().getWorld(getGameConfig().parseConfig().getGameWorld());


        registerEvents(
                new GeneralPlayerListener(),
                new PlayerJoinListener(),
                new PlayerQuitListener(),
                new TeamWonListener(),
                new InventoryTriggerListener(),
                new EntityDamageListener(),
                new EntityDamageByEntityListener(),
                new PlayerDeathListener()
        );



        registerCommands(
                new TrashWarsCMD()
        );

        sendConsoleMessage("§aVersion §f" + this.getDescription().getVersion() + "§a enabled...");

    }

    public void startScheduler() {
        Bukkit.getScheduler().runTaskTimer(this, LobbyObjective::updateLines, 50, 100);
    }


    @Override
    public void onGameDisable() {
        sendConsoleMessage("§cPlugin disabled!");
    }
}
