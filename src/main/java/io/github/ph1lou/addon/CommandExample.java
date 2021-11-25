package io.github.ph1lou.addon;


import io.github.ph1lou.werewolfapi.ICommand;
import io.github.ph1lou.werewolfapi.WereWolfAPI;
import org.bukkit.entity.Player;

public class CommandExample implements ICommand {
    @Override
    public void execute(WereWolfAPI wereWolfAPI, Player player, String[] strings) {

        wereWolfAPI.getPlayerWW(player.getUniqueId()).ifPresent(playerWW -> playerWW.sendMessageWithKey("your_addon.transformed"));

    }
}
