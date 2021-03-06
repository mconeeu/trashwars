package eu.mcone.trashwars;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.gamemode.Gamemode;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import eu.mcone.gameapi.api.GamePlugin;
import eu.mcone.gameapi.api.Option;
import eu.mcone.gameapi.api.backpack.defaults.DefaultItem;
import eu.mcone.trashwars.commands.TrashWarsCMD;
import eu.mcone.trashwars.kit.Kit;
import eu.mcone.trashwars.listener.*;
import eu.mcone.trashwars.state.EndState;
import eu.mcone.trashwars.state.InGameState;
import eu.mcone.trashwars.state.LobbyState;
import lombok.Getter;

public class TrashWars extends GamePlugin {

    public TrashWars() {
        super(
                Gamemode.TRASHWARS,
                "trashwars.prefix",
                Option.BACKPACK_MANAGER_REGISTER_GADGET_CATEGORY,
                Option.BACKPACK_MANAGER_REGISTER_OUTFIT_CATEGORY,
                Option.BACKPACK_MANAGER_REGISTER_HAT_CATEGORY,
                Option.BACKPACK_MANAGER_REGISTER_TRAIL_CATEGORY,
                Option.BACKPACK_MANAGER_REGISTER_EXCLUSIVE_CATEGORY,
                Option.BACKPACK_MANAGER_USE_RANK_BOOTS,
                Option.KIT_MANAGER_APPLY_KITS_ONCE,
                Option.TEAM_MANAGER_DISABLE_RESPAWN
        );
    }

    @Getter
    public static TrashWars instance;
    @Getter
    private CoreWorld gameWorld;

    @Override
    public void onGameEnable() {
        instance = this;
        sendConsoleMessage("┬žaInitializing new GameState Handler...");
        getGameStateManager()
                .addGameState(new LobbyState())
                .addGameState(new InGameState(60 * 45))
                .addGameState(new EndState())
                .startGame();
        getPlayerManager();
        getTeamManager().loadDefaultTeams();
        getDamageLogger();

        getKitManager().registerKits(Kit.DEFAULT, Kit.FISHER, Kit.FAULTIER, Kit.ASSASINE);
        getBackpackManager();
        getBackpackManager().setItemSlot(0);
        getBackpackManager().setFallbackSlot(0);
        getBackpackManager().disableItem(DefaultItem.COINBOMB);

        gameWorld = CoreSystem.getInstance().getWorldManager().getWorld(getGameConfig().parseConfig().getGameWorld());

        registerEvents(
                new PlayerFishingListener(),
                new GeneralPlayerListener(),
                new PlayerJoinListener(),
                new PlayerQuitListener(),
                new GameEndListener(),
                new InventoryTriggerListener(),
                new EntityDamageListener(),
                new EntityDamageByEntityListener(),
                new PlayerDeathListener()
        );

        registerCommands(
                new TrashWarsCMD()
        );

        sendConsoleMessage("┬žaVersion ┬žf" + this.getDescription().getVersion() + "┬ža enabled...");
    }


    @Override
    public void onGameDisable() {
        sendConsoleMessage("┬žcPlugin disabled!");
    }
}
