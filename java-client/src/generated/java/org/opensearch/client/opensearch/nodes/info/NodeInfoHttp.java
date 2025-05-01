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

// typedef: nodes.info.NodeInfoHttp

/**
 * Provides HTTP connection information for the node.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoHttp implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoHttp.Builder, NodeInfoHttp> {

    @Nonnull
    private final List<String> boundAddress;

    @Nullable
    private final String maxContentLength;

    private final long maxContentLengthInBytes;

    @Nonnull
    private final String publishAddress;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoHttp(Builder builder) {
        this.boundAddress = ApiTypeHelper.unmodifiableRequired(builder.boundAddress, this, "boundAddress");
        this.maxContentLength = builder.maxContentLength;
        this.maxContentLengthInBytes = ApiTypeHelper.requireNonNull(builder.maxContentLengthInBytes, this, "maxContentLengthInBytes");
        this.publishAddress = ApiTypeHelper.requireNonNull(builder.publishAddress, this, "publishAddress");
    }

    public static NodeInfoHttp of(Function<NodeInfoHttp.Builder, ObjectBuilder<NodeInfoHttp>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The addresses the node is bound to for HTTP traffic.
     * <p>
     * API name: {@code bound_address}
     * </p>
     */
    @Nonnull
    public final List<String> boundAddress() {
        return this.boundAddress;
    }

    /**
     * API name: {@code max_content_length}
     */
    @Nullable
    public final String maxContentLength() {
        return this.maxContentLength;
    }

    /**
     * Required - API name: {@code max_content_length_in_bytes}
     */
    public final long maxContentLengthInBytes() {
        return this.maxContentLengthInBytes;
    }

    /**
     * Required - The HTTP address published to other nodes.
     * <p>
     * API name: {@code publish_address}
     * </p>
     */
    @Nonnull
    public final String publishAddress() {
        return this.publishAddress;
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
        generator.writeKey("bound_address");
        generator.writeStartArray();
        for (String item0 : this.boundAddress) {
            generator.write(item0);
        }
        generator.writeEnd();

        if (this.maxContentLength != null) {
            generator.writeKey("max_content_length");
            generator.write(this.maxContentLength);
        }

        generator.writeKey("max_content_length_in_bytes");
        generator.write(this.maxContentLengthInBytes);

        generator.writeKey("publish_address");
        generator.write(this.publishAddress);
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
     * Builder for {@link NodeInfoHttp}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoHttp> {
        private List<String> boundAddress;
        @Nullable
        private String maxContentLength;
        private Long maxContentLengthInBytes;
        private String publishAddress;

        public Builder() {}

        private Builder(NodeInfoHttp o) {
            this.boundAddress = _listCopy(o.boundAddress);
            this.maxContentLength = o.maxContentLength;
            this.maxContentLengthInBytes = o.maxContentLengthInBytes;
            this.publishAddress = o.publishAddress;
        }

        private Builder(Builder o) {
            this.boundAddress = _listCopy(o.boundAddress);
            this.maxContentLength = o.maxContentLength;
            this.maxContentLengthInBytes = o.maxContentLengthInBytes;
            this.publishAddress = o.publishAddress;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The addresses the node is bound to for HTTP traffic.
         * <p>
         * API name: {@code bound_address}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>boundAddress</code>.
         * </p>
         */
        @Nonnull
        public final Builder boundAddress(List<String> list) {
            this.boundAddress = _listAddAll(this.boundAddress, list);
            return this;
        }

        /**
         * Required - The addresses the node is bound to for HTTP traffic.
         * <p>
         * API name: {@code bound_address}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>boundAddress</code>.
         * </p>
         */
        @Nonnull
        public final Builder boundAddress(String value, String... values) {
            this.boundAddress = _listAdd(this.boundAddress, value, values);
            return this;
        }

        /**
         * API name: {@code max_content_length}
         */
        @Nonnull
        public final Builder maxContentLength(@Nullable String value) {
            this.maxContentLength = value;
            return this;
        }

        /**
         * Required - API name: {@code max_content_length_in_bytes}
         */
        @Nonnull
        public final Builder maxContentLengthInBytes(long value) {
            this.maxContentLengthInBytes = value;
            return this;
        }

        /**
         * Required - The HTTP address published to other nodes.
         * <p>
         * API name: {@code publish_address}
         * </p>
         */
        @Nonnull
        public final Builder publishAddress(String value) {
            this.publishAddress = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfoHttp}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoHttp build() {
            _checkSingleUse();

            return new NodeInfoHttp(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoHttp}
     */
    public static final JsonpDeserializer<NodeInfoHttp> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoHttp::setupNodeInfoHttpDeserializer
    );

    protected static void setupNodeInfoHttpDeserializer(ObjectDeserializer<NodeInfoHttp.Builder> op) {
        op.add(Builder::boundAddress, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "bound_address");
        op.add(Builder::maxContentLength, JsonpDeserializer.stringDeserializer(), "max_content_length");
        op.add(Builder::maxContentLengthInBytes, JsonpDeserializer.longDeserializer(), "max_content_length_in_bytes");
        op.add(Builder::publishAddress, JsonpDeserializer.stringDeserializer(), "publish_address");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.boundAddress.hashCode();
        result = 31 * result + Objects.hashCode(this.maxContentLength);
        result = 31 * result + Long.hashCode(this.maxContentLengthInBytes);
        result = 31 * result + this.publishAddress.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoHttp other = (NodeInfoHttp) o;
        return this.boundAddress.equals(other.boundAddress)
            && Objects.equals(this.maxContentLength, other.maxContentLength)
            && this.maxContentLengthInBytes == other.maxContentLengthInBytes
            && this.publishAddress.equals(other.publishAddress);
    }
}
