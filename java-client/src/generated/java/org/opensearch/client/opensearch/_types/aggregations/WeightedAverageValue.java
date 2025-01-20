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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.WeightedAverageValue

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class WeightedAverageValue implements PlainJsonSerializable, ToCopyableBuilder<WeightedAverageValue.Builder, WeightedAverageValue> {

    @Nullable
    private final String field;

    @Nullable
    private final Double missing;

    @Nullable
    private final Script script;

    // ---------------------------------------------------------------------------------------------

    private WeightedAverageValue(Builder builder) {
        this.field = builder.field;
        this.missing = builder.missing;
        this.script = builder.script;
    }

    public static WeightedAverageValue of(Function<WeightedAverageValue.Builder, ObjectBuilder<WeightedAverageValue>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * A value or weight to use if the field is missing.
     * <p>
     * API name: {@code missing}
     * </p>
     */
    @Nullable
    public final Double missing() {
        return this.missing;
    }

    /**
     * API name: {@code script}
     */
    @Nullable
    public final Script script() {
        return this.script;
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
        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (this.missing != null) {
            generator.writeKey("missing");
            generator.write(this.missing);
        }

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);
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
     * Builder for {@link WeightedAverageValue}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, WeightedAverageValue> {
        @Nullable
        private String field;
        @Nullable
        private Double missing;
        @Nullable
        private Script script;

        public Builder() {}

        private Builder(WeightedAverageValue o) {
            this.field = o.field;
            this.missing = o.missing;
            this.script = o.script;
        }

        private Builder(Builder o) {
            this.field = o.field;
            this.missing = o.missing;
            this.script = o.script;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
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
         * A value or weight to use if the field is missing.
         * <p>
         * API name: {@code missing}
         * </p>
         */
        @Nonnull
        public final Builder missing(@Nullable Double value) {
            this.missing = value;
            return this;
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(@Nullable Script value) {
            this.script = value;
            return this;
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return script(fn.apply(new Script.Builder()).build());
        }

        /**
         * Builds a {@link WeightedAverageValue}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public WeightedAverageValue build() {
            _checkSingleUse();

            return new WeightedAverageValue(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link WeightedAverageValue}
     */
    public static final JsonpDeserializer<WeightedAverageValue> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        WeightedAverageValue::setupWeightedAverageValueDeserializer
    );

    protected static void setupWeightedAverageValueDeserializer(ObjectDeserializer<WeightedAverageValue.Builder> op) {
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::missing, JsonpDeserializer.doubleDeserializer(), "missing");
        op.add(Builder::script, Script._DESERIALIZER, "script");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.missing);
        result = 31 * result + Objects.hashCode(this.script);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        WeightedAverageValue other = (WeightedAverageValue) o;
        return Objects.equals(this.field, other.field)
            && Objects.equals(this.missing, other.missing)
            && Objects.equals(this.script, other.script);
    }
}
