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

package org.opensearch.client.opensearch.core;

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
import org.opensearch.client.opensearch._types.ErrorCause;
import org.opensearch.client.opensearch.core.update_by_query_rethrottle.UpdateByQueryRethrottleNode;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: update_by_query_rethrottle.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UpdateByQueryRethrottleResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UpdateByQueryRethrottleResponse.Builder, UpdateByQueryRethrottleResponse> {

    @Nonnull
    private final List<ErrorCause> nodeFailures;

    @Nonnull
    private final Map<String, UpdateByQueryRethrottleNode> nodes;

    // ---------------------------------------------------------------------------------------------

    private UpdateByQueryRethrottleResponse(Builder builder) {
        this.nodeFailures = ApiTypeHelper.unmodifiable(builder.nodeFailures);
        this.nodes = ApiTypeHelper.unmodifiableRequired(builder.nodes, this, "nodes");
    }

    public static UpdateByQueryRethrottleResponse of(
        Function<UpdateByQueryRethrottleResponse.Builder, ObjectBuilder<UpdateByQueryRethrottleResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code node_failures}
     */
    @Nonnull
    public final List<ErrorCause> nodeFailures() {
        return this.nodeFailures;
    }

    /**
     * Required - API name: {@code nodes}
     */
    @Nonnull
    public final Map<String, UpdateByQueryRethrottleNode> nodes() {
        return this.nodes;
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
        if (ApiTypeHelper.isDefined(this.nodeFailures)) {
            generator.writeKey("node_failures");
            generator.writeStartArray();
            for (ErrorCause item0 : this.nodeFailures) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("nodes");
        generator.writeStartObject();
        for (Map.Entry<String, UpdateByQueryRethrottleNode> item0 : this.nodes.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
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
     * Builder for {@link UpdateByQueryRethrottleResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, UpdateByQueryRethrottleResponse> {
        @Nullable
        private List<ErrorCause> nodeFailures;
        private Map<String, UpdateByQueryRethrottleNode> nodes;

        public Builder() {}

        private Builder(UpdateByQueryRethrottleResponse o) {
            this.nodeFailures = _listCopy(o.nodeFailures);
            this.nodes = _mapCopy(o.nodes);
        }

        private Builder(Builder o) {
            this.nodeFailures = _listCopy(o.nodeFailures);
            this.nodes = _mapCopy(o.nodes);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code node_failures}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>nodeFailures</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeFailures(List<ErrorCause> list) {
            this.nodeFailures = _listAddAll(this.nodeFailures, list);
            return this;
        }

        /**
         * API name: {@code node_failures}
         *
         * <p>
         * Adds one or more values to <code>nodeFailures</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeFailures(ErrorCause value, ErrorCause... values) {
            this.nodeFailures = _listAdd(this.nodeFailures, value, values);
            return this;
        }

        /**
         * API name: {@code node_failures}
         *
         * <p>
         * Adds a value to <code>nodeFailures</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder nodeFailures(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return nodeFailures(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * Required - API name: {@code nodes}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(Map<String, UpdateByQueryRethrottleNode> map) {
            this.nodes = _mapPutAll(this.nodes, map);
            return this;
        }

        /**
         * Required - API name: {@code nodes}
         *
         * <p>
         * Adds an entry to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, UpdateByQueryRethrottleNode value) {
            this.nodes = _mapPut(this.nodes, key, value);
            return this;
        }

        /**
         * Required - API name: {@code nodes}
         *
         * <p>
         * Adds a value to <code>nodes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder nodes(
            String key,
            Function<UpdateByQueryRethrottleNode.Builder, ObjectBuilder<UpdateByQueryRethrottleNode>> fn
        ) {
            return nodes(key, fn.apply(new UpdateByQueryRethrottleNode.Builder()).build());
        }

        /**
         * Builds a {@link UpdateByQueryRethrottleResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateByQueryRethrottleResponse build() {
            _checkSingleUse();

            return new UpdateByQueryRethrottleResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpdateByQueryRethrottleResponse}
     */
    public static final JsonpDeserializer<UpdateByQueryRethrottleResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpdateByQueryRethrottleResponse::setupUpdateByQueryRethrottleResponseDeserializer
    );

    protected static void setupUpdateByQueryRethrottleResponseDeserializer(ObjectDeserializer<UpdateByQueryRethrottleResponse.Builder> op) {
        op.add(Builder::nodeFailures, JsonpDeserializer.arrayDeserializer(ErrorCause._DESERIALIZER), "node_failures");
        op.add(Builder::nodes, JsonpDeserializer.stringMapDeserializer(UpdateByQueryRethrottleNode._DESERIALIZER), "nodes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.nodeFailures);
        result = 31 * result + this.nodes.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateByQueryRethrottleResponse other = (UpdateByQueryRethrottleResponse) o;
        return Objects.equals(this.nodeFailures, other.nodeFailures) && this.nodes.equals(other.nodes);
    }
}
