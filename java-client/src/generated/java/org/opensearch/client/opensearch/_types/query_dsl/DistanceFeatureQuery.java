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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.DistanceFeatureQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DistanceFeatureQuery extends QueryBase
    implements
        QueryVariant,
        ToCopyableBuilder<DistanceFeatureQuery.Builder, DistanceFeatureQuery> {

    @Nonnull
    private final String field;

    @Nonnull
    private final JsonData origin;

    @Nonnull
    private final JsonData pivot;

    // ---------------------------------------------------------------------------------------------

    private DistanceFeatureQuery(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.origin = ApiTypeHelper.requireNonNull(builder.origin, this, "origin");
        this.pivot = ApiTypeHelper.requireNonNull(builder.pivot, this, "pivot");
    }

    public static DistanceFeatureQuery of(Function<DistanceFeatureQuery.Builder, ObjectBuilder<DistanceFeatureQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.DistanceFeature;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * Required - API name: {@code origin}
     */
    @Nonnull
    public final JsonData origin() {
        return this.origin;
    }

    /**
     * Required - API name: {@code pivot}
     */
    @Nonnull
    public final JsonData pivot() {
        return this.pivot;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("field");
        generator.write(this.field);

        generator.writeKey("origin");
        this.origin.serialize(generator, mapper);

        generator.writeKey("pivot");
        this.pivot.serialize(generator, mapper);
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
     * Builder for {@link DistanceFeatureQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DistanceFeatureQuery> {
        private String field;
        private JsonData origin;
        private JsonData pivot;

        public Builder() {}

        private Builder(DistanceFeatureQuery o) {
            super(o);
            this.field = o.field;
            this.origin = o.origin;
            this.pivot = o.pivot;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.origin = o.origin;
            this.pivot = o.pivot;
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
         * Required - API name: {@code field}
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * Required - API name: {@code origin}
         */
        @Nonnull
        public final Builder origin(JsonData value) {
            this.origin = value;
            return this;
        }

        /**
         * Required - API name: {@code pivot}
         */
        @Nonnull
        public final Builder pivot(JsonData value) {
            this.pivot = value;
            return this;
        }

        /**
         * Builds a {@link DistanceFeatureQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DistanceFeatureQuery build() {
            _checkSingleUse();

            return new DistanceFeatureQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DistanceFeatureQuery}
     */
    public static final JsonpDeserializer<DistanceFeatureQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DistanceFeatureQuery::setupDistanceFeatureQueryDeserializer
    );

    protected static void setupDistanceFeatureQueryDeserializer(ObjectDeserializer<DistanceFeatureQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::origin, JsonData._DESERIALIZER, "origin");
        op.add(Builder::pivot, JsonData._DESERIALIZER, "pivot");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + this.origin.hashCode();
        result = 31 * result + this.pivot.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DistanceFeatureQuery other = (DistanceFeatureQuery) o;
        return this.field.equals(other.field) && this.origin.equals(other.origin) && this.pivot.equals(other.pivot);
    }
}
