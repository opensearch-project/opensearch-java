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

package org.opensearch.client.opensearch.cluster.allocation_explain;

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

// typedef: cluster.allocation_explain.NodeDiskUsage

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeDiskUsage implements PlainJsonSerializable, ToCopyableBuilder<NodeDiskUsage.Builder, NodeDiskUsage> {

    @Nonnull
    private final DiskUsage leastAvailable;

    @Nonnull
    private final DiskUsage mostAvailable;

    @Nonnull
    private final String nodeName;

    // ---------------------------------------------------------------------------------------------

    private NodeDiskUsage(Builder builder) {
        this.leastAvailable = ApiTypeHelper.requireNonNull(builder.leastAvailable, this, "leastAvailable");
        this.mostAvailable = ApiTypeHelper.requireNonNull(builder.mostAvailable, this, "mostAvailable");
        this.nodeName = ApiTypeHelper.requireNonNull(builder.nodeName, this, "nodeName");
    }

    public static NodeDiskUsage of(Function<NodeDiskUsage.Builder, ObjectBuilder<NodeDiskUsage>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code least_available}
     */
    @Nonnull
    public final DiskUsage leastAvailable() {
        return this.leastAvailable;
    }

    /**
     * Required - API name: {@code most_available}
     */
    @Nonnull
    public final DiskUsage mostAvailable() {
        return this.mostAvailable;
    }

    /**
     * Required - API name: {@code node_name}
     */
    @Nonnull
    public final String nodeName() {
        return this.nodeName;
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
        generator.writeKey("least_available");
        this.leastAvailable.serialize(generator, mapper);

        generator.writeKey("most_available");
        this.mostAvailable.serialize(generator, mapper);

        generator.writeKey("node_name");
        generator.write(this.nodeName);
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
     * Builder for {@link NodeDiskUsage}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeDiskUsage> {
        private DiskUsage leastAvailable;
        private DiskUsage mostAvailable;
        private String nodeName;

        public Builder() {}

        private Builder(NodeDiskUsage o) {
            this.leastAvailable = o.leastAvailable;
            this.mostAvailable = o.mostAvailable;
            this.nodeName = o.nodeName;
        }

        private Builder(Builder o) {
            this.leastAvailable = o.leastAvailable;
            this.mostAvailable = o.mostAvailable;
            this.nodeName = o.nodeName;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code least_available}
         */
        @Nonnull
        public final Builder leastAvailable(DiskUsage value) {
            this.leastAvailable = value;
            return this;
        }

        /**
         * Required - API name: {@code least_available}
         */
        @Nonnull
        public final Builder leastAvailable(Function<DiskUsage.Builder, ObjectBuilder<DiskUsage>> fn) {
            return leastAvailable(fn.apply(new DiskUsage.Builder()).build());
        }

        /**
         * Required - API name: {@code most_available}
         */
        @Nonnull
        public final Builder mostAvailable(DiskUsage value) {
            this.mostAvailable = value;
            return this;
        }

        /**
         * Required - API name: {@code most_available}
         */
        @Nonnull
        public final Builder mostAvailable(Function<DiskUsage.Builder, ObjectBuilder<DiskUsage>> fn) {
            return mostAvailable(fn.apply(new DiskUsage.Builder()).build());
        }

        /**
         * Required - API name: {@code node_name}
         */
        @Nonnull
        public final Builder nodeName(String value) {
            this.nodeName = value;
            return this;
        }

        /**
         * Builds a {@link NodeDiskUsage}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeDiskUsage build() {
            _checkSingleUse();

            return new NodeDiskUsage(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeDiskUsage}
     */
    public static final JsonpDeserializer<NodeDiskUsage> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeDiskUsage::setupNodeDiskUsageDeserializer
    );

    protected static void setupNodeDiskUsageDeserializer(ObjectDeserializer<NodeDiskUsage.Builder> op) {
        op.add(Builder::leastAvailable, DiskUsage._DESERIALIZER, "least_available");
        op.add(Builder::mostAvailable, DiskUsage._DESERIALIZER, "most_available");
        op.add(Builder::nodeName, JsonpDeserializer.stringDeserializer(), "node_name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.leastAvailable.hashCode();
        result = 31 * result + this.mostAvailable.hashCode();
        result = 31 * result + this.nodeName.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeDiskUsage other = (NodeDiskUsage) o;
        return this.leastAvailable.equals(other.leastAvailable)
            && this.mostAvailable.equals(other.mostAvailable)
            && this.nodeName.equals(other.nodeName);
    }
}
