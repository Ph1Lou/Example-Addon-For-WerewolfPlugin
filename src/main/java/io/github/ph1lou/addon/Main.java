package io.github.ph1lou.addon;

import io.github.ph1lou.werewolfapi.*;
import io.github.ph1lou.werewolfapi.enumlg.Category;
import io.github.ph1lou.werewolfapi.enumlg.UniversalMaterial;
import io.github.ph1lou.werewolfapi.utils.ItemBuilder;
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

        String addonKey = "werewolf.your_addon";

        registerManager
                .registerAddon(new AddonRegister(addonKey,
                        "fr",
                        this,
                        new ItemBuilder(UniversalMaterial.CARROT.getType())
                                .setLore("Ceci est un Addon d'Exemple")
                                .setDisplayName("Rôle Addon")
                                .build()
                )
                .addAuthors("Ph1Lou",UUID.fromString("056be797-2a0b-4807-9af5-37faf5384396")));



        try {
            registerManager.registerRole(new RoleRegister(addonKey,"werewolf.role.role_example.display",RoleExample.class)
                    .setLore(Arrays.asList("§fRole Example","§fFait par §bPh1Lou"))
                    .addCategory(Category.ADDONS)
                    .addCategory(Category.VILLAGER));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
