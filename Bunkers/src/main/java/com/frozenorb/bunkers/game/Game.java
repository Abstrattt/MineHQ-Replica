package com.frozenorb.bunkers.game;

import com.frozenorb.bunkers.game.map.GameMap;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter @Setter
public class Game {

    private HashMap<GameMap, Integer> votes = new HashMap<GameMap, Integer>();

    public Game(){

    }
}
