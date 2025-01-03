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

// typedef: nodes.stats.JvmClasses

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class JvmClasses implements PlainJsonSerializable, ToCopyableBuilder<JvmClasses.Builder, JvmClasses> {

    @Nullable
    private final Long currentLoadedCount;

    @Nullable
    private final Long totalLoadedCount;

    @Nullable
    private final Long totalUnloadedCount;

    // ---------------------------------------------------------------------------------------------

    private JvmClasses(Builder builder) {
        this.currentLoadedCount = builder.currentLoadedCount;
        this.totalLoadedCount = builder.totalLoadedCount;
        this.totalUnloadedCount = builder.totalUnloadedCount;
    }

    public static JvmClasses of(Function<JvmClasses.Builder, ObjectBuilder<JvmClasses>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Number of classes currently loaded by JVM.
     * <p>
     * API name: {@code current_loaded_count}
     * </p>
     */
    @Nullable
    public final Long currentLoadedCount() {
        return this.currentLoadedCount;
    }

    /**
     * Total number of classes loaded since the JVM started.
     * <p>
     * API name: {@code total_loaded_count}
     * </p>
     */
    @Nullable
    public final Long totalLoadedCount() {
        return this.totalLoadedCount;
    }

    /**
     * Total number of classes unloaded since the JVM started.
     * <p>
     * API name: {@code total_unloaded_count}
     * </p>
     */
    @Nullable
    public final Long totalUnloadedCount() {
        return this.totalUnloadedCount;
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
        if (this.currentLoadedCount != null) {
            generator.writeKey("current_loaded_count");
            generator.write(this.currentLoadedCount);
        }

        if (this.totalLoadedCount != null) {
            generator.writeKey("total_loaded_count");
            generator.write(this.totalLoadedCount);
        }

        if (this.totalUnloadedCount != null) {
            generator.writeKey("total_unloaded_count");
            generator.write(this.totalUnloadedCount);
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
     * Builder for {@link JvmClasses}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, JvmClasses> {
        @Nullable
        private Long currentLoadedCount;
        @Nullable
        private Long totalLoadedCount;
        @Nullable
        private Long totalUnloadedCount;

        public Builder() {}

        private Builder(JvmClasses o) {
            this.currentLoadedCount = o.currentLoadedCount;
            this.totalLoadedCount = o.totalLoadedCount;
            this.totalUnloadedCount = o.totalUnloadedCount;
        }

        private Builder(Builder o) {
            this.currentLoadedCount = o.currentLoadedCount;
            this.totalLoadedCount = o.totalLoadedCount;
            this.totalUnloadedCount = o.totalUnloadedCount;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Number of classes currently loaded by JVM.
         * <p>
         * API name: {@code current_loaded_count}
         * </p>
         */
        @Nonnull
        public final Builder currentLoadedCount(@Nullable Long value) {
            this.currentLoadedCount = value;
            return this;
        }

        /**
         * Total number of classes loaded since the JVM started.
         * <p>
         * API name: {@code total_loaded_count}
         * </p>
         */
        @Nonnull
        public final Builder totalLoadedCount(@Nullable Long value) {
            this.totalLoadedCount = value;
            return this;
        }

        /**
         * Total number of classes unloaded since the JVM started.
         * <p>
         * API name: {@code total_unloaded_count}
         * </p>
         */
        @Nonnull
        public final Builder totalUnloadedCount(@Nullable Long value) {
            this.totalUnloadedCount = value;
            return this;
        }

        /**
         * Builds a {@link JvmClasses}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public JvmClasses build() {
            _checkSingleUse();

            return new JvmClasses(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link JvmClasses}
     */
    public static final JsonpDeserializer<JvmClasses> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        JvmClasses::setupJvmClassesDeserializer
    );

    protected static void setupJvmClassesDeserializer(ObjectDeserializer<JvmClasses.Builder> op) {
        op.add(Builder::currentLoadedCount, JsonpDeserializer.longDeserializer(), "current_loaded_count");
        op.add(Builder::totalLoadedCount, JsonpDeserializer.longDeserializer(), "total_loaded_count");
        op.add(Builder::totalUnloadedCount, JsonpDeserializer.longDeserializer(), "total_unloaded_count");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.currentLoadedCount);
        result = 31 * result + Objects.hashCode(this.totalLoadedCount);
        result = 31 * result + Objects.hashCode(this.totalUnloadedCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        JvmClasses other = (JvmClasses) o;
        return Objects.equals(this.currentLoadedCount, other.currentLoadedCount)
            && Objects.equals(this.totalLoadedCount, other.totalLoadedCount)
            && Objects.equals(this.totalUnloadedCount, other.totalUnloadedCount);
    }
}
