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

package org.opensearch.client.opensearch._types.aggregations;

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

// typedef: _types.aggregations.GeoHashGridAggregate

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoHashGridAggregate
    implements
        AggregateVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<GeoHashGridAggregate.Builder, GeoHashGridAggregate> {

    @Nonnull
    private final Buckets<GeoHashGridBucket> buckets;

    @Nonnull
    private final Map<String, JsonData> meta;

    // ---------------------------------------------------------------------------------------------

    private GeoHashGridAggregate(Builder builder) {
        this.buckets = ApiTypeHelper.requireNonNull(builder.buckets, this, "buckets");
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
    }

    public static GeoHashGridAggregate of(Function<GeoHashGridAggregate.Builder, ObjectBuilder<GeoHashGridAggregate>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregate} variant kind.
     */
    @Override
    public Aggregate.Kind _aggregateKind() {
        return Aggregate.Kind.GeohashGrid;
    }

    /**
     * Required - API name: {@code buckets}
     */
    @Nonnull
    public final Buckets<GeoHashGridBucket> buckets() {
        return this.buckets;
    }

    /**
     * API name: {@code meta}
     */
    @Nonnull
    public final Map<String, JsonData> meta() {
        return this.meta;
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
        generator.writeKey("buckets");
        this.buckets.serialize(generator, mapper);

        if (ApiTypeHelper.isDefined(this.meta)) {
            generator.writeKey("meta");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.meta.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
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
     * Builder for {@link GeoHashGridAggregate}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GeoHashGridAggregate> {
        private Buckets<GeoHashGridBucket> buckets;
        @Nullable
        private Map<String, JsonData> meta;

        public Builder() {}

        private Builder(GeoHashGridAggregate o) {
            this.buckets = o.buckets;
            this.meta = _mapCopy(o.meta);
        }

        private Builder(Builder o) {
            this.buckets = o.buckets;
            this.meta = _mapCopy(o.meta);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code buckets}
         */
        @Nonnull
        public final Builder buckets(Buckets<GeoHashGridBucket> value) {
            this.buckets = value;
            return this;
        }

        /**
         * Required - API name: {@code buckets}
         */
        @Nonnull
        public final Builder buckets(Function<Buckets.Builder<GeoHashGridBucket>, ObjectBuilder<Buckets<GeoHashGridBucket>>> fn) {
            return buckets(fn.apply(new Buckets.Builder<GeoHashGridBucket>()).build());
        }

        /**
         * API name: {@code meta}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(Map<String, JsonData> map) {
            this.meta = _mapPutAll(this.meta, map);
            return this;
        }

        /**
         * API name: {@code meta}
         *
         * <p>
         * Adds an entry to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(String key, JsonData value) {
            this.meta = _mapPut(this.meta, key, value);
            return this;
        }

        /**
         * Builds a {@link GeoHashGridAggregate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoHashGridAggregate build() {
            _checkSingleUse();

            return new GeoHashGridAggregate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoHashGridAggregate}
     */
    public static final JsonpDeserializer<GeoHashGridAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoHashGridAggregate::setupGeoHashGridAggregateDeserializer
    );

    protected static void setupGeoHashGridAggregateDeserializer(ObjectDeserializer<GeoHashGridAggregate.Builder> op) {
        op.add(Builder::buckets, Buckets.createBucketsDeserializer(GeoHashGridBucket._DESERIALIZER), "buckets");
        op.add(Builder::meta, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "meta");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.buckets.hashCode();
        result = 31 * result + Objects.hashCode(this.meta);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeoHashGridAggregate other = (GeoHashGridAggregate) o;
        return this.buckets.equals(other.buckets) && Objects.equals(this.meta, other.meta);
    }
}
