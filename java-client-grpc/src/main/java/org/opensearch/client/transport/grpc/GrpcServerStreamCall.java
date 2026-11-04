/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import org.opensearch.client.transport.TransportException;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.grpc.translation.GrpcStatusConverter;

/**
 * A server-streaming call whose messages the caller pulls. gRPC delivers at most {@code prefetch} messages ahead of the
 * caller, so a caller that stops pulling stops the stream's HTTP/2 window, and with it the server, without holding up
 * other calls on the channel.
 * <p>
 * The gRPC listener only queues messages and records how the call closed; everything else happens on the caller's
 * thread. A call that fails before its first message with a retryable status is retried with the transport's retry
 * settings. A call that received a message is never retried.
 */
final class GrpcServerStreamCall<RequestT, ProtoT, MessageT> implements GrpcServerStream<MessageT> {

    /** How long {@link #close()} waits for a cancelled call to close. */
    private static final long CLOSE_WAIT_MILLIS = 5_000;

    private final Channel channel;
    private final MethodDescriptor<ProtoT, MessageT> method;
    private final GrpcStreamingEndpoint<RequestT, ProtoT, MessageT> endpoint;
    private final ProtoT message;
    private final Metadata headers;
    private final int prefetch;
    private final int maxRetries;
    private final long retryBackoffMillis;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition changed = lock.newCondition();
    private final ArrayDeque<MessageT> queue = new ArrayDeque<>();
    /** The current attempt; replaced only by a retry, on the caller's thread. */
    private ClientCall<ProtoT, MessageT> call;
    private Context.CancellableContext context;
    /** How the current attempt closed, or {@code null} while it runs. */
    private Status closedStatus;
    private Metadata closedTrailers;
    private boolean receivedAny;
    private boolean cancelledByCaller;
    private boolean ended;
    private int attempts;
    /** What the endpoint's decoder threw, if it did: gRPC then cancels the call with it as the cause. */
    private volatile Throwable decodeFailure;

    GrpcServerStreamCall(
        Channel channel,
        GrpcStreamingEndpoint<RequestT, ProtoT, MessageT> endpoint,
        ProtoT message,
        Metadata headers,
        int maxRetries,
        long retryBackoffMillis
    ) {
        MethodDescriptor<ProtoT, ?> declared = endpoint.method();
        if (declared.getType() != MethodDescriptor.MethodType.SERVER_STREAMING) {
            throw new IllegalArgumentException("Method [" + declared.getFullMethodName() + "] is not server-streaming");
        }
        this.channel = channel;
        // Same method, name and type; only the decoding of response messages differs.
        this.method = declared.toBuilder(declared.getRequestMarshaller(), new Decoder(endpoint.responseMarshaller())).build();
        this.endpoint = endpoint;
        this.message = message;
        this.headers = headers;
        this.prefetch = Math.max(1, endpoint.prefetch());
        this.maxRetries = Math.max(0, maxRetries);
        this.retryBackoffMillis = Math.max(0, retryBackoffMillis);
    }

    /**
     * Returns the request metadata: the headers of the options as unary calls send them (see
     * {@link GrpcTransport#requestHeaders}), then the endpoint's headers, which replace those of the same name.
     */
    static <RequestT> Metadata headers(
        RequestT request,
        GrpcStreamingEndpoint<RequestT, ?, ?> endpoint,
        @Nullable TransportOptions options
    ) {
        Metadata headers = GrpcTransport.requestHeaders(options);
        for (Map.Entry<String, String> header : endpoint.headers(request).entrySet()) {
            Metadata.Key<String> key = Metadata.Key.of(header.getKey().toLowerCase(Locale.ROOT), Metadata.ASCII_STRING_MARSHALLER);
            headers.removeAll(key);
            headers.put(key, header.getValue());
        }
        return headers;
    }

    /** Starts the first attempt. */
    void start() {
        attempt();
    }

