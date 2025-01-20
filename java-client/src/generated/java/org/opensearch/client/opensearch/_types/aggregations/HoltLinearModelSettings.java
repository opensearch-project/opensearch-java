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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.HoltLinearModelSettings

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class HoltLinearModelSettings
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<HoltLinearModelSettings.Builder, HoltLinearModelSettings> {

    @Nullable
    private final Float alpha;

    @Nullable
    private final Float beta;

    // ---------------------------------------------------------------------------------------------

    private HoltLinearModelSettings(Builder builder) {
        this.alpha = builder.alpha;
        this.beta = builder.beta;
    }

    public static HoltLinearModelSettings of(Function<HoltLinearModelSettings.Builder, ObjectBuilder<HoltLinearModelSettings>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code alpha}
     */
    @Nullable
    public final Float alpha() {
        return this.alpha;
    }

    /**
     * API name: {@code beta}
     */
    @Nullable
    public final Float beta() {
        return this.beta;
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
        if (this.alpha != null) {
            generator.writeKey("alpha");
            generator.write(this.alpha);
        }

        if (this.beta != null) {
            generator.writeKey("beta");
            generator.write(this.beta);
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
     * Builder for {@link HoltLinearModelSettings}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, HoltLinearModelSettings> {
        @Nullable
        private Float alpha;
        @Nullable
        private Float beta;

        public Builder() {}

        private Builder(HoltLinearModelSettings o) {
            this.alpha = o.alpha;
            this.beta = o.beta;
        }

        private Builder(Builder o) {
            this.alpha = o.alpha;
            this.beta = o.beta;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code alpha}
         */
        @Nonnull
        public final Builder alpha(@Nullable Float value) {
            this.alpha = value;
            return this;
        }

        /**
         * API name: {@code beta}
         */
        @Nonnull
        public final Builder beta(@Nullable Float value) {
            this.beta = value;
            return this;
        }

        /**
         * Builds a {@link HoltLinearModelSettings}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public HoltLinearModelSettings build() {
            _checkSingleUse();

            return new HoltLinearModelSettings(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link HoltLinearModelSettings}
     */
    public static final JsonpDeserializer<HoltLinearModelSettings> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        HoltLinearModelSettings::setupHoltLinearModelSettingsDeserializer
    );

    protected static void setupHoltLinearModelSettingsDeserializer(ObjectDeserializer<HoltLinearModelSettings.Builder> op) {
        op.add(Builder::alpha, JsonpDeserializer.floatDeserializer(), "alpha");
        op.add(Builder::beta, JsonpDeserializer.floatDeserializer(), "beta");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.alpha);
        result = 31 * result + Objects.hashCode(this.beta);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HoltLinearModelSettings other = (HoltLinearModelSettings) o;
        return Objects.equals(this.alpha, other.alpha) && Objects.equals(this.beta, other.beta);
    }
}
