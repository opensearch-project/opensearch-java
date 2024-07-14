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
public class IndexSettingsSearch implements PlainJsonSerializable {
    @Nullable
    private final SearchIdle idle;

    @Nullable
    private final SearchSlowlog slowlog;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsSearch(Builder builder) {

        this.idle = builder.idle;
        this.slowlog = builder.slowlog;

    }

    public static IndexSettingsSearch of(Function<Builder, ObjectBuilder<IndexSettingsSearch>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code idle}
     */
    @Nullable
    public final SearchIdle idle() {
        return this.idle;
    }

    /**
     * API name: {@code slowlog}
     */
    @Nullable
    public final SearchSlowlog slowlog() {
        return this.slowlog;
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

        if (this.idle != null) {
            generator.writeKey("idle");
            this.idle.serialize(generator, mapper);

        }
        if (this.slowlog != null) {
            generator.writeKey("slowlog");
            this.slowlog.serialize(generator, mapper);

        }

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link IndexSettingsSearch}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<IndexSettingsSearch> {
        @Nullable
        private SearchIdle idle;

        @Nullable
        private SearchSlowlog slowlog;

        /**
         * API name: {@code idle}
         */
        public final Builder idle(@Nullable SearchIdle value) {
            this.idle = value;
            return this;
        }

        /**
         * API name: {@code idle}
         */
        public final Builder idle(Function<SearchIdle.Builder, ObjectBuilder<SearchIdle>> fn) {
            return this.idle(fn.apply(new SearchIdle.Builder()).build());
        }

        /**
         * API name: {@code slowlog}
         */
        public final Builder slowlog(@Nullable SearchSlowlog value) {
            this.slowlog = value;
            return this;
        }

        /**
         * API name: {@code slowlog}
         */
        public final Builder slowlog(Function<SearchSlowlog.Builder, ObjectBuilder<SearchSlowlog>> fn) {
            return this.slowlog(fn.apply(new SearchSlowlog.Builder()).build());
        }

        /**
         * Builds a {@link IndexSettingsSearch}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public IndexSettingsSearch build() {
            _checkSingleUse();

            return new IndexSettingsSearch(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsSearch}
     */
    public static final JsonpDeserializer<IndexSettingsSearch> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsSearch::setupSettingsSearchDeserializer
    );

    protected static void setupSettingsSearchDeserializer(ObjectDeserializer<Builder> op) {

        op.add(Builder::idle, SearchIdle._DESERIALIZER, "idle");
        op.add(Builder::slowlog, SearchSlowlog._DESERIALIZER, "slowlog");

    }

}
