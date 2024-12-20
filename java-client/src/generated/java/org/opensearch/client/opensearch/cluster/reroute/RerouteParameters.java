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

package org.opensearch.client.opensearch.cluster.reroute;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.reroute.RerouteParameters

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RerouteParameters implements PlainJsonSerializable, ToCopyableBuilder<RerouteParameters.Builder, RerouteParameters> {

    private final boolean allowPrimary;

    @Nullable
    private final String fromNode;

    @Nonnull
    private final String index;

    @Nonnull
    private final String node;

    private final int shard;

    @Nullable
    private final String toNode;

    // ---------------------------------------------------------------------------------------------

    private RerouteParameters(Builder builder) {
        this.allowPrimary = ApiTypeHelper.requireNonNull(builder.allowPrimary, this, "allowPrimary");
        this.fromNode = builder.fromNode;
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.node = ApiTypeHelper.requireNonNull(builder.node, this, "node");
        this.shard = ApiTypeHelper.requireNonNull(builder.shard, this, "shard");
        this.toNode = builder.toNode;
    }

    public static RerouteParameters of(Function<RerouteParameters.Builder, ObjectBuilder<RerouteParameters>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code allow_primary}
     */
    public final boolean allowPrimary() {
        return this.allowPrimary;
    }

    /**
     * API name: {@code from_node}
     */
    @Nullable
    public final String fromNode() {
        return this.fromNode;
    }

    /**
     * Required - API name: {@code index}
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * Required - API name: {@code node}
     */
    @Nonnull
    public final String node() {
        return this.node;
    }

    /**
     * Required - API name: {@code shard}
     */
    public final int shard() {
        return this.shard;
    }

    /**
     * API name: {@code to_node}
     */
    @Nullable
    public final String toNode() {
        return this.toNode;
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
        generator.writeKey("allow_primary");
        generator.write(this.allowPrimary);

        if (this.fromNode != null) {
            generator.writeKey("from_node");
            generator.write(this.fromNode);
        }

        generator.writeKey("index");
        generator.write(this.index);

        generator.writeKey("node");
        generator.write(this.node);

        generator.writeKey("shard");
        generator.write(this.shard);

        if (this.toNode != null) {
            generator.writeKey("to_node");
            generator.write(this.toNode);
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
     * Builder for {@link RerouteParameters}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RerouteParameters> {
        private Boolean allowPrimary;
        @Nullable
        private String fromNode;
        private String index;
        private String node;
        private Integer shard;
        @Nullable
        private String toNode;

        public Builder() {}

        private Builder(RerouteParameters o) {
            this.allowPrimary = o.allowPrimary;
            this.fromNode = o.fromNode;
            this.index = o.index;
            this.node = o.node;
            this.shard = o.shard;
            this.toNode = o.toNode;
        }

        private Builder(Builder o) {
            this.allowPrimary = o.allowPrimary;
            this.fromNode = o.fromNode;
            this.index = o.index;
            this.node = o.node;
            this.shard = o.shard;
            this.toNode = o.toNode;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code allow_primary}
         */
        @Nonnull
        public final Builder allowPrimary(boolean value) {
            this.allowPrimary = value;
            return this;
        }

        /**
         * API name: {@code from_node}
         */
        @Nonnull
        public final Builder fromNode(@Nullable String value) {
            this.fromNode = value;
            return this;
        }

        /**
         * Required - API name: {@code index}
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * Required - API name: {@code node}
         */
        @Nonnull
        public final Builder node(String value) {
            this.node = value;
            return this;
        }

        /**
         * Required - API name: {@code shard}
         */
        @Nonnull
        public final Builder shard(int value) {
            this.shard = value;
            return this;
        }

        /**
         * API name: {@code to_node}
         */
        @Nonnull
        public final Builder toNode(@Nullable String value) {
            this.toNode = value;
            return this;
        }

        /**
         * Builds a {@link RerouteParameters}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RerouteParameters build() {
            _checkSingleUse();

            return new RerouteParameters(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RerouteParameters}
     */
    public static final JsonpDeserializer<RerouteParameters> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RerouteParameters::setupRerouteParametersDeserializer
    );

    protected static void setupRerouteParametersDeserializer(ObjectDeserializer<RerouteParameters.Builder> op) {
        op.add(Builder::allowPrimary, JsonpDeserializer.booleanDeserializer(), "allow_primary");
        op.add(Builder::fromNode, JsonpDeserializer.stringDeserializer(), "from_node");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node");
        op.add(Builder::shard, JsonpDeserializer.integerDeserializer(), "shard");
        op.add(Builder::toNode, JsonpDeserializer.stringDeserializer(), "to_node");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.allowPrimary);
        result = 31 * result + Objects.hashCode(this.fromNode);
        result = 31 * result + this.index.hashCode();
        result = 31 * result + this.node.hashCode();
        result = 31 * result + Integer.hashCode(this.shard);
        result = 31 * result + Objects.hashCode(this.toNode);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RerouteParameters other = (RerouteParameters) o;
        return this.allowPrimary == other.allowPrimary
            && Objects.equals(this.fromNode, other.fromNode)
            && this.index.equals(other.index)
            && this.node.equals(other.node)
            && this.shard == other.shard
            && Objects.equals(this.toNode, other.toNode);
    }
}
