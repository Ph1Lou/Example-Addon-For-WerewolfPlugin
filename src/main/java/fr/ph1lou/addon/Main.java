package fr.ph1lou.addon;

import fr.ph1lou.werewolfapi.GetWereWolfAPI;
import fr.ph1lou.werewolfapi.annotations.Author;
import fr.ph1lou.werewolfapi.annotations.ModuleWerewolf;
import fr.ph1lou.werewolfapi.enums.UniversalMaterial;
import org.bukkit.plugin.java.JavaPlugin;

@ModuleWerewolf(key = Main.KEY,
        loreKeys = {},
        item = UniversalMaterial.CARROT,
        defaultLanguage = "fr",
        authors = @Author(uuid = "056be797-2a0b-4807-9af5-37faf5384396", name = "Ph1Lou"))
public class Main extends JavaPlugin {

    private GetWereWolfAPI ww ;
    public static final String KEY = "your_addon.your_addon";

    @Override
    public void onEnable() {

        this.ww =  getServer().getServicesManager().load(GetWereWolfAPI.class);
    }
}
