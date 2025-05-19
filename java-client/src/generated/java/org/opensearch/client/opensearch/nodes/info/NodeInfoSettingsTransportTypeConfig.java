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

// typedef: nodes.info.NodeInfoSettingsTransportTypeConfig

/**
 * The detailed transport type configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSettingsTransportTypeConfig
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NodeInfoSettingsTransportTypeConfig.Builder, NodeInfoSettingsTransportTypeConfig> {

    @Nullable
    private final String default_;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSettingsTransportTypeConfig(Builder builder) {
        this.default_ = builder.default_;
    }

    public static NodeInfoSettingsTransportTypeConfig of(
        Function<NodeInfoSettingsTransportTypeConfig.Builder, ObjectBuilder<NodeInfoSettingsTransportTypeConfig>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The default transport implementation.
     * <p>
     * API name: {@code default}
     * </p>
     */
    @Nullable
    public final String default_() {
        return this.default_;
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
        if (this.default_ != null) {
            generator.writeKey("default");
            generator.write(this.default_);
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
     * Builder for {@link NodeInfoSettingsTransportTypeConfig}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoSettingsTransportTypeConfig> {
        @Nullable
        private String default_;

        public Builder() {}

        private Builder(NodeInfoSettingsTransportTypeConfig o) {
            this.default_ = o.default_;
        }

        private Builder(Builder o) {
            this.default_ = o.default_;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The default transport implementation.
         * <p>
         * API name: {@code default}
         * </p>
         */
        @Nonnull
        public final Builder default_(@Nullable String value) {
            this.default_ = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfoSettingsTransportTypeConfig}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSettingsTransportTypeConfig build() {
            _checkSingleUse();

            return new NodeInfoSettingsTransportTypeConfig(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSettingsTransportTypeConfig}
     */
    public static final JsonpDeserializer<NodeInfoSettingsTransportTypeConfig> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoSettingsTransportTypeConfig::setupNodeInfoSettingsTransportTypeConfigDeserializer
    );

    protected static void setupNodeInfoSettingsTransportTypeConfigDeserializer(
        ObjectDeserializer<NodeInfoSettingsTransportTypeConfig.Builder> op
    ) {
        op.add(Builder::default_, JsonpDeserializer.stringDeserializer(), "default");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.default_);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSettingsTransportTypeConfig other = (NodeInfoSettingsTransportTypeConfig) o;
        return Objects.equals(this.default_, other.default_);
    }
}