    /**
     * Starts an attempt, unless the caller cancelled or closed the call, so that a retry does not outlive a cancel() or
     * close() during its backoff.
     */
    private void attempt() {
        // A copy per attempt, as interceptors may change the metadata of a call, e.g. add credentials.
        Metadata metadata = new Metadata();
        metadata.merge(headers);
        final Context.CancellableContext attemptContext;
        ClientCall<ProtoT, MessageT> attemptCall = null;
        lock.lock();
        try {
            if (cancelledByCaller || ended) {
                return;
            }
            // Under the lock, so that a later cancel() cancels this attempt's context.
            attemptContext = Context.current().withCancellation();
            attempts++;
            closedStatus = null;
            closedTrailers = null;
            context = attemptContext;
        } finally {
            lock.unlock();
        }
        Context previous = attemptContext.attach();
        try {
            attemptCall = channel.newCall(method, CallOptions.DEFAULT);
            lock.lock();
            try {
                call = attemptCall;
            } finally {
                lock.unlock();
            }
            attemptCall.start(new Listener(attemptCall), metadata);
            attemptCall.request(prefetch);
            attemptCall.sendMessage(message);
            attemptCall.halfClose();
        } catch (RuntimeException | Error e) {
            failedToStart(attemptCall, attemptContext, e);
            throw e;
        } finally {
            attemptContext.detach(previous);
        }
    }

