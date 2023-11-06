package io.tofpu.template.plugin.command;

import io.tofpu.template.plugin.TemplatePlugin;
import revxrsal.commands.bukkit.BukkitCommandHandler;

public class PluginCommandHandler {
    public void init(TemplatePlugin plugin) {
        BukkitCommandHandler commandHandler = BukkitCommandHandler.create(plugin);

        commandHandler.registerResponseHandler(String.class, (response, actor, command) -> {
            if (response == null) return;
            actor.reply(response);
        });

        commandHandler.setHelpWriter((command, actor) -> String.format("/%s %s - %s", command.getPath().toRealString(), command.getUsage(), command.getDescription()));
    }
}
