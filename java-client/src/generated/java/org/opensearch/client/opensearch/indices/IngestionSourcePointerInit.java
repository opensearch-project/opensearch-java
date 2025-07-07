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

// typedef: indices.IngestionSourcePointerInit

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IngestionSourcePointerInit
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IngestionSourcePointerInit.Builder, IngestionSourcePointerInit> {

    @Nullable
    private final IngestionSourcePointerInitReset reset;

    @Nullable
    private final String resetValue;

    // ---------------------------------------------------------------------------------------------

    private IngestionSourcePointerInit(Builder builder) {
        this.reset = builder.reset;
        this.resetValue = builder.resetValue;
    }

    public static IngestionSourcePointerInit of(
        Function<IngestionSourcePointerInit.Builder, ObjectBuilder<IngestionSourcePointerInit>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code reset}
     */
    @Nullable
    public final IngestionSourcePointerInitReset reset() {
        return this.reset;
    }

    /**
     * Specifies the offset value or timestamp in milliseconds.
     * <p>
     * API name: {@code reset.value}
     * </p>
     */
    @Nullable
    public final String resetValue() {
        return this.resetValue;
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
        if (this.reset != null) {
            generator.writeKey("reset");
            this.reset.serialize(generator, mapper);
        }

        if (this.resetValue != null) {
            generator.writeKey("reset.value");
            generator.write(this.resetValue);
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
     * Builder for {@link IngestionSourcePointerInit}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IngestionSourcePointerInit> {
        @Nullable
        private IngestionSourcePointerInitReset reset;
        @Nullable
        private String resetValue;

        public Builder() {}

        private Builder(IngestionSourcePointerInit o) {
            this.reset = o.reset;
            this.resetValue = o.resetValue;
        }

        private Builder(Builder o) {
            this.reset = o.reset;
            this.resetValue = o.resetValue;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code reset}
         */
        @Nonnull
        public final Builder reset(@Nullable IngestionSourcePointerInitReset value) {
            this.reset = value;
            return this;
        }

        /**
         * Specifies the offset value or timestamp in milliseconds.
         * <p>
         * API name: {@code reset.value}
         * </p>
         */
        @Nonnull
        public final Builder resetValue(@Nullable String value) {
            this.resetValue = value;
            return this;
        }

        /**
         * Builds a {@link IngestionSourcePointerInit}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IngestionSourcePointerInit build() {
            _checkSingleUse();

            return new IngestionSourcePointerInit(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IngestionSourcePointerInit}
     */
    public static final JsonpDeserializer<IngestionSourcePointerInit> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IngestionSourcePointerInit::setupIngestionSourcePointerInitDeserializer
    );

    protected static void setupIngestionSourcePointerInitDeserializer(ObjectDeserializer<IngestionSourcePointerInit.Builder> op) {
        op.add(Builder::reset, IngestionSourcePointerInitReset._DESERIALIZER, "reset");
        op.add(Builder::resetValue, JsonpDeserializer.stringDeserializer(), "reset.value");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.reset);
        result = 31 * result + Objects.hashCode(this.resetValue);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IngestionSourcePointerInit other = (IngestionSourcePointerInit) o;
        return Objects.equals(this.reset, other.reset) && Objects.equals(this.resetValue, other.resetValue);
    }
}
