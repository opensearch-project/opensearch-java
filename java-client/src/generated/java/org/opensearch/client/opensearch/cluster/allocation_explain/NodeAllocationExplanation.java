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

package org.opensearch.client.opensearch.cluster.allocation_explain;

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

// typedef: cluster.allocation_explain.NodeAllocationExplanation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeAllocationExplanation
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NodeAllocationExplanation.Builder, NodeAllocationExplanation> {

    @Nonnull
    private final List<AllocationDecision> deciders;

    @Nonnull
    private final Map<String, String> nodeAttributes;

    @Nonnull
    private final Decision nodeDecision;

    @Nonnull
    private final String nodeId;

    @Nonnull
    private final String nodeName;

    @Nullable
    private final AllocationStore store;

    @Nonnull
    private final String transportAddress;

    @Nullable
    private final Integer weightRanking;

    // ---------------------------------------------------------------------------------------------

    private NodeAllocationExplanation(Builder builder) {
        this.deciders = ApiTypeHelper.unmodifiableRequired(builder.deciders, this, "deciders");
        this.nodeAttributes = ApiTypeHelper.unmodifiableRequired(builder.nodeAttributes, this, "nodeAttributes");
        this.nodeDecision = ApiTypeHelper.requireNonNull(builder.nodeDecision, this, "nodeDecision");
        this.nodeId = ApiTypeHelper.requireNonNull(builder.nodeId, this, "nodeId");
        this.nodeName = ApiTypeHelper.requireNonNull(builder.nodeName, this, "nodeName");
        this.store = builder.store;
        this.transportAddress = ApiTypeHelper.requireNonNull(builder.transportAddress, this, "transportAddress");
        this.weightRanking = builder.weightRanking;
    }

    public static NodeAllocationExplanation of(Function<NodeAllocationExplanation.Builder, ObjectBuilder<NodeAllocationExplanation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code deciders}
     */
    @Nonnull
    public final List<AllocationDecision> deciders() {
        return this.deciders;
    }

    /**
     * Required - API name: {@code node_attributes}
     */
    @Nonnull
    public final Map<String, String> nodeAttributes() {
        return this.nodeAttributes;
    }

    /**
     * Required - API name: {@code node_decision}
     */
    @Nonnull
    public final Decision nodeDecision() {
        return this.nodeDecision;
    }

    /**
     * Required - API name: {@code node_id}
     */
    @Nonnull
    public final String nodeId() {
        return this.nodeId;
    }

    /**
     * Required - API name: {@code node_name}
     */
    @Nonnull
    public final String nodeName() {
        return this.nodeName;
    }

    /**
     * API name: {@code store}
     */
    @Nullable
    public final AllocationStore store() {
        return this.store;
    }

    /**
     * Required - API name: {@code transport_address}
     */
    @Nonnull
    public final String transportAddress() {
        return this.transportAddress;
    }

    /**
     * API name: {@code weight_ranking}
     */
    @Nullable
    public final Integer weightRanking() {
        return this.weightRanking;
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
        generator.writeKey("deciders");
        generator.writeStartArray();
        for (AllocationDecision item0 : this.deciders) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("node_attributes");
        generator.writeStartObject();
        for (Map.Entry<String, String> item0 : this.nodeAttributes.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.write(item0.getValue());
        }
        generator.writeEnd();

        generator.writeKey("node_decision");
        this.nodeDecision.serialize(generator, mapper);

        generator.writeKey("node_id");
        generator.write(this.nodeId);

        generator.writeKey("node_name");
        generator.write(this.nodeName);

        if (this.store != null) {
            generator.writeKey("store");
            this.store.serialize(generator, mapper);
        }

        generator.writeKey("transport_address");
        generator.write(this.transportAddress);

        if (this.weightRanking != null) {
            generator.writeKey("weight_ranking");
            generator.write(this.weightRanking);
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
     * Builder for {@link NodeAllocationExplanation}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeAllocationExplanation> {
        private List<AllocationDecision> deciders;
        private Map<String, String> nodeAttributes;
        private Decision nodeDecision;
        private String nodeId;
        private String nodeName;
        @Nullable
        private AllocationStore store;
        private String transportAddress;
        @Nullable
        private Integer weightRanking;

        public Builder() {}

        private Builder(NodeAllocationExplanation o) {
            this.deciders = _listCopy(o.deciders);
            this.nodeAttributes = _mapCopy(o.nodeAttributes);
            this.nodeDecision = o.nodeDecision;
            this.nodeId = o.nodeId;
            this.nodeName = o.nodeName;
            this.store = o.store;
            this.transportAddress = o.transportAddress;
            this.weightRanking = o.weightRanking;
        }

        private Builder(Builder o) {
            this.deciders = _listCopy(o.deciders);
            this.nodeAttributes = _mapCopy(o.nodeAttributes);
            this.nodeDecision = o.nodeDecision;
            this.nodeId = o.nodeId;
            this.nodeName = o.nodeName;
            this.store = o.store;
            this.transportAddress = o.transportAddress;
            this.weightRanking = o.weightRanking;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code deciders}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>deciders</code>.
         * </p>
         */
        @Nonnull
        public final Builder deciders(List<AllocationDecision> list) {
            this.deciders = _listAddAll(this.deciders, list);
            return this;
        }

        /**
         * Required - API name: {@code deciders}
         *
         * <p>
         * Adds one or more values to <code>deciders</code>.
         * </p>
         */
        @Nonnull
        public final Builder deciders(AllocationDecision value, AllocationDecision... values) {
            this.deciders = _listAdd(this.deciders, value, values);
            return this;
        }

        /**
         * Required - API name: {@code deciders}
         *
         * <p>
         * Adds a value to <code>deciders</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder deciders(Function<AllocationDecision.Builder, ObjectBuilder<AllocationDecision>> fn) {
            return deciders(fn.apply(new AllocationDecision.Builder()).build());
        }

        /**
         * Required - API name: {@code node_attributes}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>nodeAttributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeAttributes(Map<String, String> map) {
            this.nodeAttributes = _mapPutAll(this.nodeAttributes, map);
            return this;
        }

        /**
         * Required - API name: {@code node_attributes}
         *
         * <p>
         * Adds an entry to <code>nodeAttributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeAttributes(String key, String value) {
            this.nodeAttributes = _mapPut(this.nodeAttributes, key, value);
            return this;
        }

        /**
         * Required - API name: {@code node_decision}
         */
        @Nonnull
        public final Builder nodeDecision(Decision value) {
            this.nodeDecision = value;
            return this;
        }

        /**
         * Required - API name: {@code node_id}
         */
        @Nonnull
        public final Builder nodeId(String value) {
            this.nodeId = value;
            return this;
        }

        /**
         * Required - API name: {@code node_name}
         */
        @Nonnull
        public final Builder nodeName(String value) {
            this.nodeName = value;
            return this;
        }

        /**
         * API name: {@code store}
         */
        @Nonnull
        public final Builder store(@Nullable AllocationStore value) {
            this.store = value;
            return this;
        }

        /**
         * API name: {@code store}
         */
        @Nonnull
        public final Builder store(Function<AllocationStore.Builder, ObjectBuilder<AllocationStore>> fn) {
            return store(fn.apply(new AllocationStore.Builder()).build());
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
         * API name: {@code weight_ranking}
         */
        @Nonnull
        public final Builder weightRanking(@Nullable Integer value) {
            this.weightRanking = value;
            return this;
        }

        /**
         * Builds a {@link NodeAllocationExplanation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeAllocationExplanation build() {
            _checkSingleUse();

            return new NodeAllocationExplanation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeAllocationExplanation}
     */
    public static final JsonpDeserializer<NodeAllocationExplanation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeAllocationExplanation::setupNodeAllocationExplanationDeserializer
    );

    protected static void setupNodeAllocationExplanationDeserializer(ObjectDeserializer<NodeAllocationExplanation.Builder> op) {
        op.add(Builder::deciders, JsonpDeserializer.arrayDeserializer(AllocationDecision._DESERIALIZER), "deciders");
        op.add(Builder::nodeAttributes, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "node_attributes");
        op.add(Builder::nodeDecision, Decision._DESERIALIZER, "node_decision");
        op.add(Builder::nodeId, JsonpDeserializer.stringDeserializer(), "node_id");
        op.add(Builder::nodeName, JsonpDeserializer.stringDeserializer(), "node_name");
        op.add(Builder::store, AllocationStore._DESERIALIZER, "store");
        op.add(Builder::transportAddress, JsonpDeserializer.stringDeserializer(), "transport_address");
        op.add(Builder::weightRanking, JsonpDeserializer.integerDeserializer(), "weight_ranking");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.deciders.hashCode();
        result = 31 * result + this.nodeAttributes.hashCode();
        result = 31 * result + this.nodeDecision.hashCode();
        result = 31 * result + this.nodeId.hashCode();
        result = 31 * result + this.nodeName.hashCode();
        result = 31 * result + Objects.hashCode(this.store);
        result = 31 * result + this.transportAddress.hashCode();
        result = 31 * result + Objects.hashCode(this.weightRanking);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeAllocationExplanation other = (NodeAllocationExplanation) o;
        return this.deciders.equals(other.deciders)
            && this.nodeAttributes.equals(other.nodeAttributes)
            && this.nodeDecision.equals(other.nodeDecision)
            && this.nodeId.equals(other.nodeId)
            && this.nodeName.equals(other.nodeName)
            && Objects.equals(this.store, other.store)
            && this.transportAddress.equals(other.transportAddress)
            && Objects.equals(this.weightRanking, other.weightRanking);
    }
}
