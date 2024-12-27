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

// typedef: nodes.info.NodeInfoAction

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoAction implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoAction.Builder, NodeInfoAction> {

    @Nonnull
    private final String destructiveRequiresName;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoAction(Builder builder) {
        this.destructiveRequiresName = ApiTypeHelper.requireNonNull(builder.destructiveRequiresName, this, "destructiveRequiresName");
    }

    public static NodeInfoAction of(Function<NodeInfoAction.Builder, ObjectBuilder<NodeInfoAction>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code destructive_requires_name}
     */
    @Nonnull
    public final String destructiveRequiresName() {
        return this.destructiveRequiresName;
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
        generator.writeKey("destructive_requires_name");
        generator.write(this.destructiveRequiresName);
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
     * Builder for {@link NodeInfoAction}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoAction> {
        private String destructiveRequiresName;

        public Builder() {}

        private Builder(NodeInfoAction o) {
            this.destructiveRequiresName = o.destructiveRequiresName;
        }

        private Builder(Builder o) {
            this.destructiveRequiresName = o.destructiveRequiresName;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code destructive_requires_name}
         */
        @Nonnull
        public final Builder destructiveRequiresName(String value) {
            this.destructiveRequiresName = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfoAction}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoAction build() {
            _checkSingleUse();

            return new NodeInfoAction(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoAction}
     */
    public static final JsonpDeserializer<NodeInfoAction> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoAction::setupNodeInfoActionDeserializer
    );

    protected static void setupNodeInfoActionDeserializer(ObjectDeserializer<NodeInfoAction.Builder> op) {
        op.add(Builder::destructiveRequiresName, JsonpDeserializer.stringDeserializer(), "destructive_requires_name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.destructiveRequiresName.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoAction other = (NodeInfoAction) o;
        return this.destructiveRequiresName.equals(other.destructiveRequiresName);
    }
}
