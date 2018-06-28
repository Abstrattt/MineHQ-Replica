package com.frozenorb.qlib.tablist.interfaces;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class NMS1_8Tab implements INMSTab {

    @Override
    public void createPlayer() {
        /*GameProfile gameProfile = new GameProfile();

        EntityPlayer entityPlayer = new EntityPlayer();

        entityPlayer.ping = 1;

        Packet packet = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, entityPlayer);

        sendPacket(player, packet);*/


    }

    @Override
    public void updateName() {

    }

    @Override
    public void updateLatency() {

    }

    @Override
    public void updateSkin() {

    }

    @Override
    public void updateHeaderAndFooter() {

    }

    private void sendPacket(Player player, Packet packet) {
        getEntity(player).playerConnection.sendPacket(packet);
    }

    private EntityPlayer getEntity(Player player) {
        return ((CraftPlayer) player).getHandle();
    }

    private void getVersion(Player player){

    }
}
