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
import java.util.List;
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

// typedef: search_relevance.get_experiments.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetExperimentsResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetExperimentsResponse.Builder, GetExperimentsResponse> {

    @Nonnull
    private final Map<String, JsonData> hits;

    @Nullable
    private final String id;

    @Nonnull
    private final List<String> judgmentList;

    @Nullable
    private final String querySetId;

    @Nonnull
    private final Map<String, JsonData> results;

    @Nonnull
    private final List<String> searchConfigurationList;

    @Nonnull
    private final Map<String, JsonData> shards;

    @Nullable
    private final Integer size;

    @Nullable
    private final String status;

    @Nullable
    private final Boolean timedOut;

    @Nullable
    private final String timestamp;

    @Nullable
    private final Integer took;

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private GetExperimentsResponse(Builder builder) {
        this.hits = ApiTypeHelper.unmodifiable(builder.hits);
        this.id = builder.id;
        this.judgmentList = ApiTypeHelper.unmodifiable(builder.judgmentList);
        this.querySetId = builder.querySetId;
        this.results = ApiTypeHelper.unmodifiable(builder.results);
        this.searchConfigurationList = ApiTypeHelper.unmodifiable(builder.searchConfigurationList);
        this.shards = ApiTypeHelper.unmodifiable(builder.shards);
        this.size = builder.size;
        this.status = builder.status;
        this.timedOut = builder.timedOut;
        this.timestamp = builder.timestamp;
        this.took = builder.took;
        this.type = builder.type;
    }

    public static GetExperimentsResponse of(Function<GetExperimentsResponse.Builder, ObjectBuilder<GetExperimentsResponse>> fn) {
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
     * API name: {@code judgmentList}
     */
    @Nonnull
    public final List<String> judgmentList() {
        return this.judgmentList;
    }

    /**
     * API name: {@code querySetId}
     */
    @Nullable
    public final String querySetId() {
        return this.querySetId;
    }

    /**
     * API name: {@code results}
     */
    @Nonnull
    public final Map<String, JsonData> results() {
        return this.results;
    }

    /**
     * API name: {@code searchConfigurationList}
     */
    @Nonnull
    public final List<String> searchConfigurationList() {
        return this.searchConfigurationList;
    }

    /**
     * API name: {@code _shards}
     */
    @Nonnull
    public final Map<String, JsonData> shards() {
        return this.shards;
    }

    /**
     * API name: {@code size}
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * API name: {@code status}
     */
    @Nullable
    public final String status() {
        return this.status;
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
     * API name: {@code type}
     */
    @Nullable
    public final String type() {
        return this.type;
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

        if (ApiTypeHelper.isDefined(this.judgmentList)) {
            generator.writeKey("judgmentList");
            generator.writeStartArray();
            for (String item0 : this.judgmentList) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.querySetId != null) {
            generator.writeKey("querySetId");
            generator.write(this.querySetId);
        }

        if (ApiTypeHelper.isDefined(this.results)) {
            generator.writeKey("results");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.results.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.searchConfigurationList)) {
            generator.writeKey("searchConfigurationList");
            generator.writeStartArray();
            for (String item0 : this.searchConfigurationList) {
                generator.write(item0);
            }
            generator.writeEnd();
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

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (this.status != null) {
            generator.writeKey("status");
            generator.write(this.status);
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

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
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
     * Builder for {@link GetExperimentsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetExperimentsResponse> {
        @Nullable
        private Map<String, JsonData> hits;
        @Nullable
        private String id;
        @Nullable
        private List<String> judgmentList;
        @Nullable
        private String querySetId;
        @Nullable
        private Map<String, JsonData> results;
        @Nullable
        private List<String> searchConfigurationList;
        @Nullable
        private Map<String, JsonData> shards;
        @Nullable
        private Integer size;
        @Nullable
        private String status;
        @Nullable
        private Boolean timedOut;
        @Nullable
        private String timestamp;
        @Nullable
        private Integer took;
        @Nullable
        private String type;

        public Builder() {}

        private Builder(GetExperimentsResponse o) {
            this.hits = _mapCopy(o.hits);
            this.id = o.id;
            this.judgmentList = _listCopy(o.judgmentList);
            this.querySetId = o.querySetId;
            this.results = _mapCopy(o.results);
            this.searchConfigurationList = _listCopy(o.searchConfigurationList);
            this.shards = _mapCopy(o.shards);
            this.size = o.size;
            this.status = o.status;
            this.timedOut = o.timedOut;
            this.timestamp = o.timestamp;
            this.took = o.took;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.hits = _mapCopy(o.hits);
            this.id = o.id;
            this.judgmentList = _listCopy(o.judgmentList);
            this.querySetId = o.querySetId;
            this.results = _mapCopy(o.results);
            this.searchConfigurationList = _listCopy(o.searchConfigurationList);
            this.shards = _mapCopy(o.shards);
            this.size = o.size;
            this.status = o.status;
            this.timedOut = o.timedOut;
            this.timestamp = o.timestamp;
            this.took = o.took;
            this.type = o.type;
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
         * API name: {@code judgmentList}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>judgmentList</code>.
         * </p>
         */
        @Nonnull
        public final Builder judgmentList(List<String> list) {
            this.judgmentList = _listAddAll(this.judgmentList, list);
            return this;
        }

        /**
         * API name: {@code judgmentList}
         *
         * <p>
         * Adds one or more values to <code>judgmentList</code>.
         * </p>
         */
        @Nonnull
        public final Builder judgmentList(String value, String... values) {
            this.judgmentList = _listAdd(this.judgmentList, value, values);
            return this;
        }

        /**
         * API name: {@code querySetId}
         */
        @Nonnull
        public final Builder querySetId(@Nullable String value) {
            this.querySetId = value;
            return this;
        }

        /**
         * API name: {@code results}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>results</code>.
         * </p>
         */
        @Nonnull
        public final Builder results(Map<String, JsonData> map) {
            this.results = _mapPutAll(this.results, map);
            return this;
        }

        /**
         * API name: {@code results}
         *
         * <p>
         * Adds an entry to <code>results</code>.
         * </p>
         */
        @Nonnull
        public final Builder results(String key, JsonData value) {
            this.results = _mapPut(this.results, key, value);
            return this;
        }

        /**
         * API name: {@code searchConfigurationList}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>searchConfigurationList</code>.
         * </p>
         */
        @Nonnull
        public final Builder searchConfigurationList(List<String> list) {
            this.searchConfigurationList = _listAddAll(this.searchConfigurationList, list);
            return this;
        }

        /**
         * API name: {@code searchConfigurationList}
         *
         * <p>
         * Adds one or more values to <code>searchConfigurationList</code>.
         * </p>
         */
        @Nonnull
        public final Builder searchConfigurationList(String value, String... values) {
            this.searchConfigurationList = _listAdd(this.searchConfigurationList, value, values);
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
         * API name: {@code size}
         */
        @Nonnull
        public final Builder size(@Nullable Integer value) {
            this.size = value;
            return this;
        }

        /**
         * API name: {@code status}
         */
        @Nonnull
        public final Builder status(@Nullable String value) {
            this.status = value;
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
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link GetExperimentsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetExperimentsResponse build() {
            _checkSingleUse();

            return new GetExperimentsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetExperimentsResponse}
     */
    public static final JsonpDeserializer<GetExperimentsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetExperimentsResponse::setupGetExperimentsResponseDeserializer
    );

    protected static void setupGetExperimentsResponseDeserializer(ObjectDeserializer<GetExperimentsResponse.Builder> op) {
        op.add(Builder::hits, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "hits");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::judgmentList, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "judgmentList");
        op.add(Builder::querySetId, JsonpDeserializer.stringDeserializer(), "querySetId");
        op.add(Builder::results, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "results");
        op.add(
            Builder::searchConfigurationList,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "searchConfigurationList"
        );
        op.add(Builder::shards, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "_shards");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
        op.add(Builder::timedOut, JsonpDeserializer.booleanDeserializer(), "timed_out");
        op.add(Builder::timestamp, JsonpDeserializer.stringDeserializer(), "timestamp");
        op.add(Builder::took, JsonpDeserializer.integerDeserializer(), "took");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.hits);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.judgmentList);
        result = 31 * result + Objects.hashCode(this.querySetId);
        result = 31 * result + Objects.hashCode(this.results);
        result = 31 * result + Objects.hashCode(this.searchConfigurationList);
        result = 31 * result + Objects.hashCode(this.shards);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.status);
        result = 31 * result + Objects.hashCode(this.timedOut);
        result = 31 * result + Objects.hashCode(this.timestamp);
        result = 31 * result + Objects.hashCode(this.took);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetExperimentsResponse other = (GetExperimentsResponse) o;
        return Objects.equals(this.hits, other.hits)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.judgmentList, other.judgmentList)
            && Objects.equals(this.querySetId, other.querySetId)
            && Objects.equals(this.results, other.results)
            && Objects.equals(this.searchConfigurationList, other.searchConfigurationList)
            && Objects.equals(this.shards, other.shards)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.status, other.status)
            && Objects.equals(this.timedOut, other.timedOut)
            && Objects.equals(this.timestamp, other.timestamp)
            && Objects.equals(this.took, other.took)
            && Objects.equals(this.type, other.type);
    }
}
