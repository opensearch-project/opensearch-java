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

// typedef: core.search.AggregationProfileDelegateDebugFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AggregationProfileDelegateDebugFilter
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<AggregationProfileDelegateDebugFilter.Builder, AggregationProfileDelegateDebugFilter> {

    @Nullable
    private final String query;

    @Nullable
    private final Integer resultsFromMetadata;

    @Nullable
    private final Integer segmentsCountedInConstantTime;

    @Nullable
    private final String specializedFor;

    // ---------------------------------------------------------------------------------------------

    private AggregationProfileDelegateDebugFilter(Builder builder) {
        this.query = builder.query;
        this.resultsFromMetadata = builder.resultsFromMetadata;
        this.segmentsCountedInConstantTime = builder.segmentsCountedInConstantTime;
        this.specializedFor = builder.specializedFor;
    }

    public static AggregationProfileDelegateDebugFilter of(
        Function<AggregationProfileDelegateDebugFilter.Builder, ObjectBuilder<AggregationProfileDelegateDebugFilter>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code query}
     */
    @Nullable
    public final String query() {
        return this.query;
    }

    /**
     * API name: {@code results_from_metadata}
     */
    @Nullable
    public final Integer resultsFromMetadata() {
        return this.resultsFromMetadata;
    }

    /**
     * API name: {@code segments_counted_in_constant_time}
     */
    @Nullable
    public final Integer segmentsCountedInConstantTime() {
        return this.segmentsCountedInConstantTime;
    }

    /**
     * API name: {@code specialized_for}
     */
    @Nullable
    public final String specializedFor() {
        return this.specializedFor;
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
        if (this.query != null) {
            generator.writeKey("query");
            generator.write(this.query);
        }

        if (this.resultsFromMetadata != null) {
            generator.writeKey("results_from_metadata");
            generator.write(this.resultsFromMetadata);
        }

        if (this.segmentsCountedInConstantTime != null) {
            generator.writeKey("segments_counted_in_constant_time");
            generator.write(this.segmentsCountedInConstantTime);
        }

        if (this.specializedFor != null) {
            generator.writeKey("specialized_for");
            generator.write(this.specializedFor);
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
     * Builder for {@link AggregationProfileDelegateDebugFilter}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AggregationProfileDelegateDebugFilter> {
        @Nullable
        private String query;
        @Nullable
        private Integer resultsFromMetadata;
        @Nullable
        private Integer segmentsCountedInConstantTime;
        @Nullable
        private String specializedFor;

        public Builder() {}

        private Builder(AggregationProfileDelegateDebugFilter o) {
            this.query = o.query;
            this.resultsFromMetadata = o.resultsFromMetadata;
            this.segmentsCountedInConstantTime = o.segmentsCountedInConstantTime;
            this.specializedFor = o.specializedFor;
        }

        private Builder(Builder o) {
            this.query = o.query;
            this.resultsFromMetadata = o.resultsFromMetadata;
            this.segmentsCountedInConstantTime = o.segmentsCountedInConstantTime;
            this.specializedFor = o.specializedFor;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code query}
         */
        @Nonnull
        public final Builder query(@Nullable String value) {
            this.query = value;
            return this;
        }

        /**
         * API name: {@code results_from_metadata}
         */
        @Nonnull
        public final Builder resultsFromMetadata(@Nullable Integer value) {
            this.resultsFromMetadata = value;
            return this;
        }

        /**
         * API name: {@code segments_counted_in_constant_time}
         */
        @Nonnull
        public final Builder segmentsCountedInConstantTime(@Nullable Integer value) {
            this.segmentsCountedInConstantTime = value;
            return this;
        }

        /**
         * API name: {@code specialized_for}
         */
        @Nonnull
        public final Builder specializedFor(@Nullable String value) {
            this.specializedFor = value;
            return this;
        }

        /**
         * Builds a {@link AggregationProfileDelegateDebugFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AggregationProfileDelegateDebugFilter build() {
            _checkSingleUse();

            return new AggregationProfileDelegateDebugFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AggregationProfileDelegateDebugFilter}
     */
    public static final JsonpDeserializer<AggregationProfileDelegateDebugFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AggregationProfileDelegateDebugFilter::setupAggregationProfileDelegateDebugFilterDeserializer
    );

    protected static void setupAggregationProfileDelegateDebugFilterDeserializer(
        ObjectDeserializer<AggregationProfileDelegateDebugFilter.Builder> op
    ) {
        op.add(Builder::query, JsonpDeserializer.stringDeserializer(), "query");
        op.add(Builder::resultsFromMetadata, JsonpDeserializer.integerDeserializer(), "results_from_metadata");
        op.add(Builder::segmentsCountedInConstantTime, JsonpDeserializer.integerDeserializer(), "segments_counted_in_constant_time");
        op.add(Builder::specializedFor, JsonpDeserializer.stringDeserializer(), "specialized_for");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.query);
        result = 31 * result + Objects.hashCode(this.resultsFromMetadata);
        result = 31 * result + Objects.hashCode(this.segmentsCountedInConstantTime);
        result = 31 * result + Objects.hashCode(this.specializedFor);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AggregationProfileDelegateDebugFilter other = (AggregationProfileDelegateDebugFilter) o;
        return Objects.equals(this.query, other.query)
            && Objects.equals(this.resultsFromMetadata, other.resultsFromMetadata)
            && Objects.equals(this.segmentsCountedInConstantTime, other.segmentsCountedInConstantTime)
            && Objects.equals(this.specializedFor, other.specializedFor);
    }
}
