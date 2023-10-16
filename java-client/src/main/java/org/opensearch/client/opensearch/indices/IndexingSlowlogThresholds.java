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

package org.opensearch.client.opensearch.indices;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

@JsonpDeserializable
public class IndexingSlowlogThresholds implements JsonpSerializable {
    @Nullable
    private final SlowlogThresholdLevels index;

    // ---------------------------------------------------------------------------------------------

    private IndexingSlowlogThresholds(Builder builder) {

        this.index = builder.index;

    }

    public static IndexingSlowlogThresholds of(Function<Builder, ObjectBuilder<IndexingSlowlogThresholds>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The indexing slow log, similar in functionality to the search slow log. The
     * log file name ends with <code>_index_indexing_slowlog.json</code>. Log and
     * the thresholds are configured in the same way as the search slowlog.
     * <p>
     * API name: {@code index}
     */
    @Nullable
    public final SlowlogThresholdLevels index() {
        return this.index;
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

        if (this.index != null) {
            generator.writeKey("index");
            this.index.serialize(generator, mapper);

        }

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link IndexingSlowlogThresholds}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<IndexingSlowlogThresholds> {
        @Nullable
        private SlowlogThresholdLevels index;

        /**
         * The indexing slow log, similar in functionality to the search slow log. The
         * log file name ends with <code>_index_indexing_slowlog.json</code>. Log and
         * the thresholds are configured in the same way as the search slowlog.
         * <p>
         * API name: {@code index}
         */
        public final Builder index(@Nullable SlowlogThresholdLevels value) {
            this.index = value;
            return this;
        }

        /**
         * The indexing slow log, similar in functionality to the search slow log. The
         * log file name ends with <code>_index_indexing_slowlog.json</code>. Log and
         * the thresholds are configured in the same way as the search slowlog.
         * <p>
         * API name: {@code index}
         */
        public final Builder index(Function<SlowlogThresholdLevels.Builder, ObjectBuilder<SlowlogThresholdLevels>> fn) {
            return this.index(fn.apply(new SlowlogThresholdLevels.Builder()).build());
        }

        /**
         * Builds a {@link IndexingSlowlogThresholds}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public IndexingSlowlogThresholds build() {
            _checkSingleUse();

            return new IndexingSlowlogThresholds(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexingSlowlogThresholds}
     */
    public static final JsonpDeserializer<IndexingSlowlogThresholds> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexingSlowlogThresholds::setupIndexingSlowlogTresholdsDeserializer
    );

    protected static void setupIndexingSlowlogTresholdsDeserializer(ObjectDeserializer<Builder> op) {

        op.add(Builder::index, SlowlogThresholdLevels._DESERIALIZER, "index");

    }

}
