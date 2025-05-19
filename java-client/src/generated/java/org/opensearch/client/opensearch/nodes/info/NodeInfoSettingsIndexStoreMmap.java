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
import java.util.List;
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

// typedef: nodes.info.NodeInfoSettingsIndexStoreMmap

/**
 * The memory-mapped store configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSettingsIndexStoreMmap
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NodeInfoSettingsIndexStoreMmap.Builder, NodeInfoSettingsIndexStoreMmap> {

    @Nonnull
    private final List<String> extensions;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSettingsIndexStoreMmap(Builder builder) {
        this.extensions = ApiTypeHelper.unmodifiable(builder.extensions);
    }

    public static NodeInfoSettingsIndexStoreMmap of(
        Function<NodeInfoSettingsIndexStoreMmap.Builder, ObjectBuilder<NodeInfoSettingsIndexStoreMmap>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The file extensions configured for memory mapping.
     * <p>
     * API name: {@code extensions}
     * </p>
     */
    @Nonnull
    public final List<String> extensions() {
        return this.extensions;
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
        if (ApiTypeHelper.isDefined(this.extensions)) {
            generator.writeKey("extensions");
            generator.writeStartArray();
            for (String item0 : this.extensions) {
                generator.write(item0);
            }
            generator.writeEnd();
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
     * Builder for {@link NodeInfoSettingsIndexStoreMmap}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoSettingsIndexStoreMmap> {
        @Nullable
        private List<String> extensions;

        public Builder() {}

        private Builder(NodeInfoSettingsIndexStoreMmap o) {
            this.extensions = _listCopy(o.extensions);
        }

        private Builder(Builder o) {
            this.extensions = _listCopy(o.extensions);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The file extensions configured for memory mapping.
         * <p>
         * API name: {@code extensions}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>extensions</code>.
         * </p>
         */
        @Nonnull
        public final Builder extensions(List<String> list) {
            this.extensions = _listAddAll(this.extensions, list);
            return this;
        }

        /**
         * The file extensions configured for memory mapping.
         * <p>
         * API name: {@code extensions}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>extensions</code>.
         * </p>
         */
        @Nonnull
        public final Builder extensions(String value, String... values) {
            this.extensions = _listAdd(this.extensions, value, values);
            return this;
        }

        /**
         * Builds a {@link NodeInfoSettingsIndexStoreMmap}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSettingsIndexStoreMmap build() {
            _checkSingleUse();

            return new NodeInfoSettingsIndexStoreMmap(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSettingsIndexStoreMmap}
     */
    public static final JsonpDeserializer<NodeInfoSettingsIndexStoreMmap> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoSettingsIndexStoreMmap::setupNodeInfoSettingsIndexStoreMmapDeserializer
    );

    protected static void setupNodeInfoSettingsIndexStoreMmapDeserializer(ObjectDeserializer<NodeInfoSettingsIndexStoreMmap.Builder> op) {
        op.add(Builder::extensions, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "extensions");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.extensions);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSettingsIndexStoreMmap other = (NodeInfoSettingsIndexStoreMmap) o;
        return Objects.equals(this.extensions, other.extensions);
    }
}
