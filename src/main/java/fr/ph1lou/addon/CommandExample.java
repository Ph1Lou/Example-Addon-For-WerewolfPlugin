package fr.ph1lou.addon;


import fr.ph1lou.werewolfapi.annotations.RoleCommand;
import fr.ph1lou.werewolfapi.basekeys.RoleBase;
import fr.ph1lou.werewolfapi.commands.ICommand;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import org.bukkit.entity.Player;

@RoleCommand(key = "your_addon.commands.leave.name",
        roleKeys = {RoleBase.ANGEL}, argNumbers = {2, 3},
        autoCompletion = false,
        requiredPower = true)
public class CommandExample implements ICommand {
    @Override
    public void execute(WereWolfAPI wereWolfAPI, Player player, String[] strings) {

        wereWolfAPI.getPlayerWW(player.getUniqueId()).ifPresent(playerWW -> playerWW.sendMessageWithKey("your_addon.transformed"));

    }
}
