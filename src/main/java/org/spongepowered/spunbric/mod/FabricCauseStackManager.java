package org.spongepowered.spunbric.mod;

import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.event.cause.EventContextKey;

import java.util.Optional;

// TODO Dummy Impl
public class FabricCauseStackManager implements CauseStackManager {
    @Override
    public Cause getCurrentCause() {
        return null;
    }

    @Override
    public EventContext getCurrentContext() {
        return null;
    }

    @Override
    public CauseStackManager pushCause(Object obj) {
        return null;
    }

    @Override
    public Object popCause() {
        return null;
    }

    @Override
    public void popCauses(int n) {

    }

    @Override
    public Object peekCause() {
        return null;
    }

    @Override
    public StackFrame pushCauseFrame() {
        return null;
    }

    @Override
    public void popCauseFrame(StackFrame handle) {

    }

    @Override
    public <T> CauseStackManager addContext(EventContextKey<T> key, T value) {
        return null;
    }

    @Override
    public <T> Optional<T> getContext(EventContextKey<T> key) {
        return Optional.empty();
    }

    @Override
    public <T> Optional<T> removeContext(EventContextKey<T> key) {
        return Optional.empty();
    }
}
