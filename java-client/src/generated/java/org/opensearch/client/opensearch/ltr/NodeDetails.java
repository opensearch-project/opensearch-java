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

package org.opensearch.client.opensearch.ltr;

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

// typedef: ltr.NodeDetails

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeDetails implements PlainJsonSerializable, ToCopyableBuilder<NodeDetails.Builder, NodeDetails> {

    @Nullable
    private final String hostname;

    @Nullable
    private final String name;

    @Nullable
    private final NodeStatsDetails stats;

    // ---------------------------------------------------------------------------------------------

    private NodeDetails(Builder builder) {
        this.hostname = builder.hostname;
        this.name = builder.name;
        this.stats = builder.stats;
    }

    public static NodeDetails of(Function<NodeDetails.Builder, ObjectBuilder<NodeDetails>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Node hostname.
     * <p>
     * API name: {@code hostname}
     * </p>
     */
    @Nullable
    public final String hostname() {
        return this.hostname;
    }

    /**
     * Node name.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code stats}
     */
    @Nullable
    public final NodeStatsDetails stats() {
        return this.stats;
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
        if (this.hostname != null) {
            generator.writeKey("hostname");
            generator.write(this.hostname);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.stats != null) {
            generator.writeKey("stats");
            this.stats.serialize(generator, mapper);
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
     * Builder for {@link NodeDetails}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeDetails> {
        @Nullable
        private String hostname;
        @Nullable
        private String name;
        @Nullable
        private NodeStatsDetails stats;

        public Builder() {}

        private Builder(NodeDetails o) {
            this.hostname = o.hostname;
            this.name = o.name;
            this.stats = o.stats;
        }

        private Builder(Builder o) {
            this.hostname = o.hostname;
            this.name = o.name;
            this.stats = o.stats;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Node hostname.
         * <p>
         * API name: {@code hostname}
         * </p>
         */
        @Nonnull
        public final Builder hostname(@Nullable String value) {
            this.hostname = value;
            return this;
        }

        /**
         * Node name.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code stats}
         */
        @Nonnull
        public final Builder stats(@Nullable NodeStatsDetails value) {
            this.stats = value;
            return this;
        }

        /**
         * API name: {@code stats}
         */
        @Nonnull
        public final Builder stats(Function<NodeStatsDetails.Builder, ObjectBuilder<NodeStatsDetails>> fn) {
            return stats(fn.apply(new NodeStatsDetails.Builder()).build());
        }

        /**
         * Builds a {@link NodeDetails}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeDetails build() {
            _checkSingleUse();

            return new NodeDetails(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeDetails}
     */
    public static final JsonpDeserializer<NodeDetails> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeDetails::setupNodeDetailsDeserializer
    );

    protected static void setupNodeDetailsDeserializer(ObjectDeserializer<NodeDetails.Builder> op) {
        op.add(Builder::hostname, JsonpDeserializer.stringDeserializer(), "hostname");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::stats, NodeStatsDetails._DESERIALIZER, "stats");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.hostname);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.stats);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeDetails other = (NodeDetails) o;
        return Objects.equals(this.hostname, other.hostname)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.stats, other.stats);
    }
}
