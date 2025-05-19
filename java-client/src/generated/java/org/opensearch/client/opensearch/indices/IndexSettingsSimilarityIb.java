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

package org.opensearch.client.opensearch.indices;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.IBDistribution;
import org.opensearch.client.opensearch._types.IBLambda;
import org.opensearch.client.opensearch._types.TermFrequencyNormalization;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.IndexSettingsSimilarityIb

/**
 * The information-based similarity algorithm configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsSimilarityIb
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsSimilarityIb.Builder, IndexSettingsSimilarityIb> {

    @Nonnull
    private final IBDistribution distribution;

    @Nonnull
    private final IBLambda lambda;

    @Nonnull
    private final TermFrequencyNormalization normalization;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsSimilarityIb(Builder builder) {
        this.distribution = ApiTypeHelper.requireNonNull(builder.distribution, this, "distribution");
        this.lambda = ApiTypeHelper.requireNonNull(builder.lambda, this, "lambda");
        this.normalization = ApiTypeHelper.requireNonNull(builder.normalization, this, "normalization");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static IndexSettingsSimilarityIb of(Function<IndexSettingsSimilarityIb.Builder, ObjectBuilder<IndexSettingsSimilarityIb>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code distribution}
     */
    @Nonnull
    public final IBDistribution distribution() {
        return this.distribution;
    }

    /**
     * Required - API name: {@code lambda}
     */
    @Nonnull
    public final IBLambda lambda() {
        return this.lambda;
    }

    /**
     * Required - API name: {@code normalization}
     */
    @Nonnull
    public final TermFrequencyNormalization normalization() {
        return this.normalization;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
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
        generator.writeKey("distribution");
        this.distribution.serialize(generator, mapper);

        generator.writeKey("lambda");
        this.lambda.serialize(generator, mapper);

        generator.writeKey("normalization");
        this.normalization.serialize(generator, mapper);

        generator.writeKey("type");
        generator.write(this.type);
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
     * Builder for {@link IndexSettingsSimilarityIb}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsSimilarityIb> {
        private IBDistribution distribution;
        private IBLambda lambda;
        private TermFrequencyNormalization normalization;
        private String type;

        public Builder() {}

        private Builder(IndexSettingsSimilarityIb o) {
            this.distribution = o.distribution;
            this.lambda = o.lambda;
            this.normalization = o.normalization;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.distribution = o.distribution;
            this.lambda = o.lambda;
            this.normalization = o.normalization;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code distribution}
         */
        @Nonnull
        public final Builder distribution(IBDistribution value) {
            this.distribution = value;
            return this;
        }

        /**
         * Required - API name: {@code lambda}
         */
        @Nonnull
        public final Builder lambda(IBLambda value) {
            this.lambda = value;
            return this;
        }

        /**
         * Required - API name: {@code normalization}
         */
        @Nonnull
        public final Builder normalization(TermFrequencyNormalization value) {
            this.normalization = value;
            return this;
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link IndexSettingsSimilarityIb}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsSimilarityIb build() {
            _checkSingleUse();

            return new IndexSettingsSimilarityIb(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsSimilarityIb}
     */
    public static final JsonpDeserializer<IndexSettingsSimilarityIb> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsSimilarityIb::setupIndexSettingsSimilarityIbDeserializer
    );

    protected static void setupIndexSettingsSimilarityIbDeserializer(ObjectDeserializer<IndexSettingsSimilarityIb.Builder> op) {
        op.add(Builder::distribution, IBDistribution._DESERIALIZER, "distribution");
        op.add(Builder::lambda, IBLambda._DESERIALIZER, "lambda");
        op.add(Builder::normalization, TermFrequencyNormalization._DESERIALIZER, "normalization");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.distribution.hashCode();
        result = 31 * result + this.lambda.hashCode();
        result = 31 * result + this.normalization.hashCode();
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsSimilarityIb other = (IndexSettingsSimilarityIb) o;
        return this.distribution.equals(other.distribution)
            && this.lambda.equals(other.lambda)
            && this.normalization.equals(other.normalization)
            && this.type.equals(other.type);
    }
}
