/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.core;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.scroll.Request

/**
 * Allows to retrieve a large numbers of results from a single search request.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ScrollRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ScrollRequest.Builder, ScrollRequest> {

    @Nullable
    private final Time scroll;

    @Nonnull
    private final String scrollId;

    // ---------------------------------------------------------------------------------------------

    private ScrollRequest(Builder builder) {
        super(builder);
        this.scroll = builder.scroll;
        this.scrollId = ApiTypeHelper.requireNonNull(builder.scrollId, this, "scrollId");
    }

    public static ScrollRequest of(Function<ScrollRequest.Builder, ObjectBuilder<ScrollRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code scroll}
     */
    @Nullable
    public final Time scroll() {
        return this.scroll;
    }

    /**
     * Required - API name: {@code scroll_id}
     */
    @Nonnull
    public final String scrollId() {
        return this.scrollId;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.scroll != null) {
            generator.writeKey("scroll");
            this.scroll.serialize(generator, mapper);
        }

        generator.writeKey("scroll_id");
        generator.write(this.scrollId);
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link ScrollRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ScrollRequest> {
        @Nullable
        private Time scroll;
        private String scrollId;

        public Builder() {}

        private Builder(ScrollRequest o) {
            super(o);
            this.scroll = o.scroll;
            this.scrollId = o.scrollId;
        }

        private Builder(Builder o) {
            super(o);
            this.scroll = o.scroll;
            this.scrollId = o.scrollId;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * API name: {@code scroll}
         */
        @Nonnull
        public final Builder scroll(@Nullable Time value) {
            this.scroll = value;
            return this;
        }

        /**
         * API name: {@code scroll}
         */
        @Nonnull
        public final Builder scroll(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return scroll(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code scroll_id}
         */
        @Nonnull
        public final Builder scrollId(String value) {
            this.scrollId = value;
            return this;
        }

        /**
         * Builds a {@link ScrollRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ScrollRequest build() {
            _checkSingleUse();

            return new ScrollRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ScrollRequest}
     */
    public static final JsonpDeserializer<ScrollRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ScrollRequest::setupScrollRequestDeserializer
    );

    protected static void setupScrollRequestDeserializer(ObjectDeserializer<ScrollRequest.Builder> op) {
        op.add(Builder::scroll, Time._DESERIALIZER, "scroll");
        op.add(Builder::scrollId, JsonpDeserializer.stringDeserializer(), "scroll_id");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code scroll}".
     */
    public static final SimpleEndpoint<ScrollRequest, ?> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_search/scroll",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        ScrollResponse._DESERIALIZER
    );

    /**
     * Create an "{@code scroll}" endpoint.
     */
    public static <TDocument> Endpoint<ScrollRequest, ScrollResponse<TDocument>, ErrorResponse> createScrollEndpoint(
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        return _ENDPOINT.withResponseDeserializer(ScrollResponse.createScrollResponseDeserializer(tDocumentDeserializer));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.scroll);
        result = 31 * result + this.scrollId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScrollRequest other = (ScrollRequest) o;
        return Objects.equals(this.scroll, other.scroll) && this.scrollId.equals(other.scrollId);
    }
}
