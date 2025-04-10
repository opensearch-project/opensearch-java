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
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: cluster.stats.ClusterOperatingSystemPrettyName

@JsonpDeserializable
public class ClusterOperatingSystemPrettyName implements PlainJsonSerializable {
    private final int count;

    @Nullable
    private final String prettyName;

    // ---------------------------------------------------------------------------------------------

    private ClusterOperatingSystemPrettyName(Builder builder) {

        this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count");
        this.prettyName = builder.prettyName;

    }

    public static ClusterOperatingSystemPrettyName of(Function<Builder, ObjectBuilder<ClusterOperatingSystemPrettyName>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code count}
     */
    public final int count() {
        return this.count;
    }

    /**
     * API name: {@code pretty_name}
     */
    @Nullable
    public final String prettyName() {
        return this.prettyName;
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

        generator.writeKey("count");
        generator.write(this.count);

        if (this.prettyName != null) {
            generator.writeKey("pretty_name");
            generator.write(this.prettyName);
        }

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link ClusterOperatingSystemPrettyName}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ClusterOperatingSystemPrettyName> {
        private Integer count;

        @Nullable
        private String prettyName;

        /**
         * Required - API name: {@code count}
         */
        public final Builder count(int value) {
            this.count = value;
            return this;
        }

        /**
         * API name: {@code pretty_name}
         */
        public final Builder prettyName(@Nullable String value) {
            this.prettyName = value;
            return this;
        }

        /**
         * Builds a {@link ClusterOperatingSystemPrettyName}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public ClusterOperatingSystemPrettyName build() {
            _checkSingleUse();

            return new ClusterOperatingSystemPrettyName(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterOperatingSystemPrettyName}
     */
    public static final JsonpDeserializer<ClusterOperatingSystemPrettyName> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterOperatingSystemPrettyName::setupClusterOperatingSystemPrettyNameDeserializer
    );

    protected static void setupClusterOperatingSystemPrettyNameDeserializer(
        ObjectDeserializer<ClusterOperatingSystemPrettyName.Builder> op
    ) {

        op.add(Builder::count, JsonpDeserializer.integerDeserializer(), "count");
        op.add(Builder::prettyName, JsonpDeserializer.stringDeserializer(), "pretty_name");

    }

}
