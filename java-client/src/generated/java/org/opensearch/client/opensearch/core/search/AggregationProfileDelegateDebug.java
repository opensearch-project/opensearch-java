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

// typedef: core.search.AggregationProfileDelegateDebug

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AggregationProfileDelegateDebug
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<AggregationProfileDelegateDebug.Builder, AggregationProfileDelegateDebug> {

    @Nonnull
    private final List<AggregationProfileDelegateDebugFilter> filters;

    @Nullable
    private final Integer segmentsCollected;

    @Nullable
    private final Integer segmentsCounted;

    @Nullable
    private final Integer segmentsWithDeletedDocs;

    @Nullable
    private final Integer segmentsWithDocCountField;

    // ---------------------------------------------------------------------------------------------

    private AggregationProfileDelegateDebug(Builder builder) {
        this.filters = ApiTypeHelper.unmodifiable(builder.filters);
        this.segmentsCollected = builder.segmentsCollected;
        this.segmentsCounted = builder.segmentsCounted;
        this.segmentsWithDeletedDocs = builder.segmentsWithDeletedDocs;
        this.segmentsWithDocCountField = builder.segmentsWithDocCountField;
    }

    public static AggregationProfileDelegateDebug of(
        Function<AggregationProfileDelegateDebug.Builder, ObjectBuilder<AggregationProfileDelegateDebug>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code filters}
     */
    @Nonnull
    public final List<AggregationProfileDelegateDebugFilter> filters() {
        return this.filters;
    }

    /**
     * API name: {@code segments_collected}
     */
    @Nullable
    public final Integer segmentsCollected() {
        return this.segmentsCollected;
    }

    /**
     * API name: {@code segments_counted}
     */
    @Nullable
    public final Integer segmentsCounted() {
        return this.segmentsCounted;
    }

    /**
     * API name: {@code segments_with_deleted_docs}
     */
    @Nullable
    public final Integer segmentsWithDeletedDocs() {
        return this.segmentsWithDeletedDocs;
    }

    /**
     * API name: {@code segments_with_doc_count_field}
     */
    @Nullable
    public final Integer segmentsWithDocCountField() {
        return this.segmentsWithDocCountField;
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
        if (ApiTypeHelper.isDefined(this.filters)) {
            generator.writeKey("filters");
            generator.writeStartArray();
            for (AggregationProfileDelegateDebugFilter item0 : this.filters) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.segmentsCollected != null) {
            generator.writeKey("segments_collected");
            generator.write(this.segmentsCollected);
        }

        if (this.segmentsCounted != null) {
            generator.writeKey("segments_counted");
            generator.write(this.segmentsCounted);
        }

        if (this.segmentsWithDeletedDocs != null) {
            generator.writeKey("segments_with_deleted_docs");
            generator.write(this.segmentsWithDeletedDocs);
        }

        if (this.segmentsWithDocCountField != null) {
            generator.writeKey("segments_with_doc_count_field");
            generator.write(this.segmentsWithDocCountField);
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
     * Builder for {@link AggregationProfileDelegateDebug}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AggregationProfileDelegateDebug> {
        @Nullable
        private List<AggregationProfileDelegateDebugFilter> filters;
        @Nullable
        private Integer segmentsCollected;
        @Nullable
        private Integer segmentsCounted;
        @Nullable
        private Integer segmentsWithDeletedDocs;
        @Nullable
        private Integer segmentsWithDocCountField;

        public Builder() {}

        private Builder(AggregationProfileDelegateDebug o) {
            this.filters = _listCopy(o.filters);
            this.segmentsCollected = o.segmentsCollected;
            this.segmentsCounted = o.segmentsCounted;
            this.segmentsWithDeletedDocs = o.segmentsWithDeletedDocs;
            this.segmentsWithDocCountField = o.segmentsWithDocCountField;
        }

        private Builder(Builder o) {
            this.filters = _listCopy(o.filters);
            this.segmentsCollected = o.segmentsCollected;
            this.segmentsCounted = o.segmentsCounted;
            this.segmentsWithDeletedDocs = o.segmentsWithDeletedDocs;
            this.segmentsWithDocCountField = o.segmentsWithDocCountField;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code filters}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>filters</code>.
         * </p>
         */
        @Nonnull
        public final Builder filters(List<AggregationProfileDelegateDebugFilter> list) {
            this.filters = _listAddAll(this.filters, list);
            return this;
        }

        /**
         * API name: {@code filters}
         *
         * <p>
         * Adds one or more values to <code>filters</code>.
         * </p>
         */
        @Nonnull
        public final Builder filters(AggregationProfileDelegateDebugFilter value, AggregationProfileDelegateDebugFilter... values) {
            this.filters = _listAdd(this.filters, value, values);
            return this;
        }

        /**
         * API name: {@code filters}
         *
         * <p>
         * Adds a value to <code>filters</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder filters(
            Function<AggregationProfileDelegateDebugFilter.Builder, ObjectBuilder<AggregationProfileDelegateDebugFilter>> fn
        ) {
            return filters(fn.apply(new AggregationProfileDelegateDebugFilter.Builder()).build());
        }

        /**
         * API name: {@code segments_collected}
         */
        @Nonnull
        public final Builder segmentsCollected(@Nullable Integer value) {
            this.segmentsCollected = value;
            return this;
        }

        /**
         * API name: {@code segments_counted}
         */
        @Nonnull
        public final Builder segmentsCounted(@Nullable Integer value) {
            this.segmentsCounted = value;
            return this;
        }

        /**
         * API name: {@code segments_with_deleted_docs}
         */
        @Nonnull
        public final Builder segmentsWithDeletedDocs(@Nullable Integer value) {
            this.segmentsWithDeletedDocs = value;
            return this;
        }

        /**
         * API name: {@code segments_with_doc_count_field}
         */
        @Nonnull
        public final Builder segmentsWithDocCountField(@Nullable Integer value) {
            this.segmentsWithDocCountField = value;
            return this;
        }

        /**
         * Builds a {@link AggregationProfileDelegateDebug}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AggregationProfileDelegateDebug build() {
            _checkSingleUse();

            return new AggregationProfileDelegateDebug(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AggregationProfileDelegateDebug}
     */
    public static final JsonpDeserializer<AggregationProfileDelegateDebug> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AggregationProfileDelegateDebug::setupAggregationProfileDelegateDebugDeserializer
    );

    protected static void setupAggregationProfileDelegateDebugDeserializer(ObjectDeserializer<AggregationProfileDelegateDebug.Builder> op) {
        op.add(Builder::filters, JsonpDeserializer.arrayDeserializer(AggregationProfileDelegateDebugFilter._DESERIALIZER), "filters");
        op.add(Builder::segmentsCollected, JsonpDeserializer.integerDeserializer(), "segments_collected");
        op.add(Builder::segmentsCounted, JsonpDeserializer.integerDeserializer(), "segments_counted");
        op.add(Builder::segmentsWithDeletedDocs, JsonpDeserializer.integerDeserializer(), "segments_with_deleted_docs");
        op.add(Builder::segmentsWithDocCountField, JsonpDeserializer.integerDeserializer(), "segments_with_doc_count_field");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.filters);
        result = 31 * result + Objects.hashCode(this.segmentsCollected);
        result = 31 * result + Objects.hashCode(this.segmentsCounted);
        result = 31 * result + Objects.hashCode(this.segmentsWithDeletedDocs);
        result = 31 * result + Objects.hashCode(this.segmentsWithDocCountField);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AggregationProfileDelegateDebug other = (AggregationProfileDelegateDebug) o;
        return Objects.equals(this.filters, other.filters)
            && Objects.equals(this.segmentsCollected, other.segmentsCollected)
            && Objects.equals(this.segmentsCounted, other.segmentsCounted)
            && Objects.equals(this.segmentsWithDeletedDocs, other.segmentsWithDeletedDocs)
            && Objects.equals(this.segmentsWithDocCountField, other.segmentsWithDocCountField);
    }
}