    /**
     * Ends the call after an attempt failed to start, e.g. because an interceptor threw, as JwtAuthInterceptor does when
     * its token supplier fails. gRPC closes no call that did not start, so without this, close() would wait for the
     * attempt to close and a later next() would wait forever.
     */
    private void failedToStart(@Nullable ClientCall<ProtoT, MessageT> attemptCall, Context.CancellableContext attemptContext, Throwable e) {
        if (attemptCall != null) {
            // In case it started: cancelling a call that did not start does nothing.
            attemptCall.cancel("gRPC stream failed to start", e);
        }
        attemptContext.cancel(e);
        lock.lock();
        try {
            // The attempt's listener, if any, is ignored from here on, so this status stays.
            call = null;
            closedStatus = Status.INTERNAL.withDescription("gRPC stream failed to start").withCause(e);
            closedTrailers = new Metadata();
            ended = true;
            changed.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /** Decodes with the endpoint's marshaller, recording what it throws, to tell a decoding failure from other cancellations. */
    private final class Decoder implements MethodDescriptor.Marshaller<MessageT> {
        private final MethodDescriptor.Marshaller<MessageT> marshaller;

        Decoder(MethodDescriptor.Marshaller<MessageT> marshaller) {
            this.marshaller = marshaller;
        }

        @Override
        public InputStream stream(MessageT value) {
            return marshaller.stream(value);
        }

        @Override
        public MessageT parse(InputStream stream) {
            try {
                return marshaller.parse(stream);
            } catch (Throwable t) {
                decodeFailure = t;
                throw t;
            }
        }
    }

    /** Receives the messages and the close of one attempt. */
    private final class Listener extends ClientCall.Listener<MessageT> {
        private final ClientCall<ProtoT, MessageT> attemptCall;

        Listener(ClientCall<ProtoT, MessageT> attemptCall) {
            this.attemptCall = attemptCall;
        }

        @Override
        public void onMessage(MessageT received) {
            boolean keep;
            lock.lock();
            try {
                keep = ended == false && cancelledByCaller == false && call == attemptCall;
                if (keep) {
                    receivedAny = true;
                    queue.addLast(received);
                    changed.signalAll();
                }
            } finally {
                lock.unlock();
            }
            if (keep == false) {
                endpoint.discard(received);
            }
        }

        @Override
        public void onClose(Status status, Metadata trailers) {
            lock.lock();
            try {
                if (call == attemptCall) {
                    closedStatus = status;
                    closedTrailers = trailers;
                    changed.signalAll();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    @Override
    @Nullable
    public MessageT next() throws IOException {
        while (true) {
            final MessageT taken;
            final ClientCall<ProtoT, MessageT> current;
            final Status status;
            final Metadata trailers;
            lock.lock();
            try {
                while (queue.isEmpty() && closedStatus == null && cancelledByCaller == false) {
                    changed.await();
                }
                if (cancelledByCaller) {
                    throw new TransportException("gRPC stream cancelled");
                }
                taken = queue.pollFirst();
                current = call;
                status = closedStatus;
                trailers = closedTrailers;
            } catch (InterruptedException e) {
                cancel();
                Thread.currentThread().interrupt();
                throw new TransportException("gRPC request interrupted", e);
            } finally {
                lock.unlock();
            }
            if (taken != null) {
                if (status == null) {
                    // Room for one more: lets gRPC read the next message, and the server send it.
                    current.request(1);
                }
                return taken;
            }
            if (status.isOk()) {
                markEnded();
                return null;
            }
            if (shouldRetry(status)) {
                backoff();
                // Starts nothing if the caller cancelled meanwhile; the loop then reports the cancellation.
                attempt();
                continue;
            }
            markEnded();
            throw failure(status, trailers);
        }
    }

    private boolean shouldRetry(Status status) {
        lock.lock();
        try {
            return receivedAny == false
                && cancelledByCaller == false
                && ended == false
                && attempts <= maxRetries
                && GrpcStatusConverter.isRetryable(status.getCode());
        } finally {
            lock.unlock();
        }
    }

    /** Waits before a retry; cancel() or close() ends the wait early, and then no attempt starts. */
    private void backoff() throws TransportException {
        lock.lock();
        try {
            long deadline = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(retryBackoffMillis * (1L << Math.min(attempts - 1, 16)));
            long remaining;
            while (cancelledByCaller == false && ended == false && (remaining = deadline - System.nanoTime()) > 0) {
                changed.awaitNanos(remaining);
            }
        } catch (InterruptedException e) {
            ended = true;
            Thread.currentThread().interrupt();
            throw new TransportException("gRPC request interrupted", e);
        } finally {
            lock.unlock();
        }
    }

    /** Returns the exception for a failed call, mapped as for unary calls; a decoding failure is reported as itself. */
    private IOException failure(Status status, Metadata trailers) throws IOException {
        Throwable cause = status.getCause();
        // Other causes of a cancellation, such as a cancelled parent context, map like any other status.
        if (status.getCode() == Status.Code.CANCELLED && cause != null && cause == decodeFailure) {
            // gRPC cancels a call whose response message failed to decode, with the decoder's exception as the cause.
            if (cause instanceof RuntimeException) {
                throw (RuntimeException) cause;
            }
            if (cause instanceof Error) {
                throw (Error) cause;
            }
            return new TransportException("Failed to decode gRPC stream message: " + cause.getMessage(), cause);
        }
        GrpcStatusConverter.throwConverted(status.asRuntimeException(trailers));
        return new TransportException("gRPC stream failed: " + status);
    }

    @Override
    public void cancel() {
        final Context.CancellableContext current;
        lock.lock();
        try {
            if (ended) {
                return;
            }
            cancelledByCaller = true;
            current = context;
            changed.signalAll();
        } finally {
            lock.unlock();
        }
        // Cancelling a context again does nothing, so close() cancels the running attempt even after an earlier cancel().
        if (current != null) {
            current.cancel(new CancellationException("gRPC stream cancelled by the caller"));
        }
    }

    @Override
    public void close() {
        final Context.CancellableContext running;
        lock.lock();
        try {
            // Decide and mark the end under one lock, so that a retry whose backoff ends meanwhile starts no attempt, and an
            // attempt that started before is the one cancelled here.
            running = ended == false && closedStatus == null ? context : null;
            if (running != null) {
                cancelledByCaller = true;
            }
            ended = true;
            changed.signalAll();
        } finally {
            lock.unlock();
        }
        if (running != null) {
            running.cancel(new CancellationException("gRPC stream closed by the caller"));
            awaitClose();
        }
        List<MessageT> undelivered;
        lock.lock();
        try {
            undelivered = new ArrayList<>(queue);
            queue.clear();
        } finally {
            lock.unlock();
        }
        for (MessageT left : undelivered) {
            endpoint.discard(left);
        }
    }

    /**
     * Waits up to {@link #CLOSE_WAIT_MILLIS} for the cancelled call to close, so that no message is still being decoded
     * when close() returns. An interrupt, such as the one that failed next(), does not end the wait; the thread stays
     * interrupted.
     */
    private void awaitClose() {
        long deadline = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(CLOSE_WAIT_MILLIS);
        boolean interrupted = false;
        lock.lock();
        try {
            long remaining;
            while (closedStatus == null && (remaining = deadline - System.nanoTime()) > 0) {
                try {
                    changed.awaitNanos(remaining);
                } catch (InterruptedException e) {
                    interrupted = true;
                }
            }
        } finally {
            lock.unlock();
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void markEnded() {
        lock.lock();
        try {
            ended = true;
        } finally {
            lock.unlock();
        }
    }
}
