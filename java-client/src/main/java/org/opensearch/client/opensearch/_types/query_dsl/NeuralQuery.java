/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.MissingRequiredPropertiesException;
import org.opensearch.client.util.ObjectBuilder;

@JsonpDeserializable
public class NeuralQuery extends QueryBase implements QueryVariant {

    private final String field;
    private final String queryText;
    private final String queryImage;
    @Nullable
    private final Integer k;
    @Nullable
    private final Float minScore;
    @Nullable
    private final Float maxDistance;
    @Nullable
    private final String modelId;
    @Nullable
    private final Query filter;

    private NeuralQuery(NeuralQuery.Builder builder) {
        super(builder);

        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        if (builder.queryText == null && builder.queryImage == null && !ApiTypeHelper.requiredPropertiesCheckDisabled()) {
            throw new MissingRequiredPropertiesException(this, "queryText", "queryImage");
        }
        this.queryText = builder.queryText;
        this.queryImage = builder.queryImage;
        this.k = builder.k;
        this.minScore = builder.minScore;
        this.maxDistance = builder.maxDistance;
        this.modelId = builder.modelId;
        this.filter = builder.filter;
    }

    public static NeuralQuery of(Function<NeuralQuery.Builder, ObjectBuilder<NeuralQuery>> fn) {
        return fn.apply(new NeuralQuery.Builder()).build();
    }

    /**
     * Query variant kind.
     *
     * @return The query variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Neural;
    }

    /**
     * Required - The target field.
     *
     * @return The target field.
     */
    public final String field() {
        return this.field;
    }

    /**
     * Required - The query_text if query_image is not set.
     * Optional - The query_text if query_image is set.
     *
     * @return Search query text.
     */
    public final String queryText() {
        return this.queryText;
    }

    /**
     * Required - The query_image if query_text is not set.
     * Optional - The query_image if query_text is set.
     *
     * @return Search query image.
     */
    public final String queryImage() {
        return this.queryImage;
    }

    /**
     * Optional - The number of neighbors to return.
     *
     * @return The number of neighbors to return.
     */
    @Nullable
    public final Integer k() {
        return this.k;
    }

    /**
     * Optional - The minimum score threshold for the search results
     *
     * @return The minimum score threshold for the search results
     */
    @Nullable
    public final Float minScore() {
        return this.minScore;
    }

    /**
     * Optional - The maximum distance threshold for the search results
     *
     * @return The maximum distance threshold for the search results
     */
    @Nullable
    public final Float maxDistance() {
        return this.maxDistance;
    }

    /**
     * Optional - The model_id field if the default model for the index or field is set.
     * Required - The model_id field if there is no default model set for the index or field.
     *
     * @return The model_id field.
     */
    @Nullable
    public final String modelId() {
        return this.modelId;
    }

    /**
     * Optional - A query to filter the results of the query.
     *
     * @return The filter query.
     */
    @Nullable
    public final Query filter() {
        return this.filter;
    }

    @Override
    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject(this.field);

        super.serializeInternal(generator, mapper);

        if (this.queryText != null) {
            generator.write("query_text", this.queryText);
        }

        if (this.queryImage != null) {
            generator.write("query_image", this.queryImage);
        }

        if (this.modelId != null) {
            generator.write("model_id", this.modelId);
        }

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

        generator.writeEnd();
    }

    public Builder toBuilder() {
        return toBuilder(new Builder()).field(field).queryText(queryText).queryImage(queryImage).k(k).minScore(minScore).maxDistance(maxDistance).modelId(modelId).filter(filter);
    }

    /**
     * Builder for {@link NeuralQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<NeuralQuery.Builder> implements ObjectBuilder<NeuralQuery> {
        private String field;
        private String queryText;
        private String queryImage;
        @Nullable
        private Integer k;
        @Nullable
        private Float minScore;
        @Nullable
        private Float maxDistance;
        @Nullable
        private String modelId;
        @Nullable
        private Query filter;

        /**
         * Required - The target field.
         *
         * @param field The target field.
         * @return This builder.
         */
        public NeuralQuery.Builder field(@Nullable String field) {
            this.field = field;
            return this;
        }

        /**
         * Required - The query_text if query_image is not set.
         * Optional - The query_text if query_image is set.
         *
         * @param queryText Search query text.
         * @return This builder.
         */
        public NeuralQuery.Builder queryText(@Nullable String queryText) {
            this.queryText = queryText;
            return this;
        }

        /**
         * Required - The query_image if query_text is not set.
         * Optional - The query_image if query_text is set.
         *
         * @param queryImage Search query image.
         * @return This builder.
         */
        public NeuralQuery.Builder queryImage(@Nullable String queryImage) {
            this.queryImage = queryImage;
            return this;
        }

        /**
         * Optional - The model_id field if the default model for the index or field is set.
         * Required - The model_id field if there is no default model set for the index or field.
         *
         * @param modelId The model_id field.
         * @return This builder.
         */
        public NeuralQuery.Builder modelId(@Nullable String modelId) {
            this.modelId = modelId;
            return this;
        }

        /**
         * Optional - The number of neighbors to return.
         *
         * @param k The number of neighbors to return.
         * @return This builder.
         */
        public NeuralQuery.Builder k(@Nullable Integer k) {
            this.k = k;
            return this;
        }

        /**
         * Optional - The minimum score threshold for the search results
         *
         * @param minScore The minimum score threshold for the search results
         * @return This builder.
         */
        public NeuralQuery.Builder minScore(@Nullable Float minScore) {
            this.minScore = minScore;
            return this;
        }

        /**
         * Optional - The maximum distance threshold for the search results
         *
         * @param maxDistance The maximum distance threshold for the search results
         * @return This builder.
         */
        public NeuralQuery.Builder maxDistance(@Nullable Float maxDistance) {
            this.maxDistance = maxDistance;
            return this;
        }

        /**
         * Optional - A query to filter the results of the knn query.
         *
         * @param filter The filter query.
         * @return This builder.
         */
        public NeuralQuery.Builder filter(@Nullable Query filter) {
            this.filter = filter;
            return this;
        }

        @Override
        protected NeuralQuery.Builder self() {
            return this;
        }

        /**
         * Builds a {@link NeuralQuery}.
         *
         * @return The built {@link NeuralQuery}.
         */
        @Override
        public NeuralQuery build() {
            _checkSingleUse();

            return new NeuralQuery(this);
        }
    }

    public static final JsonpDeserializer<NeuralQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        NeuralQuery.Builder::new,
        NeuralQuery::setupNeuralQueryDeserializer
    );

    protected static void setupNeuralQueryDeserializer(ObjectDeserializer<NeuralQuery.Builder> op) {
        setupQueryBaseDeserializer(op);

        op.add(NeuralQuery.Builder::queryText, JsonpDeserializer.stringDeserializer(), "query_text");
        op.add(NeuralQuery.Builder::queryImage, JsonpDeserializer.stringDeserializer(), "query_image");
        op.add(NeuralQuery.Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(NeuralQuery.Builder::k, JsonpDeserializer.integerDeserializer(), "k");
        op.add(NeuralQuery.Builder::minScore, JsonpDeserializer.floatDeserializer(), "min_score");
        op.add(NeuralQuery.Builder::maxDistance, JsonpDeserializer.floatDeserializer(), "max_distance");
        op.add(NeuralQuery.Builder::filter, Query._DESERIALIZER, "filter");

        op.setKey(NeuralQuery.Builder::field, JsonpDeserializer.stringDeserializer());
    }
}
