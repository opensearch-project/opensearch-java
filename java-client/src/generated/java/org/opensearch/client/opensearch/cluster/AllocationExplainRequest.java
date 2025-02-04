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

package org.opensearch.client.opensearch.cluster;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
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
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.allocation_explain.Request

/**
 * Explains how shards are allocated in the current cluster and provides an explanation for why unassigned shards can't be allocated to a
 * node.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class AllocationExplainRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<AllocationExplainRequest.Builder, AllocationExplainRequest> {

    @Nullable
    private final String currentNode;

    @Nullable
    private final Boolean includeDiskInfo;

    @Nullable
    private final Boolean includeYesDecisions;

    @Nullable
    private final String index;

    @Nullable
    private final Boolean primary;

    @Nullable
    private final Integer shard;

    // ---------------------------------------------------------------------------------------------

    private AllocationExplainRequest(Builder builder) {
        super(builder);
        this.currentNode = builder.currentNode;
        this.includeDiskInfo = builder.includeDiskInfo;
        this.includeYesDecisions = builder.includeYesDecisions;
        this.index = builder.index;
        this.primary = builder.primary;
        this.shard = builder.shard;
    }

    public static AllocationExplainRequest of(Function<AllocationExplainRequest.Builder, ObjectBuilder<AllocationExplainRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Specifies the node ID or the name of the node to only explain a shard that is currently located on the specified node.
     * <p>
     * API name: {@code current_node}
     * </p>
     */
    @Nullable
    public final String currentNode() {
        return this.currentNode;
    }

    /**
     * When <code>true</code>, returns information about disk usage and shard sizes.
     * <p>
     * API name: {@code include_disk_info}
     * </p>
     */
    @Nullable
    public final Boolean includeDiskInfo() {
        return this.includeDiskInfo;
    }

    /**
     * When <code>true</code>, returns any <code>YES</code> decisions in the allocation explanation.
     * <p>
     * API name: {@code include_yes_decisions}
     * </p>
     */
    @Nullable
    public final Boolean includeYesDecisions() {
        return this.includeYesDecisions;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * When <code>true</code>, returns a routing explanation for the primary shard based on the node ID.
     * <p>
     * API name: {@code primary}
     * </p>
     */
    @Nullable
    public final Boolean primary() {
        return this.primary;
    }

    /**
     * Specifies the ID of the shard that you would like an explanation for.
     * <p>
     * API name: {@code shard}
     * </p>
     */
    @Nullable
    public final Integer shard() {
        return this.shard;
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
        if (this.currentNode != null) {
            generator.writeKey("current_node");
            generator.write(this.currentNode);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.primary != null) {
            generator.writeKey("primary");
            generator.write(this.primary);
        }

        if (this.shard != null) {
            generator.writeKey("shard");
            generator.write(this.shard);
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
     * Builder for {@link AllocationExplainRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, AllocationExplainRequest> {
        @Nullable
        private String currentNode;
        @Nullable
        private Boolean includeDiskInfo;
        @Nullable
        private Boolean includeYesDecisions;
        @Nullable
        private String index;
        @Nullable
        private Boolean primary;
        @Nullable
        private Integer shard;

        public Builder() {}

        private Builder(AllocationExplainRequest o) {
            super(o);
            this.currentNode = o.currentNode;
            this.includeDiskInfo = o.includeDiskInfo;
            this.includeYesDecisions = o.includeYesDecisions;
            this.index = o.index;
            this.primary = o.primary;
            this.shard = o.shard;
        }

        private Builder(Builder o) {
            super(o);
            this.currentNode = o.currentNode;
            this.includeDiskInfo = o.includeDiskInfo;
            this.includeYesDecisions = o.includeYesDecisions;
            this.index = o.index;
            this.primary = o.primary;
            this.shard = o.shard;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Specifies the node ID or the name of the node to only explain a shard that is currently located on the specified node.
         * <p>
         * API name: {@code current_node}
         * </p>
         */
        @Nonnull
        public final Builder currentNode(@Nullable String value) {
            this.currentNode = value;
            return this;
        }

        /**
         * When <code>true</code>, returns information about disk usage and shard sizes.
         * <p>
         * API name: {@code include_disk_info}
         * </p>
         */
        @Nonnull
        public final Builder includeDiskInfo(@Nullable Boolean value) {
            this.includeDiskInfo = value;
            return this;
        }

        /**
         * When <code>true</code>, returns any <code>YES</code> decisions in the allocation explanation.
         * <p>
         * API name: {@code include_yes_decisions}
         * </p>
         */
        @Nonnull
        public final Builder includeYesDecisions(@Nullable Boolean value) {
            this.includeYesDecisions = value;
            return this;
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * When <code>true</code>, returns a routing explanation for the primary shard based on the node ID.
         * <p>
         * API name: {@code primary}
         * </p>
         */
        @Nonnull
        public final Builder primary(@Nullable Boolean value) {
            this.primary = value;
            return this;
        }

        /**
         * Specifies the ID of the shard that you would like an explanation for.
         * <p>
         * API name: {@code shard}
         * </p>
         */
        @Nonnull
        public final Builder shard(@Nullable Integer value) {
            this.shard = value;
            return this;
        }

        /**
         * Builds a {@link AllocationExplainRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AllocationExplainRequest build() {
            _checkSingleUse();

            return new AllocationExplainRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AllocationExplainRequest}
     */
    public static final JsonpDeserializer<AllocationExplainRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AllocationExplainRequest::setupAllocationExplainRequestDeserializer
    );

    protected static void setupAllocationExplainRequestDeserializer(ObjectDeserializer<AllocationExplainRequest.Builder> op) {
        op.add(Builder::currentNode, JsonpDeserializer.stringDeserializer(), "current_node");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::primary, JsonpDeserializer.booleanDeserializer(), "primary");
        op.add(Builder::shard, JsonpDeserializer.integerDeserializer(), "shard");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.includeDiskInfo != null) {
            params.put("include_disk_info", String.valueOf(this.includeDiskInfo));
        }
        if (this.includeYesDecisions != null) {
            params.put("include_yes_decisions", String.valueOf(this.includeYesDecisions));
        }
    }

    /**
     * Endpoint "{@code cluster.allocation_explain}".
     */
    public static final Endpoint<AllocationExplainRequest, AllocationExplainResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_cluster/allocation/explain",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        AllocationExplainResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.currentNode);
        result = 31 * result + Objects.hashCode(this.includeDiskInfo);
        result = 31 * result + Objects.hashCode(this.includeYesDecisions);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.primary);
        result = 31 * result + Objects.hashCode(this.shard);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AllocationExplainRequest other = (AllocationExplainRequest) o;
        return Objects.equals(this.currentNode, other.currentNode)
            && Objects.equals(this.includeDiskInfo, other.includeDiskInfo)
            && Objects.equals(this.includeYesDecisions, other.includeYesDecisions)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.primary, other.primary)
            && Objects.equals(this.shard, other.shard);
    }
}
