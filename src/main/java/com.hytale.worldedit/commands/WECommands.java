package com.hytale.worldedit.commands;

import hytale.api.command.AbstractPlayerCommand;
import hytale.api.player.Player;
import com.hytale.worldedit.SelectionManager;
import com.hytale.worldedit.ClipboardManager;

/**
 * PACKAGE: WE.Core.Commands
 * DESCRIPTION: Core WorldEdit commands implementation.
 */
public class WECommands extends AbstractPlayerCommand {
    private final ClipboardManager clipboard;

    public WECommands(String name, ClipboardManager clipboard) {
        super(name, "WorldEdit command: " + name);
        this.clipboard = clipboard;
    }

    @Override
    public void execute(Player player, String[] args) {
        // Selection check
        SelectionManager.Selection sel = SelectionManager.get(player);
        if (sel == null || !sel.isComplete()) {
            player.sendMessage("§cError: You must select two points with your Stick first!");
            return;
        }

        switch (getName().toLowerCase()) {
            case "//copy":
                clipboard.capture(player, sel.pos1, sel.pos2);
                player.sendMessage("§b[WE] Selection copied!");
                break;
            case "//paste":
                clipboard.paste(player);
                player.sendMessage("§a[WE] Selection pasted!");
                break;
            case "//move":
                clipboard.moveSelection(player, sel.pos1, sel.pos2);
                player.sendMessage("§6[WE] Selection moved to your location!");
                break;
        }
    }
}