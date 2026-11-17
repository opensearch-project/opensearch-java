/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5.sniffer;

import java.io.Closeable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.opensearch.client.transport.httpclient5.internal.Node;

/**
 * Periodically discovers cluster nodes via a {@link NodesSniffer} and publishes them to a
 * {@link NodeSetConsumer}. Also supports an immediate on-failure re-sniff (see
 * {@link SniffOnFailureListener}).
 */
public class Sniffer implements Closeable {

    private static final Log logger = LogFactory.getLog(Sniffer.class);
    /** How long {@link #close()} waits for an in-flight sniff to finish before interrupting it. */
    private static final long CLOSE_AWAIT_TIMEOUT_MILLIS = 1000L;

    private final NodesSniffer nodesSniffer;
    private final NodeSetConsumer consumer;
    private final long sniffIntervalMillis;
    private final long sniffAfterFailureDelayMillis;
    private final ScheduledExecutorService scheduler;
    private final boolean ownsScheduler;
    private final AtomicBoolean running = new AtomicBoolean(false);
    /** Set once {@link #close()} is called; a closed Sniffer is terminal and cannot be restarted. Guarded by {@code this}. */
    private boolean closed = false;
    /** The next sniff task and its future/fire-time. Guarded by {@code this}. */
    private ScheduledTask nextScheduledTask;
    /** Last node set actually published to the consumer, used to skip no-op republishes. Guarded by {@code this}. */
    private Set<Node> lastPublished = null;

    public Sniffer(NodesSniffer nodesSniffer, NodeSetConsumer consumer, long sniffIntervalMillis, long sniffAfterFailureDelayMillis) {
        this(nodesSniffer, consumer, sniffIntervalMillis, sniffAfterFailureDelayMillis, defaultScheduler(), true);
    }

    Sniffer(
        NodesSniffer nodesSniffer,
        NodeSetConsumer consumer,
        long sniffIntervalMillis,
        long sniffAfterFailureDelayMillis,
        ScheduledExecutorService scheduler,
        boolean ownsScheduler
    ) {
        this.nodesSniffer = Objects.requireNonNull(nodesSniffer, "nodesSniffer cannot be null");
        this.consumer = Objects.requireNonNull(consumer, "consumer cannot be null");
        this.sniffIntervalMillis = sniffIntervalMillis;
        this.sniffAfterFailureDelayMillis = sniffAfterFailureDelayMillis;
        this.scheduler = Objects.requireNonNull(scheduler, "scheduler cannot be null");
        this.ownsScheduler = ownsScheduler;
    }

    private static ScheduledExecutorService defaultScheduler() {
        return Executors.newScheduledThreadPool(1, r -> {
            Thread t = new Thread(r, "opensearch-sniffer");
            t.setDaemon(true);
            return t;
        });
    }

    /**
     * Starts periodic sniffing. Idempotent while open (repeated calls before {@link #close()} are
     * no-ops). The first sniff runs immediately. A {@code Sniffer} is single-use: once {@link #close()}
     * has been called it is terminally closed and this method throws {@link IllegalStateException}.
     *
     * @throws IllegalStateException if this Sniffer has already been closed
     */
    public synchronized void start() {
        if (closed) {
            throw new IllegalStateException("Sniffer has been closed and cannot be restarted");
        }
        if (running.compareAndSet(false, true)) {
            scheduleSniff(0L);
        }
    }

    /** Triggers an out-of-band sniff soon (after the configured failure delay). No-op if not running. */
    public synchronized void sniffOnFailure() {
        if (running.get()) {
            scheduleSniff(sniffAfterFailureDelayMillis);
        }
    }

    /**
     * Schedules a sniff to fire after {@code delayMillis}, coalescing with any already-pending sniff.
     * If a not-yet-started sniff is already due at or before the requested time it is kept — so a
     * storm of failure triggers (which fire on every failed request) can never push the next sniff
     * further out, nor starve the periodic sniff. If the pending sniff has already started, a fresh
     * one is scheduled to follow it. Guarded by {@code this}.
     */
    private void scheduleSniff(long delayMillis) {
        if (!running.get()) {
            return;
        }
        long fireTimeNanos = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(delayMillis);
        ScheduledTask pending = this.nextScheduledTask;
        if (pending != null && pending.isWaiting() && pending.fireTimeNanos - fireTimeNanos <= 0) {
            return; // an unstarted sniff is already scheduled at or before the requested time
        }
        if (pending != null) {
            pending.skip(); // cancel it if it hasn't started; an already-started one is left to finish
        }
        try {
            Task task = new Task();
            ScheduledFuture<?> future = scheduler.schedule(task, delayMillis, TimeUnit.MILLISECONDS);
            this.nextScheduledTask = new ScheduledTask(task, future, fireTimeNanos);
        } catch (RejectedExecutionException e) {
            logger.debug("sniffer scheduler is shut down; not scheduling next sniff");
        }
    }

