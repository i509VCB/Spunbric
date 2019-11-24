package org.spongepowered.spunbric.mod;

import org.spongepowered.api.command.Command;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.exception.CommandException;
import org.spongepowered.api.command.manager.CommandManager;
import org.spongepowered.api.command.manager.CommandMapping;
import org.spongepowered.api.command.manager.FailedRegistrationException;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.channel.MessageReceiver;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

// TODO Dummy Impl
public class FabricCommandManager implements CommandManager {
    @Override
    public CommandResult process(String arguments) throws CommandException {
        return null;
    }

    @Override
    public <T extends Subject & MessageReceiver> CommandResult process(T subjectReceiver, String arguments) throws CommandException {
        return null;
    }

    @Override
    public CommandResult process(Subject subject, MessageChannel channel, String arguments) throws CommandException {
        return null;
    }

    @Override
    public List<String> suggest(String arguments) {
        return null;
    }

    @Override
    public <T extends Subject & MessageReceiver> List<String> suggest(T subjectReceiver, String arguments) {
        return null;
    }

    @Override
    public List<String> suggest(Subject subject, MessageChannel receiver, String arguments) {
        return null;
    }

    @Override
    public CommandMapping register(PluginContainer container, Command command, String primaryAlias, String... secondaryAliases) throws FailedRegistrationException {
        return null;
    }

    @Override
    public Optional<CommandMapping> unregister(CommandMapping mapping) {
        return Optional.empty();
    }

    @Override
    public Collection<CommandMapping> unregisterAll(PluginContainer container) {
        return null;
    }

    @Override
    public Collection<PluginContainer> getPlugins() {
        return null;
    }
}
