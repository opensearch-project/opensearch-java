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
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.CompositeAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CompositeAggregation extends BucketAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<CompositeAggregation.Builder, CompositeAggregation> {

    @Nonnull
    private final Map<String, FieldValue> after;

    @Nullable
    private final Integer size;

    @Nonnull
    private final List<Map<String, CompositeAggregationSource>> sources;

    // ---------------------------------------------------------------------------------------------

    private CompositeAggregation(Builder builder) {
        super(builder);
        this.after = ApiTypeHelper.unmodifiable(builder.after);
        this.size = builder.size;
        this.sources = ApiTypeHelper.unmodifiable(builder.sources);
    }

    public static CompositeAggregation of(Function<CompositeAggregation.Builder, ObjectBuilder<CompositeAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.Composite;
    }

    /**
     * API name: {@code after}
     */
    @Nonnull
    public final Map<String, FieldValue> after() {
        return this.after;
    }

    /**
     * The number of composite buckets that should be returned.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * The value sources used to build composite buckets. Keys are returned in the order of the <code>sources</code> definition.
     * <p>
     * API name: {@code sources}
     * </p>
     */
    @Nonnull
    public final List<Map<String, CompositeAggregationSource>> sources() {
        return this.sources;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.after)) {
            generator.writeKey("after");
            generator.writeStartObject();
            for (Map.Entry<String, FieldValue> item0 : this.after.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (ApiTypeHelper.isDefined(this.sources)) {
            generator.writeKey("sources");
            generator.writeStartArray();
            for (Map<String, CompositeAggregationSource> item0 : this.sources) {
                generator.writeStartObject();
                if (item0 != null) {
                    for (Map.Entry<String, CompositeAggregationSource> item1 : item0.entrySet()) {
                        generator.writeKey(item1.getKey());
                        item1.getValue().serialize(generator, mapper);
                    }
                }
                generator.writeEnd();
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
     * Builder for {@link CompositeAggregation}.
     */
    public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, CompositeAggregation> {
        @Nullable
        private Map<String, FieldValue> after;
        @Nullable
        private Integer size;
        @Nullable
        private List<Map<String, CompositeAggregationSource>> sources;

        public Builder() {}

        private Builder(CompositeAggregation o) {
            super(o);
            this.after = _mapCopy(o.after);
            this.size = o.size;
            this.sources = _listCopy(o.sources);
        }

        private Builder(Builder o) {
            super(o);
            this.after = _mapCopy(o.after);
            this.size = o.size;
            this.sources = _listCopy(o.sources);
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
         * API name: {@code after}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>after</code>.
         * </p>
         */
        @Nonnull
        public final Builder after(Map<String, FieldValue> map) {
            this.after = _mapPutAll(this.after, map);
            return this;
        }

        /**
         * API name: {@code after}
         *
         * <p>
         * Adds an entry to <code>after</code>.
         * </p>
         */
        @Nonnull
        public final Builder after(String key, FieldValue value) {
            this.after = _mapPut(this.after, key, value);
            return this;
        }

        /**
         * API name: {@code after}
         *
         * <p>
         * Adds a value to <code>after</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder after(String key, Function<FieldValue.Builder, ObjectBuilder<FieldValue>> fn) {
            return after(key, fn.apply(new FieldValue.Builder()).build());
        }

        /**
         * The number of composite buckets that should be returned.
         * <p>
         * API name: {@code size}
         * </p>
         */
        @Nonnull
        public final Builder size(@Nullable Integer value) {
            this.size = value;
            return this;
        }

        /**
         * The value sources used to build composite buckets. Keys are returned in the order of the <code>sources</code> definition.
         * <p>
         * API name: {@code sources}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>sources</code>.
         * </p>
         */
        @Nonnull
        public final Builder sources(List<Map<String, CompositeAggregationSource>> list) {
            this.sources = _listAddAll(this.sources, list);
            return this;
        }

        /**
         * The value sources used to build composite buckets. Keys are returned in the order of the <code>sources</code> definition.
         * <p>
         * API name: {@code sources}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>sources</code>.
         * </p>
         */
        @Nonnull
        public final Builder sources(Map<String, CompositeAggregationSource> value, Map<String, CompositeAggregationSource>... values) {
            this.sources = _listAdd(this.sources, value, values);
            return this;
        }

        /**
         * Builds a {@link CompositeAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CompositeAggregation build() {
            _checkSingleUse();

            return new CompositeAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CompositeAggregation}
     */
    public static final JsonpDeserializer<CompositeAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CompositeAggregation::setupCompositeAggregationDeserializer
    );

    protected static void setupCompositeAggregationDeserializer(ObjectDeserializer<CompositeAggregation.Builder> op) {
        setupBucketAggregationBaseDeserializer(op);
        op.add(Builder::after, JsonpDeserializer.stringMapDeserializer(FieldValue._DESERIALIZER), "after");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(
            Builder::sources,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringMapDeserializer(CompositeAggregationSource._DESERIALIZER)),
            "sources"
        );
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.after);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.sources);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CompositeAggregation other = (CompositeAggregation) o;
        return Objects.equals(this.after, other.after)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.sources, other.sources);
    }
}
