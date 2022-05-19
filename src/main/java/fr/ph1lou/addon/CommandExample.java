package fr.ph1lou.addon;


import fr.ph1lou.werewolfapi.annotations.RoleCommand;
import fr.ph1lou.werewolfapi.basekeys.RoleBase;
import fr.ph1lou.werewolfapi.commands.ICommandRole;
import fr.ph1lou.werewolfapi.game.WereWolfAPI;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;

@RoleCommand(key = "your_addon.commands.leave.name",
        roleKeys = {RoleBase.ANGEL}, argNumbers = {2, 3},
        autoCompletion = false,
        requiredPower = true)
public class CommandExample implements ICommandRole {
    @Override
    public void execute(WereWolfAPI wereWolfAPI, IPlayerWW playerWW, String[] strings) {

        playerWW.sendMessageWithKey("your_addon.transformed");

    }
}
