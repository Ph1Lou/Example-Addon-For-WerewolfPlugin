package io.github.ph1lou.addon;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.ListenerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Chicken;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

public class Scenario extends ListenerManager {
    public Scenario(GetWereWolfAPI main) {
        super(main);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event){
        if(event.getEntity() instanceof Chicken){
            Bukkit.broadcastMessage("coucou");
        }
    }
}
