package io.github.ph1lou.addon;

import io.github.ph1lou.werewolfapi.DescriptionBuilder;
import io.github.ph1lou.werewolfapi.Formatter;
import io.github.ph1lou.werewolfapi.IPlayerWW;
import io.github.ph1lou.werewolfapi.PotionModifier;
import io.github.ph1lou.werewolfapi.WereWolfAPI;
import io.github.ph1lou.werewolfapi.events.game.day_cycle.DayEvent;
import io.github.ph1lou.werewolfapi.rolesattributs.ITransformed;
import io.github.ph1lou.werewolfapi.rolesattributs.RoleVillage;
import org.bukkit.event.EventHandler;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class AriloxeLeKek extends RoleVillage implements ITransformed {

    private boolean transformed = false;

    public AriloxeLeKek(WereWolfAPI game, IPlayerWW playerWW, String key) {
        super(game, playerWW, key);
    }
//Je suis le plus beau des &unicorn&
    @Override
    public @NotNull String getDescription() {
        return new DescriptionBuilder(game,this)
                .setDescription(game.translate("werewolf.role.role_example.description",
                        Formatter.format("&unicorn&",this.getPlayerWW().getName())))
                .build();
    }

    @Override
    public void recoverPower() {
        this.getPlayerWW().addPlayerMaxHealth(10);
    }

    @EventHandler
    public void onDay(DayEvent event){
        this.getPlayerWW().addPotionModifier(PotionModifier.add(PotionEffectType.DAMAGE_RESISTANCE,
                "ariloxe"));
    }



    @Override
    public boolean isNeutral() {
        return super.isNeutral() || this.transformed;
    }

    @Override
    public boolean isTransformed() {
        return this.transformed;
    }

    @Override
    public void setTransformed(boolean transformed) {
        this.transformed=transformed;
    }
}
