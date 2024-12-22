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

package org.opensearch.client.opensearch.indices.stats;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.stats.AllIndicesStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AllIndicesStats implements PlainJsonSerializable, ToCopyableBuilder<AllIndicesStats.Builder, AllIndicesStats> {

    @Nonnull
    private final IndexStats primaries;

    @Nonnull
    private final IndexStats total;

    // ---------------------------------------------------------------------------------------------

    private AllIndicesStats(Builder builder) {
        this.primaries = ApiTypeHelper.requireNonNull(builder.primaries, this, "primaries");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
    }

    public static AllIndicesStats of(Function<AllIndicesStats.Builder, ObjectBuilder<AllIndicesStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code primaries}
     */
    @Nonnull
    public final IndexStats primaries() {
        return this.primaries;
    }

    /**
     * Required - API name: {@code total}
     */
    @Nonnull
    public final IndexStats total() {
        return this.total;
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
        generator.writeKey("primaries");
        this.primaries.serialize(generator, mapper);

        generator.writeKey("total");
        this.total.serialize(generator, mapper);
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
     * Builder for {@link AllIndicesStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AllIndicesStats> {
        private IndexStats primaries;
        private IndexStats total;

        public Builder() {}

        private Builder(AllIndicesStats o) {
            this.primaries = o.primaries;
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.primaries = o.primaries;
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code primaries}
         */
        @Nonnull
        public final Builder primaries(IndexStats value) {
            this.primaries = value;
            return this;
        }

        /**
         * Required - API name: {@code primaries}
         */
        @Nonnull
        public final Builder primaries(Function<IndexStats.Builder, ObjectBuilder<IndexStats>> fn) {
            return primaries(fn.apply(new IndexStats.Builder()).build());
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(IndexStats value) {
            this.total = value;
            return this;
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(Function<IndexStats.Builder, ObjectBuilder<IndexStats>> fn) {
            return total(fn.apply(new IndexStats.Builder()).build());
        }

        /**
         * Builds a {@link AllIndicesStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AllIndicesStats build() {
            _checkSingleUse();

            return new AllIndicesStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AllIndicesStats}
     */
    public static final JsonpDeserializer<AllIndicesStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AllIndicesStats::setupAllIndicesStatsDeserializer
    );

    protected static void setupAllIndicesStatsDeserializer(ObjectDeserializer<AllIndicesStats.Builder> op) {
        op.add(Builder::primaries, IndexStats._DESERIALIZER, "primaries");
        op.add(Builder::total, IndexStats._DESERIALIZER, "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.primaries.hashCode();
        result = 31 * result + this.total.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AllIndicesStats other = (AllIndicesStats) o;
        return this.primaries.equals(other.primaries) && this.total.equals(other.total);
    }
}
