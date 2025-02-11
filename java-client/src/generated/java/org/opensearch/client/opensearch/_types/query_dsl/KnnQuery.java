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

package org.opensearch.client.opensearch._types.query_dsl;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.KnnQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KnnQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<KnnQuery.Builder, KnnQuery> {

    @Nullable
    private final Boolean expandNestedDocs;

    @Nonnull
    private final String field;

    @Nullable
    private final Query filter;

    @Nullable
    private final Integer k;

    @Nullable
    private final Float maxDistance;

    @Nonnull
    private final Map<String, JsonData> methodParameters;

    @Nullable
    private final Float minScore;

    @Nullable
    private final KnnQueryRescore rescore;

    @Nonnull
    private final List<Float> vector;

    // ---------------------------------------------------------------------------------------------

    private KnnQuery(Builder builder) {
        super(builder);
        this.expandNestedDocs = builder.expandNestedDocs;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.filter = builder.filter;
        this.k = builder.k;
        this.maxDistance = builder.maxDistance;
        this.methodParameters = ApiTypeHelper.unmodifiable(builder.methodParameters);
        this.minScore = builder.minScore;
        this.rescore = builder.rescore;
        this.vector = ApiTypeHelper.unmodifiableRequired(builder.vector, this, "vector");
    }

    public static KnnQuery of(Function<KnnQuery.Builder, ObjectBuilder<KnnQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Knn;
    }

    /**
     * API name: {@code expand_nested_docs}
     */
    @Nullable
    public final Boolean expandNestedDocs() {
        return this.expandNestedDocs;
    }

    /**
     * Required - The target field
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * The filter for the k-NN search query.
     * <p>
     * API name: {@code filter}
     * </p>
     */
    @Nullable
    public final Query filter() {
        return this.filter;
    }

    /**
     * The total number of nearest neighbors to return as top hits.
     * <p>
     * API name: {@code k}
     * </p>
     */
    @Nullable
    public final Integer k() {
        return this.k;
    }

    /**
     * The maximum physical vector space distance required in order for a neighbor to be considered a hit.
     * <p>
     * API name: {@code max_distance}
     * </p>
     */
    @Nullable
    public final Float maxDistance() {
        return this.maxDistance;
    }

    /**
     * API name: {@code method_parameters}
     */
    @Nonnull
    public final Map<String, JsonData> methodParameters() {
        return this.methodParameters;
    }

    /**
     * The minimum similarity score required in order for a neighbor to be considered a hit.
     * <p>
     * API name: {@code min_score}
     * </p>
     */
    @Nullable
    public final Float minScore() {
        return this.minScore;
    }

    /**
     * API name: {@code rescore}
     */
    @Nullable
    public final KnnQueryRescore rescore() {
        return this.rescore;
    }

    /**
     * Required - API name: {@code vector}
     */
    @Nonnull
    public final List<Float> vector() {
        return this.vector;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject(this.field);
        super.serializeInternal(generator, mapper);
        if (this.expandNestedDocs != null) {
            generator.writeKey("expand_nested_docs");
            generator.write(this.expandNestedDocs);
        }

        if (this.filter != null) {
            generator.writeKey("filter");
            this.filter.serialize(generator, mapper);
        }

        if (this.k != null) {
            generator.writeKey("k");
            generator.write(this.k);
        }

        if (this.maxDistance != null) {
            generator.writeKey("max_distance");
            generator.write(this.maxDistance);
        }

        if (ApiTypeHelper.isDefined(this.methodParameters)) {
            generator.writeKey("method_parameters");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.methodParameters.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.minScore != null) {
            generator.writeKey("min_score");
            generator.write(this.minScore);
        }

        if (this.rescore != null) {
            generator.writeKey("rescore");
            this.rescore.serialize(generator, mapper);
        }

        generator.writeKey("vector");
        generator.writeStartArray();
        for (Float item0 : this.vector) {
            generator.write(item0);
        }
        generator.writeEnd();
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
     * Builder for {@link KnnQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, KnnQuery> {
        @Nullable
        private Boolean expandNestedDocs;
        private String field;
        @Nullable
        private Query filter;
        @Nullable
        private Integer k;
        @Nullable
        private Float maxDistance;
        @Nullable
        private Map<String, JsonData> methodParameters;
        @Nullable
        private Float minScore;
        @Nullable
        private KnnQueryRescore rescore;
        private List<Float> vector;

        public Builder() {}

        private Builder(KnnQuery o) {
            super(o);
            this.expandNestedDocs = o.expandNestedDocs;
            this.field = o.field;
            this.filter = o.filter;
            this.k = o.k;
            this.maxDistance = o.maxDistance;
            this.methodParameters = _mapCopy(o.methodParameters);
            this.minScore = o.minScore;
            this.rescore = o.rescore;
            this.vector = _listCopy(o.vector);
        }

        private Builder(Builder o) {
            super(o);
            this.expandNestedDocs = o.expandNestedDocs;
            this.field = o.field;
            this.filter = o.filter;
            this.k = o.k;
            this.maxDistance = o.maxDistance;
            this.methodParameters = _mapCopy(o.methodParameters);
            this.minScore = o.minScore;
            this.rescore = o.rescore;
            this.vector = _listCopy(o.vector);
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
         * API name: {@code expand_nested_docs}
         */
        @Nonnull
        public final Builder expandNestedDocs(@Nullable Boolean value) {
            this.expandNestedDocs = value;
            return this;
        }

        /**
         * Required - The target field
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * The filter for the k-NN search query.
         * <p>
         * API name: {@code filter}
         * </p>
         */
        @Nonnull
        public final Builder filter(@Nullable Query value) {
            this.filter = value;
            return this;
        }

        /**
         * The filter for the k-NN search query.
         * <p>
         * API name: {@code filter}
         * </p>
         */
        @Nonnull
        public final Builder filter(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return filter(fn.apply(new Query.Builder()).build());
        }

        /**
         * The total number of nearest neighbors to return as top hits.
         * <p>
         * API name: {@code k}
         * </p>
         */
        @Nonnull
        public final Builder k(@Nullable Integer value) {
            this.k = value;
            return this;
        }

        /**
         * The maximum physical vector space distance required in order for a neighbor to be considered a hit.
         * <p>
         * API name: {@code max_distance}
         * </p>
         */
        @Nonnull
        public final Builder maxDistance(@Nullable Float value) {
            this.maxDistance = value;
            return this;
        }

        /**
         * API name: {@code method_parameters}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>methodParameters</code>.
         * </p>
         */
        @Nonnull
        public final Builder methodParameters(Map<String, JsonData> map) {
            this.methodParameters = _mapPutAll(this.methodParameters, map);
            return this;
        }

        /**
         * API name: {@code method_parameters}
         *
         * <p>
         * Adds an entry to <code>methodParameters</code>.
         * </p>
         */
        @Nonnull
        public final Builder methodParameters(String key, JsonData value) {
            this.methodParameters = _mapPut(this.methodParameters, key, value);
            return this;
        }

        /**
         * The minimum similarity score required in order for a neighbor to be considered a hit.
         * <p>
         * API name: {@code min_score}
         * </p>
         */
        @Nonnull
        public final Builder minScore(@Nullable Float value) {
            this.minScore = value;
            return this;
        }

        /**
         * API name: {@code rescore}
         */
        @Nonnull
        public final Builder rescore(@Nullable KnnQueryRescore value) {
            this.rescore = value;
            return this;
        }

        /**
         * API name: {@code rescore}
         */
        @Nonnull
        public final Builder rescore(Function<KnnQueryRescore.Builder, ObjectBuilder<KnnQueryRescore>> fn) {
            return rescore(fn.apply(new KnnQueryRescore.Builder()).build());
        }

        /**
         * Required - API name: {@code vector}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>vector</code>.
         * </p>
         */
        @Nonnull
        public final Builder vector(List<Float> list) {
            this.vector = _listAddAll(this.vector, list);
            return this;
        }

        /**
         * Required - API name: {@code vector}
         *
         * <p>
         * Adds one or more values to <code>vector</code>.
         * </p>
         */
        @Nonnull
        public final Builder vector(Float value, Float... values) {
            this.vector = _listAdd(this.vector, value, values);
            return this;
        }

        /**
         * Builds a {@link KnnQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public KnnQuery build() {
            _checkSingleUse();

            return new KnnQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link KnnQuery}
     */
    public static final JsonpDeserializer<KnnQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KnnQuery::setupKnnQueryDeserializer
    );

    protected static void setupKnnQueryDeserializer(ObjectDeserializer<KnnQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::expandNestedDocs, JsonpDeserializer.booleanDeserializer(), "expand_nested_docs");
        op.add(Builder::filter, Query._DESERIALIZER, "filter");
        op.add(Builder::k, JsonpDeserializer.integerDeserializer(), "k");
        op.add(Builder::maxDistance, JsonpDeserializer.floatDeserializer(), "max_distance");
        op.add(Builder::methodParameters, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "method_parameters");
        op.add(Builder::minScore, JsonpDeserializer.floatDeserializer(), "min_score");
        op.add(Builder::rescore, KnnQueryRescore._DESERIALIZER, "rescore");
        op.add(Builder::vector, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.floatDeserializer()), "vector");
        op.setKey(Builder::field, JsonpDeserializer.stringDeserializer());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.expandNestedDocs);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.filter);
        result = 31 * result + Objects.hashCode(this.k);
        result = 31 * result + Objects.hashCode(this.maxDistance);
        result = 31 * result + Objects.hashCode(this.methodParameters);
        result = 31 * result + Objects.hashCode(this.minScore);
        result = 31 * result + Objects.hashCode(this.rescore);
        result = 31 * result + this.vector.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KnnQuery other = (KnnQuery) o;
        return Objects.equals(this.expandNestedDocs, other.expandNestedDocs)
            && this.field.equals(other.field)
            && Objects.equals(this.filter, other.filter)
            && Objects.equals(this.k, other.k)
            && Objects.equals(this.maxDistance, other.maxDistance)
            && Objects.equals(this.methodParameters, other.methodParameters)
            && Objects.equals(this.minScore, other.minScore)
            && Objects.equals(this.rescore, other.rescore)
            && this.vector.equals(other.vector);
    }
}
