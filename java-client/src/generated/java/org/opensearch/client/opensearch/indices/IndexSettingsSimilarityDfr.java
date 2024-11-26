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
import org.opensearch.client.opensearch._types.DFRAfterEffect;
import org.opensearch.client.opensearch._types.DFRBasicModel;
import org.opensearch.client.opensearch._types.TermFrequencyNormalization;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.IndexSettingsSimilarityDfr

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsSimilarityDfr
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsSimilarityDfr.Builder, IndexSettingsSimilarityDfr> {

    @Nonnull
    private final DFRAfterEffect afterEffect;

    @Nonnull
    private final DFRBasicModel basicModel;

    @Nonnull
    private final TermFrequencyNormalization normalization;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsSimilarityDfr(Builder builder) {
        this.afterEffect = ApiTypeHelper.requireNonNull(builder.afterEffect, this, "afterEffect");
        this.basicModel = ApiTypeHelper.requireNonNull(builder.basicModel, this, "basicModel");
        this.normalization = ApiTypeHelper.requireNonNull(builder.normalization, this, "normalization");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static IndexSettingsSimilarityDfr of(
        Function<IndexSettingsSimilarityDfr.Builder, ObjectBuilder<IndexSettingsSimilarityDfr>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code after_effect}
     */
    @Nonnull
    public final DFRAfterEffect afterEffect() {
        return this.afterEffect;
    }

    /**
     * Required - API name: {@code basic_model}
     */
    @Nonnull
    public final DFRBasicModel basicModel() {
        return this.basicModel;
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
        generator.writeKey("after_effect");
        this.afterEffect.serialize(generator, mapper);

        generator.writeKey("basic_model");
        this.basicModel.serialize(generator, mapper);

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
     * Builder for {@link IndexSettingsSimilarityDfr}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsSimilarityDfr> {
        private DFRAfterEffect afterEffect;
        private DFRBasicModel basicModel;
        private TermFrequencyNormalization normalization;
        private String type;

        public Builder() {}

        private Builder(IndexSettingsSimilarityDfr o) {
            this.afterEffect = o.afterEffect;
            this.basicModel = o.basicModel;
            this.normalization = o.normalization;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.afterEffect = o.afterEffect;
            this.basicModel = o.basicModel;
            this.normalization = o.normalization;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code after_effect}
         */
        @Nonnull
        public final Builder afterEffect(DFRAfterEffect value) {
            this.afterEffect = value;
            return this;
        }

        /**
         * Required - API name: {@code basic_model}
         */
        @Nonnull
        public final Builder basicModel(DFRBasicModel value) {
            this.basicModel = value;
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
         * Builds a {@link IndexSettingsSimilarityDfr}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsSimilarityDfr build() {
            _checkSingleUse();

            return new IndexSettingsSimilarityDfr(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsSimilarityDfr}
     */
    public static final JsonpDeserializer<IndexSettingsSimilarityDfr> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsSimilarityDfr::setupIndexSettingsSimilarityDfrDeserializer
    );

    protected static void setupIndexSettingsSimilarityDfrDeserializer(ObjectDeserializer<IndexSettingsSimilarityDfr.Builder> op) {
        op.add(Builder::afterEffect, DFRAfterEffect._DESERIALIZER, "after_effect");
        op.add(Builder::basicModel, DFRBasicModel._DESERIALIZER, "basic_model");
        op.add(Builder::normalization, TermFrequencyNormalization._DESERIALIZER, "normalization");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.afterEffect.hashCode();
        result = 31 * result + this.basicModel.hashCode();
        result = 31 * result + this.normalization.hashCode();
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsSimilarityDfr other = (IndexSettingsSimilarityDfr) o;
        return this.afterEffect.equals(other.afterEffect)
            && this.basicModel.equals(other.basicModel)
            && this.normalization.equals(other.normalization)
            && this.type.equals(other.type);
    }
}
