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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.info.NodeInfoSettingsTransport

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSettingsTransport
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NodeInfoSettingsTransport.Builder, NodeInfoSettingsTransport> {

    @Nonnull
    private final String type;

    @Nullable
    private final String typeDefault;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSettingsTransport(Builder builder) {
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
        this.typeDefault = builder.typeDefault;
    }

    public static NodeInfoSettingsTransport of(Function<NodeInfoSettingsTransport.Builder, ObjectBuilder<NodeInfoSettingsTransport>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final String type() {
        return this.type;
    }

    /**
     * API name: {@code type.default}
     */
    @Nullable
    public final String typeDefault() {
        return this.typeDefault;
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
        generator.writeKey("type");
        generator.write(this.type);

        if (this.typeDefault != null) {
            generator.writeKey("type.default");
            generator.write(this.typeDefault);
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
     * Builder for {@link NodeInfoSettingsTransport}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoSettingsTransport> {
        private String type;
        @Nullable
        private String typeDefault;

        public Builder() {}

        private Builder(NodeInfoSettingsTransport o) {
            this.type = o.type;
            this.typeDefault = o.typeDefault;
        }

        private Builder(Builder o) {
            this.type = o.type;
            this.typeDefault = o.typeDefault;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * API name: {@code type.default}
         */
        @Nonnull
        public final Builder typeDefault(@Nullable String value) {
            this.typeDefault = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfoSettingsTransport}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSettingsTransport build() {
            _checkSingleUse();

            return new NodeInfoSettingsTransport(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSettingsTransport}
     */
    public static final JsonpDeserializer<NodeInfoSettingsTransport> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoSettingsTransport::setupNodeInfoSettingsTransportDeserializer
    );

    protected static void setupNodeInfoSettingsTransportDeserializer(ObjectDeserializer<NodeInfoSettingsTransport.Builder> op) {
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
        op.add(Builder::typeDefault, JsonpDeserializer.stringDeserializer(), "type.default");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.type.hashCode();
        result = 31 * result + Objects.hashCode(this.typeDefault);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSettingsTransport other = (NodeInfoSettingsTransport) o;
        return this.type.equals(other.type) && Objects.equals(this.typeDefault, other.typeDefault);
    }
}
