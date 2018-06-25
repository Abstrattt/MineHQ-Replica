package com.frozenorb.meetup.backend.game;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter @Setter
public class Game {

    private GameState state;
    private GameProperties properties;

    public Game() {
        this.state = GameState.WAITING;
        this.properties = new GameProperties();
    }

    public void join(Player player){
        this.join(player.getUniqueId());
    }
    public void join(UUID uuid){
        switch (state){
            case WAITING:
        }
    }

    public void leave(Player player){
        this.leave(player.getUniqueId());
    }
    public void leave(UUID uuid){
        switch (state){
            case WAITING:
        }
    }

}
