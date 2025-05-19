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

// typedef: nodes.info.NodeInfoAggregation

/**
 * The aggregation configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoAggregation implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoAggregation.Builder, NodeInfoAggregation> {

    @Nonnull
    private final List<String> types;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoAggregation(Builder builder) {
        this.types = ApiTypeHelper.unmodifiableRequired(builder.types, this, "types");
    }

    public static NodeInfoAggregation of(Function<NodeInfoAggregation.Builder, ObjectBuilder<NodeInfoAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The list of supported aggregation types.
     * <p>
     * API name: {@code types}
     * </p>
     */
    @Nonnull
    public final List<String> types() {
        return this.types;
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
        generator.writeKey("types");
        generator.writeStartArray();
        for (String item0 : this.types) {
            generator.write(item0);
        }
        generator.writeEnd();
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
     * Builder for {@link NodeInfoAggregation}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoAggregation> {
        private List<String> types;

        public Builder() {}

        private Builder(NodeInfoAggregation o) {
            this.types = _listCopy(o.types);
        }

        private Builder(Builder o) {
            this.types = _listCopy(o.types);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The list of supported aggregation types.
         * <p>
         * API name: {@code types}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>types</code>.
         * </p>
         */
        @Nonnull
        public final Builder types(List<String> list) {
            this.types = _listAddAll(this.types, list);
            return this;
        }

        /**
         * Required - The list of supported aggregation types.
         * <p>
         * API name: {@code types}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>types</code>.
         * </p>
         */
        @Nonnull
        public final Builder types(String value, String... values) {
            this.types = _listAdd(this.types, value, values);
            return this;
        }

        /**
         * Builds a {@link NodeInfoAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoAggregation build() {
            _checkSingleUse();

            return new NodeInfoAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoAggregation}
     */
    public static final JsonpDeserializer<NodeInfoAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoAggregation::setupNodeInfoAggregationDeserializer
    );

    protected static void setupNodeInfoAggregationDeserializer(ObjectDeserializer<NodeInfoAggregation.Builder> op) {
        op.add(Builder::types, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "types");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.types.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoAggregation other = (NodeInfoAggregation) o;
        return this.types.equals(other.types);
    }
}
