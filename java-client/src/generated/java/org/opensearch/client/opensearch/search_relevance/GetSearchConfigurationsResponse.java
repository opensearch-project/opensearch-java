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

package org.opensearch.client.opensearch.search_relevance;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.get_search_configurations.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetSearchConfigurationsResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetSearchConfigurationsResponse.Builder, GetSearchConfigurationsResponse> {

    @Nonnull
    private final Map<String, JsonData> hits;

    @Nullable
    private final String id;

    @Nullable
    private final String index;

    @Nullable
    private final String name;

    @Nullable
    private final String query;

    @Nullable
    private final String searchPipeline;

    @Nonnull
    private final Map<String, JsonData> shards;

    @Nullable
    private final Boolean timedOut;

    @Nullable
    private final String timestamp;

    @Nullable
    private final Integer took;

    // ---------------------------------------------------------------------------------------------

    private GetSearchConfigurationsResponse(Builder builder) {
        this.hits = ApiTypeHelper.unmodifiable(builder.hits);
        this.id = builder.id;
        this.index = builder.index;
        this.name = builder.name;
        this.query = builder.query;
        this.searchPipeline = builder.searchPipeline;
        this.shards = ApiTypeHelper.unmodifiable(builder.shards);
        this.timedOut = builder.timedOut;
        this.timestamp = builder.timestamp;
        this.took = builder.took;
    }

    public static GetSearchConfigurationsResponse of(
        Function<GetSearchConfigurationsResponse.Builder, ObjectBuilder<GetSearchConfigurationsResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code hits}
     */
    @Nonnull
    public final Map<String, JsonData> hits() {
        return this.hits;
    }

    /**
     * API name: {@code id}
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code query}
     */
    @Nullable
    public final String query() {
        return this.query;
    }

    /**
     * API name: {@code searchPipeline}
     */
    @Nullable
    public final String searchPipeline() {
        return this.searchPipeline;
    }

    /**
     * API name: {@code _shards}
     */
    @Nonnull
    public final Map<String, JsonData> shards() {
        return this.shards;
    }

    /**
     * API name: {@code timed_out}
     */
    @Nullable
    public final Boolean timedOut() {
        return this.timedOut;
    }

    /**
     * API name: {@code timestamp}
     */
    @Nullable
    public final String timestamp() {
        return this.timestamp;
    }

    /**
     * API name: {@code took}
     */
    @Nullable
    public final Integer took() {
        return this.took;
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
        if (ApiTypeHelper.isDefined(this.hits)) {
            generator.writeKey("hits");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.hits.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.query != null) {
            generator.writeKey("query");
            generator.write(this.query);
        }

        if (this.searchPipeline != null) {
            generator.writeKey("searchPipeline");
            generator.write(this.searchPipeline);
        }

        if (ApiTypeHelper.isDefined(this.shards)) {
            generator.writeKey("_shards");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.shards.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.timedOut != null) {
            generator.writeKey("timed_out");
            generator.write(this.timedOut);
        }

        if (this.timestamp != null) {
            generator.writeKey("timestamp");
            generator.write(this.timestamp);
        }

        if (this.took != null) {
            generator.writeKey("took");
            generator.write(this.took);
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
     * Builder for {@link GetSearchConfigurationsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetSearchConfigurationsResponse> {
        @Nullable
        private Map<String, JsonData> hits;
        @Nullable
        private String id;
        @Nullable
        private String index;
        @Nullable
        private String name;
        @Nullable
        private String query;
        @Nullable
        private String searchPipeline;
        @Nullable
        private Map<String, JsonData> shards;
        @Nullable
        private Boolean timedOut;
        @Nullable
        private String timestamp;
        @Nullable
        private Integer took;

        public Builder() {}

        private Builder(GetSearchConfigurationsResponse o) {
            this.hits = _mapCopy(o.hits);
            this.id = o.id;
            this.index = o.index;
            this.name = o.name;
            this.query = o.query;
            this.searchPipeline = o.searchPipeline;
            this.shards = _mapCopy(o.shards);
            this.timedOut = o.timedOut;
            this.timestamp = o.timestamp;
            this.took = o.took;
        }

        private Builder(Builder o) {
            this.hits = _mapCopy(o.hits);
            this.id = o.id;
            this.index = o.index;
            this.name = o.name;
            this.query = o.query;
            this.searchPipeline = o.searchPipeline;
            this.shards = _mapCopy(o.shards);
            this.timedOut = o.timedOut;
            this.timestamp = o.timestamp;
            this.took = o.took;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code hits}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>hits</code>.
         * </p>
         */
        @Nonnull
        public final Builder hits(Map<String, JsonData> map) {
            this.hits = _mapPutAll(this.hits, map);
            return this;
        }

        /**
         * API name: {@code hits}
         *
         * <p>
         * Adds an entry to <code>hits</code>.
         * </p>
         */
        @Nonnull
        public final Builder hits(String key, JsonData value) {
            this.hits = _mapPut(this.hits, key, value);
            return this;
        }

        /**
         * API name: {@code id}
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
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
         * API name: {@code name}
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code query}
         */
        @Nonnull
        public final Builder query(@Nullable String value) {
            this.query = value;
            return this;
        }

        /**
         * API name: {@code searchPipeline}
         */
        @Nonnull
        public final Builder searchPipeline(@Nullable String value) {
            this.searchPipeline = value;
            return this;
        }

        /**
         * API name: {@code _shards}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(Map<String, JsonData> map) {
            this.shards = _mapPutAll(this.shards, map);
            return this;
        }

        /**
         * API name: {@code _shards}
         *
         * <p>
         * Adds an entry to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(String key, JsonData value) {
            this.shards = _mapPut(this.shards, key, value);
            return this;
        }

        /**
         * API name: {@code timed_out}
         */
        @Nonnull
        public final Builder timedOut(@Nullable Boolean value) {
            this.timedOut = value;
            return this;
        }

        /**
         * API name: {@code timestamp}
         */
        @Nonnull
        public final Builder timestamp(@Nullable String value) {
            this.timestamp = value;
            return this;
        }

        /**
         * API name: {@code took}
         */
        @Nonnull
        public final Builder took(@Nullable Integer value) {
            this.took = value;
            return this;
        }

        /**
         * Builds a {@link GetSearchConfigurationsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetSearchConfigurationsResponse build() {
            _checkSingleUse();

            return new GetSearchConfigurationsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetSearchConfigurationsResponse}
     */
    public static final JsonpDeserializer<GetSearchConfigurationsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetSearchConfigurationsResponse::setupGetSearchConfigurationsResponseDeserializer
    );

    protected static void setupGetSearchConfigurationsResponseDeserializer(ObjectDeserializer<GetSearchConfigurationsResponse.Builder> op) {
        op.add(Builder::hits, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "hits");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::query, JsonpDeserializer.stringDeserializer(), "query");
        op.add(Builder::searchPipeline, JsonpDeserializer.stringDeserializer(), "searchPipeline");
        op.add(Builder::shards, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "_shards");
        op.add(Builder::timedOut, JsonpDeserializer.booleanDeserializer(), "timed_out");
        op.add(Builder::timestamp, JsonpDeserializer.stringDeserializer(), "timestamp");
        op.add(Builder::took, JsonpDeserializer.integerDeserializer(), "took");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.hits);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.query);
        result = 31 * result + Objects.hashCode(this.searchPipeline);
        result = 31 * result + Objects.hashCode(this.shards);
        result = 31 * result + Objects.hashCode(this.timedOut);
        result = 31 * result + Objects.hashCode(this.timestamp);
        result = 31 * result + Objects.hashCode(this.took);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetSearchConfigurationsResponse other = (GetSearchConfigurationsResponse) o;
        return Objects.equals(this.hits, other.hits)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.query, other.query)
            && Objects.equals(this.searchPipeline, other.searchPipeline)
            && Objects.equals(this.shards, other.shards)
            && Objects.equals(this.timedOut, other.timedOut)
            && Objects.equals(this.timestamp, other.timestamp)
            && Objects.equals(this.took, other.took);
    }
}
