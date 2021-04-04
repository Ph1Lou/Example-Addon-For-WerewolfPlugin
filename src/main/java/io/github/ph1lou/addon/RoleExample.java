package io.github.ph1lou.addon;


import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.events.DayEvent;
import io.github.ph1lou.werewolfapi.events.NightEvent;
import io.github.ph1lou.werewolfapi.rolesattributs.RoleVillage;
import org.bukkit.event.EventHandler;

public class RoleExample extends RoleVillage {


    public RoleExample(GetWereWolfAPI main, IPlayerWW playerWW, String key) {
        super(main,playerWW,key);
    }

    @EventHandler
    public void onNight(NightEvent event) {

        //Je fais des trucs la nuit
    }

    @EventHandler
    public void onDay(DayEvent event) {

      //Je fais des trucs le Jours
    }


    @Override
    public String getDescription() {
        return game.translate("werewolf.role.role_example.description");
    }

    @Override
    public void recoverPower() {

    }


    @Override
    public void recoverPotionEffect() {
        super.recoverPotionEffect();
        //à l'annonce des rôles et quand je rez
    }

}
