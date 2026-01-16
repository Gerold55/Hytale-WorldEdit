package com.hytale.worldedit;

public class Visualizer {
    public static void toggleShadow(Player player, Map<Vector3, String> clipboard) {
        Vector3 target = player.getPosition();
        clipboard.forEach((offset, blockId) -> {
            // Sends a packet that only this player sees
            // Tinted 50% blue to indicate it is a 'Shadow'
            player.renderGhostBlock(target.add(offset), blockId, 0.5f);
        });
    }
}