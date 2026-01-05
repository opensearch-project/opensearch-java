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
import org.opensearch.client.json.JsonData;
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

// typedef: _types.query_dsl.DecayPlacement

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DecayPlacement implements PlainJsonSerializable, ToCopyableBuilder<DecayPlacement.Builder, DecayPlacement> {

    @Nullable
    private final Double decay;

    @Nullable
    private final JsonData offset;

    @Nullable
    private final JsonData origin;

    @Nonnull
    private final JsonData scale;

    // ---------------------------------------------------------------------------------------------

    private DecayPlacement(Builder builder) {
        this.decay = builder.decay;
        this.offset = builder.offset;
        this.origin = builder.origin;
        this.scale = ApiTypeHelper.requireNonNull(builder.scale, this, "scale");
    }

    public static DecayPlacement of(Function<DecayPlacement.Builder, ObjectBuilder<DecayPlacement>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code decay}
     */
    @Nullable
    public final Double decay() {
        return this.decay;
    }

    /**
     * API name: {@code offset}
     */
    @Nullable
    public final JsonData offset() {
        return this.offset;
    }

    /**
     * API name: {@code origin}
     */
    @Nullable
    public final JsonData origin() {
        return this.origin;
    }

    /**
     * Required - API name: {@code scale}
     */
    @Nonnull
    public final JsonData scale() {
        return this.scale;
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
        if (this.decay != null) {
            generator.writeKey("decay");
            generator.write(this.decay);
        }

        if (this.offset != null) {
            generator.writeKey("offset");
            this.offset.serialize(generator, mapper);
        }

        if (this.origin != null) {
            generator.writeKey("origin");
            this.origin.serialize(generator, mapper);
        }

        generator.writeKey("scale");
        this.scale.serialize(generator, mapper);
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
     * Builder for {@link DecayPlacement}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DecayPlacement> {
        @Nullable
        private Double decay;
        @Nullable
        private JsonData offset;
        @Nullable
        private JsonData origin;
        private JsonData scale;

        public Builder() {}

        private Builder(DecayPlacement o) {
            this.decay = o.decay;
            this.offset = o.offset;
            this.origin = o.origin;
            this.scale = o.scale;
        }

        private Builder(Builder o) {
            this.decay = o.decay;
            this.offset = o.offset;
            this.origin = o.origin;
            this.scale = o.scale;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code decay}
         */
        @Nonnull
        public final Builder decay(@Nullable Double value) {
            this.decay = value;
            return this;
        }

        /**
         * API name: {@code offset}
         */
        @Nonnull
        public final Builder offset(@Nullable JsonData value) {
            this.offset = value;
            return this;
        }

        /**
         * API name: {@code origin}
         */
        @Nonnull
        public final Builder origin(@Nullable JsonData value) {
            this.origin = value;
            return this;
        }

        /**
         * Required - API name: {@code scale}
         */
        @Nonnull
        public final Builder scale(JsonData value) {
            this.scale = value;
            return this;
        }

        /**
         * Builds a {@link DecayPlacement}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DecayPlacement build() {
            _checkSingleUse();

            return new DecayPlacement(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DecayPlacement}
     */
    public static final JsonpDeserializer<DecayPlacement> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DecayPlacement::setupDecayPlacementDeserializer
    );

    protected static void setupDecayPlacementDeserializer(ObjectDeserializer<DecayPlacement.Builder> op) {
        op.add(Builder::decay, JsonpDeserializer.doubleDeserializer(), "decay");
        op.add(Builder::offset, JsonData._DESERIALIZER, "offset");
        op.add(Builder::origin, JsonData._DESERIALIZER, "origin");
        op.add(Builder::scale, JsonData._DESERIALIZER, "scale");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.decay);
        result = 31 * result + Objects.hashCode(this.offset);
        result = 31 * result + Objects.hashCode(this.origin);
        result = 31 * result + this.scale.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DecayPlacement other = (DecayPlacement) o;
        return Objects.equals(this.decay, other.decay)
            && Objects.equals(this.offset, other.offset)
            && Objects.equals(this.origin, other.origin)
            && this.scale.equals(other.scale);
    }
}
