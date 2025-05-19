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

package org.opensearch.client.opensearch.nodes.usage;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
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

// typedef: nodes.usage.NodeUsage

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeUsage implements PlainJsonSerializable, ToCopyableBuilder<NodeUsage.Builder, NodeUsage> {

    @Nonnull
    private final Map<String, JsonData> aggregations;

    @Nonnull
    private final Map<String, Long> restActions;

    private final long since;

    private final long timestamp;

    // ---------------------------------------------------------------------------------------------

    private NodeUsage(Builder builder) {
        this.aggregations = ApiTypeHelper.unmodifiable(builder.aggregations);
        this.restActions = ApiTypeHelper.unmodifiable(builder.restActions);
        this.since = ApiTypeHelper.requireNonNull(builder.since, this, "since");
        this.timestamp = ApiTypeHelper.requireNonNull(builder.timestamp, this, "timestamp");
    }

    public static NodeUsage of(Function<NodeUsage.Builder, ObjectBuilder<NodeUsage>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code aggregations}
     */
    @Nonnull
    public final Map<String, JsonData> aggregations() {
        return this.aggregations;
    }

    /**
     * API name: {@code rest_actions}
     */
    @Nonnull
    public final Map<String, Long> restActions() {
        return this.restActions;
    }

    /**
     * Required - API name: {@code since}
     */
    public final long since() {
        return this.since;
    }

    /**
     * Required - API name: {@code timestamp}
     */
    public final long timestamp() {
        return this.timestamp;
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
        if (ApiTypeHelper.isDefined(this.aggregations)) {
            generator.writeKey("aggregations");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.aggregations.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.restActions)) {
            generator.writeKey("rest_actions");
            generator.writeStartObject();
            for (Map.Entry<String, Long> item0 : this.restActions.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        generator.writeKey("since");
        generator.write(this.since);

        generator.writeKey("timestamp");
        generator.write(this.timestamp);
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
     * Builder for {@link NodeUsage}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeUsage> {
        @Nullable
        private Map<String, JsonData> aggregations;
        @Nullable
        private Map<String, Long> restActions;
        private Long since;
        private Long timestamp;

        public Builder() {}

        private Builder(NodeUsage o) {
            this.aggregations = _mapCopy(o.aggregations);
            this.restActions = _mapCopy(o.restActions);
            this.since = o.since;
            this.timestamp = o.timestamp;
        }

        private Builder(Builder o) {
            this.aggregations = _mapCopy(o.aggregations);
            this.restActions = _mapCopy(o.restActions);
            this.since = o.since;
            this.timestamp = o.timestamp;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code aggregations}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final Builder aggregations(Map<String, JsonData> map) {
            this.aggregations = _mapPutAll(this.aggregations, map);
            return this;
        }

        /**
         * API name: {@code aggregations}
         *
         * <p>
         * Adds an entry to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final Builder aggregations(String key, JsonData value) {
            this.aggregations = _mapPut(this.aggregations, key, value);
            return this;
        }

        /**
         * API name: {@code rest_actions}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>restActions</code>.
         * </p>
         */
        @Nonnull
        public final Builder restActions(Map<String, Long> map) {
            this.restActions = _mapPutAll(this.restActions, map);
            return this;
        }

        /**
         * API name: {@code rest_actions}
         *
         * <p>
         * Adds an entry to <code>restActions</code>.
         * </p>
         */
        @Nonnull
        public final Builder restActions(String key, Long value) {
            this.restActions = _mapPut(this.restActions, key, value);
            return this;
        }

        /**
         * Required - API name: {@code since}
         */
        @Nonnull
        public final Builder since(long value) {
            this.since = value;
            return this;
        }

        /**
         * Required - API name: {@code timestamp}
         */
        @Nonnull
        public final Builder timestamp(long value) {
            this.timestamp = value;
            return this;
        }

        /**
         * Builds a {@link NodeUsage}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeUsage build() {
            _checkSingleUse();

            return new NodeUsage(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeUsage}
     */
    public static final JsonpDeserializer<NodeUsage> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeUsage::setupNodeUsageDeserializer
    );

    protected static void setupNodeUsageDeserializer(ObjectDeserializer<NodeUsage.Builder> op) {
        op.add(Builder::aggregations, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "aggregations");
        op.add(Builder::restActions, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.longDeserializer()), "rest_actions");
        op.add(Builder::since, JsonpDeserializer.longDeserializer(), "since");
        op.add(Builder::timestamp, JsonpDeserializer.longDeserializer(), "timestamp");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.aggregations);
        result = 31 * result + Objects.hashCode(this.restActions);
        result = 31 * result + Long.hashCode(this.since);
        result = 31 * result + Long.hashCode(this.timestamp);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeUsage other = (NodeUsage) o;
        return Objects.equals(this.aggregations, other.aggregations)
            && Objects.equals(this.restActions, other.restActions)
            && this.since == other.since
            && this.timestamp == other.timestamp;
    }
}
