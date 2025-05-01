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

package org.opensearch.client.opensearch.indices.validate_query;

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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.validate_query.IndicesValidationExplanation

/**
 * The validation results for an index query.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndicesValidationExplanation
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndicesValidationExplanation.Builder, IndicesValidationExplanation> {

    @Nullable
    private final String error;

    @Nullable
    private final String explanation;

    @Nonnull
    private final String index;

    private final boolean valid;

    // ---------------------------------------------------------------------------------------------

    private IndicesValidationExplanation(Builder builder) {
        this.error = builder.error;
        this.explanation = builder.explanation;
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.valid = ApiTypeHelper.requireNonNull(builder.valid, this, "valid");
    }

    public static IndicesValidationExplanation of(
        Function<IndicesValidationExplanation.Builder, ObjectBuilder<IndicesValidationExplanation>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The error message if validation failed.
     * <p>
     * API name: {@code error}
     * </p>
     */
    @Nullable
    public final String error() {
        return this.error;
    }

    /**
     * The explanation of why the query is valid or invalid.
     * <p>
     * API name: {@code explanation}
     * </p>
     */
    @Nullable
    public final String explanation() {
        return this.explanation;
    }

    /**
     * Required - API name: {@code index}
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * Required - Whether the query is valid for the index.
     * <p>
     * API name: {@code valid}
     * </p>
     */
    public final boolean valid() {
        return this.valid;
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
        if (this.error != null) {
            generator.writeKey("error");
            generator.write(this.error);
        }

        if (this.explanation != null) {
            generator.writeKey("explanation");
            generator.write(this.explanation);
        }

        generator.writeKey("index");
        generator.write(this.index);

        generator.writeKey("valid");
        generator.write(this.valid);
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
     * Builder for {@link IndicesValidationExplanation}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndicesValidationExplanation> {
        @Nullable
        private String error;
        @Nullable
        private String explanation;
        private String index;
        private Boolean valid;

        public Builder() {}

        private Builder(IndicesValidationExplanation o) {
            this.error = o.error;
            this.explanation = o.explanation;
            this.index = o.index;
            this.valid = o.valid;
        }

        private Builder(Builder o) {
            this.error = o.error;
            this.explanation = o.explanation;
            this.index = o.index;
            this.valid = o.valid;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The error message if validation failed.
         * <p>
         * API name: {@code error}
         * </p>
         */
        @Nonnull
        public final Builder error(@Nullable String value) {
            this.error = value;
            return this;
        }

        /**
         * The explanation of why the query is valid or invalid.
         * <p>
         * API name: {@code explanation}
         * </p>
         */
        @Nonnull
        public final Builder explanation(@Nullable String value) {
            this.explanation = value;
            return this;
        }

        /**
         * Required - API name: {@code index}
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * Required - Whether the query is valid for the index.
         * <p>
         * API name: {@code valid}
         * </p>
         */
        @Nonnull
        public final Builder valid(boolean value) {
            this.valid = value;
            return this;
        }

        /**
         * Builds a {@link IndicesValidationExplanation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndicesValidationExplanation build() {
            _checkSingleUse();

            return new IndicesValidationExplanation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndicesValidationExplanation}
     */
    public static final JsonpDeserializer<IndicesValidationExplanation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndicesValidationExplanation::setupIndicesValidationExplanationDeserializer
    );

    protected static void setupIndicesValidationExplanationDeserializer(ObjectDeserializer<IndicesValidationExplanation.Builder> op) {
        op.add(Builder::error, JsonpDeserializer.stringDeserializer(), "error");
        op.add(Builder::explanation, JsonpDeserializer.stringDeserializer(), "explanation");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::valid, JsonpDeserializer.booleanDeserializer(), "valid");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.error);
        result = 31 * result + Objects.hashCode(this.explanation);
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Boolean.hashCode(this.valid);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndicesValidationExplanation other = (IndicesValidationExplanation) o;
        return Objects.equals(this.error, other.error)
            && Objects.equals(this.explanation, other.explanation)
            && this.index.equals(other.index)
            && this.valid == other.valid;
    }
}
