/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import java.util.function.Function;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BulkStreamingResponse implements Publisher<BulkResponse> {
    private final Publisher<BulkResponse> items;

    // ---------------------------------------------------------------------------------------------

    private BulkStreamingResponse(Builder builder) {
        this.items = ApiTypeHelper.requireNonNull(builder.items, this, "items");
    }

    public static BulkStreamingResponse of(Function<Builder, ObjectBuilder<BulkStreamingResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    @Override
    public void subscribe(Subscriber<? super BulkResponse> s) {
        items.subscribe(s);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link BulkStreamingResponse}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<BulkStreamingResponse> {
        private Publisher<BulkResponse> items;

        /**
         * Required - API name: {@code items}
         * <p>
         * Adds all elements of <code>list</code> to <code>items</code>.
         */
        public final Builder items(Publisher<BulkResponse> items) {
            this.items = items;
            return this;
        }

        /**
         * Required - API name: {@code items}
         * <p>
         * Adds one or more values to <code>items</code>.
         */
        public final Builder items(BulkResponse value, BulkResponse... values) {
            this.items = Flux.concat(Mono.just(value), Flux.fromArray(values));
            return this;
        }

        /**
         * Required - API name: {@code items}
         * <p>
         * Adds a value to <code>items</code> using a builder lambda.
         */
        public final Builder items(Function<BulkResponse.Builder, ObjectBuilder<BulkResponse>> fn) {
            return items(fn.apply(new BulkResponse.Builder()).build());
        }

        /**
         * Builds a {@link BulkStreamingResponse}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public BulkStreamingResponse build() {
            _checkSingleUse();

            return new BulkStreamingResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------
}
