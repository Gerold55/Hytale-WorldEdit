package com.hytale.worldedit;

import hytale.api.world.World;
import hytale.api.math.Vector3;
import java.util.Map;

public class ClipboardManager {
    public void moveSelection(Player player) {
        // 1. Capture current selection
        Map<Vector3, String> data = capture(player);
        
        // 2. Delete original (Replace with Air)
        clearOriginalArea(player);
        
        // 3. Paste at new location (Player's current feet)
        pasteAt(player.getPosition(), data);
        player.sendMessage("§aBuild moved successfully!");
    }
}