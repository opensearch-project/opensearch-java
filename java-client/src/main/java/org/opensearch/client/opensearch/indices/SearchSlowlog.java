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
import org.opensearch.client.json.*;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

@JsonpDeserializable
public class SearchSlowlog implements JsonpSerializable {
    @Nullable
    private final String level;

    @Nullable
    private final SearchSlowlogThresholds threshold;

    // ---------------------------------------------------------------------------------------------

    private SearchSlowlog(Builder builder) {

        this.level = builder.level;
        this.threshold = builder.threshold;

    }

    public static SearchSlowlog of(Function<Builder, ObjectBuilder<SearchSlowlog>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code level}
     */
    @Nullable
    public final String level() {
        return this.level;
    }

    /**
     * API name: {@code threshold}
     */
    @Nullable
    public final SearchSlowlogThresholds threshold() {
        return this.threshold;
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

        if (this.level != null) {
            generator.writeKey("level");
            generator.write(this.level);

        }

        if (this.threshold != null) {
            generator.writeKey("threshold");
            this.threshold.serialize(generator, mapper);

        }

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link SearchSlowlog}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<SearchSlowlog> {
        @Nullable
        private String level;

        @Nullable
        private SearchSlowlogThresholds threshold;

        /**
         * API name: {@code level}
         */
        public final Builder level(@Nullable String value) {
            this.level = value;
            return this;
        }

        /**
         * API name: {@code threshold}
         */
        public final Builder threshold(@Nullable SearchSlowlogThresholds value) {
            this.threshold = value;
            return this;
        }

        /**
         * API name: {@code threshold}
         */
        public final Builder threshold(Function<SearchSlowlogThresholds.Builder, ObjectBuilder<SearchSlowlogThresholds>> fn) {
            return this.threshold(fn.apply(new SearchSlowlogThresholds.Builder()).build());
        }

        /**
         * Builds a {@link SearchSlowlog}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public SearchSlowlog build() {
            _checkSingleUse();

            return new SearchSlowlog(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SearchSlowlog}
     */
    public static final JsonpDeserializer<SearchSlowlog> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SearchSlowlog::setupIndexingSlowlogSettingsDeserializer
    );

    protected static void setupIndexingSlowlogSettingsDeserializer(ObjectDeserializer<SearchSlowlog.Builder> op) {

        op.add(Builder::level, JsonpDeserializer.stringDeserializer(), "level");
        op.add(Builder::threshold, SearchSlowlogThresholds._DESERIALIZER, "threshold");

    }

}
