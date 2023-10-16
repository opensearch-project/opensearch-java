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
public class SearchSlowlogThresholds implements JsonpSerializable {
    @Nullable
    private final SlowlogThresholdLevels query;

    @Nullable
    private final SlowlogThresholdLevels fetch;

    // ---------------------------------------------------------------------------------------------

    private SearchSlowlogThresholds(Builder builder) {

        this.query = builder.query;
        this.fetch = builder.fetch;

    }

    public static SearchSlowlogThresholds of(Function<Builder, ObjectBuilder<SearchSlowlogThresholds>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code query}
     */
    @Nullable
    public final SlowlogThresholdLevels query() {
        return this.query;
    }

    /**
     * API name: {@code fetch}
     */
    @Nullable
    public final SlowlogThresholdLevels fetch() {
        return this.fetch;
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

        if (this.query != null) {
            generator.writeKey("query");
            this.query.serialize(generator, mapper);

        }
        if (this.fetch != null) {
            generator.writeKey("fetch");
            this.fetch.serialize(generator, mapper);

        }

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link SearchSlowlogThresholds}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<SearchSlowlogThresholds> {
        @Nullable
        private SlowlogThresholdLevels query;

        @Nullable
        private SlowlogThresholdLevels fetch;

        /**
         * API name: {@code query}
         */
        public final Builder query(@Nullable SlowlogThresholdLevels value) {
            this.query = value;
            return this;
        }

        /**
         * API name: {@code query}
         */
        public final Builder query(Function<SlowlogThresholdLevels.Builder, ObjectBuilder<SlowlogThresholdLevels>> fn) {
            return this.query(fn.apply(new SlowlogThresholdLevels.Builder()).build());
        }

        /**
         * API name: {@code fetch}
         */
        public final Builder fetch(@Nullable SlowlogThresholdLevels value) {
            this.fetch = value;
            return this;
        }

        /**
         * API name: {@code fetch}
         */
        public final Builder fetch(Function<SlowlogThresholdLevels.Builder, ObjectBuilder<SlowlogThresholdLevels>> fn) {
            return this.fetch(fn.apply(new SlowlogThresholdLevels.Builder()).build());
        }

        /**
         * Builds a {@link SearchSlowlogThresholds}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public SearchSlowlogThresholds build() {
            _checkSingleUse();

            return new SearchSlowlogThresholds(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SearchSlowlogThresholds}
     */
    public static final JsonpDeserializer<SearchSlowlogThresholds> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SearchSlowlogThresholds::setupIndexingSlowlogTresholdsDeserializer
    );

    protected static void setupIndexingSlowlogTresholdsDeserializer(ObjectDeserializer<Builder> op) {

        op.add(Builder::query, SlowlogThresholdLevels._DESERIALIZER, "query");
        op.add(Builder::fetch, SlowlogThresholdLevels._DESERIALIZER, "fetch");

    }

}
