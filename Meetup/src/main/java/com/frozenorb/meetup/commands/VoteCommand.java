package com.frozenorb.meetup.commands;

import com.frozenorb.commonlibs.utils.MessageUtility;
import com.frozenorb.meetup.MeetupPlugin;
import com.frozenorb.meetup.backend.game.Game;
import com.frozenorb.meetup.backend.game.GameState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VoteCommand implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("You can not vote as console.");
            return false;
        }
        /* Player Object */
        Player player = (Player) commandSender;

        /* Game Object */
        Game game = MeetupPlugin.getGame();

        /* Check that the game is the correct gamestate */
        if (!game.getState().equals(GameState.VOTING)){
            player.sendMessage(MessageUtility.formatMessage("&cYou can not vote in this game state."));
            return false;
        }

        //TODO add more

        return false;
    }

}
