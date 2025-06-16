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

package org.opensearch.client.opensearch.ism;

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
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ism.retry_index.Request

/**
 * Retries the failed action for an index.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class RetryIndexRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RetryIndexRequest.Builder, RetryIndexRequest> {

    @Nullable
    private final String index;

    @Nonnull
    private final String state;

    // ---------------------------------------------------------------------------------------------

    private RetryIndexRequest(Builder builder) {
        super(builder);
        this.index = builder.index;
        this.state = ApiTypeHelper.requireNonNull(builder.state, this, "state");
    }

    public static RetryIndexRequest of(Function<RetryIndexRequest.Builder, ObjectBuilder<RetryIndexRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * Required - The state to retry.
     * <p>
     * API name: {@code state}
     * </p>
     */
    @Nonnull
    public final String state() {
        return this.state;
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
        generator.writeKey("state");
        generator.write(this.state);
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
     * Builder for {@link RetryIndexRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, RetryIndexRequest> {
        @Nullable
        private String index;
        private String state;

        public Builder() {}

        private Builder(RetryIndexRequest o) {
            super(o);
            this.index = o.index;
            this.state = o.state;
        }

        private Builder(Builder o) {
            super(o);
            this.index = o.index;
            this.state = o.state;
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
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * Required - The state to retry.
         * <p>
         * API name: {@code state}
         * </p>
         */
        @Nonnull
        public final Builder state(String value) {
            this.state = value;
            return this;
        }

        /**
         * Builds a {@link RetryIndexRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RetryIndexRequest build() {
            _checkSingleUse();

            return new RetryIndexRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RetryIndexRequest}
     */
    public static final JsonpDeserializer<RetryIndexRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RetryIndexRequest::setupRetryIndexRequestDeserializer
    );

    protected static void setupRetryIndexRequestDeserializer(ObjectDeserializer<RetryIndexRequest.Builder> op) {
        op.add(Builder::state, JsonpDeserializer.stringDeserializer(), "state");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ism.retry_index}".
     */
    public static final Endpoint<RetryIndexRequest, RetryIndexResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _index = 1 << 0;

            int propsSet = 0;

            if (request.index() != null) propsSet |= _index;

            if (propsSet == 0) {
                return "/_plugins/_ism/retry";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_ism/retry/");
                SimpleEndpoint.pathEncode(request.index, buf);
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        RetryIndexResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + this.state.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RetryIndexRequest other = (RetryIndexRequest) o;
        return Objects.equals(this.index, other.index) && this.state.equals(other.state);
    }
}
