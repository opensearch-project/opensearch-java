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

// typedef: nodes.stats.JvmThreads

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class JvmThreads implements PlainJsonSerializable, ToCopyableBuilder<JvmThreads.Builder, JvmThreads> {

    @Nullable
    private final Long count;

    @Nullable
    private final Long peakCount;

    // ---------------------------------------------------------------------------------------------

    private JvmThreads(Builder builder) {
        this.count = builder.count;
        this.peakCount = builder.peakCount;
    }

    public static JvmThreads of(Function<JvmThreads.Builder, ObjectBuilder<JvmThreads>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Number of active threads in use by JVM.
     * <p>
     * API name: {@code count}
     * </p>
     */
    @Nullable
    public final Long count() {
        return this.count;
    }

    /**
     * Highest number of threads used by JVM.
     * <p>
     * API name: {@code peak_count}
     * </p>
     */
    @Nullable
    public final Long peakCount() {
        return this.peakCount;
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
        if (this.count != null) {
            generator.writeKey("count");
            generator.write(this.count);
        }

        if (this.peakCount != null) {
            generator.writeKey("peak_count");
            generator.write(this.peakCount);
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
     * Builder for {@link JvmThreads}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, JvmThreads> {
        @Nullable
        private Long count;
        @Nullable
        private Long peakCount;

        public Builder() {}

        private Builder(JvmThreads o) {
            this.count = o.count;
            this.peakCount = o.peakCount;
        }

        private Builder(Builder o) {
            this.count = o.count;
            this.peakCount = o.peakCount;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Number of active threads in use by JVM.
         * <p>
         * API name: {@code count}
         * </p>
         */
        @Nonnull
        public final Builder count(@Nullable Long value) {
            this.count = value;
            return this;
        }

        /**
         * Highest number of threads used by JVM.
         * <p>
         * API name: {@code peak_count}
         * </p>
         */
        @Nonnull
        public final Builder peakCount(@Nullable Long value) {
            this.peakCount = value;
            return this;
        }

        /**
         * Builds a {@link JvmThreads}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public JvmThreads build() {
            _checkSingleUse();

            return new JvmThreads(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link JvmThreads}
     */
    public static final JsonpDeserializer<JvmThreads> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        JvmThreads::setupJvmThreadsDeserializer
    );

    protected static void setupJvmThreadsDeserializer(ObjectDeserializer<JvmThreads.Builder> op) {
        op.add(Builder::count, JsonpDeserializer.longDeserializer(), "count");
        op.add(Builder::peakCount, JsonpDeserializer.longDeserializer(), "peak_count");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.peakCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        JvmThreads other = (JvmThreads) o;
        return Objects.equals(this.count, other.count) && Objects.equals(this.peakCount, other.peakCount);
    }
}
