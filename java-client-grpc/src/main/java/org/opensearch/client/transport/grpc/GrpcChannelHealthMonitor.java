/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Monitors the health of a gRPC {@link ManagedChannel} using its built-in connectivity state machine.
 * <p>
 * gRPC channels have 5 states:
 * <ul>
 *   <li><b>IDLE</b> — No active connection, will connect on next RPC</li>
 *   <li><b>CONNECTING</b> — Establishing connection (name resolution, TCP, TLS handshake)</li>
 *   <li><b>READY</b> — Connection established, RPCs can be sent</li>
 *   <li><b>TRANSIENT_FAILURE</b> — Connection lost, retrying with backoff</li>
 *   <li><b>SHUTDOWN</b> — Channel has been shut down permanently</li>
 * </ul>
 * <p>
 * This class provides:
 * <ul>
 *   <li>{@link #isReady()} — Quick check if channel can serve RPCs immediately</li>
 *   <li>{@link #isHealthy()} — Channel is READY, IDLE, or CONNECTING (not failed/shutdown)</li>
 *   <li>{@link #getState()} — Current connectivity state</li>
 *   <li>{@link #waitForReady(long, TimeUnit)} — Block until channel becomes READY</li>
 *   <li>{@link #startMonitoring()} — Background state monitoring with callbacks</li>
 * </ul>
 * <p>
 * Usage:
 * <pre>{@code
 * GrpcChannelHealthMonitor monitor = new GrpcChannelHealthMonitor(channel);
 * monitor.startMonitoring(); // begin watching state changes
 *
 * if (monitor.isReady()) {
 *     // channel is connected and ready
 * }
 *
 * // Block until ready (with timeout)
 * boolean ready = monitor.waitForReady(5, TimeUnit.SECONDS);
 * }</pre>
 */
public class GrpcChannelHealthMonitor {

    private static final Logger logger = Logger.getLogger(GrpcChannelHealthMonitor.class.getName());

    private final ManagedChannel channel;
    private final AtomicBoolean monitoring = new AtomicBoolean(false);
    private volatile ConnectivityState lastKnownState;
    private volatile StateChangeListener listener;

    /**
     * Callback interface for channel state changes.
     */
    @FunctionalInterface
    public interface StateChangeListener {
        /**
         * Called when the channel state changes.
         *
         * @param previousState the state before the change
         * @param newState      the current state after the change
         */
        void onStateChanged(ConnectivityState previousState, ConnectivityState newState);
    }

    public GrpcChannelHealthMonitor(ManagedChannel channel) {
        this.channel = channel;
        this.lastKnownState = channel.getState(false); // don't trigger connection
    }

    /**
     * Returns the current connectivity state of the channel.
     * Does NOT trigger a connection attempt if the channel is IDLE.
     */
    public ConnectivityState getState() {
        lastKnownState = channel.getState(false);
        return lastKnownState;
    }

    /**
     * Returns the current connectivity state, optionally triggering a connection
     * if the channel is currently IDLE.
     *
     * @param requestConnection if true and state is IDLE, initiates connection
     */
    public ConnectivityState getState(boolean requestConnection) {
        lastKnownState = channel.getState(requestConnection);
        return lastKnownState;
    }

    /**
     * Returns true if the channel is in READY state — connection is established
     * and RPCs can be sent immediately without waiting.
     */
    public boolean isReady() {
        return channel.getState(false) == ConnectivityState.READY;
    }

    /**
     * Returns true if the channel is in a healthy state — READY, IDLE, or CONNECTING.
     * Returns false if in TRANSIENT_FAILURE or SHUTDOWN.
     */
    public boolean isHealthy() {
        ConnectivityState state = channel.getState(false);
        return state == ConnectivityState.READY || state == ConnectivityState.IDLE || state == ConnectivityState.CONNECTING;
    }

    /**
     * Returns true if the channel is in TRANSIENT_FAILURE — connection was lost
     * and the channel is retrying with backoff.
     */
    public boolean isInTransientFailure() {
        return channel.getState(false) == ConnectivityState.TRANSIENT_FAILURE;
    }

    /**
     * Returns true if the channel has been shut down.
     */
    public boolean isShutdown() {
        return channel.isShutdown() || channel.getState(false) == ConnectivityState.SHUTDOWN;
    }

    /**
     * Blocks until the channel reaches READY state or the timeout expires.
     * Triggers a connection attempt if the channel is IDLE.
     *
     * @param timeout the maximum time to wait
     * @param unit    the time unit
     * @return true if the channel became READY within the timeout, false otherwise
     * @throws InterruptedException if the waiting thread is interrupted
     */
    public boolean waitForReady(long timeout, TimeUnit unit) throws InterruptedException {
        long deadlineNanos = System.nanoTime() + unit.toNanos(timeout);

        // Trigger connection if idle
        ConnectivityState state = channel.getState(true);

        while (state != ConnectivityState.READY) {
            if (state == ConnectivityState.SHUTDOWN) {
                return false; // permanently closed
            }

            long remainingNanos = deadlineNanos - System.nanoTime();
            if (remainingNanos <= 0) {
                return false; // timeout
            }

            // Wait for state to change
            Object lock = new Object();
            synchronized (lock) {
                final ConnectivityState currentState = state;
                channel.notifyWhenStateChanged(currentState, () -> {
                    synchronized (lock) {
                        lock.notifyAll();
                    }
                });
                lock.wait(TimeUnit.NANOSECONDS.toMillis(remainingNanos));
            }

            state = channel.getState(true);
        }

        return true;
    }

    /**
     * Initiates a connection if the channel is IDLE.
     * This is useful to "warm up" the channel before the first RPC,
     * reducing latency on the first actual request.
     */
    public void connectIfIdle() {
        ConnectivityState state = channel.getState(false);
        if (state == ConnectivityState.IDLE) {
            channel.getState(true); // triggers connection
            logger.log(Level.FINE, "Triggered connection from IDLE state");
        }
    }

    /**
     * Starts background monitoring of channel state changes.
     * Logs state transitions and invokes the registered {@link StateChangeListener}.
     * <p>
     * Monitoring continues until the channel is SHUTDOWN or {@link #stopMonitoring()} is called.
     */
    public void startMonitoring() {
        if (!monitoring.compareAndSet(false, true)) {
            return; // already monitoring
        }
        lastKnownState = channel.getState(false);
        watchForStateChange(lastKnownState);
    }

    /**
     * Stops background state monitoring.
     */
    public void stopMonitoring() {
        monitoring.set(false);
    }

    /**
     * Sets a listener that will be called on every state change.
     *
     * @param listener the callback, or null to remove
     */
    public void setStateChangeListener(StateChangeListener listener) {
        this.listener = listener;
    }

    private void watchForStateChange(ConnectivityState currentState) {
        if (!monitoring.get() || currentState == ConnectivityState.SHUTDOWN) {
            return;
        }

        channel.notifyWhenStateChanged(currentState, () -> {
            ConnectivityState newState = channel.getState(false);
            ConnectivityState previousState = lastKnownState;
            lastKnownState = newState;

            logger.log(Level.INFO, "gRPC channel state changed: {0} → {1}", new Object[] { previousState, newState });

            // Invoke listener
            StateChangeListener currentListener = this.listener;
            if (currentListener != null) {
                try {
                    currentListener.onStateChanged(previousState, newState);
                } catch (Exception e) {
                    logger.log(Level.WARNING, "StateChangeListener threw exception", e);
                }
            }

            // Continue watching
            watchForStateChange(newState);
        });
    }
}
