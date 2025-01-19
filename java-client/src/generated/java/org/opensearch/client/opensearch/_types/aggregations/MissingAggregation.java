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

package org.opensearch.client.opensearch._types.aggregations;

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
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.MissingAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MissingAggregation extends BucketAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<MissingAggregation.Builder, MissingAggregation> {

    @Nullable
    private final String field;

    @Nullable
    private final FieldValue missing;

    // ---------------------------------------------------------------------------------------------

    private MissingAggregation(Builder builder) {
        super(builder);
        this.field = builder.field;
        this.missing = builder.missing;
    }

    public static MissingAggregation of(Function<MissingAggregation.Builder, ObjectBuilder<MissingAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.Missing;
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code missing}
     */
    @Nullable
    public final FieldValue missing() {
        return this.missing;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (this.missing != null) {
            generator.writeKey("missing");
            this.missing.serialize(generator, mapper);
        }
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
     * Builder for {@link MissingAggregation}.
     */
    public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, MissingAggregation> {
        @Nullable
        private String field;
        @Nullable
        private FieldValue missing;

        public Builder() {}

        private Builder(MissingAggregation o) {
            super(o);
            this.field = o.field;
            this.missing = o.missing;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.missing = o.missing;
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
         * API name: {@code field}
         */
        @Nonnull
        public final Builder field(@Nullable String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code missing}
         */
        @Nonnull
        public final Builder missing(@Nullable FieldValue value) {
            this.missing = value;
            return this;
        }

        /**
         * API name: {@code missing}
         */
        @Nonnull
        public final Builder missing(Function<FieldValue.Builder, ObjectBuilder<FieldValue>> fn) {
            return missing(fn.apply(new FieldValue.Builder()).build());
        }

        /**
         * Builds a {@link MissingAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MissingAggregation build() {
            _checkSingleUse();

            return new MissingAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MissingAggregation}
     */
    public static final JsonpDeserializer<MissingAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MissingAggregation::setupMissingAggregationDeserializer
    );

    protected static void setupMissingAggregationDeserializer(ObjectDeserializer<MissingAggregation.Builder> op) {
        setupBucketAggregationBaseDeserializer(op);
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::missing, FieldValue._DESERIALIZER, "missing");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.missing);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MissingAggregation other = (MissingAggregation) o;
        return Objects.equals(this.field, other.field) && Objects.equals(this.missing, other.missing);
    }
}
