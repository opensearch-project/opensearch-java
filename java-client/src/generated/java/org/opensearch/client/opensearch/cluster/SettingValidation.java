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

package org.opensearch.client.opensearch.cluster;

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

// typedef: cluster.SettingValidation

/**
 * The declared value type and bounds of a setting. Present only for settings defined with a typed parser; string, list, and enumerated
 * settings have no validation object.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SettingValidation implements PlainJsonSerializable, ToCopyableBuilder<SettingValidation.Builder, SettingValidation> {

    @Nullable
    private final String max;

    @Nullable
    private final String min;

    @Nonnull
    private final SettingValueType type;

    // ---------------------------------------------------------------------------------------------

    private SettingValidation(Builder builder) {
        this.max = builder.max;
        this.min = builder.min;
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static SettingValidation of(Function<SettingValidation.Builder, ObjectBuilder<SettingValidation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The largest accepted value, in the same string form as <code>default</code>. Omitted when the definition places no upper bound on the
     * value.
     * <p>
     * API name: {@code max}
     * </p>
     */
    @Nullable
    public final String max() {
        return this.max;
    }

    /**
     * The smallest accepted value, in the same string form as <code>default</code>. Omitted when the definition places no lower bound on
     * the value.
     * <p>
     * API name: {@code min}
     * </p>
     */
    @Nullable
    public final String min() {
        return this.min;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final SettingValueType type() {
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
        if (this.max != null) {
            generator.writeKey("max");
            generator.write(this.max);
        }

        if (this.min != null) {
            generator.writeKey("min");
            generator.write(this.min);
        }

        generator.writeKey("type");
        this.type.serialize(generator, mapper);
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
     * Builder for {@link SettingValidation}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SettingValidation> {
        @Nullable
        private String max;
        @Nullable
        private String min;
        private SettingValueType type;

        public Builder() {}

        private Builder(SettingValidation o) {
            this.max = o.max;
            this.min = o.min;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.max = o.max;
            this.min = o.min;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The largest accepted value, in the same string form as <code>default</code>. Omitted when the definition places no upper bound on
         * the value.
         * <p>
         * API name: {@code max}
         * </p>
         */
        @Nonnull
        public final Builder max(@Nullable String value) {
            this.max = value;
            return this;
        }

        /**
         * The smallest accepted value, in the same string form as <code>default</code>. Omitted when the definition places no lower bound
         * on the value.
         * <p>
         * API name: {@code min}
         * </p>
         */
        @Nonnull
        public final Builder min(@Nullable String value) {
            this.min = value;
            return this;
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(SettingValueType value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link SettingValidation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SettingValidation build() {
            _checkSingleUse();

            return new SettingValidation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SettingValidation}
     */
    public static final JsonpDeserializer<SettingValidation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SettingValidation::setupSettingValidationDeserializer
    );

    protected static void setupSettingValidationDeserializer(ObjectDeserializer<SettingValidation.Builder> op) {
        op.add(Builder::max, JsonpDeserializer.stringDeserializer(), "max");
        op.add(Builder::min, JsonpDeserializer.stringDeserializer(), "min");
        op.add(Builder::type, SettingValueType._DESERIALIZER, "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.max);
        result = 31 * result + Objects.hashCode(this.min);
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SettingValidation other = (SettingValidation) o;
        return Objects.equals(this.max, other.max) && Objects.equals(this.min, other.min) && this.type.equals(other.type);
    }
}
