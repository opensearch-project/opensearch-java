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

// typedef: cluster.stats.ClusterProcess

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterProcess implements PlainJsonSerializable, ToCopyableBuilder<ClusterProcess.Builder, ClusterProcess> {

    @Nonnull
    private final ClusterProcessCpu cpu;

    @Nonnull
    private final ClusterProcessOpenFileDescriptors openFileDescriptors;

    // ---------------------------------------------------------------------------------------------

    private ClusterProcess(Builder builder) {
        this.cpu = ApiTypeHelper.requireNonNull(builder.cpu, this, "cpu");
        this.openFileDescriptors = ApiTypeHelper.requireNonNull(builder.openFileDescriptors, this, "openFileDescriptors");
    }

    public static ClusterProcess of(Function<ClusterProcess.Builder, ObjectBuilder<ClusterProcess>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code cpu}
     */
    @Nonnull
    public final ClusterProcessCpu cpu() {
        return this.cpu;
    }

    /**
     * Required - API name: {@code open_file_descriptors}
     */
    @Nonnull
    public final ClusterProcessOpenFileDescriptors openFileDescriptors() {
        return this.openFileDescriptors;
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
        generator.writeKey("cpu");
        this.cpu.serialize(generator, mapper);

        generator.writeKey("open_file_descriptors");
        this.openFileDescriptors.serialize(generator, mapper);
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
     * Builder for {@link ClusterProcess}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterProcess> {
        private ClusterProcessCpu cpu;
        private ClusterProcessOpenFileDescriptors openFileDescriptors;

        public Builder() {}

        private Builder(ClusterProcess o) {
            this.cpu = o.cpu;
            this.openFileDescriptors = o.openFileDescriptors;
        }

        private Builder(Builder o) {
            this.cpu = o.cpu;
            this.openFileDescriptors = o.openFileDescriptors;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code cpu}
         */
        @Nonnull
        public final Builder cpu(ClusterProcessCpu value) {
            this.cpu = value;
            return this;
        }

        /**
         * Required - API name: {@code cpu}
         */
        @Nonnull
        public final Builder cpu(Function<ClusterProcessCpu.Builder, ObjectBuilder<ClusterProcessCpu>> fn) {
            return cpu(fn.apply(new ClusterProcessCpu.Builder()).build());
        }

        /**
         * Required - API name: {@code open_file_descriptors}
         */
        @Nonnull
        public final Builder openFileDescriptors(ClusterProcessOpenFileDescriptors value) {
            this.openFileDescriptors = value;
            return this;
        }

        /**
         * Required - API name: {@code open_file_descriptors}
         */
        @Nonnull
        public final Builder openFileDescriptors(
            Function<ClusterProcessOpenFileDescriptors.Builder, ObjectBuilder<ClusterProcessOpenFileDescriptors>> fn
        ) {
            return openFileDescriptors(fn.apply(new ClusterProcessOpenFileDescriptors.Builder()).build());
        }

        /**
         * Builds a {@link ClusterProcess}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterProcess build() {
            _checkSingleUse();

            return new ClusterProcess(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterProcess}
     */
    public static final JsonpDeserializer<ClusterProcess> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterProcess::setupClusterProcessDeserializer
    );

    protected static void setupClusterProcessDeserializer(ObjectDeserializer<ClusterProcess.Builder> op) {
        op.add(Builder::cpu, ClusterProcessCpu._DESERIALIZER, "cpu");
        op.add(Builder::openFileDescriptors, ClusterProcessOpenFileDescriptors._DESERIALIZER, "open_file_descriptors");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.cpu.hashCode();
        result = 31 * result + this.openFileDescriptors.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterProcess other = (ClusterProcess) o;
        return this.cpu.equals(other.cpu) && this.openFileDescriptors.equals(other.openFileDescriptors);
    }
}
