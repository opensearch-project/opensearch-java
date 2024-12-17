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

package org.opensearch.client.opensearch.indices.segments;

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

// typedef: indices.segments.ShardSegmentRouting

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardSegmentRouting implements PlainJsonSerializable, ToCopyableBuilder<ShardSegmentRouting.Builder, ShardSegmentRouting> {

    @Nonnull
    private final String node;

    private final boolean primary;

    @Nonnull
    private final String state;

    // ---------------------------------------------------------------------------------------------

    private ShardSegmentRouting(Builder builder) {
        this.node = ApiTypeHelper.requireNonNull(builder.node, this, "node");
        this.primary = ApiTypeHelper.requireNonNull(builder.primary, this, "primary");
        this.state = ApiTypeHelper.requireNonNull(builder.state, this, "state");
    }

    public static ShardSegmentRouting of(Function<ShardSegmentRouting.Builder, ObjectBuilder<ShardSegmentRouting>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code node}
     */
    @Nonnull
    public final String node() {
        return this.node;
    }

    /**
     * Required - API name: {@code primary}
     */
    public final boolean primary() {
        return this.primary;
    }

    /**
     * Required - API name: {@code state}
     */
    @Nonnull
    public final String state() {
        return this.state;
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
        generator.writeKey("node");
        generator.write(this.node);

        generator.writeKey("primary");
        generator.write(this.primary);

        generator.writeKey("state");
        generator.write(this.state);
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
     * Builder for {@link ShardSegmentRouting}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardSegmentRouting> {
        private String node;
        private Boolean primary;
        private String state;

        public Builder() {}

        private Builder(ShardSegmentRouting o) {
            this.node = o.node;
            this.primary = o.primary;
            this.state = o.state;
        }

        private Builder(Builder o) {
            this.node = o.node;
            this.primary = o.primary;
            this.state = o.state;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
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
         * Required - API name: {@code primary}
         */
        @Nonnull
        public final Builder primary(boolean value) {
            this.primary = value;
            return this;
        }

        /**
         * Required - API name: {@code state}
         */
        @Nonnull
        public final Builder state(String value) {
            this.state = value;
            return this;
        }

        /**
         * Builds a {@link ShardSegmentRouting}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardSegmentRouting build() {
            _checkSingleUse();

            return new ShardSegmentRouting(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardSegmentRouting}
     */
    public static final JsonpDeserializer<ShardSegmentRouting> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardSegmentRouting::setupShardSegmentRoutingDeserializer
    );

    protected static void setupShardSegmentRoutingDeserializer(ObjectDeserializer<ShardSegmentRouting.Builder> op) {
        op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node");
        op.add(Builder::primary, JsonpDeserializer.booleanDeserializer(), "primary");
        op.add(Builder::state, JsonpDeserializer.stringDeserializer(), "state");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.node.hashCode();
        result = 31 * result + Boolean.hashCode(this.primary);
        result = 31 * result + this.state.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardSegmentRouting other = (ShardSegmentRouting) o;
        return this.node.equals(other.node) && this.primary == other.primary && this.state.equals(other.state);
    }
}
