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

package org.opensearch.client.opensearch._types.aggregations;

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

// typedef: _types.aggregations.CompositeAggregationSource

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CompositeAggregationSource
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CompositeAggregationSource.Builder, CompositeAggregationSource> {

    @Nullable
    private final CompositeDateHistogramAggregationSource dateHistogram;

    @Nullable
    private final CompositeGeoTileGridAggregationSource geotileGrid;

    @Nullable
    private final CompositeHistogramAggregationSource histogram;

    @Nullable
    private final CompositeTermsAggregationSource terms;

    // ---------------------------------------------------------------------------------------------

    private CompositeAggregationSource(Builder builder) {
        this.dateHistogram = builder.dateHistogram;
        this.geotileGrid = builder.geotileGrid;
        this.histogram = builder.histogram;
        this.terms = builder.terms;
    }

    public static CompositeAggregationSource of(
        Function<CompositeAggregationSource.Builder, ObjectBuilder<CompositeAggregationSource>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code date_histogram}
     */
    @Nullable
    public final CompositeDateHistogramAggregationSource dateHistogram() {
        return this.dateHistogram;
    }

    /**
     * API name: {@code geotile_grid}
     */
    @Nullable
    public final CompositeGeoTileGridAggregationSource geotileGrid() {
        return this.geotileGrid;
    }

    /**
     * API name: {@code histogram}
     */
    @Nullable
    public final CompositeHistogramAggregationSource histogram() {
        return this.histogram;
    }

    /**
     * API name: {@code terms}
     */
    @Nullable
    public final CompositeTermsAggregationSource terms() {
        return this.terms;
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
        if (this.dateHistogram != null) {
            generator.writeKey("date_histogram");
            this.dateHistogram.serialize(generator, mapper);
        }

        if (this.geotileGrid != null) {
            generator.writeKey("geotile_grid");
            this.geotileGrid.serialize(generator, mapper);
        }

        if (this.histogram != null) {
            generator.writeKey("histogram");
            this.histogram.serialize(generator, mapper);
        }

        if (this.terms != null) {
            generator.writeKey("terms");
            this.terms.serialize(generator, mapper);
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
     * Builder for {@link CompositeAggregationSource}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CompositeAggregationSource> {
        @Nullable
        private CompositeDateHistogramAggregationSource dateHistogram;
        @Nullable
        private CompositeGeoTileGridAggregationSource geotileGrid;
        @Nullable
        private CompositeHistogramAggregationSource histogram;
        @Nullable
        private CompositeTermsAggregationSource terms;

        public Builder() {}

        private Builder(CompositeAggregationSource o) {
            this.dateHistogram = o.dateHistogram;
            this.geotileGrid = o.geotileGrid;
            this.histogram = o.histogram;
            this.terms = o.terms;
        }

        private Builder(Builder o) {
            this.dateHistogram = o.dateHistogram;
            this.geotileGrid = o.geotileGrid;
            this.histogram = o.histogram;
            this.terms = o.terms;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code date_histogram}
         */
        @Nonnull
        public final Builder dateHistogram(@Nullable CompositeDateHistogramAggregationSource value) {
            this.dateHistogram = value;
            return this;
        }

        /**
         * API name: {@code date_histogram}
         */
        @Nonnull
        public final Builder dateHistogram(
            Function<CompositeDateHistogramAggregationSource.Builder, ObjectBuilder<CompositeDateHistogramAggregationSource>> fn
        ) {
            return dateHistogram(fn.apply(new CompositeDateHistogramAggregationSource.Builder()).build());
        }

        /**
         * API name: {@code geotile_grid}
         */
        @Nonnull
        public final Builder geotileGrid(@Nullable CompositeGeoTileGridAggregationSource value) {
            this.geotileGrid = value;
            return this;
        }

        /**
         * API name: {@code geotile_grid}
         */
        @Nonnull
        public final Builder geotileGrid(
            Function<CompositeGeoTileGridAggregationSource.Builder, ObjectBuilder<CompositeGeoTileGridAggregationSource>> fn
        ) {
            return geotileGrid(fn.apply(new CompositeGeoTileGridAggregationSource.Builder()).build());
        }

        /**
         * API name: {@code histogram}
         */
        @Nonnull
        public final Builder histogram(@Nullable CompositeHistogramAggregationSource value) {
            this.histogram = value;
            return this;
        }

        /**
         * API name: {@code histogram}
         */
        @Nonnull
        public final Builder histogram(
            Function<CompositeHistogramAggregationSource.Builder, ObjectBuilder<CompositeHistogramAggregationSource>> fn
        ) {
            return histogram(fn.apply(new CompositeHistogramAggregationSource.Builder()).build());
        }

        /**
         * API name: {@code terms}
         */
        @Nonnull
        public final Builder terms(@Nullable CompositeTermsAggregationSource value) {
            this.terms = value;
            return this;
        }

        /**
         * API name: {@code terms}
         */
        @Nonnull
        public final Builder terms(Function<CompositeTermsAggregationSource.Builder, ObjectBuilder<CompositeTermsAggregationSource>> fn) {
            return terms(fn.apply(new CompositeTermsAggregationSource.Builder()).build());
        }

        /**
         * Builds a {@link CompositeAggregationSource}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CompositeAggregationSource build() {
            _checkSingleUse();

            return new CompositeAggregationSource(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CompositeAggregationSource}
     */
    public static final JsonpDeserializer<CompositeAggregationSource> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CompositeAggregationSource::setupCompositeAggregationSourceDeserializer
    );

    protected static void setupCompositeAggregationSourceDeserializer(ObjectDeserializer<CompositeAggregationSource.Builder> op) {
        op.add(Builder::dateHistogram, CompositeDateHistogramAggregationSource._DESERIALIZER, "date_histogram");
        op.add(Builder::geotileGrid, CompositeGeoTileGridAggregationSource._DESERIALIZER, "geotile_grid");
        op.add(Builder::histogram, CompositeHistogramAggregationSource._DESERIALIZER, "histogram");
        op.add(Builder::terms, CompositeTermsAggregationSource._DESERIALIZER, "terms");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.dateHistogram);
        result = 31 * result + Objects.hashCode(this.geotileGrid);
        result = 31 * result + Objects.hashCode(this.histogram);
        result = 31 * result + Objects.hashCode(this.terms);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CompositeAggregationSource other = (CompositeAggregationSource) o;
        return Objects.equals(this.dateHistogram, other.dateHistogram)
            && Objects.equals(this.geotileGrid, other.geotileGrid)
            && Objects.equals(this.histogram, other.histogram)
            && Objects.equals(this.terms, other.terms);
    }
}
