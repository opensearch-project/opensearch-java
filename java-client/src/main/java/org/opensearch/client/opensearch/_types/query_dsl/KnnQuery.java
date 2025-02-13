/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;

@JsonpDeserializable
public class KnnQuery extends QueryBase implements QueryVariant {
    private final String field;
    private final float[] vector;
    @Nullable
    private final Integer k;
    @Nullable
    private final Float minScore;
    @Nullable
    private final Float maxDistance;
    @Nullable
    private final Query filter;
    @Nonnull
    private final Map<String, JsonData> methodParameters;
    @Nullable
    private final KnnQueryRescore rescore;
    @Nullable
    private final Boolean expandNestedDocs;

    private KnnQuery(Builder builder) {
        super(builder);

        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.vector = ApiTypeHelper.requireNonNull(builder.vector, this, "vector");
        this.k = builder.k;
        this.minScore = builder.minScore;
        this.maxDistance = builder.maxDistance;
        this.filter = builder.filter;
        this.methodParameters = ApiTypeHelper.unmodifiable(builder.methodParameters);
        this.rescore = builder.rescore;
        this.expandNestedDocs = builder.expandNestedDocs;
    }

    public static KnnQuery of(Function<Builder, ObjectBuilder<KnnQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Query variant kind.
     * @return The query variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Knn;
    }

    /**
     * Required - The target field.
     * @return The target field.
     */
    public final String field() {
        return this.field;
    }

    /**
     * Required - The vector to search for.
     * @return The vector to search for.
     */
    public final float[] vector() {
        return this.vector;
    }

    /**
     * Optional - The number of neighbors the search of each graph will return.
     * @return The number of neighbors to return.
     */
    @Nullable
    public final Integer k() {
        return this.k;
    }

    /**
     * Optional - The minimum score allowed for the returned search results.
     * @return The minimum score allowed for the returned search results.
     */
    @Nullable
    public final Float minScore() {
        return this.minScore;
    }

    /**
     * Optional - The maximum distance allowed between the vector and each of the returned search results.
     * @return The maximum distance allowed between the vector and each ofthe returned search results.
     */
    @Nullable
    public final Float maxDistance() {
        return this.maxDistance;
    }

    /**
     * Optional - A query to filter the results of the query.
     * @return The filter query.
     */
    @Nullable
    public final Query filter() {
        return this.filter;
    }

    @Nonnull
    public final Map<String, JsonData> methodParameters() {
        return this.methodParameters;
    }

    @Nullable
    public final KnnQueryRescore rescore() {
        return this.rescore;
    }

    @Nullable
    public final Boolean expandNestedDocs() {
        return this.expandNestedDocs;
    }

    @Override
    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject(this.field);

        super.serializeInternal(generator, mapper);

        generator.writeKey("vector");
        generator.writeStartArray();
        for (float value : this.vector) {
            generator.write(value);
        }
        generator.writeEnd();

        if (this.k != null) {
            generator.write("k", this.k);
        }

        if (this.minScore != null) {
            generator.write("min_score", this.minScore);
        }

        if (this.maxDistance != null) {
            generator.write("max_distance", this.maxDistance);
        }