    private void performSniff() {
        long nextDelayMillis = sniffIntervalMillis;
        try {
            List<Node> nodes = nodesSniffer.sniff();
            if (!running.get()) {
                return; // closed while sniffing; do not publish or reschedule
            }
            if (nodes != null && !nodes.isEmpty()) {
                publishIfChanged(nodes);
            } else {
                logger.warn("sniff returned no nodes; keeping current node list");
            }
        } catch (Throwable e) {
            logger.warn("error while sniffing nodes, will retry", e);
            nextDelayMillis = sniffAfterFailureDelayMillis;
        }
        synchronized (this) {
            scheduleSniff(nextDelayMillis);
        }
    }

    /**
     * Publishes {@code nodes} only when the discovered membership differs from what was last
     * published. Republishing an unchanged set would reset the transport's per-host failure denylist
     * (see {@code ApacheHttpClient5Transport.setNodes}), reviving still-registered-but-dead hosts on a
     * fixed cadence and defeating the exponential backoff. Order within the set is irrelevant, so the
     * comparison is set-based.
     * <p>
     * Synchronized because {@link #scheduleSniff(long)} can let a sniff already in flight run
     * concurrently with a freshly scheduled one (see its javadoc); without this, two overlapping
     * {@code performSniff()} calls could both read the same stale {@link #lastPublished}, both pass
     * the unchanged-set check, and both publish.
     * <p>
     * The method also re-checks {@link #running} under the lock so that no publish can occur after
     * {@link #close()} has returned: {@code performSniff()} tests {@code running} outside any lock,
     * but both this method and {@code close()} are synchronized on the same monitor, so re-checking
     * here closes the check-then-act window.
     */
    private synchronized void publishIfChanged(List<Node> nodes) {
        // Re-check under the lock: performSniff's running check happens outside any lock, so close()
        // (also synchronized on this) can flip running to false in the gap before we publish. Both
        // methods contend for the same monitor, so re-checking here guarantees no publish lands after
        // close() has returned.
        if (!running.get()) {
            return;
        }
        Set<Node> discovered = new HashSet<>(nodes);
        if (discovered.equals(lastPublished)) {
            logger.debug("sniffed node set unchanged; not republishing");
            return;
        }
        consumer.accept(nodes);
        lastPublished = discovered;
    }

    /**
     * Terminally closes this Sniffer: stops sniffing and, if this Sniffer owns its scheduler, shuts
     * it down. Idempotent. After close the Sniffer cannot be restarted ({@link #start()} throws).
     * <p>
     * When this Sniffer owns its scheduler, close gives an in-flight sniff a bounded chance to finish
     * gracefully ({@link #CLOSE_AWAIT_TIMEOUT_MILLIS}ms) and then interrupts it via
     * {@code shutdownNow()}. The scheduler shutdown deliberately runs outside the {@code synchronized}
     * block: otherwise the closing thread would hold the monitor that an in-flight {@code performSniff}
     * needs to publish or reschedule, stalling the await for its full timeout.
     */
    @Override
    public void close() {
        synchronized (this) {
            closed = true;
            if (running.compareAndSet(true, false) && nextScheduledTask != null) {
                nextScheduledTask.skip();
            }
        }
        if (ownsScheduler) {
            scheduler.shutdown();
            try {
                if (!scheduler.awaitTermination(CLOSE_AWAIT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)) {
                    scheduler.shutdownNow();
                }
            } catch (InterruptedException e) {
                scheduler.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * A single sniff execution whose lifecycle is {@code WAITING -> (STARTED | SKIPPED)}, enforced by
     * CAS. This lets {@link #scheduleSniff(long)} tell apart a sniff that is still pending (and can be
     * coalesced with or cancelled) from one that has already begun running (and must be left to finish).
     */
    private final class Task implements Runnable {
        private final AtomicReference<TaskState> state = new AtomicReference<>(TaskState.WAITING);

        @Override
        public void run() {
            if (!state.compareAndSet(TaskState.WAITING, TaskState.STARTED)) {
                return; // skipped before it could start
            }
            performSniff();
        }

        boolean isWaiting() {
            return state.get() == TaskState.WAITING;
        }

        /** Prevents the task from running if it has not started yet. No effect once started. */
        void skip() {
            state.compareAndSet(TaskState.WAITING, TaskState.SKIPPED);
        }
    }

    /** Bundles a {@link Task} with its scheduled future and intended fire time. */
    private static final class ScheduledTask {
        private final Task task;
        private final ScheduledFuture<?> future;
        private final long fireTimeNanos;

        ScheduledTask(Task task, ScheduledFuture<?> future, long fireTimeNanos) {
            this.task = task;
            this.future = future;
            this.fireTimeNanos = fireTimeNanos;
        }

        boolean isWaiting() {
            return task.isWaiting();
        }

        void skip() {
            task.skip();
            future.cancel(false);
        }
    }

    private enum TaskState {
        WAITING,
        STARTED,
        SKIPPED
    }
}
