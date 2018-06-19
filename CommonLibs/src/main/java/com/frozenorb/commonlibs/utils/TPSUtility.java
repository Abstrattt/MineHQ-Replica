package com.frozenorb.commonlibs.utils;

import org.bukkit.Bukkit;
import org.bukkit.Server;

import java.lang.reflect.Field;

public class TPSUtility {

    private static Object minecraftServer;
    private static Field recentTps;
    private static Boolean isPaperSpigot = null;

    public static double[] getRecentTps() {
        if (isPaperSpigot == null) {
            try {
                double[] recentTps = getRecentTpsPaperSpigot();
                isPaperSpigot = true;
                return recentTps;
            } catch (Throwable t) {
                isPaperSpigot = false;
            }
        }
        if (isPaperSpigot) {
            try {
                return getRecentTpsPaperSpigot();
            } catch (Throwable throwable) {
                return new double[]{20, 20, 20};
            }
        } else {
            try {
                return getRecentTpsRefl();
            } catch (Throwable throwable) {
                return new double[]{20, 20, 20};
            }
        }
    }

    private static double[] getRecentTpsPaperSpigot() throws Throwable {
        return Bukkit.getServer().spigot().getTPS();
    }

    private static double[] getRecentTpsRefl() throws Throwable {
        if (minecraftServer == null) {
            Server server = Bukkit.getServer();
            Field consoleField = server.getClass().getDeclaredField("console");
            consoleField.setAccessible(true);
            minecraftServer = consoleField.get(server);
        }
        if (recentTps == null) {
            recentTps = minecraftServer.getClass().getSuperclass().getDeclaredField("recentTps");
            recentTps.setAccessible(true);
        }
        return (double[]) recentTps.get(minecraftServer);
    }
}
