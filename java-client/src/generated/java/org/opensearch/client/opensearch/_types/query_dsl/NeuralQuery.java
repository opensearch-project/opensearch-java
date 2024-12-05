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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.NeuralQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NeuralQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<NeuralQuery.Builder, NeuralQuery> {

    @Nonnull
    private final String field;

    @Nullable
    private final Query filter;

    @Nullable
    private final Integer k;

    @Nullable
    private final Float maxDistance;

    @Nullable
    private final Float minScore;

    @Nullable
    private final String modelId;

    @Nullable
    private final String queryImage;

    @Nullable
    private final String queryText;

    // ---------------------------------------------------------------------------------------------

    private NeuralQuery(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.filter = builder.filter;
        this.k = builder.k;
        this.maxDistance = builder.maxDistance;
        this.minScore = builder.minScore;
        this.modelId = builder.modelId;
        this.queryImage = builder.queryImage;
        this.queryText = builder.queryText;
    }

    public static NeuralQuery of(Function<NeuralQuery.Builder, ObjectBuilder<NeuralQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Neural;
    }

    /**
     * Required - The target field
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code filter}
     */
    @Nullable
    public final Query filter() {
        return this.filter;
    }

    /**
     * API name: {@code k}
     */
    @Nullable
    public final Integer k() {
        return this.k;
    }

    /**
     * API name: {@code max_distance}
     */
    @Nullable
    public final Float maxDistance() {
        return this.maxDistance;
    }

    /**
     * API name: {@code min_score}
     */
    @Nullable
    public final Float minScore() {
        return this.minScore;
    }

    /**
     * API name: {@code model_id}
     */
    @Nullable
    public final String modelId() {
        return this.modelId;
    }

    /**
     * API name: {@code query_image}
     */
    @Nullable
    public final String queryImage() {
        return this.queryImage;
    }

    /**
     * API name: {@code query_text}
     */
    @Nullable
    public final String queryText() {
        return this.queryText;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject(this.field);
        super.serializeInternal(generator, mapper);
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

        if (this.minScore != null) {
            generator.writeKey("min_score");
            generator.write(this.minScore);
        }

        if (this.modelId != null) {
            generator.writeKey("model_id");
            generator.write(this.modelId);
        }

        if (this.queryImage != null) {
            generator.writeKey("query_image");
            generator.write(this.queryImage);
        }

        if (this.queryText != null) {
            generator.writeKey("query_text");
            generator.write(this.queryText);
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
     * Builder for {@link NeuralQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, NeuralQuery> {
        private String field;
        @Nullable
        private Query filter;
        @Nullable
        private Integer k;
        @Nullable
        private Float maxDistance;
        @Nullable
        private Float minScore;
        @Nullable
        private String modelId;
        @Nullable
        private String queryImage;
        @Nullable
        private String queryText;

        public Builder() {}

        private Builder(NeuralQuery o) {
            super(o);
            this.field = o.field;
            this.filter = o.filter;
            this.k = o.k;
            this.maxDistance = o.maxDistance;
            this.minScore = o.minScore;
            this.modelId = o.modelId;
            this.queryImage = o.queryImage;
            this.queryText = o.queryText;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.filter = o.filter;
            this.k = o.k;
            this.maxDistance = o.maxDistance;
            this.minScore = o.minScore;
            this.modelId = o.modelId;
            this.queryImage = o.queryImage;
            this.queryText = o.queryText;
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
         * Required - The target field
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code filter}
         */
        @Nonnull
        public final Builder filter(@Nullable Query value) {
            this.filter = value;
            return this;
        }

        /**
         * API name: {@code filter}
         */
        @Nonnull
        public final Builder filter(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return filter(fn.apply(new Query.Builder()).build());
        }

        /**
         * API name: {@code k}
         */
        @Nonnull
        public final Builder k(@Nullable Integer value) {
            this.k = value;
            return this;
        }

        /**
         * API name: {@code max_distance}
         */
        @Nonnull
        public final Builder maxDistance(@Nullable Float value) {
            this.maxDistance = value;
            return this;
        }

        /**
         * API name: {@code min_score}
         */
        @Nonnull
        public final Builder minScore(@Nullable Float value) {
            this.minScore = value;
            return this;
        }

        /**
         * API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(@Nullable String value) {
            this.modelId = value;
            return this;
        }

        /**
         * API name: {@code query_image}
         */
        @Nonnull
        public final Builder queryImage(@Nullable String value) {
            this.queryImage = value;
            return this;
        }

        /**
         * API name: {@code query_text}
         */
        @Nonnull
        public final Builder queryText(@Nullable String value) {
            this.queryText = value;
            return this;
        }

        /**
         * Builds a {@link NeuralQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NeuralQuery build() {
            _checkSingleUse();

            return new NeuralQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NeuralQuery}
     */
    public static final JsonpDeserializer<NeuralQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NeuralQuery::setupNeuralQueryDeserializer
    );

    protected static void setupNeuralQueryDeserializer(ObjectDeserializer<NeuralQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::filter, Query._DESERIALIZER, "filter");
        op.add(Builder::k, JsonpDeserializer.integerDeserializer(), "k");
        op.add(Builder::maxDistance, JsonpDeserializer.floatDeserializer(), "max_distance");
        op.add(Builder::minScore, JsonpDeserializer.floatDeserializer(), "min_score");
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(Builder::queryImage, JsonpDeserializer.stringDeserializer(), "query_image");
        op.add(Builder::queryText, JsonpDeserializer.stringDeserializer(), "query_text");
        op.setKey(Builder::field, JsonpDeserializer.stringDeserializer());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.filter);
        result = 31 * result + Objects.hashCode(this.k);
        result = 31 * result + Objects.hashCode(this.maxDistance);
        result = 31 * result + Objects.hashCode(this.minScore);
        result = 31 * result + Objects.hashCode(this.modelId);
        result = 31 * result + Objects.hashCode(this.queryImage);
        result = 31 * result + Objects.hashCode(this.queryText);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NeuralQuery other = (NeuralQuery) o;
        return this.field.equals(other.field)
            && Objects.equals(this.filter, other.filter)
            && Objects.equals(this.k, other.k)
            && Objects.equals(this.maxDistance, other.maxDistance)
            && Objects.equals(this.minScore, other.minScore)
            && Objects.equals(this.modelId, other.modelId)
            && Objects.equals(this.queryImage, other.queryImage)
            && Objects.equals(this.queryText, other.queryText);
    }
}
