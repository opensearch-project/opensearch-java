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

// typedef: indices.IndexSettingsIndexing

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsIndexing
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsIndexing.Builder, IndexSettingsIndexing> {

    @Nullable
    private final IndexingSlowlog slowlog;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsIndexing(Builder builder) {
        this.slowlog = builder.slowlog;
    }

    public static IndexSettingsIndexing of(Function<IndexSettingsIndexing.Builder, ObjectBuilder<IndexSettingsIndexing>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code slowlog}
     */
    @Nullable
    public final IndexingSlowlog slowlog() {
        return this.slowlog;
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
        if (this.slowlog != null) {
            generator.writeKey("slowlog");
            this.slowlog.serialize(generator, mapper);
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
     * Builder for {@link IndexSettingsIndexing}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsIndexing> {
        @Nullable
        private IndexingSlowlog slowlog;

        public Builder() {}

        private Builder(IndexSettingsIndexing o) {
            this.slowlog = o.slowlog;
        }

        private Builder(Builder o) {
            this.slowlog = o.slowlog;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code slowlog}
         */
        @Nonnull
        public final Builder slowlog(@Nullable IndexingSlowlog value) {
            this.slowlog = value;
            return this;
        }

        /**
         * API name: {@code slowlog}
         */
        @Nonnull
        public final Builder slowlog(Function<IndexingSlowlog.Builder, ObjectBuilder<IndexingSlowlog>> fn) {
            return slowlog(fn.apply(new IndexingSlowlog.Builder()).build());
        }

        /**
         * Builds a {@link IndexSettingsIndexing}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsIndexing build() {
            _checkSingleUse();

            return new IndexSettingsIndexing(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsIndexing}
     */
    public static final JsonpDeserializer<IndexSettingsIndexing> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsIndexing::setupIndexSettingsIndexingDeserializer
    );

    protected static void setupIndexSettingsIndexingDeserializer(ObjectDeserializer<IndexSettingsIndexing.Builder> op) {
        op.add(Builder::slowlog, IndexingSlowlog._DESERIALIZER, "slowlog");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.slowlog);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsIndexing other = (IndexSettingsIndexing) o;
        return Objects.equals(this.slowlog, other.slowlog);
    }
}
