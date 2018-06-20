package com.frozenorb.meetup.backend.game.type;

import com.frozenorb.meetup.backend.game.Game;

public class DuoGame extends Game {

    public DuoGame(){
        getProperties().setTeamSize(2);
        getProperties().setMaxPlayers(24);
    }
}
