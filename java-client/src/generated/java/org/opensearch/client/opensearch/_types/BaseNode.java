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
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.BaseNode

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class BaseNode implements PlainJsonSerializable {

    private final Map<String, String> attributes;

    @Nullable
    private final String host;

    @Nullable
    private final String ip;

    private final String name;

    private final List<NodeRole> roles;

    @Nullable
    private final String transportAddress;

    // ---------------------------------------------------------------------------------------------

    protected BaseNode(AbstractBuilder<?> builder) {
        this.attributes = ApiTypeHelper.unmodifiable(builder.attributes);
        this.host = builder.host;
        this.ip = builder.ip;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.roles = ApiTypeHelper.unmodifiable(builder.roles);
        this.transportAddress = builder.transportAddress;
    }

    /**
     * API name: {@code attributes}
     */
    public final Map<String, String> attributes() {
        return this.attributes;
    }

    /**
     * API name: {@code host}
     */
    @Nullable
    public final String host() {
        return this.host;
    }

    /**
     * API name: {@code ip}
     */
    @Nullable
    public final String ip() {
        return this.ip;
    }

    /**
     * Required - API name: {@code name}
     */
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code roles}
     */
    public final List<NodeRole> roles() {
        return this.roles;
    }

    /**
     * API name: {@code transport_address}
     */
    @Nullable
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
        if (ApiTypeHelper.isDefined(this.attributes)) {
            generator.writeKey("attributes");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.attributes.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (this.host != null) {
            generator.writeKey("host");
            generator.write(this.host);
        }

        if (this.ip != null) {
            generator.writeKey("ip");
            generator.write(this.ip);
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

        if (this.transportAddress != null) {
            generator.writeKey("transport_address");
            generator.write(this.transportAddress);
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private Map<String, String> attributes;
        @Nullable
        private String host;
        @Nullable
        private String ip;
        private String name;
        @Nullable
        private List<NodeRole> roles;
        @Nullable
        private String transportAddress;

        /**
         * API name: {@code attributes}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>attributes</code>.
         * </p>
         */
        public final BuilderT attributes(Map<String, String> map) {
            this.attributes = _mapPutAll(this.attributes, map);
            return self();
        }

        /**
         * API name: {@code attributes}
         *
         * <p>
         * Adds an entry to <code>attributes</code>.
         * </p>
         */
        public final BuilderT attributes(String key, String value) {
            this.attributes = _mapPut(this.attributes, key, value);
            return self();
        }

        /**
         * API name: {@code host}
         */
        public final BuilderT host(@Nullable String value) {
            this.host = value;
            return self();
        }

        /**
         * API name: {@code ip}
         */
        public final BuilderT ip(@Nullable String value) {
            this.ip = value;
            return self();
        }

        /**
         * Required - API name: {@code name}
         */
        public final BuilderT name(String value) {
            this.name = value;
            return self();
        }

        /**
         * API name: {@code roles}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>roles</code>.
         * </p>
         */
        public final BuilderT roles(List<NodeRole> list) {
            this.roles = _listAddAll(this.roles, list);
            return self();
        }

        /**
         * API name: {@code roles}
         *
         * <p>
         * Adds one or more values to <code>roles</code>.
         * </p>
         */
        public final BuilderT roles(NodeRole value, NodeRole... values) {
            this.roles = _listAdd(this.roles, value, values);
            return self();
        }

        /**
         * API name: {@code transport_address}
         */
        public final BuilderT transportAddress(@Nullable String value) {
            this.transportAddress = value;
            return self();
        }

        protected abstract BuilderT self();
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupBaseNodeDeserializer(ObjectDeserializer<BuilderT> op) {
        op.add(AbstractBuilder::attributes, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "attributes");
        op.add(AbstractBuilder::host, JsonpDeserializer.stringDeserializer(), "host");
        op.add(AbstractBuilder::ip, JsonpDeserializer.stringDeserializer(), "ip");
        op.add(AbstractBuilder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(AbstractBuilder::roles, JsonpDeserializer.arrayDeserializer(NodeRole._DESERIALIZER), "roles");
        op.add(AbstractBuilder::transportAddress, JsonpDeserializer.stringDeserializer(), "transport_address");
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.attributes);
        result = 31 * result + Objects.hashCode(this.host);
        result = 31 * result + Objects.hashCode(this.ip);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.roles);
        result = 31 * result + Objects.hashCode(this.transportAddress);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        BaseNode other = (BaseNode) o;
        return Objects.equals(this.attributes, other.attributes)
            && Objects.equals(this.host, other.host)
            && Objects.equals(this.ip, other.ip)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.roles, other.roles)
            && Objects.equals(this.transportAddress, other.transportAddress);
    }
}
