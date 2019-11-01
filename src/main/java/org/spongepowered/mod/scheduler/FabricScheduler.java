package org.spongepowered.mod.scheduler;

import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.scheduler.ScheduledTask;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.scheduler.Task;
import org.spongepowered.api.scheduler.TaskExecutorService;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class FabricScheduler implements Scheduler {
    @Override
    public Optional<ScheduledTask> getTaskById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Set<ScheduledTask> getTasksByName(String pattern) {
        return null;
    }

    @Override
    public Set<ScheduledTask> getTasks() {
        return null;
    }

    @Override
    public Set<ScheduledTask> getTasksByPlugin(PluginContainer plugin) {
        return null;
    }

    @Override
    public TaskExecutorService createExecutor(PluginContainer plugin) {
        return null;
    }

    @Override
    public ScheduledTask submit(Task task) {
        return null;
    }
}
