/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import static org.hamcrest.CoreMatchers.equalTo;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.Version;
import org.opensearch.client.Request;
import org.opensearch.client.Response;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch.core.BulkStreamingRequest;
import org.opensearch.client.opensearch.core.BulkStreamingResponse;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.test.rest.yaml.ObjectPath;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.scheduler.VirtualTimeScheduler;

public abstract class AbstractStreamingIT extends OpenSearchJavaClientTestCase {
    @Before
    public void checkVersion() throws IOException {
        assumeTrue("Streaming bulk is supported in OpenSearch 3.0.0 and later", getServerVersion().onOrAfter(Version.V_3_0_0));
    }

    @Test
    public void testStreamingRequestNoBatching() throws IOException {
        final VirtualTimeScheduler scheduler = VirtualTimeScheduler.create(true);

        final Stream<BulkOperation> stream = IntStream.range(1, 6)
            .mapToObj(
                id -> BulkOperation.of(
                    op -> op.index(
                        in -> in.index("test-streaming").id(Integer.toString(id)).document(Collections.singletonMap("name", "josh"))
                    )
                )
            );

        final Duration delay = Duration.ofMillis(1);
        final BulkStreamingRequest streamingRequest = BulkStreamingRequest.of(
            r -> r.operations(Flux.fromStream(stream).delayElements(delay, scheduler)).refresh(Refresh.True)
        );

        final BulkStreamingResponse streamingResponse = javaClient().bulk(streamingRequest);
        scheduler.advanceTimeBy(delay); /* emit first element */

        StepVerifier.create(Flux.from(streamingResponse).flatMapIterable(r -> r.items()))
            .expectNextMatches(item -> Objects.equals(item.result(), "created") && Objects.equals(item.id(), "1"))
            .then(() -> scheduler.advanceTimeBy(delay))
            .expectNextMatches(item -> Objects.equals(item.result(), "created") && Objects.equals(item.id(), "2"))
            .then(() -> scheduler.advanceTimeBy(delay))
            .expectNextMatches(item -> Objects.equals(item.result(), "created") && Objects.equals(item.id(), "3"))
            .then(() -> scheduler.advanceTimeBy(delay))
            .expectNextMatches(item -> Objects.equals(item.result(), "created") && Objects.equals(item.id(), "4"))
            .then(() -> scheduler.advanceTimeBy(delay))
            .expectNextMatches(item -> Objects.equals(item.result(), "created") && Objects.equals(item.id(), "5"))
            .then(() -> scheduler.advanceTimeBy(delay))
            .expectComplete()
            .verify();

        final Request request = new Request("GET", "/test-streaming/_count");
        final Response response = client().performRequest(request);
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
        final Integer count = objectPath.evaluate("count");
        assertThat(count, equalTo(5));
    }

    public void testStreamingRequestOneBatchBySize() throws IOException, InterruptedException {
        final Stream<BulkOperation> stream = IntStream.range(1, 6)
            .mapToObj(
                id -> BulkOperation.of(
                    op -> op.index(
                        in -> in.index("test-streaming").id(Integer.toString(id)).document(Collections.singletonMap("name", "josh"))
                    )
                )
            );

        final Duration delay = Duration.ofMillis(1);
        final BulkStreamingRequest streamingRequest = BulkStreamingRequest.of(
            r -> r.operations(Flux.fromStream(stream).delayElements(delay)).refresh(Refresh.True).batchSize(5)
        );

        final BulkStreamingResponse streamingResponse = javaClient().bulk(streamingRequest);

        StepVerifier.create(Flux.from(streamingResponse).map(r -> r.items()))
            .expectNextMatches(
                items -> items.size() == 5
                    && Objects.equals(items.get(0).result(), "created")
                    && Objects.equals(items.get(0).id(), "1")
                    && Objects.equals(items.get(1).result(), "created")
                    && Objects.equals(items.get(1).id(), "2")
                    && Objects.equals(items.get(2).result(), "created")
                    && Objects.equals(items.get(2).id(), "3")
                    && Objects.equals(items.get(3).result(), "created")
                    && Objects.equals(items.get(3).id(), "4")
                    && Objects.equals(items.get(4).result(), "created")
                    && Objects.equals(items.get(4).id(), "5")
            )
            .expectComplete()
            .verify();

        final Request request = new Request("GET", "/test-streaming/_count");
        final Response response = client().performRequest(request);
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
        final Integer count = objectPath.evaluate("count");
        assertThat(count, equalTo(5));
    }

