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

package org.opensearch.client.opensearch.core.search;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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

// typedef: core.search.HitsMetadata

@Generated("org.opensearch.client.codegen.CodeGenerator")
public class HitsMetadata<TDocument>
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<HitsMetadata.Builder<TDocument>, HitsMetadata<TDocument>> {

    @Nonnull
    private final List<Hit<TDocument>> hits;

    @Nullable
    private final Float maxScore;

    @Nullable
    private final TotalHits total;

    // ---------------------------------------------------------------------------------------------

    private HitsMetadata(Builder<TDocument> builder) {
        this.hits = ApiTypeHelper.unmodifiableRequired(builder.hits, this, "hits");
        this.maxScore = builder.maxScore;
        this.total = builder.total;
    }

    public static <TDocument> HitsMetadata<TDocument> of(
        Function<HitsMetadata.Builder<TDocument>, ObjectBuilder<HitsMetadata<TDocument>>> fn
    ) {
        return fn.apply(new Builder<>()).build();
    }

    /**
     * Required - API name: {@code hits}
     */
    @Nonnull
    public final List<Hit<TDocument>> hits() {
        return this.hits;
    }

    /**
     * API name: {@code max_score}
     */
    @Nullable
    public final Float maxScore() {
        return this.maxScore;
    }

    /**
     * The total number of hits, present only if <code>track_total_hits</code> is not set to <code>false</code> in the search request.
     * <p>
     * API name: {@code total}
     * </p>
     */
    @Nullable
    public final TotalHits total() {
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
        generator.writeKey("hits");
        generator.writeStartArray();
        for (Hit<TDocument> item0 : this.hits) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.maxScore != null) {
            generator.writeKey("max_score");
            generator.write(this.maxScore);
        }

        if (this.total != null) {
            generator.writeKey("total");
            this.total.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder<TDocument> toBuilder() {
        return new Builder<>(this);
    }

    @Nonnull
    public static <TDocument> Builder builder() {
        return new Builder<>();
    }

    /**
     * Builder for {@link HitsMetadata}.
     */
    public static class Builder<TDocument> extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder<TDocument>, HitsMetadata<TDocument>> {
        private List<Hit<TDocument>> hits;
        @Nullable
        private Float maxScore;
        @Nullable
        private TotalHits total;

        public Builder() {}

        private Builder(HitsMetadata<TDocument> o) {
            this.hits = _listCopy(o.hits);
            this.maxScore = o.maxScore;
            this.total = o.total;
        }

        private Builder(Builder<TDocument> o) {
            this.hits = _listCopy(o.hits);
            this.maxScore = o.maxScore;
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder<TDocument> copy() {
            return new Builder<>(this);
        }

        /**
         * Required - API name: {@code hits}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>hits</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> hits(List<Hit<TDocument>> list) {
            this.hits = _listAddAll(this.hits, list);
            return this;
        }

        /**
         * Required - API name: {@code hits}
         *
         * <p>
         * Adds one or more values to <code>hits</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> hits(Hit<TDocument> value, Hit<TDocument>... values) {
            this.hits = _listAdd(this.hits, value, values);
            return this;
        }

        /**
         * Required - API name: {@code hits}
         *
         * <p>
         * Adds a value to <code>hits</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> hits(Function<Hit.Builder<TDocument>, ObjectBuilder<Hit<TDocument>>> fn) {
            return hits(fn.apply(new Hit.Builder<TDocument>()).build());
        }

        /**
         * API name: {@code max_score}
         */
        @Nonnull
        public final Builder<TDocument> maxScore(@Nullable Float value) {
            this.maxScore = value;
            return this;
        }

        /**
         * The total number of hits, present only if <code>track_total_hits</code> is not set to <code>false</code> in the search request.
         * <p>
         * API name: {@code total}
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> total(@Nullable TotalHits value) {
            this.total = value;
            return this;
        }

        /**
         * The total number of hits, present only if <code>track_total_hits</code> is not set to <code>false</code> in the search request.
         * <p>
         * API name: {@code total}
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> total(Function<TotalHits.Builder, ObjectBuilder<TotalHits>> fn) {
            return total(fn.apply(new TotalHits.Builder()).build());
        }

        /**
         * Builds a {@link HitsMetadata}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public HitsMetadata<TDocument> build() {
            _checkSingleUse();

            return new HitsMetadata<>(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Create a JSON deserializer for HitsMetadata.
     */
    public static <TDocument> JsonpDeserializer<HitsMetadata<TDocument>> createHitsMetadataDeserializer(
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        return ObjectBuilderDeserializer.createForObject(
            Builder<TDocument>::new,
            op -> HitsMetadata.setupHitsMetadataDeserializer(op, tDocumentDeserializer)
        );
    }

    protected static <TDocument> void setupHitsMetadataDeserializer(
        ObjectDeserializer<HitsMetadata.Builder<TDocument>> op,
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        op.add(Builder::hits, JsonpDeserializer.arrayDeserializer(Hit.createHitDeserializer(tDocumentDeserializer)), "hits");
        op.add(Builder::maxScore, JsonpDeserializer.floatDeserializer(), "max_score");
        op.add(Builder::total, TotalHits._DESERIALIZER, "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.hits.hashCode();
        result = 31 * result + Objects.hashCode(this.maxScore);
        result = 31 * result + Objects.hashCode(this.total);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HitsMetadata<?> other = (HitsMetadata<?>) o;
        return this.hits.equals(other.hits) && Objects.equals(this.maxScore, other.maxScore) && Objects.equals(this.total, other.total);
    }
}
