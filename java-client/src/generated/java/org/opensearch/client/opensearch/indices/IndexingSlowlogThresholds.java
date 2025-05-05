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

// typedef: indices.IndexingSlowlogThresholds

/**
 * The threshold configuration for indexing slow log.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexingSlowlogThresholds
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexingSlowlogThresholds.Builder, IndexingSlowlogThresholds> {

    @Nullable
    private final SlowlogThresholdLevels index;

    // ---------------------------------------------------------------------------------------------

    private IndexingSlowlogThresholds(Builder builder) {
        this.index = builder.index;
    }

    public static IndexingSlowlogThresholds of(Function<IndexingSlowlogThresholds.Builder, ObjectBuilder<IndexingSlowlogThresholds>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final SlowlogThresholdLevels index() {
        return this.index;
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
        if (this.index != null) {
            generator.writeKey("index");
            this.index.serialize(generator, mapper);
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
     * Builder for {@link IndexingSlowlogThresholds}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexingSlowlogThresholds> {
        @Nullable
        private SlowlogThresholdLevels index;

        public Builder() {}

        private Builder(IndexingSlowlogThresholds o) {
            this.index = o.index;
        }

        private Builder(Builder o) {
            this.index = o.index;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable SlowlogThresholdLevels value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(Function<SlowlogThresholdLevels.Builder, ObjectBuilder<SlowlogThresholdLevels>> fn) {
            return index(fn.apply(new SlowlogThresholdLevels.Builder()).build());
        }

        /**
         * Builds a {@link IndexingSlowlogThresholds}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
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
        IndexingSlowlogThresholds::setupIndexingSlowlogThresholdsDeserializer
    );

    protected static void setupIndexingSlowlogThresholdsDeserializer(ObjectDeserializer<IndexingSlowlogThresholds.Builder> op) {
        op.add(Builder::index, SlowlogThresholdLevels._DESERIALIZER, "index");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.index);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexingSlowlogThresholds other = (IndexingSlowlogThresholds) o;
        return Objects.equals(this.index, other.index);
    }
}
