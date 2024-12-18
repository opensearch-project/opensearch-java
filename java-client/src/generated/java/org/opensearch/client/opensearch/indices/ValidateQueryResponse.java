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
import java.util.List;
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
import org.opensearch.client.opensearch._types.ShardStatistics;
import org.opensearch.client.opensearch.indices.validate_query.IndicesValidationExplanation;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.validate_query.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ValidateQueryResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ValidateQueryResponse.Builder, ValidateQueryResponse> {

    @Nullable
    private final String error;

    @Nonnull
    private final List<IndicesValidationExplanation> explanations;

    @Nullable
    private final ShardStatistics shards;

    private final boolean valid;

    // ---------------------------------------------------------------------------------------------

    private ValidateQueryResponse(Builder builder) {
        this.error = builder.error;
        this.explanations = ApiTypeHelper.unmodifiable(builder.explanations);
        this.shards = builder.shards;
        this.valid = ApiTypeHelper.requireNonNull(builder.valid, this, "valid");
    }

    public static ValidateQueryResponse of(Function<ValidateQueryResponse.Builder, ObjectBuilder<ValidateQueryResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code error}
     */
    @Nullable
    public final String error() {
        return this.error;
    }

    /**
     * API name: {@code explanations}
     */
    @Nonnull
    public final List<IndicesValidationExplanation> explanations() {
        return this.explanations;
    }

    /**
     * API name: {@code _shards}
     */
    @Nullable
    public final ShardStatistics shards() {
        return this.shards;
    }

    /**
     * Required - API name: {@code valid}
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

        if (ApiTypeHelper.isDefined(this.explanations)) {
            generator.writeKey("explanations");
            generator.writeStartArray();
            for (IndicesValidationExplanation item0 : this.explanations) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.shards != null) {
            generator.writeKey("_shards");
            this.shards.serialize(generator, mapper);
        }

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
     * Builder for {@link ValidateQueryResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ValidateQueryResponse> {
        @Nullable
        private String error;
        @Nullable
        private List<IndicesValidationExplanation> explanations;
        @Nullable
        private ShardStatistics shards;
        private Boolean valid;

        public Builder() {}

        private Builder(ValidateQueryResponse o) {
            this.error = o.error;
            this.explanations = _listCopy(o.explanations);
            this.shards = o.shards;
            this.valid = o.valid;
        }

        private Builder(Builder o) {
            this.error = o.error;
            this.explanations = _listCopy(o.explanations);
            this.shards = o.shards;
            this.valid = o.valid;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code error}
         */
        @Nonnull
        public final Builder error(@Nullable String value) {
            this.error = value;
            return this;
        }

        /**
         * API name: {@code explanations}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>explanations</code>.
         * </p>
         */
        @Nonnull
        public final Builder explanations(List<IndicesValidationExplanation> list) {
            this.explanations = _listAddAll(this.explanations, list);
            return this;
        }

        /**
         * API name: {@code explanations}
         *
         * <p>
         * Adds one or more values to <code>explanations</code>.
         * </p>
         */
        @Nonnull
        public final Builder explanations(IndicesValidationExplanation value, IndicesValidationExplanation... values) {
            this.explanations = _listAdd(this.explanations, value, values);
            return this;
        }

        /**
         * API name: {@code explanations}
         *
         * <p>
         * Adds a value to <code>explanations</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder explanations(Function<IndicesValidationExplanation.Builder, ObjectBuilder<IndicesValidationExplanation>> fn) {
            return explanations(fn.apply(new IndicesValidationExplanation.Builder()).build());
        }

        /**
         * API name: {@code _shards}
         */
        @Nonnull
        public final Builder shards(@Nullable ShardStatistics value) {
            this.shards = value;
            return this;
        }

        /**
         * API name: {@code _shards}
         */
        @Nonnull
        public final Builder shards(Function<ShardStatistics.Builder, ObjectBuilder<ShardStatistics>> fn) {
            return shards(fn.apply(new ShardStatistics.Builder()).build());
        }

        /**
         * Required - API name: {@code valid}
         */
        @Nonnull
        public final Builder valid(boolean value) {
            this.valid = value;
            return this;
        }

        /**
         * Builds a {@link ValidateQueryResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ValidateQueryResponse build() {
            _checkSingleUse();

            return new ValidateQueryResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ValidateQueryResponse}
     */
    public static final JsonpDeserializer<ValidateQueryResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ValidateQueryResponse::setupValidateQueryResponseDeserializer
    );

    protected static void setupValidateQueryResponseDeserializer(ObjectDeserializer<ValidateQueryResponse.Builder> op) {
        op.add(Builder::error, JsonpDeserializer.stringDeserializer(), "error");
        op.add(Builder::explanations, JsonpDeserializer.arrayDeserializer(IndicesValidationExplanation._DESERIALIZER), "explanations");
        op.add(Builder::shards, ShardStatistics._DESERIALIZER, "_shards");
        op.add(Builder::valid, JsonpDeserializer.booleanDeserializer(), "valid");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.error);
        result = 31 * result + Objects.hashCode(this.explanations);
        result = 31 * result + Objects.hashCode(this.shards);
        result = 31 * result + Boolean.hashCode(this.valid);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ValidateQueryResponse other = (ValidateQueryResponse) o;
        return Objects.equals(this.error, other.error)
            && Objects.equals(this.explanations, other.explanations)
            && Objects.equals(this.shards, other.shards)
            && this.valid == other.valid;
    }
}
