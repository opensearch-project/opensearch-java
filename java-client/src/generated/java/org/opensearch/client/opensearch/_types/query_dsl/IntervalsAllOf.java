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

package org.opensearch.client.opensearch._types.query_dsl;

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

// typedef: _types.query_dsl.IntervalsAllOf

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IntervalsAllOf
    implements
        IntervalsVariant,
        IntervalsQueryVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<IntervalsAllOf.Builder, IntervalsAllOf> {

    @Nullable
    private final IntervalsFilter filter;

    @Nonnull
    private final List<Intervals> intervals;

    @Nullable
    private final Integer maxGaps;

    @Nullable
    private final Boolean ordered;

    // ---------------------------------------------------------------------------------------------

    private IntervalsAllOf(Builder builder) {
        this.filter = builder.filter;
        this.intervals = ApiTypeHelper.unmodifiableRequired(builder.intervals, this, "intervals");
        this.maxGaps = builder.maxGaps;
        this.ordered = builder.ordered;
    }

    public static IntervalsAllOf of(Function<IntervalsAllOf.Builder, ObjectBuilder<IntervalsAllOf>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Intervals} variant kind.
     */
    @Override
    public Intervals.Kind _intervalsKind() {
        return Intervals.Kind.AllOf;
    }

    /**
     * {@link IntervalsQuery} variant kind.
     */
    @Override
    public IntervalsQuery.Kind _intervalsQueryKind() {
        return IntervalsQuery.Kind.AllOf;
    }

    /**
     * API name: {@code filter}
     */
    @Nullable
    public final IntervalsFilter filter() {
        return this.filter;
    }

    /**
     * Required - An array of rules to combine. All rules must produce a match in a document for the overall source to match.
     * <p>
     * API name: {@code intervals}
     * </p>
     */
    @Nonnull
    public final List<Intervals> intervals() {
        return this.intervals;
    }

    /**
     * Maximum number of positions between the matching terms. Intervals produced by the rules further apart than this are not considered
     * matches.
     * <p>
     * API name: {@code max_gaps}
     * </p>
     */
    @Nullable
    public final Integer maxGaps() {
        return this.maxGaps;
    }

    /**
     * If <code>true</code>, intervals produced by the rules should appear in the order in which they are specified.
     * <p>
     * API name: {@code ordered}
     * </p>
     */
    @Nullable
    public final Boolean ordered() {
        return this.ordered;
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
        if (this.filter != null) {
            generator.writeKey("filter");
            this.filter.serialize(generator, mapper);
        }

        generator.writeKey("intervals");
        generator.writeStartArray();
        for (Intervals item0 : this.intervals) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.maxGaps != null) {
            generator.writeKey("max_gaps");
            generator.write(this.maxGaps);
        }

        if (this.ordered != null) {
            generator.writeKey("ordered");
            generator.write(this.ordered);
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
     * Builder for {@link IntervalsAllOf}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IntervalsAllOf> {
        @Nullable
        private IntervalsFilter filter;
        private List<Intervals> intervals;
        @Nullable
        private Integer maxGaps;
        @Nullable
        private Boolean ordered;

        public Builder() {}

        private Builder(IntervalsAllOf o) {
            this.filter = o.filter;
            this.intervals = _listCopy(o.intervals);
            this.maxGaps = o.maxGaps;
            this.ordered = o.ordered;
        }

        private Builder(Builder o) {
            this.filter = o.filter;
            this.intervals = _listCopy(o.intervals);
            this.maxGaps = o.maxGaps;
            this.ordered = o.ordered;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code filter}
         */
        @Nonnull
        public final Builder filter(@Nullable IntervalsFilter value) {
            this.filter = value;
            return this;
        }

        /**
         * API name: {@code filter}
         */
        @Nonnull
        public final Builder filter(Function<IntervalsFilter.Builder, ObjectBuilder<IntervalsFilter>> fn) {
            return filter(fn.apply(new IntervalsFilter.Builder()).build());
        }

        /**
         * Required - An array of rules to combine. All rules must produce a match in a document for the overall source to match.
         * <p>
         * API name: {@code intervals}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>intervals</code>.
         * </p>
         */
        @Nonnull
        public final Builder intervals(List<Intervals> list) {
            this.intervals = _listAddAll(this.intervals, list);
            return this;
        }

        /**
         * Required - An array of rules to combine. All rules must produce a match in a document for the overall source to match.
         * <p>
         * API name: {@code intervals}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>intervals</code>.
         * </p>
         */
        @Nonnull
        public final Builder intervals(Intervals value, Intervals... values) {
            this.intervals = _listAdd(this.intervals, value, values);
            return this;
        }

        /**
         * Required - An array of rules to combine. All rules must produce a match in a document for the overall source to match.
         * <p>
         * API name: {@code intervals}
         * </p>
         *
         * <p>
         * Adds a value to <code>intervals</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder intervals(Function<Intervals.Builder, ObjectBuilder<Intervals>> fn) {
            return intervals(fn.apply(new Intervals.Builder()).build());
        }

        /**
         * Maximum number of positions between the matching terms. Intervals produced by the rules further apart than this are not
         * considered matches.
         * <p>
         * API name: {@code max_gaps}
         * </p>
         */
        @Nonnull
        public final Builder maxGaps(@Nullable Integer value) {
            this.maxGaps = value;
            return this;
        }

        /**
         * If <code>true</code>, intervals produced by the rules should appear in the order in which they are specified.
         * <p>
         * API name: {@code ordered}
         * </p>
         */
        @Nonnull
        public final Builder ordered(@Nullable Boolean value) {
            this.ordered = value;
            return this;
        }

        /**
         * Builds a {@link IntervalsAllOf}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IntervalsAllOf build() {
            _checkSingleUse();

            return new IntervalsAllOf(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IntervalsAllOf}
     */
    public static final JsonpDeserializer<IntervalsAllOf> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IntervalsAllOf::setupIntervalsAllOfDeserializer
    );

    protected static void setupIntervalsAllOfDeserializer(ObjectDeserializer<IntervalsAllOf.Builder> op) {
        op.add(Builder::filter, IntervalsFilter._DESERIALIZER, "filter");
        op.add(Builder::intervals, JsonpDeserializer.arrayDeserializer(Intervals._DESERIALIZER), "intervals");
        op.add(Builder::maxGaps, JsonpDeserializer.integerDeserializer(), "max_gaps");
        op.add(Builder::ordered, JsonpDeserializer.booleanDeserializer(), "ordered");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.filter);
        result = 31 * result + this.intervals.hashCode();
        result = 31 * result + Objects.hashCode(this.maxGaps);
        result = 31 * result + Objects.hashCode(this.ordered);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IntervalsAllOf other = (IntervalsAllOf) o;
        return Objects.equals(this.filter, other.filter)
            && this.intervals.equals(other.intervals)
            && Objects.equals(this.maxGaps, other.maxGaps)
            && Objects.equals(this.ordered, other.ordered);
    }
}
