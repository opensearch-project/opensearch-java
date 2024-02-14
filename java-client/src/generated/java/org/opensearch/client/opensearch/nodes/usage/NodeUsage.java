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

// ----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
// ----------------------------------------------------

package org.opensearch.client.opensearch.nodes.usage;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

@JsonpDeserializable
public class NodeUsage implements JsonpSerializable {

    private final Map<String, Map<String, JsonData>> aggregations;

    private final Map<String, Integer> restActions;

    private final JsonData since;

    private final JsonData timestamp;

    // ---------------------------------------------------------------------------------------------

    private NodeUsage(Builder builder) {
        this.aggregations =
                ApiTypeHelper.unmodifiableRequired(builder.aggregations, this, "aggregations");
        this.restActions =
                ApiTypeHelper.unmodifiableRequired(builder.restActions, this, "restActions");
        this.since = ApiTypeHelper.requireNonNull(builder.since, this, "since");
        this.timestamp = ApiTypeHelper.requireNonNull(builder.timestamp, this, "timestamp");
    }

    public static NodeUsage of(Function<NodeUsage.Builder, ObjectBuilder<NodeUsage>> fn) {
        return fn.apply(new Builder()).build();
    }

    /** API name: {@code aggregations} */
    public final Map<String, Map<String, JsonData>> aggregations() {
        return this.aggregations;
    }

    /** API name: {@code rest_actions} */
    public final Map<String, Integer> restActions() {
        return this.restActions;
    }

    /** API name: {@code since} */
    public final JsonData since() {
        return this.since;
    }

    /** API name: {@code timestamp} */
    public final JsonData timestamp() {
        return this.timestamp;
    }

    /** Serialize this object to JSON. */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeKey("aggregations");
        generator.writeStartObject();
        for (Map.Entry<String, Map<String, JsonData>> item0 : this.aggregations.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item1 : item0.getValue().entrySet()) {
                generator.writeKey(item1.getKey());
                item1.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }
        generator.writeEnd();

        generator.writeKey("rest_actions");
        generator.writeStartObject();
        for (Map.Entry<String, Integer> item0 : this.restActions.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.write(item0.getValue());
        }
        generator.writeEnd();

        generator.writeKey("since");
        this.since.serialize(generator, mapper);

        generator.writeKey("timestamp");
        this.timestamp.serialize(generator, mapper);
    }

    // ---------------------------------------------------------------------------------------------

    /** Builder for {@link NodeUsage}. */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<NodeUsage> {
        @Nullable private Map<String, Map<String, JsonData>> aggregations;
        @Nullable private Map<String, Integer> restActions;
        @Nullable private JsonData since;
        @Nullable private JsonData timestamp;

        /** API name: {@code aggregations} */
        public final Builder aggregations(Map<String, Map<String, JsonData>> map) {
            this.aggregations = _mapPutAll(this.aggregations, map);
            return this;
        }

        /** API name: {@code aggregations} */
        public final Builder aggregations(String key, Map<String, JsonData> value) {
            this.aggregations = _mapPut(this.aggregations, key, value);
            return this;
        }

        /** API name: {@code rest_actions} */
        public final Builder restActions(Map<String, Integer> map) {
            this.restActions = _mapPutAll(this.restActions, map);
            return this;
        }

        /** API name: {@code rest_actions} */
        public final Builder restActions(String key, Integer value) {
            this.restActions = _mapPut(this.restActions, key, value);
            return this;
        }

        /** API name: {@code since} */
        public final Builder since(JsonData value) {
            this.since = value;
            return this;
        }

        /** API name: {@code timestamp} */
        public final Builder timestamp(JsonData value) {
            this.timestamp = value;
            return this;
        }

        /**
         * Builds a {@link NodeUsage}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public NodeUsage build() {
            _checkSingleUse();

            return new NodeUsage(this);
        }
    }
    // ---------------------------------------------------------------------------------------------

    /** Json deserializer for {@link NodeUsage} */
    public static final JsonpDeserializer<NodeUsage> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(Builder::new, NodeUsage::setupNodeUsageDeserializer);

    protected static void setupNodeUsageDeserializer(ObjectDeserializer<NodeUsage.Builder> op) {
        op.add(
                Builder::aggregations,
                JsonpDeserializer.stringMapDeserializer(
                        JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER)),
                "aggregations");
        op.add(
                Builder::restActions,
                JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.integerDeserializer()),
                "rest_actions");
        op.add(Builder::since, JsonData._DESERIALIZER, "since");
        op.add(Builder::timestamp, JsonData._DESERIALIZER, "timestamp");
    }
}
