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

package org.opensearch.client.opensearch.indices;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.IndexSettingsQueries

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsQueries implements PlainJsonSerializable, ToCopyableBuilder<IndexSettingsQueries.Builder, IndexSettingsQueries> {

    @Nullable
    private final IndexSettingsQueriesCache cache;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsQueries(Builder builder) {
        this.cache = builder.cache;
    }

    public static IndexSettingsQueries of(Function<IndexSettingsQueries.Builder, ObjectBuilder<IndexSettingsQueries>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code cache}
     */
    @Nullable
    public final IndexSettingsQueriesCache cache() {
        return this.cache;
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
        if (this.cache != null) {
            generator.writeKey("cache");
            this.cache.serialize(generator, mapper);
        }
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
     * Builder for {@link IndexSettingsQueries}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsQueries> {
        @Nullable
        private IndexSettingsQueriesCache cache;

        public Builder() {}

        private Builder(IndexSettingsQueries o) {
            this.cache = o.cache;
        }

        private Builder(Builder o) {
            this.cache = o.cache;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code cache}
         */
        @Nonnull
        public final Builder cache(@Nullable IndexSettingsQueriesCache value) {
            this.cache = value;
            return this;
        }

        /**
         * API name: {@code cache}
         */
        @Nonnull
        public final Builder cache(Function<IndexSettingsQueriesCache.Builder, ObjectBuilder<IndexSettingsQueriesCache>> fn) {
            return cache(fn.apply(new IndexSettingsQueriesCache.Builder()).build());
        }

        /**
         * Builds a {@link IndexSettingsQueries}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsQueries build() {
            _checkSingleUse();

            return new IndexSettingsQueries(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsQueries}
     */
    public static final JsonpDeserializer<IndexSettingsQueries> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsQueries::setupIndexSettingsQueriesDeserializer
    );

    protected static void setupIndexSettingsQueriesDeserializer(ObjectDeserializer<IndexSettingsQueries.Builder> op) {
        op.add(Builder::cache, IndexSettingsQueriesCache._DESERIALIZER, "cache");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.cache);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsQueries other = (IndexSettingsQueries) o;
        return Objects.equals(this.cache, other.cache);
    }
}
