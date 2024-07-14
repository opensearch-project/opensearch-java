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

package org.opensearch.client.opensearch.cluster.stats;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: cluster.stats.ClusterProcessCpu

@JsonpDeserializable
public class ClusterProcessCpu implements PlainJsonSerializable {
    private final int percent;

    // ---------------------------------------------------------------------------------------------

    private ClusterProcessCpu(Builder builder) {

        this.percent = ApiTypeHelper.requireNonNull(builder.percent, this, "percent");

    }

    public static ClusterProcessCpu of(Function<Builder, ObjectBuilder<ClusterProcessCpu>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code percent}
     */
    public final int percent() {
        return this.percent;
    }

    /**
     * Serialize this object to JSON.
     */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        generator.writeKey("percent");
        generator.write(this.percent);

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link ClusterProcessCpu}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ClusterProcessCpu> {
        private Integer percent;

        /**
         * Required - API name: {@code percent}
         */
        public final Builder percent(int value) {
            this.percent = value;
            return this;
        }

        /**
         * Builds a {@link ClusterProcessCpu}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public ClusterProcessCpu build() {
            _checkSingleUse();

            return new ClusterProcessCpu(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterProcessCpu}
     */
    public static final JsonpDeserializer<ClusterProcessCpu> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterProcessCpu::setupClusterProcessCpuDeserializer
    );

    protected static void setupClusterProcessCpuDeserializer(ObjectDeserializer<ClusterProcessCpu.Builder> op) {

        op.add(Builder::percent, JsonpDeserializer.integerDeserializer(), "percent");

    }

}
