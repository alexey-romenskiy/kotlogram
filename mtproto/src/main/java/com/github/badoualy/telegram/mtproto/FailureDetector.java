package com.github.badoualy.telegram.mtproto;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FailureDetector {

    private static final FailureDetector INSTANCE = new FailureDetector();

    private final Set<Listener> listeners = new HashSet<>();

    private boolean failed;

    public static FailureDetector getInstance() {
        return INSTANCE;
    }

    private FailureDetector() {
        // empty
    }

    public synchronized void reset() {
        failed = false;
    }

    public void failed() {

        final List<Listener> listeners;

        synchronized (this) {

            if (failed) {
                return;
            }

            failed = true;
            listeners = new ArrayList<>(this.listeners);
        }

        for (final Listener listener : listeners) {
            listener.failed();
        }
    }

    public void addListener(@NotNull Listener listener) {

        synchronized (this) {

            listeners.add(listener);

            if (!failed) {
                return;
            }
        }

        listener.failed();
    }

    public synchronized void removeListener(@NotNull Listener listener) {
        listeners.remove(listener);
    }

    public interface Listener {

        void failed();
    }
}
