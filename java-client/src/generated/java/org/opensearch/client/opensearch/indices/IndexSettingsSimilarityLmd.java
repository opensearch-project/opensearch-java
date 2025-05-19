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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.IndexSettingsSimilarityLmd

/**
 * The LM Dirichlet similarity algorithm configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsSimilarityLmd
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsSimilarityLmd.Builder, IndexSettingsSimilarityLmd> {

    private final float mu;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsSimilarityLmd(Builder builder) {
        this.mu = ApiTypeHelper.requireNonNull(builder.mu, this, "mu");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static IndexSettingsSimilarityLmd of(
        Function<IndexSettingsSimilarityLmd.Builder, ObjectBuilder<IndexSettingsSimilarityLmd>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The smoothing parameter.
     * <p>
     * API name: {@code mu}
     * </p>
     */
    public final float mu() {
        return this.mu;
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
        generator.writeKey("mu");
        generator.write(this.mu);

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
     * Builder for {@link IndexSettingsSimilarityLmd}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsSimilarityLmd> {
        private Float mu;
        private String type;

        public Builder() {}

        private Builder(IndexSettingsSimilarityLmd o) {
            this.mu = o.mu;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.mu = o.mu;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The smoothing parameter.
         * <p>
         * API name: {@code mu}
         * </p>
         */
        @Nonnull
        public final Builder mu(float value) {
            this.mu = value;
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
         * Builds a {@link IndexSettingsSimilarityLmd}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsSimilarityLmd build() {
            _checkSingleUse();

            return new IndexSettingsSimilarityLmd(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsSimilarityLmd}
     */
    public static final JsonpDeserializer<IndexSettingsSimilarityLmd> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsSimilarityLmd::setupIndexSettingsSimilarityLmdDeserializer
    );

    protected static void setupIndexSettingsSimilarityLmdDeserializer(ObjectDeserializer<IndexSettingsSimilarityLmd.Builder> op) {
        op.add(Builder::mu, JsonpDeserializer.floatDeserializer(), "mu");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Float.hashCode(this.mu);
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsSimilarityLmd other = (IndexSettingsSimilarityLmd) o;
        return this.mu == other.mu && this.type.equals(other.type);
    }
}
