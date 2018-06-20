package com.frozenorb.meetup.backend.game.type;

import com.frozenorb.meetup.backend.game.Game;

public class SoloGame extends Game {

    public SoloGame() {
        getProperties().setTeamSize(1);
        getProperties().setMaxPlayers(16);
    }
}
