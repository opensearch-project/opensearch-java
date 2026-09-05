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
}
