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

package org.opensearch.client.opensearch.cluster.stats;

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

// typedef: cluster.stats.ClusterProcessOpenFileDescriptors

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterProcessOpenFileDescriptors
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ClusterProcessOpenFileDescriptors.Builder, ClusterProcessOpenFileDescriptors> {

    private final long avg;

    private final long max;

    private final long min;

    // ---------------------------------------------------------------------------------------------

    private ClusterProcessOpenFileDescriptors(Builder builder) {
        this.avg = ApiTypeHelper.requireNonNull(builder.avg, this, "avg");
        this.max = ApiTypeHelper.requireNonNull(builder.max, this, "max");
        this.min = ApiTypeHelper.requireNonNull(builder.min, this, "min");
    }

    public static ClusterProcessOpenFileDescriptors of(
        Function<ClusterProcessOpenFileDescriptors.Builder, ObjectBuilder<ClusterProcessOpenFileDescriptors>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Average number of concurrently open file descriptors. Returns <code>-1</code> if not supported.
     * <p>
     * API name: {@code avg}
     * </p>
     */
    public final long avg() {
        return this.avg;
    }

    /**
     * Required - Maximum number of concurrently open file descriptors allowed across all selected nodes. Returns <code>-1</code> if not
     * supported.
     * <p>
     * API name: {@code max}
     * </p>
     */
    public final long max() {
        return this.max;
    }

    /**
     * Required - Minimum number of concurrently open file descriptors across all selected nodes. Returns -1 if not supported.
     * <p>
     * API name: {@code min}
     * </p>
     */
    public final long min() {
        return this.min;
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
        generator.writeKey("avg");
        generator.write(this.avg);

        generator.writeKey("max");
        generator.write(this.max);

        generator.writeKey("min");
        generator.write(this.min);
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
     * Builder for {@link ClusterProcessOpenFileDescriptors}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterProcessOpenFileDescriptors> {
        private Long avg;
        private Long max;
        private Long min;

        public Builder() {}

        private Builder(ClusterProcessOpenFileDescriptors o) {
            this.avg = o.avg;
            this.max = o.max;
            this.min = o.min;
        }

        private Builder(Builder o) {
            this.avg = o.avg;
            this.max = o.max;
            this.min = o.min;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Average number of concurrently open file descriptors. Returns <code>-1</code> if not supported.
         * <p>
         * API name: {@code avg}
         * </p>
         */
        @Nonnull
        public final Builder avg(long value) {
            this.avg = value;
            return this;
        }

        /**
         * Required - Maximum number of concurrently open file descriptors allowed across all selected nodes. Returns <code>-1</code> if not
         * supported.
         * <p>
         * API name: {@code max}
         * </p>
         */
        @Nonnull
        public final Builder max(long value) {
            this.max = value;
            return this;
        }

        /**
         * Required - Minimum number of concurrently open file descriptors across all selected nodes. Returns -1 if not supported.
         * <p>
         * API name: {@code min}
         * </p>
         */
        @Nonnull
        public final Builder min(long value) {
            this.min = value;
            return this;
        }

        /**
         * Builds a {@link ClusterProcessOpenFileDescriptors}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterProcessOpenFileDescriptors build() {
            _checkSingleUse();

            return new ClusterProcessOpenFileDescriptors(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterProcessOpenFileDescriptors}
     */
    public static final JsonpDeserializer<ClusterProcessOpenFileDescriptors> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterProcessOpenFileDescriptors::setupClusterProcessOpenFileDescriptorsDeserializer
    );

    protected static void setupClusterProcessOpenFileDescriptorsDeserializer(
        ObjectDeserializer<ClusterProcessOpenFileDescriptors.Builder> op
    ) {
        op.add(Builder::avg, JsonpDeserializer.longDeserializer(), "avg");
        op.add(Builder::max, JsonpDeserializer.longDeserializer(), "max");
        op.add(Builder::min, JsonpDeserializer.longDeserializer(), "min");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.avg);
        result = 31 * result + Long.hashCode(this.max);
        result = 31 * result + Long.hashCode(this.min);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterProcessOpenFileDescriptors other = (ClusterProcessOpenFileDescriptors) o;
        return this.avg == other.avg && this.max == other.max && this.min == other.min;
    }
}
