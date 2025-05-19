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

// typedef: _types.aggregations.HoltWintersModelSettings

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class HoltWintersModelSettings
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<HoltWintersModelSettings.Builder, HoltWintersModelSettings> {

    @Nullable
    private final Float alpha;

    @Nullable
    private final Float beta;

    @Nullable
    private final Float gamma;

    @Nullable
    private final Boolean pad;

    @Nullable
    private final Integer period;

    @Nullable
    private final HoltWintersType type;

    // ---------------------------------------------------------------------------------------------

    private HoltWintersModelSettings(Builder builder) {
        this.alpha = builder.alpha;
        this.beta = builder.beta;
        this.gamma = builder.gamma;
        this.pad = builder.pad;
        this.period = builder.period;
        this.type = builder.type;
    }

    public static HoltWintersModelSettings of(Function<HoltWintersModelSettings.Builder, ObjectBuilder<HoltWintersModelSettings>> fn) {
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
     * API name: {@code gamma}
     */
    @Nullable
    public final Float gamma() {
        return this.gamma;
    }

    /**
     * API name: {@code pad}
     */
    @Nullable
    public final Boolean pad() {
        return this.pad;
    }

    /**
     * API name: {@code period}
     */
    @Nullable
    public final Integer period() {
        return this.period;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final HoltWintersType type() {
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
        if (this.alpha != null) {
            generator.writeKey("alpha");
            generator.write(this.alpha);
        }

        if (this.beta != null) {
            generator.writeKey("beta");
            generator.write(this.beta);
        }

        if (this.gamma != null) {
            generator.writeKey("gamma");
            generator.write(this.gamma);
        }

        if (this.pad != null) {
            generator.writeKey("pad");
            generator.write(this.pad);
        }

        if (this.period != null) {
            generator.writeKey("period");
            generator.write(this.period);
        }

        if (this.type != null) {
            generator.writeKey("type");
            this.type.serialize(generator, mapper);
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
     * Builder for {@link HoltWintersModelSettings}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, HoltWintersModelSettings> {
        @Nullable
        private Float alpha;
        @Nullable
        private Float beta;
        @Nullable
        private Float gamma;
        @Nullable
        private Boolean pad;
        @Nullable
        private Integer period;
        @Nullable
        private HoltWintersType type;

        public Builder() {}

        private Builder(HoltWintersModelSettings o) {
            this.alpha = o.alpha;
            this.beta = o.beta;
            this.gamma = o.gamma;
            this.pad = o.pad;
            this.period = o.period;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.alpha = o.alpha;
            this.beta = o.beta;
            this.gamma = o.gamma;
            this.pad = o.pad;
            this.period = o.period;
            this.type = o.type;
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
         * API name: {@code gamma}
         */
        @Nonnull
        public final Builder gamma(@Nullable Float value) {
            this.gamma = value;
            return this;
        }

        /**
         * API name: {@code pad}
         */
        @Nonnull
        public final Builder pad(@Nullable Boolean value) {
            this.pad = value;
            return this;
        }

        /**
         * API name: {@code period}
         */
        @Nonnull
        public final Builder period(@Nullable Integer value) {
            this.period = value;
            return this;
        }

        /**
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable HoltWintersType value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link HoltWintersModelSettings}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public HoltWintersModelSettings build() {
            _checkSingleUse();

            return new HoltWintersModelSettings(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link HoltWintersModelSettings}
     */
    public static final JsonpDeserializer<HoltWintersModelSettings> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        HoltWintersModelSettings::setupHoltWintersModelSettingsDeserializer
    );

    protected static void setupHoltWintersModelSettingsDeserializer(ObjectDeserializer<HoltWintersModelSettings.Builder> op) {
        op.add(Builder::alpha, JsonpDeserializer.floatDeserializer(), "alpha");
        op.add(Builder::beta, JsonpDeserializer.floatDeserializer(), "beta");
        op.add(Builder::gamma, JsonpDeserializer.floatDeserializer(), "gamma");
        op.add(Builder::pad, JsonpDeserializer.booleanDeserializer(), "pad");
        op.add(Builder::period, JsonpDeserializer.integerDeserializer(), "period");
        op.add(Builder::type, HoltWintersType._DESERIALIZER, "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.alpha);
        result = 31 * result + Objects.hashCode(this.beta);
        result = 31 * result + Objects.hashCode(this.gamma);
        result = 31 * result + Objects.hashCode(this.pad);
        result = 31 * result + Objects.hashCode(this.period);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HoltWintersModelSettings other = (HoltWintersModelSettings) o;
        return Objects.equals(this.alpha, other.alpha)
            && Objects.equals(this.beta, other.beta)
            && Objects.equals(this.gamma, other.gamma)
            && Objects.equals(this.pad, other.pad)
            && Objects.equals(this.period, other.period)
            && Objects.equals(this.type, other.type);
    }
}
