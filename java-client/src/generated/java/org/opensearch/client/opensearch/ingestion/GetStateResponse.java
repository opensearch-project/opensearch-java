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

package org.opensearch.client.opensearch.ingestion;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.opensearch._types.ShardStatistics;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ingestion.get_state.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetStateResponse implements PlainJsonSerializable, ToCopyableBuilder<GetStateResponse.Builder, GetStateResponse> {

    @Nonnull
    private final Map<String, List<ShardIngestionState>> ingestionState;

    @Nullable
    private final String nextPageToken;

    @Nullable
    private final ShardStatistics shards;

    // ---------------------------------------------------------------------------------------------

    private GetStateResponse(Builder builder) {
        this.ingestionState = ApiTypeHelper.unmodifiable(builder.ingestionState);
        this.nextPageToken = builder.nextPageToken;
        this.shards = builder.shards;
    }

    public static GetStateResponse of(Function<GetStateResponse.Builder, ObjectBuilder<GetStateResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Ingestion state for a given index and its shards.
     * <p>
     * API name: {@code ingestion_state}
     * </p>
     */
    @Nonnull
    public final Map<String, List<ShardIngestionState>> ingestionState() {
        return this.ingestionState;
    }

    /**
     * Specifies the next page token. Pass this token in the request to retrieve contents of the next page.
     * <p>
     * API name: {@code next_page_token}
     * </p>
     */
    @Nullable
    public final String nextPageToken() {
        return this.nextPageToken;
    }

    /**
     * API name: {@code _shards}
     */
    @Nullable
    public final ShardStatistics shards() {
        return this.shards;
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
        if (ApiTypeHelper.isDefined(this.ingestionState)) {
            generator.writeKey("ingestion_state");
            generator.writeStartObject();
            for (Map.Entry<String, List<ShardIngestionState>> item0 : this.ingestionState.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.writeStartArray();
                if (item0.getValue() != null) {
                    for (ShardIngestionState item1 : item0.getValue()) {
                        item1.serialize(generator, mapper);
                    }
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (this.nextPageToken != null) {
            generator.writeKey("next_page_token");
            generator.write(this.nextPageToken);
        }

        if (this.shards != null) {
            generator.writeKey("_shards");
            this.shards.serialize(generator, mapper);
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
     * Builder for {@link GetStateResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetStateResponse> {
        @Nullable
        private Map<String, List<ShardIngestionState>> ingestionState;
        @Nullable
        private String nextPageToken;
        @Nullable
        private ShardStatistics shards;

        public Builder() {}

        private Builder(GetStateResponse o) {
            this.ingestionState = _mapCopy(o.ingestionState);
            this.nextPageToken = o.nextPageToken;
            this.shards = o.shards;
        }

        private Builder(Builder o) {
            this.ingestionState = _mapCopy(o.ingestionState);
            this.nextPageToken = o.nextPageToken;
            this.shards = o.shards;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Ingestion state for a given index and its shards.
         * <p>
         * API name: {@code ingestion_state}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>ingestionState</code>.
         * </p>
         */
        @Nonnull
        public final Builder ingestionState(Map<String, List<ShardIngestionState>> map) {
            this.ingestionState = _mapPutAll(this.ingestionState, map);
            return this;
        }

        /**
         * Ingestion state for a given index and its shards.
         * <p>
         * API name: {@code ingestion_state}
         * </p>
         *
         * <p>
         * Adds an entry to <code>ingestionState</code>.
         * </p>
         */
        @Nonnull
        public final Builder ingestionState(String key, List<ShardIngestionState> value) {
            this.ingestionState = _mapPut(this.ingestionState, key, value);
            return this;
        }

        /**
         * Specifies the next page token. Pass this token in the request to retrieve contents of the next page.
         * <p>
         * API name: {@code next_page_token}
         * </p>
         */
        @Nonnull
        public final Builder nextPageToken(@Nullable String value) {
            this.nextPageToken = value;
            return this;
        }

        /**
         * API name: {@code _shards}
         */
        @Nonnull
        public final Builder shards(@Nullable ShardStatistics value) {
            this.shards = value;
            return this;
        }

        /**
         * API name: {@code _shards}
         */
        @Nonnull
        public final Builder shards(Function<ShardStatistics.Builder, ObjectBuilder<ShardStatistics>> fn) {
            return shards(fn.apply(new ShardStatistics.Builder()).build());
        }

        /**
         * Builds a {@link GetStateResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetStateResponse build() {
            _checkSingleUse();

            return new GetStateResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetStateResponse}
     */
    public static final JsonpDeserializer<GetStateResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetStateResponse::setupGetStateResponseDeserializer
    );

    protected static void setupGetStateResponseDeserializer(ObjectDeserializer<GetStateResponse.Builder> op) {
        op.add(
            Builder::ingestionState,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.arrayDeserializer(ShardIngestionState._DESERIALIZER)),
            "ingestion_state"
        );
        op.add(Builder::nextPageToken, JsonpDeserializer.stringDeserializer(), "next_page_token");
        op.add(Builder::shards, ShardStatistics._DESERIALIZER, "_shards");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.ingestionState);
        result = 31 * result + Objects.hashCode(this.nextPageToken);
        result = 31 * result + Objects.hashCode(this.shards);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetStateResponse other = (GetStateResponse) o;
        return Objects.equals(this.ingestionState, other.ingestionState)
            && Objects.equals(this.nextPageToken, other.nextPageToken)
            && Objects.equals(this.shards, other.shards);
    }
}