        if (this.filter != null) {
            generator.writeKey("filter");
            this.filter.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.methodParameters)) {
            generator.writeKey("method_parameters");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> entry : this.methodParameters.entrySet()) {
                generator.writeKey(entry.getKey());
                entry.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.rescore != null) {
            generator.writeKey("rescore");
            this.rescore.serialize(generator, mapper);
        }

        if (this.expandNestedDocs != null) {
            generator.write("expand_nested_docs", this.expandNestedDocs);
        }

        generator.writeEnd();
    }

    public Builder toBuilder() {
        return toBuilder(new Builder()).field(field)
            .vector(vector)
            .k(k)
            .minScore(minScore)
            .maxDistance(maxDistance)
            .filter(filter)
            .methodParameters(methodParameters)
            .rescore(rescore)
            .expandNestedDocs(expandNestedDocs);
    }

    /**
     * Builder for {@link KnnQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements ObjectBuilder<KnnQuery> {
        @Nullable
        private String field;
        @Nullable
        private float[] vector;
        @Nullable
        private Integer k;
        @Nullable
        private Float minScore;
        @Nullable
        private Float maxDistance;
        @Nullable
        private Query filter;
        @Nullable
        private Map<String, JsonData> methodParameters;
        @Nullable
        private KnnQueryRescore rescore;
        @Nullable
        private Boolean expandNestedDocs;

        /**
         * Required - The target field.
         * @param field The target field.
         * @return This builder.
         */
        public Builder field(@Nullable String field) {
            this.field = field;
            return this;
        }

        /**
         * Required - The vector to search for.
         *
         * @param vector The vector to search for.
         * @return This builder.
         */
        public Builder vector(@Nullable float[] vector) {
            this.vector = vector;
            return this;
        }

        /**
         * Optional - The number of neighbors to return.
         *
         * @param k The number of neighbors to return.
         * @return This builder.
         */
        public Builder k(@Nullable Integer k) {
            this.k = k;
            return this;
        }

        /**
         * Optional - The minimum score allowed for the returned search results.
         *
         * @param minScore The minimum score allowed for the returned search results.
         * @return This builder.
         */
        public Builder minScore(@Nullable Float minScore) {
            this.minScore = minScore;
            return this;
        }

        /**
         * Optional - The maximum distance allowed between the vector and each of the returned search results.
         *
         * @param maxDistance The maximum distance allowed between the vector and each ofthe returned search results.
         * @return This builder.
         */
        public Builder maxDistance(@Nullable Float maxDistance) {
            this.maxDistance = maxDistance;
            return this;
        }

        /**
         * Optional - A query to filter the results of the knn query.
         *
         * @param filter The filter query.
         * @return This builder.
         */
        public Builder filter(@Nullable Query filter) {
            this.filter = filter;
            return this;
        }

        public Builder methodParameters(@Nonnull Map<String, JsonData> value) {
            this.methodParameters = _mapPutAll(this.methodParameters, value);
            return this;
        }

        public Builder methodParameters(String key, JsonData value) {
            this.methodParameters = _mapPut(this.methodParameters, key, value);
            return this;
        }

        public Builder rescore(@Nullable KnnQueryRescore value) {
            this.rescore = value;
            return this;
        }

        public Builder rescore(Function<KnnQueryRescore.Builder, ObjectBuilder<KnnQueryRescore>> fn) {
            return this.rescore(fn.apply(new KnnQueryRescore.Builder()).build());
        }

        public Builder expandNestedDocs(@Nullable Boolean value) {
            this.expandNestedDocs = value;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link KnnQuery}.
         *
         * @return The built {@link KnnQuery}.
         */
        @Override
        public KnnQuery build() {
            _checkSingleUse();

            return new KnnQuery(this);
        }
    }

    public static final JsonpDeserializer<KnnQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KnnQuery::setupKnnQueryDeserializer
    );

    protected static void setupKnnQueryDeserializer(ObjectDeserializer<Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add((b, v) -> {
            float[] vector = new float[v.size()];
            int i = 0;
            for (Float value : v) {
                vector[i++] = value;
            }
            b.vector(vector);
        }, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.floatDeserializer()), "vector");
        op.add(Builder::k, JsonpDeserializer.integerDeserializer(), "k");
        op.add(Builder::minScore, JsonpDeserializer.floatDeserializer(), "min_score");
        op.add(Builder::maxDistance, JsonpDeserializer.floatDeserializer(), "max_distance");
        op.add(Builder::filter, Query._DESERIALIZER, "filter");
        op.add(Builder::methodParameters, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "method_parameters");
        op.add(Builder::rescore, KnnQueryRescore._DESERIALIZER, "rescore");
        op.add(Builder::expandNestedDocs, JsonpDeserializer.booleanDeserializer(), "expand_nested_docs");

        op.setKey(Builder::field, JsonpDeserializer.stringDeserializer());
    }
}
