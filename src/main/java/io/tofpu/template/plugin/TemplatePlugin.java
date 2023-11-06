package io.tofpu.template.plugin;

import io.tofpu.template.plugin.command.PluginCommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class TemplatePlugin extends JavaPlugin {
    private final PluginCommandHandler commandHandler = new PluginCommandHandler();

    @Override
    public void onEnable() {
        commandHandler.init(this);
    }

    @Override
    public void onDisable() {

    }
}
