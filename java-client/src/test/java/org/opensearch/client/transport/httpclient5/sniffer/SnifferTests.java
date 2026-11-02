/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5.sniffer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.hc.core5.http.HttpHost;
import org.junit.Test;
import org.opensearch.client.transport.httpclient5.internal.Node;

public class SnifferTests {

    private static Node node(String host) {
        return new Node(new HttpHost("http", host, 9200));
    }

    /**
     * Waits until {@code t} is no longer actively executing its task (i.e. not RUNNABLE or BLOCKED) —
     * meaning it has parked back in the pool's task queue or terminated. Deadline-bounded so a stuck
     * thread fails the test quickly instead of hanging.
     */
    private static void awaitNotRunning(Thread t, long timeoutMillis) throws InterruptedException {
        long deadline = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(timeoutMillis);
        while (System.nanoTime() < deadline) {
            Thread.State st = t.getState();
            if (st != Thread.State.RUNNABLE && st != Thread.State.BLOCKED) {
                return;
            }
            Thread.sleep(1);
        }
    }

    @Test(expected = NullPointerException.class)
    public void constructor_rejectsNullNodesSniffer() {
        new Sniffer(null, nodes -> {}, TimeUnit.MINUTES.toMillis(5), 50L);
    }

    @Test(expected = NullPointerException.class)
    public void constructor_rejectsNullConsumer() {
        new Sniffer(() -> java.util.Collections.emptyList(), null, TimeUnit.MINUTES.toMillis(5), 50L);
    }

    @Test
    public void start_invokesConsumerWithSniffedNodes() throws Exception {
        List<Node> discovered = Arrays.asList(node("10.0.0.1"), node("10.0.0.2"));
        CountDownLatch latch = new CountDownLatch(1);
        CopyOnWriteArrayList<Node> received = new CopyOnWriteArrayList<>();

        NodesSniffer sniffer = () -> discovered;
        NodeSetConsumer consumer = nodes -> {
            received.addAll(nodes);
            latch.countDown();
        };

        try (Sniffer s = new Sniffer(sniffer, consumer, TimeUnit.MINUTES.toMillis(5), TimeUnit.SECONDS.toMillis(1))) {
            s.start();
            assertThat(latch.await(5, TimeUnit.SECONDS), is(true));
            assertThat(received.size(), is(2));
        }
    }

    @Test
    public void sniffFailure_isSwallowedAndRetryScheduled() throws Exception {
        AtomicInteger calls = new AtomicInteger();
        CountDownLatch twice = new CountDownLatch(2);

        NodesSniffer flaky = () -> {
            twice.countDown();
            if (calls.getAndIncrement() == 0) {
                throw new IOException("boom");
            }
            return Arrays.asList(node("10.0.0.9"));
        };

        try (Sniffer s = new Sniffer(flaky, nodes -> {}, TimeUnit.MINUTES.toMillis(5), 50L)) {
            s.start();
            // first attempt throws, retry scheduled after 50ms; expect >= 2 sniff attempts
            assertThat(twice.await(5, TimeUnit.SECONDS), is(true));
            assertThat(calls.get(), greaterThanOrEqualTo(2));
        }
    }

    @Test
    public void sniffError_isSwallowedAndRetryScheduled() throws Exception {
        AtomicInteger calls = new AtomicInteger();
        CountDownLatch twice = new CountDownLatch(2);

        NodesSniffer flaky = () -> {
            twice.countDown();
            if (calls.getAndIncrement() == 0) {
                throw new AssertionError("simulated Error from sniffer");
            }
            return Arrays.asList(node("10.0.0.9"));
        };

        try (Sniffer s = new Sniffer(flaky, nodes -> {}, TimeUnit.MINUTES.toMillis(5), 50L)) {
            s.start();
            // first attempt throws an Error, retry scheduled after 50ms; expect >= 2 sniff attempts
            assertThat(twice.await(5, TimeUnit.SECONDS), is(true));
            assertThat(calls.get(), greaterThanOrEqualTo(2));
        }
    }

    @Test
    public void unchangedNodeSet_isPublishedOnlyOnce() throws Exception {
        // The cluster keeps reporting the same membership every sniff. Republishing it would reset the
        // transport's per-host denylist backoff, so the sniffer must publish only the first time.
        List<Node> stable = Arrays.asList(node("10.0.0.1"), node("10.0.0.2"));
        AtomicInteger publishCalls = new AtomicInteger();
        CountDownLatch sniffedTwice = new CountDownLatch(2);

        NodesSniffer sniffer = () -> {
            sniffedTwice.countDown();
            return stable;
        };
        NodeSetConsumer consumer = nodes -> publishCalls.incrementAndGet();

        try (Sniffer s = new Sniffer(sniffer, consumer, 50L, 50L)) {
            s.start();
            assertThat(sniffedTwice.await(5, TimeUnit.SECONDS), is(true));
            // Sniffed at least twice, but membership never changed → exactly one publish.
            assertThat(publishCalls.get(), is(1));
        }
    }

