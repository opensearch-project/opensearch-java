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

package org.opensearch.client.opensearch.nodes;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch.nodes._types.NodesResponseBase;
import org.opensearch.client.opensearch.nodes.usage.NodeUsage;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

@JsonpDeserializable
public class UsageResponse extends NodesResponseBase implements JsonpSerializable {

    private final String clusterName;

    private final Map<String, NodeUsage> nodes;

    private UsageResponse(Builder builder) {
        this.clusterName = ApiTypeHelper.requireNonNull(builder.clusterName, this, "clusterName");
        this.nodes = ApiTypeHelper.unmodifiableRequired(builder.nodes, this, "nodes");
    }

    public static UsageResponse of(
            Function<UsageResponse.Builder, ObjectBuilder<UsageResponse>> fn) {
        return fn.apply(new Builder()).build();
    }
    /** API name: {@code cluster_name} */
    public final String clusterName() {
        return this.clusterName;
    }

    /** API name: {@code nodes} */
    public final Map<String, NodeUsage> nodes() {
        return this.nodes;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeKey("cluster_name");
        generator.write(this.clusterName);

        generator.writeKey("nodes");
        generator.writeStartObject();
        for (Map.Entry<String, NodeUsage> item0 : this.nodes.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();
    }
    /** Builder for {@link UsageResponse}. */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<UsageResponse> {
        @Nullable private String clusterName;
        @Nullable private Map<String, NodeUsage> nodes;

        /** API name: {@code cluster_name} */
        public final Builder clusterName(String value) {
            this.clusterName = value;
            return this;
        }

        /** API name: {@code nodes} */
        public final Builder nodes(Map<String, NodeUsage> map) {
            this.nodes = _mapPutAll(this.nodes, map);
            return this;
        }

        /** API name: {@code nodes} */
        public final Builder nodes(String key, NodeUsage value) {
            this.nodes = _mapPut(this.nodes, key, value);
            return this;
        }

        /**
         * Builds a {@link UsageResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public UsageResponse build() {
            _checkSingleUse();

            return new UsageResponse(this);
        }
    }

    public static final JsonpDeserializer<UsageResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, UsageResponse::setupUsageResponseDeserializer);

    protected static void setupUsageResponseDeserializer(
            ObjectDeserializer<UsageResponse.Builder> op) {
        op.add(Builder::clusterName, JsonpDeserializer.stringDeserializer(), "cluster_name");
        op.add(
                Builder::nodes,
                JsonpDeserializer.stringMapDeserializer(NodeUsage._DESERIALIZER),
                "nodes");
    }
}
