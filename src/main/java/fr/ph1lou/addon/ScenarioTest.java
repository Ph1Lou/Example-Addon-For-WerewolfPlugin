package fr.ph1lou.addon;

import fr.ph1lou.werewolfapi.GetWereWolfAPI;
import fr.ph1lou.werewolfapi.annotations.Scenario;
import fr.ph1lou.werewolfapi.listeners.impl.ListenerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Chicken;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;


@Scenario(key = "your_addon.scenarios.name")
public class ScenarioTest extends ListenerManager {
    public ScenarioTest(GetWereWolfAPI main) {
        super(main);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event){
        if(event.getEntity() instanceof Chicken){
            Bukkit.broadcastMessage("coucou");
        }
    }
}