    @Test
    public void changedNodeSet_isRepublished() throws Exception {
        // A real membership change (a node joins) must be published even though the previous set was
        // already published — otherwise the transport never learns about the new node.
        AtomicInteger calls = new AtomicInteger();
        CountDownLatch publishedTwice = new CountDownLatch(2);

        NodesSniffer sniffer = () -> {
            int n = calls.getAndIncrement();
            return n == 0 ? Arrays.asList(node("10.0.0.1")) : Arrays.asList(node("10.0.0.1"), node("10.0.0.2"));
        };
        NodeSetConsumer consumer = nodes -> publishedTwice.countDown();

        try (Sniffer s = new Sniffer(sniffer, consumer, 50L, 50L)) {
            s.start();
            assertThat(publishedTwice.await(5, TimeUnit.SECONDS), is(true));
        }
    }

    @Test
    public void failureStorm_doesNotStarveSniffing() throws Exception {
        // Periodic interval far out; failure delay short. A continuous storm of onFailure triggers
        // (which fire on every failed request) must not perpetually defer the sniff: the coalescing
        // only ever moves the next sniff sooner, never further out. The old cancel-and-reschedule
        // behavior would leave only the initial sniff run during the storm (count == 1).
        AtomicInteger sniffs = new AtomicInteger();
        NodesSniffer sniffer = () -> {
            sniffs.incrementAndGet();
            return Arrays.asList(node("10.0.0.1"));
        };

        try (Sniffer s = new Sniffer(sniffer, nodes -> {}, TimeUnit.MINUTES.toMillis(5), 100L)) {
            s.start();
            long end = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(800);
            while (System.nanoTime() < end) {
                s.sniffOnFailure();
                Thread.sleep(30);
            }
            // Initial sniff + at least one failure-triggered sniff that actually fired during the storm.
            assertThat(sniffs.get(), greaterThanOrEqualTo(2));
        }
    }

