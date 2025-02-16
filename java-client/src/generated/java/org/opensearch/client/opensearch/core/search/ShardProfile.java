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

package org.opensearch.client.opensearch.core.search;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.search.ShardProfile

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardProfile implements PlainJsonSerializable, ToCopyableBuilder<ShardProfile.Builder, ShardProfile> {

    @Nonnull
    private final List<AggregationProfile> aggregations;

    @Nullable
    private final FetchProfile fetch;

    @Nonnull
    private final String id;

    @Nonnull
    private final List<SearchProfile> searches;

    // ---------------------------------------------------------------------------------------------

    private ShardProfile(Builder builder) {
        this.aggregations = ApiTypeHelper.unmodifiableRequired(builder.aggregations, this, "aggregations");
        this.fetch = builder.fetch;
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.searches = ApiTypeHelper.unmodifiableRequired(builder.searches, this, "searches");
    }

    public static ShardProfile of(Function<ShardProfile.Builder, ObjectBuilder<ShardProfile>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code aggregations}
     */
    @Nonnull
    public final List<AggregationProfile> aggregations() {
        return this.aggregations;
    }

    /**
     * API name: {@code fetch}
     */
    @Nullable
    public final FetchProfile fetch() {
        return this.fetch;
    }

    /**
     * Required - API name: {@code id}
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * Required - API name: {@code searches}
     */
    @Nonnull
    public final List<SearchProfile> searches() {
        return this.searches;
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
        generator.writeKey("aggregations");
        generator.writeStartArray();
        for (AggregationProfile item0 : this.aggregations) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.fetch != null) {
            generator.writeKey("fetch");
            this.fetch.serialize(generator, mapper);
        }

        generator.writeKey("id");
        generator.write(this.id);

        generator.writeKey("searches");
        generator.writeStartArray();
        for (SearchProfile item0 : this.searches) {
            item0.serialize(generator, mapper);
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
     * Builder for {@link ShardProfile}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardProfile> {
        private List<AggregationProfile> aggregations;
        @Nullable
        private FetchProfile fetch;
        private String id;
        private List<SearchProfile> searches;

        public Builder() {}

        private Builder(ShardProfile o) {
            this.aggregations = _listCopy(o.aggregations);
            this.fetch = o.fetch;
            this.id = o.id;
            this.searches = _listCopy(o.searches);
        }

        private Builder(Builder o) {
            this.aggregations = _listCopy(o.aggregations);
            this.fetch = o.fetch;
            this.id = o.id;
            this.searches = _listCopy(o.searches);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code aggregations}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final Builder aggregations(List<AggregationProfile> list) {
            this.aggregations = _listAddAll(this.aggregations, list);
            return this;
        }

        /**
         * Required - API name: {@code aggregations}
         *
         * <p>
         * Adds one or more values to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final Builder aggregations(AggregationProfile value, AggregationProfile... values) {
            this.aggregations = _listAdd(this.aggregations, value, values);
            return this;
        }

        /**
         * Required - API name: {@code aggregations}
         *
         * <p>
         * Adds a value to <code>aggregations</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder aggregations(Function<AggregationProfile.Builder, ObjectBuilder<AggregationProfile>> fn) {
            return aggregations(fn.apply(new AggregationProfile.Builder()).build());
        }

        /**
         * API name: {@code fetch}
         */
        @Nonnull
        public final Builder fetch(@Nullable FetchProfile value) {
            this.fetch = value;
            return this;
        }

        /**
         * API name: {@code fetch}
         */
        @Nonnull
        public final Builder fetch(Function<FetchProfile.Builder, ObjectBuilder<FetchProfile>> fn) {
            return fetch(fn.apply(new FetchProfile.Builder()).build());
        }

        /**
         * Required - API name: {@code id}
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * Required - API name: {@code searches}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>searches</code>.
         * </p>
         */
        @Nonnull
        public final Builder searches(List<SearchProfile> list) {
            this.searches = _listAddAll(this.searches, list);
            return this;
        }

        /**
         * Required - API name: {@code searches}
         *
         * <p>
         * Adds one or more values to <code>searches</code>.
         * </p>
         */
        @Nonnull
        public final Builder searches(SearchProfile value, SearchProfile... values) {
            this.searches = _listAdd(this.searches, value, values);
            return this;
        }

        /**
         * Required - API name: {@code searches}
         *
         * <p>
         * Adds a value to <code>searches</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder searches(Function<SearchProfile.Builder, ObjectBuilder<SearchProfile>> fn) {
            return searches(fn.apply(new SearchProfile.Builder()).build());
        }

        /**
         * Builds a {@link ShardProfile}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardProfile build() {
            _checkSingleUse();

            return new ShardProfile(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardProfile}
     */
    public static final JsonpDeserializer<ShardProfile> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardProfile::setupShardProfileDeserializer
    );

    protected static void setupShardProfileDeserializer(ObjectDeserializer<ShardProfile.Builder> op) {
        op.add(Builder::aggregations, JsonpDeserializer.arrayDeserializer(AggregationProfile._DESERIALIZER), "aggregations");
        op.add(Builder::fetch, FetchProfile._DESERIALIZER, "fetch");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::searches, JsonpDeserializer.arrayDeserializer(SearchProfile._DESERIALIZER), "searches");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.aggregations.hashCode();
        result = 31 * result + Objects.hashCode(this.fetch);
        result = 31 * result + this.id.hashCode();
        result = 31 * result + this.searches.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardProfile other = (ShardProfile) o;
        return this.aggregations.equals(other.aggregations)
            && Objects.equals(this.fetch, other.fetch)
            && this.id.equals(other.id)
            && this.searches.equals(other.searches);
    }
}
