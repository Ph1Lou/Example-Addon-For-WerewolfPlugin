package io.github.ph1lou.addon;

import io.github.ph1lou.werewolfapi.*;
import io.github.ph1lou.werewolfapi.enumlg.Category;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.UUID;

public class Main extends JavaPlugin {

    GetWereWolfAPI ww ;

    @Override
    public void onEnable() {

        ww = (GetWereWolfAPI) Bukkit.getPluginManager().getPlugin("WereWolfPlugin");

        RegisterManager registerManager = ww.getRegisterManager();

        registerManager
                .registerAddon(new AddonRegister("werewolf.unique_key","fr",this)
                .addAuthors(UUID.fromString("056be797-2a0b-4807-9af5-37faf5384396"))
                .setLore("Ceci est un addon d'exemple"));

        try {
            registerManager.registerRole(new RoleRegister("werewolf.unique_key","werewolf.role.role_example.display",RoleExample.class)
                    .setLore(Arrays.asList("§fRole Example","§fFait par §bPh1Lou"))
                    .addCategory(Category.ADDONS)
                    .addCategory(Category.VILLAGER));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