    @Test
    public void closeAfterRunningCheck_doesNotPublish() throws Exception {
        // performSniff() checks running OUTSIDE the lock, then calls the synchronized publishIfChanged().
        // We hold the Sniffer's monitor so the scheduler thread passes the outside-the-lock check and
        // blocks entering publishIfChanged; we close() (reentrant) to flip running=false, then release.
        // The guard inside publishIfChanged must observe running==false and skip the publish.
        List<Node> nodes = Arrays.asList(node("10.0.0.1"));
        AtomicInteger publishCalls = new AtomicInteger();
        CountDownLatch sniffReturned = new CountDownLatch(1);
        AtomicReference<Thread> worker = new AtomicReference<>();

        NodesSniffer sniffer = () -> {
            worker.set(Thread.currentThread());
            sniffReturned.countDown();
            return nodes;
        };
        NodeSetConsumer consumer = n -> publishCalls.incrementAndGet();

        Sniffer s = new Sniffer(sniffer, consumer, TimeUnit.MINUTES.toMillis(5), 50L);
        synchronized (s) {
            s.start();
            assertThat(sniffReturned.await(5, TimeUnit.SECONDS), is(true));
            // Deterministically wait until the sniff thread is BLOCKED entering publishIfChanged
            // (whose monitor we hold) instead of hoping a fixed sleep is long enough.
            Thread t = worker.get();
            long deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5);
            while (t.getState() != Thread.State.BLOCKED && System.nanoTime() < deadline) {
                Thread.sleep(1);
            }
            assertThat("sniff thread should be blocked entering publishIfChanged", t.getState(), is(Thread.State.BLOCKED));
            s.close(); // reentrant; flips running=false while the sniff thread is blocked on the monitor
        }
        // Monitor released: the sniff thread now enters publishIfChanged and must observe running==false.
        worker.get().join(TimeUnit.SECONDS.toMillis(5));
        assertThat(publishCalls.get(), is(0));
    }

    @Test
    public void overlappingSniffs_publishUnchangedSetOnlyOnce() throws Exception {
        // scheduleSniff() deliberately lets an already-STARTED sniff run to completion concurrently
        // with a freshly scheduled one (see its javadoc). The default single-threaded scheduler
        // serializes actual execution, so a multi-threaded scheduler (via the package-private
        // constructor) is needed to force two performSniff() calls to genuinely overlap and race on
        // publishIfChanged's check-then-set of lastPublished.
        List<Node> stable = Arrays.asList(node("10.0.0.1"), node("10.0.0.2"));
        AtomicInteger callCount = new AtomicInteger();
        CountDownLatch task1Started = new CountDownLatch(1);
        CountDownLatch bothBlocked = new CountDownLatch(2);
        CountDownLatch release = new CountDownLatch(1);
        CountDownLatch released = new CountDownLatch(2);
        AtomicReference<Thread> worker1 = new AtomicReference<>();
        AtomicReference<Thread> worker2 = new AtomicReference<>();

        NodesSniffer blockingTwice = () -> {
            int n = callCount.incrementAndGet();
            if (n == 1) {
                worker1.set(Thread.currentThread());
                task1Started.countDown();
            }
            if (n == 2) {
                worker2.set(Thread.currentThread());
            }
            if (n <= 2) {
                bothBlocked.countDown();
                try {
                    release.await(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                released.countDown();
            }
            return stable;
        };
        AtomicInteger publishCalls = new AtomicInteger();
        NodeSetConsumer consumer = nodes -> publishCalls.incrementAndGet();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2, r -> {
            Thread t = new Thread(r, "sniffer-race-test");
            t.setDaemon(true);
            return t;
        });

        try (Sniffer s = new Sniffer(blockingTwice, consumer, TimeUnit.MINUTES.toMillis(5), 5L, scheduler, true)) {
            s.start();
            assertThat(task1Started.await(5, TimeUnit.SECONDS), is(true));
            // Task1 is now STARTED (blocked in sniff()), so this schedules a second, concurrent sniff
            // instead of being coalesced into the pending one.
            s.sniffOnFailure();
            assertThat(bothBlocked.await(5, TimeUnit.SECONDS), is(true));
            release.countDown();
            // First ensure both sniff threads have actually woken from the release latch and are past
            // it (RUNNABLE, heading into publishIfChanged); a thread still TIMED_WAITING on `release`
            // would otherwise be mistaken for "already finished" by the state poll below.
            assertThat(released.await(5, TimeUnit.SECONDS), is(true));
            // Then wait until both have finished performSniff() (parked back in the pool), so a delayed
            // second publish cannot slip in after the assert.
            awaitNotRunning(worker1.get(), TimeUnit.SECONDS.toMillis(5));
            awaitNotRunning(worker2.get(), TimeUnit.SECONDS.toMillis(5));
            assertThat(publishCalls.get(), is(1));
        }
    }

    @Test
    public void startAfterClose_throwsIllegalStateException() throws Exception {
        Sniffer s = new Sniffer(() -> java.util.Collections.emptyList(), nodes -> {}, TimeUnit.MINUTES.toMillis(5), 50L);
        s.start();
        s.close();
        try {
            s.start();
            org.junit.Assert.fail("expected IllegalStateException on restart after close");
        } catch (IllegalStateException expected) {
            // terminal close: restart must be rejected loudly
        }
    }

    @Test
    public void startAfterCloseBeforeStart_throwsIllegalStateException() throws Exception {
        // close() before any start() must still be terminal.
        Sniffer s = new Sniffer(() -> java.util.Collections.emptyList(), nodes -> {}, TimeUnit.MINUTES.toMillis(5), 50L);
        s.close();
        try {
            s.start();
            org.junit.Assert.fail("expected IllegalStateException when starting a Sniffer closed before start");
        } catch (IllegalStateException expected) {
            // expected
        }
    }

    @Test
    public void close_awaitsThenInterruptsInFlightSniff() throws Exception {
        // A sniff that blocks far longer than CLOSE_AWAIT_TIMEOUT_MILLIS. close() must not block for
        // the full block: it awaits ~1s, then shutdownNow() interrupts the sniff.
        CountDownLatch sniffStarted = new CountDownLatch(1);
        CountDownLatch sniffInterrupted = new CountDownLatch(1);

        NodesSniffer blocking = () -> {
            sniffStarted.countDown();
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(30));
            } catch (InterruptedException e) {
                sniffInterrupted.countDown();
                Thread.currentThread().interrupt();
            }
            return Arrays.asList(node("10.0.0.1"));
        };

        Sniffer s = new Sniffer(blocking, nodes -> {}, TimeUnit.MINUTES.toMillis(5), 50L);
        s.start();
        assertThat(sniffStarted.await(5, TimeUnit.SECONDS), is(true));

        long startNanos = System.nanoTime();
        s.close();
        long elapsedMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);

        // Must return shortly after the await timeout, not after the full 30s sleep.
        assertThat("close() should return shortly after the await timeout", elapsedMillis < 5000L, is(true));
        // shutdownNow()'s interrupt must reach the blocked sniff.
        assertThat(sniffInterrupted.await(5, TimeUnit.SECONDS), is(true));
    }
}
