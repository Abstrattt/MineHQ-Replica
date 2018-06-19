package com.frozenorb.qmodsuite.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import redis.clients.jedis.Jedis;
import com.frozenorb.qmodsuite.qModSuitePlugin;
import redis.clients.jedis.Pipeline;

public class ReportCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("You can not report people from console.");
            return false;
        }

        /* Player Object */
        Player player = (Player) commandSender;
        if (strings.length < 2) {
            commandSender.sendMessage(Messages.format(this.commandUsage));
            return false;
        }
        if (strings[0] == null) return false;
        if (strings[0].equalsIgnoreCase(player.getName())){
            player.sendMessage(Messages.format("&cYou can not report yourself!")); return false;
        }
        if (Bukkit.getPlayer(strings[0]) == null){
            player.sendMessage(Messages.format("&cThis player is not online!")); return false;
        }
        Player reported = Bukkit.getPlayer(strings[0]);
        new BukkitRunnable(){
            @Override
            public void run() {
                if (hasCooldown(player)){
                    player.sendMessage(Messages.format(commandOnCooldown)); return;
                }
                addCooldown(player);
                StringBuilder sb = new StringBuilder();
                for (String arg : strings) {
                    if (!arg.equalsIgnoreCase(strings[0])) sb.append(arg).append(" ");
                }
                String newString = plugin.getSettings().getServerName() + "|||" + reported.getName() + "|||" + player.getName() + "|||" + sb.toString();
                                SendResponse sendResponse = plugin.getTelegramManager().getBot().execute(request);
                boolean ok = sendResponse.isOk();
                Message message = sendResponse.message();
                plugin.getJedisManager().getPubSubChannel().publish("AMC-RP", newString, "async");
                qModSuitePlugin.getRedisHelper().getPool().getResource().publish()
                player.sendMessage(Messages.format(commandSuccess));
            }
        }.runTaskAsynchronously(plugin);
        return false;
    }
}
