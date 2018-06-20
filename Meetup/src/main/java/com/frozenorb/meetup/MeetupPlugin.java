package com.frozenorb.meetup;

import com.frozenorb.meetup.backend.game.Game;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class MeetupPlugin extends JavaPlugin {

    @Getter private static Game game;
    private boolean setup = false;

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
