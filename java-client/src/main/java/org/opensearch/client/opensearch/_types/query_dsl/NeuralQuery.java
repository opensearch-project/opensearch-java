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
import org.opensearch.client.util.ObjectBuilder;

@JsonpDeserializable
public class NeuralQuery extends QueryBase implements QueryVariant {

    private final String field;
    private final String queryText;
    private final int k;
    @Nullable
    private final String modelId;

    private NeuralQuery(NeuralQuery.Builder builder) {
        super(builder);

        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.queryText = ApiTypeHelper.requireNonNull(builder.queryText, this, "queryText");
        this.k = ApiTypeHelper.requireNonNull(builder.k, this, "k");
        this.modelId = builder.modelId;
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
     * Required - Search query text.
     *
     * @return Search query text.
     */
    public final String queryText() {
        return this.queryText;
    }

    /**
     * Required - The number of neighbors to return.
     *
     * @return The number of neighbors to return.
     */
    public final int k() {
        return this.k;
    }

    /**
     * Builder for {@link NeuralQuery}.
     */

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

    @Override
    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject(this.field);

        super.serializeInternal(generator, mapper);

        generator.write("query_text", this.queryText);

        if (this.modelId != null) {
            generator.write("model_id", this.modelId);
        }

        generator.write("k", this.k);

        generator.writeEnd();
    }

    public Builder toBuilder() {
        return new Builder().field(field).queryText(queryText).k(k).modelId(modelId);
    }

    /**
     * Builder for {@link NeuralQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<NeuralQuery.Builder> implements ObjectBuilder<NeuralQuery> {
        private String field;
        private String queryText;
        private Integer k;
        @Nullable
        private String modelId;

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
         * Required - Search query text.
         *
         * @param queryText Search query text.
         * @return This builder.
         */
        public NeuralQuery.Builder queryText(@Nullable String queryText) {
            this.queryText = queryText;
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
         * Required - The number of neighbors to return.
         *
         * @param k The number of neighbors to return.
         * @return This builder.
         */
        public NeuralQuery.Builder k(@Nullable Integer k) {
            this.k = k;
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
        op.add(NeuralQuery.Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(NeuralQuery.Builder::k, JsonpDeserializer.integerDeserializer(), "k");

        op.setKey(NeuralQuery.Builder::field, JsonpDeserializer.stringDeserializer());
    }
}
