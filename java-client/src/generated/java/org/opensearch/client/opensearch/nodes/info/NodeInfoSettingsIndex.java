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

// typedef: nodes.info.NodeInfoSettingsIndex

/**
 * The index-level settings configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSettingsIndex
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NodeInfoSettingsIndex.Builder, NodeInfoSettingsIndex> {

    @Nullable
    private final NodeInfoSettingsIndexStore store;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSettingsIndex(Builder builder) {
        this.store = builder.store;
    }

    public static NodeInfoSettingsIndex of(Function<NodeInfoSettingsIndex.Builder, ObjectBuilder<NodeInfoSettingsIndex>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code store}
     */
    @Nullable
    public final NodeInfoSettingsIndexStore store() {
        return this.store;
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
        if (this.store != null) {
            generator.writeKey("store");
            this.store.serialize(generator, mapper);
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
     * Builder for {@link NodeInfoSettingsIndex}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoSettingsIndex> {
        @Nullable
        private NodeInfoSettingsIndexStore store;

        public Builder() {}

        private Builder(NodeInfoSettingsIndex o) {
            this.store = o.store;
        }

        private Builder(Builder o) {
            this.store = o.store;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code store}
         */
        @Nonnull
        public final Builder store(@Nullable NodeInfoSettingsIndexStore value) {
            this.store = value;
            return this;
        }

        /**
         * API name: {@code store}
         */
        @Nonnull
        public final Builder store(Function<NodeInfoSettingsIndexStore.Builder, ObjectBuilder<NodeInfoSettingsIndexStore>> fn) {
            return store(fn.apply(new NodeInfoSettingsIndexStore.Builder()).build());
        }

        /**
         * Builds a {@link NodeInfoSettingsIndex}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSettingsIndex build() {
            _checkSingleUse();

            return new NodeInfoSettingsIndex(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSettingsIndex}
     */
    public static final JsonpDeserializer<NodeInfoSettingsIndex> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoSettingsIndex::setupNodeInfoSettingsIndexDeserializer
    );

    protected static void setupNodeInfoSettingsIndexDeserializer(ObjectDeserializer<NodeInfoSettingsIndex.Builder> op) {
        op.add(Builder::store, NodeInfoSettingsIndexStore._DESERIALIZER, "store");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.store);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSettingsIndex other = (NodeInfoSettingsIndex) o;
        return Objects.equals(this.store, other.store);
    }
}
