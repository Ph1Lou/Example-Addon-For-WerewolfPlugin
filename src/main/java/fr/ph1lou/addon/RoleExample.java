package fr.ph1lou.addon;


import fr.ph1lou.werewolfapi.annotations.Role;
import fr.ph1lou.werewolfapi.enums.Category;
import fr.ph1lou.werewolfapi.events.game.day_cycle.DayEvent;
import fr.ph1lou.werewolfapi.events.game.day_cycle.NightEvent;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import fr.ph1lou.werewolfapi.role.impl.RoleVillage;

import fr.ph1lou.werewolfapi.role.utils.DescriptionBuilder;
import org.bukkit.event.EventHandler;
import org.jetbrains.annotations.NotNull;

@Role(key = "your_addon.role.role_example.display", category = Category.VILLAGER, attributes = {})
public class RoleExample extends RoleVillage {

    public RoleExample(WereWolfAPI main, IPlayerWW playerWW) {
        super(main,playerWW);
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
    public @NotNull String getDescription() {
        return new DescriptionBuilder(game, this)
                .setDescription(game.translate("your_addon.role.role_example.description"))
                .build();
    }

    @Override
    public void recoverPower() {

    }


    @Override
    public void recoverPotionEffect() {
        //à l'annonce des rôles et quand je rez
    }

}