    public void testStreamingRequestManyBatchesBySize() throws IOException {
        final Stream<BulkOperation> stream = IntStream.range(1, 6)
            .mapToObj(
                id -> BulkOperation.of(
                    op -> op.index(
                        in -> in.index("test-streaming").id(Integer.toString(id)).document(Collections.singletonMap("name", "josh"))
                    )
                )
            );

        final Duration delay = Duration.ofMillis(1);
        final BulkStreamingRequest streamingRequest = BulkStreamingRequest.of(
            r -> r.operations(Flux.fromStream(stream).delayElements(delay)).refresh(Refresh.True).batchSize(3)
        );

        final BulkStreamingResponse streamingResponse = javaClient().bulk(streamingRequest);

        StepVerifier.create(Flux.from(streamingResponse).map(r -> r.items()))
            .expectNextMatches(
                items -> items.size() == 3
                    && Objects.equals(items.get(0).result(), "created")
                    && Objects.equals(items.get(0).id(), "1")
                    && Objects.equals(items.get(1).result(), "created")
                    && Objects.equals(items.get(1).id(), "2")
                    && Objects.equals(items.get(2).result(), "created")
                    && Objects.equals(items.get(2).id(), "3")

            )
            .expectNextMatches(
                items -> items.size() == 2
                    && Objects.equals(items.get(0).result(), "created")
                    && Objects.equals(items.get(0).id(), "4")
                    && Objects.equals(items.get(1).result(), "created")
                    && Objects.equals(items.get(1).id(), "5")
            )
            .expectComplete()
            .verify();

        final Request request = new Request("GET", "/test-streaming/_count");
        final Response response = client().performRequest(request);
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
        final Integer count = objectPath.evaluate("count");
        assertThat(count, equalTo(5));
    }

    public void testStreamingRequestManyBatchesByInterval() throws IOException {
        final Stream<BulkOperation> stream = IntStream.range(1, 6)
            .mapToObj(
                id -> BulkOperation.of(
                    op -> op.index(
                        in -> in.index("test-streaming").id(Integer.toString(id)).document(Collections.singletonMap("name", "josh"))
                    )
                )
            );

        final Duration delay = Duration.ofMillis(500);
        final BulkStreamingRequest streamingRequest = BulkStreamingRequest.of(
            r -> r.operations(Flux.fromStream(stream).delayElements(delay)).refresh(Refresh.True).batchInterval(t -> t.time("5s"))
        );

        final BulkStreamingResponse streamingResponse = javaClient().bulk(streamingRequest);

        StepVerifier.create(Flux.from(streamingResponse).map(r -> r.items()))
            .expectNextMatches(
                items -> items.size() == 5
                    && Objects.equals(items.get(0).result(), "created")
                    && Objects.equals(items.get(0).id(), "1")
                    && Objects.equals(items.get(1).result(), "created")
                    && Objects.equals(items.get(1).id(), "2")
                    && Objects.equals(items.get(2).result(), "created")
                    && Objects.equals(items.get(2).id(), "3")
                    && Objects.equals(items.get(3).result(), "created")
                    && Objects.equals(items.get(3).id(), "4")
                    && Objects.equals(items.get(4).result(), "created")
                    && Objects.equals(items.get(4).id(), "5")
            )
            .expectComplete()
            .verify();

        final Request request = new Request("GET", "/test-streaming/_count");
        final Response response = client().performRequest(request);
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
        final Integer count = objectPath.evaluate("count");
        assertThat(count, equalTo(5));
    }

    public void testStreamingLargeDocument() throws IOException {
        final Stream<BulkOperation> stream = Stream.of(
            BulkOperation.of(
                op -> op.index(
                    in -> in.index("test-streaming").id("1").document(Collections.singletonMap("name", randomAlphaOfLength(7000)))
                )
            )
        );

        final BulkStreamingRequest streamingRequest = BulkStreamingRequest.of(r -> r.operations(Flux.fromStream(stream)));
        final BulkStreamingResponse streamingResponse = javaClient().bulk(streamingRequest);

        StepVerifier.create(Flux.from(streamingResponse).flatMapIterable(r -> r.items()))
            .expectNextMatches(item -> Objects.equals(item.result(), "created") && Objects.equals(item.id(), "1"))
            .expectComplete()
            .verify();
    }

    public void testStreamingLargeDocumentThatExceedsChunkSize() throws IOException {
        final Stream<BulkOperation> stream = Stream.of(
            BulkOperation.of(
                op -> op.index(
                    in -> in.index("test-streaming")
                        .id("1")
                        .document(Collections.singletonMap("name", randomAlphaOfLength(9000) /* the default chunk size limit is set 8k */))
                )
            )
        );

        final BulkStreamingRequest streamingRequest = BulkStreamingRequest.of(r -> r.operations(Flux.fromStream(stream)));
        final BulkStreamingResponse streamingResponse = javaClient().bulk(streamingRequest);

        StepVerifier.create(Flux.from(streamingResponse).flatMapIterable(r -> r.items()))
            .expectErrorMatches(
                ex -> ex instanceof OpenSearchException
                    && Objects.equals(((OpenSearchException) ex).error().type(), "illegal_argument_exception")
            )
            .verify();
    }
}
