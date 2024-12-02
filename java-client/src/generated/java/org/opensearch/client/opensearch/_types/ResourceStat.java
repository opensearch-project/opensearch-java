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

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: _types.ResourceStat

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ResourceStat implements PlainJsonSerializable, ToCopyableBuilder<ResourceStat.Builder, ResourceStat> {

    private final long cpuTimeInNanos;

    private final long memoryInBytes;

    // ---------------------------------------------------------------------------------------------

    private ResourceStat(Builder builder) {
        this.cpuTimeInNanos = ApiTypeHelper.requireNonNull(builder.cpuTimeInNanos, this, "cpuTimeInNanos");
        this.memoryInBytes = ApiTypeHelper.requireNonNull(builder.memoryInBytes, this, "memoryInBytes");
    }

    public static ResourceStat of(Function<ResourceStat.Builder, ObjectBuilder<ResourceStat>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code cpu_time_in_nanos}
     */
    public final long cpuTimeInNanos() {
        return this.cpuTimeInNanos;
    }

    /**
     * Required - API name: {@code memory_in_bytes}
     */
    public final long memoryInBytes() {
        return this.memoryInBytes;
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
        generator.writeKey("cpu_time_in_nanos");
        generator.write(this.cpuTimeInNanos);

        generator.writeKey("memory_in_bytes");
        generator.write(this.memoryInBytes);
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
     * Builder for {@link ResourceStat}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ResourceStat> {
        private Long cpuTimeInNanos;
        private Long memoryInBytes;

        public Builder() {}

        private Builder(ResourceStat o) {
            this.cpuTimeInNanos = o.cpuTimeInNanos;
            this.memoryInBytes = o.memoryInBytes;
        }

        private Builder(Builder o) {
            this.cpuTimeInNanos = o.cpuTimeInNanos;
            this.memoryInBytes = o.memoryInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code cpu_time_in_nanos}
         */
        @Nonnull
        public final Builder cpuTimeInNanos(long value) {
            this.cpuTimeInNanos = value;
            return this;
        }

        /**
         * Required - API name: {@code memory_in_bytes}
         */
        @Nonnull
        public final Builder memoryInBytes(long value) {
            this.memoryInBytes = value;
            return this;
        }

        /**
         * Builds a {@link ResourceStat}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ResourceStat build() {
            _checkSingleUse();

            return new ResourceStat(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ResourceStat}
     */
    public static final JsonpDeserializer<ResourceStat> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ResourceStat::setupResourceStatDeserializer
    );

    protected static void setupResourceStatDeserializer(ObjectDeserializer<ResourceStat.Builder> op) {
        op.add(Builder::cpuTimeInNanos, JsonpDeserializer.longDeserializer(), "cpu_time_in_nanos");
        op.add(Builder::memoryInBytes, JsonpDeserializer.longDeserializer(), "memory_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.cpuTimeInNanos);
        result = 31 * result + Long.hashCode(this.memoryInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ResourceStat other = (ResourceStat) o;
        return this.cpuTimeInNanos == other.cpuTimeInNanos && this.memoryInBytes == other.memoryInBytes;
    }
}
