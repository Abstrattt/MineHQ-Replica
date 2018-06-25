package com.frozenorb.qlib.misc;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.util.Map;
import java.util.UUID;

/**
 * Fake Player Class
 */
public class FakePlayer implements OfflinePlayer {

    private String name;
    private Team team;
    private final UUID uuid;

    public FakePlayer(Team team) {
        this.team = team;
        this.uuid = UUID.randomUUID();
        this.name = "";
    }

    public Team getTeam() {
        return team;
    }

    @Override
    public boolean isOnline() {
        return true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UUID getUniqueId() {
        return this.uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean isBanned() {
        return false;
    }

    @Override
    public void setBanned(boolean b) {

    }

    @Override
    public boolean isWhitelisted() {
        return false;
    }

    @Override
    public void setWhitelisted(boolean b) {

    }

    @Override
    public Player getPlayer() {
        return null;
    }

    @Override
    public long getFirstPlayed() {
        return 0;
    }

    @Override
    public long getLastPlayed() {
        return 0;
    }

    @Override
    public boolean hasPlayedBefore() {
        return false;
    }

    @Override
    public Location getBedSpawnLocation() {
        return null;
    }

    @Override
    public Map<String, Object> serialize() {
        return null;
    }

    @Override
    public boolean isOp() {
        return false;
    }

    @Override
    public void setOp(boolean b) {

    }
}
