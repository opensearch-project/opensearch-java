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
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

@JsonpDeserializable
public class IndexingSlowlog implements PlainJsonSerializable {
    @Nullable
    private final String level;

    @Nullable
    private final Integer source;

    @Nullable
    private final Boolean reformat;

    @Nullable
    private final IndexingSlowlogThresholds threshold;

    // ---------------------------------------------------------------------------------------------

    private IndexingSlowlog(Builder builder) {

        this.level = builder.level;
        this.source = builder.source;
        this.reformat = builder.reformat;
        this.threshold = builder.threshold;

    }

    public static IndexingSlowlog of(Function<Builder, ObjectBuilder<IndexingSlowlog>> fn) {
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
     * API name: {@code source}
     */
    @Nullable
    public final Integer source() {
        return this.source;
    }

    /**
     * API name: {@code reformat}
     */
    @Nullable
    public final Boolean reformat() {
        return this.reformat;
    }

    /**
     * API name: {@code threshold}
     */
    @Nullable
    public final IndexingSlowlogThresholds threshold() {
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
        if (this.source != null) {
            generator.writeKey("source");
            generator.write(this.source);

        }
        if (this.reformat != null) {
            generator.writeKey("reformat");
            generator.write(this.reformat);

        }
        if (this.threshold != null) {
            generator.writeKey("threshold");
            this.threshold.serialize(generator, mapper);

        }

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link IndexingSlowlog}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<IndexingSlowlog> {
        @Nullable
        private String level;

        @Nullable
        private Integer source;

        @Nullable
        private Boolean reformat;

        @Nullable
        private IndexingSlowlogThresholds threshold;

        /**
         * API name: {@code level}
         */
        public final Builder level(@Nullable String value) {
            this.level = value;
            return this;
        }

        /**
         * API name: {@code source}
         */
        public final Builder source(@Nullable Integer value) {
            this.source = value;
            return this;
        }

        /**
         * API name: {@code reformat}
         */
        public final Builder reformat(@Nullable Boolean value) {
            this.reformat = value;
            return this;
        }

        /**
         * API name: {@code threshold}
         */
        public final Builder threshold(@Nullable IndexingSlowlogThresholds value) {
            this.threshold = value;
            return this;
        }

        /**
         * API name: {@code threshold}
         */
        public final Builder threshold(Function<IndexingSlowlogThresholds.Builder, ObjectBuilder<IndexingSlowlogThresholds>> fn) {
            return this.threshold(fn.apply(new IndexingSlowlogThresholds.Builder()).build());
        }

        /**
         * Builds a {@link IndexingSlowlog}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public IndexingSlowlog build() {
            _checkSingleUse();

            return new IndexingSlowlog(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexingSlowlog}
     */
    public static final JsonpDeserializer<IndexingSlowlog> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexingSlowlog::setupIndexingSlowlogSettingsDeserializer
    );

    protected static void setupIndexingSlowlogSettingsDeserializer(ObjectDeserializer<IndexingSlowlog.Builder> op) {

        op.add(Builder::level, JsonpDeserializer.stringDeserializer(), "level");
        op.add(Builder::source, JsonpDeserializer.integerDeserializer(), "source");
        op.add(Builder::reformat, JsonpDeserializer.booleanDeserializer(), "reformat");
        op.add(Builder::threshold, IndexingSlowlogThresholds._DESERIALIZER, "threshold");

    }

}
