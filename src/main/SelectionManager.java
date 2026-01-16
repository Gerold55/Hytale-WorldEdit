package com.hytale.worldedit;

import hytale.api.player.Player;
import hytale.api.math.Vector3;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * PACKAGE: WE.Core.Selection
 * LOCATION: /src/main/java/com/hytale/worldedit/SelectionManager.java
 * DESCRIPTION: Stores and retrieves Point A and Point B for every player.
 */
public class SelectionManager {
    
    // Store selections by Player UUID
    private static final Map<UUID, Selection> playerSelections = new HashMap<>();

    public static void setA(Player player, Vector3 pos) {
        Selection sel = playerSelections.computeIfAbsent(player.getUniqueId(), k -> new Selection());
        sel.pos1 = pos;
    }

    public static void setB(Player player, Vector3 pos) {
        Selection sel = playerSelections.computeIfAbsent(player.getUniqueId(), k -> new Selection());
        sel.pos2 = pos;
    }

    public static Selection get(Player player) {
        return playerSelections.get(player.getUniqueId());
    }

    // Helper class to hold the two points
    public static class Selection {
        public Vector3 pos1;
        public Vector3 pos2;

        public boolean isComplete() {
            return pos1 != null && pos2 != null;
        }
    }
}