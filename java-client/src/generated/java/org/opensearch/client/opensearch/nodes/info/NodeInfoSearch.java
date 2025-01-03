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

package org.opensearch.client.opensearch.nodes.info;

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

// typedef: nodes.info.NodeInfoSearch

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSearch implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoSearch.Builder, NodeInfoSearch> {

    @Nonnull
    private final NodeInfoSearchRemote remote;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSearch(Builder builder) {
        this.remote = ApiTypeHelper.requireNonNull(builder.remote, this, "remote");
    }

    public static NodeInfoSearch of(Function<NodeInfoSearch.Builder, ObjectBuilder<NodeInfoSearch>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code remote}
     */
    @Nonnull
    public final NodeInfoSearchRemote remote() {
        return this.remote;
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
        generator.writeKey("remote");
        this.remote.serialize(generator, mapper);
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
     * Builder for {@link NodeInfoSearch}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoSearch> {
        private NodeInfoSearchRemote remote;

        public Builder() {}

        private Builder(NodeInfoSearch o) {
            this.remote = o.remote;
        }

        private Builder(Builder o) {
            this.remote = o.remote;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code remote}
         */
        @Nonnull
        public final Builder remote(NodeInfoSearchRemote value) {
            this.remote = value;
            return this;
        }

        /**
         * Required - API name: {@code remote}
         */
        @Nonnull
        public final Builder remote(Function<NodeInfoSearchRemote.Builder, ObjectBuilder<NodeInfoSearchRemote>> fn) {
            return remote(fn.apply(new NodeInfoSearchRemote.Builder()).build());
        }

        /**
         * Builds a {@link NodeInfoSearch}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSearch build() {
            _checkSingleUse();

            return new NodeInfoSearch(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSearch}
     */
    public static final JsonpDeserializer<NodeInfoSearch> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoSearch::setupNodeInfoSearchDeserializer
    );

    protected static void setupNodeInfoSearchDeserializer(ObjectDeserializer<NodeInfoSearch.Builder> op) {
        op.add(Builder::remote, NodeInfoSearchRemote._DESERIALIZER, "remote");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.remote.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSearch other = (NodeInfoSearch) o;
        return this.remote.equals(other.remote);
    }
}
