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

package org.opensearch.client.opensearch.cluster.stats;

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

// typedef: cluster.stats.NodePackagingType

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodePackagingType implements PlainJsonSerializable, ToCopyableBuilder<NodePackagingType.Builder, NodePackagingType> {

    private final int count;

    @Nullable
    private final String flavor;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private NodePackagingType(Builder builder) {
        this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count");
        this.flavor = builder.flavor;
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static NodePackagingType of(Function<NodePackagingType.Builder, ObjectBuilder<NodePackagingType>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Number of selected nodes using the distribution flavor and file type.
     * <p>
     * API name: {@code count}
     * </p>
     */
    public final int count() {
        return this.count;
    }

    /**
     * Type of OpenSearch distribution. This is always <code>default</code>.
     * <p>
     * API name: {@code flavor}
     * </p>
     */
    @Nullable
    public final String flavor() {
        return this.flavor;
    }

    /**
     * Required - File type (such as <code>tar</code> or <code>zip</code>) used for the distribution package.
     * <p>
     * API name: {@code type}
     * </p>
     */
    @Nonnull
    public final String type() {
        return this.type;
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
        generator.writeKey("count");
        generator.write(this.count);

        if (this.flavor != null) {
            generator.writeKey("flavor");
            generator.write(this.flavor);
        }

        generator.writeKey("type");
        generator.write(this.type);
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
     * Builder for {@link NodePackagingType}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodePackagingType> {
        private Integer count;
        @Nullable
        private String flavor;
        private String type;

        public Builder() {}

        private Builder(NodePackagingType o) {
            this.count = o.count;
            this.flavor = o.flavor;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.count = o.count;
            this.flavor = o.flavor;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Number of selected nodes using the distribution flavor and file type.
         * <p>
         * API name: {@code count}
         * </p>
         */
        @Nonnull
        public final Builder count(int value) {
            this.count = value;
            return this;
        }

        /**
         * Type of OpenSearch distribution. This is always <code>default</code>.
         * <p>
         * API name: {@code flavor}
         * </p>
         */
        @Nonnull
        public final Builder flavor(@Nullable String value) {
            this.flavor = value;
            return this;
        }

        /**
         * Required - File type (such as <code>tar</code> or <code>zip</code>) used for the distribution package.
         * <p>
         * API name: {@code type}
         * </p>
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link NodePackagingType}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodePackagingType build() {
            _checkSingleUse();

            return new NodePackagingType(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodePackagingType}
     */
    public static final JsonpDeserializer<NodePackagingType> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodePackagingType::setupNodePackagingTypeDeserializer
    );

    protected static void setupNodePackagingTypeDeserializer(ObjectDeserializer<NodePackagingType.Builder> op) {
        op.add(Builder::count, JsonpDeserializer.integerDeserializer(), "count");
        op.add(Builder::flavor, JsonpDeserializer.stringDeserializer(), "flavor");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.flavor);
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodePackagingType other = (NodePackagingType) o;
        return this.count == other.count && Objects.equals(this.flavor, other.flavor) && this.type.equals(other.type);
    }
}
