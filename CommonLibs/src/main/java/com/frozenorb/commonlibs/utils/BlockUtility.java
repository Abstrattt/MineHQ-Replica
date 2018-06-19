package com.frozenorb.commonlibs.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlockUtility {

    public static boolean isMaterialWithinBlock(Material material, Block block){
        Location location = block.getLocation();
        World world = location.getWorld();
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        Set<Material> blocks = Stream.of(
                world.getBlockAt(new Location(world, x, y+1, z)).getType(), world.getBlockAt(new Location(world, x, y-1, z)).getType(),
                world.getBlockAt(new Location(world, x+1, y, z)).getType(), world.getBlockAt(new Location(world, x-1, y, z)).getType(),
                world.getBlockAt(new Location(world, x, y, z+1)).getType(), world.getBlockAt(new Location(world, x, y, z-1)).getType())
                .collect(Collectors.toSet());
        return (blocks.contains(material));
    }
}
