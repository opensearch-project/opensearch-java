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

package org.opensearch.client.opensearch.nodes.stats;

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

// typedef: nodes.stats.NodeIndicesStatusCounter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeIndicesStatusCounter
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NodeIndicesStatusCounter.Builder, NodeIndicesStatusCounter> {

    @Nullable
    private final StatusCounterStats docStatus;

    @Nullable
    private final StatusCounterStats searchResponseStatus;

    // ---------------------------------------------------------------------------------------------

    private NodeIndicesStatusCounter(Builder builder) {
        this.docStatus = builder.docStatus;
        this.searchResponseStatus = builder.searchResponseStatus;
    }

    public static NodeIndicesStatusCounter of(Function<NodeIndicesStatusCounter.Builder, ObjectBuilder<NodeIndicesStatusCounter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code doc_status}
     */
    @Nullable
    public final StatusCounterStats docStatus() {
        return this.docStatus;
    }

    /**
     * API name: {@code search_response_status}
     */
    @Nullable
    public final StatusCounterStats searchResponseStatus() {
        return this.searchResponseStatus;
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
        if (this.docStatus != null) {
            generator.writeKey("doc_status");
            this.docStatus.serialize(generator, mapper);
        }

        if (this.searchResponseStatus != null) {
            generator.writeKey("search_response_status");
            this.searchResponseStatus.serialize(generator, mapper);
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
     * Builder for {@link NodeIndicesStatusCounter}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeIndicesStatusCounter> {
        @Nullable
        private StatusCounterStats docStatus;
        @Nullable
        private StatusCounterStats searchResponseStatus;

        public Builder() {}

        private Builder(NodeIndicesStatusCounter o) {
            this.docStatus = o.docStatus;
            this.searchResponseStatus = o.searchResponseStatus;
        }

        private Builder(Builder o) {
            this.docStatus = o.docStatus;
            this.searchResponseStatus = o.searchResponseStatus;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code doc_status}
         */
        @Nonnull
        public final Builder docStatus(@Nullable StatusCounterStats value) {
            this.docStatus = value;
            return this;
        }

        /**
         * API name: {@code doc_status}
         */
        @Nonnull
        public final Builder docStatus(Function<StatusCounterStats.Builder, ObjectBuilder<StatusCounterStats>> fn) {
            return docStatus(fn.apply(new StatusCounterStats.Builder()).build());
        }

        /**
         * API name: {@code search_response_status}
         */
        @Nonnull
        public final Builder searchResponseStatus(@Nullable StatusCounterStats value) {
            this.searchResponseStatus = value;
            return this;
        }

        /**
         * API name: {@code search_response_status}
         */
        @Nonnull
        public final Builder searchResponseStatus(Function<StatusCounterStats.Builder, ObjectBuilder<StatusCounterStats>> fn) {
            return searchResponseStatus(fn.apply(new StatusCounterStats.Builder()).build());
        }

        /**
         * Builds a {@link NodeIndicesStatusCounter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeIndicesStatusCounter build() {
            _checkSingleUse();

            return new NodeIndicesStatusCounter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeIndicesStatusCounter}
     */
    public static final JsonpDeserializer<NodeIndicesStatusCounter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeIndicesStatusCounter::setupNodeIndicesStatusCounterDeserializer
    );

    protected static void setupNodeIndicesStatusCounterDeserializer(ObjectDeserializer<NodeIndicesStatusCounter.Builder> op) {
        op.add(Builder::docStatus, StatusCounterStats._DESERIALIZER, "doc_status");
        op.add(Builder::searchResponseStatus, StatusCounterStats._DESERIALIZER, "search_response_status");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.docStatus);
        result = 31 * result + Objects.hashCode(this.searchResponseStatus);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeIndicesStatusCounter other = (NodeIndicesStatusCounter) o;
        return Objects.equals(this.docStatus, other.docStatus) && Objects.equals(this.searchResponseStatus, other.searchResponseStatus);
    }
}
