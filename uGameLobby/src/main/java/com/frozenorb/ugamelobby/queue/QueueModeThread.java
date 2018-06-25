package com.frozenorb.ugamelobby.queue;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import com.frozenorb.ugamelobby.uGameLobbyPlugin;

public class QueueModeThread extends Thread {

    public QueueModeThread(){
        setName("uGameLobby-Queue");
    }

    @Override
    public void run() {
        QueueHandler.getQueues().forEach(queue -> {
            if (queue.getQueued().size() >= queue.getRequiredPlayers()) {


                /* Once a server is found */
                queue.getQueued().forEach(uuid -> {
                    Player queuePlayer = Bukkit.getPlayer(uuid);
                    ByteArrayDataOutput out = ByteStreams.newDataOutput();
                    /*out.writeUTF("Connect");
                    out.writeUTF("hub");*/
                    //TODO find out how we can dynamically add and remove servers
                    queuePlayer.sendPluginMessage(uGameLobbyPlugin.getProvidingPlugin(uGameLobbyPlugin.class), "BungeeCord", out.toByteArray());
                });
            }
        });
    }
}
