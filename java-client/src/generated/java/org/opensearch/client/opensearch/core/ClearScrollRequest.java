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
import java.util.List;
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

// typedef: _global.clear_scroll.Request

/**
 * Explicitly clears the search context for a scroll.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ClearScrollRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ClearScrollRequest.Builder, ClearScrollRequest> {

    @Nonnull
    private final List<String> scrollId;

    // ---------------------------------------------------------------------------------------------

    private ClearScrollRequest(Builder builder) {
        super(builder);
        this.scrollId = ApiTypeHelper.unmodifiable(builder.scrollId);
    }

    public static ClearScrollRequest of(Function<ClearScrollRequest.Builder, ObjectBuilder<ClearScrollRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code scroll_id}
     */
    @Nonnull
    public final List<String> scrollId() {
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
        if (ApiTypeHelper.isDefined(this.scrollId)) {
            generator.writeKey("scroll_id");
            generator.writeStartArray();
            for (String item0 : this.scrollId) {
                generator.write(item0);
            }
            generator.writeEnd();
        }
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
     * Builder for {@link ClearScrollRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ClearScrollRequest> {
        @Nullable
        private List<String> scrollId;

        public Builder() {}

        private Builder(ClearScrollRequest o) {
            super(o);
            this.scrollId = _listCopy(o.scrollId);
        }

        private Builder(Builder o) {
            super(o);
            this.scrollId = _listCopy(o.scrollId);
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
         * API name: {@code scroll_id}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>scrollId</code>.
         * </p>
         */
        @Nonnull
        public final Builder scrollId(List<String> list) {
            this.scrollId = _listAddAll(this.scrollId, list);
            return this;
        }

        /**
         * API name: {@code scroll_id}
         *
         * <p>
         * Adds one or more values to <code>scrollId</code>.
         * </p>
         */
        @Nonnull
        public final Builder scrollId(String value, String... values) {
            this.scrollId = _listAdd(this.scrollId, value, values);
            return this;
        }

        /**
         * Builds a {@link ClearScrollRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClearScrollRequest build() {
            _checkSingleUse();

            return new ClearScrollRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClearScrollRequest}
     */
    public static final JsonpDeserializer<ClearScrollRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClearScrollRequest::setupClearScrollRequestDeserializer
    );

    protected static void setupClearScrollRequestDeserializer(ObjectDeserializer<ClearScrollRequest.Builder> op) {
        op.add(Builder::scrollId, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "scroll_id");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code clear_scroll}".
     */
    public static final Endpoint<ClearScrollRequest, ClearScrollResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "DELETE",
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
        ClearScrollResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.scrollId);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClearScrollRequest other = (ClearScrollRequest) o;
        return Objects.equals(this.scrollId, other.scrollId);
    }
}
