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
import java.util.Map;
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

// typedef: cluster.allocation_explain.CurrentNode

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CurrentNode implements PlainJsonSerializable, ToCopyableBuilder<CurrentNode.Builder, CurrentNode> {

    @Nonnull
    private final Map<String, String> attributes;

    @Nonnull
    private final String id;

    @Nonnull
    private final String name;

    @Nonnull
    private final String transportAddress;

    private final int weightRanking;

    // ---------------------------------------------------------------------------------------------

    private CurrentNode(Builder builder) {
        this.attributes = ApiTypeHelper.unmodifiableRequired(builder.attributes, this, "attributes");
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.transportAddress = ApiTypeHelper.requireNonNull(builder.transportAddress, this, "transportAddress");
        this.weightRanking = ApiTypeHelper.requireNonNull(builder.weightRanking, this, "weightRanking");
    }

    public static CurrentNode of(Function<CurrentNode.Builder, ObjectBuilder<CurrentNode>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code attributes}
     */
    @Nonnull
    public final Map<String, String> attributes() {
        return this.attributes;
    }

    /**
     * Required - API name: {@code id}
     */
    @Nonnull
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
     * Required - API name: {@code transport_address}
     */
    @Nonnull
    public final String transportAddress() {
        return this.transportAddress;
    }

    /**
     * Required - API name: {@code weight_ranking}
     */
    public final int weightRanking() {
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
        generator.writeKey("attributes");
        generator.writeStartObject();
        for (Map.Entry<String, String> item0 : this.attributes.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.write(item0.getValue());
        }
        generator.writeEnd();

        generator.writeKey("id");
        generator.write(this.id);

        generator.writeKey("name");
        generator.write(this.name);

        generator.writeKey("transport_address");
        generator.write(this.transportAddress);

        generator.writeKey("weight_ranking");
        generator.write(this.weightRanking);
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
     * Builder for {@link CurrentNode}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CurrentNode> {
        private Map<String, String> attributes;
        private String id;
        private String name;
        private String transportAddress;
        private Integer weightRanking;

        public Builder() {}

        private Builder(CurrentNode o) {
            this.attributes = _mapCopy(o.attributes);
            this.id = o.id;
            this.name = o.name;
            this.transportAddress = o.transportAddress;
            this.weightRanking = o.weightRanking;
        }

        private Builder(Builder o) {
            this.attributes = _mapCopy(o.attributes);
            this.id = o.id;
            this.name = o.name;
            this.transportAddress = o.transportAddress;
            this.weightRanking = o.weightRanking;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code attributes}
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
         * Required - API name: {@code attributes}
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
         * Required - API name: {@code id}
         */
        @Nonnull
        public final Builder id(String value) {
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
         * Required - API name: {@code transport_address}
         */
        @Nonnull
        public final Builder transportAddress(String value) {
            this.transportAddress = value;
            return this;
        }

        /**
         * Required - API name: {@code weight_ranking}
         */
        @Nonnull
        public final Builder weightRanking(int value) {
            this.weightRanking = value;
            return this;
        }

        /**
         * Builds a {@link CurrentNode}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CurrentNode build() {
            _checkSingleUse();

            return new CurrentNode(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CurrentNode}
     */
    public static final JsonpDeserializer<CurrentNode> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CurrentNode::setupCurrentNodeDeserializer
    );

    protected static void setupCurrentNodeDeserializer(ObjectDeserializer<CurrentNode.Builder> op) {
        op.add(Builder::attributes, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "attributes");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::transportAddress, JsonpDeserializer.stringDeserializer(), "transport_address");
        op.add(Builder::weightRanking, JsonpDeserializer.integerDeserializer(), "weight_ranking");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.attributes.hashCode();
        result = 31 * result + this.id.hashCode();
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.transportAddress.hashCode();
        result = 31 * result + Integer.hashCode(this.weightRanking);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CurrentNode other = (CurrentNode) o;
        return this.attributes.equals(other.attributes)
            && this.id.equals(other.id)
            && this.name.equals(other.name)
            && this.transportAddress.equals(other.transportAddress)
            && this.weightRanking == other.weightRanking;
    }
}
