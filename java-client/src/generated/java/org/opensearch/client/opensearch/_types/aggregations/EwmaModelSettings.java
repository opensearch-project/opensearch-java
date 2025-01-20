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

// typedef: _types.aggregations.EwmaModelSettings

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class EwmaModelSettings implements PlainJsonSerializable, ToCopyableBuilder<EwmaModelSettings.Builder, EwmaModelSettings> {

    @Nullable
    private final Float alpha;

    // ---------------------------------------------------------------------------------------------

    private EwmaModelSettings(Builder builder) {
        this.alpha = builder.alpha;
    }

    public static EwmaModelSettings of(Function<EwmaModelSettings.Builder, ObjectBuilder<EwmaModelSettings>> fn) {
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
     * Builder for {@link EwmaModelSettings}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, EwmaModelSettings> {
        @Nullable
        private Float alpha;

        public Builder() {}

        private Builder(EwmaModelSettings o) {
            this.alpha = o.alpha;
        }

        private Builder(Builder o) {
            this.alpha = o.alpha;
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
         * Builds a {@link EwmaModelSettings}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public EwmaModelSettings build() {
            _checkSingleUse();

            return new EwmaModelSettings(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link EwmaModelSettings}
     */
    public static final JsonpDeserializer<EwmaModelSettings> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        EwmaModelSettings::setupEwmaModelSettingsDeserializer
    );

    protected static void setupEwmaModelSettingsDeserializer(ObjectDeserializer<EwmaModelSettings.Builder> op) {
        op.add(Builder::alpha, JsonpDeserializer.floatDeserializer(), "alpha");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.alpha);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        EwmaModelSettings other = (EwmaModelSettings) o;
        return Objects.equals(this.alpha, other.alpha);
    }
}
