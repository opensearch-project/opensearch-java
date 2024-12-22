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

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
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

// typedef: _types.NodeAttributes

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeAttributes implements PlainJsonSerializable, ToCopyableBuilder<NodeAttributes.Builder, NodeAttributes> {

    @Nonnull
    private final Map<String, String> attributes;

    @Nonnull
    private final String ephemeralId;

    @Nullable
    private final String externalId;

    @Nullable
    private final String id;

    @Nonnull
    private final String name;

    @Nonnull
    private final List<NodeRole> roles;

    @Nonnull
    private final String transportAddress;

    // ---------------------------------------------------------------------------------------------

    private NodeAttributes(Builder builder) {
        this.attributes = ApiTypeHelper.unmodifiableRequired(builder.attributes, this, "attributes");
        this.ephemeralId = ApiTypeHelper.requireNonNull(builder.ephemeralId, this, "ephemeralId");
        this.externalId = builder.externalId;
        this.id = builder.id;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.roles = ApiTypeHelper.unmodifiable(builder.roles);
        this.transportAddress = ApiTypeHelper.requireNonNull(builder.transportAddress, this, "transportAddress");
    }

    public static NodeAttributes of(Function<NodeAttributes.Builder, ObjectBuilder<NodeAttributes>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Lists node attributes.
     * <p>
     * API name: {@code attributes}
     * </p>
     */
    @Nonnull
    public final Map<String, String> attributes() {
        return this.attributes;
    }

    /**
     * Required - API name: {@code ephemeral_id}
     */
    @Nonnull
    public final String ephemeralId() {
        return this.ephemeralId;
    }

    /**
     * API name: {@code external_id}
     */
    @Nullable
    public final String externalId() {
        return this.externalId;
    }

    /**
     * API name: {@code id}
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code roles}
     */
    @Nonnull
    public final List<NodeRole> roles() {
        return this.roles;
    }

    /**
     * Required - API name: {@code transport_address}
     */
    @Nonnull
    public final String transportAddress() {
        return this.transportAddress;
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
        generator.writeKey("attributes");
        generator.writeStartObject();
        for (Map.Entry<String, String> item0 : this.attributes.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.write(item0.getValue());
        }
        generator.writeEnd();

        generator.writeKey("ephemeral_id");
        generator.write(this.ephemeralId);

        if (this.externalId != null) {
            generator.writeKey("external_id");
            generator.write(this.externalId);
        }

        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
        }

        generator.writeKey("name");
        generator.write(this.name);

        if (ApiTypeHelper.isDefined(this.roles)) {
            generator.writeKey("roles");
            generator.writeStartArray();
            for (NodeRole item0 : this.roles) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("transport_address");
        generator.write(this.transportAddress);
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
     * Builder for {@link NodeAttributes}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeAttributes> {
        private Map<String, String> attributes;
        private String ephemeralId;
        @Nullable
        private String externalId;
        @Nullable
        private String id;
        private String name;
        @Nullable
        private List<NodeRole> roles;
        private String transportAddress;

        public Builder() {}

        private Builder(NodeAttributes o) {
            this.attributes = _mapCopy(o.attributes);
            this.ephemeralId = o.ephemeralId;
            this.externalId = o.externalId;
            this.id = o.id;
            this.name = o.name;
            this.roles = _listCopy(o.roles);
            this.transportAddress = o.transportAddress;
        }

        private Builder(Builder o) {
            this.attributes = _mapCopy(o.attributes);
            this.ephemeralId = o.ephemeralId;
            this.externalId = o.externalId;
            this.id = o.id;
            this.name = o.name;
            this.roles = _listCopy(o.roles);
            this.transportAddress = o.transportAddress;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Lists node attributes.
         * <p>
         * API name: {@code attributes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>attributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder attributes(Map<String, String> map) {
            this.attributes = _mapPutAll(this.attributes, map);
            return this;
        }

        /**
         * Required - Lists node attributes.
         * <p>
         * API name: {@code attributes}
         * </p>
         *
         * <p>
         * Adds an entry to <code>attributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder attributes(String key, String value) {
            this.attributes = _mapPut(this.attributes, key, value);
            return this;
        }

        /**
         * Required - API name: {@code ephemeral_id}
         */
        @Nonnull
        public final Builder ephemeralId(String value) {
            this.ephemeralId = value;
            return this;
        }

        /**
         * API name: {@code external_id}
         */
        @Nonnull
        public final Builder externalId(@Nullable String value) {
            this.externalId = value;
            return this;
        }

        /**
         * API name: {@code id}
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code roles}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>roles</code>.
         * </p>
         */
        @Nonnull
        public final Builder roles(List<NodeRole> list) {
            this.roles = _listAddAll(this.roles, list);
            return this;
        }

        /**
         * API name: {@code roles}
         *
         * <p>
         * Adds one or more values to <code>roles</code>.
         * </p>
         */
        @Nonnull
        public final Builder roles(NodeRole value, NodeRole... values) {
            this.roles = _listAdd(this.roles, value, values);
            return this;
        }

        /**
         * Required - API name: {@code transport_address}
         */
        @Nonnull
        public final Builder transportAddress(String value) {
            this.transportAddress = value;
            return this;
        }

        /**
         * Builds a {@link NodeAttributes}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeAttributes build() {
            _checkSingleUse();

            return new NodeAttributes(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeAttributes}
     */
    public static final JsonpDeserializer<NodeAttributes> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeAttributes::setupNodeAttributesDeserializer
    );

    protected static void setupNodeAttributesDeserializer(ObjectDeserializer<NodeAttributes.Builder> op) {
        op.add(Builder::attributes, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "attributes");
        op.add(Builder::ephemeralId, JsonpDeserializer.stringDeserializer(), "ephemeral_id");
        op.add(Builder::externalId, JsonpDeserializer.stringDeserializer(), "external_id");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::roles, JsonpDeserializer.arrayDeserializer(NodeRole._DESERIALIZER), "roles");
        op.add(Builder::transportAddress, JsonpDeserializer.stringDeserializer(), "transport_address");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.attributes.hashCode();
        result = 31 * result + this.ephemeralId.hashCode();
        result = 31 * result + Objects.hashCode(this.externalId);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.roles);
        result = 31 * result + this.transportAddress.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeAttributes other = (NodeAttributes) o;
        return this.attributes.equals(other.attributes)
            && this.ephemeralId.equals(other.ephemeralId)
            && Objects.equals(this.externalId, other.externalId)
            && Objects.equals(this.id, other.id)
            && this.name.equals(other.name)
            && Objects.equals(this.roles, other.roles)
            && this.transportAddress.equals(other.transportAddress);
    }
}
