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

package org.opensearch.client.opensearch.nodes.stats;

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

// typedef: nodes.stats.NativeMemoryAnalyticsBackend

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NativeMemoryAnalyticsBackend
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NativeMemoryAnalyticsBackend.Builder, NativeMemoryAnalyticsBackend> {

    @Nullable
    private final Long allocatedBytes;

    @Nullable
    private final Long residentBytes;

    // ---------------------------------------------------------------------------------------------

    private NativeMemoryAnalyticsBackend(Builder builder) {
        this.allocatedBytes = builder.allocatedBytes;
        this.residentBytes = builder.residentBytes;
    }

    public static NativeMemoryAnalyticsBackend of(
        Function<NativeMemoryAnalyticsBackend.Builder, ObjectBuilder<NativeMemoryAnalyticsBackend>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code allocated_bytes}
     */
    @Nullable
    public final Long allocatedBytes() {
        return this.allocatedBytes;
    }

    /**
     * API name: {@code resident_bytes}
     */
    @Nullable
    public final Long residentBytes() {
        return this.residentBytes;
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
        if (this.allocatedBytes != null) {
            generator.writeKey("allocated_bytes");
            generator.write(this.allocatedBytes);
        }

        if (this.residentBytes != null) {
            generator.writeKey("resident_bytes");
            generator.write(this.residentBytes);
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
     * Builder for {@link NativeMemoryAnalyticsBackend}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NativeMemoryAnalyticsBackend> {
        @Nullable
        private Long allocatedBytes;
        @Nullable
        private Long residentBytes;

        public Builder() {}

        private Builder(NativeMemoryAnalyticsBackend o) {
            this.allocatedBytes = o.allocatedBytes;
            this.residentBytes = o.residentBytes;
        }

        private Builder(Builder o) {
            this.allocatedBytes = o.allocatedBytes;
            this.residentBytes = o.residentBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code allocated_bytes}
         */
        @Nonnull
        public final Builder allocatedBytes(@Nullable Long value) {
            this.allocatedBytes = value;
            return this;
        }

        /**
         * API name: {@code resident_bytes}
         */
        @Nonnull
        public final Builder residentBytes(@Nullable Long value) {
            this.residentBytes = value;
            return this;
        }

        /**
         * Builds a {@link NativeMemoryAnalyticsBackend}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NativeMemoryAnalyticsBackend build() {
            _checkSingleUse();

            return new NativeMemoryAnalyticsBackend(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NativeMemoryAnalyticsBackend}
     */
    public static final JsonpDeserializer<NativeMemoryAnalyticsBackend> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NativeMemoryAnalyticsBackend::setupNativeMemoryAnalyticsBackendDeserializer
    );

    protected static void setupNativeMemoryAnalyticsBackendDeserializer(ObjectDeserializer<NativeMemoryAnalyticsBackend.Builder> op) {
        op.add(Builder::allocatedBytes, JsonpDeserializer.longDeserializer(), "allocated_bytes");
        op.add(Builder::residentBytes, JsonpDeserializer.longDeserializer(), "resident_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allocatedBytes);
        result = 31 * result + Objects.hashCode(this.residentBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NativeMemoryAnalyticsBackend other = (NativeMemoryAnalyticsBackend) o;
        return Objects.equals(this.allocatedBytes, other.allocatedBytes) && Objects.equals(this.residentBytes, other.residentBytes);
    }
}
