package com.hytale.worldedit;

import hytale.api.plugin.JavaPlugin;
import com.hytale.worldedit.commands.WECommands;

public class WorldEditMain extends JavaPlugin {
    private final ClipboardManager clipboard = new ClipboardManager();

    @Override
    public void onEnable() {
        // Register the commands in the Hytale Command Registry
        getCommandRegistry().registerCommand(new WECommands("//copy", clipboard));
        getCommandRegistry().registerCommand(new WECommands("//paste", clipboard));
        getCommandRegistry().registerCommand(new WECommands("//move", clipboard));
        
        getLogger().info("Hytale WorldEdit Enabled with Stick support!");
    }
}