package io.github.ph1lou.addon;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.enums.Category;
import io.github.ph1lou.werewolfapi.enums.UniversalMaterial;
import io.github.ph1lou.werewolfapi.registers.AddonRegister;
import io.github.ph1lou.werewolfapi.registers.RegisterManager;
import io.github.ph1lou.werewolfapi.registers.RoleRegister;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class Main extends JavaPlugin {

    GetWereWolfAPI ww ;

    @Override
    public void onEnable() {

        ww = (GetWereWolfAPI) Bukkit.getPluginManager().getPlugin("WereWolfPlugin");

        RegisterManager registerManager = ww.getRegisterManager();

        String addonKey = "werewolf.your_addon";

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
