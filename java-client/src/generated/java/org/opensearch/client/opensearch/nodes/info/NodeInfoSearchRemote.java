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

// typedef: nodes.info.NodeInfoSearchRemote

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSearchRemote implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoSearchRemote.Builder, NodeInfoSearchRemote> {

    @Nonnull
    private final String connect;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSearchRemote(Builder builder) {
        this.connect = ApiTypeHelper.requireNonNull(builder.connect, this, "connect");
    }

    public static NodeInfoSearchRemote of(Function<NodeInfoSearchRemote.Builder, ObjectBuilder<NodeInfoSearchRemote>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code connect}
     */
    @Nonnull
    public final String connect() {
        return this.connect;
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
        generator.writeKey("connect");
        generator.write(this.connect);
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
     * Builder for {@link NodeInfoSearchRemote}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoSearchRemote> {
        private String connect;

        public Builder() {}

        private Builder(NodeInfoSearchRemote o) {
            this.connect = o.connect;
        }

        private Builder(Builder o) {
            this.connect = o.connect;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code connect}
         */
        @Nonnull
        public final Builder connect(String value) {
            this.connect = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfoSearchRemote}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSearchRemote build() {
            _checkSingleUse();

            return new NodeInfoSearchRemote(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSearchRemote}
     */
    public static final JsonpDeserializer<NodeInfoSearchRemote> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoSearchRemote::setupNodeInfoSearchRemoteDeserializer
    );

    protected static void setupNodeInfoSearchRemoteDeserializer(ObjectDeserializer<NodeInfoSearchRemote.Builder> op) {
        op.add(Builder::connect, JsonpDeserializer.stringDeserializer(), "connect");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.connect.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSearchRemote other = (NodeInfoSearchRemote) o;
        return this.connect.equals(other.connect);
    }
}
