package io.github.ph1lou.addon;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.enums.Category;
import io.github.ph1lou.werewolfapi.enums.RolesBase;
import io.github.ph1lou.werewolfapi.enums.StateGame;
import io.github.ph1lou.werewolfapi.enums.StatePlayer;
import io.github.ph1lou.werewolfapi.enums.UniversalMaterial;
import io.github.ph1lou.werewolfapi.registers.AddonRegister;
import io.github.ph1lou.werewolfapi.registers.CommandRegister;
import io.github.ph1lou.werewolfapi.registers.IRegisterManager;
import io.github.ph1lou.werewolfapi.registers.RoleRegister;
import io.github.ph1lou.werewolfapi.registers.ScenarioRegister;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.UUID;

public class Main extends JavaPlugin {

    GetWereWolfAPI ww ;

    @Override
    public void onEnable() {

        ww =  getServer().getServicesManager().load(GetWereWolfAPI.class);

        IRegisterManager registerManager = ww.getRegisterManager();



        String addonKey = "werewolf.your_addon";


        registerManager.registerScenario(new ScenarioRegister(addonKey,"",new Scenario(ww)));

        registerManager.registerCommands(new CommandRegister(addonKey,
                "werewolf.commands.leave.name",
                new CommandExample())
        .addArgNumbers(2)
        .addArgNumbers(3)
        .addStateAccess(StatePlayer.ALIVE)
        .addStateWW(StateGame.GAME)
        .unsetAutoCompletion()
        .setRequiredPower()
        .addRoleKey(RolesBase.ANGEL.getKey()));

        registerManager
                .registerAddon(new AddonRegister(addonKey,
                        "fr",
                        this)
                        .setItem(new ItemStack(UniversalMaterial.CARROT.getType()))
                        .addLoreKey("werewolf.role.description")
                        .addAuthors("Ph1Lou",UUID.fromString("056be797-2a0b-4807-9af5-37faf5384396")));

        try {
            registerManager.registerRole(new RoleRegister(addonKey,"werewolf.role.role_example.display",RoleExample.class)
                    .addLoreKey("werewolf.role.role_example.item")
                    .addCategory(Category.ADDONS)
                    .addCategory(Category.VILLAGER));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
