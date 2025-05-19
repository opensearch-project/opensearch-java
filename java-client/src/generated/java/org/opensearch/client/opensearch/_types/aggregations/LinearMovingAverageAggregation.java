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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.EmptyObject;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.LinearMovingAverageAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class LinearMovingAverageAggregation extends MovingAverageAggregationBase
    implements
        MovingAverageAggregationVariant,
        ToCopyableBuilder<LinearMovingAverageAggregation.Builder, LinearMovingAverageAggregation> {

    @Nonnull
    private final EmptyObject settings;

    // ---------------------------------------------------------------------------------------------

    private LinearMovingAverageAggregation(Builder builder) {
        super(builder);
        this.settings = ApiTypeHelper.requireNonNull(builder.settings, this, "settings");
    }

    public static LinearMovingAverageAggregation of(
        Function<LinearMovingAverageAggregation.Builder, ObjectBuilder<LinearMovingAverageAggregation>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link MovingAverageAggregation} variant kind.
     */
    @Override
    public MovingAverageAggregation.Kind _movingAverageAggregationKind() {
        return MovingAverageAggregation.Kind.Linear;
    }

    /**
     * Required - API name: {@code settings}
     */
    @Nonnull
    public final EmptyObject settings() {
        return this.settings;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("model", "linear");
        super.serializeInternal(generator, mapper);
        generator.writeKey("settings");
        this.settings.serialize(generator, mapper);
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
     * Builder for {@link LinearMovingAverageAggregation}.
     */
    public static class Builder extends MovingAverageAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, LinearMovingAverageAggregation> {
        private EmptyObject settings;

        public Builder() {}

        private Builder(LinearMovingAverageAggregation o) {
            super(o);
            this.settings = o.settings;
        }

        private Builder(Builder o) {
            super(o);
            this.settings = o.settings;
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
         * Required - API name: {@code settings}
         */
        @Nonnull
        public final Builder settings(EmptyObject value) {
            this.settings = value;
            return this;
        }

        /**
         * Required - API name: {@code settings}
         */
        @Nonnull
        public final Builder settings(Function<EmptyObject.Builder, ObjectBuilder<EmptyObject>> fn) {
            return settings(fn.apply(new EmptyObject.Builder()).build());
        }

        /**
         * Builds a {@link LinearMovingAverageAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public LinearMovingAverageAggregation build() {
            _checkSingleUse();

            return new LinearMovingAverageAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link LinearMovingAverageAggregation}
     */
    public static final JsonpDeserializer<LinearMovingAverageAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        LinearMovingAverageAggregation::setupLinearMovingAverageAggregationDeserializer
    );

    protected static void setupLinearMovingAverageAggregationDeserializer(ObjectDeserializer<LinearMovingAverageAggregation.Builder> op) {
        setupMovingAverageAggregationBaseDeserializer(op);
        op.add(Builder::settings, EmptyObject._DESERIALIZER, "settings");

        op.ignore("model");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.settings.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LinearMovingAverageAggregation other = (LinearMovingAverageAggregation) o;
        return this.settings.equals(other.settings);
    }
}
