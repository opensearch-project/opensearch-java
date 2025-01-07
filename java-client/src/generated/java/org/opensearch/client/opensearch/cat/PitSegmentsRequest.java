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

package org.opensearch.client.opensearch.cat;

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
import org.opensearch.client.opensearch._types.Bytes;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.pit_segments.Request

/**
 * Lists one or several CAT point-in-time segments.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PitSegmentsRequest extends CatRequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PitSegmentsRequest.Builder, PitSegmentsRequest> {

    @Nullable
    private final Bytes bytes;

    @Nonnull
    private final List<String> pitId;

    // ---------------------------------------------------------------------------------------------

    private PitSegmentsRequest(Builder builder) {
        super(builder);
        this.bytes = builder.bytes;
        this.pitId = ApiTypeHelper.unmodifiableRequired(builder.pitId, this, "pitId");
    }

    public static PitSegmentsRequest of(Function<PitSegmentsRequest.Builder, ObjectBuilder<PitSegmentsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The units used to display byte values.
     * <p>
     * API name: {@code bytes}
     * </p>
     */
    @Nullable
    public final Bytes bytes() {
        return this.bytes;
    }

    /**
     * Required - API name: {@code pit_id}
     */
    @Nonnull
    public final List<String> pitId() {
        return this.pitId;
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
        generator.writeKey("pit_id");
        generator.writeStartArray();
        for (String item0 : this.pitId) {
            generator.write(item0);
        }
        generator.writeEnd();
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
     * Builder for {@link PitSegmentsRequest}.
     */
    public static class Builder extends CatRequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PitSegmentsRequest> {
        @Nullable
        private Bytes bytes;
        private List<String> pitId;

        public Builder() {}

        private Builder(PitSegmentsRequest o) {
            super(o);
            this.bytes = o.bytes;
            this.pitId = _listCopy(o.pitId);
        }

        private Builder(Builder o) {
            super(o);
            this.bytes = o.bytes;
            this.pitId = _listCopy(o.pitId);
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
         * The units used to display byte values.
         * <p>
         * API name: {@code bytes}
         * </p>
         */
        @Nonnull
        public final Builder bytes(@Nullable Bytes value) {
            this.bytes = value;
            return this;
        }

        /**
         * Required - API name: {@code pit_id}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>pitId</code>.
         * </p>
         */
        @Nonnull
        public final Builder pitId(List<String> list) {
            this.pitId = _listAddAll(this.pitId, list);
            return this;
        }

        /**
         * Required - API name: {@code pit_id}
         *
         * <p>
         * Adds one or more values to <code>pitId</code>.
         * </p>
         */
        @Nonnull
        public final Builder pitId(String value, String... values) {
            this.pitId = _listAdd(this.pitId, value, values);
            return this;
        }

        /**
         * Builds a {@link PitSegmentsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PitSegmentsRequest build() {
            _checkSingleUse();

            return new PitSegmentsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PitSegmentsRequest}
     */
    public static final JsonpDeserializer<PitSegmentsRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PitSegmentsRequest::setupPitSegmentsRequestDeserializer
    );

    protected static void setupPitSegmentsRequestDeserializer(ObjectDeserializer<PitSegmentsRequest.Builder> op) {
        op.add(Builder::pitId, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "pit_id");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.bytes != null) {
            params.put("bytes", this.bytes.jsonValue());
        }
    }

    /**
     * Endpoint "{@code cat.pit_segments}".
     */
    public static final Endpoint<PitSegmentsRequest, PitSegmentsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> "/_cat/pit_segments",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        PitSegmentsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.bytes);
        result = 31 * result + this.pitId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PitSegmentsRequest other = (PitSegmentsRequest) o;
        return Objects.equals(this.bytes, other.bytes) && this.pitId.equals(other.pitId);
    }
}
